package com.example.zhihuribao.chilfrangment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zhihuribao.R;
import com.example.zhihuribao.adapter.RecviewAdapters4;
import com.example.zhihuribao.base.BaseMvpfrangment;
import com.example.zhihuribao.bean.Bean_ReMen;
import com.example.zhihuribao.model.ReMenM;
import com.example.zhihuribao.presenter.ReMenP;
import com.example.zhihuribao.view.ReMenV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFrangment extends BaseMvpfrangment<ReMenM, ReMenV, ReMenP> implements ReMenV {

private ArrayList<Bean_ReMen.RecentBean> list=new ArrayList<>();
    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private RecviewAdapters4 adapters4;

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
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
    protected ReMenV MyMvpView() {
        return this;
    }

    @Override
    protected ReMenM MyMvpModel() {
        return new ReMenM();
    }

    @Override
    protected ReMenP initMypresenter() {
        return new ReMenP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.zhihuframeng1;
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


//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }
}
