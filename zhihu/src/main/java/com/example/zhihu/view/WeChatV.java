package com.example.zhihu.view;

import com.example.zhihu.base.BaseView;
import com.example.zhihu.bean.Bean_ReMen;
import com.example.zhihu.bean.Bean_Wechat;

public interface WeChatV extends BaseView {
    void OnSuccess(Bean_Wechat bean_wechat);

    void OnFaile(String msg);
}
