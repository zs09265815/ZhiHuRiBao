package com.example.zhihuribao.view;

import com.example.zhihuribao.base.Baseview;
import com.example.zhihuribao.bean.Bean_ReMen;

public interface ReMenV extends Baseview {
    void OnSuccess(Bean_ReMen bean_reMen);

    void OnFaile(String msg);
}
