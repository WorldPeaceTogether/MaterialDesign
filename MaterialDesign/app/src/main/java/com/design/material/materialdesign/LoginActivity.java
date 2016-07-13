package com.design.material.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/6/29.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.et_Login)
    TextInputEditText etLogin;
    @Bind(R.id.et_Password)
    TextInputEditText etPassword;
    @Bind(R.id.text)
    TextView text;

    @Override
    public int setLayout() {

        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        text.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.text){
            finish();
            intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
