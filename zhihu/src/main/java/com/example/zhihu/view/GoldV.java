package com.example.zhihu.view;

import com.example.zhihu.base.BaseView;
import com.example.zhihu.bean.Bean_ReMen;
import com.example.zhihu.bean.Gold_all;

public interface GoldV extends BaseView {
    void OnSuccess(Gold_all gold_all);

    void OnFaile(String msg);
}
