package com.example.zuoye2.presneter;

import com.example.zuoye2.bean.Gold_all;
import com.example.zuoye2.callback.CallBackk;
import com.example.zuoye2.model.Mymodel;
import com.example.zuoye2.view.MyView;

public class Mypresneterrr implements Mypresneter, CallBackk {
    private Mymodel mymodel;
    private MyView myView;

    public Mypresneterrr(Mymodel mymodel, MyView myView) {
        this.mymodel = mymodel;
        this.myView = myView;
    }

    @Override
    public void getdata(String name) {
        mymodel.getdata(name,this);

    }

    @Override
    public void OnSuccess(Gold_all gold_all) {
        myView.OnSuccess(gold_all);
    }

    @Override
    public void OnFaile(String msg) {
        myView.OnFaile(msg);

    }
}
