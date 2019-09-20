package com.example.z_circle.Details;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.z_base.BaseView;
import com.example.z_circle.R;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by zengwei on 2019/9/18.
 */

public interface DetailsView extends BaseView{
    ImageView getDetails_Close();
    ImageView getDetails_Share();
    TextView getDetails_UserName();
    BGABanner getDetails_Banner();
    TextView getDetails_Title();
    TextView getDetails_Content();
    TextView getDetails_Address();
    TextView getDetails_Time();

    RelativeLayout getDetails_Goods_Layout();
    ImageView getDetails_Goods_Image();
    TextView getDetails_Goods_Title();
    TextView getDetails_Goods_Price();

    TextView getDetails_Label();

    String getRoundId();

    RecyclerView getDetails_CommentsShow_Recycler();
    TextView getDetails_CommentsShow_But();
    TextView getDetails_CommentsShow_Sum();

    TextView getDetails_Refresh();
    TextView getDetails_Praise();
    TextView getDetails_Collection();
    TextView getDetails_Comments();
}
