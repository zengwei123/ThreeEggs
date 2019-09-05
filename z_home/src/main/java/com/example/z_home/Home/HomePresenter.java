package com.example.z_home.Home;

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
    @Override
    public void init() {
        setView();
        setClick();
    }

    @Override
    public void setView() {
        /**天气**/
        SimpleUtils.setViewTypeface(mvpView.getHome_Fragment_TextView_Search(),"\uea65搜索商品/店铺");
        mvpView.getHome_Fragment_Image_Location().setOnClickListener(v -> {
           RoutePageActivity.getAddress();
        });
        HomeHead();
    }
    private void setClick(){
        mvpView.getHome_Fragment_TextView_Search().setOnClickListener(this);
        mvpView.getHome_Fragment_Image_Location().setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int i = view.getId();
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
                GlideUtil.roundAngleImage(mvpView.getThisActivity(),o.getData().getAd().get(0).getImagePath(),mvpView.getHome_HuoDong(),80); //活动图
                if (o.getData().getWeather()!=null){
                    setWeather(Integer.parseInt(o.getData().getWeather().getText()),o.getData().getWeather().getTemperature()); //天气
                }
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
        mvpView.getHome_Fragment_RecyclerView().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,4));

        simpleRecyclerViewAdapter.setOnItemClickListener((adapter, view, position) -> {
           switch (position){
               case 0:RoutePageActivity.getFineStore();break;
               case 1:RoutePageActivity.getGoodsItem("新品首发");break;
               case 2:RoutePageActivity.getGoodsItem("新品首发");break;
               case 3:RoutePageActivity.getHomeCategory();break;
           }
        });
    }
    /**设置轮播**/
    private void setHeadShuffling(List<HomeHead.IndexBean> indexBeans){
        /**设置轮播**/
        mvpView.getHome_Fragment_BGABanner().setAdapter((banner, itemView, model, position) ->{
            ImageView imageView= (ImageView) itemView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            GlideUtil.displayImage(mvpView.getThisActivity(),model,imageView);
        });
        List<String> sf=new ArrayList<>();
        for (HomeHead.IndexBean indexBean:indexBeans){
            sf.add(indexBean.getImagePath());
        }
        mvpView.getHome_Fragment_BGABanner().setData(sf, null);
    }
    /**天气设置**/
    private void setWeather(int code,String wndu){
        int image=ImageGallery.weather_10;
        switch (code){
            case 0: image=ImageGallery.weather_10;break;
            case 1: image=ImageGallery.weather_7;break;
            case 2: image=ImageGallery.weather_16;break;
            case 3: image=ImageGallery.weather_19;break;
            case 4: image=ImageGallery.weather_8;break;
            case 5: image=ImageGallery.weather_9;break;
            case 6: image=ImageGallery.weather_17;break;
            case 7: image=ImageGallery.weather_15;break;
            case 8: image=ImageGallery.weather_21;break;
            case 9: image=ImageGallery.weather_5;break;
            case 10: image=ImageGallery.weather_2;break;
            case 11: image=ImageGallery.weather_3;break;
            case 12: image=ImageGallery.weather_12;break;
            case 13: image=ImageGallery.weather_18;break;
            case 14: image=ImageGallery.weather_14;break;
            case 15: image=ImageGallery.weather_20;break;
            case 16: image=ImageGallery.weather_4;break;
            case 17: image=ImageGallery.weather_1;break;
            case 18: image=ImageGallery.weather_13;break;
            case 19: image=ImageGallery.weather_6;break;
            case 20: image=ImageGallery.weather_11;break;
            case 21: image=ImageGallery.weather_15;break;
            case 22: image=ImageGallery.weather_21;break;
            case 23: image=ImageGallery.weather_5;break;
            case 24: image=ImageGallery.weather_2;break;
            case 25: image=ImageGallery.weather_3;break;
            case 26: image=ImageGallery.weather_14;break;
            case 27: image=ImageGallery.weather_20;break;
            case 28: image=ImageGallery.weather_4;break;
        }
        GlideUtil.drawableImage(46,image,mvpView.getHome_Fragment_Image_weather(),true);
        mvpView.getHome_Fragment_Image_weather().setText(wndu);
    }
}
