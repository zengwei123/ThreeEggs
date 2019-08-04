package com.example.z_home.Net;

import com.example.z_common.Model.AllDataState;
import com.example.z_home.Model.CategoryList;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zengwei on 2019/8/4.
 */

public interface HomeRequestService {
    /**
     * 分类获取接口
     */
    @FormUrlEncoded
    @POST("item/category/find")
    Observable<AllDataState<CategoryList>> CategoryFind(@Field("pid")String pid, @Field("stratum")boolean stratum);
}
