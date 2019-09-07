package com.example.z_goods.GoodsList;

import android.support.v7.widget.RecyclerView;

import com.example.z_base.BaseView;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/**
 * Created by zengwei on 2019/7/24.
 */

public interface GoodsListView extends BaseView{
    RecyclerView getGoodsList_Recycler();
    TwinklingRefreshLayout getGoodsList_Fragment_TwinklingRefreshLayout();

    String getSearchParameter();
    int getGoodsType();
}
