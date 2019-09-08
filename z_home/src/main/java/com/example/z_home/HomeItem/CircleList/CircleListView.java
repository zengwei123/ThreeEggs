package com.example.z_home.HomeItem.CircleList;

import android.support.design.widget.TabLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseView;

/**
 * Created by zengwei on 2019/9/8.
 */

public interface CircleListView extends BaseView{
    TextView getInclude_Title_Text();
    ImageView getInclude_Title_Close();
    ImageView getCircleList_Search();
    TabLayout getCircleList_TabLayout();

    String getTitlec();
    String getclassification();
}
