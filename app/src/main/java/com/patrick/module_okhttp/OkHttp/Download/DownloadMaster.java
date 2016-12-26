package com.patrick.module_okhttp.OkHttp.Download;

import android.content.Context;

/**
 * Created by patrick on 2016/12/23.
 */

public class DownloadMaster {



    public static DownloadRequest with (Context context){
        return new DownloadRequest(context);
    }

    public static void cancel (Object tag){

    }

}
