package com.example.z_common.Model;

public class CityList {
    private String code;  //城市编号
    private String sname; //省份+城市
    private String name;  //城市姓名
    private String abb;    //缩写

    public CityList(String code, String sname, String name,String abb) {
        this.code = code;
        this.sname=sname;
        this.name = name;
        this.abb = abb;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbb() {
        return abb;
    }

    public void setAbb(String abb) {
        this.abb = abb;
    }
}
