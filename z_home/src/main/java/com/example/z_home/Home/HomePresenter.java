package com.example.z_home.Home;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_common.Amap.AmapPositioningUtil;
import com.example.z_common.GlideUtil;
import com.example.z_common.ImageGallery;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.RoutePage.RouterPageFragment;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_home.Model.HomeHead;
import com.example.z_home.Net.HomeRequestServiceFactory;
import com.example.z_home.R;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by zengwei on 2019/7/24.
 */

class HomePresenter extends BasePresenter<HomeView> implements View.OnClickListener {
    private List<Disposable> disposables;
    @Override
    public void init() {
        setView();
        /**添加推荐布局内容**/
        FragmentTransaction fragmentTransaction=mvpView.getFragmentManagers().beginTransaction();
        fragmentTransaction.replace(R.id.GoodsList_Fragment, RouterPageFragment.grtGoodsList()).commit();
        /**添加事件**/
        setClick();
    }

    @Override
    public void setView() {
        disposables=new ArrayList<>();
        GlideUtil.drawableImage(56, ImageGallery.weather_1,mvpView.getHome_Fragment_Image_weather(),true);
        SimpleUtils.setViewTypeface(mvpView.getHome_Fragment_TextView_Search(),"\uea65搜索商品/店铺");
        mvpView.getHome_Fragment_Image_Location().setOnClickListener(v -> {
           RoutePageActivity.getAddress();
        });
        HomeHead();
    }

    @Override
    public void CloseRequest() {
        for (Disposable disposable:disposables){
            disposable.dispose();
        }
    }

    private void setClick(){
        mvpView.getHome_Fragment_TextView_Search().setOnClickListener(this);
        mvpView.getHome_Fragment_Image_Location().setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int i = view.getId();
        // RoutePageActivity.getHomeCategory();
        if(i==R.id.Home_Fragment_TextView_Search){
            RoutePageActivity.getSearch();
        }else if(i==R.id.Home_Fragment_Image_Location){
            /**当没用定位的时候 停止定位**/
            if (AmapPositioningUtil.getIsPosition()==-1){
                AmapPositioningUtil.getAmapPositioningUtil().StopPositioning();
            }
            RoutePageActivity.getAddress();
        }
    }
    /**定位功能**/
    public void positioning(){
        /**判断是否有定位权限**/
        if(XXPermissions.isHasPermission(BaseActivity.getInstance(), Permission.Group.LOCATION)){
            mvpView.getHome_Fragment_Image_Location().setText("定位中");
            AmapPositioningUtil.getAmapPositioningUtil().StartPositioning(aMapLocation -> {
                String str=AmapPositioningUtil.ParsingAMapLocation(aMapLocation);
                SimpleUtils.setViewTypeface(mvpView.getHome_Fragment_Image_Location(),"\uec74"+str);
                AmapPositioningUtil.setServicePositioning();
            });
        }else {
            SimpleUtils.setViewTypeface(mvpView.getHome_Fragment_Image_Location(),"\uec74定位失败");
        }
    }

    /**获取首页活动和轮播图**/
    public void HomeHead(){
        HomeRequestServiceFactory.HomeHead(new RequestObserver.RequestObserverNext<AllDataState<HomeHead>>() {
            @Override
            public void Next(AllDataState<HomeHead> o) {
                setHeadMenu(o.getData().getMenu());   //菜单设置
                setHeadShuffling(o.getData().getIndex());  //轮播图设置
               // GlideUtil.displayImage(mvpView.getThisActivity(),o.getData().getAd().get(0).getImagePath(),mvpView.getHome_activity()); //活动图
            }
            @Override
            public void onError() { }
            @Override
            public void getDisposable(Disposable d) {
                disposables.add(d);
            }
        });
    }

    /**设置菜单**/
    private void setHeadMenu(List<HomeHead.MenuBean> menus){
        /**设置活动菜单**/
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter =new SimpleRecyclerViewAdapter(R.layout.home_fragment_recyclerview_activitymenu, mvpView.getActivityContext(), menus, (helper, item) -> {
                    /**获取数据**/
                    HomeHead.MenuBean menuBean= ( HomeHead.MenuBean) item;
                    /**价值图片**/
                    GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.common_nodata, helper.getView(R.id.Home_Fragment_ActivityMenu_Image));
                    /**活动名称**/
                    helper.setText(R.id.Home_Fragment_ActivityMenu_TextView,menuBean.getTitle());
                });
        mvpView.getHome_Fragment_RecyclerView().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getHome_Fragment_RecyclerView().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,menus.size()/2));
    }
    /**设置轮播**/
    private void setHeadShuffling(List<HomeHead.IndexBean> indexBeans){
        /**设置轮播**/
        mvpView.getHome_Fragment_BGABanner().setAdapter((banner, itemView, model, position) ->
                GlideUtil.displayImage(mvpView.getThisActivity(),model,(ImageView) itemView));
        List<String> sf=new ArrayList<>();
        for (HomeHead.IndexBean indexBean:indexBeans){
            sf.add(indexBean.getImagePath());
        }
        mvpView.getHome_Fragment_BGABanner().setData(sf, null);
    }

}
