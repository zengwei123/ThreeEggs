package com.example.z_goods.Net;

import android.content.Context;

import com.example.z_base.BaseActivity;
import com.example.z_common.Custom.Dialog.LottieDialog;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.NET.RetrofitServiceManager;
import com.example.z_common.SimpleUtils;
import com.example.z_goods.Model.GoodsModel;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Field;

/**
 * Created by zengwei on 2019/8/4.
 */

public class GoodsRequestServiceFactory {
    private static GoodsRequestService homeRequestService = RetrofitServiceManager.getInstance().create(GoodsRequestService.class);

    /**
     * 首页新品
     */
    public static void  HomeItemGoods(RequestObserver.RequestObserverNext requestObserverNext, Context context, int pageNum ){
        LottieDialog.setDialogWindow(context);
        Observable observable= homeRequestService.HomeItemGoods(SimpleUtils.getToken(BaseActivity.getInstance()),100000000,pageNum,10);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState<GoodsModel>>(requestObserverNext){});
    }

    /**
     * 搜索商品
     */
    public static void  setSearchGoodsPage(RequestObserver.RequestObserverNext requestObserverNext,
                                           Context context,
                                           String type,   //查询类型
                                           String keyword,   //关键字
                                           String distance,  //查询距离
                                           String minPrice,  //最小价格
                                           String maxPrice,  //最大价格
                                            String brandName,  //品牌
                                           String itemCategoryId,  //分类id
                                            String categoryName,  //多个分类
                                           String pageNum){  //查询页码

        LottieDialog.setDialogWindow(context);
        Observable observable= homeRequestService.setSearchGoodsPage(SimpleUtils.getToken(BaseActivity.getInstance())
                ,type,keyword,distance,minPrice,maxPrice,brandName,itemCategoryId,categoryName,pageNum,10+"");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState<GoodsModel>>(requestObserverNext){});
    }

}
