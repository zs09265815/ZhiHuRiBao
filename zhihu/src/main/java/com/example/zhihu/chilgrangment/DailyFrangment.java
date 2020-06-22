package com.example.zhihu.chilgrangment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.zhihu.R;
import com.example.zhihu.adapter.RecviewAdapter1;
import com.example.zhihu.base.BaseMvpfrangment;
import com.example.zhihu.bean.Bean_Zhihu;
import com.example.zhihu.model.InfoM;
import com.example.zhihu.presenter.Infop;
import com.example.zhihu.view.InfoV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyFrangment extends BaseMvpfrangment<InfoM, InfoV, Infop> implements InfoV {

    private static final String TAG = DailyFrangment.class.getName();
    private ArrayList<Bean_Zhihu.StoriesBean> list1=new ArrayList<>();
    private ArrayList<Bean_Zhihu.TopStoriesBean> list=new ArrayList<>();
    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private RecviewAdapter1 adapter1;

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        re.setLayoutManager(manager);
        adapter1 = new RecviewAdapter1(getContext(), list1, list);
        re.setAdapter(adapter1);
    }

    @Override
    protected void initData() {
        super.initData();
        Mypresenter.getdata();
    }

    @Override
    protected InfoV initview() {
        return this;

    }

    @Override
    protected InfoM initmodel() {
        return new InfoM();
    }

    @Override
    protected Infop initpresenter() {
        return new Infop();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_daily_frangment;
    }

    @Override
    public void OnSuccess(Bean_Zhihu bean_zhihu) {
         ArrayList<Bean_Zhihu.StoriesBean> stories = bean_zhihu.getStories();
         list1.addAll(stories);
         ArrayList<Bean_Zhihu.TopStoriesBean> top_stories = bean_zhihu.getTop_stories();
         list.addAll(top_stories);
         adapter1.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );

    }
}
