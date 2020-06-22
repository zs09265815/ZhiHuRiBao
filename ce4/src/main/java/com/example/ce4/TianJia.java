package com.example.ce4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import javax.xml.transform.Result;

public class TianJia extends AppCompatActivity implements View.OnClickListener {

    private ImageView mTianjiaim;
    /**
     * 姓名：
     */
    private TextView mTianjiatv1;
    /**
     * 请输入
     */
    private EditText mTianjiaed1;
    /**
     * 阶段：
     */
    private TextView mTianjiatv2;
    /**
     * 请输入
     */
    private EditText mTianjiaed2;
    /**
     * 提交
     */
    private Button mTianjia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tian_jia);
        initView();
    }

    private void initView() {
        mTianjiaim = (ImageView) findViewById(R.id.tianjiaim);
        mTianjiatv1 = (TextView) findViewById(R.id.tianjiatv1);
        mTianjiaed1 = (EditText) findViewById(R.id.tianjiaed1);
        mTianjiatv2 = (TextView) findViewById(R.id.tianjiatv2);
        mTianjiaed2 = (EditText) findViewById(R.id.tianjiaed2);
        mTianjia = (Button) findViewById(R.id.tianjia);
        mTianjia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
         String s = mTianjiaed1.getText().toString();
         String s1 = mTianjiaed2.getText().toString();
        switch (v.getId()) {
            default:
                break;
            case R.id.tianjia:
                 Intent intent = new Intent(TianJia.this,ShuJuKu.class);
                intent.putExtra("s",s);
                intent.putExtra("s1",s1);
                setResult(2,intent);
                finish();
                break;
        }
    }
}
