package com.example.z_circle.CircleList;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.z_base.BasePresenter;
import com.example.z_circle.Model.CircleModel;
import com.example.z_circle.Net.CircleRequestServiceFactory;
import com.example.z_circle.R;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.Util.GlideUtil;
import com.example.z_common.Util.SimpleUtils;
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

        mvpView.getCircleList_Fragment_TwinklingRefreshLayout().setTargetView(mvpView.getCircleList_Recycler());
    }

    @Override
    public void CloseRequest() {

    }

    /**获取数据**/
    private void setRecycler(int CircleType){
        switch (CircleType){
            case 0: //圈子 列表
                setRoundHome(pageindex,mvpView.getSearchParameter());
                break;
            case 1:  //首页item 穿搭推荐
                setHomeItemCircle(pageindex,mvpView.getSearchParameter());
                break;
        }
    }
    /**首页穿搭推荐发按分类查询**/
    public void  categoryName(String categoryName){
        isRecyclerState=true;    //设置显示布局
        pageindex=1;   //设置初始页面
        mvpView.getCircleList_Fragment_TwinklingRefreshLayout().finishLoadmore();  //设置结束加载跟多  允许加载
        mvpView.getCircleList_Fragment_TwinklingRefreshLayout().setEnableLoadmore(true);   //设置允许上拉
        /**判断是哪个加载
         * 0：首页的穿搭推荐
         * 1：圈子界面的内容
         * **/
        switch (mvpView.getCircleType()){
            case 0:setRoundHome(pageindex,categoryName);break;
            case 1: setHomeItemCircle(pageindex,categoryName);break;
        }

    }

    //********************************************************************************************************


    /**首页item 穿搭推荐**/
    private void setHomeItemCircle(int page,String labelId){
        /**如果是上拉 就不需要显示加载框**/
        Context context=mvpView.getActivityContext();
        if (page!=1){
            context=null;
        }
        /**加载数据**/
        CircleRequestServiceFactory.HomeItemCircle(new RequestObserver.RequestObserverNext<AllDataState<CircleModel>>() {
            @Override
            public void Next(AllDataState<CircleModel> o) {
                if (o.isSuccess()){
                    circleModel=o.getData();
                    /**这个就是普通的列表布局**/
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
        },context,page,10,labelId);
    }
    /**这个是布局的切换 及数据的显示**/
    public void setGoodsListRecycler(List<CircleModel.PageBean.ListBean> circleRecyclers){
        /**列表布局的显示  切换布局其实没用 因为不需要切换**/
        SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback= (helper, item) -> {
            CircleModel.PageBean.ListBean circleRecycler = (CircleModel.PageBean.ListBean) item;
            new GlideUtil().roundAngleImage(mvpView.getThisActivity(),circleRecycler.getPosterUrl(),helper.getView(R.id.CircleList_Image),8);
            //标签
            helper.setText(R.id.CircleRecyclerList_Label,circleRecycler.getLabelName());
            //标题内容
            helper.setText(R.id.CircleList_Title,circleRecycler.getRoundTitle());
            //简略内容
            helper.setText(R.id.CircleList_Content,circleRecycler.getRoundDesc());
            //用户名
            helper.setText(R.id.CircleList_Name," "+circleRecycler.getUserName());
            //头像
            GlideUtil.drawableUrlImage(mvpView.getThisActivity(),50, circleRecycler.getHandImg(),helper.getView(R.id.CircleList_Name),true,false);
            //点赞
            SimpleUtils.setViewTypeface((helper.getView(R.id.CircleList_Praise))," "+circleRecycler.getLikeNum());
            if (circleRecycler.isHasLike()){
                ((TextView)helper.getView(R.id.CircleList_Praise)).setTextColor(Color.parseColor("#FD404E"));
                GlideUtil.drawableImage(40,R.mipmap.praise_f_icon,helper.getView(R.id.CircleList_Praise),true);
            }else {
                ((TextView)helper.getView(R.id.CircleList_Praise)).setTextColor(Color.parseColor("#999999"));
                GlideUtil.drawableImage(40,R.mipmap.praise_9_icon,helper.getView(R.id.CircleList_Praise),true);
            }
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

    //********************************************************************************************************

    /**主界面圈子列表item**/
    private void setRoundHome(int page,String labelId){
        Context context=mvpView.getActivityContext();
        if (page!=1){
            context=null;
        }
        CircleRequestServiceFactory.HomeItemCircle(new RequestObserver.RequestObserverNext<AllDataState<CircleModel>>() {
            @Override
            public void Next(AllDataState<CircleModel> o) {
                if (o.isSuccess()){
                    circleModel=o.getData();
                    setRoundHomeGoodsListRecycler(circleModel.getPage().getList());
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
        },context,page,10,labelId);
    }
    /**主界面圈子列表item布局  瀑布流**/
    public void setRoundHomeGoodsListRecycler(List<CircleModel.PageBean.ListBean> circleRecyclers){
        if (pageindex==1){
            SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(
                    R.layout.circlerecyclerlist_fragment_item, mvpView.getActivityContext(),circleRecyclers, (helper, item) -> {
                CircleModel.PageBean.ListBean circleRecycler = (CircleModel.PageBean.ListBean) item;
                //图片
                new GlideUtil().roundAngleImage(mvpView.getThisActivity(),circleRecycler.getPosterUrl(),helper.getView(R.id.CircleRecyclerList_Recycler_Item_Image),8);
                //标签
                helper.setText(R.id.CircleRecyclerList_Recycler_Item_Label,circleRecycler.getLabelName());
                //标题内容
                helper.setText(R.id.CircleRecyclerList_Recycler_Item_Context,circleRecycler.getRoundTitle());
                //用户名
                helper.setText(R.id.CircleRecyclerList_Recycler_Item_Name," "+circleRecycler.getUserName());
                //头像
                GlideUtil.drawableUrlImage(mvpView.getThisActivity(),50, circleRecycler.getHandImg(),helper.getView(R.id.CircleRecyclerList_Recycler_Item_Name),true,false);
                //点赞
                SimpleUtils.setViewTypeface((helper.getView(R.id.CircleRecyclerList_Recycler_Item_Praise))," "+circleRecycler.getLikeNum());
                if (circleRecycler.isHasLike()){
                    ((TextView)helper.getView(R.id.CircleRecyclerList_Recycler_Item_Praise)).setTextColor(Color.parseColor("#FD404E"));
                    GlideUtil.drawableImage(40,R.mipmap.praise_f_icon,helper.getView(R.id.CircleRecyclerList_Recycler_Item_Praise),true);
                }else {
                    ((TextView)helper.getView(R.id.CircleRecyclerList_Recycler_Item_Praise)).setTextColor(Color.parseColor("#999999"));
                    GlideUtil.drawableImage(40,R.mipmap.praise_9_icon,helper.getView(R.id.CircleRecyclerList_Recycler_Item_Praise),true);
                }
            });
            mvpView.getCircleList_Recycler().setAdapter(simpleRecyclerViewAdapter);
            mvpView.getCircleList_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(2,false));
        }else {
            mvpView.getCircleList_Fragment_TwinklingRefreshLayout().finishLoadmore();
            for (CircleModel.PageBean.ListBean listBean:circleRecyclers)
            ((SimpleRecyclerViewAdapter)mvpView.getCircleList_Recycler().getAdapter()).addData(listBean);
        }
    }


    //********************************************************************************************************


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
