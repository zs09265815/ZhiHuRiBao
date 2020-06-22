package com.example.zhihu.presenter;

import com.example.zhihu.base.BaseCallback;
import com.example.zhihu.base.BasePresenter;
import com.example.zhihu.bean.Bean_V2ItemBean;
import com.example.zhihu.bean.Gold_all;
import com.example.zhihu.model.GoldM;
import com.example.zhihu.model.V2exItemM;
import com.example.zhihu.view.GoldV;
import com.example.zhihu.view.V2exItemV;

import java.util.ArrayList;

public class V2exItemP extends BasePresenter<V2exItemM,V2exItemV> {
    public void getdata(String href){
        if (Mymodel!=null){
            Mymodel.getData(href,new BaseCallback<ArrayList<Bean_V2ItemBean>>() {
                @Override
                public void OnSuccess(ArrayList<Bean_V2ItemBean> bean_v2ItemBeans) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_v2ItemBeans);
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
