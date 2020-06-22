package com.example.zhihuribao.chilfrangment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zhihuribao.R;
import com.example.zhihuribao.adapter.Recadapters3;
import com.example.zhihuribao.base.BaseMvpfrangment;
import com.example.zhihuribao.bean.Bean_ZhuanLan;
import com.example.zhihuribao.model.ZhuanM;
import com.example.zhihuribao.presenter.ZhuanLanP;
import com.example.zhihuribao.view.ZhuanLanV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpecialFrangment extends BaseMvpfrangment<ZhuanM, ZhuanLanV, ZhuanLanP> implements ZhuanLanV {
    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private ArrayList<Bean_ZhuanLan.DataBean> list = new ArrayList<>();
    private Recadapters3 recadapters3;

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
         GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        re.setLayoutManager(manager);
        recadapters3 = new Recadapters3(getContext(), list);
        re.setAdapter(recadapters3);
    }

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata();
    }

    @Override
    protected ZhuanLanV MyMvpView() {
        return this;
    }

    @Override
    protected ZhuanM MyMvpModel() {
        return new ZhuanM();
    }

    @Override
    protected ZhuanLanP initMypresenter() {
        return new ZhuanLanP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.zhihuframeng1;
    }

    @Override
    public void OnSuccess(Bean_ZhuanLan bean_zhuanLan) {
        ArrayList<Bean_ZhuanLan.DataBean> data = bean_zhuanLan.getData();
        list.addAll(data);
        recadapters3.notifyDataSetChanged();
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
