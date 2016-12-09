package com.vivien.recyclerviewtogallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vivien on 16/12/7.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private List<Integer> mDatas;
    private OnItemClickLister onItemClickLister;

    public GalleryAdapter(Context context, List<Integer> datas) {
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View arg0) {
            super(arg0);
        }

        ImageView mImg;
        TextView mTxt;
    }

    public void setOnItemClickLister(OnItemClickLister lister) {
        onItemClickLister = lister;
    }

    public interface OnItemClickLister {
        void onItemClick(View view, int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mImg = (ImageView) view.findViewById(R.id.item_iv);
        viewHolder.mTxt = (TextView) view.findViewById(R.id.item_tv);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mImg.setImageResource(mDatas.get(position));
        holder.mTxt.setText("item" + position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickLister != null) {
                    onItemClickLister.onItemClick(holder.itemView, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
