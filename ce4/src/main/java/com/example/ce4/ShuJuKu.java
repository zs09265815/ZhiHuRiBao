package com.example.ce4;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.ce4.adapter.RecviewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShuJuKu extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRe;
    private ArrayList<Student> list = new ArrayList<>();
    private RecviewAdapter adapter;
    private PopupWindow pop;
    private int a = 0;
    /**
     * 修改
     */
    private Button mBu1;
    /**
     * 删除
     */
    private Button mBu2;
    private Button bu1;
    private Button bu2;
    /**
     * 添加
     */
    private Button mBbuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shu_ju_ku);
        initView();
        initdata();
        initquery();
        initpop();
    }

    private void initpop() {
        View view = View.inflate(this, R.layout.pop_item, null);
        bu1 = view.findViewById(R.id.bu1);
        bu2 = view.findViewById(R.id.bu2);
        bu1.setOnClickListener(this);
        bu2.setOnClickListener(this);
        pop = new PopupWindow(view, 600, 500);
        pop.setOutsideTouchable(true);
        pop.setBackgroundDrawable(new ColorDrawable());
    }

    private void initquery() {
        List<Student> query = DbHolder.getDbHolder().query();
        list.addAll(query);
        adapter.setList(list);
        adapter.notifyDataSetChanged();
        adapter.setClick(new RecviewAdapter.onclick() {
            @Override
            public void onclick(View view, int position) {
                pop.showAsDropDown(mRe,0,0);
                a = position;
            }
        });
    }

    private void initdata() {
        ArrayList<Student> list1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            student.setId(Long.valueOf(i));
            student.setName("张三" + i);
            student.setSubject("Android高级" + i);
            list1.add(student);
        }
        DbHolder.getDbHolder().insert(list1);
    }

    private void initView() {
        mRe = (RecyclerView) findViewById(R.id.re);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRe.setLayoutManager(manager);
        adapter = new RecviewAdapter(this, list);
        mRe.setAdapter(adapter);
        mBbuu = (Button) findViewById(R.id.bbuu);
        mBbuu.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bu1:
                Intent intent = new Intent(ShuJuKu.this, TianJia.class);
                startActivityForResult(intent,11);
                break;
            case R.id.bu2:
                list.remove(a);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bbuu:
                 Intent intent1 = new Intent(ShuJuKu.this, TianJia.class);
                startActivityForResult(intent1,1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==2){
             String s = data.getStringExtra("s");
             String s1 = data.getStringExtra("s1");
             Student student = new Student();
            student.setName(s);
            student.setSubject(s1);
            list.add(student);
            adapter.notifyDataSetChanged();
        }else{
            String s = data.getStringExtra("s");
            String s1 = data.getStringExtra("s1");
             Student student1 = list.get(a);
             student1.setSubject(s1);
             student1.setName(s);
            adapter.notifyDataSetChanged();
        }
    }
}
