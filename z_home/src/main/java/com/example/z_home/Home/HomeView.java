package com.example.z_home.Home;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseView;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by zengwei on 2019/7/24.
 */

interface HomeView extends BaseView{
    ImageView getHome_Fragment_Image_Category();
    ImageView getHome_Fragment_Image_Shooting();
    TextView getHome_Fragment_Image_Location();
    BGABanner getHome_Fragment_BGABanner();
    RecyclerView getHome_Fragment_RecyclerView();
    ImageView getHome_activity();
    FrameLayout getGoodsList_Fragment();
    FragmentManager getFragmentManagers();
    TextView getHome_Fragment_TextView_Search();
}
