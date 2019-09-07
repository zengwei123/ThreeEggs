package com.example.z_goods.GoodsList;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BasePresenter;
import com.example.z_common.GlideUtil;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapterCallback;
import com.example.z_goods.Model.GoodsModel;
import com.example.z_goods.Net.GoodsRequestServiceFactory;
import com.example.z_goods.R;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by zengwei on 2019/7/24.
 */

public class GoodsListPresenter extends BasePresenter<GoodsListView>{
    private boolean isRecyclerState=true;
    private SimpleRecyclerViewAdapter RecyclerStyleState1,RecyclerStyleState2;   //切换咨询的
    private GoodsModel goodsModel;

    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        setRecycler(mvpView.getGoodsType());
    }

    @Override
    public void CloseRequest() {

    }
    /**获取数据**/
    private void setRecycler(int GoodsType){
        switch (GoodsType){
            case 0:
                setSearchGoodsPage(mvpView.getSearchParameter());
                break;
            case 1:  //首页item 新品首发
                setHomeItemGoods(1);
                break;
        }
    }
    /**首页item 新品首发**/
    private void setHomeItemGoods(int page){
        GoodsRequestServiceFactory.HomeItemGoods(new RequestObserver.RequestObserverNext<AllDataState<GoodsModel>>() {
            @Override
            public void Next(AllDataState<GoodsModel> o) {
                if (o.isSuccess()){
                    goodsModel=o.getData();
                    SimpleUtils.setLog(o.toString());
                    SimpleUtils.setLog(goodsModel.toString());
                    setGoodsListRecycler(goodsModel.getPage().getList());
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
        },mvpView.getActivityContext(),page);
    }
    /**首页item 新品首发**/
    private void setSearchGoodsPage(String keyword){
        GoodsRequestServiceFactory.setSearchGoodsPage(new RequestObserver.RequestObserverNext<AllDataState<GoodsModel>>() {
            @Override
            public void Next(AllDataState<GoodsModel> o) {
                if (o.isSuccess()){
                    goodsModel=o.getData();
                    SimpleUtils.setLog(o.toString());
                    SimpleUtils.setLog(goodsModel.toString());
                    setGoodsListRecycler(goodsModel.getPage().getList());
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
                null,null,null,null,null,1+"");
    }

    /**这个是布局的切换 及数据的显示**/
    public void setGoodsListRecycler(List<GoodsModel.PageBean.ListBean> goodsRecyclers){
        SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback= (helper, item) -> {
            GoodsModel.PageBean.ListBean goodsRecycler = (GoodsModel.PageBean.ListBean) item;
            GlideUtil.displayImage(mvpView.getThisActivity(),goodsRecycler.getImage(), helper.getView(R.id.GL_Recycler_information_Image));
            helper.setText(R.id.GL_Recycler_information_Title, goodsRecycler.getTitle());
            SimpleUtils.setViewTypeface(helper.getView(R.id.GL_Recycler_information_Collection),"\ue83a"+goodsRecycler.getCollectNum()+"人收藏");
            helper.setText(R.id.GL_Recycler_information_Price,"￥"+ goodsRecycler.getPrice());
            helper.setText(R.id.GL_Recycler_information_Introduce, "商品特色..");
            SimpleUtils.setViewTypeface(helper.getView(R.id.GL_Recycler_information_Address),"\uea7c"+goodsRecycler.getAddress());
        };
        /**准备切换的布局**/
        RecyclerStyleState1=new SimpleRecyclerViewAdapter(R.layout.goodslist_recycler_information1, mvpView.getActivityContext(), goodsRecyclers,simpleRecyclerViewAdapterCallback);
        RecyclerStyleState2=new SimpleRecyclerViewAdapter(R.layout.goodslist_recycler_information2, mvpView.getActivityContext(), goodsRecyclers,simpleRecyclerViewAdapterCallback);
        switchRecycler(isRecyclerState,mvpView.getGoodsList_Recycler(),null);
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
}
