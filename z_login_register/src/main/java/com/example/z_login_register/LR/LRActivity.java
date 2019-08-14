package com.example.z_login_register.LR;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.MvpActivity;
import com.example.z_common.Custom.NoScrollViewPager;
import com.example.z_login_register.R;

/**
 * Created by zengwei on 2019/8/11.
 */
@Route(path = "/LR/LRActivity")
public class LRActivity extends MvpActivity<LRPresenter> implements LRView{
    private TextView Include_Title_Text;   //页面头文字
    private ImageView Include_Title_Close;  //头部关闭按钮
    private NoScrollViewPager LR_ViewPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lr_layout);
        mvpPresenter.attachView(this);
        getViews();
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
    protected LRPresenter createPresenter() {
        return new LRPresenter();
    }

    @Override
    public void getViews() {
        LR_ViewPage=findViewById(R.id.LR_ViewPage);
        Include_Title_Text=findViewById(R.id.Include_Title_Text);
        Include_Title_Close=findViewById(R.id.Include_Title_Close);
    }

    @Override
    public TextView getInclude_Title_Text() {
        return Include_Title_Text;
    }

    @Override
    public ImageView getInclude_Title_Close() {
        return Include_Title_Close;
    }

    @Override
    public NoScrollViewPager getNoScrollViewPager() {
        return LR_ViewPage;
    }
}
