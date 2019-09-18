package com.example.z_circle.Model;

import java.util.List;

/**
 * Created by zengwei on 2019/9/8.
 */

public class CircleModel {

    /**
     * page : {"total":7,"list":[{"id":1234375432,"roundTitle":"7关于詹姆斯走步频繁的说法是否客观？","roundDesc":"作者：熠杰 链接：https://www.zhihu.com","posterUrl":"https://img.alicdn.com/imgextra/i4/3943659105/O1CN01CtDsX22H88ifFW6Nu_!!3943659105.jpg","sellerId":1,"goodsId":149187842867912,"labelId":1,"categoryId":51,"weight":1000,"latitude":28.241326,"longitude":112.2,"address":"叉子山","isPublish":true,"isAudit":true,"isDelete":false,"createTime":"2019-09-08 14:30:52","updateTime":"2019-09-08 14:30:52","distance":84122.44466446973,"userName":"佐助","handImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","likeNum":0,"lookNum":0,"collectNum":0,"commentNum":0},{"id":1234354323,"roundTitle":"4关于詹姆斯走步频繁的说法是否客观？","roundDesc":"作者：熠杰 链接：https://www.zhihu.com","posterUrl":"https://img.alicdn.com/imgextra/i4/3943659105/O1CN01CtDsX22H88ifFW6Nu_!!3943659105.jpg","sellerId":1,"goodsId":149187842867912,"labelId":4,"categoryId":51,"weight":1000,"latitude":28.241326,"longitude":112.2,"address":"叉子山","isPublish":true,"isAudit":true,"isDelete":false,"createTime":"2019-09-08 14:30:42","updateTime":"2019-09-08 14:30:42","distance":84122.44466446973,"userName":"佐助","handImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","likeNum":0,"lookNum":0,"collectNum":0,"commentNum":0},{"id":123435431,"roundTitle":"2关于詹姆斯走步频繁的说法是否客观？","roundDesc":"作者：熠杰 链接：https://www.zhihu.com","posterUrl":"https://img.alicdn.com/imgextra/i4/3943659105/O1CN01CtDsX22H88ifFW6Nu_!!3943659105.jpg","sellerId":1,"goodsId":149187842867912,"labelId":2,"categoryId":51,"weight":1000,"latitude":28.241326,"longitude":112.2,"address":"叉子山","isPublish":true,"isAudit":true,"isDelete":false,"createTime":"2019-09-08 14:30:40","updateTime":"2019-09-08 14:30:40","distance":84122.44466446973,"userName":"佐助","handImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","likeNum":0,"lookNum":0,"collectNum":0,"commentNum":0},{"id":123435432,"roundTitle":"3关于詹姆斯走步频繁的说法是否客观？","roundDesc":"作者：熠杰 链接：https://www.zhihu.com","posterUrl":"https://img.alicdn.com/imgextra/i4/3943659105/O1CN01CtDsX22H88ifFW6Nu_!!3943659105.jpg","sellerId":1,"goodsId":149187842867912,"labelId":3,"categoryId":51,"weight":1000,"latitude":28.241326,"longitude":112.2,"address":"叉子山","isPublish":true,"isAudit":true,"isDelete":false,"createTime":"2019-09-08 14:30:41","updateTime":"2019-09-08 14:30:41","distance":84122.44466446973,"userName":"佐助","handImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","likeNum":0,"lookNum":0,"collectNum":0,"commentNum":0},{"id":1234356432,"roundTitle":"6关于詹姆斯走步频繁的说法是否客观？","roundDesc":"作者：熠杰 链接：https://www.zhihu.com","posterUrl":"https://img.alicdn.com/imgextra/i4/3943659105/O1CN01CtDsX22H88ifFW6Nu_!!3943659105.jpg","sellerId":1,"goodsId":149187842867912,"labelId":6,"categoryId":51,"weight":1000,"latitude":28.241326,"longitude":112.2,"address":"叉子山","isPublish":true,"isAudit":true,"isDelete":false,"createTime":"2019-09-08 14:30:48","updateTime":"2019-09-08 14:30:48","distance":84122.44466446973,"userName":"佐助","handImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","likeNum":0,"lookNum":0,"collectNum":0,"commentNum":0}],"pageNum":1,"pageSize":5,"size":5,"startRow":1,"endRow":5,"pages":2,"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2],"navigateFirstPage":1,"navigateLastPage":2}
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
         * total : 7
         * list : [{"id":1234375432,"roundTitle":"7关于詹姆斯走步频繁的说法是否客观？","roundDesc":"作者：熠杰 链接：https://www.zhihu.com","posterUrl":"https://img.alicdn.com/imgextra/i4/3943659105/O1CN01CtDsX22H88ifFW6Nu_!!3943659105.jpg","sellerId":1,"goodsId":149187842867912,"labelId":1,"categoryId":51,"weight":1000,"latitude":28.241326,"longitude":112.2,"address":"叉子山","isPublish":true,"isAudit":true,"isDelete":false,"createTime":"2019-09-08 14:30:52","updateTime":"2019-09-08 14:30:52","distance":84122.44466446973,"userName":"佐助","handImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","likeNum":0,"lookNum":0,"collectNum":0,"commentNum":0},{"id":1234354323,"roundTitle":"4关于詹姆斯走步频繁的说法是否客观？","roundDesc":"作者：熠杰 链接：https://www.zhihu.com","posterUrl":"https://img.alicdn.com/imgextra/i4/3943659105/O1CN01CtDsX22H88ifFW6Nu_!!3943659105.jpg","sellerId":1,"goodsId":149187842867912,"labelId":4,"categoryId":51,"weight":1000,"latitude":28.241326,"longitude":112.2,"address":"叉子山","isPublish":true,"isAudit":true,"isDelete":false,"createTime":"2019-09-08 14:30:42","updateTime":"2019-09-08 14:30:42","distance":84122.44466446973,"userName":"佐助","handImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","likeNum":0,"lookNum":0,"collectNum":0,"commentNum":0},{"id":123435431,"roundTitle":"2关于詹姆斯走步频繁的说法是否客观？","roundDesc":"作者：熠杰 链接：https://www.zhihu.com","posterUrl":"https://img.alicdn.com/imgextra/i4/3943659105/O1CN01CtDsX22H88ifFW6Nu_!!3943659105.jpg","sellerId":1,"goodsId":149187842867912,"labelId":2,"categoryId":51,"weight":1000,"latitude":28.241326,"longitude":112.2,"address":"叉子山","isPublish":true,"isAudit":true,"isDelete":false,"createTime":"2019-09-08 14:30:40","updateTime":"2019-09-08 14:30:40","distance":84122.44466446973,"userName":"佐助","handImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","likeNum":0,"lookNum":0,"collectNum":0,"commentNum":0},{"id":123435432,"roundTitle":"3关于詹姆斯走步频繁的说法是否客观？","roundDesc":"作者：熠杰 链接：https://www.zhihu.com","posterUrl":"https://img.alicdn.com/imgextra/i4/3943659105/O1CN01CtDsX22H88ifFW6Nu_!!3943659105.jpg","sellerId":1,"goodsId":149187842867912,"labelId":3,"categoryId":51,"weight":1000,"latitude":28.241326,"longitude":112.2,"address":"叉子山","isPublish":true,"isAudit":true,"isDelete":false,"createTime":"2019-09-08 14:30:41","updateTime":"2019-09-08 14:30:41","distance":84122.44466446973,"userName":"佐助","handImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","likeNum":0,"lookNum":0,"collectNum":0,"commentNum":0},{"id":1234356432,"roundTitle":"6关于詹姆斯走步频繁的说法是否客观？","roundDesc":"作者：熠杰 链接：https://www.zhihu.com","posterUrl":"https://img.alicdn.com/imgextra/i4/3943659105/O1CN01CtDsX22H88ifFW6Nu_!!3943659105.jpg","sellerId":1,"goodsId":149187842867912,"labelId":6,"categoryId":51,"weight":1000,"latitude":28.241326,"longitude":112.2,"address":"叉子山","isPublish":true,"isAudit":true,"isDelete":false,"createTime":"2019-09-08 14:30:48","updateTime":"2019-09-08 14:30:48","distance":84122.44466446973,"userName":"佐助","handImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","likeNum":0,"lookNum":0,"collectNum":0,"commentNum":0}]
         * pageNum : 1
         * pageSize : 5
         * size : 5
         * startRow : 1
         * endRow : 5
         * pages : 2
         * prePage : 0
         * nextPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2]
         * navigateFirstPage : 1
         * navigateLastPage : 2
         */

        private long total;
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

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
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
             * id : 1234375432
             * roundTitle : 7关于詹姆斯走步频繁的说法是否客观？
             * roundDesc : 作者：熠杰 链接：https://www.zhihu.com
             * posterUrl : https://img.alicdn.com/imgextra/i4/3943659105/O1CN01CtDsX22H88ifFW6Nu_!!3943659105.jpg
             * sellerId : 1
             * goodsId : 149187842867912
             * labelId : 1
             * categoryId : 51
             * weight : 1000
             * latitude : 28.241326
             * longitude : 112.2
             * address : 叉子山
             * isPublish : true
             * isAudit : true
             * isDelete : false
             * createTime : 2019-09-08 14:30:52
             * updateTime : 2019-09-08 14:30:52
             * distance : 84122.44466446973
             * userName : 佐助
             * handImg : https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg
             * likeNum : 0
             * lookNum : 0
             * collectNum : 0
             * commentNum : 0
             */

            private long id;
            private String roundTitle;
            private String roundDesc;
            private String posterUrl;
            private long sellerId;
            private long goodsId;
            private long labelId;
            private long categoryId;
            private int weight;
            private double latitude;
            private double longitude;
            private String address;
            private boolean isPublish;
            private boolean isAudit;
            private boolean isDelete;
            private String createTime;
            private String updateTime;
            private double distance;
            private String userName;
            private String handImg;
            private int likeNum;
            private int lookNum;
            private int collectNum;
            private int commentNum;
            private String labelName;
            private boolean hasLike;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getRoundTitle() {
                return roundTitle;
            }

            public void setRoundTitle(String roundTitle) {
                this.roundTitle = roundTitle;
            }

            public String getRoundDesc() {
                return roundDesc;
            }

            public void setRoundDesc(String roundDesc) {
                this.roundDesc = roundDesc;
            }

            public String getPosterUrl() {
                return posterUrl;
            }

            public void setPosterUrl(String posterUrl) {
                this.posterUrl = posterUrl;
            }

            public long getSellerId() {
                return sellerId;
            }

            public void setSellerId(long sellerId) {
                this.sellerId = sellerId;
            }

            public long getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(long goodsId) {
                this.goodsId = goodsId;
            }

            public long getLabelId() {
                return labelId;
            }

            public void setLabelId(long labelId) {
                this.labelId = labelId;
            }

            public long getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(long categoryId) {
                this.categoryId = categoryId;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public boolean isIsPublish() {
                return isPublish;
            }

            public void setIsPublish(boolean isPublish) {
                this.isPublish = isPublish;
            }

            public boolean isIsAudit() {
                return isAudit;
            }

            public void setIsAudit(boolean isAudit) {
                this.isAudit = isAudit;
            }

            public boolean isIsDelete() {
                return isDelete;
            }

            public void setIsDelete(boolean isDelete) {
                this.isDelete = isDelete;
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

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getHandImg() {
                return handImg;
            }

            public void setHandImg(String handImg) {
                this.handImg = handImg;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
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

            public int getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(int commentNum) {
                this.commentNum = commentNum;
            }

            public String getLabelName() {
                return labelName;
            }

            public void setLabelName(String labelName) {
                this.labelName = labelName;
            }

            public boolean isHasLike() {
                return hasLike;
            }

            public void setHasLike(boolean hasLike) {
                this.hasLike = hasLike;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id=" + id +
                        ", roundTitle='" + roundTitle + '\'' +
                        ", roundDesc='" + roundDesc + '\'' +
                        ", posterUrl='" + posterUrl + '\'' +
                        ", sellerId=" + sellerId +
                        ", goodsId=" + goodsId +
                        ", labelId=" + labelId +
                        ", categoryId=" + categoryId +
                        ", weight=" + weight +
                        ", latitude=" + latitude +
                        ", longitude=" + longitude +
                        ", address='" + address + '\'' +
                        ", isPublish=" + isPublish +
                        ", isAudit=" + isAudit +
                        ", isDelete=" + isDelete +
                        ", createTime='" + createTime + '\'' +
                        ", updateTime='" + updateTime + '\'' +
                        ", distance=" + distance +
                        ", userName='" + userName + '\'' +
                        ", handImg='" + handImg + '\'' +
                        ", likeNum=" + likeNum +
                        ", lookNum=" + lookNum +
                        ", collectNum=" + collectNum +
                        ", commentNum=" + commentNum +
                        '}';
            }
        }
    }
}
