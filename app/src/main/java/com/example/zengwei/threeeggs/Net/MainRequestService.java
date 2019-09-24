package com.example.zengwei.threeeggs.Net;

import com.example.z_common.Model.AllDataState;
import com.example.z_common.Model.Token;
import com.example.zengwei.threeeggs.Model.ApkUpdate;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**主model的一些网络请求**/
public interface MainRequestService {
    /**
     * 更新接口
     */
    @FormUrlEncoded
    @POST("apk/detection")
    Observable<AllDataState<ApkUpdate>> ApkDetection(@Field("version")int version);  /**apk更新接口**/

    /**
     * token接口
     */
    @FormUrlEncoded
    @POST("devices/token")
    Observable<AllDataState<Token>> Token(@Field("systemName")String systemName,   //系统名称
                                          @Field("operator")String operator,       //运行商
                                          @Field("seriesNumber")String seriesNumber,   //序列号
                                          @Field("wlan")String wlan,            //无线局域网地址
                                          @Field("bluetooth")String bluetooth,  //蓝牙
                                          @Field("imei")String imei,           //手机imei
                                          @Field("iccid")String iccid,          //手机iccid
                                          @Field("meid")String meid);          //手机meid

    @Streaming //添加这个注解用来下载大文件
    @GET()
    Observable<ResponseBody> downloadFileUrl(@Url String fileUrl);
}
