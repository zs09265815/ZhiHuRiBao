package com.example.zhihu.presenter;

import com.example.zhihu.base.BaseCallback;
import com.example.zhihu.base.BasePresenter;
import com.example.zhihu.bean.Bean_Zhihu;
import com.example.zhihu.model.InfoM;
import com.example.zhihu.view.InfoV;

public class Infop extends BasePresenter<InfoM,InfoV> {
    public void getdata(){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<Bean_Zhihu>() {
                @Override
                public void OnSuccess(Bean_Zhihu bean_zhihu) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_zhihu);
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
