package com.example.zhihu.chilgrangment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihu.R;
import com.example.zhihu.adapter.Recadapters3;
import com.example.zhihu.base.BaseMvpfrangment;
import com.example.zhihu.bean.Bean_ZhuanLan;
import com.example.zhihu.model.ZhuanM;
import com.example.zhihu.presenter.ZhuanP;
import com.example.zhihu.view.ZhuanV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanFrangment extends BaseMvpfrangment<ZhuanM, ZhuanV, ZhuanP> implements ZhuanV {
    private static final String TAG = ZhuanFrangment.class.getName();
    private ArrayList<Bean_ZhuanLan.DataBean> list=new ArrayList<>();

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private Recadapters3 recadapters3;

    @Override
    protected void initView() {
        super.initView();
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
    protected ZhuanV initview() {
        return this;
    }

    @Override
    protected ZhuanM initmodel() {
        return new ZhuanM();
    }

    @Override
    protected ZhuanP initpresenter() {
        return new ZhuanP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_daily_frangment;
    }

    @Override
    public void OnSuccess(Bean_ZhuanLan bean_zhuanLan) {
         ArrayList<Bean_ZhuanLan.DataBean> data = bean_zhuanLan.getData();
         list.addAll(data);
         recadapters3.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );

    }
}
