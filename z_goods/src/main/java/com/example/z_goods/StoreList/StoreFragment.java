package com.example.z_goods.StoreList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.MvpFragment;
import com.example.z_goods.R;

/**
 * Created by zengwei on 2019/9/4.
 * 店铺列表fragment
 */
@Route(path = "/Goods/StoreList")
public class StoreFragment extends MvpFragment<StorePresenter> implements StoreView {
    private RecyclerView Store_Recycler;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.store_fragment,null,false);
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
    protected StorePresenter createPresenter() {
        return new StorePresenter();
    }

    @Override
    public void getViews(View view) {
        Store_Recycler=view.findViewById(R.id.Store_Recycler);
    }


    @Override
    public RecyclerView getStore_Recycler() {
        return Store_Recycler;
    }
}
