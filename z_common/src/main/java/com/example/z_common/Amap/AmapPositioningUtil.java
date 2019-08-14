package com.example.z_common.Amap;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.example.z_base.BaseActivity;
import com.example.z_common.CommonRequestServiceFactory;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.Model.PositioningSuccessful;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.SimpleUtils;

import io.reactivex.disposables.Disposable;

/**高德地图工具类**/
public class AmapPositioningUtil {
    //保存的定位信息  是否定位成功   全部定位信息
    private static int isPosition=-1;    //-1 没有定位   0定位成功   1定位失败   2手动定位  3未获取具体位置 只拿到城市
    private static PositioningSuccessful positioningSuccessful;


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
            isPosition=-1;   //清除定位信息
            positioningSuccessful=null;
       }
    }

    /**定位数据的解析方法**/
    public static String ParsingAMapLocation(AMapLocation aMapLocation){
        String LocationMessage="定位失败";
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                positioningSuccessful=new PositioningSuccessful(aMapLocation.getCity(),
                        aMapLocation.getCityCode(),
                        aMapLocation.getAddress(),
                        aMapLocation.getLongitude(),
                        aMapLocation.getLatitude(),
                        aMapLocation.getPoiName());

                isPosition=0;
                LocationMessage=aMapLocation.getAddress();
            }else {
                LocationMessage="定位失败";
                isPosition=1;
            }
        }
        return LocationMessage;
    }


    public static int getIsPosition() {
        return isPosition;
    }

    public static void setIsPosition(int isPosition) {
        AmapPositioningUtil.isPosition = isPosition;
    }

    public static PositioningSuccessful getPositioningSuccessful() {
        return positioningSuccessful;
    }

    public static void setPositioningSuccessful(PositioningSuccessful positioningSuccessful) {
        //只要设置了这个我就给你保存定位信息
        AmapPositioningUtil.positioningSuccessful = positioningSuccessful;
        CommonRequestServiceFactory.orientation(new RequestObserver.RequestObserverNext<AllDataState>() {
            @Override
            public void Next(AllDataState o) {
                if (o.isSuccess()){

                }else {
                    SimpleUtils.setLog("定位错误"+o.getMessage());
                }
            }

            @Override
            public void onError() {

            }

            @Override
            public void getDisposable(Disposable d) {

            }
        },AmapPositioningUtil.positioningSuccessful);
    }
}
