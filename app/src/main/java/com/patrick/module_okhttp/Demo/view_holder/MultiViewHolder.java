package com.patrick.module_okhttp.Demo.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.patrick.module_okhttp.R;

/**
 * Created by patrick on 2016/12/24.
 */

public class MultiViewHolder extends RecyclerView.ViewHolder {

    public ProgressBar progressBar;
    public TextView tv_Name;
    public Button bt_Start ,bt_Stop;

    public MultiViewHolder(View itemView) {
        super(itemView);
        progressBar = (ProgressBar) itemView.findViewById(R.id.pb_item_multi);
        tv_Name = (TextView) itemView.findViewById(R.id.tv_item_multi);
        bt_Start = (Button) itemView.findViewById(R.id.bt_item_multi_start);
        bt_Stop = (Button) itemView.findViewById(R.id.bt_item_multi_stop);
    }
}
