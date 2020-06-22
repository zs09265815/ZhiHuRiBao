package com.example.zhihu.model;

import com.example.zhihu.base.BaseCallback;
import com.example.zhihu.base.BaseModel;
import com.example.zhihu.bean.Bean_V2ex;
import com.example.zhihu.net.BaseObserver;
import com.example.zhihu.net.HttpUtils;
import com.example.zhihu.net.MyServse;
import com.example.zhihu.net.RxUtil;

import javax.security.auth.callback.Callback;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class V2exM extends BaseModel {
    public void getdata(final BaseCallback<Bean_V2ex> callback){
         MyServse apiServse = HttpUtils.getHttpUtils().getApiServse(MyServse.url6, MyServse.class);
         Observable<Bean_V2ex> bean_v2exObservable = apiServse.getv2ex();
        bean_v2exObservable.compose(RxUtil.<Bean_V2ex>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Bean_V2ex>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Bean_V2ex bean_v2ex) {
                        callback.OnSuccess(bean_v2ex);
                    }
                });
    }
}
