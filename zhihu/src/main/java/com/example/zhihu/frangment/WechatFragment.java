package com.example.zhihu.frangment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihu.R;
import com.example.zhihu.adapter.WechatRecviewAdapter;
import com.example.zhihu.base.BaseMvpfrangment;
import com.example.zhihu.bean.Bean_Wechat;
import com.example.zhihu.model.WechatM;
import com.example.zhihu.presenter.WeChatP;
import com.example.zhihu.view.WeChatV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class WechatFragment extends BaseMvpfrangment<WechatM, WeChatV, WeChatP> implements WeChatV {

private ArrayList<Bean_Wechat.NewslistBean> list=new ArrayList<>();
    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private WechatRecviewAdapter adapter;

    @Override
    protected void initView() {
        super.initView();
         LinearLayoutManager manager = new LinearLayoutManager(getContext());
        re.setLayoutManager(manager);
        adapter = new WechatRecviewAdapter(getContext(), list);
        re.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata();
    }

    @Override
    protected WeChatV initview() {
        return this;
    }

    @Override
    protected WechatM initmodel() {
        return new WechatM();
    }

    @Override
    protected WeChatP initpresenter() {
        return new WeChatP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_daily_frangment;
    }

    @Override
    public void OnSuccess(Bean_Wechat bean_wechat) {
         ArrayList<Bean_Wechat.NewslistBean> newslist = bean_wechat.getNewslist();
         list.addAll(newslist);
         adapter.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );

    }
}
