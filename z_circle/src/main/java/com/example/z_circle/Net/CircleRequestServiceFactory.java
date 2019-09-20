package com.example.z_circle.Net;

import android.content.Context;

import com.example.z_base.BaseActivity;
import com.example.z_circle.Model.CircleComment;
import com.example.z_circle.Model.CircleDetails;
import com.example.z_circle.Model.CircleHome;
import com.example.z_circle.Model.CircleModel;
import com.example.z_common.Custom.Dialog.LottieDialog;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.NET.RetrofitServiceManager;
import com.example.z_common.Util.SimpleUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Field;

/**
 * Created by zengwei on 2019/8/4.
 */

public class CircleRequestServiceFactory {
    private static CircleRequestService homeRequestService = RetrofitServiceManager.getInstance().create(CircleRequestService.class);

    /**
     * 首页穿搭推荐
     */
    public static void  HomeItemCircle(RequestObserver.RequestObserverNext requestObserverNext, Context context, int pageNum ,int pagesize,String labelId ){
        LottieDialog.setDialogWindow(context);
        Observable observable= homeRequestService.HomeItemCircle(SimpleUtils.getToken(BaseActivity.getInstance()),labelId,100000000,pageNum,pagesize);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState<CircleModel>>(requestObserverNext){});
    }

    /**
     * 圈子的轮播和分类列表
     */
    public static void  Roundhome(RequestObserver.RequestObserverNext requestObserverNext, Context context ){
        LottieDialog.setDialogWindow(context);
        Observable observable= homeRequestService.RoundHome(SimpleUtils.getToken(BaseActivity.getInstance()));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState<CircleHome>>(requestObserverNext){});
    }

    /**
     * 圈子内容的详情
     */
    public static void  Detail(RequestObserver.RequestObserverNext requestObserverNext, Context context,String roundId){
        LottieDialog.setDialogWindow(context);
        Observable observable= homeRequestService.Detail(SimpleUtils.getToken(BaseActivity.getInstance()),roundId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState<CircleDetails>>(requestObserverNext){});
    }

    /**
     * 圈子评论
     */
    public static void  Comment(RequestObserver.RequestObserverNext requestObserverNext,
                                Context context,String roundId, String pageNum, String pageSize){
        LottieDialog.setDialogWindow(context);
        Observable observable= homeRequestService.Comment(SimpleUtils.getToken(BaseActivity.getInstance()),roundId,pageNum,pageSize);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState<CircleComment>>(requestObserverNext){});
    }


}
