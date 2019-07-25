package com.example.zengwei.threeeggs.Main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpActivity;
import com.example.z_base.ViewBind;
import com.example.z_common.Custom.NoScrollViewPager;
import com.example.zengwei.threeeggs.R;


/**
 * Created by zengwei on 2019/7/21.
 * 主布局界面
 */

public class MainActivity extends MvpActivity<MainPresenter> implements MainView {
    @ViewBind(R.id.Main_TabLayout)
    private TabLayout Main_TabLayout;
    @ViewBind(R.id.Main_ViewPager)
    private NoScrollViewPager Main_ViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**启动页的图片设置为空**/
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        mvpPresenter.attachView(this);
        super.injectViews();
        mvpPresenter.init();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public Activity getThisActivity() {
        return this;
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public TabLayout getMain_TabLayout() {
        return Main_TabLayout;
    }

    @Override
    public NoScrollViewPager getMain_ViewPager() {
        return Main_ViewPager;
    }
}
