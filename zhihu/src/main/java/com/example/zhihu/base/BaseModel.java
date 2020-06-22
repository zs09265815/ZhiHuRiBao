package com.example.zhihu.base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseModel {
    protected CompositeDisposable compositeDisposable=new CompositeDisposable();
    public void destory(){
        compositeDisposable.clear();
    }
}
