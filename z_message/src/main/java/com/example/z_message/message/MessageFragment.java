package com.example.z_message.message;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;
import com.example.z_message.R;

public class MessageFragment extends MvpFragment<MessagePresenter> implements MessageView {
    private ViewPager Message_ViewPage;
    private TabLayout Message_TabLayout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.message_fragment,null,false);
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
    protected MessagePresenter createPresenter() {
        return new MessagePresenter();
    }

    @Override
    public void getViews(View view) {
        Message_ViewPage=view.findViewById(R.id.Message_ViewPage);
        Message_TabLayout=view.findViewById(R.id.Message_TabLayout);
    }

    @Override
    public ViewPager getMessage_ViewPage() {
        return Message_ViewPage;
    }

    @Override
    public TabLayout getMessage_TabLayout() {
        return Message_TabLayout;
    }
}
