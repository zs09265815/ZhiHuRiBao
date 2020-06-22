package com.example.zhihu.chilgrangment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihu.GoldActivity;
import com.example.zhihu.R;
import com.example.zhihu.adapter.Gold_RecviewAdapter;
import com.example.zhihu.base.BaseMvpfrangment;
import com.example.zhihu.bean.Gold_all;
import com.example.zhihu.model.GoldM;
import com.example.zhihu.presenter.GoldP;
import com.example.zhihu.view.GoldV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class GolddailyFrangment extends BaseMvpfrangment<GoldM, GoldV, GoldP> implements GoldV {

    private static final String TAG = GolddailyFrangment.class.getName();
    private ArrayList<Gold_all.ResultsBean> list=new ArrayList<>();
    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private String name;
    private Gold_RecviewAdapter adapter;

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        re.setLayoutManager(layoutManager);
        adapter = new Gold_RecviewAdapter(getContext(), list);
        re.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata(name);
    }

    @SuppressLint("ValidFragment")
    public GolddailyFrangment(String name) {
        this.name = name;
    }


    @Override
    protected GoldV initview() {
        return this;
    }

    @Override
    protected GoldM initmodel() {
        return new GoldM();
    }

    @Override
    protected GoldP initpresenter() {
        return new GoldP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_daily_frangment;
    }

    @Override
    public void OnSuccess(Gold_all gold_all) {
         ArrayList<Gold_all.ResultsBean> results = gold_all.getResults();
         list.addAll(results);
         adapter.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );

    }
}
