package com.pixel.pigeonim.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wongchen on 2017/11/2.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        init();
    }

    public abstract int getLayoutId();

    public abstract void init();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
