package com.example.zhihu.chilgrangment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihu.R;
import com.example.zhihu.adapter.RecviewAdapters4;
import com.example.zhihu.base.BaseMvpfrangment;
import com.example.zhihu.bean.Bean_ReMen;
import com.example.zhihu.model.HotM;
import com.example.zhihu.presenter.HotP;
import com.example.zhihu.view.HotV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFrangment extends BaseMvpfrangment<HotM, HotV, HotP> implements HotV {

private ArrayList<Bean_ReMen.RecentBean> list=new ArrayList<>();
    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private RecviewAdapters4 adapters4;

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        re.setLayoutManager(manager);
        adapters4 = new RecviewAdapters4(getContext(), list);
        re.setAdapter(adapters4);
    }

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata();
    }

    @Override
    protected HotV initview() {
        return this;
    }

    @Override
    protected HotM initmodel() {
        return new HotM();
    }

    @Override
    protected HotP initpresenter() {
        return new HotP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_daily_frangment;
    }

    @Override
    public void OnSuccess(Bean_ReMen bean_reMen) {
         ArrayList<Bean_ReMen.RecentBean> recent = bean_reMen.getRecent();
         list.addAll(recent);
         adapters4.notifyDataSetChanged();

    }

    @Override
    public void OnFaile(String msg) {

    }

}
