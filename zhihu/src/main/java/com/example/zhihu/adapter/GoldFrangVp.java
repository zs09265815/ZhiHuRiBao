package com.example.zhihu.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class GoldFrangVp extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private String[] type;

    public GoldFrangVp(FragmentManager fm, ArrayList<Fragment> list, String[] type) {
        super(fm);
        this.list = list;
        this.type = type;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return type[position];
    }
}
