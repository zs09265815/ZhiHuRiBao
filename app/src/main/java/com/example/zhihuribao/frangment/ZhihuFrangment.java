package com.example.zhihuribao.frangment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.zhihuribao.R;
import com.example.zhihuribao.adapter.frangVp;
import com.example.zhihuribao.base.BaseFrangment;
import com.example.zhihuribao.chilfrangment.DailyFrangment;
import com.example.zhihuribao.chilfrangment.HotFrangment;
import com.example.zhihuribao.chilfrangment.SpecialFrangment;

import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuFrangment extends BaseFrangment {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    protected Unbinder bind;
    private ArrayList<Fragment> list;
    private frangVp vp1;

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_zhihu;
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        initfrangment();

        tab.addTab(tab.newTab().setText("日报"));
        tab.addTab(tab.newTab().setText("专栏"));
        tab.addTab(tab.newTab().setText("热门"));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

        vp1 = new frangVp(getChildFragmentManager(), list);
        vp.setAdapter(vp1);
    }


    private void initfrangment() {
        list = new ArrayList<>();
        list.add(new DailyFrangment());
        list.add(new SpecialFrangment());
        list.add(new HotFrangment());
    }
}
