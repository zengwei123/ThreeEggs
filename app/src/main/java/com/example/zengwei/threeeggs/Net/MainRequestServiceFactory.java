package com.example.zengwei.threeeggs.Net;

import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.NET.RetrofitServiceManager;
import com.example.z_common.Util.DownloadUtil;
import com.example.z_common.Util.SimpleUtils;
import com.example.zengwei.threeeggs.Model.ApkUpdate;
import com.example.zengwei.threeeggs.TOKEnUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainRequestServiceFactory {
    private static MainRequestService mainRequestService = RetrofitServiceManager.getInstance().create(MainRequestService.class);
    /**这个鸡儿事用来判断apk是否需要更新**/

    public static void  ApkDetection(){
        Observable observable= mainRequestService.ApkDetection(SimpleUtils.getAppVersion());
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState<ApkUpdate>>(){
                    @Override
                    public void onNext(AllDataState<ApkUpdate> o) {
                        if (o.isSuccess()){
                            DownloadUtil.isUpdate(o.getData().getApkUpdate().getApkDownloadUrl());
                        }
                    }
                });
    }
    /**获取用token**/
    public static void  Token(RequestObserver.RequestObserverNext requestObserverNext){
        Observable observable= mainRequestService.Token(
                TOKEnUtil.getsystemName(),
                TOKEnUtil.getoperator(),
                TOKEnUtil.getseriesNumber(),
                TOKEnUtil.getwlan(),
                TOKEnUtil.getbluetooth(),
                TOKEnUtil.getimei(),
                TOKEnUtil.geticcid(),
                TOKEnUtil.getmeid());
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState>(requestObserverNext){});
    }
}
