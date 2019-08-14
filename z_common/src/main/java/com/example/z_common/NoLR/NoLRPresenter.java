package com.example.z_common.NoLR;


import android.view.View;

import com.example.z_base.BasePresenter;
import com.example.z_common.RoutePage.RoutePageActivity;

/**
 * Created by zengwei on 2019/7/24.
 */

class NoLRPresenter extends BasePresenter<NoLRView>{
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        mvpView.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoutePageActivity.getLRActivity();
            }
        });
    }

    @Override
    public void CloseRequest() {

    }

}
