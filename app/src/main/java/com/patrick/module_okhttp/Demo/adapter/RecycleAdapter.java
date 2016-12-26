package com.patrick.module_okhttp.Demo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.patrick.module_okhttp.Demo.Download;
import com.patrick.module_okhttp.Demo.Get;
import com.patrick.module_okhttp.Demo.MultiDownload;
import com.patrick.module_okhttp.Demo.Post;
import com.patrick.module_okhttp.Demo.view_holder.RecycleViewHolder;
import com.patrick.module_okhttp.Demo.Upload;
import com.patrick.module_okhttp.R;

/**
 * Created by patrick on 2016/12/20.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleViewHolder> {

    private String [] types = {"Get" , "Post" ,"Download" ,"MultiDownload" ,"Upload" };
    private Context context;
    private LayoutInflater layoutInflater;

    public RecycleAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_recycle_view , parent ,false);
        RecycleViewHolder recycleViewHolder = new RecycleViewHolder(view);
        return recycleViewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, final int position) {
        holder.button.setText(types[position]);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = types[position];
                    if("Get".equals(name)){
                        context.startActivity(new Intent(context ,Get.class));
                    }else if("Post".equals(name)){
                        context.startActivity(new Intent(context ,Post.class));
                    }else if("Download".equals(name)){
                        context.startActivity(new Intent(context ,Download.class));
                    }else if("MultiDownload".equals(name)){
                        context.startActivity(new Intent(context ,MultiDownload.class));
                    }else if("Upload".equals(name)){
                        context.startActivity(new Intent(context ,Upload.class));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return types.length;
    }
}
