package com.example.z_login_register.Net;

import com.example.z_common.Model.AllDataState;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zengwei on 2019/8/17.
 */

public interface LRRequestService {
    /**
     * 短信登陆接口
     */
    @FormUrlEncoded
    @POST("validateCode")
    Observable<AllDataState> validateCode(@Field("devicesToken")String devicesToken, @Field("phone")String phone);

    /**
     * 短信登陆接口
     */
    @FormUrlEncoded
    @POST("login")
    Observable<AllDataState> login(@Field("devicesToken")String devicesToken,
                                   @Field("phone")String phone,
                                   @Field("validateCode") String validateCode,
                                   @Field("qqOpenId")String qqOpenId,
                                   @Field("weixinOpenId")String weixinOpenId);

    /**
     * QQ登陆接口 绑定
     */
    @FormUrlEncoded
    @POST("qqLogin")
    Observable<AllDataState> qqLogin(@Field("devicesToken")String devicesToken, @Field("openId")String openId);
}
