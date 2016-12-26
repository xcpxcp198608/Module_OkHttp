package com.patrick.module_okhttp.OkHttp;

import com.patrick.module_okhttp.OkHttp.Request.GetRequest;
import com.patrick.module_okhttp.OkHttp.Request.PostRequest;
import com.patrick.module_okhttp.OkHttp.Request.UploadRequest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by patrick on 2016/12/20.
 */

public class OkMaster {

    public static OkHttpClient okHttpClient;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30,TimeUnit.SECONDS);
        builder.readTimeout(30,TimeUnit.SECONDS);
        okHttpClient = builder.build();
    }

    public static GetRequest get(String url){
        return new GetRequest(url);
    }

    public static PostRequest post(String url){
        return new PostRequest(url);
    }

    public static UploadRequest upload(String url){
        return new UploadRequest(url);
    }

}
