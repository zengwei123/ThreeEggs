package com.example.z_circle.Net;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseActivity;
import com.example.z_circle.Model.CircleComment;
import com.example.z_circle.Model.CircleDetails;
import com.example.z_circle.Model.CircleHome;
import com.example.z_circle.Model.CircleModel;
import com.example.z_circle.R;
import com.example.z_common.Custom.Dialog.LottieDialog;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.NET.RetrofitServiceManager;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.Util.GlideUtil;
import com.example.z_common.Util.SimpleUtils;
import com.example.z_common.Util.SnackbarUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zengwei on 2019/8/4.
 */

public class CircleRequestServiceFactory {
    private static CircleRequestService homeRequestService = RetrofitServiceManager.getInstance().create(CircleRequestService.class);

    /**
     * 首页穿搭推荐
     */
    public static void  HomeItemCircle(RequestObserver.RequestObserverNext requestObserverNext, Context context, int pageNum ,int pagesize,String labelId ){
        LottieDialog.setDialogWindow(context);
        Observable observable= homeRequestService.HomeItemCircle(SimpleUtils.getToken(BaseActivity.getInstance()),labelId,100000000,pageNum,pagesize);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState<CircleModel>>(requestObserverNext){});
    }

    /**
     * 圈子的轮播和分类列表
     */
    public static void  Roundhome(RequestObserver.RequestObserverNext requestObserverNext, Context context ){
        LottieDialog.setDialogWindow(context);
        Observable observable= homeRequestService.RoundHome(SimpleUtils.getToken(BaseActivity.getInstance()));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState<CircleHome>>(requestObserverNext){});
    }

    /**
     * 圈子内容的详情
     */
    public static void  Detail(RequestObserver.RequestObserverNext requestObserverNext, Context context,String roundId){
        LottieDialog.setDialogWindow(context);
        Observable observable= homeRequestService.Detail(SimpleUtils.getToken(BaseActivity.getInstance()),roundId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState<CircleDetails>>(requestObserverNext){});
    }

    /**
     * 圈子评论
     */
    public static void  Comment(RequestObserver.RequestObserverNext requestObserverNext,
                                Context context,String roundId, String comment_id ,String pageNum, String pageSize){
        LottieDialog.setDialogWindow(context);
        Observable observable= homeRequestService.Comment(SimpleUtils.getToken(BaseActivity.getInstance()),roundId,comment_id,pageNum,pageSize);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState<CircleComment>>(requestObserverNext){});
    }

    /**
     * 圈子详情推荐文章
     */
    public static void  Recommend(RequestObserver.RequestObserverNext requestObserverNext, Context context,String labelId,String current){
        LottieDialog.setDialogWindow(context);
        Observable observable= homeRequestService.Recommend(SimpleUtils.getToken(BaseActivity.getInstance()),labelId,current,10+"");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState<CircleModel>>(requestObserverNext){});
    }

    /**
     * 圈子详情点赞
     */
    public static void  Like(View view, String roundId, TextView textView){
        LottieDialog.setDialogWindow(null);
        Observable observable= homeRequestService.Like(SimpleUtils.getToken(BaseActivity.getInstance()),roundId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState>(){
                    @Override
                    public void onNext(AllDataState o) {
                        super.onNext(o);
                        int  id = R.mipmap.praise_9_icon;
                        if (o.getCode()==10003){
                            id = R.mipmap.praise_f_icon;
                            textView.setText((String) o.getData());
                            textView.setTextColor(Color.parseColor("#FD404E"));
                        }else if (o.getCode()==10004){
                            id = R.mipmap.praise_9_icon;
                            textView.setText((String) o.getData());
                            textView.setTextColor(Color.parseColor("#999999"));
                        }else if(o.getCode()==32006){
                            SnackbarUtil.IndefiniteSnackbar(view,o.getMessage(),3000,1).setAction("点击登录", v -> RoutePageActivity.getLRActivity()).show();
                        }
                        GlideUtil.drawableImage(40,id,textView,true);
                        SimpleUtils.setToast(o.getMessage());
                    }
                });
    }

    /**
     * 圈子详情收藏
     */
    public static void  Collect(View view, String roundId, TextView textView){
        LottieDialog.setDialogWindow(null);
        Observable observable= homeRequestService.Collect(SimpleUtils.getToken(BaseActivity.getInstance()),roundId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState>(){
                    @Override
                    public void onNext(AllDataState o) {
                        super.onNext(o);
                        int  id = R.mipmap.collection_9_icon;
                        if (o.getCode()==10001){
                            id = R.mipmap.collection_f_icon;
                            textView.setTextColor(Color.parseColor("#FD404E"));
                            textView.setText((String) o.getData());
                        }else if (o.getCode()==10002){
                            id = R.mipmap.collection_9_icon;
                            textView.setTextColor(Color.parseColor("#999999"));
                        }else if(o.getCode()==32006){
                            textView.setText((String) o.getData());
                            SnackbarUtil.IndefiniteSnackbar(view,"未登录，是否登录？",3000,1).setAction("点击登录", v -> RoutePageActivity.getLRActivity()).show();
                        }
                        GlideUtil.drawableImage(40,id,textView,true);
                        SimpleUtils.setToast(o.getMessage());
                    }
                });
    }

    /**
     * 圈子详情点赞
     */
    public static void  Comment_Like(View view, Activity activity, String commentId, ImageView imageView, TextView textView){

        LottieDialog.setDialogWindow(null);
        Observable observable= homeRequestService.Comment_Like(SimpleUtils.getToken(BaseActivity.getInstance()),commentId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState>(){
                    @Override
                    public void onNext(AllDataState o) {
                        super.onNext(o);
                        SimpleUtils.setLog("评论id:"+commentId+"----点赞数："+o.getMessage());
                        int  id = R.mipmap.praise_9_icon;
                        if (o.getCode()==10003){
                            id = R.mipmap.praise_f_icon;
                            textView.setText((String) o.getData());
                            textView.setTextColor(Color.parseColor("#FD404E"));
                        }else if (o.getCode()==10004){
                            id = R.mipmap.praise_9_icon;
                            textView.setText((String) o.getData());
                            textView.setTextColor(Color.parseColor("#999999"));
                        }else if(o.getCode()==32006){
                            SnackbarUtil.IndefiniteSnackbar(view,o.getMessage(),3000,1).setAction("点击登录", v -> RoutePageActivity.getLRActivity()).show();
                        }
                        GlideUtil.displayImage(activity,id,imageView);
                        SimpleUtils.setToast(o.getMessage());
                    }
                });
    }


    /**评论文章**/
    public static void  Comment_Save(RequestObserver.RequestObserverNext requestObserverNext,Context context, String content,String roundId, String commentId){
        LottieDialog.setDialogWindow(context);
        Observable observable= homeRequestService.Comment_Save(SimpleUtils.getToken(BaseActivity.getInstance()),content,roundId,commentId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestObserver<AllDataState>(requestObserverNext){});
    }

}
