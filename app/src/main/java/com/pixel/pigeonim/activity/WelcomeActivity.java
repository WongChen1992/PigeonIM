package com.pixel.pigeonim.activity;

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
        startActivity(SignInActivity.class);
    }
}
