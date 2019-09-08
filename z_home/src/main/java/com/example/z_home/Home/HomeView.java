package com.example.z_home.Home;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    ImageView getHome_HuoDong1();
    ImageView getHome_HuoDong2();
    ImageView getHome_HuoDong3();
    LinearLayout getHome_HuoDong_layout1();
    LinearLayout getHome_HuoDong_layout2();
    RecyclerView getHome_Fragment_RecyclerView();
    TextView getHome_Fragment_TextView_Search();

    TextView getHome_HotArticle_Title();
    TextView getHome_HotArticle_Content();
    ImageView getHome_HotArticle_Image();
}
