package com.example.zuoye2.model;

import com.example.zuoye2.api.MyServse;
import com.example.zuoye2.bean.Gold_all;
import com.example.zuoye2.callback.CallBackk;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Mymodelim implements Mymodel{
    @Override
    public void getdata(String name, final CallBackk callBackk) {
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(MyServse.url5)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final MyServse servse = retrofit.create(MyServse.class);
        final Observable<Gold_all> getgold = servse.getgold(name);
        getgold.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Gold_all>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Gold_all gold_all) {
                        callBackk.OnSuccess(gold_all);

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBackk.OnFaile(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
