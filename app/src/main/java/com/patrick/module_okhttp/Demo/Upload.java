package com.patrick.module_okhttp.Demo;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.patrick.module_okhttp.Demo.beans.FileInfo;
import com.patrick.module_okhttp.Demo.utils.FileUtils;
import com.patrick.module_okhttp.Demo.utils.Logger;
import com.patrick.module_okhttp.OkHttp.Listener.UploadListener;
import com.patrick.module_okhttp.OkHttp.OkMaster;
import com.patrick.module_okhttp.R;
import com.patrick.module_okhttp.databinding.ActivityUploadBinding;

import java.io.File;
import java.io.IOException;

import okhttp3.Response;

/**
 * Created by patrick on 2016/12/20.
 */

public class Upload extends BaseActivity {
    private String url = "http://158.69.229.104:8080/UploadAPI/Upload";
    private ActivityUploadBinding binding;
    private FileInfo fileInfo = new FileInfo();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_upload);
        binding.setEvent(new EventListener());
    }

    public class EventListener {
        public void onClick(View view){
            switch (view.getId()){
                case R.id.bt_pick:
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setType("*/*"); //选择任意文件
//                    intent.setType("image/*"); //选择图片
//                    intent.setType("audio/*"); //选择音频
//                    intent.setType("video/*"); //选择视频 （mp4 3gp 是android支持的视频格式）
//                    intent.setType("video/*;image/*");//同时选择视频和图片
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    startActivityForResult(intent , 1);
                    break;
                case R.id.bt_upload:
                    File file = new File(fileInfo.getPath());
                    if(!file.exists()){
                        return;
                    }else{
                        fileInfo.setName(file.getName());
                        OkMaster.upload(url).file(file).upload(new UploadListener() {
                            @Override
                            public void onSuccess(Response response) throws IOException {
                                Logger.d(response.body().string());
                                binding.progressbar.setVisibility(View.GONE);
                            }

                            @Override
                            public void onFailure(String e) {
                                Logger.d(e);
                            }
                        });
                    }
                    break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            String path = FileUtils.getPathByUri(Upload.this , uri);
            fileInfo.setPath(path);
            fileInfo.setName(path.split("/")[path.split("/").length-1]);
            Logger.d(path);
        }else{
            fileInfo.setPath("");
            fileInfo.setName("没有选择文件");
        }
        binding.setFileInfo(fileInfo);
    }
}
