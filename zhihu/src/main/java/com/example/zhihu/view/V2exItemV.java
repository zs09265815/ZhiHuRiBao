package com.example.zhihu.view;

import com.example.zhihu.base.BaseView;
import com.example.zhihu.bean.Bean_V2ItemBean;
import com.example.zhihu.bean.Gold_all;

import java.util.ArrayList;

public interface V2exItemV extends BaseView {

    void OnSuccess(ArrayList<Bean_V2ItemBean> bean_v2ItemBeans);

    void OnFaile(String msg);
}
