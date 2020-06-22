package com.example.zuoye2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zuoye2.adapter.GoldFrngVp;
import com.example.zuoye2.bean.Gold_bean;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GoldFrangment extends Fragment {

    private View view;
    private ImageView mIm;
    private TabLayout mTab;
    private ViewPager mVp;
    private String[] mTypes = new String[]{"all","Android","iOS","休息视频",
            "拓展资源","瞎推荐","前端"};
    private ArrayList<Gold_bean> list;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> Tiltle;
    private GoldFrngVp goldFrngVp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_gold_frangment, container, false);
        initView(inflate);
        initdata();
        initlistener();
        return inflate;
    }

    private void initView(View inflate) {
        mIm = (ImageView) inflate.findViewById(R.id.im);
        mTab = (TabLayout) inflate.findViewById(R.id.tab);
        mVp = (ViewPager) inflate.findViewById(R.id.vp);
        list = new ArrayList<>();
        for (int i = 0; i <7 ; i++) {
            if (i%3==0){
                 Gold_bean gold_bean = new Gold_bean(mTypes[i], true);
                 list.add(gold_bean);
            }else {
                Gold_bean gold_bean = new Gold_bean(mTypes[i], false);
                list.add(gold_bean);
            }
        }
        fragments = new ArrayList<>();
        Tiltle = new ArrayList<>();
    }
    private void initdata() {
        for (int i = 0; i <list.size() ; i++) {
             Gold_bean gold_bean = list.get(i);
            if (gold_bean.isSelected()){
                fragments.add(new GoldDatesFrangment(gold_bean.getName()));
                Tiltle.add(gold_bean.getName());
            }
        }
        goldFrngVp = new GoldFrngVp(getChildFragmentManager(), mTypes, fragments);
        mVp.setAdapter(goldFrngVp);

        mTab.setupWithViewPager(mVp);
    }
    private void initlistener() {
        mIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(getActivity(), GoldActivity.class);
                intent.putExtra("list",list);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1&&resultCode==Activity.RESULT_OK){
            list = (ArrayList<Gold_bean>) data.getSerializableExtra("list");
            fragments.clear();
            Tiltle.clear();
            initdata();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
