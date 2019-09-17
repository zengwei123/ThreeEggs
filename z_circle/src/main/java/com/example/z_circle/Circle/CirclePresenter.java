package com.example.z_circle.Circle;

import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;

import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_circle.CircleList.CircleListFragment;
import com.example.z_circle.Model.CircleHome;
import com.example.z_circle.Net.CircleRequestServiceFactory;
import com.example.z_circle.R;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.RoutePage.RouterPageFragment;
import com.example.z_common.Util.GlideUtil;
import com.example.z_common.Util.SimpleUtils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class CirclePresenter extends BasePresenter<CircleView> {
    @Override
    public void init() {
        getHomeData();
        setView();
    }

    @Override
    public void setView() {
        setContentRecycler();
        SimpleUtils.setViewTypeface(mvpView.getCircle_Fragment_TextView_Search(),"\uea65搜索感兴趣的内容");

    }

    @Override
    public void CloseRequest() {

    }

    /**获取轮播图和分类的数据**/
    private void getHomeData(){
        CircleRequestServiceFactory.Roundhome(new RequestObserver.RequestObserverNext<AllDataState<CircleHome>>() {
            @Override
            public void Next(AllDataState<CircleHome> o) {
                setHeadShuffling(o.getData().getCarousel());
                setTabLayout();
            }

            @Override
            public void onError() {

            }

            @Override
            public void getDisposable(Disposable d) {

            }
        },mvpView.getActivityContext());
    }
    /**设置轮播**/
    private void setHeadShuffling(List<CircleHome.CarouselBean> carouselBeans){
        mvpView.getCircle_Fragment_BGABanner().setData(carouselBeans, null);
        mvpView.getCircle_Fragment_BGABanner().setAdapter((banner, itemView, model, position) ->{
            CircleHome.CarouselBean carouselBean= (CircleHome.CarouselBean) model;
            ImageView imageView= (ImageView) itemView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            GlideUtil.displayImage(mvpView.getThisActivity(),carouselBean.getPosterUrl(),(ImageView) itemView);
            SimpleUtils.setLog("进入没有+"+position);
        });
    }
    /**设置分类**/
    private void setTabLayout(){
        mvpView.getCircle_Fragment_TabLayout().addTab( mvpView.getCircle_Fragment_TabLayout().newTab().setText("推荐"));
        mvpView.getCircle_Fragment_TabLayout().addTab( mvpView.getCircle_Fragment_TabLayout().newTab().setText("关注"));
        mvpView.getCircle_Fragment_TabLayout().addTab( mvpView.getCircle_Fragment_TabLayout().newTab().setText("附近"));
        mvpView.getCircle_Fragment_TabLayout().addTab( mvpView.getCircle_Fragment_TabLayout().newTab().setText("点亮数"));
        mvpView.getCircle_Fragment_TabLayout().addTab( mvpView.getCircle_Fragment_TabLayout().newTab().setText("点亮数"));
        mvpView.getCircle_Fragment_TabLayout().addTab( mvpView.getCircle_Fragment_TabLayout().newTab().setText("点亮数"));
    }

    public void setContentRecycler() {
        FragmentTransaction fragmentTransaction= BaseActivity.getInstance().getSupportFragmentManager().beginTransaction();
        CircleListFragment fragment= (CircleListFragment) RouterPageFragment.grtCircleList(0,null);
        fragmentTransaction.add(R.id.Circle_Fragment_List, fragment,CircleListFragment.class.getName()).commit();
        mvpView.getCircle_AppBar().addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            TwinklingRefreshLayout twinklingRefreshLayout=fragment.getCircleList_Fragment_TwinklingRefreshLayout();
            if (twinklingRefreshLayout!=null){
                /**解决下滑动冲突**/
                twinklingRefreshLayout.setNestedScrollingEnabled(false);
            }

        });
    }
}
