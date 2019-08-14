package com.example.z_my.History;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.MvpActivity;
import com.example.z_my.R;
import com.necer.calendar.Miui9Calendar;

/**
 * Created by zengwei on 2019/8/11.
 */
@Route(path = "/Me/History")
public class HistoryActivity extends MvpActivity<HistoryPresenter> implements HistoryView {
    private Miui9Calendar History_MIUI9Calendar;
    private RecyclerView History_Recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_layout);
        mvpPresenter.attachView(this);
        getViews();
        mvpPresenter.init();
    }

    @Override
    protected HistoryPresenter createPresenter() {
        return new HistoryPresenter();
    }

    @Override
    public void getViews() {
        History_MIUI9Calendar=findViewById(R.id.History_MIUI9Calendar);
        History_Recycler=findViewById(R.id.History_Recycler);
    }

    @Override
    public Miui9Calendar getHistory_MIUI9Calendar() {
        return History_MIUI9Calendar;
    }

    @Override
    public RecyclerView getHistory_Recycler() {
        return History_Recycler;
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public Activity getThisActivity() {
        return this;
    }
}
