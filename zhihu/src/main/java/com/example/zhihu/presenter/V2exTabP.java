package com.example.zhihu.presenter;

import com.example.zhihu.base.BaseCallback;
import com.example.zhihu.base.BasePresenter;
import com.example.zhihu.bean.Bean_Zhihu;
import com.example.zhihu.bean.Bean_v2Tab;
import com.example.zhihu.model.InfoM;
import com.example.zhihu.model.Vx2TabM;
import com.example.zhihu.view.InfoV;
import com.example.zhihu.view.V2exTabV;
import com.example.zhihu.view.V2exV;

import java.util.ArrayList;

public class V2exTabP extends BasePresenter<Vx2TabM,V2exTabV> {
    public void getdata(){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<ArrayList<Bean_v2Tab>>() {
                @Override
                public void OnSuccess(ArrayList<Bean_v2Tab> bean_v2Tab) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_v2Tab);
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
