package com.example.z_home.Model;

import java.util.List;

public class HomeHead {


    /**
     * ad : [{"id":14,"contentCategoryId":6,"title":"菜单下面的广告图","url":"http://www.163.com","imagePath":"http://pic.netbian.com/d/file/2019/08/19/163320ju2xz.jpg","jumpMark":2,"keyType":1,"status":1,"sortOrder":1,"longitude":1,"latitude":1,"provinceCode":"1","cityCode":"1","areaCode":"1","address":"1","devicesState":0,"isDelete":false,"updateTime":"2019-09-06 11:02:02"}]
     * weather : {"city":"上海市","text":"9","temperature":"24℃","windSpeed":"9.3km/h","humidity":"99%"}
     * index : [{"id":5,"contentCategoryId":1,"title":"轮播图片1","url":"1","imagePath":"https://gss0.bdstatic.com/7051cy89RcgCncy6lo7D0j9wexYrbOWh7c50/cysk/270-140.png","jumpMark":2,"keyType":1,"status":1,"sortOrder":3,"longitude":1,"latitude":1,"provinceCode":"1","cityCode":"1","areaCode":"1","address":"1","devicesState":0,"isDelete":false,"updateTime":"2019-09-06 11:02:02"},{"id":9,"contentCategoryId":1,"title":"轮播图片3","url":"3","imagePath":"https://iknow-base.bj.bcebos.com/zhimatuanhuodong/QB270X170.jpg","jumpMark":2,"keyType":1,"status":1,"sortOrder":6,"longitude":1,"latitude":1,"provinceCode":"1","cityCode":"1","areaCode":"1","address":"1","devicesState":0,"isDelete":false,"updateTime":"2019-09-06 11:02:02"},{"id":8,"contentCategoryId":1,"title":"轮播图片2","url":"2","imagePath":"https://gss0.bdstatic.com/7051cy89RcgCncy6lo7D0j9wexYrbOWh7c50/BD/zhuanti/GELUN270140.jpg","jumpMark":2,"keyType":1,"status":1,"sortOrder":10,"longitude":1,"latitude":1,"provinceCode":"1","cityCode":"1","areaCode":"1","address":"1","devicesState":0,"isDelete":false,"updateTime":"2019-09-06 11:02:02"}]
     * menu : [{"id":10,"contentCategoryId":2,"title":"精选店铺","url":"http://www.163.com","imagePath":"http://yanzhishijian.oss-cn-shenzhen.aliyuncs.com/201909051509270397688c99bd43acaea73ce44a8e73dc.png","jumpMark":2,"keyType":1,"status":1,"sortOrder":2,"longitude":1,"latitude":1,"provinceCode":"1","cityCode":"1","areaCode":"1","address":"1","devicesState":0,"isDelete":false,"updateTime":"2019-09-06 11:02:02"},{"id":13,"contentCategoryId":2,"title":"附近爆款","url":"http://www.163.com","jumpMark":2,"keyType":1,"keywords":"连衣裙,T恤,卫衣","status":1,"sortOrder":5,"longitude":1,"latitude":1,"provinceCode":"1","cityCode":"1","areaCode":"1","address":"1","devicesState":0,"isDelete":false,"updateTime":"2019-09-06 11:02:02"},{"id":15,"contentCategoryId":2,"title":"新品首发","url":"http://www.163.com","imagePath":"http://yanzhishijian.oss-cn-shenzhen.aliyuncs.com/20190905151007d4f443e920604e8cb82048da0d2a7db1.png","jumpMark":2,"keyType":1,"status":1,"sortOrder":5,"longitude":1,"latitude":1,"provinceCode":"1","cityCode":"1","areaCode":"1","address":"1","devicesState":0,"isDelete":false,"createTime":"2019-08-27 16:14:52","updateTime":"2019-09-06 11:02:02"},{"id":17,"contentCategoryId":2,"title":"分类","url":"http://www.163.com","imagePath":"http://yanzhishijian.oss-cn-shenzhen.aliyuncs.com/20190905151027712b06109920423385ecb786c8bdafb9.png","jumpMark":6,"keyType":1,"status":1,"sortOrder":5,"longitude":1,"latitude":1,"provinceCode":"1","cityCode":"1","areaCode":"1","address":"1","devicesState":0,"isDelete":false,"createTime":"2019-08-27 16:14:52","updateTime":"2019-09-06 11:02:02"}]
     */

    private WeatherBean weather;
    private List<AdBean> ad;
    private List<IndexBean> index;
    private List<MenuBean> menu;

    public WeatherBean getWeather() {
        return weather;
    }

    public void setWeather(WeatherBean weather) {
        this.weather = weather;
    }

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

    public static class WeatherBean {
        /**
         * city : 上海市
         * text : 9
         * temperature : 24℃
         * windSpeed : 9.3km/h
         * humidity : 99%
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

    public static class AdBean {
        /**
         * id : 14
         * contentCategoryId : 6
         * title : 菜单下面的广告图
         * url : http://www.163.com
         * imagePath : http://pic.netbian.com/d/file/2019/08/19/163320ju2xz.jpg
         * jumpMark : 2
         * keyType : 1
         * status : 1
         * sortOrder : 1
         * longitude : 1
         * latitude : 1
         * provinceCode : 1
         * cityCode : 1
         * areaCode : 1
         * address : 1
         * devicesState : 0
         * isDelete : false
         * updateTime : 2019-09-06 11:02:02
         */

        private long id;
        private long contentCategoryId;
        private String title;
        private String url;
        private String imagePath;
        private int jumpMark;
        private int keyType;
        private int status;
        private int sortOrder;
        private int longitude;
        private int latitude;
        private String provinceCode;
        private String cityCode;
        private String areaCode;
        private String address;
        private int devicesState;
        private boolean isDelete;
        private String updateTime;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getContentCategoryId() {
            return contentCategoryId;
        }

        public void setContentCategoryId(long contentCategoryId) {
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

        public int getJumpMark() {
            return jumpMark;
        }

        public void setJumpMark(int jumpMark) {
            this.jumpMark = jumpMark;
        }

        public int getKeyType() {
            return keyType;
        }

        public void setKeyType(int keyType) {
            this.keyType = keyType;
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

        public int getLongitude() {
            return longitude;
        }

        public void setLongitude(int longitude) {
            this.longitude = longitude;
        }

        public int getLatitude() {
            return latitude;
        }

        public void setLatitude(int latitude) {
            this.latitude = latitude;
        }

        public String getProvinceCode() {
            return provinceCode;
        }

        public void setProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getDevicesState() {
            return devicesState;
        }

        public void setDevicesState(int devicesState) {
            this.devicesState = devicesState;
        }

        public boolean isIsDelete() {
            return isDelete;
        }

        public void setIsDelete(boolean isDelete) {
            this.isDelete = isDelete;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    public static class IndexBean {
        /**
         * id : 5
         * contentCategoryId : 1
         * title : 轮播图片1
         * url : 1
         * imagePath : https://gss0.bdstatic.com/7051cy89RcgCncy6lo7D0j9wexYrbOWh7c50/cysk/270-140.png
         * jumpMark : 2
         * keyType : 1
         * status : 1
         * sortOrder : 3
         * longitude : 1
         * latitude : 1
         * provinceCode : 1
         * cityCode : 1
         * areaCode : 1
         * address : 1
         * devicesState : 0
         * isDelete : false
         * updateTime : 2019-09-06 11:02:02
         */

        private long id;
        private long contentCategoryId;
        private String title;
        private String url;
        private String imagePath;
        private int jumpMark;
        private int keyType;
        private int status;
        private int sortOrder;
        private int longitude;
        private int latitude;
        private String provinceCode;
        private String cityCode;
        private String areaCode;
        private String address;
        private int devicesState;
        private boolean isDelete;
        private String updateTime;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getContentCategoryId() {
            return contentCategoryId;
        }

        public void setContentCategoryId(long contentCategoryId) {
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

        public int getJumpMark() {
            return jumpMark;
        }

        public void setJumpMark(int jumpMark) {
            this.jumpMark = jumpMark;
        }

        public int getKeyType() {
            return keyType;
        }

        public void setKeyType(int keyType) {
            this.keyType = keyType;
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

        public int getLongitude() {
            return longitude;
        }

        public void setLongitude(int longitude) {
            this.longitude = longitude;
        }

        public int getLatitude() {
            return latitude;
        }

        public void setLatitude(int latitude) {
            this.latitude = latitude;
        }

        public String getProvinceCode() {
            return provinceCode;
        }

        public void setProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getDevicesState() {
            return devicesState;
        }

        public void setDevicesState(int devicesState) {
            this.devicesState = devicesState;
        }

        public boolean isIsDelete() {
            return isDelete;
        }

        public void setIsDelete(boolean isDelete) {
            this.isDelete = isDelete;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    public static class MenuBean {
        /**
         * id : 10
         * contentCategoryId : 2
         * title : 精选店铺
         * url : http://www.163.com
         * imagePath : http://yanzhishijian.oss-cn-shenzhen.aliyuncs.com/201909051509270397688c99bd43acaea73ce44a8e73dc.png
         * jumpMark : 2
         * keyType : 1
         * status : 1
         * sortOrder : 2
         * longitude : 1
         * latitude : 1
         * provinceCode : 1
         * cityCode : 1
         * areaCode : 1
         * address : 1
         * devicesState : 0
         * isDelete : false
         * updateTime : 2019-09-06 11:02:02
         * keywords : 连衣裙,T恤,卫衣
         * createTime : 2019-08-27 16:14:52
         */

        private long id;
        private long contentCategoryId;
        private String title;
        private String url;
        private String imagePath;
        private int jumpMark;
        private int keyType;
        private int status;
        private int sortOrder;
        private int longitude;
        private int latitude;
        private String provinceCode;
        private String cityCode;
        private String areaCode;
        private String address;
        private int devicesState;
        private boolean isDelete;
        private String updateTime;
        private String keywords;
        private String createTime;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getContentCategoryId() {
            return contentCategoryId;
        }

        public void setContentCategoryId(long contentCategoryId) {
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

        public int getJumpMark() {
            return jumpMark;
        }

        public void setJumpMark(int jumpMark) {
            this.jumpMark = jumpMark;
        }

        public int getKeyType() {
            return keyType;
        }

        public void setKeyType(int keyType) {
            this.keyType = keyType;
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

        public int getLongitude() {
            return longitude;
        }

        public void setLongitude(int longitude) {
            this.longitude = longitude;
        }

        public int getLatitude() {
            return latitude;
        }

        public void setLatitude(int latitude) {
            this.latitude = latitude;
        }

        public String getProvinceCode() {
            return provinceCode;
        }

        public void setProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getDevicesState() {
            return devicesState;
        }

        public void setDevicesState(int devicesState) {
            this.devicesState = devicesState;
        }

        public boolean isIsDelete() {
            return isDelete;
        }

        public void setIsDelete(boolean isDelete) {
            this.isDelete = isDelete;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
    }
}
