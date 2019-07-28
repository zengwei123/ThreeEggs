package com.example.z_order.orderPage;

import android.support.v7.widget.RecyclerView;

import com.example.z_base.BaseView;

/**
 * Created by zengwei on 2019/7/28.
 */

interface OrderPageView extends BaseView{
    void setRecyclerLayout(int layout);
    int getRecyclerLayout();
    RecyclerView getOrderPage_Recycler();
}
