package com.example.z_home.Search;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.MvpActivity;
import com.example.z_common.Custom.HotLayout;
import com.example.z_home.R;

/**
 * Created by zengwei on 2019/8/1.
 */
@Route(path = "/Home/Search")
public class SearchActivity extends MvpActivity<SearchPresenter> implements SearchView {
    private HotLayout Search_HotLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**启动页的图片设置为空**/
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
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
    protected SearchPresenter createPresenter() {
        return new SearchPresenter();
    }

    @Override
    public void getViews() {
        Search_HotLayout=findViewById(R.id.Search_HotLayout);
    }

    @Override
    public HotLayout getSearch_HotLayout() {
        return Search_HotLayout;
    }
}
