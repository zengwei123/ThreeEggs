package com.example.z_home.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.BasePresenter;
import com.example.z_common.GlideUtil;
import com.example.z_common.Model.Home.HomeActivityMenu;
import com.example.z_common.SimpleRecyclerViewAdapter;
import com.example.z_common.SimpleUtils;
import com.example.z_home.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zengwei on 2019/7/24.
 */

class HomePresenter extends BasePresenter<HomeView>{
    @Override
    public void init() {
        setView();
        Fragment navigation = (Fragment) ARouter.getInstance().build("/Goods/GoodsList").navigation();
        if(mvpView.getFragmentManagers().beginTransaction()==null){
            Log.d("zengwei123","为空啊");
        }else {
            FragmentTransaction fragmentTransaction=mvpView.getFragmentManagers().beginTransaction();
            if(navigation!=null){
                fragmentTransaction.replace(R.id.GoodsList_Fragment,navigation).commit();
            }else {
                Log.d("zengwei123","界面为空");
            }
        }
    }

    @Override
    public void setView() {
        mvpView.getHome_Fragment_Image_Location().setText("长沙市岳麓区茶子山");
        GlideUtil.displayImage(mvpView.getActivityContext(), R.mipmap.home_camera,mvpView.getHome_Fragment_Image_Shooting());
        GlideUtil.displayImage(mvpView.getActivityContext(), R.mipmap.home_class,mvpView.getHome_Fragment_Image_Class());

        mvpView.getHome_Fragment_Image_Location().setOnClickListener(v -> {
            ARouter.getInstance().build("/Goods/cccc").navigation();
        });

        /**设置轮播**/
        mvpView.getHome_Fragment_BGABanner().setAdapter((banner, itemView, model, position) ->
                GlideUtil.displayImage(mvpView.getActivityContext(),model,(ImageView) itemView));
        mvpView.getHome_Fragment_BGABanner().setData(
                Arrays.asList(R.mipmap.beijin04, R.mipmap.beijin05, R.mipmap.beijin06),
                null
        );

        /**设置活动菜单**/
        List<HomeActivityMenu> list=new ArrayList<>();
        list.add(new HomeActivityMenu(R.mipmap.main_circle,"","精选店铺",""));
        list.add(new HomeActivityMenu(R.mipmap.main_circle,"","清凉夏季",""));
        list.add(new HomeActivityMenu(R.mipmap.main_circle,"","镇店大牌",""));
        list.add(new HomeActivityMenu(R.mipmap.main_circle,"","附近爆款",""));
        list.add(new HomeActivityMenu(R.mipmap.main_circle,"","穿搭推荐",""));
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter1 =new SimpleRecyclerViewAdapter(
                R.layout.home_fragment_recyclerview_activitymenu, mvpView.getActivityContext(), list,
                (helper, item) -> {
                    /**获取数据**/
                    HomeActivityMenu homeActivityMenu= (HomeActivityMenu) item;
                    /**价值图片**/
                    GlideUtil.displayImage(mvpView.getActivityContext(),
                            homeActivityMenu.getImageDrawable(),
                            helper.getView(R.id.Home_Fragment_ActivityMenu_Image));
                    /**活动名称**/
                    helper.setText(R.id.Home_Fragment_ActivityMenu_TextView,homeActivityMenu.getName());
                });
        mvpView.getHome_Fragment_RecyclerView().setAdapter(simpleRecyclerViewAdapter1);
        mvpView.getHome_Fragment_RecyclerView().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,mvpView.getActivityContext(),5));

    }
}
