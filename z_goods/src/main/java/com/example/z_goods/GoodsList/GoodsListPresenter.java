package com.example.z_goods.GoodsList;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.z_base.BasePresenter;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.Util.GlideUtil;
import com.example.z_common.Util.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapterCallback;
import com.example.z_goods.Model.GoodsModel;
import com.example.z_goods.Net.GoodsRequestServiceFactory;
import com.example.z_goods.R;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.List;

import javax.microedition.khronos.opengles.GL;

import io.reactivex.disposables.Disposable;

/**
 * Created by zengwei on 2019/7/24.
 * 这个是商品模块的
 */

public class GoodsListPresenter extends BasePresenter<GoodsListView>{
    public boolean isRecyclerState=true;   //当前布局形态
    public int pageindex=1;   //页数
    private SimpleRecyclerViewAdapter RecyclerStyleState1,RecyclerStyleState2;   //切换咨询的
    private GoodsModel goodsModel;   //商品数据

    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        /**上拉刷新**/
        mvpView.getGoodsList_Fragment_TwinklingRefreshLayout().setEnableRefresh(false);
        mvpView.getGoodsList_Fragment_TwinklingRefreshLayout().setEnableOverScroll(false);
        mvpView.getGoodsList_Fragment_TwinklingRefreshLayout().setOnRefreshListener(new RefreshListenerAdapter(){
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {

            }
            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                if (pageindex<goodsModel.getPage().getPages()){
                    pageindex++;
                    setRecycler(mvpView.getGoodsType());
                }else {
                    mvpView.getGoodsList_Fragment_TwinklingRefreshLayout().finishRefreshing();
                    mvpView.getGoodsList_Fragment_TwinklingRefreshLayout().setEnableLoadmore(false);
                    SimpleUtils.setToast("数据全部加载完成");
                }
            }
        });

        setRecycler(mvpView.getGoodsType());
    }

    @Override
    public void CloseRequest() {

    }
    /**获取数据**/
    private void setRecycler(int GoodsType){
        switch (GoodsType){
            case 0:
                setSearchGoodsPage(pageindex,mvpView.getSearchParameter());
                break;
            case 1:  //首页item 新品首发
                setHomeItemGoods(pageindex,null);
                break;
            case 2:  //首页好物热购
                setHomeHotGoods();
                break;
        }
    }





    /**首页item 新品首发**/
    private void setHomeItemGoods(int page,String categoryName){
        SimpleUtils.setLog("看看："+mvpView.getGoodsType());
        GoodsRequestServiceFactory.HomeItemGoods(new RequestObserver.RequestObserverNext<AllDataState<GoodsModel>>() {
            @Override
            public void Next(AllDataState<GoodsModel> o) {
                if (o.isSuccess()){
                    goodsModel=o.getData();
                    SimpleUtils.setLog(o.toString());
                    SimpleUtils.setLog(goodsModel.toString());
                    setGoodsListRecycler(goodsModel.getPage().getList(),true);
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
        },mvpView.getActivityContext(),page,categoryName);
    }
    /**首页新品首发按分类查询**/
    public void  categoryName(String categoryName){
        isRecyclerState=true;    //设置显示布局
        pageindex=1;   //设置初始页面
        mvpView.getGoodsList_Fragment_TwinklingRefreshLayout().finishLoadmore();  //设置结束加载跟多  允许加载
        mvpView.getGoodsList_Fragment_TwinklingRefreshLayout().setEnableLoadmore(true);   //设置允许上拉
        setHomeItemGoods(pageindex,categoryName);
    }








    /**搜索商品**/
    private void setSearchGoodsPage(int page,String keyword){
        GoodsRequestServiceFactory.setSearchGoodsPage(new RequestObserver.RequestObserverNext<AllDataState<GoodsModel>>() {
            @Override
            public void Next(AllDataState<GoodsModel> o) {
                if (o.isSuccess()){
                    goodsModel=o.getData();
                    SimpleUtils.setLog(o.toString());
                    SimpleUtils.setLog(goodsModel.toString());
                    setGoodsListRecycler(goodsModel.getPage().getList(),true);
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
        },mvpView.getActivityContext(),null,keyword,100000000+"",
                null,null,null,null,null,page+"");
    }
    /**首页新品首发按分类查询**/
    public void  keywordName(String keywordName){
        isRecyclerState=true;    //设置显示布局
        pageindex=1;   //设置初始页面
        mvpView.getGoodsList_Fragment_TwinklingRefreshLayout().finishLoadmore();  //设置结束加载跟多  允许加载
        mvpView.getGoodsList_Fragment_TwinklingRefreshLayout().setEnableLoadmore(true);   //设置允许上拉
        setSearchGoodsPage(pageindex,keywordName);
    }





    /**首页好物热购**/
    private void setHomeHotGoods(){
        mvpView.getGoodsList_Fragment_TwinklingRefreshLayout().setEnableLoadmore(false);   //设置允许上拉
        mvpView.getGoodsList_Fragment_TwinklingRefreshLayout().setNestedScrollingEnabled(false);   //这里设置为false,放弃自己的滑动,交给外部的NestedScrollView处理,
        GoodsRequestServiceFactory.HomeHotGoods(new RequestObserver.RequestObserverNext<AllDataState<GoodsModel>>() {
            @Override
            public void Next(AllDataState<GoodsModel> o) {
                if (o.isSuccess()){
                    goodsModel=o.getData();
                    isRecyclerState=false;
                    SimpleUtils.setLog(o.toString());
                    SimpleUtils.setLog(goodsModel.toString());
                    setGoodsListRecycler(goodsModel.getPage().getList(),false);
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
        },1,2);

    }







    /**这个是布局的切换 及数据的显示**/
    public void setGoodsListRecycler(List<GoodsModel.PageBean.ListBean> goodsRecyclers,boolean isNoScroll){
        SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback= (helper, item) -> {
            GoodsModel.PageBean.ListBean goodsRecycler = (GoodsModel.PageBean.ListBean) item;
            //图片
            GlideUtil.displayImage(mvpView.getThisActivity(),goodsRecycler.getImage(), helper.getView(R.id.GL_Recycler_information_Image));
            //标题
            helper.setText(R.id.GL_Recycler_information_Title, goodsRecycler.getTitle());
            //收藏
            SimpleUtils.setViewTypeface(helper.getView(R.id.GL_Recycler_information_Collection)," "+goodsRecycler.getCollectNum()+"人");
            GlideUtil.drawableImage(30,R.mipmap.collection_9_icon,helper.getView(R.id.GL_Recycler_information_Collection),true);
            //价格
            helper.setText(R.id.GL_Recycler_information_Price,"￥"+ SimpleUtils.getPrice(goodsRecycler.getPrice()));
            //标签
            helper.setText(R.id.GL_Recycler_information_Introduce, goodsRecycler.getSellPoint());
            //地址
            SimpleUtils.setViewTypeface(helper.getView(R.id.GL_Recycler_information_Address)," "+goodsRecycler.getAddress());
            GlideUtil.drawableImage(30,R.mipmap.positioning_icon,helper.getView(R.id.GL_Recycler_information_Address),true);
        };
        /**页面数为1的时候是第一次加载**/
        if (pageindex==1){
            /**准备切换的布局**/
            RecyclerStyleState1=new SimpleRecyclerViewAdapter(R.layout.goodslist_recycler_information1, mvpView.getActivityContext(), goodsRecyclers,simpleRecyclerViewAdapterCallback);
            RecyclerStyleState2=new SimpleRecyclerViewAdapter(R.layout.goodslist_recycler_information2, mvpView.getActivityContext(), goodsRecyclers,simpleRecyclerViewAdapterCallback);
            if (isNoScroll){
                switchRecycler(isRecyclerState,mvpView.getGoodsList_Recycler(),null);
            }else {
                NoScrollswitchRecycler(isRecyclerState,mvpView.getGoodsList_Recycler(),null);
            }
        }else {
            /**其他的时候是加载更多**/
            mvpView.getGoodsList_Fragment_TwinklingRefreshLayout().finishLoadmore();
            for (GoodsModel.PageBean.ListBean listBean:goodsRecyclers){
                RecyclerStyleState1.addData(listBean);
                RecyclerStyleState2.addData(listBean);
            }
        }

    }
    /**切换布局状态方法**/
    public void setSWitch(TextView textView){
        /**显示默认的布局状态**/
        switchRecycler(isRecyclerState,mvpView.getGoodsList_Recycler(),textView);
        if (textView!=null){
            textView.setOnClickListener(v -> {
                /**切换布局状态**/
                switchRecycler(isRecyclerState,mvpView.getGoodsList_Recycler(),textView);
            });
        }
    }
    /**切换推荐商品布局状态**/
    private void switchRecycler(boolean b, RecyclerView recyclerView,  TextView textView){
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

    /**首页禁止滑动的布局状态**/
    private void NoScrollswitchRecycler(boolean b, RecyclerView recyclerView,  TextView textView){
        if(b){
            recyclerView.setAdapter(RecyclerStyleState1);
            recyclerView.setLayoutManager(SimpleUtils.getNoScrollRecyclerLayoutManager(false,2));
            isRecyclerState=false;
            if (textView!=null)
                SimpleUtils.setViewTypeface(textView,"\ue90d");
        }else {
            recyclerView.setAdapter(RecyclerStyleState2);
            recyclerView.setLayoutManager(SimpleUtils.getNoScrollRecyclerLayoutManager(false,2));
            isRecyclerState=true;
            if (textView!=null)
                SimpleUtils.setViewTypeface(textView,"\ue90c");
        }
    }
}
