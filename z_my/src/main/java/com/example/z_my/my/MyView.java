package com.example.z_my.my;

import android.media.Image;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.z_base.BaseView;
import com.example.z_common.Main_Me_Listener;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/**
 * Created by zengwei on 2019/7/28.
 */

interface MyView extends BaseView{
    TextView getMy_OpenDrawer();
    TextView getMy_UserName();
    ImageView getMy_UserHead();
    TextView getMy_Signature();
    TextView getMy_UserEditor();
    TabLayout getMy_TabLayout_Class();
    TabLayout getMy_TabLayout_Item();
    TwinklingRefreshLayout getMy_Fragment_TwinklingRefreshLayout();
    RecyclerView getMy_RecyclerView();

    Main_Me_Listener getMain_Me_Listener();
    void setMain_Me_Listener(Main_Me_Listener m);
}
