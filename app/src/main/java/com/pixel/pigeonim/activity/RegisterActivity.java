package com.pixel.pigeonim.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pixel.pigeonim.R;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by a1111 on 17/11/7.
 */

public class RegisterActivity extends BaseActivity {


    @BindView(R.id.et_register_phonenumber)
    EditText etRegisterPhonenumber;
    @BindView(R.id.text_register_phonenumber)
    TextInputLayout textRegisterPhonenumber;
    @BindView(R.id.et_register_password)
    EditText etRegisterPassword;
    @BindView(R.id.text_register_password)
    TextInputLayout textRegisterPassword;
    @BindView(R.id.et_register_password_twice)
    EditText etRegisterPasswordTwice;
    @BindView(R.id.text_register_password_twice)
    TextInputLayout textRegisterPasswordTwice;
    @BindView(R.id.et_register_verification_code)
    EditText etRegisterVerificationCode;
    @BindView(R.id.text_register_verification)
    TextInputLayout textRegisterVerification;
    @BindView(R.id.btn_register_verification_get_code)
    Button btnRegisterVerificationGetCode;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void init() {
        etRegisterPhonenumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etRegisterPhonenumber.getText().toString())) {
                    textRegisterPhonenumber.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etRegisterPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etRegisterPassword.getText().toString())) {
                    textRegisterPassword.setErrorEnabled(false);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etRegisterPasswordTwice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etRegisterPasswordTwice.getText().toString())) {
                    textRegisterPasswordTwice.setErrorEnabled(false);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etRegisterVerificationCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etRegisterVerificationCode.getText().toString())) {
                    textRegisterVerification.setErrorEnabled(false);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etRegisterVerificationCode.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Verify_Register_information();
                return false;
            }
        });

    }

    private CountDownTimer timer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long l) {
            btnRegisterVerificationGetCode.setEnabled(false);
            btnRegisterVerificationGetCode.setText(l / 1000 + "s");
            btnRegisterVerificationGetCode.setBackgroundColor(Color.GRAY);

        }

        @Override
        public void onFinish() {
            btnRegisterVerificationGetCode.setEnabled(true);
            btnRegisterVerificationGetCode.setText("重新获取");
            btnRegisterVerificationGetCode.setBackgroundColor(getResources().getColor(R.color.colorAccent));


        }
    };

    private void Verify_Register_information() {
        String number = etRegisterPhonenumber.getText().toString();
        String password1 = etRegisterPassword.getText().toString();
        String password2 = etRegisterPasswordTwice.getText().toString();
        String verifycode = etRegisterVerificationCode.getText().toString();
        String verifycodetest = "0000";

        if (TextUtils.isEmpty(number)) {
            textRegisterPhonenumber.setError("手机号不能为空");
            return;

        } else {
            if (isMobileNO(etRegisterPhonenumber.getText().toString()) == false) {
                textRegisterPhonenumber.setError("手机号码格式不正确");
                return;
            }
        }
        if (TextUtils.isEmpty(password1)) {
            textRegisterPassword.setError("密码不能为空");
            return;
        }
        if (TextUtils.isEmpty(password2)) {
            textRegisterPasswordTwice.setError("请确认密码");
            return;
        }
        if (TextUtils.isEmpty(verifycode)) {
            textRegisterVerification.setError("验证码不能为空");
            return;
        }
        if (!TextUtils.isEmpty(password1) && !TextUtils.isEmpty(password2) && password1.equals(password2) == false) {
            textRegisterPasswordTwice.setError("两次密码不相同");
        }
        if (!TextUtils.isEmpty(verifycode) && verifycode.equals(verifycodetest) == false) {
            textRegisterVerification.setError("验证码不正确");
        }


    }

    public static boolean isMobileNO(String number) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(number);
        System.out.println(m.matches() + "---");

        return m.matches();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(RegisterActivity.isMobileNO("12016155153"));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_register_verification_get_code, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_register_verification_get_code:
                if (TextUtils.isEmpty(etRegisterPhonenumber.getText().toString())) {
                    textRegisterPhonenumber.setError("手机号不能为空");

                } else if(!TextUtils.isEmpty(etRegisterPhonenumber.getText().toString())&&isMobileNO(etRegisterPhonenumber.getText().toString()) == false){
                    textRegisterPhonenumber.setError("手机号码格式不正确");
                    return;
                }else {
                    timer.start();
                }

                break;
            case R.id.btn_register:
                Verify_Register_information();
                break;
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
