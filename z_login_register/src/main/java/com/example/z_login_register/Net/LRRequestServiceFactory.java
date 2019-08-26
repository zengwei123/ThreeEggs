package com.example.z_login_register.Net;

import com.example.z_base.BaseActivity;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.NET.RetrofitServiceManager;
import com.example.z_common.SimpleUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zengwei on 2019/8/17.
 */

public class LRRequestServiceFactory {
    private static LRRequestService lrRequestService = RetrofitServiceManager.getInstance().create(LRRequestService.class);
    /**
     * 短信验证码
     */
    public static void  validateCode(RequestObserver.RequestObserverNext requestObserverNext,String Phone){
        Observable observable= lrRequestService.validateCode(SimpleUtils.getToken(BaseActivity.getInstance()),Phone);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState>(requestObserverNext){});
    }

    /**
     * 登录
     */
    public static void  login(RequestObserver.RequestObserverNext requestObserverNext,String Phone,String code,String qqOpenId,String weixinOpenId){
        Observable observable= lrRequestService.login(SimpleUtils.getToken(BaseActivity.getInstance()),Phone,code,qqOpenId,weixinOpenId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState>(requestObserverNext){});
    }

    /**
     * 短信验证码
     */
    public static void  qqLogin(RequestObserver.RequestObserverNext requestObserverNext,String openId){
        Observable observable= lrRequestService.qqLogin(SimpleUtils.getToken(BaseActivity.getInstance()),openId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState>(requestObserverNext){});
    }

}
