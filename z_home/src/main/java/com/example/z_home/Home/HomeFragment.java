package com.example.z_home.Home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.MvpFragment;
import com.example.z_common.Amap.AmapPositioningUtil;
import com.example.z_home.R;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by zengwei on 2019/7/24.
 * 首页
 */

public class HomeFragment extends MvpFragment<HomePresenter> implements HomeView {
    private ImageView Home_Fragment_Image_Category;   //类别
    private ImageView Home_Fragment_Image_Shooting;  //照相
    private TextView Home_Fragment_Image_Location;  //位置
    private BGABanner Home_Fragment_BGABanner;    //轮播图
    private RecyclerView Home_Fragment_RecyclerView;   //活动栏
    private ImageView Home_activity;
    private FrameLayout GoodsList_Fragment;  //商品列表
    private TextView Home_Fragment_TextView_Search;  //搜索界面按钮
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
        Home_Fragment_Image_Category=view.findViewById(R.id.Home_Fragment_Image_Category);
        Home_Fragment_Image_Shooting=view.findViewById(R.id.Home_Fragment_Image_Shooting);
        Home_Fragment_Image_Location=view.findViewById(R.id.Home_Fragment_Image_Location);
        Home_Fragment_BGABanner=view.findViewById(R.id.Home_Fragment_BGABanner);
        Home_Fragment_RecyclerView=view.findViewById(R.id.Home_Fragment_RecyclerView);
        Home_activity=view.findViewById(R.id.Home_activity);
        GoodsList_Fragment=view.findViewById(R.id.GoodsList_Fragment);
        Home_Fragment_TextView_Search=view.findViewById(R.id.Home_Fragment_TextView_Search);
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
    public ImageView getHome_Fragment_Image_Category() {
        return Home_Fragment_Image_Category;
    }

    @Override
    public ImageView getHome_Fragment_Image_Shooting() {
        return Home_Fragment_Image_Shooting;
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
    public RecyclerView getHome_Fragment_RecyclerView() {
        return Home_Fragment_RecyclerView;
    }

    @Override
    public ImageView getHome_activity() {
        return Home_activity;
    }

    @Override
    public FrameLayout getGoodsList_Fragment() {
        return GoodsList_Fragment;
    }

    @Override
    public FragmentManager getFragmentManagers() {
        return getFragmentManager();
    }

    public TextView getHome_Fragment_TextView_Search() {
        return Home_Fragment_TextView_Search;
    }

    @Override
    public void onResume() {
        super.onResume();
        /**在这里获取定位  防止第一次进入无法获取位置**/
        if(AmapPositioningUtil.getIsPosition()==-1){
            mvpPresenter.positioning();
        }else  if(AmapPositioningUtil.getIsPosition()==2||AmapPositioningUtil.getIsPosition()==0){
            getHome_Fragment_Image_Location().setText(AmapPositioningUtil.getPositioningSuccessful().getCity()+
                    AmapPositioningUtil.getPositioningSuccessful().getAddress());
        }
    }
}