package com.example.zengwei.threeeggs.Guide;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.z_base.MvpActivity;
import com.example.z_base.ViewBind;
import com.example.zengwei.threeeggs.R;

import cn.bingoogolapple.bgabanner.BGABanner;


/**
 * Created by zengwei on 2019/7/20.
 * 初次进入的引导界面
 */

public class GuideActivity extends MvpActivity<GuidePresenter> implements GuideView {
    @ViewBind(R.id.Guide_BGABanner)
    private BGABanner Guide_BGABanner;
    @ViewBind(R.id.Guide_NoFirst_layout)
    private RelativeLayout Guide_NoFirst_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_layout);
        mvpPresenter.attachView(this);
        super.injectViews();
        mvpPresenter.init();
    }

    @Override
    public void getViews() {
    }

    @Override
    protected GuidePresenter createPresenter() {
        return new GuidePresenter();
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
    public BGABanner getGuide_BGABanner() {
        return Guide_BGABanner;
    }

    @Override
    public RelativeLayout getGuide_NoFirst_layout() {
        return Guide_NoFirst_layout;
    }
}
