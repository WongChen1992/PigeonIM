package com.pixel.pigeonim.app;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by wongchen on 2017/11/8.
 */

public class AppContext extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}
