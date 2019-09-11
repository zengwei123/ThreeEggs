package com.example.zengwei.threeeggs.Main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.MvpActivity;
import com.example.z_base.ViewBind;
import com.example.z_common.Custom.NoScrollViewPager;
import com.example.zengwei.threeeggs.R;


/**
 * Created by zengwei on 2019/7/21.
 * 主布局界面
 */
@Route(path = "/Main/MainActivity")
public class MainActivity extends MvpActivity<MainPresenter> implements MainView {
    @ViewBind(R.id.Main_ViewPager)
    private NoScrollViewPager Main_ViewPager;

    @ViewBind(R.id.Main_Home_Tab)
    private RelativeLayout Main_Home_Tab;
    @ViewBind(R.id.Main_Circle_Tab)
    private RelativeLayout Main_Circle_Tab;
    @ViewBind(R.id.Main_Add_Tab)
    private RelativeLayout Main_Add_Tab;
    @ViewBind(R.id.Main_Message_Tab)
    private RelativeLayout Main_Message_Tab;
    @ViewBind(R.id.Main_Personal_Tab)
    private RelativeLayout Main_Personal_Tab;

    @ViewBind(R.id.Main_Home_Tab_Image)
    private ImageView Main_Home_Tab_Image;
    @ViewBind(R.id.Main_Circle_Tab_Image)
    private ImageView Main_Circle_Tab_Image;
    @ViewBind(R.id.Main_Message_Tab_Image)
    private ImageView Main_Message_Tab_Image;
    @ViewBind(R.id.Main_Personal_Tab_Image)
    private ImageView Main_Personal_Tab_Image;
    @ViewBind(R.id.Main_DrawerLayout)
    private DrawerLayout Main_DrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**启动页的图片设置为空**/
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        mvpPresenter.attachView(this);
        super.injectViews();
        mvpPresenter.init();
    }

    @Override
    public void getViews() {
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
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public NoScrollViewPager getMain_ViewPager() {
        return Main_ViewPager;
    }

    @Override
    public RelativeLayout getMain_Home_Tab() {
        return Main_Home_Tab;
    }

    @Override
    public RelativeLayout getMain_Circle_Tab() {
        return Main_Circle_Tab;
    }

    @Override
    public RelativeLayout getMain_Add_Tab() {
        return Main_Add_Tab;
    }

    @Override
    public RelativeLayout getMain_Message_Tab() {
        return Main_Message_Tab;
    }

    @Override
    public RelativeLayout getMain_Personal_Tab() {
        return Main_Personal_Tab;
    }

    @Override
    public ImageView getMain_Home_Tab_Image() {
        return Main_Home_Tab_Image;
    }

    @Override
    public ImageView getMain_Circle_Tab_Image() {
        return Main_Circle_Tab_Image;
    }

    @Override
    public ImageView getMain_Message_Tab_Image() {
        return Main_Message_Tab_Image;
    }

    @Override
    public ImageView getMain_Personal_Tab_Image() {
        return Main_Personal_Tab_Image;
    }

    @Override
    public DrawerLayout getMain_DrawerLayout() {
        return Main_DrawerLayout;
    }

    @Override
    public void onBackPressed() {
        OnTwoBack();
    }
}
