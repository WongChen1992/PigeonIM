package com.pixel.pigeonim.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.pixel.pigeonim.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by a1111 on 17/11/8.
 */

public class ResetPasswordActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_new_password)
    EditText etNewPassword;
    @BindView(R.id.text_password)
    TextInputLayout textPassword;
    @BindView(R.id.et_affirm)
    EditText etAffirm;
    @BindView(R.id.text_affirm)
    TextInputLayout textAffirm;
    @BindView(R.id.btn_affirm)
    Button btnAffirm;

    @Override
    public int getLayoutId() {
        return R.layout.activity_resetpassword;
    }

    @Override
    public void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("重置密码");
        etAffirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etAffirm.getText().toString())) {
                    textAffirm.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etNewPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etNewPassword.getText().toString())) {
                    textPassword.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    private void passwordCompare(){
        if (TextUtils.isEmpty(etNewPassword.getText().toString())){
            textPassword.setError(getResources().getString(R.string.sign_up_error_4));
        }
        if (TextUtils.isEmpty(etAffirm.getText().toString())){
            textAffirm.setError(getResources().getString(R.string.register_password_twice));
        }
        if (!TextUtils.isEmpty(etNewPassword.getText().toString())&&!TextUtils.isEmpty(etAffirm.getText().toString())&&!etAffirm.getText().toString().equals(etNewPassword.getText().toString())){
            textAffirm.setError(getResources().getString(R.string.sign_up_error_1));
        }
    }

    @OnClick(R.id.btn_affirm)
    public void onViewClicked() {
        passwordCompare();

    }
}
