package com.example.z_common;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

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
}
