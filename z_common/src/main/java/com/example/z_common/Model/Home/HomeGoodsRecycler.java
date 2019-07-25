package com.example.z_common.Model.Home;

/**
 * Created by zengwei on 2019/7/23.
 * 首页推荐信息的商品数据模型
 */

public class HomeGoodsRecycler {
    private String ImageUrl;  //图片
    private String Title;   //商品标题
    private String Price;   //商品推荐价格
    private String BuyNumber;  //购买数量
    private String Distance;   //店铺距离
    private String Location;  //店铺位置
    private String ShopName;  //店铺名字

    public HomeGoodsRecycler(String imageUrl, String title, String price, String buyNumber, String distance, String location, String shopName) {
        ImageUrl = imageUrl;
        Title = title;
        Price = price;
        BuyNumber = buyNumber;
        Distance = distance;
        Location = location;
        ShopName = shopName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getBuyNumber() {
        return BuyNumber;
    }

    public void setBuyNumber(String buyNumber) {
        BuyNumber = buyNumber;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }
}
