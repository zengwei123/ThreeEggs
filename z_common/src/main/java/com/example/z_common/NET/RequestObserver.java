package com.example.z_common.NET;

import com.example.z_common.Custom.Dialog.LottieDialog;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zengwei on 2019/8/3.
 * 封装接口的调用
 */

public abstract class RequestObserver<T> implements Observer<T> {

    public RequestObserver(){
        /**网络请求dialog 打开**/
        if (LottieDialog.getDialog()!=null){
            LottieDialog.stopDialogView();
            LottieDialog.showDialogView();
        }
    }
    private RequestObserverNext next=null;
    public RequestObserver(RequestObserverNext requestObserverNext){
        if (LottieDialog.getDialog()!=null){
            LottieDialog.stopDialogView();
            LottieDialog.showDialogView();
        }
        next=requestObserverNext;
    }

    private Disposable d;
    @Override
    public void onSubscribe(Disposable d) {
        this.d=d;
        /**用来进行停止请求**/
        if (next!=null){
            next.getDisposable(d);
        }
    }

    @Override
    public void onNext(T  o) {
        /**如果有回调接口**/
        if (next!=null){
            next.Next(o);
        }
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        stopDisposable(false);
        SimpleUtils.setToast("网络错误");
        /**如果有回调接口**/
        if (next!=null){
            next.onError();
            e.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
        /**结束时候调用**/
        stopDisposable(true);
    }
    /**请求调用**/
    public void stopDisposable(boolean b){
        /**关闭网络请求**/
        if (LottieDialog.getDialog()!=null){
            LottieDialog.stopDialogView();
            LottieDialog.setDialog(null);
        }
        /**设置网络错误列表显示图片提示内容**/
        SimpleRecyclerViewAdapter.setIsNoNetWork(b);
        d.dispose();
    }

    /**回调接口**/
    public interface RequestObserverNext<T>{
        Disposable d = null;
        void Next(T  o);
        void onError();
        void getDisposable(Disposable d);
    }
}
