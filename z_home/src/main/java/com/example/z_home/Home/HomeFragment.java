package com.example.z_home.Home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.z_base.MvpFragment;
import com.example.z_common.Amap.AmapPositioningUtil;
import com.example.z_common.Util.GlideUtil;
import com.example.z_common.Util.SimpleUtils;
import com.example.z_home.R;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by zengwei on 2019/7/24.
 * 首页
 */

public class HomeFragment extends MvpFragment<HomePresenter> implements HomeView {
    private TextView Home_Fragment_Image_weather;   //天气
    private TextView Home_Fragment_Image_Location;  //位置
    private BGABanner Home_Fragment_BGABanner;    //轮播图

    private ImageView Home_HuoDong,Home_HuoDong1,Home_HuoDong2,Home_HuoDong3;  //活动item下面的图片
    private View Home_HuoDong_View;  //活动图中间的空白

    private LinearLayout Home_HuoDong_Layout1,Home_HuoDong_Layout2;//活动图片布局的  用来显示隐藏
    private RecyclerView Home_Fragment_RecyclerView;   //活动栏
    private TextView Home_Fragment_TextView_Search;  //搜索界面按钮

    private TextView Home_HotArticle_Title;    //热文推荐的标题
    private TextView Home_HotArticle_Content;   //热文的简略内容
    private ImageView Home_HotArticle_Image;    //文章图片
    private TextView Home_HotArticle_Praise;  //热文推荐的点赞数
    private TextView Home_HotArticle_Collection;  //热文推荐的收藏数
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter.attachView(this);
        getViews(view);
        mvpPresenter.init();
    }

    public void getViews(View view){
        Home_Fragment_Image_weather=view.findViewById(R.id.Home_Fragment_Image_weather);
        Home_Fragment_Image_Location=view.findViewById(R.id.Home_Fragment_Image_Location);
        Home_Fragment_BGABanner=view.findViewById(R.id.Home_Fragment_BGABanner);
        Home_HuoDong=view.findViewById(R.id.Home_HuoDong);
        Home_HuoDong1=view.findViewById(R.id.Home_HuoDong1);
        Home_HuoDong2=view.findViewById(R.id.Home_HuoDong2);
        Home_HuoDong3=view.findViewById(R.id.Home_HuoDong3);
        Home_HuoDong_Layout1=view.findViewById(R.id.Home_HuoDong_Layout1);
        Home_HuoDong_Layout2=view.findViewById(R.id.Home_HuoDong_Layout2);
        Home_HuoDong_View=view.findViewById(R.id.Home_HuoDong_View);

        Home_Fragment_RecyclerView=view.findViewById(R.id.Home_Fragment_RecyclerView);
        Home_Fragment_TextView_Search=view.findViewById(R.id.Home_Fragment_TextView_Search);

        Home_HotArticle_Title=view.findViewById(R.id.Home_HotArticle_Title);
        Home_HotArticle_Content=view.findViewById(R.id.Home_HotArticle_Content);
        Home_HotArticle_Image=view.findViewById(R.id.Home_HotArticle_Image);
        Home_HotArticle_Praise=view.findViewById(R.id.Home_HotArticle_Praise);
        Home_HotArticle_Collection=view.findViewById(R.id.Home_HotArticle_Collection);
    }

    @Override
    public Context getActivityContext() {
        return activity;
    }

    @Override
    public Activity getThisActivity() {
        return activity;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public TextView getHome_Fragment_Image_weather() {
        return Home_Fragment_Image_weather;
    }


    @Override
    public TextView getHome_Fragment_Image_Location() {
        return Home_Fragment_Image_Location;
    }

    @Override
    public BGABanner getHome_Fragment_BGABanner() {
        return Home_Fragment_BGABanner;
    }

    @Override
    public ImageView getHome_HuoDong() {
        return Home_HuoDong;
    }

    @Override
    public ImageView getHome_HuoDong1() {
        return Home_HuoDong1;
    }

    @Override
    public ImageView getHome_HuoDong2() {
        return Home_HuoDong2;
    }

    @Override
    public ImageView getHome_HuoDong3() {
        return Home_HuoDong3;
    }

    @Override
    public View getHome_HuoDong_View() {
        return Home_HuoDong_View;
    }

    @Override
    public LinearLayout getHome_HuoDong_layout1() {
        return Home_HuoDong_Layout1;
    }

    @Override
    public LinearLayout getHome_HuoDong_layout2() {
        return Home_HuoDong_Layout2;
    }

    @Override
    public RecyclerView getHome_Fragment_RecyclerView() {
        return Home_Fragment_RecyclerView;
    }

    public TextView getHome_Fragment_TextView_Search() {
        return Home_Fragment_TextView_Search;
    }

    @Override
    public TextView getHome_HotArticle_Title() {
        return Home_HotArticle_Title;
    }

    @Override
    public TextView getHome_HotArticle_Content() {
        return Home_HotArticle_Content;
    }

    @Override
    public ImageView getHome_HotArticle_Image() {
        return Home_HotArticle_Image;
    }

    @Override
    public TextView getHome_HotArticle_Praise() {
        return Home_HotArticle_Praise;
    }

    @Override
    public TextView getHome_HotArticle_Collection() {
        return Home_HotArticle_Collection;
    }

    @Override
    public void onResume() {
        super.onResume();
        /**在这里获取定位  防止第一次进入无法获取位置**/
        if(AmapPositioningUtil.getIsPosition()==-1){
            mvpPresenter.positioning();
        }else  if(AmapPositioningUtil.getIsPosition()==2||AmapPositioningUtil.getIsPosition()==0){
            SimpleUtils.setViewTypeface(getHome_Fragment_Image_Location(),AmapPositioningUtil.getPositioningSuccessful().getAddress());
            GlideUtil.drawableImage(48,40,R.mipmap.positioning_icon,R.mipmap.bottom_icon,getHome_Fragment_Image_Location());
            AmapPositioningUtil.setServicePositioning();
        }else if (AmapPositioningUtil.getIsPosition()==3){
            SimpleUtils.setViewTypeface(getHome_Fragment_Image_Location(),AmapPositioningUtil.getPositioningSuccessful().getCity());
            GlideUtil.drawableImage(48,40,R.mipmap.positioning_icon,R.mipmap.bottom_icon,getHome_Fragment_Image_Location());
            AmapPositioningUtil.setServicePositioning();
        }
    }
}