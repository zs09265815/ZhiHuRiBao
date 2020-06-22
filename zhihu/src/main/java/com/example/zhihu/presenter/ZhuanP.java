package com.example.zhihu.presenter;

import com.example.zhihu.base.BaseCallback;
import com.example.zhihu.base.BasePresenter;
import com.example.zhihu.bean.Bean_Zhihu;
import com.example.zhihu.bean.Bean_ZhuanLan;
import com.example.zhihu.model.InfoM;
import com.example.zhihu.model.ZhuanM;
import com.example.zhihu.view.InfoV;
import com.example.zhihu.view.ZhuanV;

public class ZhuanP extends BasePresenter<ZhuanM,ZhuanV> {
    public void getdata(){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<Bean_ZhuanLan>() {
                @Override
                public void OnSuccess(Bean_ZhuanLan bean_zhuanLan) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_zhuanLan);
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
