package com.example.zhihu.view;

import com.example.zhihu.base.BaseView;
import com.example.zhihu.bean.Bean_ReMen;
import com.example.zhihu.bean.Bean_V2ex;

public interface V2exV extends BaseView {

    void OnSuccess(Bean_V2ex bean_v2ex);

    void OnFaile(String msg);
}

