package com.example.z_circle.Model;

import java.util.List;

/**
 * Created by zengwei on 2019/9/16.
 * 圈子首页数据model
 */

public class CircleHome {


    private List<CarouselBean> carousel;
    private List<LabelsBean> labels;

    public List<CarouselBean> getCarousel() {
        return carousel;
    }

    public void setCarousel(List<CarouselBean> carousel) {
        this.carousel = carousel;
    }

    public List<LabelsBean> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelsBean> labels) {
        this.labels = labels;
    }

    public static class CarouselBean {
        /**
         * id : 1172119067230765058
         * roundTitle : 曾经，我们的童年也是这般纯粹
         * posterUrl : http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg
         * sellerId : 3
         * goodsId : 149187842867914
         */

        private long id;
        private String roundTitle;
        private String posterUrl;
        private int sellerId;
        private long goodsId;

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

        public String getPosterUrl() {
            return posterUrl;
        }

        public void setPosterUrl(String posterUrl) {
            this.posterUrl = posterUrl;
        }

        public int getSellerId() {
            return sellerId;
        }

        public void setSellerId(int sellerId) {
            this.sellerId = sellerId;
        }

        public long getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(long goodsId) {
            this.goodsId = goodsId;
        }
    }

    public static class LabelsBean {
        /**
         * id : 7
         * labelName : 热文推荐
         */

        private int id;
        private String labelName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLabelName() {
            return labelName;
        }

        public void setLabelName(String labelName) {
            this.labelName = labelName;
        }
    }
}
