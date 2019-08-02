package com.example.z_common.Amap;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.example.z_base.BaseActivity;

/**高德地图工具类**/
public class AmapPositioningUtil {
    //保存的定位信息  是否定位成功   全部定位信息
    private static boolean isPosition=false;
    private static AMapLocation OKMapLocation;


    private static AmapPositioningUtil amapPositioningUtil=null;
    public static AmapPositioningUtil getAmapPositioningUtil(){
        if (amapPositioningUtil==null){
            amapPositioningUtil=new AmapPositioningUtil();
        }
        return amapPositioningUtil;
    }
    private AMapLocationClient mLocationClient;   //声明AMapLocationClient类对象
    private AMapLocationClientOption option;     //声明AMapLocationClientOption对象
    /**初始化**/
    private AmapPositioningUtil(){
        mLocationClient=new AMapLocationClient(BaseActivity.getInstance());
        option = new AMapLocationClientOption();
        option.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn);

        option.setHttpTimeOut(10000); //单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。  这里设置定位超时为10秒
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy); // 高精度定位模式。 使用网络定位和gps定位
    }
    /**启动定位**/
    public void StartPositioning(AMapLocationListener mLocationListener){
        if(null != mLocationClient){
            mLocationClient.setLocationListener(mLocationListener);    //设置定位回调监听
            mLocationClient.setLocationOption(option);
            mLocationClient.stopLocation();  //设置场景模式后最好调用一次stop，再调用start以保证场景模式生效
            mLocationClient.startLocation();
        }
    }
    /**停止定位**/
    public void StopPositioning(){
        if(null != mLocationClient){
            mLocationClient.stopLocation();  //设置场景模式后最好调用一次stop，再调用start以保证场景模式生效
            isPosition=false;   //清除定位信息
            OKMapLocation=null;  //清除定位信息
       }
    }

    /**定位数据的解析方法**/
    public static String ParsingAMapLocation(AMapLocation aMapLocation){
        String LocationMessage=null;
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                OKMapLocation=aMapLocation;
                isPosition=true;
                LocationMessage=aMapLocation.getAddress();
            }else {
                LocationMessage="定位失败";
            }
        }
        return LocationMessage;
    }



    public static boolean isIsPosition() {
        return isPosition;
    }
    public static void setIsPosition(boolean isPosition) {
        AmapPositioningUtil.isPosition = isPosition;
    }
    public static AMapLocation getOKMapLocation() {
        return OKMapLocation;
    }
    public static void setOKMapLocation(AMapLocation OKMapLocation) {
        AmapPositioningUtil.OKMapLocation = OKMapLocation;
    }
}
