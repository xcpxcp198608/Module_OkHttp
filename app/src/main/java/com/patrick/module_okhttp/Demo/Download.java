package com.patrick.module_okhttp.Demo;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bumptech.glide.Glide;
import com.patrick.module_okhttp.Demo.utils.Logger;
import com.patrick.module_okhttp.OkHttp.Download.DownloadInfo;
import com.patrick.module_okhttp.OkHttp.Download.DownloadListener;
import com.patrick.module_okhttp.OkHttp.Download.DownloadMaster;
import com.patrick.module_okhttp.OkHttp.Download.DownloadRequest;
import com.patrick.module_okhttp.OkHttp.Request.RequestMaster;
import com.patrick.module_okhttp.R;
import com.patrick.module_okhttp.databinding.ActivityDownloadBinding;

/**
 * Created by patrick on 2016/12/20.
 */

public class Download  extends BaseActivity{

    private String url="http://158.69.229.104:8091/l_EN/image/btv_icon_2.png";
    private ActivityDownloadBinding binding;
    RequestMaster requestMaster;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this ,R.layout.activity_download);
        binding.setEvent(new EventListener());
    }

    public class EventListener {
        public void onClick (View view){
            switch (view.getId()){
                case R.id.bt_download:
                    requestMaster = DownloadMaster.with(Download.this).url(url).tag("123");
                    requestMaster.download(new DownloadListener() {
                        @Override
                        public void onPending(DownloadInfo downloadInfo) {
                            binding.setDownloadInfo(downloadInfo);
                            Logger.d(downloadInfo.getMessage());
                        }

                        @Override
                        public void onStart(DownloadInfo downloadInfo) {
                            Logger.d(downloadInfo.getMessage());
                        }

                        @Override
                        public void onPause(DownloadInfo downloadInfo) {
                            Logger.d(downloadInfo.getMessage());
                        }

                        @Override
                        public void onProgress(DownloadInfo downloadInfo) {
                            binding.setDownloadInfo(downloadInfo);
                            Logger.d(downloadInfo.getMessage());
                        }

                        @Override
                        public void onFinished(DownloadInfo downloadInfo) {
                            binding.setDownloadInfo(downloadInfo);
                            Logger.d(downloadInfo.getMessage());
                        }

                        @Override
                        public void onCancel(DownloadInfo downloadInfo) {
                            Logger.d(downloadInfo.getMessage());
                        }

                        @Override
                        public void onError(DownloadInfo downloadInfo) {
                            Logger.d(downloadInfo.getMessage());
                        }
                    });
                    break;
                case R.id.bt_cancel:
                    requestMaster.cancel("123");
                    break;
                case R.id.bt_pause:
                    break;
            }

        }
    }
}
