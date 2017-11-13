package com.pixel.pigeonim.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import io.rong.imkit.RongIM;

/**
 * Created by wongchen on 2017/11/8.
 */

public class AppContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
//        if ("io.rong.app".equals(getCurProcessName(getApplicationContext()))||"io.rong.push".equals(getCurProcessName(getApplicationContext()))){
//            RongIM.init(this);
//        }
//        if ("io.rong.app".equals(getCurProcessName(getApplicationContext()))){
//            RongCloudEvent.init(this);
//        }
//    }
//
//    public static String getCurProcessName(Context context) {
//        int pid = android.os.Process.myPid();
//        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
//        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
//            if (appProcess.pid == pid) {
//                return appProcess.processName;
//            }
//
//        }
//        return null;
//
    }
}
