package com.example.z_goods.Model;

import java.util.List;

/**
 * Created by zengwei on 2019/9/8.
 */

public class StoreModel {


    /**
     * page : {"records":[{"id":1,"name":"百度公司","follow":2,"logoPic":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1700741544,1951185347&fm=26&gp=0.jpg","goodsList":[{"id":149187842867924,"goodsName":"华为手机","smallPic":"https://img30.360buyimg.com/popWaterMark/jfs/t1/66034/10/5411/93643/5d382afcE5f106069/89d489bc5eca71f0.jpg"},{"id":149187842867933,"goodsName":"大米手机","smallPic":"https://img30.360buyimg.com/popWaterMark/jfs/t1/66034/10/5411/93643/5d382afcE5f106069/89d489bc5eca71f0.jpg"}]},{"id":2,"name":"华为公司","follow":1,"logoPic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1820523987,3798556096&fm=26&gp=0.jpg","goodsList":[]}],"total":3,"size":2,"current":1,"orders":[],"searchCount":true,"pages":2}
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
         * records : [{"id":1,"name":"百度公司","follow":2,"logoPic":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1700741544,1951185347&fm=26&gp=0.jpg","goodsList":[{"id":149187842867924,"goodsName":"华为手机","smallPic":"https://img30.360buyimg.com/popWaterMark/jfs/t1/66034/10/5411/93643/5d382afcE5f106069/89d489bc5eca71f0.jpg"},{"id":149187842867933,"goodsName":"大米手机","smallPic":"https://img30.360buyimg.com/popWaterMark/jfs/t1/66034/10/5411/93643/5d382afcE5f106069/89d489bc5eca71f0.jpg"}]},{"id":2,"name":"华为公司","follow":1,"logoPic":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1820523987,3798556096&fm=26&gp=0.jpg","goodsList":[]}]
         * total : 3
         * size : 2
         * current : 1
         * orders : []
         * searchCount : true
         * pages : 2
         */

        private int total;
        private int size;
        private int current;
        private boolean searchCount;
        private int pages;
        private List<RecordsBean> records;
        private List<?> orders;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public boolean isSearchCount() {
            return searchCount;
        }

        public void setSearchCount(boolean searchCount) {
            this.searchCount = searchCount;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public List<?> getOrders() {
            return orders;
        }

        public void setOrders(List<?> orders) {
            this.orders = orders;
        }

        public static class RecordsBean {
            /**
             * id : 1
             * name : 百度公司
             * follow : 2
             * logoPic : https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1700741544,1951185347&fm=26&gp=0.jpg
             * goodsList : [{"id":149187842867924,"goodsName":"华为手机","smallPic":"https://img30.360buyimg.com/popWaterMark/jfs/t1/66034/10/5411/93643/5d382afcE5f106069/89d489bc5eca71f0.jpg"},{"id":149187842867933,"goodsName":"大米手机","smallPic":"https://img30.360buyimg.com/popWaterMark/jfs/t1/66034/10/5411/93643/5d382afcE5f106069/89d489bc5eca71f0.jpg"}]
             */

            private int id;
            private String name;
            private int follow;
            private String logoPic;
            private List<GoodsListBean> goodsList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public String getLogoPic() {
                return logoPic;
            }

            public void setLogoPic(String logoPic) {
                this.logoPic = logoPic;
            }

            public List<GoodsListBean> getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(List<GoodsListBean> goodsList) {
                this.goodsList = goodsList;
            }

            public static class GoodsListBean {
                /**
                 * id : 149187842867924
                 * goodsName : 华为手机
                 * smallPic : https://img30.360buyimg.com/popWaterMark/jfs/t1/66034/10/5411/93643/5d382afcE5f106069/89d489bc5eca71f0.jpg
                 */

                private long id;
                private String goodsName;
                private String smallPic;

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public String getSmallPic() {
                    return smallPic;
                }

                public void setSmallPic(String smallPic) {
                    this.smallPic = smallPic;
                }
            }
        }
    }
}
