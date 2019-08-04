package com.example.z_common.Model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by zengwei on 2019/7/21.
 * 全部数据的状态
 */

public class AllDataState<T> implements MultiItemEntity {
    private int itemType;
    private T result;
    private int code;
    private boolean success;
    private String message;

    public AllDataState(T data,int itemType) {
        this.result=data;
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public T getData() {
        return result;
    }

    public void setData(T data) {
        this.result = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AllDataState{" +
                "result=" + result +
                ", code=" + code +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
