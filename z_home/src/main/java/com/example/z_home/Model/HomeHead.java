package com.example.z_home.Model;

import java.util.List;

public class HomeHead {

    private List<AdBean> ad;
    private List<IndexBean> index;
    private List<MenuBean> menu;
    private Weather weather;
    public List<AdBean> getAd() {
        return ad;
    }

    public void setAd(List<AdBean> ad) {
        this.ad = ad;
    }

    public List<IndexBean> getIndex() {
        return index;
    }

    public void setIndex(List<IndexBean> index) {
        this.index = index;
    }

    public List<MenuBean> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuBean> menu) {
        this.menu = menu;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public static class AdBean {
        /**
         * id : 14
         * contentCategoryId : 6
         * title : 618狂欢节
         * url : http://www.163.com
         * imagePath : http://192.168.25.133/group1/M00/00/00/wKgZhVnJ1pyAFbWqAAFyVK2N7Ig973.jpg
         * status : 1
         * sortOrder : 1
         * isDelete : 0
         * provinceCode :
         */

        private int id;
        private int contentCategoryId;
        private String title;
        private String url;
        private String imagePath;
        private int status;
        private int sortOrder;
        private int isDelete;
        private String provinceCode;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getContentCategoryId() {
            return contentCategoryId;
        }

        public void setContentCategoryId(int contentCategoryId) {
            this.contentCategoryId = contentCategoryId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(int sortOrder) {
            this.sortOrder = sortOrder;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public String getProvinceCode() {
            return provinceCode;
        }

        public void setProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
        }
    }

    public static class IndexBean {
        /**
         * id : 5
         * contentCategoryId : 1
         * title : 测试广告
         * url : http://www.baidu.com
         * imagePath : http://192.168.25.133/group1/M00/00/00/wKgZhVnIhVqAAa0jAActhhatATY291.png
         * status : 1
         * sortOrder : 3
         * isDelete : 0
         * provinceCode :
         */

        private int id;
        private int contentCategoryId;
        private String title;
        private String url;
        private String imagePath;
        private int status;
        private int sortOrder;
        private int isDelete;
        private String provinceCode;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getContentCategoryId() {
            return contentCategoryId;
        }

        public void setContentCategoryId(int contentCategoryId) {
            this.contentCategoryId = contentCategoryId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(int sortOrder) {
            this.sortOrder = sortOrder;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public String getProvinceCode() {
            return provinceCode;
        }

        public void setProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
        }
    }

    public static class MenuBean {
        /**
         * id : 10
         * contentCategoryId : 2
         * title : 天猫超市
         * url : http://www.163.com
         * imagePath : http://192.168.25.133/group1/M00/00/00/wKgZhVnJ1pyAFbWqAAFyVK2N7Ig973.jpg
         * status : 1
         * sortOrder : 2
         * isDelete : 0
         * provinceCode :
         */

        private int id;
        private int contentCategoryId;
        private String title;
        private String url;
        private String imagePath;
        private int status;
        private int sortOrder;
        private int isDelete;
        private String provinceCode;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getContentCategoryId() {
            return contentCategoryId;
        }

        public void setContentCategoryId(int contentCategoryId) {
            this.contentCategoryId = contentCategoryId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(int sortOrder) {
            this.sortOrder = sortOrder;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public String getProvinceCode() {
            return provinceCode;
        }

        public void setProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
        }
    }

    public static class Weather{

        /**
         * city : 深圳市
         * text : 2
         * temperature : 28℃
         * windSpeed : 13.9km/h
         * humidity : 76%
         */

        private String city;
        private String text;
        private String temperature;
        private String windSpeed;
        private String humidity;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(String windSpeed) {
            this.windSpeed = windSpeed;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }
    }
}
