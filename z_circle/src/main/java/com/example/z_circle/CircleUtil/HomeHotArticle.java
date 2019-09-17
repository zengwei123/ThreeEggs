package com.example.z_circle.CircleUtil;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_circle.Model.CircleModel;
import com.example.z_circle.Net.CircleRequestServiceFactory;
import com.example.z_circle.R;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.Util.GlideUtil;
import com.example.z_common.Util.SimpleUtils;

import io.reactivex.disposables.Disposable;

/**
 * Created by zengwei on 2019/9/8.
 * 设置首页热文推荐
 */

public class HomeHotArticle {
    public static void setHomeHotArticle(Activity activity, TextView title, TextView content, ImageView image,TextView Collection,TextView Praise){
        CircleRequestServiceFactory.HomeItemCircle(new RequestObserver.RequestObserverNext<AllDataState<CircleModel>>() {
            @Override
            public void Next(AllDataState<CircleModel> o) {
                try {
                    CircleModel.PageBean.ListBean listBean=o.getData().getPage().getList().get(0);
                    title.setText(listBean.getRoundTitle());
                    content.setText(listBean.getRoundDesc());
                    GlideUtil.roundAngleImage(activity,listBean.getPosterUrl(),image,8);
                    title.setText(listBean.getRoundTitle());
                    SimpleUtils.setViewTypeface(Collection," "+listBean.getCollectNum());
                    GlideUtil.drawableImage(30, R.mipmap.collection_9_icon,Collection,true);
                    SimpleUtils.setViewTypeface(Praise," "+listBean.getLikeNum());
                    GlideUtil.drawableImage(30, R.mipmap.praise_9_icon,Praise,true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onError() {

            }

            @Override
            public void getDisposable(Disposable d) {

            }
        },null,1,1,null);
    }
}
