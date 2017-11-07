package com.pixel.pigeonim;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pixel.pigeonim.activity.BaseActivity;
import com.pixel.pigeonim.activity.RegisterActivity;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_find_password)
    TextView tvFindPassword;
    @BindView(R.id.tv_sign_up)
    TextView tvSignUp;
    @BindView(R.id.btn_sign_in)
    Button btnSignIn;
    @BindView(R.id.text_input_layout_account)
    TextInputLayout textInputLayoutAccount;
    @BindView(R.id.text_input_layout_password)
    TextInputLayout textInputLayoutPassword;

    @Override
    public int getLayoutId() {
        return R.layout.activity_signin;
    }

    @Override
    public void init() {
        etAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etAccount.getText().toString()))
                    textInputLayoutAccount.setErrorEnabled(false);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etPassword.getText().toString()))
                    textInputLayoutPassword.setErrorEnabled(false);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                signIn();
                return false;
            }
        });
    }

    @OnClick({R.id.tv_find_password, R.id.tv_sign_up, R.id.btn_sign_in})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_find_password:

                break;
            case R.id.tv_sign_up:
                Intent sign_up_intent=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(sign_up_intent);
                break;
            case R.id.btn_sign_in:
                signIn();
                break;
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

    private void signIn() {
        String account = etAccount.getText().toString();
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(account)) {
            textInputLayoutAccount.setError("手机号不能为空");

        }else if (!TextUtils.isEmpty(account)&&isMobileNO(etAccount.getText().toString())==false){
            textInputLayoutAccount.setError("手机格式不正确");
        }
        if (TextUtils.isEmpty(password)) {
            textInputLayoutPassword.setError("密码不能为空");
            return;
        }

    }
}
