package com.example.z_goods.SearchGoodsList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.BasePresenter;
import com.example.z_base.MvpActivity;
import com.example.z_goods.R;

/**
 * Created by zengwei on 2019/8/3.
 * 商品的搜索
 */
@Route(path = "/Goods/GoodsSearchList")
public class SearchGoodsListActivity extends MvpActivity<SearchGoodsListPresenter> implements SearchGoodsListView{
    private FrameLayout SearchGoodsList_Frame;
    private TextView SearchGoodsList_Back;   //返回
    private TextView SearchGoodsList_TextView;   //搜索
    private TextView SearchGoodsList_Switch;   //切换
    private TabLayout SearchGoods_TabLayout;
    private ViewPager SearchGoodsList_Page;   //页面
    @Autowired
    public String SearchKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**启动页的图片设置为空**/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchgoodslist_layout);
        ARouter.getInstance().inject(this);
        mvpPresenter.attachView(this);
        getViews();
        mvpPresenter.init();
    }

    @Override
    protected SearchGoodsListPresenter createPresenter() {
        return new SearchGoodsListPresenter();
    }

    @Override
    public void getViews() {
        SearchGoodsList_Frame=findViewById(R.id.SearchGoodsList_Frame);
        SearchGoodsList_Back=findViewById(R.id.SearchGoodsList_Back);
        SearchGoodsList_TextView=findViewById(R.id.SearchGoodsList_TextView);
        SearchGoodsList_Switch=findViewById(R.id.SearchGoodsList_Switch);
        SearchGoods_TabLayout=findViewById(R.id.SearchGoods_TabLayout);
        SearchGoodsList_Page=findViewById(R.id.SearchGoodsList_Page);
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
    public FrameLayout getSearchGoodsList_Frame() {
        return SearchGoodsList_Frame;
    }

    @Override
    public TextView getSearchGoodsList_TextView() {
        return SearchGoodsList_TextView;
    }

    @Override
    public TextView getSearchGoodsList_Back() {
        return SearchGoodsList_Back;
    }

    @Override
    public TextView getSearchGoodsList_Switch() {
        return SearchGoodsList_Switch;
    }

    @Override
    public String getSearchKey() {
        return SearchKey;
    }

    @Override
    public TabLayout getSearchGoods_TabLayout() {
        return SearchGoods_TabLayout;
    }

    @Override
    public ViewPager getSearchGoodsList_Page() {
        return SearchGoodsList_Page;
    }
}
