package com.example.zhihu.view;

import com.example.zhihu.base.BaseView;
import com.example.zhihu.bean.Bean_ReMen;
import com.example.zhihu.bean.Bean_v2Tab;

import java.util.ArrayList;

public interface V2exTabV extends BaseView {

    void OnFaile(String msg);

    void OnSuccess(ArrayList<Bean_v2Tab> bean_v2Tab);
}
