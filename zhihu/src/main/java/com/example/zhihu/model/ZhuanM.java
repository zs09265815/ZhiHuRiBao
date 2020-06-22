package com.example.zhihu.model;

import com.example.zhihu.base.BaseCallback;
import com.example.zhihu.base.BaseModel;
import com.example.zhihu.bean.Bean_ZhuanLan;
import com.example.zhihu.net.BaseObserver;
import com.example.zhihu.net.HttpUtils;
import com.example.zhihu.net.MyServse;
import com.example.zhihu.net.RxUtil;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ZhuanM extends BaseModel {
    public void getdata(final BaseCallback<Bean_ZhuanLan> callback){
         MyServse apiServse = HttpUtils.getHttpUtils().getApiServse(MyServse.url2, MyServse.class);
         Observable<Bean_ZhuanLan> getzhaunlan = apiServse.getzhaunlan();
        getzhaunlan.compose(RxUtil.<Bean_ZhuanLan>rxObserableSchedulerHelper())
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
