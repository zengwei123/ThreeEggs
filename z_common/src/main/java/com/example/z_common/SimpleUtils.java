package com.example.z_common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.z_base.BaseActivity;
import com.example.z_common.Custom.Dialog.DialogUtil;
import com.example.z_common.Model.CityList;
import com.example.z_common.Model.Citys;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.XXPermissions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwei on 2019/7/21.
 * 基础的一些工具
 */

public class SimpleUtils {
    /**列表的布局方式**/
    public static RecyclerView.LayoutManager getRecyclerLayoutManager(boolean isLG,int number ){
        if (isLG){
            return new LinearLayoutManager(BaseActivity.getInstance());
        }else {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(BaseActivity.getInstance(), number);
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
    public static void setViewTypeface(Object View,String str){
        Typeface typeface=Typeface.createFromAsset(BaseActivity.getInstance().getAssets(),"font/icomoon.ttf");
        if (View instanceof TextView){
            ((TextView)View).setTypeface(typeface);
            ((TextView)View).setText(str);
        }else if (View instanceof EditText){
            ((EditText)View).setTypeface(typeface);
            ((EditText)View).setText(str);
        }
    }

    /**获取版本号**/
    public static String getAppVersion(){
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = BaseActivity.getInstance().getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(BaseActivity.getInstance().getPackageName(),0);
            String version = packInfo.versionName;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            //出错返回默认1.0版本
            return "1.0";
        }
    }

    /**权限获取**/
    public static void getPermissions(){
        XXPermissions.with(BaseActivity.getInstance())
                //.constantRequest() //可设置被拒绝后继续申请，直到用户授权或者永久拒绝
//                .permission(Permission.SYSTEM_ALERT_WINDOW, Permission.REQUEST_INSTALL_PACKAGES) //支持请求6.0悬浮窗权限8.0请求安装权限
                //.permission() //不指定权限则自动获取清单中的危险权限
                .request(new OnPermission() {

                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {
                        if (!isAll){
                            DialogUtil dialogUtil = new DialogUtil();
                            dialogUtil.show(R.mipmap.prompt, "重要权限未授权部分功将会受限，可能会影响您的使用体验，是否手动开启权限？", "设置",new DialogUtil.DialogButtonListener() {
                                @Override
                                public void sure() {
                                    XXPermissions.gotoPermissionSettings(BaseActivity.getInstance());
                                }

                                @Override
                                public void cancel() {
                                }
                            });
                        }
                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {

                    }
                });
    }

    /**获取屏幕的宽高**/
    public static int getWindowSize(boolean b) {
        WindowManager manager = (WindowManager) BaseActivity.getInstance().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        if (b){
            return dm.widthPixels;
        }else {
            return dm.heightPixels;
        }
    }

    /**获取城市列表对象数组**/
    public static List<Citys> getCitys() throws IOException {
        InputStream inputStream=BaseActivity.getInstance().getAssets().open("json/cities.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return new Gson().fromJson(reader, new TypeToken<List<Citys>>() {}.getType());
    }
    /**定位界面显示城市列表   现在只放了地级市**/
    public static List<CityList> getCitysList(){
        List<CityList> cityLists=new ArrayList<>();
        try {
            for (Citys citys:getCitys()){
                for (Citys.CityBean cityBean:citys.getCity()){
                    cityLists.add(new CityList(cityBean.getCode(),citys.getName(),cityBean.getName(),cityBean.getAbb()));
//                    for (Citys.CityBean.AreaBean areaBean:cityBean.getArea()){
//                        cityLists.add(new CityList(areaBean.getCode(),cityBean.getName(),areaBean.getName(),areaBean.getAbb()));
//                    }
                }
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        return cityLists;
    }


    /**控制 log**/
    public static void setLog(String str){
        Log.d("zengwei123",str);
    }

    /**控制 Toast**/
    public static void setToast(String str){
        Toast.makeText(BaseActivity.getInstance(), str, Toast.LENGTH_SHORT).show();
    }
}
