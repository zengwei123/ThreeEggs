package com.example.z_goods.SearchGoodsList;

import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.z_base.BaseView;

/**
 * Created by zengwei on 2019/8/3.
 */

interface SearchGoodsListView extends BaseView{
    FrameLayout getSearchGoodsList_Frame();
    TextView getSearchGoodsList_TextView();
    TextView getSearchGoodsList_Back();
    TextView getSearchGoodsList_Switch();
    String getSearchKey();
}
