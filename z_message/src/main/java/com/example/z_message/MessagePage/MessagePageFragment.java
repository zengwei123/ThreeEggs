package com.example.z_message.MessagePage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.z_base.BasePresenter;
import com.example.z_base.MvpFragment;
import com.example.z_message.R;

/**
 * Created by zengwei on 2019/9/1.
 */

public class MessagePageFragment extends MvpFragment<MessagePagePresenter> implements MessagePageView {
    private RecyclerView MessagePage_Recycler;
    public int MESSAGE_TYPE=0;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.messagepage_fragment,null,false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter.attachView(this);
        getViews(view);
        mvpPresenter.init();
    }

    @Override
    protected MessagePagePresenter createPresenter() {
        return new MessagePagePresenter();
    }

    @Override
    public void getViews(View view) {
        MessagePage_Recycler=view.findViewById(R.id.MessagePage_Recycler);
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
    public RecyclerView getMessagePage_Recycler() {
        return MessagePage_Recycler;
    }
}
