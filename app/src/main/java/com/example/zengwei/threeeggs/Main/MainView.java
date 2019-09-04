package com.example.zengwei.threeeggs.Main;

import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.z_base.BaseView;
import com.example.z_common.Custom.NoScrollViewPager;


/**
 * Created by zengwei on 2019/7/21.
 */

public interface MainView extends BaseView {
    NoScrollViewPager getMain_ViewPager();

    RelativeLayout getMain_Home_Tab();
    RelativeLayout getMain_Circle_Tab();
    RelativeLayout getMain_Add_Tab();
    RelativeLayout getMain_Message_Tab();
    RelativeLayout getMain_Personal_Tab();

    ImageView getMain_Home_Tab_Image();
    ImageView getMain_Circle_Tab_Image();
    ImageView getMain_Message_Tab_Image();
    ImageView getMain_Personal_Tab_Image();
    DrawerLayout getMain_DrawerLayout();
}
