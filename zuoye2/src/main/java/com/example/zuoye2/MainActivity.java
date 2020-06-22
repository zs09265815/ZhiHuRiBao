package com.example.zuoye2;
//张媛媛  1809A

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.zuoye2.adapter.FrangVp;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> list;
    private FrangVp frangVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initfrngemt();
    }

    private void initfrngemt() {
        list = new ArrayList<>();
        list.add(new GoldFrangment());
        list.add(new XiTuJueJinFrangment());
        frangVp = new FrangVp(getSupportFragmentManager(), list);
        mVp.setAdapter(frangVp);

        mTab.addTab(mTab.newTab().setText("A"));
        mTab.addTab(mTab.newTab().setText("B"));
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
    }
}
