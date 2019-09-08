package com.example.z_circle.CircleList;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.z_base.BasePresenter;
import com.example.z_circle.Model.CircleList;
import com.example.z_circle.Model.CircleModel;
import com.example.z_circle.Net.CircleRequestServiceFactory;
import com.example.z_circle.R;
import com.example.z_common.GlideUtil;
import com.example.z_common.ImageGallery;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapterCallback;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class CircleListPresenter extends BasePresenter<CircleListView> {
    public boolean isRecyclerState=true;   //当前布局形态
    public int pageindex=1;   //页数
    private SimpleRecyclerViewAdapter RecyclerStyleState1,RecyclerStyleState2;   //切换咨询的
    private CircleModel circleModel;
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        /**上拉刷新**/
        mvpView.getCircleList_Fragment_TwinklingRefreshLayout().setEnableRefresh(false);
        mvpView.getCircleList_Fragment_TwinklingRefreshLayout().setEnableOverScroll(false);
        mvpView.getCircleList_Fragment_TwinklingRefreshLayout().setOnRefreshListener(new RefreshListenerAdapter(){
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {

            }
            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                if (pageindex<circleModel.getPage().getPages()){
                    pageindex++;
                    setRecycler(mvpView.getCircleType());
                }else {
                    mvpView.getCircleList_Fragment_TwinklingRefreshLayout().finishRefreshing();
                    mvpView.getCircleList_Fragment_TwinklingRefreshLayout().setEnableLoadmore(false);
                    SimpleUtils.setToast("数据全部加载完成");
                }
            }
        });

        setRecycler(mvpView.getCircleType());
    }

    @Override
    public void CloseRequest() {

    }

    /**获取数据**/
    private void setRecycler(int GoodsType){
        switch (GoodsType){
            case 0:
                // setSearchGoodsPage(pageindex,mvpView.getSearchParameter());
                break;
            case 1:  //首页item 穿搭推荐
                setHomeItemCircle(pageindex,mvpView.getSearchParameter());
                break;
        }
    }

    /**首页item 新品首发**/
    private void setHomeItemCircle(int page,String labelId){
        CircleRequestServiceFactory.HomeItemCircle(new RequestObserver.RequestObserverNext<AllDataState<CircleModel>>() {
            @Override
            public void Next(AllDataState<CircleModel> o) {
                if (o.isSuccess()){
                    circleModel=o.getData();
                    setGoodsListRecycler(circleModel.getPage().getList());
                }else {
                    SimpleUtils.setToast(o.getMessage());
                }
            }

            @Override
            public void onError() {

            }

            @Override
            public void getDisposable(Disposable d) {

            }
        },mvpView.getActivityContext(),page,10,labelId);
    }
    /**首页新品首发按分类查询**/
    public void  categoryName(String categoryName){
        isRecyclerState=true;    //设置显示布局
        pageindex=1;   //设置初始页面
        mvpView.getCircleList_Fragment_TwinklingRefreshLayout().finishLoadmore();  //设置结束加载跟多  允许加载
        mvpView.getCircleList_Fragment_TwinklingRefreshLayout().setEnableLoadmore(true);   //设置允许上拉
        setHomeItemCircle(pageindex,categoryName);
    }



    /**这个是布局的切换 及数据的显示**/
    public void setGoodsListRecycler(List<CircleModel.PageBean.ListBean> circleRecyclers){
        SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback= (helper, item) -> {
            CircleModel.PageBean.ListBean circleRecycler = (CircleModel.PageBean.ListBean) item;
            GlideUtil.displayImage(mvpView.getThisActivity(),circleRecycler.getPosterUrl(), helper.getView(R.id.CircleList_Image));   //海报图片
            helper.setText(R.id.CircleList_Title, circleRecycler.getRoundTitle());   //标题
            helper.setText(R.id.CircleList_Content,circleRecycler.getRoundDesc());
            helper.setText(R.id.CircleList_Name, " "+circleRecycler.getUserName());
            GlideUtil.drawableUrlImage(mvpView.getThisActivity(),30,circleRecycler.getHandImg(),helper.getView(R.id.CircleList_Name),true,false);
            SimpleUtils.setViewTypeface(helper.getView(R.id.CircleList_Praise),"点赞"+circleRecycler.getLikeNum());
            GlideUtil.drawableUrlImage(mvpView.getThisActivity(),30, ImageGallery.praise,helper.getView(R.id.CircleList_Praise),true,true);

            SimpleUtils.setLog(circleRecycler.getPosterUrl()+"--"+circleRecycler.getRoundTitle()+"--"+circleRecycler.getCollectNum());
        };
        /**页面数为1的时候是第一次加载**/
        if (pageindex==1){
            /**准备切换的布局**/
            RecyclerStyleState1=new SimpleRecyclerViewAdapter(R.layout.circlelist_recycler_item, mvpView.getActivityContext(), circleRecyclers,simpleRecyclerViewAdapterCallback);
            RecyclerStyleState2=new SimpleRecyclerViewAdapter(R.layout.circlelist_recycler_item1, mvpView.getActivityContext(), circleRecyclers,simpleRecyclerViewAdapterCallback);
            switchRecycler(isRecyclerState,mvpView.getCircleList_Recycler(),null);
        }else {
            /**其他的时候是加载更多**/
            mvpView.getCircleList_Fragment_TwinklingRefreshLayout().finishLoadmore();
            for (CircleModel.PageBean.ListBean listBean:circleRecyclers){
                RecyclerStyleState1.addData(listBean);
                RecyclerStyleState2.addData(listBean);
            }
        }

    }
    /**切换布局状态方法**/
    public void setSWitch(TextView textView){
        /**显示默认的布局状态**/
        switchRecycler(isRecyclerState,mvpView.getCircleList_Recycler(),textView);
        if (textView!=null){
            textView.setOnClickListener(v -> {
                /**切换布局状态**/
                switchRecycler(isRecyclerState,mvpView.getCircleList_Recycler(),textView);
            });
        }
    }
    /**切换推荐商品布局状态**/
    private void switchRecycler(boolean b, RecyclerView recyclerView, TextView textView){
        if(b){
            recyclerView.setAdapter(RecyclerStyleState1);
            recyclerView.setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
            isRecyclerState=false;
            if (textView!=null)
                SimpleUtils.setViewTypeface(textView,"\ue90d");
        }else {
            recyclerView.setAdapter(RecyclerStyleState2);
            recyclerView.setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,2));
            isRecyclerState=true;
            if (textView!=null)
                SimpleUtils.setViewTypeface(textView,"\ue90c");
        }
    }
}
