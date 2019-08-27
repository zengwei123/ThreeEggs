package com.example.z_base;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;


/**
 * Created by zengwei on 2018/8/22.
 */

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity  {
    protected P mvpPresenter;
    protected abstract P createPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
        hiddenBar();
        /**状态栏 深色模式 6.0+**/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }else {  /**设置状态栏颜色 6.0-**/
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.Hei));
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
            mvpPresenter =null;
        }
    }

    public abstract void getViews();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mvpPresenter.CloseRequest();
    }
}
