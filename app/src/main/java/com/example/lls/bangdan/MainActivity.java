package com.example.lls.bangdan;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.lls.bangdan.database.AnimeDBHelper;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private XRecyclerView recycler_view;//https://github.com/jianghejie/XRecyclerView
    private List<Animeitem.AnimeBean> animebean = new LinkedList<>();
    private Context mContext;
    private BaseAdapter adapter;
    private ACache mACache;
    private JSONObject result;
    private Animeitem animeitem;
    private int page = 1;
    private int animenum = 0;
    private Animeitem.AnimeBean anime = new Animeitem.AnimeBean();
    AnimeDBHelper db = AnimeDBHelper.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        mContext = this;
        mACache =ACache.get(this);



        initData();
        initView();
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
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int position) {
                view.startAnimation(animation);
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        String id = animebean.get(position).getId();//得到当前点击的动漫的bangumi id
                        if(animebean.get(position).getColour() != null){
                            db.updateColour(id, null);
                            animebean.get(position).setColour(null);
                        } else{
                            db.updateColour(id, "green");
                            animebean.get(position).setColour("green");
                        }
                        adapter.notifyDataSetChanged();
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

    private void loadMore() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animebean.addAll(db.getAnimesLimit(page, 30));
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
                animebean.clear();
                initData();
                page = 1;


                recycler_view.refreshComplete();
                adapter.notifyDataSetChanged();
            }
        },500);

    }

    private void initData() {

        animenum = db.getAnimesCount();//可以优化
        if (animenum == 0 ){
            getjson();
            anime.setName("请稍等5秒左右后刷新列表");
            animebean.add(anime);
        }else {
            animebean.addAll(db.getAnimesLimit(0,30));
        }
    }

    public void getjson(){
        RequestQueue mQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                "http://acgshelf.wang/test_api", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());
                        animeitem = JSON.parseObject(response.toString(), Animeitem.class);

                        db.insertAnimes(animeitem.getAnime());
//                            mACache.put("animelist",response);
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

