package com.example.z_order.Model;

/**
 * Created by zengwei on 2019/7/28.
 */

public class OrderList {
    private int State;
    private String StoreName;
    private String OrderState;
    private String GoodsImage;
    private String GoodsName;
    private String GoodsPrice;
    private String GoodsTime;

    public OrderList(int State,String storeName, String orderState, String GoodsImage,String goodsName, String goodsPrice, String goodsTime) {
        this.State=State;
        this.GoodsImage=GoodsImage;
        this.StoreName = storeName;
        this.OrderState = orderState;
        this.GoodsName = goodsName;
        this.GoodsPrice = goodsPrice;
        this.GoodsTime = goodsTime;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public String getOrderState() {
        return OrderState;
    }

    public void setOrderState(String orderState) {
        OrderState = orderState;
    }

    public String getGoodsImage() {
        return GoodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        GoodsImage = goodsImage;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public String getGoodsPrice() {
        return GoodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        GoodsPrice = goodsPrice;
    }

    public String getGoodsTime() {
        return GoodsTime;
    }

    public void setGoodsTime(String goodsTime) {
        GoodsTime = goodsTime;
    }
}
