package com.patrick.module_okhttp.Demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.patrick.module_okhttp.Demo.beans.FileInfo;
import com.patrick.module_okhttp.Demo.utils.Logger;
import com.patrick.module_okhttp.Demo.view_holder.MultiViewHolder;
import com.patrick.module_okhttp.OkHttp.Download.DownloadInfo;
import com.patrick.module_okhttp.OkHttp.Download.DownloadListener;
import com.patrick.module_okhttp.OkHttp.Download.DownloadMaster;
import com.patrick.module_okhttp.OkHttp.Request.RequestMaster;
import com.patrick.module_okhttp.R;

import java.io.File;
import java.util.List;

import okhttp3.Call;

/**
 * Created by patrick on 2016/12/24.
 */

public class MultiAdapter extends RecyclerView.Adapter<MultiViewHolder> {

    private List<FileInfo> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public MultiAdapter(Context context ,List<FileInfo> list) {
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MultiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_multi_download , parent ,false);
        MultiViewHolder viewHolder = new MultiViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MultiViewHolder holder, int position) {
        final FileInfo fileInfo = list.get(position);
        holder.tv_Name.setText(fileInfo.getName());
        if(fileInfo.getPath() == null){
            fileInfo.setPath(context.getExternalFilesDir("download").getAbsolutePath());
        }
        File file = new File(fileInfo.getPath() ,fileInfo.getName());
        if(file.exists()){
            holder.progressBar.setProgress(100);
        }
        final RequestMaster[] requestMaster = new RequestMaster[1];
        holder.bt_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestMaster[0] = DownloadMaster.with(context)
                        .name(fileInfo.getName())
                        .url(fileInfo.getUrl())
                        .path(fileInfo.getPath())
                        .tag(fileInfo.getName());
                requestMaster[0].download(new DownloadListener() {
                    @Override
                    public void onPending(DownloadInfo downloadInfo) {
                        holder.tv_Name.setText(downloadInfo.getName());
                    }

                    @Override
                    public void onStart(DownloadInfo downloadInfo) {
                        holder.tv_Name.setText(downloadInfo.getName());
                    }

                    @Override
                    public void onPause(DownloadInfo downloadInfo) {

                    }

                    @Override
                    public void onProgress(DownloadInfo downloadInfo) {
                        holder.progressBar.setProgress(downloadInfo.getProgress());
                    }

                    @Override
                    public void onFinished(DownloadInfo downloadInfo) {
                        holder.progressBar.setProgress(downloadInfo.getProgress());
                        Logger.d(downloadInfo.getMessage());
                    }

                    @Override
                    public void onCancel(DownloadInfo downloadInfo) {

                    }

                    @Override
                    public void onError(DownloadInfo downloadInfo) {

                    }
                });
            }
        });
        holder.bt_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestMaster[0].cancel(fileInfo.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
