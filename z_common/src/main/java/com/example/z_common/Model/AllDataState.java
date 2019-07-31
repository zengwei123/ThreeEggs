package com.example.z_common.Model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by zengwei on 2019/7/21.
 * 全部数据的状态
 */

public class AllDataState<T> implements MultiItemEntity {
    private int itemType;
    private T data;
    private int code;
    private boolean success;
    private String message;

    public AllDataState(T data,int itemType) {
        this.data=data;
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
