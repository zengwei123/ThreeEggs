package com.example.zengwei.threeeggs.Main;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;

import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_base.MvpFragment;
import com.example.z_circle.Circle.CircleFragment;
import com.example.z_common.GlideUtil;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.RoutePage.RouterPageFragment;
import com.example.z_common.SimpleFragmentAdapter;
import com.example.z_common.SimpleUtils;
import com.example.z_drawer.Drawer.DrawerFragment;
import com.example.z_home.Home.HomeFragment;
import com.example.z_message.message.MessageFragment;
import com.example.z_my.my.MyFragment;
import com.example.zengwei.threeeggs.MainRequestServiceFactory;
import com.example.zengwei.threeeggs.R;
import com.example.zengwei.threeeggs.Service.MyNotificationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwei on 2019/7/21.
 */

public class MainPresenter extends BasePresenter<MainView> implements View.OnClickListener{
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
        MyFragment myFragment=new MyFragment();
        myFragment.setMain_Me_Listener(() -> {
            mvpView.getMain_DrawerLayout().openDrawer(Gravity.LEFT);
        });
        fragments.add(myFragment);
        SimpleFragmentAdapter simpleFragmentAdapter=new SimpleFragmentAdapter( ((FragmentActivity)mvpView.getThisActivity()).getSupportFragmentManager(),fragments);
        mvpView.getMain_ViewPager().setAdapter(simpleFragmentAdapter);
        /**加载页面数量**/
        mvpView.getMain_ViewPager().setOffscreenPageLimit(4);

        setClick();
        setDrawer();


    }

    @Override
    public void CloseRequest() {

    }

    /**网络请求**/
    private void Request(){
        /**是否需要更新**/
        /**设置一下dialog的显示界面**/
       // LottieDialog.setDialogWindow(mvpView.getActivityContext());
        MainRequestServiceFactory.ApkDetection();

    }
    /**侧滑菜单**/
    private void setDrawer(){
        /**设置侧滑布局的退出登录事件**/
        FragmentTransaction fragmentTransaction= BaseActivity.getInstance().getSupportFragmentManager().beginTransaction();
        DrawerFragment fragment= (DrawerFragment) RouterPageFragment.grtDrawerFragment();
        fragment.setMain_Me_Listener(() -> {
            mvpView.getMain_DrawerLayout().closeDrawers();
            mvpView.getMain_Home_Tab().callOnClick();
        });
        fragmentTransaction.add(R.id.Main_DrawerFragment, fragment,DrawerFragment.class.getName()).commit();
        /**侧滑菜单控制**/
        mvpView.getMain_DrawerLayout().setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mvpView.getMain_DrawerLayout().addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {}
            @Override
            public void onDrawerOpened(View drawerView) {
                mvpView.getMain_DrawerLayout().setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                mvpView.getMain_DrawerLayout().setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            }
            @Override
            public void onDrawerStateChanged(int newState) {}
        });
    }

    private void setClick(){
        mvpView.getMain_Home_Tab().setOnClickListener(this);
        mvpView.getMain_Circle_Tab().setOnClickListener(this);
        mvpView.getMain_Message_Tab().setOnClickListener(this);
        mvpView.getMain_Personal_Tab().setOnClickListener(this);
        mvpView.getMain_Add_Tab().setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int i=v.getId();
        if (i==R.id.Main_Home_Tab){
            TabImage();
            GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.main_home,mvpView.getMain_Home_Tab_Image());
            mvpView.getMain_ViewPager().setCurrentItem(0);
        }else if (i==R.id.Main_Circle_Tab){
            TabImage();
            GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.main_circle,mvpView.getMain_Circle_Tab_Image());
            mvpView.getMain_ViewPager().setCurrentItem(1);
        }else if (i==R.id.Main_Add_Tab){
            RoutePageActivity.getIssueActivity();
        }else if (i==R.id.Main_Message_Tab){
            TabImage();
            GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.main_order,mvpView.getMain_Message_Tab_Image());
            mvpView.getMain_ViewPager().setCurrentItem(2);
        }else if (i==R.id.Main_Personal_Tab){
            if(!SimpleUtils.IsLogin()){
                RoutePageActivity.getLRActivity();
                return;
            }else {
                TabImage();
                GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.main_personal,mvpView.getMain_Personal_Tab_Image());
                mvpView.getMain_ViewPager().setCurrentItem(3);
            }
        }
    }

    private void TabImage(){
        GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.main_home1,mvpView.getMain_Home_Tab_Image());
        GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.main_circle1,mvpView.getMain_Circle_Tab_Image());
        GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.main_order1,mvpView.getMain_Message_Tab_Image());
        GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.main_personal1,mvpView.getMain_Personal_Tab_Image());
    }

}
