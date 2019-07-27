package com.example.z_circle.Circle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.z_base.BaseView;

public interface CircleView extends BaseView {
    TabLayout getCircle_TabLayout();
    ViewPager getCircle_ViewPager();
    FloatingActionButton getCircle_FloatingActionButton();
}
