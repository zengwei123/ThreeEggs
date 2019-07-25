package com.example.zengwei.threeeggs.Main;

import android.support.design.widget.TabLayout;

import com.example.z_base.BaseView;
import com.example.z_common.Custom.NoScrollViewPager;


/**
 * Created by zengwei on 2019/7/21.
 */

public interface MainView extends BaseView {
    TabLayout getMain_TabLayout();
    NoScrollViewPager getMain_ViewPager();
}
