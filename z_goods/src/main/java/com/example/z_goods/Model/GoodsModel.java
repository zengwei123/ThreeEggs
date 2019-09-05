package com.example.z_goods.Model;

import java.util.List;

public class GoodsModel {

    /**
     * page : {"total":81,"list":[{"id":1217541,"goodsId":1,"sellerId":1,"itemCategoryId":560,"title":"苹果（Apple）iPhone 6 Plus (A1524) 128GB 银色 移动联通电信4G手机","sellPoint":"<a href='http://sale.jd.com/act/nAqiWgU34frQolt.html' target='_blank'>关注iPhone6.jd.com<\/a>","price":7388,"stockCount":99999,"image":"http://img11.360buyimg.com/n1/s450x450_jfs/t3286/138/5179502023/67325/93373553/585b52b7N8d296f80.jpg","isDefault":1,"category":"手机","brand":"苹果","spec":"{'机身内存':'128G,'网络':'电信4G'}","seller":"苹果","weight":0,"longitude":112.951415,"latitude":28.241326,"status":1,"createTime":"2015-03-08 21:27:42","updateTime":"2015-03-08 21:27:42","distance":236.90373323009797,"address":"西二旗小胡同","lookNum":0,"collectNum":0,"hot":false,"upNew":false},{"id":1023752,"goodsId":1,"sellerId":1,"itemCategoryId":560,"title":"飞利浦 老人手机 (W8578) 黑色 联通3G手机 双卡双待","sellPoint":"爱要久久，孝敬爸妈的老人手机！中国好儿女，把爱带回家！","price":1799,"stockCount":99999,"image":"http://img11.360buyimg.com/n1/s450x450_jfs/t3115/243/2876210567/110536/f736e20b/57e7e8dbN1d7d7f90.jpg","isDefault":1,"category":"手机","brand":"飞利浦","spec":"{'机身内存':'16G','网络':'联通3G'}","seller":"飞利浦","weight":0,"longitude":112.951415,"latitude":28.241326,"status":1,"createTime":"2015-03-08 21:29:11","updateTime":"2015-03-08 21:29:11","distance":236.90373323009797,"address":"西二旗小胡同","lookNum":0,"collectNum":0,"hot":false,"upNew":false},{"id":951305,"goodsId":1,"sellerId":1,"itemCategoryId":560,"title":"三星 Galaxy S4 (I9502) 16G版 粉色 联通3G手机 双卡双待双通","sellPoint":"三星经典旗舰机！5英寸1080P高清屏+双四核分时CUP+2GB RAM+1300万像素主摄像头","price":1799,"stockCount":99999,"image":"http://img10.360buyimg.com/n1/s450x450_jfs/t3457/294/236823024/102048/c97f5825/58072422Ndd7e66c4.jpg","isDefault":1,"category":"手机","brand":"三星","spec":"{'机身内存':'16G','网络':'联通3G'}","seller":"三星","weight":0,"longitude":112.951415,"latitude":28.241326,"status":1,"createTime":"2015-03-08 21:28:01","updateTime":"2015-03-08 21:28:01","distance":236.90373323009797,"address":"西二旗小胡同","lookNum":0,"collectNum":0,"hot":false,"upNew":false},{"id":1219085,"goodsId":1,"sellerId":1,"itemCategoryId":560,"title":"苹果(Apple) iPhone 6 (A1586) 16G 深空灰 移动联通电信4G手机","sellPoint":"","price":5188,"stockCount":99999,"image":"http://img11.360buyimg.com/n1/s450x450_jfs/t3286/138/5179502023/67325/93373553/585b52b7N8d296f80.jpg","isDefault":1,"category":"手机","brand":"苹果","spec":"{'机身内存':'16G','网络':'电信4G'}","seller":"苹果","weight":0,"longitude":112.951415,"latitude":28.241326,"status":1,"createTime":"2015-03-08 21:28:01","updateTime":"2015-03-08 21:28:01","distance":236.90373323009797,"address":"西二旗小胡同","lookNum":0,"collectNum":0,"hot":false,"upNew":false},{"id":1088285,"goodsId":1,"sellerId":1,"itemCategoryId":560,"title":"酷派 8085Q 雅士黑 移动3G手机","sellPoint":"酷派8085Q颠覆特价持续爆燃！超实惠的价格，非一般的体验！","price":289,"stockCount":99999,"image":"http://img11.360buyimg.com/n1/s450x450_jfs/t3322/33/2284564501/73724/e133c724/584aa0e9N7dd07b46.jpg","isDefault":1,"category":"手机","brand":"酷派","spec":"{'机身内存':'16G','网络':'移动3G'}","seller":"酷派","weight":0,"longitude":112.951415,"latitude":28.241326,"status":1,"createTime":"2015-03-08 21:28:09","updateTime":"2015-03-08 21:28:09","distance":236.90373323009797,"address":"西二旗小胡同","lookNum":0,"collectNum":0,"hot":false,"upNew":false}],"pageNum":1,"pageSize":5,"size":5,"startRow":1,"endRow":5,"pages":17,"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3,4,5,6,7,8],"navigateFirstPage":1,"navigateLastPage":8}
     */

    private PageBean page;

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public static class PageBean {
        /**
         * total : 81
         * list : [{"id":1217541,"goodsId":1,"sellerId":1,"itemCategoryId":560,"title":"苹果（Apple）iPhone 6 Plus (A1524) 128GB 银色 移动联通电信4G手机","sellPoint":"<a href='http://sale.jd.com/act/nAqiWgU34frQolt.html' target='_blank'>关注iPhone6.jd.com<\/a>","price":7388,"stockCount":99999,"image":"http://img11.360buyimg.com/n1/s450x450_jfs/t3286/138/5179502023/67325/93373553/585b52b7N8d296f80.jpg","isDefault":1,"category":"手机","brand":"苹果","spec":"{'机身内存':'128G,'网络':'电信4G'}","seller":"苹果","weight":0,"longitude":112.951415,"latitude":28.241326,"status":1,"createTime":"2015-03-08 21:27:42","updateTime":"2015-03-08 21:27:42","distance":236.90373323009797,"address":"西二旗小胡同","lookNum":0,"collectNum":0,"hot":false,"upNew":false},{"id":1023752,"goodsId":1,"sellerId":1,"itemCategoryId":560,"title":"飞利浦 老人手机 (W8578) 黑色 联通3G手机 双卡双待","sellPoint":"爱要久久，孝敬爸妈的老人手机！中国好儿女，把爱带回家！","price":1799,"stockCount":99999,"image":"http://img11.360buyimg.com/n1/s450x450_jfs/t3115/243/2876210567/110536/f736e20b/57e7e8dbN1d7d7f90.jpg","isDefault":1,"category":"手机","brand":"飞利浦","spec":"{'机身内存':'16G','网络':'联通3G'}","seller":"飞利浦","weight":0,"longitude":112.951415,"latitude":28.241326,"status":1,"createTime":"2015-03-08 21:29:11","updateTime":"2015-03-08 21:29:11","distance":236.90373323009797,"address":"西二旗小胡同","lookNum":0,"collectNum":0,"hot":false,"upNew":false},{"id":951305,"goodsId":1,"sellerId":1,"itemCategoryId":560,"title":"三星 Galaxy S4 (I9502) 16G版 粉色 联通3G手机 双卡双待双通","sellPoint":"三星经典旗舰机！5英寸1080P高清屏+双四核分时CUP+2GB RAM+1300万像素主摄像头","price":1799,"stockCount":99999,"image":"http://img10.360buyimg.com/n1/s450x450_jfs/t3457/294/236823024/102048/c97f5825/58072422Ndd7e66c4.jpg","isDefault":1,"category":"手机","brand":"三星","spec":"{'机身内存':'16G','网络':'联通3G'}","seller":"三星","weight":0,"longitude":112.951415,"latitude":28.241326,"status":1,"createTime":"2015-03-08 21:28:01","updateTime":"2015-03-08 21:28:01","distance":236.90373323009797,"address":"西二旗小胡同","lookNum":0,"collectNum":0,"hot":false,"upNew":false},{"id":1219085,"goodsId":1,"sellerId":1,"itemCategoryId":560,"title":"苹果(Apple) iPhone 6 (A1586) 16G 深空灰 移动联通电信4G手机","sellPoint":"","price":5188,"stockCount":99999,"image":"http://img11.360buyimg.com/n1/s450x450_jfs/t3286/138/5179502023/67325/93373553/585b52b7N8d296f80.jpg","isDefault":1,"category":"手机","brand":"苹果","spec":"{'机身内存':'16G','网络':'电信4G'}","seller":"苹果","weight":0,"longitude":112.951415,"latitude":28.241326,"status":1,"createTime":"2015-03-08 21:28:01","updateTime":"2015-03-08 21:28:01","distance":236.90373323009797,"address":"西二旗小胡同","lookNum":0,"collectNum":0,"hot":false,"upNew":false},{"id":1088285,"goodsId":1,"sellerId":1,"itemCategoryId":560,"title":"酷派 8085Q 雅士黑 移动3G手机","sellPoint":"酷派8085Q颠覆特价持续爆燃！超实惠的价格，非一般的体验！","price":289,"stockCount":99999,"image":"http://img11.360buyimg.com/n1/s450x450_jfs/t3322/33/2284564501/73724/e133c724/584aa0e9N7dd07b46.jpg","isDefault":1,"category":"手机","brand":"酷派","spec":"{'机身内存':'16G','网络':'移动3G'}","seller":"酷派","weight":0,"longitude":112.951415,"latitude":28.241326,"status":1,"createTime":"2015-03-08 21:28:09","updateTime":"2015-03-08 21:28:09","distance":236.90373323009797,"address":"西二旗小胡同","lookNum":0,"collectNum":0,"hot":false,"upNew":false}]
         * pageNum : 1
         * pageSize : 5
         * size : 5
         * startRow : 1
         * endRow : 5
         * pages : 17
         * prePage : 0
         * nextPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2,3,4,5,6,7,8]
         * navigateFirstPage : 1
         * navigateLastPage : 8
         */

        private int total;
        private int pageNum;
        private int pageSize;
        private int size;
        private int startRow;
        private int endRow;
        private int pages;
        private int prePage;
        private int nextPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        private int navigateFirstPage;
        private int navigateLastPage;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getNavigateFirstPage() {
            return navigateFirstPage;
        }

        public void setNavigateFirstPage(int navigateFirstPage) {
            this.navigateFirstPage = navigateFirstPage;
        }

        public int getNavigateLastPage() {
            return navigateLastPage;
        }

        public void setNavigateLastPage(int navigateLastPage) {
            this.navigateLastPage = navigateLastPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * id : 1217541
             * goodsId : 1
             * sellerId : 1
             * itemCategoryId : 560
             * title : 苹果（Apple）iPhone 6 Plus (A1524) 128GB 银色 移动联通电信4G手机
             * sellPoint : <a href='http://sale.jd.com/act/nAqiWgU34frQolt.html' target='_blank'>关注iPhone6.jd.com</a>
             * price : 7388
             * stockCount : 99999
             * image : http://img11.360buyimg.com/n1/s450x450_jfs/t3286/138/5179502023/67325/93373553/585b52b7N8d296f80.jpg
             * isDefault : 1
             * category : 手机
             * brand : 苹果
             * spec : {'机身内存':'128G,'网络':'电信4G'}
             * seller : 苹果
             * weight : 0
             * longitude : 112.951415
             * latitude : 28.241326
             * status : 1
             * createTime : 2015-03-08 21:27:42
             * updateTime : 2015-03-08 21:27:42
             * distance : 236.90373323009797
             * address : 西二旗小胡同
             * lookNum : 0
             * collectNum : 0
             * hot : false
             * upNew : false
             */

            private int id;
            private int goodsId;
            private int sellerId;
            private int itemCategoryId;
            private String title;
            private String sellPoint;
            private int price;
            private int stockCount;
            private String image;
            private int isDefault;
            private String category;
            private String brand;
            private String spec;
            private String seller;
            private int weight;
            private double longitude;
            private double latitude;
            private int status;
            private String createTime;
            private String updateTime;
            private double distance;
            private String address;
            private int lookNum;
            private int collectNum;
            private boolean hot;
            private boolean upNew;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public int getSellerId() {
                return sellerId;
            }

            public void setSellerId(int sellerId) {
                this.sellerId = sellerId;
            }

            public int getItemCategoryId() {
                return itemCategoryId;
            }

            public void setItemCategoryId(int itemCategoryId) {
                this.itemCategoryId = itemCategoryId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSellPoint() {
                return sellPoint;
            }

            public void setSellPoint(String sellPoint) {
                this.sellPoint = sellPoint;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getStockCount() {
                return stockCount;
            }

            public void setStockCount(int stockCount) {
                this.stockCount = stockCount;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getIsDefault() {
                return isDefault;
            }

            public void setIsDefault(int isDefault) {
                this.isDefault = isDefault;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }

            public String getSpec() {
                return spec;
            }

            public void setSpec(String spec) {
                this.spec = spec;
            }

            public String getSeller() {
                return seller;
            }

            public void setSeller(String seller) {
                this.seller = seller;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public double getDistance() {
                return distance;
            }

            public void setDistance(double distance) {
                this.distance = distance;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getLookNum() {
                return lookNum;
            }

            public void setLookNum(int lookNum) {
                this.lookNum = lookNum;
            }

            public int getCollectNum() {
                return collectNum;
            }

            public void setCollectNum(int collectNum) {
                this.collectNum = collectNum;
            }

            public boolean isHot() {
                return hot;
            }

            public void setHot(boolean hot) {
                this.hot = hot;
            }

            public boolean isUpNew() {
                return upNew;
            }

            public void setUpNew(boolean upNew) {
                this.upNew = upNew;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id=" + id +
                        ", goodsId=" + goodsId +
                        ", sellerId=" + sellerId +
                        ", itemCategoryId=" + itemCategoryId +
                        ", title='" + title + '\'' +
                        ", sellPoint='" + sellPoint + '\'' +
                        ", price=" + price +
                        ", stockCount=" + stockCount +
                        ", image='" + image + '\'' +
                        ", isDefault=" + isDefault +
                        ", category='" + category + '\'' +
                        ", brand='" + brand + '\'' +
                        ", spec='" + spec + '\'' +
                        ", seller='" + seller + '\'' +
                        ", weight=" + weight +
                        ", longitude=" + longitude +
                        ", latitude=" + latitude +
                        ", status=" + status +
                        ", createTime='" + createTime + '\'' +
                        ", updateTime='" + updateTime + '\'' +
                        ", distance=" + distance +
                        ", address='" + address + '\'' +
                        ", lookNum=" + lookNum +
                        ", collectNum=" + collectNum +
                        ", hot=" + hot +
                        ", upNew=" + upNew +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "PageBean{" +
                    "total=" + total +
                    ", pageNum=" + pageNum +
                    ", pageSize=" + pageSize +
                    ", size=" + size +
                    ", startRow=" + startRow +
                    ", endRow=" + endRow +
                    ", pages=" + pages +
                    ", prePage=" + prePage +
                    ", nextPage=" + nextPage +
                    ", isFirstPage=" + isFirstPage +
                    ", isLastPage=" + isLastPage +
                    ", hasPreviousPage=" + hasPreviousPage +
                    ", hasNextPage=" + hasNextPage +
                    ", navigatePages=" + navigatePages +
                    ", navigateFirstPage=" + navigateFirstPage +
                    ", navigateLastPage=" + navigateLastPage +
                    ", list=" + list +
                    ", navigatepageNums=" + navigatepageNums +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GoodsModel{" +
                "page=" + page +
                '}';
    }
}
