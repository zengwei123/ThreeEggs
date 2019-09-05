package com.example.z_goods.Net;

import com.example.z_base.BaseActivity;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.NET.RetrofitServiceManager;
import com.example.z_common.SimpleUtils;
import com.example.z_goods.Model.GoodsModel;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zengwei on 2019/8/4.
 */

public class GoodsRequestServiceFactory {
    private static GoodsRequestService homeRequestService = RetrofitServiceManager.getInstance().create(GoodsRequestService.class);

    /**
     * 首页新品
     */
    public static void  HomeItemGoods(RequestObserver.RequestObserverNext requestObserverNext,int pageNum ){
        Observable observable= homeRequestService.HomeItemGoods(SimpleUtils.getToken(BaseActivity.getInstance()),pageNum,10);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState<GoodsModel>>(requestObserverNext){});
    }



}