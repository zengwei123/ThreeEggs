package com.example.z_common.UtilRecyclerAdapter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.z_common.R;

import java.util.List;

/**
 * Created by zengwei on 2019/7/21.
 * 一些简单的recycle的adapter
 * 不需要传其他的数据的
 * 单布局
 */

public class SimpleRecyclerViewAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {
    private SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback;
    private static boolean isNoNetWork=true;
    public SimpleRecyclerViewAdapter(int layoutResId, Context context, List data, SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback) {
        super(layoutResId, data);
        mContext=context;
        this.simpleRecyclerViewAdapterCallback=simpleRecyclerViewAdapterCallback;
        if (mContext!=null){
            View view;
            if(isNoNetWork){
                view=View.inflate(mContext, R.layout.common_nodata_layout,null);
            }else {
                view=View.inflate(mContext, R.layout.common_nonetwork_layout,null);
            }
            this.setEmptyView(view);
        }
    }
    /**这个是评论的  就是显示了一个暂无评论**/
    public SimpleRecyclerViewAdapter(int i,int layoutResId, Context context, List data, SimpleRecyclerViewAdapterCallback simpleRecyclerViewAdapterCallback) {
        super(layoutResId, data);
        mContext=context;
        this.simpleRecyclerViewAdapterCallback=simpleRecyclerViewAdapterCallback;
        if (mContext!=null){
            View view=View.inflate(mContext, R.layout.common_comments_layout,null);
            this.setEmptyView(view);
        }
    }


    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        simpleRecyclerViewAdapterCallback.convert(helper,item);
    }

    public static boolean isIsNoNetWork() {
        return isNoNetWork;
    }

    public static void setIsNoNetWork(boolean isNoNetWork) {
        SimpleRecyclerViewAdapter.isNoNetWork = isNoNetWork;
    }
}