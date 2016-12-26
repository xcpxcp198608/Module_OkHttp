package com.patrick.module_okhttp.Demo.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.patrick.module_okhttp.R;

/**
 * Created by patrick on 2016/12/23.
 */

public class GetViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_Id;
    public TextView tv_Name;
    public TextView tv_Url;
    public TextView tv_Link;

    public GetViewHolder(View itemView) {
        super(itemView);
        tv_Id = (TextView) itemView.findViewById(R.id.tv_id);
        tv_Name = (TextView) itemView.findViewById(R.id.tv_name);
        tv_Url = (TextView) itemView.findViewById(R.id.tv_url);
        tv_Link = (TextView) itemView.findViewById(R.id.tv_link);
    }
}
