package com.example.z_common.Model;

/**
 * Created by zengwei on 2019/8/8.
 */

public class PositioningSuccessful {
    private String City;
    private String CityCode;
    private String Address;
    private double Longitude;
    private double Latitude;
    private String PoiName;

    public PositioningSuccessful(String city, String cityCode, String address, double longitude, double latitude,String poiName) {
        City = city;
        CityCode = cityCode;
        Address = address;
        Longitude = longitude;
        Latitude = latitude;
        PoiName=poiName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String cityCode) {
        CityCode = cityCode;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public String getPoiName() {
        return PoiName;
    }

    public void setPoiName(String poiName) {
        PoiName = poiName;
    }

    @Override
    public String toString() {
        return "PositioningSuccessful{" +
                "City='" + City + '\'' +
                ", CityCode='" + CityCode + '\'' +
                ", Address='" + Address + '\'' +
                ", Longitude=" + Longitude +
                ", Latitude=" + Latitude +
                ", PoiName='" + PoiName + '\'' +
                '}';
    }
}
