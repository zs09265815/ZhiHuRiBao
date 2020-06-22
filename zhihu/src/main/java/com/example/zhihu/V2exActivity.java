package com.example.zhihu;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.zhihu.adapter.ReV2exAdapetr;
import com.example.zhihu.base.BaseMvpactivity;
import com.example.zhihu.bean.Bean_V2ex;
import com.example.zhihu.model.V2exM;
import com.example.zhihu.presenter.V2exP;
import com.example.zhihu.view.V2exV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import qdx.stickyheaderdecoration.NormalDecoration;

public class V2exActivity extends BaseMvpactivity<V2exM, V2exV, V2exP> implements V2exV {

    private static final String TAG = V2exActivity.class.getName();
    private ArrayList<Bean_V2ex.DataBean> list=new ArrayList<>();
    @BindView(R.id.re)
    RecyclerView re;
    private ReV2exAdapetr adapetr;

    @Override
    protected void initView() {
        super.initView();
        re.setLayoutManager(new LinearLayoutManager(this));
        adapetr = new ReV2exAdapetr(this, list);
        re.setAdapter(adapetr);
    }
    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata();
    }

    @Override
    protected V2exV initview() {
        return this;
    }

    @Override
    protected V2exM initmodel() {
        return new V2exM();
    }

    @Override
    protected V2exP initpresenter() {
        return new V2exP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_v2ex;

    }

    @Override
    public void OnSuccess(Bean_V2ex bean_v2ex) {
        final ArrayList<Bean_V2ex.DataBean> data = bean_v2ex.getData();
        list.addAll(data);
        NormalDecoration normalDecoration=new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                return data.get(i).getName();
            }
        };
        re.addItemDecoration(normalDecoration);
        adapetr.setList(bean_v2ex.getData());
        adapetr.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );
    }
}
