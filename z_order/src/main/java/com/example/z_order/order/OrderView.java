package com.example.z_order.order;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.example.z_base.BaseView;

interface OrderView extends BaseView {
    TabLayout getOrder_Table();
    ViewPager getOrder_ViewPager();
}
