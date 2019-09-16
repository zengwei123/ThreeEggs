package com.example.z_circle.CircleList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;
import com.example.z_circle.R;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
@Route(path = "/Circle/CircleListFragment")
public class CircleListFragment extends MvpFragment<CircleListPresenter> implements CircleListView {
    /**这里是推荐的商品**/
    private RecyclerView CircleList_Recycler;  //推荐数据列表
    private TwinklingRefreshLayout CircleList_Fragment_TwinklingRefreshLayout;  //上拉刷新
    @Autowired
    public String SearchParameter=null;   //搜索内容
    @Autowired
    public  int CircleType;   //商品列表

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);
        return inflater.inflate(R.layout.circlelist_fragment,null,false);
    }

    @Override
    protected CircleListPresenter createPresenter() {
        return new CircleListPresenter();
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
        CircleList_Recycler=view.findViewById(R.id.CircleList_Recycler);
        CircleList_Fragment_TwinklingRefreshLayout=view.findViewById(R.id.CircleList_Fragment_TwinklingRefreshLayout);
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
    public RecyclerView getCircleList_Recycler() {
        return CircleList_Recycler;
    }

    @Override
    public TwinklingRefreshLayout getCircleList_Fragment_TwinklingRefreshLayout() {
        return CircleList_Fragment_TwinklingRefreshLayout;
    }

    @Override
    public String getSearchParameter() {
        return SearchParameter;
    }

    @Override
    public int getCircleType() {
        return CircleType;
    }

    /**首页传达推荐按分类查询**/
    public void categoryName(String categoryName){
        mvpPresenter.categoryName(categoryName);
    }
}
