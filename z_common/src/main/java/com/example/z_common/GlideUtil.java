package com.example.z_common;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.z_base.BaseActivity;

/**
 * Created by zengwei on 2019/7/20.
 * 图片请求工具类
 */

public class GlideUtil {
    public static void displayImage(Activity activity,Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Glide.with(activity).load(path).into(imageView);
    }
    /**设置textview图片**/
    public  static void drawableImage(int WH,int imageid, TextView textView,boolean b) {
        Drawable drawable = BaseActivity.getInstance().getResources().getDrawable(imageid);
        drawable.setBounds(0, 0, WH, WH);
        if (b){
            textView.setCompoundDrawables(drawable,null,null,null);
        }else {
            textView.setCompoundDrawables(null,null,drawable,null);
        }
    }

}
