package com.patrick.module_okhttp.Demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.patrick.module_okhttp.Demo.utils.Logger;

/**
 * Created by patrick on 2016/12/22.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.init("----px----");
    }
}
