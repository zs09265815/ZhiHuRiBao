package com.example.zhihu.presenter;

import com.example.zhihu.base.BaseCallback;
import com.example.zhihu.base.BasePresenter;
import com.example.zhihu.bean.Bean_ReMen;
import com.example.zhihu.bean.Bean_V2ex;
import com.example.zhihu.model.HotM;
import com.example.zhihu.model.V2exM;
import com.example.zhihu.view.HotV;
import com.example.zhihu.view.V2exV;

public class V2exP extends BasePresenter<V2exM,V2exV> {
    public void getdata(){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<Bean_V2ex>() {
                @Override
                public void OnSuccess(Bean_V2ex bean_v2ex) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_v2ex);
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
