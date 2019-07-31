package com.example.z_circle.Circle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;
import com.example.z_circle.R;

public class CircleFragment extends MvpFragment<CirclePresenter> implements CircleView {
    private TabLayout Circle_TabLayout;  //附近与热门的推荐
    private ViewPager Circle_ViewPage;
    private FloatingActionButton Circle_FloatingActionButton;
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
        Circle_TabLayout=view.findViewById(R.id.Circle_TabLayout);
        Circle_ViewPage=view.findViewById(R.id.Circle_ViewPage);
        Circle_FloatingActionButton=view.findViewById(R.id.Circle_FloatingActionButton);
    }

    @Override
    public TabLayout getCircle_TabLayout() {
        return Circle_TabLayout;
    }

    @Override
    public ViewPager getCircle_ViewPager() {
        return Circle_ViewPage;
    }

    @Override
    public FloatingActionButton getCircle_FloatingActionButton() {
        return Circle_FloatingActionButton;
    }
}
