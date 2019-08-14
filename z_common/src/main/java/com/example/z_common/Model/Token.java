package com.example.z_common.Model;

import java.io.Serializable;

/**
 * Created by zengwei on 2019/8/14.
 */

public class Token implements Serializable{
    private String devicesToken;

    @Override
    public String toString() {
        return "Token{" +
                "devicesToken='" + devicesToken + '\'' +
                '}';
    }

    public String getToken() {
        return devicesToken;
    }

    public void setToken(String token) {
        this.devicesToken = token;
    }
}
