package com.example.z_home.Net;

import android.app.Activity;

import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.NET.RetrofitServiceManager;
import com.example.z_home.Category.CategoryActivity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zengwei on 2019/8/4.
 */

public class HomeRequestServiceFactory {
    private static HomeRequestService homeRequestService = RetrofitServiceManager.getInstance().create(HomeRequestService.class);

    /**
     * 首页分类的数据解析
     */
    public static void  CategoryFind(RequestObserver.RequestObserverNext requestObserverNext){
        Observable observable= homeRequestService.CategoryFind("0",true);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState>(requestObserverNext){});
    }

    /**
     * 首页分类的数据解析
     */
    public static void  HomeHead(RequestObserver.RequestObserverNext requestObserverNext){
        Observable observable= homeRequestService.HomeHead();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState>(requestObserverNext){});
    }
}
