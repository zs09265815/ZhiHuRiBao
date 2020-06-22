package com.example.zuoye2;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zuoye2.adapter.Gold_RecviewAdapter;
import com.example.zuoye2.bean.Gold_all;
import com.example.zuoye2.model.Mymodelim;
import com.example.zuoye2.presneter.Mypresneterrr;
import com.example.zuoye2.view.MyView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class GoldDatesFrangment extends Fragment implements MyView {


    private static final String TAG = GoldDatesFrangment.class.getName();
    private String name;
    private View view;
    private RecyclerView mRe;
    private Mypresneterrr mypresneterrr;
    private ArrayList<Gold_all.ResultsBean> list=new ArrayList<>();
    private Gold_RecviewAdapter adapter;

    @SuppressLint("ValidFragment")
    public GoldDatesFrangment(String name) {
        this.name = name;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.golddatads_frngment, container, false);
        initView(inflate);
        initdata();
        return inflate;
    }

    private void initdata() {
        mypresneterrr = new Mypresneterrr(new Mymodelim(), this);
        mypresneterrr.getdata(name);
    }

    private void initView(View inflate) {
        mRe = (RecyclerView) inflate.findViewById(R.id.re);
        mRe.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Gold_RecviewAdapter(getContext(), list);
        mRe.setAdapter(adapter);

    }

    @Override
    public void OnSuccess(Gold_all gold_all) {
         ArrayList<Gold_all.ResultsBean> results = gold_all.getResults();
         list.addAll(results);
         adapter.notifyDataSetChanged();

    }

    @Override
    public void OnFaile(String msg) {
        Log.e(TAG, "OnFaile: "+msg );

    }
}
