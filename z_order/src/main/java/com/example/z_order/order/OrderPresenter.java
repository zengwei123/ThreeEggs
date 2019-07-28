package com.example.z_order.order;

import android.support.v4.app.FragmentActivity;

import com.example.z_base.BasePresenter;
import com.example.z_base.MvpFragment;
import com.example.z_common.SimpleFragmentAdapter;
import com.example.z_order.orderPage.OrderPageFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderPresenter extends BasePresenter<OrderView> {
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        List<MvpFragment> mvpFragments=new ArrayList<>();
        mvpFragments.add(new OrderPageFragment());

        mvpView.getOrder_ViewPager().setAdapter(new SimpleFragmentAdapter(((FragmentActivity)mvpView.getThisActivity()).getSupportFragmentManager(),mvpFragments));
    }
}
