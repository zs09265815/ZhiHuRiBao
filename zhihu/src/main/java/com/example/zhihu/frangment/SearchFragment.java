package com.example.zhihu.frangment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.zhihu.R;
import com.example.zhihu.adapter.FrangVp;
import com.example.zhihu.base.BaseFrangment;
import com.example.zhihu.chilgrangment.DailyFrangment;
import com.example.zhihu.chilgrangment.HotFrangment;
import com.example.zhihu.chilgrangment.ZhuanFrangment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFrangment {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private ArrayList<Fragment> list;
    private FrangVp vp1;

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_zhihu;
    }

    @Override
    protected void initView() {
        super.initView();
        frangmet();
    }

    private void frangmet() {
        list = new ArrayList<>();
        list.add(new DailyFrangment());
        list.add(new ZhuanFrangment());
        list.add(new HotFrangment());

        vp1 = new FrangVp(getChildFragmentManager(), list);
        vp.setAdapter(vp1);
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
    }
}
