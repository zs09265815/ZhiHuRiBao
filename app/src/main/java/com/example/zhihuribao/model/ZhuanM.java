package com.example.zhihuribao.model;

import com.example.zhihuribao.base.BaseCallback;
import com.example.zhihuribao.base.BaseModel;
import com.example.zhihuribao.bean.Bean_Zhihu;
import com.example.zhihuribao.bean.Bean_ZhuanLan;
import com.example.zhihuribao.net.BaseObserver;
import com.example.zhihuribao.net.HttpUtils;
import com.example.zhihuribao.net.MyServse;
import com.example.zhihuribao.net.RxUtil;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class ZhuanM extends BaseModel {
    public void getdata(final BaseCallback<Bean_ZhuanLan> callback){
         MyServse apiServse = HttpUtils.getHttpUtils().getApiServse(MyServse.url4, MyServse.class);
        Observable<Bean_ZhuanLan> geturl = apiServse.getzhaunlan();
        geturl.compose(RxUtil.<Bean_ZhuanLan>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Bean_ZhuanLan>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Bean_ZhuanLan bean_zhuanLan) {
                    callback.OnSuccess(bean_zhuanLan);
                    }
                });
    }
}
