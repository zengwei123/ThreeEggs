package com.example.z_home.Home;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseView;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by zengwei on 2019/7/24.
 */

interface HomeView extends BaseView{
    TextView getHome_Fragment_Image_weather();
    TextView getHome_Fragment_Image_Location();
    BGABanner getHome_Fragment_BGABanner();
    ImageView getHome_HuoDong();
    RecyclerView getHome_Fragment_RecyclerView();
    ImageView getHome_activity();
    TextView getHome_Fragment_TextView_Search();
}
