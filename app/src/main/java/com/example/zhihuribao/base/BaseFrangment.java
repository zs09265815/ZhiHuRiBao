package com.example.zhihuribao.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFrangment extends Fragment {
    protected Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View inflate = inflater.inflate(getlayoutId(), null);
        bind = ButterKnife.bind(this, inflate);
        initMvp();
        initView(inflate);
        initData();
        initListener();
        return inflate;

    }

    protected void initView(View inflate) {
    }

    protected void initListener() {

    }

    protected void initData() {

    }


    protected void initMvp() {

    }

    protected abstract int getlayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
