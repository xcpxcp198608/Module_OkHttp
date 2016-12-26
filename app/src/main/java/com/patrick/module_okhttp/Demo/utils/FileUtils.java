package com.patrick.module_okhttp.Demo.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by patrick on 2016/12/26.
 */

public class FileUtils {
    //通过系统返回的uri获得文件路径
    public static String getPathByUri (Context context , Uri uri){
        if(uri == null){
            return null;
        }else if("file".equalsIgnoreCase(uri.getScheme())){
            return uri.getPath();
        }else if ("content".equalsIgnoreCase(uri.getScheme())){
            try {
                String[] projection = {"_data"};
                Cursor cursor = null;
                cursor = context.getContentResolver().query(uri, projection, null, null, null);
                int index = cursor.getColumnIndexOrThrow("_data");
                if (cursor.moveToFirst()) {
                    return cursor.getString(index);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return null;
    }


}
