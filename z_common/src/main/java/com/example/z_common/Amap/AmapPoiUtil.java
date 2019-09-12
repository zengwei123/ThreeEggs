package com.example.z_common.Amap;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.example.z_base.BaseActivity;
import com.example.z_common.Model.PositioningSuccessful;
import com.example.z_common.Util.SimpleUtils;

import java.util.ArrayList;
import java.util.List;

/**附近地址的推荐**/
public class AmapPoiUtil {
    public static void getNearPoi(String keyWord, String cityCode, double latitude, double longitude, final PoiAddreess poiAddreess){
        SimpleUtils.setLog("这里了1");
        PoiSearch.Query query=new PoiSearch.Query("", "060101", cityCode);
        query.setPageSize(15);// 设置每页最多返回多少条poiitem
        query.setPageNum(1);//设置查询页码
        PoiSearch poiSearch=new PoiSearch(BaseActivity.getInstance(), query);
        poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() {
            @Override
            public void onPoiSearched(PoiResult poiResult, int i) {
                SimpleUtils.setLog("这里了2");
                List<PositioningSuccessful> strings=new ArrayList();
                if(poiResult!=null){
                    for (PoiItem poiItem:poiResult.getPois()){
                        SimpleUtils.setLog(poiItem.toString());
                        strings.add(new PositioningSuccessful(poiItem.getCityName(),poiItem.getAdCode(),
                                poiItem.getCityName()+poiItem.getAdName()+poiItem.toString(),
                                poiItem.getLatLonPoint().getLongitude(),poiItem.getLatLonPoint().getLatitude(),""));
                    }
                }
                poiAddreess.getPoiAddreess(strings);
            }
            @Override
            public void onPoiItemSearched(PoiItem poiItem, int i) {
                SimpleUtils.setLog("这里了3");
            }
        });
        poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(latitude, longitude), 3000));//设置周边搜索的中心点以及半径
        poiSearch.searchPOIAsyn();
    }

    public interface PoiAddreess{
        void getPoiAddreess(List<PositioningSuccessful> poiItems);
    }
}
