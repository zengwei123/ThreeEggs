package com.example.z_common.NoLR;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.z_base.MvpFragment;
import com.example.z_common.R;

/**
 * Created by zengwei on 2019/7/24.
 * 首页
 */

public class NoLRFragment extends MvpFragment<NoLRPresenter> implements NoLRView {
    private Button button;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.z_nolr_fragment,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter.attachView(this);
        getViews(view);
        mvpPresenter.init();
    }

    public void getViews(View view){
        button=view.findViewById(R.id.button);
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
    protected NoLRPresenter createPresenter() {
        return new NoLRPresenter();
    }


    @Override
    public Button getButton() {
        return button;
    }
}