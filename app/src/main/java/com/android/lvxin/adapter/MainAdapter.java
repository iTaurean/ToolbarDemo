package com.android.lvxin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.lvxin.R;

import java.util.List;

/**
 * @ClassName: MainAdapter
 * @Description: TODO
 * @Author: lvxin
 * @Date: 12/29/15 14:03
 */
public class MainAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<String> mData;
    private LayoutInflater mInflater;
    private OnItemClickListener mListener;

    public MainAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_main_item, parent, false);
        return new ItemViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String content = mData.get(position);
        ((ItemViewHolder) holder).contentTv.setText(content);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView contentTv;

        public ItemViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            contentTv = (TextView) itemView.findViewById(R.id.item_content_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != listener) {
                        listener.onClick(v, getLayoutPosition());
                    }
                }
            });
        }
    }
}
