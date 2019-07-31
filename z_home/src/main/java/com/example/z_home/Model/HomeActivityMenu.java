package com.example.z_home.Model;

/**
 * Created by zengwei on 2019/7/21.
 * 首页的活动菜单的数据模型
 */

public class HomeActivityMenu {
    private int ImageDrawable;
    private String ImageUrl;
    private String Name;
    private String Url;

    public HomeActivityMenu(int imageDrawable, String imageUrl, String name, String url) {
        ImageDrawable = imageDrawable;
        ImageUrl = imageUrl;
        Name = name;
        Url = url;
    }

    public int getImageDrawable() {
        return ImageDrawable;
    }

    public void setImageDrawable(int imageDrawable) {
        ImageDrawable = imageDrawable;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    @Override
    public String toString() {
        return "HomeActivityMenu{" +
                "ImageUrl='" + ImageUrl + '\'' +
                ", Name='" + Name + '\'' +
                ", Url='" + Url + '\'' +
                '}';
    }
}
