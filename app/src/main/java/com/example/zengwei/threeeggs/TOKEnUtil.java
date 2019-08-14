package com.example.zengwei.threeeggs;

import android.annotation.SuppressLint;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.example.z_base.BaseActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by zengwei on 2019/8/14.
 */

public class TOKEnUtil {
    /**获取手机厂商+手机型号**/
    public static String getsystemName(){
        return android.os.Build.BRAND+android.os.Build.MODEL;
    }

    /**获取运营商**/
    @SuppressLint("MissingPermission")
    public static String getoperator(){
        try {
            String ProvidersName = "";
            TelephonyManager telephonyManager = (TelephonyManager) BaseActivity.getInstance().getSystemService(Context.TELEPHONY_SERVICE);
            String IMSI = telephonyManager.getSubscriberId();
            if (IMSI != null) {
                if (IMSI.startsWith("46000") || IMSI.startsWith("46002") || IMSI.startsWith("46007")) {
                    ProvidersName = "中国移动";
                } else if (IMSI.startsWith("46001")  || IMSI.startsWith("46006")) {
                    ProvidersName = "中国联通";
                } else if (IMSI.startsWith("46003")) {
                    ProvidersName = "中国电信";
                }
                return ProvidersName;
            } else {
                return "";
            }
        }catch (Exception e){
            return "";
        }
    }

    /**获取序列号**/
    public static String getseriesNumber(){
        return android.os.Build.SERIAL;
    }

    /**获取无线局域网地址**/
    public static String getwlan(){
        String mac = "";
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            mac = getMacDefault(BaseActivity.getInstance());
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mac = getMacAddress();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mac = getMacFromHardware();
        }
        return mac;
    }
    private static String getMacFromHardware() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(String.format("%02X:", b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    private static String getMacAddress() {
        String WifiAddress = "";
        try {
            WifiAddress = new BufferedReader(new FileReader(new File("/sys/class/net/wlan0/address"))).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return WifiAddress;
    }
    private static String getMacDefault(Context context) {
        String mac = "";
        if (context == null) {
            return mac;
        }
        WifiManager wifi = (WifiManager) context.getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
        if (wifi == null) {
            return mac;
        }
        WifiInfo info = null;
        try {
            info = wifi.getConnectionInfo();
        } catch (Exception e) {
        }
        if (info == null) {
            return null;
        }
        mac = info.getMacAddress();
        mac = mac.toUpperCase(Locale.ENGLISH);
        return mac;
    }

    /**获取蓝牙**/
    public static String getbluetooth(){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return BluetoothAdapter.getDefaultAdapter().getAddress();
        }else {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            Field field = null;
            try {
                field = BluetoothAdapter.class.getDeclaredField("mService");
                field.setAccessible(true);
                Object bluetoothManagerService = field.get(bluetoothAdapter);
                if (bluetoothManagerService == null) {
                    return null;
                }
                Method method = bluetoothManagerService.getClass().getMethod("getAddress");
                if(method != null) {
                    Object obj = method.invoke(bluetoothManagerService);
                    if(obj != null) {
                        return obj.toString();
                    }
                }
                return "";
            }catch (Exception e){
                return "";
            }
        }
    }

    /**获取imei**/
    @SuppressLint("MissingPermission")
    public static String getimei(){
        try {
            TelephonyManager tm = (TelephonyManager) BaseActivity.getInstance().getSystemService(Service.TELEPHONY_SERVICE);
            return tm.getDeviceId();
        }catch (Exception e){
            return "";
        }
    }

    /**获取iccid**/
    @SuppressLint("MissingPermission")
    public static String geticcid(){
        try {
            TelephonyManager tm = (TelephonyManager) BaseActivity.getInstance().getSystemService(Service.TELEPHONY_SERVICE);
            return tm.getSimSerialNumber();
        }catch (Exception e){
            return "";
        }
    }

    /**获取meid**/
    @SuppressLint("MissingPermission")
    public static String getmeid(){
        try {
            TelephonyManager telephonyManager = (TelephonyManager)  BaseActivity.getInstance().getSystemService(Context.TELEPHONY_SERVICE);
            String meid="";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                meid = telephonyManager.getMeid();
            } else {
                Class clazz = null;
                clazz = Class.forName("android.os.SystemProperties");
                Method method = clazz.getMethod("get", String.class, String.class);
                meid = (String) method.invoke(null, "ril.cdma.meid", "");

            }
            return meid;
        }catch (Exception e){
            return "";
        }
    }
}
