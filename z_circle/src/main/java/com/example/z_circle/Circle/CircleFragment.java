package com.example.z_circle.Circle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.z_base.MvpFragment;
import com.example.z_circle.R;
import com.example.z_common.Amap.AmapPositioningUtil;
import com.example.z_common.Custom.WanTextView;
import com.example.z_common.SimpleUtils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import cn.bingoogolapple.bgabanner.BGABanner;

public class CircleFragment extends MvpFragment<CirclePresenter> implements CircleView {
    private TextView Circle_Fragment_Address;   //位置
    private WanTextView Circle_Fragment_TextView_Search;  //圈子搜索
    private RecyclerView Circle_Fragment_RecyclerView;  //栏目item
    private BGABanner Circle_Fragment_BGABanner;// 轮播图
    private TabLayout Circle_Fragment_TabLayout;
    private RecyclerView Circle_Fragment_ContentRecyclerView;  //内容Recycler
    private TwinklingRefreshLayout Circle_Fragment_TwinklingRefreshLayout;  //上拉加载框架
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.circle_fragment,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter.attachView(this);
        getViews(view);
        mvpPresenter.init();
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
    protected CirclePresenter createPresenter() {
        return new CirclePresenter();
    }

    @Override
    public void getViews(View view) {
        Circle_Fragment_Address=view.findViewById(R.id.Circle_Fragment_Address);
        Circle_Fragment_TextView_Search=view.findViewById(R.id.Circle_Fragment_TextView_Search);
        Circle_Fragment_RecyclerView=view.findViewById(R.id.Circle_Fragment_RecyclerView);
        Circle_Fragment_BGABanner=view.findViewById(R.id.Circle_Fragment_BGABanner);
        Circle_Fragment_TabLayout=view.findViewById(R.id.Circle_Fragment_TabLayout);
        Circle_Fragment_ContentRecyclerView=view.findViewById(R.id.Circle_Fragment_ContentRecyclerView);
        Circle_Fragment_TwinklingRefreshLayout=view.findViewById(R.id.Circle_Fragment_TwinklingRefreshLayout);
    }

    @Override
    public TextView getCircle_Fragment_Address() {
        return Circle_Fragment_Address;
    }

    @Override
    public WanTextView getCircle_Fragment_TextView_Search() {
        return Circle_Fragment_TextView_Search;
    }

    @Override
    public RecyclerView getCircle_Fragment_RecyclerView() {
        return Circle_Fragment_RecyclerView;
    }

    @Override
    public BGABanner getCircle_Fragment_BGABanner() {
        return Circle_Fragment_BGABanner;
    }

    @Override
    public TabLayout getCircle_Fragment_TabLayout() {
        return Circle_Fragment_TabLayout;
    }

    @Override
    public RecyclerView getCircle_Fragment_ContentRecyclerView() {
        return Circle_Fragment_ContentRecyclerView;
    }

    @Override
    public TwinklingRefreshLayout getCircle_Fragment_TwinklingRefreshLayout() {
        return Circle_Fragment_TwinklingRefreshLayout;
    }


    @Override
    public void onResume() {
        super.onResume();
        /**获取位置**/
        if (AmapPositioningUtil.getPositioningSuccessful()!=null){
            SimpleUtils.setViewTypeface(getCircle_Fragment_Address(),"\uec74"+AmapPositioningUtil.getPositioningSuccessful().getAddress());
        }else {
            SimpleUtils.setViewTypeface(getCircle_Fragment_Address(),"\uec74未定位");
        }
    }
}
