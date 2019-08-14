package com.example.zengwei.threeeggs;

import com.example.z_common.Custom.Dialog.DialogUtil;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.NET.RetrofitServiceManager;
import com.example.z_common.SimpleUtils;

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
                .subscribe(new RequestObserver<AllDataState>(){
                    @Override
                    public void onNext(AllDataState o) {
                        if (o.isSuccess()){
                            new DialogUtil().show(R.mipmap.prompt,"发现新版本，是否现在更新","更新", new DialogUtil.DialogButtonListener(){

                                @Override
                                public void sure() {
                                    SimpleUtils.setToast("开始跟新");
                                }

                                @Override
                                public void cancel() {

                                }
                            });
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
