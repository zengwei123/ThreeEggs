package com.example.zengwei.threeeggs;

import android.app.Activity;

import com.example.z_base.BaseView;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RetrofitServiceManager;
import com.example.z_common.SimpleUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainRequestServiceFactory {
    private static MainRequestService mainRequestService = RetrofitServiceManager.getInstance().create(MainRequestService.class);
    /**这个鸡儿事用来判断apk是否需要更新**/
    public static void  ApkDetection(BaseView baseView){
        Observable observable= mainRequestService.ApkDetection(SimpleUtils.getAppVersion(baseView.getActivityContext()));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<AllDataState>) o -> SimpleUtils.setLog(o.getMessage()));
    }
}
