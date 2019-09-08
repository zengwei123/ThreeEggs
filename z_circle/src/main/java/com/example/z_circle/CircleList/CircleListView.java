package com.example.z_circle.CircleList;

import android.support.v7.widget.RecyclerView;

import com.example.z_base.BaseView;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

public interface CircleListView extends BaseView {
    RecyclerView getCircleList_Recycler();
    TwinklingRefreshLayout getCircleList_Fragment_TwinklingRefreshLayout();

    String getSearchParameter();
    int getCircleType();
}
