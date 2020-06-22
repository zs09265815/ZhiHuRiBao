package com.example.zhihu.net;

import android.util.Log;

import com.example.zhihu.util.ToastUtil;

import io.reactivex.Observer;

/**
 * Created by $lzj on 2019/5/6.
 */
public abstract class BaseObserver<T> implements Observer<T> {

    private final String TAG = getClass().getName();

    @Override
    public void onComplete() {
        Log.e(TAG,"onComplete");
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG,"onError:" + e.getMessage());
        ToastUtil.showShort("数据加载失败:" + e.getMessage());
    }
}
