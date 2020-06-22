package com.example.zhihuribao.view;

import com.example.zhihuribao.base.Baseview;
import com.example.zhihuribao.bean.Bean_ZhuanLan;

public interface ZhuanLanV extends Baseview {

    void OnSuccess(Bean_ZhuanLan bean_zhuanLan);

    void OnFaile(String msg);
}
