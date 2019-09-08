package com.example.z_home.Net;

import android.content.Context;

import com.example.z_base.BaseActivity;
import com.example.z_common.Custom.Dialog.LottieDialog;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.NET.RetrofitServiceManager;
import com.example.z_common.SimpleUtils;
import com.example.z_goods.Model.GoodsModel;
import com.example.z_home.Model.HomeHead;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zengwei on 2019/8/4.
 */

public class HomeRequestServiceFactory {
    private static HomeRequestService homeRequestService = RetrofitServiceManager.getInstance().create(HomeRequestService.class);

    /**
     * 首页分类的数据解析
     */
    public static void  CategoryFind(RequestObserver.RequestObserverNext requestObserverNext, Context context){
        LottieDialog.setDialogWindow(context);
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
                .subscribe(new RequestObserver<AllDataState<HomeHead>>(requestObserverNext){});
    }




}
