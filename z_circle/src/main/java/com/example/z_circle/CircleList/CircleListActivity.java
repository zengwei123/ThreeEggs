package com.example.z_circle.CircleList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.example.z_base.MvpActivity;
import com.example.z_circle.R;

public class CircleListActivity extends MvpActivity<CircleListPreesenter> implements CircleListView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**启动页的图片设置为空**/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circlelist_layout);
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
    protected CircleListPreesenter createPresenter() {
        return new CircleListPreesenter();
    }

    @Override
    public void getViews() {

    }
}
