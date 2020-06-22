package com.example.zhihuribao.view;

import com.example.zhihuribao.base.Baseview;
import com.example.zhihuribao.bean.Bean_Zhihu;

public interface InfoV extends Baseview {
    void OnSuccess(Bean_Zhihu bean_zhihu);

    void OnFaile(String msg);
}
