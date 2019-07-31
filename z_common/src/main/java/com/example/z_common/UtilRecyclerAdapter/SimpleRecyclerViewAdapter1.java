package com.example.z_common.UtilRecyclerAdapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.z_common.Model.AllDataState;

import java.util.List;

/**
 * Created by zengwei on 2019/7/21.
 * 可以实现多布局的Recycler
 */

public class SimpleRecyclerViewAdapter1 extends BaseMultiItemQuickAdapter<AllDataState, BaseViewHolder> {
    private SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback;
    public SimpleRecyclerViewAdapter1(int[] layouts,List data,SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback) {
        super(data);
        for (int i=0;i<layouts.length;i++){
            addItemType(i, layouts[i]);
        }
        this.simpleRecyclerViewAdapterCallback=simpleRecyclerViewAdapterCallback;
    }

    @Override
    protected void convert(BaseViewHolder helper, AllDataState item) {
        simpleRecyclerViewAdapterCallback.convert(helper,item);
    }
}