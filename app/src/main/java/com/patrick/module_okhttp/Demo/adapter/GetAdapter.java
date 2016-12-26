package com.patrick.module_okhttp.Demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.patrick.module_okhttp.Demo.beans.ImageInfo;
import com.patrick.module_okhttp.Demo.view_holder.GetViewHolder;
import com.patrick.module_okhttp.R;

import java.util.List;

/**
 * Created by patrick on 2016/12/23.
 */

public class GetAdapter extends RecyclerView.Adapter<GetViewHolder>{

    private List<ImageInfo> list;
    private LayoutInflater layoutInflater;

    public GetAdapter(Context context ,List<ImageInfo> list) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public GetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_get ,parent ,false);
        GetViewHolder getViewHolder = new GetViewHolder(view);
        return getViewHolder;
    }

    @Override
    public void onBindViewHolder(GetViewHolder holder, int position) {
        ImageInfo imageInfo = list.get(position);
        holder.tv_Id.setText(imageInfo.getId()+"");
        holder.tv_Name.setText(imageInfo.getName());
        holder.tv_Url.setText(imageInfo.getUrl());
        holder.tv_Link.setText(imageInfo.getLink());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
