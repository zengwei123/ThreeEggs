package com.example.zengwei.threeeggs;

import com.example.z_common.Model.AllDataState;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**主model的一些网络请求**/
public interface MainRequestService {
    /**
     * 更新接口
     */
    @FormUrlEncoded
    @POST("apk/detection")
    Observable<AllDataState> ApkDetection(@Field("version")String version);  /**apk更新接口**/
}
