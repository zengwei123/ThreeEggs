package com.example.z_circle.CircleRecyclerList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;
import com.example.z_circle.R;

public class CircleRecyclerListFragment extends MvpFragment<CircleRecyclerListPresenter> implements CircleRecyclerListView {
    private RecyclerView CircleRecyclerList_Recycler;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.circlerecyclerlist_fragment,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(activity.getApplication());
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
    protected CircleRecyclerListPresenter createPresenter() {
        return new CircleRecyclerListPresenter();
    }

    @Override
    public void getViews(View view) {
        CircleRecyclerList_Recycler=view.findViewById(R.id.CircleRecyclerList_Recycler);
    }

    @Override
    public RecyclerView getCircleRecyclerList_Recycler() {
        return CircleRecyclerList_Recycler;
    }
}
