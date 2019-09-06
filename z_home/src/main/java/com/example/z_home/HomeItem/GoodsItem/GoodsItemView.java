package com.example.z_home.HomeItem.GoodsItem;

import android.support.design.widget.TabLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseView;

public interface GoodsItemView extends BaseView {
    TextView getInclude_Title_Text();
    ImageView getInclude_Title_Close();
    ImageView getGoodsList_Search();
    TabLayout getGoodsList_TabLayout();

    String getTitlec();
    String getclassification();
}
