package com.example.z_common.Util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.text.emoji.EmojiCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.z_base.BaseActivity;
import com.example.z_common.Custom.Dialog.DialogUtil;
import com.example.z_common.Model.CityList;
import com.example.z_common.Model.Citys;
import com.example.z_common.Model.Token;
import com.example.z_common.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static RecyclerView.LayoutManager getRecyclerLayoutManager(int number, final boolean isScroll){
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(number, StaggeredGridLayoutManager.VERTICAL){
            @Override
            public boolean canScrollVertically() {
                if(isScroll){
                    return false;
                }else {
                    return super.canScrollVertically();
                }
            }
        };
        return layoutManager;
    }
    /**列表的布局方式**/
    public static RecyclerView.LayoutManager getNoScrollRecyclerLayoutManager(boolean isLG,int number){
        if (isLG){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BaseActivity.getInstance(),
                    LinearLayoutManager.VERTICAL, false) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };

            return linearLayoutManager;
        }else {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(BaseActivity.getInstance(), number){
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            //设置表格，根据position计算在该position处1列占几格数据
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override public int getSpanSize(int position) {
                    return 1;
                }
            });
            return gridLayoutManager;
        }
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
    public static int getAppVersion(){
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = BaseActivity.getInstance().getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(BaseActivity.getInstance().getPackageName(),0);
            int version = packInfo.versionCode;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            //出错返回默认1.0版本
            return 1;
        }
    }

    /**权限获取**/
    public static void getPermissions(){
        String[] strings={Permission.ACCESS_COARSE_LOCATION,
                Permission. ACCESS_FINE_LOCATION,
                Permission. READ_PHONE_STATE,
                Permission. WRITE_EXTERNAL_STORAGE};
        //                Permission. REQUEST_INSTALL_PACKAGES
        XXPermissions.with(BaseActivity.getInstance())
                .permission(strings) //支持请求6.0悬浮窗权限8.0请求安装权限
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

    public static int[] caitsints={1,2,3,14,25,37,51,60,73,74,87,98,115,124,135,152,170,187,201
            ,236,257,258,279,288,311,321,335,362,222,304,343,348,384,387};
    /**获取城市列表对象数组**/
    public static List<Citys> getCitys() throws IOException {
        InputStream inputStream=BaseActivity.getInstance().getAssets().open("json/cities.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<Citys> cityse=new Gson().fromJson(reader, new TypeToken<List<Citys>>() {}.getType());
        return cityse;
    }
    /**定位界面显示城市列表   现在只放了地级市**/
    public static List<CityList> getCitysList(){
        List<CityList> cityLists=new ArrayList<>();
        try {
            List<String> strings=new ArrayList<>();
            Map<String,CityList> cityListMap=new HashMap<>();
            for (Citys citys1:getCitys()){
                for (Citys.CityBean cityBean:citys1.getCity()){
                    cityListMap.put(cityBean.getSpell(),new CityList(cityBean.getCode(),cityBean.getAbb().substring(0,1).toUpperCase(),cityBean.getName(),cityBean.getSpell()));
                    strings.add(cityBean.getSpell());
                }
            }
            Collections.sort(strings);
            cityLists.add(cityListMap.get("beijingshi"));
            cityLists.get(0).setSname("#");
            cityLists.add(cityListMap.get("shanghaishi"));
            cityLists.get(1).setSname("#");
            cityLists.add(cityListMap.get("guangzhoushi"));
            cityLists.get(2).setSname("#");
            cityLists.add(cityListMap.get("shenzhenshi"));
            cityLists.get(3).setSname("#");
            cityLists.add(cityListMap.get("hangzhoushi"));
            cityLists.get(4).setSname("#");
            cityLists.add(cityListMap.get("changshashi"));
            cityLists.get(5).setSname("#");
            cityLists.add(cityListMap.get("nanjingshi"));
            cityLists.get(6).setSname("#");
            cityLists.add(cityListMap.get("wuhanshi"));
            cityLists.get(7).setSname("#");
            for (String s:strings){
                cityLists.add(cityListMap.get(s));
            }
        }catch (Exception E){

        }
        return cityLists;
    }

    /**验证是否登陆**/
    public static boolean IsLogin(){
        boolean b= (boolean) new SharedPreferencesHelper(BaseActivity.getInstance(),"TOKEN").getSharedPreference("ISLogin",false);
        return b;
    }

    /**
     * 隐藏输入软键盘
     * @param context
     * @param view
     */
    public static void hideInputManager(Context context,View view){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (view !=null && imm != null){
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);  //强制隐藏
        }
    }

    /**获取设备token**/
    public static String getToken(Context context){
        Token token=((Token)new SharedPreferencesHelper(context,"TOKEN").getBase64("key"));
        if (token==null){
            return null;
        }else {
            SimpleUtils.setLog(token.getToken());
            return token.getToken();
        }
    }

    /**价格单位换算  单位：分 ---单外：元**/
    public static String getPrice(int price){
        DecimalFormat df=new DecimalFormat("0.00");//设置保留位数
        if (price>0)
            return df.format((double) price/(double)100);
        else
            return 0+"";
    }

    /**字符和表情转换**/
    public static String stringToUnicode(String string) {

        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {

            // 取出每一个字符
            char c = string.charAt(i);

            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }

        return unicode.toString();
    }

    /**转成字符 和表情**/
    public static CharSequence unicode2String(String unicode) {

        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);

            // 追加成string
            string.append((char) data);
        }

        return EmojiCompat.get().process(string.toString());
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
