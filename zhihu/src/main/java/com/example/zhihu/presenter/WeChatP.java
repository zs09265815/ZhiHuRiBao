package com.example.zhihu.presenter;

import com.example.zhihu.base.BaseCallback;
import com.example.zhihu.base.BasePresenter;
import com.example.zhihu.bean.Bean_ReMen;
import com.example.zhihu.bean.Bean_Wechat;
import com.example.zhihu.model.HotM;
import com.example.zhihu.model.WechatM;
import com.example.zhihu.view.HotV;
import com.example.zhihu.view.WeChatV;

public class WeChatP extends BasePresenter<WechatM,WeChatV> {
    public void getdata(){
        if (Mymodel!=null){
            Mymodel.getdata(new BaseCallback<Bean_Wechat>() {
                @Override
                public void OnSuccess(Bean_Wechat bean_wechat) {
                    if (Myview!=null){
                        Myview.OnSuccess(bean_wechat);
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
