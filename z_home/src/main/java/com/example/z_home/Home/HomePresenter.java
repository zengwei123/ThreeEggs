package com.example.z_home.Home;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_common.Amap.AmapPositioningUtil;
import com.example.z_common.GlideUtil;
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


        GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.home_camera,mvpView.getHome_Fragment_Image_Shooting());
        GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.home_class,mvpView.getHome_Fragment_Image_Category());

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
        mvpView.getHome_Fragment_Image_Category().setOnClickListener(this);
        mvpView.getHome_Fragment_TextView_Search().setOnClickListener(this);
        mvpView.getHome_Fragment_Image_Location().setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.Home_Fragment_Image_Category) {
            RoutePageActivity.getHomeCategory();
        }else if(i==R.id.Home_Fragment_TextView_Search){
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
                mvpView.getHome_Fragment_Image_Location().setText(str);
                SimpleUtils.setLog("定位位置："+str);
                AmapPositioningUtil.setServicePositioning();
            });
        }else {
            mvpView.getHome_Fragment_Image_Location().setText("定位失败");
        }
    }

    /**获取首页活动和轮播图**/
    public void HomeHead(){
        HomeRequestServiceFactory.HomeHead(new RequestObserver.RequestObserverNext<AllDataState<HomeHead>>() {
            @Override
            public void Next(AllDataState<HomeHead> o) {
//                SimpleUtils.setLog(o.toString());
//                setHeadMenu(o.getData().getMenu());   //菜单设置
//                setHeadShuffling(o.getData().getIndex());  //轮播图设置
//                /**活动图  只拿第一个**/
//                GlideUtil.displayImage(mvpView.getThisActivity(),o.getData().getAd().get(0).getImagePath(),mvpView.getHome_activity());
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
//        List<HomeActivityMenu> list=new ArrayList<>();
//        list.add(new HomeActivityMenu(R.mipmap.main_circle,"","精选店铺",""));
//        list.add(new HomeActivityMenu(R.mipmap.main_circle,"","清凉夏季",""));
//        list.add(new HomeActivityMenu(R.mipmap.main_circle,"","镇店大牌",""));
//        list.add(new HomeActivityMenu(R.mipmap.main_circle,"","附近爆款",""));
//        list.add(new HomeActivityMenu(R.mipmap.main_circle,"","穿搭推荐",""));
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter =new SimpleRecyclerViewAdapter(
                R.layout.home_fragment_recyclerview_activitymenu, mvpView.getActivityContext(), menus,
                (helper, item) -> {
                    /**获取数据**/
                    HomeHead.MenuBean menuBean= ( HomeHead.MenuBean) item;
                    /**价值图片**/
                    GlideUtil.displayImage(mvpView.getThisActivity(),menuBean.getImagePath(), helper.getView(R.id.Home_Fragment_ActivityMenu_Image));
                    /**活动名称**/
                    helper.setText(R.id.Home_Fragment_ActivityMenu_TextView,menuBean.getTitle());
                });
        mvpView.getHome_Fragment_RecyclerView().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getHome_Fragment_RecyclerView().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,menus.size()));
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
