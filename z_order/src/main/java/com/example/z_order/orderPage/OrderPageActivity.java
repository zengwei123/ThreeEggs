package com.example.z_order.orderPage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.MvpActivity;
import com.example.z_order.R;

/**
 * Created by zengwei on 2019/7/28.
 */

@Route(path = "/Order/OrderList")
public class OrderPageActivity extends MvpActivity<OrderPagePresenter> implements OrderPageView{
    private RecyclerView OrderPage_Recycler;
    private int RecyclerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**启动页的图片设置为空**/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderpage_fragment);
        mvpPresenter.attachView(this);
        getViews();
        mvpPresenter.init();
    }

    @Override
    protected OrderPagePresenter createPresenter() {
        return new OrderPagePresenter();
    }

    @Override
    public void getViews() {
        OrderPage_Recycler=findViewById(R.id.OrderPage_Recycler);
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
