package com.example.zuoye2.api;


import com.example.zuoye2.bean.Gold_all;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyServse {

    public String url5="http://gank.io/api/search/query/{搜索字段}/category/";
    @GET("{name}/count/10/page/1")
    Observable<Gold_all> getgold(@Path("name") String name);
}
