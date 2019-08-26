package com.example.z_common;

import android.content.Context;

import com.example.z_base.BaseActivity;
import com.example.z_common.Custom.Dialog.DialogUtil;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.Model.PositioningSuccessful;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.NET.RetrofitServiceManager;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CommonRequestServiceFactory {
    private static CommonRequestService commonRequestService = RetrofitServiceManager.getInstance().create(CommonRequestService.class);

    /**设备定位更新**/
    public static void  orientation(RequestObserver.RequestObserverNext requestObserverNext, PositioningSuccessful positioningSuccessful){
        if (positioningSuccessful!=null){
            Observable observable= commonRequestService.orientation(SimpleUtils.getToken(BaseActivity.getInstance()),
                    positioningSuccessful.getLongitude()+"",
                    positioningSuccessful.getLatitude()+"",
                    positioningSuccessful.getCityCode(),
                    positioningSuccessful.getCity(),
                    positioningSuccessful.getAddress());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new RequestObserver<AllDataState>(requestObserverNext){});
        }
    }

    /**设备定位更新**/
    public static void  checkLogin(RequestObserver.RequestObserverNext requestObserverNext, Context context){
            Observable observable= commonRequestService.checkLogin(SimpleUtils.getToken(context));
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new RequestObserver<AllDataState>(requestObserverNext){});
    }
}
