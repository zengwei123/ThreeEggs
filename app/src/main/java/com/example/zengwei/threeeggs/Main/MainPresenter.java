package com.example.zengwei.threeeggs.Main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.z_base.BasePresenter;
import com.example.z_base.MvpFragment;
import com.example.z_circle.Circle.CircleFragment;
import com.example.z_common.Custom.Dialog.LottieDialog;
import com.example.z_common.NoLR.NoLRFragment;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.SimpleFragmentAdapter;
import com.example.z_common.SimpleUtils;
import com.example.z_home.Home.HomeFragment;
import com.example.z_message.message.MessageFragment;
import com.example.z_my.my.MyFragment;
import com.example.zengwei.threeeggs.MainRequestServiceFactory;
import com.example.zengwei.threeeggs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwei on 2019/7/21.
 */

public class MainPresenter extends BasePresenter<MainView> {
    private int fragmentid=0;
    @Override
    public void init() {
        SimpleUtils.getPermissions();
        setView();
        Request();
    }

    @Override
    public void setView() {
        /**主界面的4个模块**/
        List<MvpFragment> fragments=new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CircleFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MyFragment());
        SimpleFragmentAdapter simpleFragmentAdapter=new SimpleFragmentAdapter( ((FragmentActivity)mvpView.getThisActivity()).getSupportFragmentManager(),fragments);
        mvpView.getMain_ViewPager().setAdapter(simpleFragmentAdapter);

        /**加载页面数量**/
        mvpView.getMain_ViewPager().setOffscreenPageLimit(4);
        mvpView.getMain_TabLayout().addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==3){
                    if(!SimpleUtils.IsLogin()){
                        mvpView.getMain_TabLayout().getTabAt(fragmentid).select();
                        RoutePageActivity.getLRActivity();
                        return;
                    }
                }
                switch (tab.getPosition()){
                    case 0: tab.setIcon(R.mipmap.main_home);  break;
                    case 1: tab.setIcon(R.mipmap.main_circle); break;
                    case 2: tab.setIcon(R.mipmap.main_order); break;
                    case 3: tab.setIcon(R.mipmap.main_personal); break;
                }
                mvpView.getMain_ViewPager().setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                fragmentid=tab.getPosition();
                switch (tab.getPosition()){
                    case 0: tab.setIcon(R.mipmap.main_home1); break;
                    case 1: tab.setIcon(R.mipmap.main_circle1); break;
                    case 2: tab.setIcon(R.mipmap.main_order1);break;
                    case 3: tab.setIcon(R.mipmap.main_personal1); break;
                }
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

//        /**两个控件绑定起来**/
//        mvpView.getMain_TabLayout().setupWithViewPager(mvpView.getMain_ViewPager());
//
//        /**设置图标  ViewPage跟Tablayout绑定后 绑定后会清除 妈的**/
//        mvpView.getMain_TabLayout().getTabAt(0).setIcon(R.mipmap.main_home);
//        mvpView.getMain_TabLayout().getTabAt(1).setIcon(R.mipmap.main_circle1);
//        mvpView.getMain_TabLayout().getTabAt(2).setIcon(R.mipmap.main_order1);
//        mvpView.getMain_TabLayout().getTabAt(3).setIcon(R.mipmap.main_personal1);

    }

    @Override
    public void CloseRequest() {

    }

    /**网络请求**/
    private void Request(){
        /**是否需要更新**/
        /**设置一下dialog的显示界面**/
        LottieDialog.setDialogWindow(mvpView.getActivityContext());
        MainRequestServiceFactory.ApkDetection();
    }
}
