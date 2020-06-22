package com.example.zhihu.adapter;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.example.zhihu.R;
import com.example.zhihu.base.BaseMvpfrangment;
import com.example.zhihu.model.InfoM;
import com.example.zhihu.presenter.Infop;
import com.example.zhihu.view.InfoV;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyFrangment extends BaseMvpfrangment<InfoM, InfoV, Infop> {

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected InfoV initview() {
        return null;
    }

    @Override
    protected InfoM initmodel() {
        return null;
    }

    @Override
    protected Infop initpresenter() {
        return null;
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_daily_frangment;
    }

}
