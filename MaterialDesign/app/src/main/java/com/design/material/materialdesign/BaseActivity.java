package com.design.material.materialdesign;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;


import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * Created by huozhiliang on 16/4/7.
 */
public abstract class  BaseActivity <T> extends AppCompatActivity {

    protected Toolbar mToolbar;
    protected Intent intent;
    private InputMethodManager manager;
    protected  Context mContext;
    protected Activity mActivity;

    protected TextView tv_titleleft;
    protected TextView tv_titleright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mContext = this;
        mActivity = this;
        //注解
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        initView();
        initData();
        initListener();

    }

    public abstract int setLayout();

    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();

    public void initToolBar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null){
            TextView tv_title = (TextView) findViewById(R.id.tv_title);
            mToolbar.setTitle("");
            if (tv_title != null){
                tv_title.setText(getToolbarTitle());
            }
            setSupportActionBar(mToolbar);
            mToolbar.setNavigationIcon(R.drawable.back);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    public String getToolbarTitle(){
        return "";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

   @Subscribe
    public void onEvent(T t){

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            if(getCurrentFocus()!=null && getCurrentFocus().getWindowToken()!=null){
                manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        return super.onTouchEvent(event);
    }


    public void setback(){
        /*ImageView iv_back = (ImageView) findViewById(R.id.iv_back);
        if (iv_back != null ){
            iv_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }*/
    }
}
