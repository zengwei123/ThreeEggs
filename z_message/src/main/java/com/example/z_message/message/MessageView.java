package com.example.z_message.message;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.z_base.BaseView;

interface MessageView extends BaseView {
    ViewPager getMessage_ViewPage();
    TabLayout getMessage_TabLayout();
}
