package com.example.zengwei.threeeggs.Model;

/**
 * Created by zengwei on 2019/8/3.
 */

public class ApkUpdate {

    /**
     * apkUpdate : {"id":4,"apkDownloadUrl":"http://www.baidu.com","sort":1,"appVersion":1,"isPublish":0,"isValid":1,"isDelete":0}
     */

    private ApkUpdateBean apkUpdate;

    public ApkUpdateBean getApkUpdate() {
        return apkUpdate;
    }

    public void setApkUpdate(ApkUpdateBean apkUpdate) {
        this.apkUpdate = apkUpdate;
    }

    public static class ApkUpdateBean {
        /**
         * id : 4
         * apkDownloadUrl : http://www.baidu.com
         * sort : 1
         * appVersion : 1
         * isPublish : 0
         * isValid : 1
         * isDelete : 0
         */

        private int id;
        private String apkDownloadUrl;
        private int sort;
        private int appVersion;
        private int isPublish;
        private int isValid;
        private int isDelete;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getApkDownloadUrl() {
            return apkDownloadUrl;
        }

        public void setApkDownloadUrl(String apkDownloadUrl) {
            this.apkDownloadUrl = apkDownloadUrl;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(int appVersion) {
            this.appVersion = appVersion;
        }

        public int getIsPublish() {
            return isPublish;
        }

        public void setIsPublish(int isPublish) {
            this.isPublish = isPublish;
        }

        public int getIsValid() {
            return isValid;
        }

        public void setIsValid(int isValid) {
            this.isValid = isValid;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }
    }
}
