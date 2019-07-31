package com.example.z_my.my;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;
import com.example.z_my.R;

/**
 * Created by zengwei on 2019/7/28.
 */

public class MyFragment extends MvpFragment<MyPresenter> implements MyView {
    private RecyclerView My_Recycler;
    private LinearLayout My_OrderAll_Linear;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_fragment,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter.attachView(this);
        getViews(view);
        mvpPresenter.init();
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
    protected MyPresenter createPresenter() {
        return new MyPresenter();
    }

    @Override
    public void getViews(View view) {
        My_Recycler=view.findViewById(R.id.My_Recycler);
        My_OrderAll_Linear=view.findViewById(R.id.My_OrderAll_Linear);
    }

    @Override
    public RecyclerView getMy_Recycler() {
        return My_Recycler;
    }

    @Override
    public LinearLayout getMy_OrderAll_Linear() {
        return My_OrderAll_Linear;
    }

}
