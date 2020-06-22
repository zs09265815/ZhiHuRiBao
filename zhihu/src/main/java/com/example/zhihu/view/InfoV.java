package com.example.zhihu.view;

import com.example.zhihu.base.BaseView;
import com.example.zhihu.bean.Bean_Zhihu;

public interface InfoV extends BaseView {
    void OnSuccess(Bean_Zhihu bean_zhihu);

    void OnFaile(String msg);
}
