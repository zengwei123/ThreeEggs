package com.example.z_circle.Net;

import com.example.z_circle.Model.CircleHome;
import com.example.z_circle.Model.CircleModel;
import com.example.z_common.Model.AllDataState;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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

    /**圈子轮播图和下面的分类列表图**/
    @GET("round/home")
    Observable<AllDataState<CircleHome>> RoundHome(@Query("devicesToken") String devicesToken);


}
