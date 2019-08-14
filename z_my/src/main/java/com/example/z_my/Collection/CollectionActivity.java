package com.example.z_my.Collection;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.BasePresenter;
import com.example.z_base.MvpActivity;
import com.example.z_base.MvpFragment;
import com.example.z_my.R;

import java.util.Collection;

/**
 * Created by zengwei on 2019/8/11.
 */
@Route(path = "/Me/Collection")
public class CollectionActivity extends MvpActivity<CollectionPresenter> implements CollectionView {
    private RecyclerView Collection_Recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_layout);
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
    protected CollectionPresenter createPresenter() {
        return new CollectionPresenter();
    }

    @Override
    public void getViews() {
        Collection_Recycler=findViewById(R.id.Collection_Recycler);
    }

    @Override
    public RecyclerView getCollection_Recycler() {
        return Collection_Recycler;
    }
}
