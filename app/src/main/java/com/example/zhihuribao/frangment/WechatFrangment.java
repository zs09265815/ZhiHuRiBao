package com.example.zhihuribao.frangment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihuribao.R;
import com.example.zhihuribao.base.BaseFrangment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WechatFrangment extends BaseFrangment {


    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_wechat_frangment;
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
    }
    //    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }
}
