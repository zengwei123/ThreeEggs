package com.example.z_home.Address;

import android.view.View;

import com.example.z_base.BasePresenter;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.SimpleUtils;
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
    }

    @Override
    public void setView() {
        setCityRecycle(Arrays.asList("A北京","B南京","C东京","D西京","E湖北","F湖南","G湖东","H湖西","I山北","J山南","K山东","M山西"));
        setNearRecycler(Arrays.asList("新开的一家烧烤店","新开的一家烧烤店","新开的一家烧烤店","新开的一家烧烤店","新开的一家烧烤店","新开的一家烧烤店","新开的一家烧烤店","新开的一家烧烤店","新开的一家烧烤店","新开的一家烧烤店","新开的一家烧烤店","新开的一家烧烤店"));
    }
    /**城市选择**/
    private void setCityRecycle(List<String> CityList){
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.address_city_item, mvpView.getActivityContext(),CityList, (helper, item) -> {
            helper.setText(R.id.Address_City_item_Text,item.toString().substring(1));
        });
        mvpView.getAddress_City_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,mvpView.getActivityContext(),0));
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
        mvpView.getAddress_Near_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,mvpView.getActivityContext(),3));
        mvpView.getAddress_Near_Recycler().setAdapter(simpleRecyclerViewAdapter);
    }

    private void setClick(){
        mvpView.getAddress_City_Text().setOnClickListener(this);
        mvpView.getAddress_City_Look().setOnClickListener(this);

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
            mvpView.getAddress_Near_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(!GLNear,mvpView.getActivityContext(),3));
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
