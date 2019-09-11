package com.example.zengwei.threeeggs;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;

import com.example.z_base.BaseActivity;
import com.example.z_common.Custom.Dialog.DialogUtil;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.NET.RetrofitServiceManager;
import com.example.z_common.SimpleUtils;
import com.example.zengwei.threeeggs.Model.ApkUpdate;

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
                            new DialogUtil().show(R.mipmap.prompt,"发现新版本，是否现在更新","更新", new DialogUtil.DialogButtonListener(){

                                @Override
                                public void sure() {
                                    SimpleUtils.setToast("开始跟新");
                                    //创建下载任务,downloadUrl就是下载链接
                                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(o.getData().getApkDownloadUrl()));
                                    //指定下载路径和下载文件名
                                    request.setDestinationInExternalPublicDir("/download/", "zw.apk");
                                    //获取下载管理器
                                    DownloadManager downloadManager= (DownloadManager) BaseActivity.getInstance().getSystemService(Context.DOWNLOAD_SERVICE);
                                    //将下载任务加入下载队列，否则不会进行下载
                                    downloadManager.enqueue(request);
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
