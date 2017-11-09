package com.pixel.pigeonim.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pixel.pigeonim.R;
import com.pixel.pigeonim.common.CommonUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by a1111 on 17/11/8.
 */

public class PassWordFindActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.text_phone)
    TextInputLayout textPhone;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.text_code)
    TextInputLayout textCode;
    @BindView(R.id.btn_register_verification_get_code)
    Button btnRegisterVerificationGetCode;
    @BindView(R.id.btn_find_password)
    Button btnFindPassword;

    @Override
    public int getLayoutId() {
        return R.layout.activity_findpassword;
    }

    @Override
    public void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("找回密码");

        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etPhone.getText().toString())) {
                    textPhone.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etCode.getText().toString())) {
                    textCode.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private String code = "0000";

    public void informationComfirm() {

        if (TextUtils.isEmpty(etPhone.getText().toString())) {
            textPhone.setError(getResources().getString(R.string.phone_number_cannot_be_empty));
        } else if (!CommonUtils.isMobileNum(etPhone.getText().toString())) {
            textPhone.setError(getResources().getString(R.string.sign_up_error_5));

        }


        if (TextUtils.isEmpty(etCode.getText().toString())) {
            textCode.setError(getResources().getString(R.string.sign_up_error_2));
        }
        if (!TextUtils.isEmpty(etCode.getText().toString()) && !etCode.getText().toString().equals(code)) {
            textCode.setError(getResources().getString(R.string.sign_up_error_3));

        }
        if (!TextUtils.isEmpty(etPhone.getText().toString()) && !TextUtils.isEmpty(etCode.getText().toString()) && etCode.getText().toString().equals(code)) {
            startActivity(ResetPasswordActivity.class);

        }
    }

    private CountDownTimer timer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            btnRegisterVerificationGetCode.setEnabled(false);
            btnRegisterVerificationGetCode.setText(millisUntilFinished / 1000 + "s");
            btnRegisterVerificationGetCode.setBackgroundColor(Color.GRAY);

        }

        @Override
        public void onFinish() {
            btnRegisterVerificationGetCode.setEnabled(true);
            btnRegisterVerificationGetCode.setText("重新获取");
            btnRegisterVerificationGetCode.setBackgroundColor(getResources().getColor(R.color.colorAccent));


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_register_verification_get_code, R.id.btn_find_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_register_verification_get_code:
                if (TextUtils.isEmpty(etPhone.getText().toString())) {
                    textPhone.setError(getResources().getString(R.string.phone_number_cannot_be_empty));


                }
                if (TextUtils.isEmpty(etCode.getText().toString())) {
                    textCode.setError(getResources().getString(R.string.sign_up_error_2));
                } else if (!TextUtils.isEmpty(etCode.getText().toString()) && !etCode.getText().toString().equals(code)) {
                    textCode.setError(getResources().getString(R.string.sign_up_error_3));

                } else {
                    timer.start();
                }
                break;
            case R.id.btn_find_password:
                informationComfirm();
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
