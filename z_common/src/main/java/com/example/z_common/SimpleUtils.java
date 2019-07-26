package com.example.z_common;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

/**
 * Created by zengwei on 2019/7/21.
 * 基础的一些工具
 */

public class SimpleUtils {
    /**列表的布局方式**/
    public static RecyclerView.LayoutManager getRecyclerLayoutManager(boolean isLG, Context context,int number ){
        if (isLG){
            return new LinearLayoutManager(context);
        }else {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, number);
            //设置表格，根据position计算在该position处1列占几格数据
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override public int getSpanSize(int position) {
                    return 1;
                }
            });
            return gridLayoutManager;
        }
    }
    /**也是列表的布局方式  瀑布流**/
    public static RecyclerView.LayoutManager getRecyclerLayoutManager(Context context,int number ){
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(number, StaggeredGridLayoutManager.VERTICAL);
        return layoutManager;
    }

    public static void Test(){
        Log.d("zengwei123","测试");
    }
}
