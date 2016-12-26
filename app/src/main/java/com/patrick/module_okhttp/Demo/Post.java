package com.patrick.module_okhttp.Demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.patrick.module_okhttp.Demo.beans.PostInfo;
import com.patrick.module_okhttp.Demo.utils.Logger;
import com.patrick.module_okhttp.OkHttp.Listener.StringListener;
import com.patrick.module_okhttp.OkHttp.OkMaster;
import com.patrick.module_okhttp.R;
import com.patrick.module_okhttp.databinding.ActivityPostBinding;

import java.io.IOException;

/**
 * Created by patrick on 2016/12/20.
 */

public class Post extends BaseActivity {

    private String url = "http://158.69.229.104:8080/PostAPI/PostHandler";
    private String username = "admin";
    private String password = "admin";
    private ActivityPostBinding binding;
    private PostInfo postInfo = new PostInfo();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this ,R.layout.activity_post);
        binding.setEvent(new EventListener());
    }

    public class EventListener {
        public void onCustomClick(View view){
            OkMaster.post(url)
                    .parames("username" , username)
                    .parames("password" , password)
                    .enqueue(new StringListener() {
                        @Override
                        public void onSuccess(String s) throws IOException {
                            Logger.d(s);
                            postInfo.setS(s);
                            binding.setPostInfo(postInfo);
                        }

                        @Override
                        public void onFailure(String e) {

                        }
                    });
        }
    }

}
