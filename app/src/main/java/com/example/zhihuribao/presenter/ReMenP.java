package com.example.zhihuribao.presenter;

import com.example.zhihuribao.base.BaseCallback;
import com.example.zhihuribao.base.Basepresenter;
import com.example.zhihuribao.bean.Bean_ReMen;
import com.example.zhihuribao.bean.Bean_Zhihu;
import com.example.zhihuribao.model.ReMenM;
import com.example.zhihuribao.view.ReMenV;

public class ReMenP extends Basepresenter<ReMenM,ReMenV> {
    public void getdata(){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<Bean_ReMen>() {
                @Override
                public void OnSuccess(Bean_ReMen bean_reMen) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_reMen);
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
