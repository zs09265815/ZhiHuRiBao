package com.example.zhihu.presenter;

import com.example.zhihu.base.BaseCallback;
import com.example.zhihu.base.BasePresenter;
import com.example.zhihu.bean.Bean_ReMen;
import com.example.zhihu.bean.Bean_ZhuanLan;
import com.example.zhihu.model.HotM;
import com.example.zhihu.model.ZhuanM;
import com.example.zhihu.view.HotV;
import com.example.zhihu.view.ZhuanV;

public class HotP extends BasePresenter<HotM,HotV> {
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
