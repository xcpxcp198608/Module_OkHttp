package com.patrick.module_okhttp.Demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.patrick.module_okhttp.Demo.adapter.RecycleAdapter;
import com.patrick.module_okhttp.R;

public class MainActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private RecycleAdapter recycleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recycleAdapter = new RecycleAdapter(this);
        recyclerView.setAdapter(recycleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ,LinearLayoutManager.VERTICAL ,false));
    }
}
