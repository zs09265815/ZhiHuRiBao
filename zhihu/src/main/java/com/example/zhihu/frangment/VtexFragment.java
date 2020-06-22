package com.example.zhihu.frangment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zhihu.R;
import com.example.zhihu.V2exActivity;
import com.example.zhihu.V2exItemFrangment;
import com.example.zhihu.adapter.FrangVp;
import com.example.zhihu.base.BaseFrangment;
import com.example.zhihu.base.BaseModel;
import com.example.zhihu.base.BaseMvpfrangment;
import com.example.zhihu.base.BasePresenter;
import com.example.zhihu.base.BaseView;
import com.example.zhihu.bean.Bean_v2Tab;
import com.example.zhihu.model.Vx2TabM;
import com.example.zhihu.presenter.V2exTabP;
import com.example.zhihu.view.V2exTabV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class VtexFragment extends BaseMvpfrangment<Vx2TabM,V2exTabV,V2exTabP> implements V2exTabV {


    @BindView(R.id.goldim)
    ImageView goldim;
    @BindView(R.id.goldtab)
    TabLayout goldtab;
    @BindView(R.id.goldvp)
    ViewPager goldvp;
    Unbinder unbinder;

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.goldfrangment;
    }
    @OnClick(R.id.goldim)
    public void onimaClick(){
         Intent intent = new Intent(getActivity(), V2exActivity.class);
        startActivity(intent);
    }


    @Override
    protected V2exTabV initview() {
        return this;
    }

    @Override
    protected Vx2TabM initmodel() {
        return new Vx2TabM();
    }

    @Override
    protected V2exTabP initpresenter() {
        return new V2exTabP();
    }

    @Override
    public void OnFaile(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            private String TAG;

            @Override
            public void run() {
                Log.e(TAG, "run: "+msg );
            }
        });


    }

    @Override
    public void OnSuccess(final ArrayList<Bean_v2Tab> bean_v2Tab) {
        getActivity().runOnUiThread(new Runnable() {


            private FrangVp frangVp;
            private ArrayList<Fragment> list;

            @Override
            public void run() {
                list = new ArrayList<>();
                for (int i = 0; i <bean_v2Tab.size(); i++) {
                     Bean_v2Tab bean_v2Tab1 = bean_v2Tab.get(i);
                    list.add(new V2exItemFrangment(bean_v2Tab1.getHref()));
                    goldtab.addTab(goldtab.newTab().setText(bean_v2Tab1.getTitle()));
                }
                frangVp = new FrangVp(getChildFragmentManager(), list);
                goldvp.setAdapter(frangVp);

                goldtab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        goldvp.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });

                goldvp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(goldtab));
            }
        });
    }
}
