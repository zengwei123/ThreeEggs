package com.example.z_circle.Circle;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.z_base.BaseView;
import com.example.z_common.Custom.WanTextView;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import cn.bingoogolapple.bgabanner.BGABanner;

public interface CircleView extends BaseView {
    TextView getCircle_Fragment_Address();
    WanTextView getCircle_Fragment_TextView_Search();
    RecyclerView getCircle_Fragment_RecyclerView();
    BGABanner getCircle_Fragment_BGABanner();
    TabLayout getCircle_Fragment_TabLayout();
    TwinklingRefreshLayout getCircle_Fragment_TwinklingRefreshLayout();
    RecyclerView getCircle_Fragment_ContentRecyclerView();
}
