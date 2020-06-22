package com.example.zhihuribao.base;

public interface BaseCallback<T> {
    void OnSuccess(T t);
    void OnFaile(String msg);
}
