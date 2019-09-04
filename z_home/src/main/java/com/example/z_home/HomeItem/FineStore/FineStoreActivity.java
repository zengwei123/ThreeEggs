package com.example.z_home.HomeItem.FineStore;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.MvpActivity;
import com.example.z_home.R;

/**
 * Created by zengwei on 2019/9/4.
 */
@Route(path = "/Home/FineStoreActivity")
public class FineStoreActivity extends MvpActivity<FineStorePresenter> implements FineStoreView {
    private TextView Include_Title_Text;   //页面头文字
    private ImageView Include_Title_Close;  //头部关闭按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**启动页的图片设置为空**/
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finestore_layout);
        mvpPresenter.attachView(this);
        getViews();
        mvpPresenter.init();
    }

    @Override
    protected FineStorePresenter createPresenter() {
        return new FineStorePresenter();
    }

    @Override
    public void getViews() {
        Include_Title_Text=findViewById(R.id.Include_Title_Text);
        Include_Title_Close=findViewById(R.id.Include_Title_Close);
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
    public TextView getInclude_Title_Text() {
        return Include_Title_Text;
    }

    @Override
    public ImageView getInclude_Title_Close() {
        return Include_Title_Close;
    }
}
