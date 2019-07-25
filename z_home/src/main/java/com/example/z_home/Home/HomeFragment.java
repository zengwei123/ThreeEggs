package com.example.z_home.Home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;
import com.example.z_base.ViewBind;
import com.example.z_home.R;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by zengwei on 2019/7/24.
 * 首页
 */

public class HomeFragment extends MvpFragment<HomePresenter> implements HomeView {
    @ViewBind(R.id.Home_Fragment_Image_Class)
    private ImageView Home_Fragment_Image_Class;   //类别
    @ViewBind(R.id.Home_Fragment_Image_Shooting)
    private ImageView Home_Fragment_Image_Shooting;  //照相
    @ViewBind(R.id.Home_Fragment_Image_Location)
    private TextView Home_Fragment_Image_Location;  //位置
    @ViewBind(R.id.Home_Fragment_BGABanner)
    private BGABanner Home_Fragment_BGABanner;    //轮播图
    @ViewBind(R.id.Home_Fragment_RecyclerView)
    private RecyclerView Home_Fragment_RecyclerView;   //活动栏
    @ViewBind(R.id.GoodsList_Fragment)
    private FrameLayout GoodsList_Fragment;  //商品列表
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(activity.getApplication());
        mvpPresenter.attachView(this);
        injectViews(view);
        mvpPresenter.init();
    }

    @Override
    public Context getActivityContext() {
        return activity;
    }

    @Override
    public Activity getThisActivity() {
        return activity;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public ImageView getHome_Fragment_Image_Class() {
        return Home_Fragment_Image_Class;
    }

    @Override
    public ImageView getHome_Fragment_Image_Shooting() {
        return Home_Fragment_Image_Shooting;
    }

    @Override
    public TextView getHome_Fragment_Image_Location() {
        return Home_Fragment_Image_Location;
    }

    @Override
    public BGABanner getHome_Fragment_BGABanner() {
        return Home_Fragment_BGABanner;
    }

    @Override
    public RecyclerView getHome_Fragment_RecyclerView() {
        return Home_Fragment_RecyclerView;
    }

    @Override
    public FrameLayout getGoodsList_Fragment() {
        return GoodsList_Fragment;
    }

    @Override
    public FragmentManager getFragmentManagers() {
        return getFragmentManager();
    }
}
