package com.example.lls.bangdan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
//import com.example.lls.bangdan.database.AnimeDBHelper;
import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private XRecyclerView recycler_view;//https://github.com/jianghejie/XRecyclerView
    private List<AnimeBean> animebean = new LinkedList<>();
    private Context mContext;
    private BaseAdapter adapter;
    private Animeitem animeitem;
    private int page = 0;
    private long animenum = 0;
    private int mode = 2;//需要更改
    private AnimeBean anime = new AnimeBean();
    private AnimeBeanDao animeBeanDao;
    private String color;
    private int mposition;


//    AnimeDBHelper db = AnimeDBHelper.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        animeBeanDao = daoSession.getAnimeBeanDao();

        mContext = this;

        animenum = animeBeanDao.count();//可以优化
        if (animenum == 0 ){
            anime.setName_cn("第一次打开请稍候5秒");
            animebean.add(anime);
            getjson();
        }else{
            initData();
        }
        initView();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,110,2,"按排名排序");
        menu.add(1,111,1,"按评论人数排序");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case 110:
                mode = 1;
                initData();
                adapter.notifyDataSetChanged();
                break;
            case 111:
                mode = 2;
                initData();
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        recycler_view = (XRecyclerView)findViewById(R.id.recycler_view);

        //设置为垂直的样式
        recycler_view.setLayoutManager(new LinearLayoutManager(mContext));
        //使用的是系统默认的分割线
        recycler_view.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        //设置适配器
        recycler_view.setAdapter(adapter=new BaseAdapter(mContext,animebean));
        //设置默认动画
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        //设置刷新样式
        recycler_view.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        //设置下拉加载样式
        recycler_view.setLoadingMoreProgressStyle(ProgressStyle.SquareSpin);
        //点击动画
        final Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.alpha);
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int position) {
                view.startAnimation(animation);
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        mposition = position;
                        color = animebean.get(position).getColour();
                        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                        if (color!=null)
                            intent.putExtra("color", color);
                        startActivityForResult(intent,0x123);

                    }
                });
            }

            @Override
            public void onItemLongClick(View view, int position) {
            }
        });

        recycler_view.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
            @Override
            public void onLoadMore() {
                loadMore();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0x123 && resultCode == 0x123)
        {
            color = data.getStringExtra("recolor");
            animebean.get(mposition).setColour(color);
            animeBeanDao.update(animebean.get(mposition));
            adapter.notifyDataSetChanged();
        }
    }

    private void loadMore() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (mode){
                    case 1:
                        animebean.addAll(animeBeanDao.queryBuilder().orderAsc(AnimeBeanDao.Properties.Rank).offset(30*page).limit(30).list());
                        break;
                    case 2:
                        animebean.addAll(animeBeanDao.queryBuilder().orderDesc(AnimeBeanDao.Properties.Collection_collect).offset(30*page).limit(30).list());
                        break;
                }
                page++;
                recycler_view.refreshComplete();
                adapter.notifyDataSetChanged();
            }
        },500);
    }

    private void refresh() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                initData();

                recycler_view.refreshComplete();
                adapter.notifyDataSetChanged();
            }
        },500);

    }

    private void initData() {//清空数据，页数清零，加载数据，刷新列表
        animebean.clear();
        switch (mode){
            case 1:
                animebean.addAll(animeBeanDao.queryBuilder().orderAsc(AnimeBeanDao.Properties.Rank).limit(30).list());
                break;
            case 2:
                animebean.addAll(animeBeanDao.queryBuilder().orderDesc(AnimeBeanDao.Properties.Collection_collect).limit(30).list());
                break;
        }
        page=1;

    }

    public void getjson(){
        RequestQueue mQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                "http://acgshelf.wang/test_api", null,
//                "http://10.0.2.2/1/test_api", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());
                        animeitem = JSON.parseObject(response.toString(), Animeitem.class);
                        animeBeanDao.insertInTx(animeitem.getAnime());
                        initData();
                        adapter.notifyDataSetChanged();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                    }
                });
        mQueue.add(jsonObjectRequest);
    }

    public void getbgmjson(String id){
        RequestQueue mQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                "http://api.bgm.tv/subject/"+id, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());
                        BgmSub bgmsub = JSON.parseObject(response.toString(), BgmSub.class);
//                        animeBeanDao.insertInTx(animeitem.getAnime());
                        String url = bgmsub.getImages().getCommon();

//                        initData();
//                        adapter.notifyDataSetChanged();
//                        Glide.with(mContext).load(url).into(holder.image2);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                    }
                });
        mQueue.add(jsonObjectRequest);
    }


}

