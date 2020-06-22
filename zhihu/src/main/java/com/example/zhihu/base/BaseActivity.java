package com.example.zhihu.base;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayoutId());
        ButterKnife.bind(this);
        initMvp();
        initView();
        initData();
        initListener();

    }

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView() {

    }

    protected void initMvp() {
    }

    protected abstract int getlayoutId();

    public void addFrangment(FragmentManager manager,Class<? extends BaseFrangment> zclass,int layoutId,Bundle args){

    }
}
