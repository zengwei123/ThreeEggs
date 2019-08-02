package com.example.z_home.Address;

import android.view.View;

import com.example.z_base.BasePresenter;
import com.example.z_common.Amap.AmapPoiUtil;
import com.example.z_common.Amap.AmapPositioningUtil;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_home.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressPresenter extends BasePresenter<AddressView> implements View.OnClickListener {
    private int isNearNumber=5;    //附近地址部分显示的默认数量
    private boolean GLNear=false;   //控制附近的地址的全部还是部分显示
    List<String> NearList=new ArrayList<>();   //附近地址数据
    List<String> CityList=new ArrayList<>();   //城市列表数据
    @Override
    public void init() {
        setView();
        setClick();
        positioning();
    }

    @Override
    public void setView() {
        setCityRecycle(Arrays.asList("A北京","B南京","C东京","D西京","E湖北","F湖南","G湖东","H湖西","I山北","J山南","K山东","M山西"));
        mvpView.getAddress_WanEditText_Message().setRightPicOnclickListener(editText -> {
            positioning();
        });

    }
    /**城市选择**/
    private void setCityRecycle(List<String> CityList){
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.address_city_item, mvpView.getActivityContext(),CityList, (helper, item) -> {
            helper.setText(R.id.Address_City_item_Text,item.toString().substring(1));
        });
        mvpView.getAddress_City_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
        mvpView.getAddress_City_Recycler().setAdapter(simpleRecyclerViewAdapter);
        /**这个是设置字母的悬浮内容**/
        if (CityList!=null){
            if(CityList.size()!=0){
                mvpView.getAddress_City_Recycler().addItemDecoration(new AddressItemDecoration(mvpView.getActivityContext(), position -> CityList.get(position).substring(0,1)));
            }
        }
    }

    /**附近地址**/
    private void setNearRecycler(List<String> NearList){
        this.NearList=NearList;
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.address_city_item, mvpView.getActivityContext(),NearList, (helper, item) -> {
            if (helper.getAdapterPosition()<isNearNumber){
                helper.setText(R.id.Address_City_item_Text,item.toString().substring(1));
            }
        });
        mvpView.getAddress_Near_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,3));
        mvpView.getAddress_Near_Recycler().setAdapter(simpleRecyclerViewAdapter);
    }
    /**获取附近的推荐地址**/
    private void getNearAddress(){
        AmapPoiUtil.getNearPoi(AmapPositioningUtil.getOKMapLocation().getPoiName(),
                AmapPositioningUtil.getOKMapLocation().getCity(),
                AmapPositioningUtil.getOKMapLocation().getLatitude(),
                AmapPositioningUtil.getOKMapLocation().getLongitude(),
                poiItems -> setNearRecycler(poiItems)
        );
    }


    private void setClick(){
        mvpView.getAddress_City_Text().setOnClickListener(this);
        mvpView.getAddress_City_Look().setOnClickListener(this);

    }
    /**定位功能  点击定位**/
    private void positioning(){
        /**定位功能  如果已经定位成功  就直接用**/
        if (AmapPositioningUtil.isIsPosition()){
            mvpView.getAddress_WanEditText_Message().setText(AmapPositioningUtil.getOKMapLocation().getAddress());
            getNearAddress();
        }else {
            /**没有定位成功就定位一次**/
            mvpView.getAddress_WanEditText_Message().setText("定位中...");
            AmapPositioningUtil.getAmapPositioningUtil().StartPositioning(aMapLocation -> {
                String str=AmapPositioningUtil.ParsingAMapLocation(aMapLocation);
                AmapPositioningUtil.setIsPosition(true);   //临时保存定位信息
                mvpView.getAddress_WanEditText_Message().setText(str);
                SimpleUtils.setToast("定位结束");
                getNearAddress();
            });
        }
    }
    @Override
    public void onClick(View view) {
        int i = view.getId();
        /**展开城市列表**/
        if (i == R.id.Address_City_Text) {
            mvpView.getAddress_City_Recycler().setVisibility(View.VISIBLE);
        }
        /**控制更多附近的显示的显示**/
        else if(i==R.id.Address_City_Look){
            /**表格还是列表  表格的时候是部分  列表的时候是全部  第一次加载的时候就全部加载出来**/
            mvpView.getAddress_Near_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(!GLNear,3));
            if (GLNear){
                GLNear=false;
                /**附近的地址小于5个数字的时候就显示全部 否则最多5个**/
                if(NearList.size()<5){
                    isNearNumber=NearList.size();
                }else {
                    isNearNumber=5;
                }
            }else {
                /**列表状态下显示全部附近地址**/
                GLNear=true;
                isNearNumber=NearList.size();
            }
            mvpView.getAddress_Near_Recycler().getAdapter().notifyDataSetChanged();
        }
    }
}
