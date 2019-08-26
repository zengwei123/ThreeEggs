package com.example.zengwei.threeeggs;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_common.CommonRequestServiceFactory;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.SharedPreferencesHelper;
import com.example.z_common.SimpleUtils;
import com.example.z_common.Model.Token;
import com.tencent.tauth.Tencent;

import io.reactivex.disposables.Disposable;

public class ThreeEggsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        /**弟弟行为 为大哥提供方便**/
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this);
        /**获取Token**/
        if (SimpleUtils.getToken(getApplicationContext())==null||SimpleUtils.getToken(getApplicationContext()).equals("")){
            MainRequestServiceFactory.Token(new RequestObserver.RequestObserverNext<AllDataState<Token>>() {
                @Override
                public void Next(AllDataState<Token> o) {
                    if (o.isSuccess()) {
                        new SharedPreferencesHelper(getApplicationContext(),"TOKEN").putBase64("key",o.getData());
                    }else {
                        SimpleUtils.setLog("看看错误"+o.getMessage());
                    }
                }
                @Override
                public void onError() {
                }
                @Override
                public void getDisposable(Disposable d) {

                }
            });
        }
        CommonRequestServiceFactory.checkLogin(new RequestObserver.RequestObserverNext<AllDataState>() {
            @Override
            public void Next(AllDataState o) {
                SimpleUtils.setLog("看看token:"+SimpleUtils.getToken(getApplicationContext())+"---"+o.isSuccess());
                new SharedPreferencesHelper(getApplicationContext(),"TOKEN").put("ISLogin",o.isSuccess());
            }

            @Override
            public void onError() {

            }

            @Override
            public void getDisposable(Disposable d) {

            }
        },getApplicationContext());
    }
}
