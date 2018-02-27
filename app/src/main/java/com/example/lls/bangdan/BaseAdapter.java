package com.example.lls.bangdan;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by King_ on 2018/2/18.
 */

public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.MyViewHolder> {

    private Context mContext;
    private List<AnimeBean> animebean;

    //自定义点击事件和长按事件
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener)
    {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    //构造器
    public BaseAdapter(Context mContext, List<AnimeBean> animebean) {
        this.mContext = mContext;
        this.animebean = animebean;
    }
    //加载布局
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.item_base, parent, false));
        return holder;
    }
    //为布局加载数据
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_text.setText(animebean.get(position).getName());
        holder.tv_text2.setText(animebean.get(position).getHuashu()+"集");
        holder.tv_text3.setText(animebean.get(position).getScore()+"分");
        holder.tv_text4.setText(animebean.get(position).getPnum()+"评论");
        holder.tv_text5.setText(animebean.get(position).getFaxing());
        holder.tv_text6.setText("rank "+animebean.get(position).getRanking());
        if(animebean.get(position).getColour()!=null) {

            if (animebean.get(position).getColour().equals("red")) {
                holder.tv_text.setBackgroundColor(Color.parseColor("#ff0000"));//red
            }
            if (animebean.get(position).getColour().equals("blue")) {
                holder.tv_text.setBackgroundColor(Color.parseColor("#0000ff"));//blue
            }
            if (animebean.get(position).getColour().equals("green")) {
                holder.tv_text.setBackgroundColor(Color.parseColor("#00ff00"));//green
            }
        }else holder.tv_text.setBackgroundColor(Color.parseColor("#ffffff"));
        setClickListener(holder,position);
    }
    //设置点击事件
    private void setClickListener(final MyViewHolder holder, int position) {
        if(mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition()-1;//默认是第一个开始
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                int pos = holder.getLayoutPosition()-1;//默认是第一个开始
                mOnItemClickListener.onItemLongClick(holder.itemView, pos);
                return true;//返回true可以屏蔽点击监听的响应
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    //总共多少个项
    @Override
    public int getItemCount() {
        return animebean.size();
    }

    //初始化布局信息
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_text;
        TextView tv_text2;
        TextView tv_text3;
        TextView tv_text4;
        TextView tv_text5;
        TextView tv_text6;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_text = (TextView) itemView.findViewById(R.id.tv_text);
            tv_text2 = (TextView) itemView.findViewById(R.id.textView2);
            tv_text3 = (TextView) itemView.findViewById(R.id.textView3);
            tv_text4 = (TextView) itemView.findViewById(R.id.textView4);
            tv_text5 = (TextView) itemView.findViewById(R.id.textView5);
            tv_text6 = (TextView) itemView.findViewById(R.id.textView6);
        }
    }

    //    //添加
//    public void addData(int position) {
//        animebean.add(position, "Insert One");
//        notifyItemInserted(position);
//    }
    //删除
    public void removeData(int position) {
        animebean.remove(position);
        notifyItemRemoved(position);
    }
}
