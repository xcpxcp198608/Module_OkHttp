package com.patrick.module_okhttp.Demo.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.patrick.module_okhttp.R;

/**
 * Created by patrick on 2016/12/20.
 */

public class RecycleViewHolder extends RecyclerView.ViewHolder {

    public Button button;
    public RecycleViewHolder(View itemView) {
        super(itemView);
        button = (Button) itemView.findViewById(R.id.bt_Type);
    }
}
