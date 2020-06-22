package com.example.zhihu;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.example.zhihu.adapter.RvGoldrecviewAdapter;
import com.example.zhihu.base.BaseActivity;
import com.example.zhihu.bean.Gold_bean;
import com.example.zhihu.util.SimpleItemTouchHelperCallBack;
import com.example.zhihu.util.TouchCallBack;
import java.util.ArrayList;
import butterknife.BindView;

public class GoldActivity extends BaseActivity {
    @BindView(R.id.re)
    RecyclerView re;
    private ArrayList<Gold_bean> list;
    private RvGoldrecviewAdapter adapter;

    @Override
    protected int getlayoutId() {
        return R.layout.goldactivity;
    }

    @Override
    protected void initView() {
        list = (ArrayList<Gold_bean>) getIntent().getSerializableExtra("list");
        adapter = new RvGoldrecviewAdapter(this, list);
        re.setAdapter(adapter);
        re.setLayoutManager(new LinearLayoutManager(this));


        SimpleItemTouchHelperCallBack simpleIte = new SimpleItemTouchHelperCallBack(adapter);
         ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleIte);
        itemTouchHelper.attachToRecyclerView(re);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("list",list);
        setResult(2,intent);
        super.onBackPressed();
    }
}

