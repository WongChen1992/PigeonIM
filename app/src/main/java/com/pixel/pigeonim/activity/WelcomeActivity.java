package com.pixel.pigeonim.activity;

import android.os.Handler;

import com.pixel.pigeonim.R;

/**
 * Created by wongchen on 2017/11/8.
 */

public class WelcomeActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void init() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //TODO 判断是否已经在登录状态
                startActivityAndFinish(SignInActivity.class);
            }
        }, 1000);
    }
}
