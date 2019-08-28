package com.example.z_base;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by zengwei on 2018/8/22.
 */

public abstract class BasePresenter<V> {
    public V mvpView;
    public List<Disposable> disposables=new ArrayList<>();

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    public void detachView() {
        this.mvpView = null;
    }
    public abstract void init();
    public abstract void setView();
    public void CloseRequest(){
        for (Disposable disposable:disposables){
            disposable.dispose();
        }
    }
}