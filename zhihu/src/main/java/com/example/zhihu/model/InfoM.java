package com.example.zhihu.model;

import com.example.zhihu.base.BaseCallback;
import com.example.zhihu.base.BaseModel;
import com.example.zhihu.bean.Bean_Zhihu;
import com.example.zhihu.net.BaseObserver;
import com.example.zhihu.net.HttpUtils;
import com.example.zhihu.net.MyServse;
import com.example.zhihu.net.RxUtil;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class InfoM extends BaseModel {
    public void getdata(final BaseCallback<Bean_Zhihu> callback){
         MyServse apiServse = HttpUtils.getHttpUtils().getApiServse(MyServse.url, MyServse.class);
         Observable<Bean_Zhihu> getzhihu = apiServse.getzhihu();
        getzhihu.compose(RxUtil.<Bean_Zhihu>rxObserableSchedulerHelper())
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
