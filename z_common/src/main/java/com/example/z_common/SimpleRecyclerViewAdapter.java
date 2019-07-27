package com.example.z_common;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by zengwei on 2019/7/21.
 * 一些简单的recycle的adapter
 * 不需要传其他的数据的
 */

public class SimpleRecyclerViewAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {
    private SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback;
    public SimpleRecyclerViewAdapter(int layoutResId, Context context, List data, SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback) {
        super(layoutResId, data);
        mContext=context;
        this.simpleRecyclerViewAdapterCallback=simpleRecyclerViewAdapterCallback;
        if (mContext!=null){
            View view=View.inflate(mContext,R.layout.common_nodata_layout,null);
            this.setEmptyView(view);
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        simpleRecyclerViewAdapterCallback.convert(helper,item);
    }
}