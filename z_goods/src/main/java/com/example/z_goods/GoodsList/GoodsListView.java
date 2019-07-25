package com.example.z_goods.GoodsList;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseView;

/**
 * Created by zengwei on 2019/7/24.
 */

public interface GoodsListView extends BaseView{
    /**推荐的**/
    TextView getGoodsList_Comprehensive();
    TextView getGoodsList_Sales();
    TextView getGoodsList_Price();
    TextView getGoodsList_Distance();
    ImageView getGoodsList_Style();
    ImageView getGoodsList_Screening();
    RecyclerView getGoodsList_Recycler();
}
