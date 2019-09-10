package com.example.z_circle.CircleUtil;

import android.app.Activity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_circle.Model.CircleList;
import com.example.z_circle.Model.CircleModel;
import com.example.z_circle.Net.CircleRequestServiceFactory;
import com.example.z_common.GlideUtil;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;

import io.reactivex.disposables.Disposable;

/**
 * Created by zengwei on 2019/9/8.
 * 设置首页热文推荐
 */

public class HomeHotArticle {
    public static void setHomeHotArticle(Activity activity, TextView title, TextView content, ImageView image){
        CircleRequestServiceFactory.HomeItemCircle(new RequestObserver.RequestObserverNext<AllDataState<CircleModel>>() {
            @Override
            public void Next(AllDataState<CircleModel> o) {
                try {
                    CircleModel.PageBean.ListBean listBean=o.getData().getPage().getList().get(0);
                    title.setText(listBean.getRoundTitle());
                    content.setText(listBean.getRoundDesc());
                    GlideUtil.displayImage(activity,listBean.getPosterUrl(),image);
                    title.setText(listBean.getRoundTitle());
                }catch (Exception e){

                }
            }

            @Override
            public void onError() {

            }

            @Override
            public void getDisposable(Disposable d) {

            }
        },null,1,1,"7");
    }
}
