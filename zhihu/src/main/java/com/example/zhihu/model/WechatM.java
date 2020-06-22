package com.example.zhihu.model;

import com.example.zhihu.base.BaseCallback;
import com.example.zhihu.base.BaseModel;
import com.example.zhihu.bean.Bean_ReMen;
import com.example.zhihu.bean.Bean_Wechat;
import com.example.zhihu.net.BaseObserver;
import com.example.zhihu.net.HttpUtils;
import com.example.zhihu.net.MyServse;
import com.example.zhihu.net.RxUtil;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class WechatM extends BaseModel {
    public void getdata(final BaseCallback<Bean_Wechat> callback){
        final MyServse apiServse = HttpUtils.getHttpUtils().getApiServse(MyServse.url4, MyServse.class);
        final Observable<Bean_Wechat> getwechat = apiServse.getwechat();
        getwechat.compose(RxUtil.<Bean_Wechat>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Bean_Wechat>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Bean_Wechat bean_wechat) {
                        callback.OnSuccess(bean_wechat);

                    }
                });

    }
}
