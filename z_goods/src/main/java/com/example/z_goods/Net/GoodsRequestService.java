package com.example.z_goods.Net;

import com.example.z_common.Model.AllDataState;
import com.example.z_goods.Model.GoodsModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zengwei on 2019/8/4.
 */

public interface GoodsRequestService {

    /**首页新品首发**/
    @FormUrlEncoded
    @POST("item/search")
    Observable<AllDataState<GoodsModel>> HomeItemGoods(@Field("devicesToken") String pid, @Field("pageNum") int pageNum, @Field("pageNum") int pageSize);
}
