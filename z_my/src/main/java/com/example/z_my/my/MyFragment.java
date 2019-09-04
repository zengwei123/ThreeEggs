package com.example.z_my.my;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;
import com.example.z_common.Main_Me_Listener;
import com.example.z_my.R;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/**
 * Created by zengwei on 2019/7/28.
 */

public class MyFragment extends MvpFragment<MyPresenter> implements MyView {
    private TextView My_OpenDrawer;
    private TextView My_UserName;   //用户名
    private ImageView My_UserHead;   //头像
    private TextView My_Signature;   //个性签名
    private TextView My_UserEditor;   //编辑
    private TabLayout My_TabLayout_Class;
    private TabLayout My_TabLayout_Item;

    private RecyclerView My_RecyclerView;  //用户数据

    private TwinklingRefreshLayout My_Fragment_TwinklingRefreshLayout;

    public Main_Me_Listener main_me_listener;
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
    public void getViews(View view) {
        My_OpenDrawer=view.findViewById(R.id.My_OpenDrawer);
        My_UserName=view.findViewById(R.id.My_UserName);
        My_UserHead=view.findViewById(R.id.My_UserHead);
        My_Signature=view.findViewById(R.id.My_Signature);
        My_UserEditor=view.findViewById(R.id.My_UserEditor);
        My_TabLayout_Class=view.findViewById(R.id.My_TabLayout_Class);
        My_TabLayout_Item=view.findViewById(R.id.My_TabLayout_Item);
        My_Fragment_TwinklingRefreshLayout=view.findViewById(R.id.My_Fragment_TwinklingRefreshLayout);
        My_RecyclerView=view.findViewById(R.id.My_RecyclerView);
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
    public TextView getMy_OpenDrawer() {
        return My_OpenDrawer;
    }

    @Override
    public TextView getMy_UserName() {
        return My_UserName;
    }

    @Override
    public ImageView getMy_UserHead() {
        return My_UserHead;
    }

    @Override
    public TextView getMy_Signature() {
        return My_Signature;
    }

    @Override
    public TextView getMy_UserEditor() {
        return My_UserEditor;
    }

    @Override
    public TabLayout getMy_TabLayout_Class() {
        return My_TabLayout_Class;
    }

    @Override
    public TabLayout getMy_TabLayout_Item() {
        return My_TabLayout_Item;
    }

    @Override
    public TwinklingRefreshLayout getMy_Fragment_TwinklingRefreshLayout() {
        return My_Fragment_TwinklingRefreshLayout;
    }

    @Override
    public RecyclerView getMy_RecyclerView() {
        return My_RecyclerView;
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