package com.example.z_home.HomeItem.CircleList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpActivity;
import com.example.z_home.R;

/**
 * Created by zengwei on 2019/9/8.
 */

@Route(path = "/Home/CircleListActivity")
public class CircleListActivity extends MvpActivity<CircleListPresenter> implements CircleListView {
    private TextView Include_Title_Text;   //页面头文字
    private ImageView Include_Title_Close;  //头部关闭按钮
    private ImageView CircleList_Search;
    private TabLayout CircleList_TabLayout;

    @Autowired
    public String titlec;
    @Autowired
    public String classification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**启动页的图片设置为空**/
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circlelsit_layout);
        ARouter.getInstance().inject(this);
        mvpPresenter.attachView(this);
        getViews();
        mvpPresenter.init();
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
    protected CircleListPresenter createPresenter() {
        return new CircleListPresenter();
    }

    @Override
    public void getViews() {
        Include_Title_Text=findViewById(R.id.Include_Title_Text);
        Include_Title_Close=findViewById(R.id.Include_Title_Close);
        CircleList_Search=findViewById(R.id.CircleList_Search);
        CircleList_TabLayout=findViewById(R.id.CircleList_TabLayout);
    }

    @Override
    public TextView getInclude_Title_Text() {
        return Include_Title_Text;
    }

    @Override
    public ImageView getInclude_Title_Close() {
        return Include_Title_Close;
    }

    @Override
    public ImageView getCircleList_Search() {
        return CircleList_Search;
    }

    @Override
    public TabLayout getCircleList_TabLayout() {
        return CircleList_TabLayout;
    }

    @Override
    public String getTitlec() {
        return titlec;
    }

    @Override
    public String getclassification() {
        return classification;
    }
}
