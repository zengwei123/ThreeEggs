package com.example.z_circle.Model;

/**
 * 圈子界面的瀑布流布局数据模型
 */
public class CircleList {
    private int Image;
    private String ImageUrl;
    private String BriefContent;
    private String Name;
    private String UserImage;

    public CircleList(int image, String imageUrl, String briefContent, String name, String userImage) {
        Image = image;
        ImageUrl = imageUrl;
        BriefContent = briefContent;
        Name = name;
        UserImage = userImage;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getBriefContent() {
        return BriefContent;
    }

    public void setBriefContent(String briefContent) {
        BriefContent = briefContent;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserImage() {
        return UserImage;
    }

    public void setUserImage(String userImage) {
        UserImage = userImage;
    }
}
