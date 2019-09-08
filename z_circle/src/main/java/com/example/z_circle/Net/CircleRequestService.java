package com.example.z_circle.Net;

import com.example.z_circle.Model.CircleModel;
import com.example.z_common.Model.AllDataState;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zengwei on 2019/8/4.
 */

public interface CircleRequestService {

    /**首页新品首发**/
    @FormUrlEncoded
    @POST("round/search")
    Observable<AllDataState<CircleModel>> HomeItemCircle(@Field("devicesToken") String devicesToken,
                                                        @Field("labelId") String labelId,
                                                        @Field("distance") Integer distance,
                                                        @Field("pageNum") int pageNum,
                                                        @Field("pageSize") int pageSize);




//    /**搜索商品列表**/
//    @FormUrlEncoded
//    @POST("item/search")
//    Observable<AllDataState<GoodsModel>> setSearchGoodsPage(@Field("devicesToken") String devicesToken,
//                                                            @Field("type") String type,   //查询类型
//                                                            @Field("keyword") String keyword,   //关键字
//                                                            @Field("distance") String distance,  //查询距离
//                                                            @Field("minPrice") String minPrice,  //最小价格
//                                                            @Field("maxPrice") String maxPrice,  //最大价格
//                                                            @Field("brandName") String brandName,  //品牌
//                                                            @Field("itemCategoryId") String itemCategoryId,  //分类id
//                                                            @Field("categoryName") String categoryName,  //多个分类
//                                                            @Field("pageNum") String pageNum,  //查询页码
//                                                            @Field("pageSize") String pageSize);
}
