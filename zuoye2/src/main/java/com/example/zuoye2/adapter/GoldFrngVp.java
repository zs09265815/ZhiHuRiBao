package com.example.zuoye2.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class GoldFrngVp extends FragmentPagerAdapter {
    private String[] mTypes;
    private ArrayList<Fragment> fragments;

    public GoldFrngVp(FragmentManager fm, String[] mTypes, ArrayList<Fragment> fragments) {
        super(fm);
        this.mTypes = mTypes;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTypes[position];
    }
}
