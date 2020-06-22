package com.example.zhihu.view;

import com.example.zhihu.base.BaseView;
import com.example.zhihu.bean.Bean_ReMen;
import com.example.zhihu.bean.Bean_Zhihu;

public interface HotV extends BaseView {
    void OnSuccess(Bean_ReMen bean_reMen);

    void OnFaile(String msg);
}
