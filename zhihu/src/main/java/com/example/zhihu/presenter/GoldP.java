package com.example.zhihu.presenter;

import com.example.zhihu.base.BaseCallback;
import com.example.zhihu.base.BasePresenter;
import com.example.zhihu.bean.Bean_ReMen;
import com.example.zhihu.bean.Gold_all;
import com.example.zhihu.model.GoldM;
import com.example.zhihu.model.HotM;
import com.example.zhihu.view.GoldV;
import com.example.zhihu.view.HotV;

public class GoldP extends BasePresenter<GoldM,GoldV> {
    public void getdata(String name){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<Gold_all>() {
                @Override
                public void OnSuccess(Gold_all gold_all) {
                    if (Myview!=null){
                        Myview.OnSuccess(gold_all);
                    }
                }

                @Override
                public void OnFaile(String msg) {
                    if (Myview!=null){
                        Myview.OnFaile(msg);
                    }

                }
            });
        }
    }
}
