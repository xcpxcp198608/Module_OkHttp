package com.patrick.module_okhttp.Demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.patrick.module_okhttp.Demo.adapter.MultiAdapter;
import com.patrick.module_okhttp.Demo.beans.FileInfo;
import com.patrick.module_okhttp.R;
import com.patrick.module_okhttp.databinding.ActivityMultiDownloadBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrick on 2016/12/20.
 */

public class MultiDownload extends BaseActivity {
    private ActivityMultiDownloadBinding binding;
    private MultiAdapter adapter;
    private List<FileInfo> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_download);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_multi_download);

        String url1 = "http://158.69.229.104:8091/l_EN/image/user_guide_icon_4.png";
        FileInfo f1 = new FileInfo();
        f1.setUrl(url1);
        f1.setName("user_guide_icon_4.png");
        list.add(f1);
        String url2 = "http://158.69.229.104:8091/l_EN/image/setting_icon_2.png";
        FileInfo f2 = new FileInfo();
        f2.setUrl(url2);
        f2.setName("setting_icon_2.png");
        list.add(f2);
        String url3 = "http://158.69.229.104:8091/l_EN/image/apps_icon_3.png";
        FileInfo f3 = new FileInfo();
        f3.setUrl(url3);
        f3.setName("apps_icon_3.png");
        list.add(f3);
        String url4 = "http://158.69.229.104:8091/l_EN/image/market_icon_2.png";
        FileInfo f4 = new FileInfo();
        f4.setUrl(url4);
        f4.setName("market_icon_2.png");
        list.add(f4);
        String url5 = "http://158.69.229.104:8091/l_EN/image/ld_opportunity_1.png";
        FileInfo f5 = new FileInfo();
        f5.setUrl(url5);
        f5.setName("ld_opportunity_1.png");
        list.add(f5);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter = new MultiAdapter(getApplicationContext() , list);
        binding.rvMultiDownload.setAdapter(adapter);
        binding.rvMultiDownload.setLayoutManager(new LinearLayoutManager(MultiDownload.this , LinearLayoutManager.VERTICAL ,false));
    }
}
