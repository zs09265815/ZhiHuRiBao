package com.example.zhihuribao.model;

import com.example.zhihuribao.base.BaseCallback;
import com.example.zhihuribao.base.BaseModel;
import com.example.zhihuribao.bean.Bean_Zhihu;
import com.example.zhihuribao.net.BaseObserver;
import com.example.zhihuribao.net.HttpUtils;
import com.example.zhihuribao.net.MyServse;
import com.example.zhihuribao.net.RxUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public  class InfoM extends BaseModel {
    public void getdata(final BaseCallback<Bean_Zhihu> callback){
        MyServse apiServse = HttpUtils.getHttpUtils().getApiServse(MyServse.url,MyServse.class);
         Observable<Bean_Zhihu> geturl = apiServse.geturl();
         geturl.compose(RxUtil.<Bean_Zhihu>rxObserableSchedulerHelper())
                 .subscribe(new BaseObserver<Bean_Zhihu>() {
                     @Override
                     public void onSubscribe(Disposable d) {
                         compositeDisposable.add(d);
                     }

                     @Override
                     public void onNext(Bean_Zhihu bean_zhihu) {
                    callback.OnSuccess(bean_zhihu);
                     }
                 });
    }
}
