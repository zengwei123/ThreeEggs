package com.example.z_goods.GoodsList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.z_base.BasePresenter;
import com.example.z_common.GlideUtil;
import com.example.z_common.Model.Home.HomeGoodsRecycler;
import com.example.z_common.SimpleRecyclerViewAdapter;
import com.example.z_common.SimpleRecyclerViewAdapterCallback;
import com.example.z_common.SimpleUtils;
import com.example.z_goods.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwei on 2019/7/24.
 */

public class GoodsListPresenter extends BasePresenter<GoodsListView>{
    private boolean isRecyclerState=true;
    private SimpleRecyclerViewAdapter RecyclerStyleState1,RecyclerStyleState2;   //切换咨询的

    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        mvpView.getGoodsList_Comprehensive().setText("综合");
        mvpView.getGoodsList_Sales().setText("销量");
        mvpView.getGoodsList_Price().setText("价格");
        mvpView.getGoodsList_Distance().setText("距离");

        /**首页的推荐不需要筛选  这里吧筛选当作样式切换**/
        mvpView.getGoodsList_Style().setVisibility(View.INVISIBLE);

        /**设置推挤数据**/
        List<HomeGoodsRecycler> homeGoodsRecyclers=new ArrayList<>();
        for (int i=0;i<10;i++){
            homeGoodsRecyclers.add(new HomeGoodsRecycler("",
                    "商品的长标题商品的长标题商品的长标题商品的长标题商品的长标题商品的长标题",
                    "88","1111","1234","北京故宫","司马的店铺"+i));
        }
        /**切换列表的**/
        setGoodsListRecycler(mvpView.getGoodsList_Recycler(),
                homeGoodsRecyclers,
                mvpView.getActivityContext(),
                mvpView.getGoodsList_Screening());
    }
    /**这个是布局的切换 及数据的显示**/
    private void setGoodsListRecycler(RecyclerView recycler,
                                            List<HomeGoodsRecycler> homeGoodsRecyclers,
                                            Context context,ImageView imageView){
        SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback= (helper, item) -> {
            HomeGoodsRecycler homeGoodsRecycler= (HomeGoodsRecycler) item;
            GlideUtil.displayImage(mvpView.getActivityContext(),
                    R.mipmap.beijin04,
                   helper.getView(R.id.GL_Recycler_information_Image));
            helper.setText(R.id.GL_Recycler_information_Title,homeGoodsRecycler.getTitle());
            helper.setText(R.id.GL_Recycler_information_Price,"￥"+homeGoodsRecycler.getPrice());
            helper.setText(R.id.GL_Recycler_information_Other,homeGoodsRecycler.getBuyNumber()+"付款  "+homeGoodsRecycler.getLocation());
            helper.setText(R.id.GL_Recycler_information_Store,homeGoodsRecycler.getShopName());
        };
        /**准备切换的布局**/
        RecyclerStyleState1=new SimpleRecyclerViewAdapter(R.layout.goodslist_recycler_information1, mvpView.getActivityContext(),homeGoodsRecyclers,simpleRecyclerViewAdapterCallback);
        RecyclerStyleState2=new SimpleRecyclerViewAdapter(R.layout.goodslist_recycler_information2, mvpView.getActivityContext(),homeGoodsRecyclers,simpleRecyclerViewAdapterCallback);

        /**显示默认的布局状态**/
        switchRecycler(isRecyclerState,recycler,context,imageView);
        imageView.setOnClickListener(v -> {
            /**切换布局状态**/
            switchRecycler(isRecyclerState,recycler,context,imageView);
        });
    }

    /**切换推荐商品布局状态**/
    private void switchRecycler(boolean b, RecyclerView recyclerView, Context context, ImageView imageView){
        if(b){
            recyclerView.setAdapter(RecyclerStyleState1);
            recyclerView.setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,context,0));
            isRecyclerState=false;
            GlideUtil.displayImage(context,R.mipmap.goods_class1,imageView);
        }else {
            recyclerView.setAdapter(RecyclerStyleState2);
            recyclerView.setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,context,2));
            isRecyclerState=true;
            GlideUtil.displayImage(context,R.mipmap.goods_class2,imageView);
        }
    }
}
