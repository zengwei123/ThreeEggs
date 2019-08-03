package com.example.z_common.Amap;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.example.z_base.BaseActivity;
import com.example.z_common.SimpleUtils;

import java.util.ArrayList;
import java.util.List;

/**附近地址的推荐**/
public class AmapPoiUtil {
    public static void getNearPoi(String keyWord, String cityCode, double latitude, double longitude, final PoiAddreess poiAddreess){
        PoiSearch.Query query=new PoiSearch.Query(keyWord, "", cityCode);
        query.setPageSize(15);// 设置每页最多返回多少条poiitem
        query.setPageNum(1);//设置查询页码
        PoiSearch poiSearch=new PoiSearch(BaseActivity.getInstance(), query);
        poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() {
            @Override
            public void onPoiSearched(PoiResult poiResult, int i) {
                List<String> strings=new ArrayList();
                SimpleUtils.setLog("开始---");
                if(poiResult!=null){
                    for (PoiItem poiItem:poiResult.getPois()){
                        strings.add(poiItem.toString());
                        SimpleUtils.setLog(poiItem.toString()+"---");
                    }
                    SimpleUtils.setLog("结束---"+strings.size());
                }
                SimpleUtils.setLog("最终结束---"+strings.size());
                poiAddreess.getPoiAddreess(strings);
            }
            @Override
            public void onPoiItemSearched(PoiItem poiItem, int i) { }
        });
        poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(latitude, longitude), 1000));//设置周边搜索的中心点以及半径
        poiSearch.searchPOIAsyn();
    }

    public interface PoiAddreess{
        void getPoiAddreess(List<String> poiItems);
    }
}
