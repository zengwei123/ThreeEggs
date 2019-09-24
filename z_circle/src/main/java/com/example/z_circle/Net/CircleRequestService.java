package com.example.z_circle.Net;

import com.example.z_circle.Model.CircleComment;
import com.example.z_circle.Model.CircleDetails;
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


    /**圈子详情内容**/
    @FormUrlEncoded
    @POST("round/detail")
    Observable<AllDataState<CircleDetails>> Detail(@Field("devicesToken") String devicesToken, @Field("roundId")String roundId);

    /**圈子评论**/
    @FormUrlEncoded
    @POST("round/comment/list")
    Observable<AllDataState<CircleComment>> Comment(@Field("devicesToken") String devicesToken,
                                                    @Field("roundId")String roundId,
                                                    @Field("commentId")String comment_id ,
                                                    @Field("pageNum")String pageNum,
                                                    @Field("pageSize")String pageSize);

    /**圈子详情中的推荐**/
    @FormUrlEncoded
    @POST("round/recommend")
    Observable<AllDataState<CircleModel>> Recommend(@Field("devicesToken") String devicesToken,@Field("labelId") String labelId,
                                                   @Field("pageNum") String current, @Field("pageSize") String pageSize);


    /**圈子文章点赞**/
    @FormUrlEncoded
    @POST("round/like")
    Observable<AllDataState> Like(@Field("devicesToken") String devicesToken, @Field("roundId") String roundId);

    /**圈子文章收藏**/
    @FormUrlEncoded
    @POST("round/collect")
    Observable<AllDataState> Collect(@Field("devicesToken") String devicesToken, @Field("roundId") String roundId);

    /**圈子文章收藏**/
    @FormUrlEncoded
    @POST("round/comment/like")
    Observable<AllDataState> Comment_Like(@Field("devicesToken") String devicesToken, @Field("commentId") String commentId);


    /**圈子文章评论**/
    @FormUrlEncoded
    @POST("round/comment/save")
    Observable<AllDataState> Comment_Save(@Field("devicesToken") String devicesToken,
                                          @Field("content") String content,
                                          @Field("roundId") String roundId,
                                          @Field("commentId")String commentId);

}
