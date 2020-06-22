package com.example.zhihu;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihu.adapter.V2exRecviewAdapter;
import com.example.zhihu.base.BaseMvpfrangment;
import com.example.zhihu.bean.Bean_V2ItemBean;
import com.example.zhihu.model.V2exItemM;
import com.example.zhihu.presenter.V2exItemP;
import com.example.zhihu.view.V2exItemV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class V2exItemFrangment extends BaseMvpfrangment<V2exItemM, V2exItemV, V2exItemP> implements V2exItemV {

    private ArrayList<Bean_V2ItemBean> list=new ArrayList<>();

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private String name;
    private V2exRecviewAdapter adapter;

    @Override
    protected void initView() {
        super.initView();
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new V2exRecviewAdapter(getContext(), list);
        re.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata(name);
    }

    @SuppressLint("ValidFragment")
    public V2exItemFrangment(String href) {
        this.name = name;
    }

    @Override
    protected V2exItemV initview() {
        return this;
    }

    @Override
    protected V2exItemM initmodel() {
        return new V2exItemM();
    }

    @Override
    protected V2exItemP initpresenter() {
        return new V2exItemP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_v2ex_item_frangment;
    }

    @Override
    public void OnSuccess(final ArrayList<Bean_V2ItemBean> bean_v2ItemBeans) {
    getActivity().runOnUiThread(new Runnable() {
        @Override
        public void run() {
            list.addAll(bean_v2ItemBeans);
            adapter.setList(list);
            adapter.notifyDataSetChanged();
        }
    });
    }

    @Override
    public void OnFaile(final String msg) {
       getActivity().runOnUiThread(new Runnable() {
           @Override
           public void run() {
               Log.e(TAG, "OnFaile: "+msg );
           }
       });

    }
}
