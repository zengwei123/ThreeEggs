package com.example.z_order.orderPage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;
import com.example.z_order.R;

/**
 * Created by zengwei on 2019/7/28.
 */

public class OrderPageFragment extends MvpFragment<OrderPagePresenter> implements OrderPageView{
    private RecyclerView OrderPage_Recycler;
    private int RecyclerLayout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.orderpage_fragment,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(activity.getApplication());
        mvpPresenter.attachView(this);
        getViews(view);
        mvpPresenter.init();
    }

    @Override
    protected OrderPagePresenter createPresenter() {
        return new OrderPagePresenter();
    }

    @Override
    public void getViews(View view) {
        OrderPage_Recycler=view.findViewById(R.id.OrderPage_Recycler);
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
    public void setRecyclerLayout(int layout) {
        RecyclerLayout = layout;
    }

    @Override
    public int getRecyclerLayout() {
        return RecyclerLayout;
    }

    @Override
    public RecyclerView getOrderPage_Recycler() {
        return OrderPage_Recycler;
    }
}
