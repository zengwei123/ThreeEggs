package com.example.z_common;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.z_common.Model.Home.HomeActivityMenu;
import com.example.z_common.Model.Home.HomeGoodsRecycler;

import java.util.List;

/**
 * Created by zengwei on 2019/7/21.
 * 一些简单的recycle的adapter
 * 不需要传其他的数据的
 */

public class SimpleRecyclerViewAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {
    private Class aclass;
    private SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback;
    public SimpleRecyclerViewAdapter(int layoutResId, List data, Class aclass,SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback) {
        super(layoutResId, data);
        this.aclass=aclass;
        this.simpleRecyclerViewAdapterCallback=simpleRecyclerViewAdapterCallback;
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        simpleRecyclerViewAdapterCallback.convert(helper,item);
    }
}