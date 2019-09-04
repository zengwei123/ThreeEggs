package com.example.z_common;

import com.example.z_common.Model.AllDataState;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**主model的一些网络请求**/
public interface CommonRequestService {
    /**
     * 设备定位接口
     */
    @FormUrlEncoded
    @POST("devices/orientation")
    Observable<AllDataState> orientation(@Field("devicesToken") String devicesToken,
                                         @Field("longitude") String longitude,
                                         @Field("latitude") String latitude,
                                         @Field("cityCode") String cityCode,
                                         @Field("cityName") String cityName,
                                         @Field("address") String address);


    /**
     * 设备定位接口
     */
    @FormUrlEncoded
    @POST("checkLogin")
    Observable<AllDataState> checkLogin(@Field("devicesToken") String devicesToken);


    /**
     * 啊  这个是退出登录哟
     */
    @FormUrlEncoded
    @POST("logout")
    Observable<AllDataState> logout(@Field("devicesToken") String devicesToken);

}
