package com.example.z_common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

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
    public static RecyclerView.LayoutManager getRecyclerLayoutManager(int number ){
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(number, StaggeredGridLayoutManager.VERTICAL);
        return layoutManager;
    }

    /**设置字体图标**/
    public static void setViewTypeface(Context context,Object View,String str){
        Typeface typeface=Typeface.createFromAsset(context.getAssets(),"font/icomoon.ttf");
        if (View instanceof TextView){
            ((TextView)View).setTypeface(typeface);
            ((TextView)View).setText(str);
        }else if (View instanceof EditText){
            ((EditText)View).setTypeface(typeface);
            ((EditText)View).setText(str);
        }
    }

    /**获取版本号**/
    public static String getAppVersion(Context context){
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = context.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(),0);
            String version = packInfo.versionName;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            //出错返回默认1.0版本
            return "1.0";
        }
    }


    /**控制 log**/
    public static void setLog(String str){
        Log.d("zengwei123",str);
    }
}
