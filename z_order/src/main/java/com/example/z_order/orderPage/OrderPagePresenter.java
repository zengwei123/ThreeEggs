package com.example.z_order.orderPage;

import android.view.View;

import com.example.z_base.BasePresenter;
import com.example.z_common.GlideUtil;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.SimpleUtils;
import com.example.z_order.Model.OrderList;
import com.example.z_order.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwei on 2019/7/28.
 */

class OrderPagePresenter extends BasePresenter<OrderPageView>{
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        List<OrderList> orderLists=new ArrayList<>();
        orderLists.add(new OrderList(1,"爸爸的店铺","待使用","","爸爸的二手飞机杯","111","2019-07-07 11:11:11"));
        orderLists.add(new OrderList(2,"妈妈的店铺","待付款","","妈妈的可裸体围裙","222","2019-07-07 11:11:12"));
        orderLists.add(new OrderList(3,"爷爷的店铺","待送达","","爷爷的恐怖僵尸假牙","333","2019-07-07 11:11:13"));
        orderLists.add(new OrderList(4,"奶奶的店铺","待评价","","奶奶的慈祥巨乳牛牛奶","444","2019-07-07 11:11:144"));
        orderLists.add(new OrderList(5,"叔叔的店铺","售后(退货退款)","","可爱表妹原味胖次","555","2019-07-07 11:11:15"));
        orderLists.add(new OrderList(6,"嫂子的店铺","售后(换货)","","嫂子的爱心饺子","666","2019-07-07 11:11:16"));


        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.orderpage_recycler_item_all,
                mvpView.getActivityContext(), orderLists, (helper, item) -> {
                    helper.setText(R.id.OrderPage_StoreName,((OrderList)item).getStoreName());
                    helper.setText(R.id.OrderPage_State,((OrderList)item).getOrderState());
                    helper.setText(R.id.OrderPage_GoodsName,((OrderList)item).getGoodsName());
                    helper.setText(R.id.OrderPage_GoodsPrice,"￥ "+((OrderList)item).getGoodsPrice());
                    helper.setText(R.id.OrderPage_GoodsTime,((OrderList)item).getGoodsTime());
//                    helper.setText(R.id.OrderPage_GoodsPrice,((OrderList)item).getStoreName());
                    GlideUtil.displayImage(mvpView.getActivityContext(),R.mipmap.order_goods,helper.getView(R.id.OrderPage_GoodsImage));
                    switch (((OrderList)item).getState()){
                        case 1:
                            helper.setText(R.id.OrderPage_Left,"退款");
                            helper.setText(R.id.OrderPage_Right,"取货码");
                            break;
                        case 2:
                            helper.setText(R.id.OrderPage_Left,"取消订单");
                            helper.setText(R.id.OrderPage_Right,"付款");
                            break;
                        case 3:
                            helper.setText(R.id.OrderPage_Left,"商品状态");
                            helper.setText(R.id.OrderPage_Right,"确认收获");
                            break;
                        case 4:
                            helper.getView(R.id.OrderPage_Left).setVisibility(View.GONE);
                            helper.setText(R.id.OrderPage_Right,"评论商品");
                            break;
                        case 5:
                            helper.getView(R.id.OrderPage_Left).setVisibility(View.GONE);
                            helper.setText(R.id.OrderPage_Right,"售后进度");
                            break;
                        case 6:
                            helper.getView(R.id.OrderPage_Left).setVisibility(View.GONE);
                            helper.setText(R.id.OrderPage_Right,"售后进度");
                            break;
                    }
                });
        mvpView.getOrderPage_Recycler().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getOrderPage_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
    }
}
