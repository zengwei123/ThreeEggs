package com.example.z_drawer.Drawer;

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

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.BasePresenter;
import com.example.z_base.MvpFragment;
import com.example.z_common.Main_Me_Listener;
import com.example.z_drawer.R;

/**
 * Created by zengwei on 2019/9/3.
 */
@Route(path = "/Drawer/DrawerFragment")
public class DrawerFragment extends MvpFragment<DrawerPresenter> implements DrawerView{
    private TextView Drawer_ExitBut;
    private RecyclerView Drawer_RecyclerView;
    public Main_Me_Listener main_me_listener;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.drawer_fragemnt,null,false);
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
    protected DrawerPresenter createPresenter() {
        return new DrawerPresenter();
    }

    @Override
    public void getViews(View view) {
        Drawer_ExitBut=view.findViewById(R.id.Drawer_ExitBut);
        Drawer_RecyclerView=view.findViewById(R.id.Drawer_RecyclerView);
    }

    @Override
    public TextView getDrawer_ExitBut() {
        return Drawer_ExitBut;
    }

    @Override
    public RecyclerView getDrawer_RecyclerView() {
        return Drawer_RecyclerView;
    }


    @Override
    public Main_Me_Listener getMain_Me_Listener() {
        return main_me_listener;
    }

    @Override
    public void setMain_Me_Listener(Main_Me_Listener m) {
        main_me_listener=m;
    }
}
