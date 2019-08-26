package com.example.z_login_register.LR;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseView;
import com.example.z_common.Custom.NoScrollViewPager;

/**
 * Created by zengwei on 2019/8/11.
 */

interface LRView extends BaseView{
    ImageView getLR_Close();
    NoScrollViewPager getNoScrollViewPager();
}
