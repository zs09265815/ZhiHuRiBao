package com.example.zhihuribao.chilfrangment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.zhihuribao.R;
import com.example.zhihuribao.adapter.RecviewAdapter1;
import com.example.zhihuribao.base.BaseMvpfrangment;
import com.example.zhihuribao.bean.Bean_Zhihu;
import com.example.zhihuribao.model.InfoM;
import com.example.zhihuribao.presenter.InfoP;
import com.example.zhihuribao.view.InfoV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyFrangment extends BaseMvpfrangment<InfoM, InfoV, InfoP> implements InfoV {

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private ArrayList<Bean_Zhihu.StoriesBean> list1=new ArrayList<>();
    private ArrayList<Bean_Zhihu.TopStoriesBean> list=new ArrayList<>();
    private RecviewAdapter1 adapter1;

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
         LinearLayoutManager manager = new LinearLayoutManager(getContext());
        re.setLayoutManager(manager);
        adapter1 = new RecviewAdapter1(getContext(), list1, list);
        re.setAdapter(adapter1);
    }

    @Override
    protected void initData() {
        Mypresenter.getdata();
    }

    @Override
    protected InfoV MyMvpView() {
        return this;
    }

    @Override
    protected InfoM MyMvpModel() {
        return new InfoM();
    }

    @Override
    protected InfoP initMypresenter() {
        return new InfoP();
    }

    @Override
    protected int getlayoutId() {
        return R.layout.zhihuframeng1;
    }


//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }

    @Override
    public void OnSuccess(Bean_Zhihu bean_zhihu) {
        final ArrayList<Bean_Zhihu.StoriesBean> stories = bean_zhihu.getStories();
        final ArrayList<Bean_Zhihu.TopStoriesBean> top_stories = bean_zhihu.getTop_stories();
        list.addAll(top_stories);
        list1.addAll(stories);
        adapter1.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );
    }
}
