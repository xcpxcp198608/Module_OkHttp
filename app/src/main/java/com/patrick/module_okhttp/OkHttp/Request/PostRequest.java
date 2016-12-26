package com.patrick.module_okhttp.OkHttp.Request;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Request;

/**
 * Created by patrick on 2016/12/23.
 */

public class PostRequest extends RequestMaster {

    private String url;

    public PostRequest (String  url){
        this.url = url;
    }

    @Override
    protected Request createRequest(Header header, Parameters parameters ,Object tag) {
        Request.Builder builder = new Request.Builder();
        if(header != null){
            Headers headers = Headers.of(header.stringMap);
            builder.headers(headers);
        }
        if(parameters != null){
            FormBody.Builder builder1 = new FormBody.Builder();
            for (Map.Entry<String ,String > entry : parameters.stringMap.entrySet()){
                builder1.add(entry.getKey() ,entry.getValue());
            }
            builder.post(builder1.build());
        }
        if(tag != null){
            builder.tag(tag);
        }
        builder.url(url);
        return builder.build();
    }
}
