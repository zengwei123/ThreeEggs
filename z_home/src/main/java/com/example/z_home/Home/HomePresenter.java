package com.example.z_home.Home;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.example.z_base.BasePresenter;
import com.example.z_common.GlideUtil;
import com.example.z_home.Model.HomeActivityMenu;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.RoutePage.RouterPageFragment;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.SimpleUtils;
import com.example.z_home.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zengwei on 2019/7/24.
 */

class HomePresenter extends BasePresenter<HomeView> implements View.OnClickListener {
    @Override
    public void init() {
        setView();
        /**添加推荐布局内容**/
        FragmentTransaction fragmentTransaction=mvpView.getFragmentManagers().beginTransaction();
        fragmentTransaction.replace(R.id.GoodsList_Fragment, RouterPageFragment.grtHomeCategory()).commit();
        /**添加事件**/
        setClick();
    }

    @Override
    public void setView() {
        mvpView.getHome_Fragment_Image_Location().setText("长沙市岳麓区茶子山");
        GlideUtil.displayImage(mvpView.getActivityContext(), R.mipmap.home_camera,mvpView.getHome_Fragment_Image_Shooting());
        GlideUtil.displayImage(mvpView.getActivityContext(), R.mipmap.home_class,mvpView.getHome_Fragment_Image_Category());

        mvpView.getHome_Fragment_Image_Location().setOnClickListener(v -> {
           RoutePageActivity.getAddress();
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
    private void setClick(){
        mvpView.getHome_Fragment_Image_Category().setOnClickListener(this);
        mvpView.getHome_Fragment_TextView_Search().setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.Home_Fragment_Image_Category) {
            RoutePageActivity.getHomeCategory();
        }else if(i==R.id.Home_Fragment_TextView_Search){
            RoutePageActivity.getSearch();
        }
    }
}
