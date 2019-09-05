package com.example.z_common;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.z_base.BaseActivity;

import java.security.MessageDigest;

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

    /**加载圆形图片**/
    public static void roundImage(Activity activity,Object path, ImageView imageView){
        Glide.with(activity).load(path).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(imageView);
    }

    /**圆角**/
    public static void roundAngleImage(Activity activity,Object path, ImageView imageView,int rdp){
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .transform(new GlideRoundTransform(rdp));
        Glide.with(activity).load(path).apply(options).into(imageView);
    }
    public static class GlideRoundTransform extends BitmapTransformation {
        private static float radius = 0f;

        public GlideRoundTransform() {
            this(8);
        }

        public GlideRoundTransform(int dp) {
            super();
            this.radius = Resources.getSystem().getDisplayMetrics().density * dp;
        }

        @Override protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return roundCrop(pool, toTransform);
        }

        private static Bitmap roundCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;

            Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            }

            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
            canvas.drawRoundRect(rectF, radius, radius, paint);
            return result;
        }

        @Override
        public void updateDiskCacheKey(MessageDigest messageDigest) {

        }
    }
}
