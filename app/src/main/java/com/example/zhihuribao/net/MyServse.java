package com.example.zhihuribao.net;

import com.example.zhihuribao.bean.Bean_ReMen;
import com.example.zhihuribao.bean.Bean_Zhihu;
import com.example.zhihuribao.bean.Bean_ZhuanLan;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServse {
    public String url="http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<Bean_Zhihu> geturl();

    public String url3="http://news-at.zhihu.com/api/4/";
    @GET("sections")
    Observable<Bean_ZhuanLan> getzhaunlan();

    public String url4="http://news-at.zhihu.com/api/4/";
    @GET("news/hot")
    Observable<Bean_ReMen> getremen();

}
