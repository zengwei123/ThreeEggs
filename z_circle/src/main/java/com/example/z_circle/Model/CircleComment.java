package com.example.z_circle.Model;

import java.util.List;

/**
 * Created by zengwei on 2019/9/20.
 * 圈子的评论
 */

public class CircleComment {

    /**
     * page : {"total":"21","list":[{"id":"1174524606321659904","roundId":"1172119067230765058","commentId":"1174518785911164928","ownerUserId":"1167623100242726912","content":"我突然横空出世了？","images":"http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg","commentNum":"0","likeNum":"0","isValid":true,"isDelete":false,"createTime":"2019-09-19 11:24:22","updateTime":"2019-09-19 11:24:22","commentUserName":"佐助","commentHeadImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","hasLike":false,"hasReply":false,"commentReplyId":"1174523030056079360","replyUserName":"佐助","replyContent":"我突然横空出世了？","replyImages":"http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg"},{"id":"1174523092786089984","roundId":"1172119067230765058","commentId":"1174518785911164928","commentReplyId":"1174523030056079360","ownerUserId":"1167623100242726912","content":"我也突然横空出世了？","images":"http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg","commentNum":"0","likeNum":"0","isValid":true,"isDelete":false,"createTime":"2019-09-19 11:18:22","updateTime":"2019-09-19 11:18:22","commentUserName":"佐助","commentHeadImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","replyUserName":"佐助","replyContent":"我突然横空出世了？","replyImages":"http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg","hasLike":false,"hasReply":true},{"id":"1174523030056079360","roundId":"1172119067230765058","commentId":"1174518785911164928","ownerUserId":"1167623100242726912","content":"我突然横空出世了？","images":"http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg","commentNum":"0","likeNum":"0","isValid":true,"isDelete":false,"createTime":"2019-09-19 11:18:07","updateTime":"2019-09-19 11:18:07","commentUserName":"佐助","commentHeadImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","hasLike":false,"hasReply":false},{"id":"1174522943313678336","roundId":"1172119067230765058","ownerUserId":"1167623100242726912","content":"我突然横空出世了？","images":"http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg","commentNum":"0","likeNum":"0","isValid":true,"isDelete":false,"createTime":"2019-09-19 11:17:46","updateTime":"2019-09-19 11:17:46","commentUserName":"佐助","commentHeadImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","hasLike":false,"hasReply":false},{"id":"1174522822870044672","roundId":"1172119067230765058","ownerUserId":"1167623100242726912","content":"我突然横空出世了？","images":"http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg","commentNum":"0","likeNum":"0","isValid":true,"isDelete":false,"createTime":"2019-09-19 11:17:17","updateTime":"2019-09-19 11:17:17","commentUserName":"佐助","commentHeadImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","hasLike":false,"hasReply":false}],"pageNum":"1","pageSize":"5","size":"5","startRow":"1","endRow":"5","pages":"5","prePage":"0","nextPage":"2","isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":"8","navigatepageNums":[1,2,3,4,5],"navigateFirstPage":"1","navigateLastPage":"5"}
     */

    private PageBean page;

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "CircleComment{" +
                "page=" + page +
                '}';
    }

    public static class PageBean {
        /**
         * total : 21
         * list : [{"id":"1174524606321659904","roundId":"1172119067230765058","commentId":"1174518785911164928","ownerUserId":"1167623100242726912","content":"我突然横空出世了？","images":"http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg","commentNum":"0","likeNum":"0","isValid":true,"isDelete":false,"createTime":"2019-09-19 11:24:22","updateTime":"2019-09-19 11:24:22","commentUserName":"佐助","commentHeadImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","hasLike":false,"hasReply":false},{"id":"1174523092786089984","roundId":"1172119067230765058","commentId":"1174518785911164928","commentReplyId":"1174523030056079360","ownerUserId":"1167623100242726912","content":"我也突然横空出世了？","images":"http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg","commentNum":"0","likeNum":"0","isValid":true,"isDelete":false,"createTime":"2019-09-19 11:18:22","updateTime":"2019-09-19 11:18:22","commentUserName":"佐助","commentHeadImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","replyUserName":"佐助","replyContent":"我突然横空出世了？","replyImages":"http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg","hasLike":false,"hasReply":true},{"id":"1174523030056079360","roundId":"1172119067230765058","commentId":"1174518785911164928","ownerUserId":"1167623100242726912","content":"我突然横空出世了？","images":"http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg","commentNum":"0","likeNum":"0","isValid":true,"isDelete":false,"createTime":"2019-09-19 11:18:07","updateTime":"2019-09-19 11:18:07","commentUserName":"佐助","commentHeadImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","hasLike":false,"hasReply":false},{"id":"1174522943313678336","roundId":"1172119067230765058","ownerUserId":"1167623100242726912","content":"我突然横空出世了？","images":"http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg","commentNum":"0","likeNum":"0","isValid":true,"isDelete":false,"createTime":"2019-09-19 11:17:46","updateTime":"2019-09-19 11:17:46","commentUserName":"佐助","commentHeadImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","hasLike":false,"hasReply":false},{"id":"1174522822870044672","roundId":"1172119067230765058","ownerUserId":"1167623100242726912","content":"我突然横空出世了？","images":"http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg","commentNum":"0","likeNum":"0","isValid":true,"isDelete":false,"createTime":"2019-09-19 11:17:17","updateTime":"2019-09-19 11:17:17","commentUserName":"佐助","commentHeadImg":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg","hasLike":false,"hasReply":false}]
         * pageNum : 1
         * pageSize : 5
         * size : 5
         * startRow : 1
         * endRow : 5
         * pages : 5
         * prePage : 0
         * nextPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2,3,4,5]
         * navigateFirstPage : 1
         * navigateLastPage : 5
         */

        private String total;
        private String pageNum;
        private String pageSize;
        private String size;
        private String startRow;
        private String endRow;
        private String pages;
        private String prePage;
        private String nextPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private String navigatePages;
        private String navigateFirstPage;
        private String navigateLastPage;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getPageNum() {
            return pageNum;
        }

        public void setPageNum(String pageNum) {
            this.pageNum = pageNum;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getStartRow() {
            return startRow;
        }

        public void setStartRow(String startRow) {
            this.startRow = startRow;
        }

        public String getEndRow() {
            return endRow;
        }

        public void setEndRow(String endRow) {
            this.endRow = endRow;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public String getPrePage() {
            return prePage;
        }

        public void setPrePage(String prePage) {
            this.prePage = prePage;
        }

        public String getNextPage() {
            return nextPage;
        }

        public void setNextPage(String nextPage) {
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

        public String getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(String navigatePages) {
            this.navigatePages = navigatePages;
        }

        public String getNavigateFirstPage() {
            return navigateFirstPage;
        }

        public void setNavigateFirstPage(String navigateFirstPage) {
            this.navigateFirstPage = navigateFirstPage;
        }

        public String getNavigateLastPage() {
            return navigateLastPage;
        }

        public void setNavigateLastPage(String navigateLastPage) {
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

        @Override
        public String toString() {
            return "PageBean{" +
                    "total='" + total + '\'' +
                    ", pageNum='" + pageNum + '\'' +
                    ", pageSize='" + pageSize + '\'' +
                    ", size='" + size + '\'' +
                    ", startRow='" + startRow + '\'' +
                    ", endRow='" + endRow + '\'' +
                    ", pages='" + pages + '\'' +
                    ", prePage='" + prePage + '\'' +
                    ", nextPage='" + nextPage + '\'' +
                    ", isFirstPage=" + isFirstPage +
                    ", isLastPage=" + isLastPage +
                    ", hasPreviousPage=" + hasPreviousPage +
                    ", hasNextPage=" + hasNextPage +
                    ", navigatePages='" + navigatePages + '\'' +
                    ", navigateFirstPage='" + navigateFirstPage + '\'' +
                    ", navigateLastPage='" + navigateLastPage + '\'' +
                    ", list=" + list +
                    ", navigatepageNums=" + navigatepageNums +
                    '}';
        }

        public static class ListBean {
            /**
             * id : 1174524606321659904
             * roundId : 1172119067230765058
             * commentId : 1174518785911164928
             * ownerUserId : 1167623100242726912
             * content : 我突然横空出世了？
             * images : http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg
             * commentNum : 0
             * likeNum : 0
             * isValid : true
             * isDelete : false
             * createTime : 2019-09-19 11:24:22
             * updateTime : 2019-09-19 11:24:22
             * commentUserName : 佐助
             * commentHeadImg : https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567929805&di=69e3564e973748d9d792550c5b0fa579&src=http://img5.duitang.com/uploads/item/201502/08/20150208102535_TY3EY.jpeg
             * hasLike : false
             * hasReply : false
             * commentReplyId : 1174523030056079360
             * replyUserName : 佐助
             * replyContent : 我突然横空出世了？
             * replyImages : http://i0.hdslb.com/bfs/face/4e671f19788b7fccadf9772bb92e2041c5ea02fe.jpg,http://i1.hdslb.com/bfs/face/d0a5f0eecf4a6bdf9b5049406aff48a66d852f2e.jpg
             */

            private String id;
            private String roundId;
            private String commentId;
            private String ownerUserId;
            private String content;
            private String images;
            private String commentNum;
            private String likeNum;
            private boolean isValid;
            private boolean isDelete;
            private String createTime;
            private String updateTime;
            private String commentUserName;
            private String commentHeadImg;
            private boolean hasLike;
            private boolean hasReply;
            private String commentReplyId;
            private String replyUserName;
            private String replyContent;
            private String replyImages;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getRoundId() {
                return roundId;
            }

            public void setRoundId(String roundId) {
                this.roundId = roundId;
            }

            public String getCommentId() {
                return commentId;
            }

            public void setCommentId(String commentId) {
                this.commentId = commentId;
            }

            public String getOwnerUserId() {
                return ownerUserId;
            }

            public void setOwnerUserId(String ownerUserId) {
                this.ownerUserId = ownerUserId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(String commentNum) {
                this.commentNum = commentNum;
            }

            public String getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(String likeNum) {
                this.likeNum = likeNum;
            }

            public boolean isIsValid() {
                return isValid;
            }

            public void setIsValid(boolean isValid) {
                this.isValid = isValid;
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

            public String getCommentUserName() {
                return commentUserName;
            }

            public void setCommentUserName(String commentUserName) {
                this.commentUserName = commentUserName;
            }

            public String getCommentHeadImg() {
                return commentHeadImg;
            }

            public void setCommentHeadImg(String commentHeadImg) {
                this.commentHeadImg = commentHeadImg;
            }

            public boolean isHasLike() {
                return hasLike;
            }

            public void setHasLike(boolean hasLike) {
                this.hasLike = hasLike;
            }

            public boolean isHasReply() {
                return hasReply;
            }

            public void setHasReply(boolean hasReply) {
                this.hasReply = hasReply;
            }

            public String getCommentReplyId() {
                return commentReplyId;
            }

            public void setCommentReplyId(String commentReplyId) {
                this.commentReplyId = commentReplyId;
            }

            public String getReplyUserName() {
                return replyUserName;
            }

            public void setReplyUserName(String replyUserName) {
                this.replyUserName = replyUserName;
            }

            public String getReplyContent() {
                return replyContent;
            }

            public void setReplyContent(String replyContent) {
                this.replyContent = replyContent;
            }

            public String getReplyImages() {
                return replyImages;
            }

            public void setReplyImages(String replyImages) {
                this.replyImages = replyImages;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id='" + id + '\'' +
                        ", roundId='" + roundId + '\'' +
                        ", commentId='" + commentId + '\'' +
                        ", ownerUserId='" + ownerUserId + '\'' +
                        ", content='" + content + '\'' +
                        ", images='" + images + '\'' +
                        ", commentNum='" + commentNum + '\'' +
                        ", likeNum='" + likeNum + '\'' +
                        ", isValid=" + isValid +
                        ", isDelete=" + isDelete +
                        ", createTime='" + createTime + '\'' +
                        ", updateTime='" + updateTime + '\'' +
                        ", commentUserName='" + commentUserName + '\'' +
                        ", commentHeadImg='" + commentHeadImg + '\'' +
                        ", hasLike=" + hasLike +
                        ", hasReply=" + hasReply +
                        ", commentReplyId='" + commentReplyId + '\'' +
                        ", replyUserName='" + replyUserName + '\'' +
                        ", replyContent='" + replyContent + '\'' +
                        ", replyImages='" + replyImages + '\'' +
                        '}';
            }
        }
    }
}
