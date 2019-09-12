package com.example.z_circle.Net;

import android.content.Context;

import com.example.z_base.BaseActivity;
import com.example.z_circle.Model.CircleModel;
import com.example.z_common.Custom.Dialog.LottieDialog;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.NET.RetrofitServiceManager;
import com.example.z_common.Util.SimpleUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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



//    /**
//     * 搜索商品
//     */
//    public static void  setSearchGoodsPage(RequestObserver.RequestObserverNext requestObserverNext,
//                                           Context context,
//                                           String type,   //查询类型
//                                           String keyword,   //关键字
//                                           String distance,  //查询距离
//                                           String minPrice,  //最小价格
//                                           String maxPrice,  //最大价格
//                                           String brandName,  //品牌
//                                           String itemCategoryId,  //分类id
//                                           String categoryName,  //多个分类
//                                           String pageNum){  //查询页码
//        LottieDialog.setDialogWindow(context);
//        Observable observable= homeRequestService.setSearchGoodsPage(SimpleUtils.getToken(BaseActivity.getInstance())
//                ,type,keyword,distance,minPrice,maxPrice,brandName,itemCategoryId,categoryName,pageNum,10+"");
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new RequestObserver<AllDataState<GoodsModel>>(requestObserverNext){});
//    }

}
