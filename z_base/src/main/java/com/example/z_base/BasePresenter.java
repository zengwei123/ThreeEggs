package com.example.z_base;

/**
 * Created by zengwei on 2018/8/22.
 */

public abstract class BasePresenter<V> {
    public V mvpView;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    public void detachView() {
        this.mvpView = null;
    }
    public abstract void init();
    public abstract void setView();
    public abstract void CloseRequest();
}