package com.example.z_home.Search;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.MvpActivity;
import com.example.z_common.Custom.HotLayout;
import com.example.z_home.R;

/**
 * Created by zengwei on 2019/8/1.
 */
@Route(path = "/Home/Search")
public class SearchActivity extends MvpActivity<SearchPresenter> implements SearchView {
    private HotLayout Search_HotLayout;  //搜索记录控件
    private TextView Search_Search;  //搜索按钮
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
        Search_Search=findViewById(R.id.Search_Search);
    }

    @Override
    public HotLayout getSearch_HotLayout() {
        return Search_HotLayout;
    }

    @Override
    public TextView getSearch_Search() {
        return Search_Search;
    }
}
