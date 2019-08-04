package com.example.zengwei.threeeggs.Model;

/**
 * Created by zengwei on 2019/8/3.
 */

public class ApkUpdate {
    private int id;
    private String apkDownloadUrl;
    private String appVersion;

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

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}
