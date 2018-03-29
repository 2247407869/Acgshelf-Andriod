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

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.WhereCondition;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private XRecyclerView recycler_view;//https://github.com/jianghejie/XRecyclerView
    private List<AnimeSubject.DataBean> animebean = new LinkedList<>();
    private Context mContext;
    private BaseAdapter adapter;
    private AnimeSubject animeitem;
//    private int page = 1;
    private long animenum = 0;
    private int mode = 2;//需要更改
    private int filtrate = 0;
    private AnimeBean anime = new AnimeBean();
    private AnimeBeanDao animeBeanDao;
    private String color;
    private int mposition;
    int loadMore_page = 2;

    public static final String TAG ="=======================";
    public static final String BASE_URL = "http://acgshelf.wang/api/";

//    AnimeDBHelper db = AnimeDBHelper.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = this;
        getdatas(1);
        initView();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,110,2,"按排名排序");
        menu.add(1,111,1,"按评论人数排序");
        menu.add(1,120,3,"隐藏/显示已看和抛弃");
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
            case 120:
                if(filtrate == 1) filtrate = 0;
                else filtrate = 1;
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
//                new Handler().post(new Runnable() {
//                    @Override
//                    public void run() {
//                        mposition = position;
//                        color = animebean.get(position).getColour();
//                        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                        if (color!=null)
//                            intent.putExtra("color", color);
//                        startActivityForResult(intent,0x123);
//
//                    }
//                });
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

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 0x123 && resultCode == 0x123)
//        {
//            color = data.getStringExtra("recolor");
//            animebean.get(mposition).setColour(color);
//            adapter.notifyDataSetChanged();
//        }
//    }

    private void loadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getdatas(loadMore_page);
                loadMore_page++;
                recycler_view.refreshComplete();
//                switch (filtrate){
//                    case 0:
//                        switch (mode){
//                            case 1:
//                                animebean.addAll(animeBeanDao.queryBuilder().orderAsc(AnimeBeanDao.Properties.Rank).offset(30*page).limit(30).list());
//                                break;
//                            case 2:
//                                animebean.addAll(animeBeanDao.queryBuilder().orderDesc(AnimeBeanDao.Properties.Collection_collect).offset(30*page).limit(30).list());
//                                break;
//                        }
//                        break;
//                    case 1:
//                        switch (mode){
//                            case 1:
//                                animebean.addAll(animeBeanDao.queryBuilder().where(
//                                        AnimeBeanDao.Properties.Colour.notIn("2","5")
//                                ).orderAsc(AnimeBeanDao.Properties.Rank).offset(30*page).limit(30).list());
//                                break;
//                            case 2:
//                                animebean.addAll(animeBeanDao.queryBuilder().where(
//                                        AnimeBeanDao.Properties.Colour.notIn("2","5")
//                                ).orderDesc(AnimeBeanDao.Properties.Collection_collect).offset(30*page).limit(30).list());
//                                break;
//                        }
//                        break;
//                }
//                page++;
//                recycler_view.refreshComplete();
//                adapter.notifyDataSetChanged();
            }
        },500);
    }

    private void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animebean.clear();
                getdatas(1);
                loadMore_page = 2;//让加载更多重归第二页
                recycler_view.refreshComplete();
//                animeBeanDao.updateInTx(animebean);
//                initData();
//
//                recycler_view.refreshComplete();
//                adapter.notifyDataSetChanged();
            }
        },500);
    }

    private void initData() {//清空数据，页数清零，加载数据，刷新列表
//        animebean.clear();

    }

    public void getjson(){
        RequestQueue mQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                "http://acgshelf.wang/api/animes", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());
                        animeitem = JSON.parseObject(response.toString(), AnimeSubject.class);
                        animebean.addAll(animeitem.getData());
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

    public void getdatas(int page) {

        //步骤4:创建Retrofit对象

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        AnimeService animeService = retrofit.create(AnimeService.class);
        animeService.getTop30(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AnimeSubject>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage());
                    }

                    @Override
                    public void onNext(AnimeSubject animeSubject) {
                        animebean.addAll(animeSubject.getData());
                        adapter.notifyDataSetChanged();
                    }
                });
    }

//    public void getbgmjson(String id){
//        RequestQueue mQueue = Volley.newRequestQueue(this);
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
//                "http://api.bgm.tv/subject/"+id, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d("TAG", response.toString());
//                        BgmSub bgmsub = JSON.parseObject(response.toString(), BgmSub.class);
////                        animeBeanDao.insertInTx(animeitem.getAnime());
//                        String url = bgmsub.getImages().getCommon();
//
////                        initData();
////                        adapter.notifyDataSetChanged();
////                        Glide.with(mContext).load(url).into(holder.image2);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("TAG", error.getMessage(), error);
//                    }
//                });
//        mQueue.add(jsonObjectRequest);
//    }

}

