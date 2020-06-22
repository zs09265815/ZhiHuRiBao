package com.example.zhihuribao.model;

import com.example.zhihuribao.base.BaseCallback;
import com.example.zhihuribao.base.BaseModel;
import com.example.zhihuribao.bean.Bean_ReMen;
import com.example.zhihuribao.bean.Bean_Zhihu;
import com.example.zhihuribao.net.BaseObserver;
import com.example.zhihuribao.net.HttpUtils;
import com.example.zhihuribao.net.MyServse;
import com.example.zhihuribao.net.RxUtil;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class ReMenM extends BaseModel {
    public void getdata(final BaseCallback<Bean_ReMen> callback){
         MyServse apiServse = HttpUtils.getHttpUtils().getApiServse(MyServse.url3, MyServse.class);
        Observable<Bean_ReMen> geturl = apiServse.getremen();
        geturl.compose(RxUtil.<Bean_ReMen>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Bean_ReMen>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Bean_ReMen bean_reMen) {
                    callback.OnSuccess(bean_reMen);
                    }
                });
}
}