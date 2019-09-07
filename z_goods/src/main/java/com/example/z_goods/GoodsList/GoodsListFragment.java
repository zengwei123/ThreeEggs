package com.example.z_goods.GoodsList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;
import com.example.z_goods.R;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/**
 * Created by zengwei on 2019/7/24.
 */
@Route(path="/Goods/GoodsList")
public class GoodsListFragment extends MvpFragment<GoodsListPresenter> implements GoodsListView {
    /**这里是推荐的商品**/
    private RecyclerView GoodsList_Recycler;  //推荐数据列表
    private TwinklingRefreshLayout GoodsList_Fragment_TwinklingRefreshLayout;  //上拉刷新

    @Autowired
    public String SearchParameter=null;   //搜索内容
    @Autowired
    public  int GoodsType;   //商品列表

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);
        return inflater.inflate(R.layout.goodslis_fragment,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter.attachView(this);
        getViews(view);
        mvpPresenter.init();
    }

    @Override
    public void getViews(View view){
        GoodsList_Recycler=view.findViewById(R.id.GoodsList_Recycler);
        GoodsList_Fragment_TwinklingRefreshLayout=view.findViewById(R.id.GoodsList_Fragment_TwinklingRefreshLayout);
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
    protected GoodsListPresenter createPresenter() {
        return new GoodsListPresenter();
    }

    @Override
    public RecyclerView getGoodsList_Recycler() {
        return GoodsList_Recycler;
    }

    @Override
    public TwinklingRefreshLayout getGoodsList_Fragment_TwinklingRefreshLayout() {
        return GoodsList_Fragment_TwinklingRefreshLayout;
    }


    @Override
    public String getSearchParameter() {
        return SearchParameter;
    }

    @Override
    public int getGoodsType() {
        return GoodsType;
    }

    public void setSWitch(TextView textView){
        mvpPresenter.setSWitch(textView);
    }



    /**首页新品首发按分类查询**/
    public void categoryName(String categoryName){
        mvpPresenter.categoryName(categoryName);
    }

}
