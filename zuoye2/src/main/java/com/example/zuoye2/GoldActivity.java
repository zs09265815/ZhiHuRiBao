package com.example.zuoye2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.zuoye2.adapter.GoldDateRecviewAdapter;
import com.example.zuoye2.base.SimpleItemTouchHelperCallBack;
import com.example.zuoye2.bean.Gold_bean;

import java.io.Serializable;
import java.util.ArrayList;

public class GoldActivity extends AppCompatActivity {

    private RecyclerView mRe;
    private ArrayList<Gold_bean> list;
    private GoldDateRecviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold);
        initView();
    }

    private void initView() {
        list = (ArrayList<Gold_bean>) getIntent().getSerializableExtra("list");
        mRe = (RecyclerView) findViewById(R.id.re);
        mRe.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GoldDateRecviewAdapter(this, list);
        mRe.setAdapter(adapter);

         SimpleItemTouchHelperCallBack simple = new SimpleItemTouchHelperCallBack(adapter);

         ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simple);
        itemTouchHelper.attachToRecyclerView(mRe);
    }

    @Override
    public void onBackPressed() {
         Intent intent = new Intent();
        intent.putExtra("list",list);
        setResult(Activity.RESULT_OK,intent);
        super.onBackPressed();
    }
}
