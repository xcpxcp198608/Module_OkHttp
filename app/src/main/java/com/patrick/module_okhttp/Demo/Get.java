package com.patrick.module_okhttp.Demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.patrick.module_okhttp.Demo.adapter.GetAdapter;
import com.patrick.module_okhttp.OkHttp.OkMaster;
import com.patrick.module_okhttp.OkHttp.Listener.StringListener;
import com.patrick.module_okhttp.R;
import com.patrick.module_okhttp.Demo.beans.ImageInfo;
import com.patrick.module_okhttp.Demo.utils.Logger;
import com.patrick.module_okhttp.databinding.ActivityGetBinding;
import java.io.IOException;
import java.util.List;

/**
 * Created by patrick on 2016/12/20.
 */

public class Get extends BaseActivity {
    private RecyclerView rv_Get;
    private GetAdapter adapter;
    private String url = "http://158.69.229.104:8080/Launcher_EN/GetImage";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGetBinding binding = DataBindingUtil.setContentView(this , R.layout.activity_get);
        binding.setEventListener(new EventListener());
        rv_Get = (RecyclerView) findViewById(R.id.rv_get);
    }

    public class EventListener {
        public void onClick (View v){
            OkMaster.get(url)
                .enqueue(new StringListener() {
                    @Override
                    public void onSuccess(String  s) throws IOException {
                        List<ImageInfo> list = new Gson().fromJson(s ,new TypeToken<List<ImageInfo>>(){}.getType());
                        adapter = new GetAdapter(Get.this ,list);
                        rv_Get.setAdapter(adapter);
                        rv_Get.setLayoutManager(new LinearLayoutManager(Get.this ,LinearLayoutManager.VERTICAL ,false));
                        rv_Get.addItemDecoration(new LinearOffsetsItemDecoration(LinearOffsetsItemDecoration.LINEAR_OFFSETS_VERTICAL));
                    }

                    @Override
                    public void onFailure(String e) {

                    }
                });
        }
    }
}
