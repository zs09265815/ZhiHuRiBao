package com.example.zhihu.view;

import com.example.zhihu.base.BaseView;
import com.example.zhihu.bean.Bean_ZhuanLan;

public interface ZhuanV extends BaseView {
    void OnSuccess(Bean_ZhuanLan bean_zhuanLan);

    void OnFaile(String msg);
}
