package com.example.zhihu.model;

import com.example.zhihu.base.BaseCallback;
import com.example.zhihu.base.BaseModel;
import com.example.zhihu.bean.Bean_ReMen;
import com.example.zhihu.net.BaseObserver;
import com.example.zhihu.net.HttpUtils;
import com.example.zhihu.net.MyServse;
import com.example.zhihu.net.RxUtil;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class HotM extends BaseModel {
    public void  getdata(final BaseCallback<Bean_ReMen> callback){
        final MyServse apiServse = HttpUtils.getHttpUtils().getApiServse(MyServse.url3, MyServse.class);
        final Observable<Bean_ReMen> getremen = apiServse.getremen();
        getremen.compose(RxUtil.<Bean_ReMen>rxObserableSchedulerHelper())
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
