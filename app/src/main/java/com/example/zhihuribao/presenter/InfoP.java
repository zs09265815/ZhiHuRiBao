package com.example.zhihuribao.presenter;

import com.example.zhihuribao.base.BaseCallback;
import com.example.zhihuribao.base.Basepresenter;
import com.example.zhihuribao.bean.Bean_Zhihu;
import com.example.zhihuribao.model.InfoM;
import com.example.zhihuribao.view.InfoV;

public class InfoP extends Basepresenter<InfoM,InfoV> {
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
