package com.example.zhihuribao.presenter;

import com.example.zhihuribao.base.BaseCallback;
import com.example.zhihuribao.base.Basepresenter;
import com.example.zhihuribao.bean.Bean_Zhihu;
import com.example.zhihuribao.bean.Bean_ZhuanLan;
import com.example.zhihuribao.model.ZhuanM;
import com.example.zhihuribao.view.ZhuanLanV;

public class ZhuanLanP extends Basepresenter<ZhuanM,ZhuanLanV> {
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
