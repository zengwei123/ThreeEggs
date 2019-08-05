package com.example.z_home.Address;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.z_base.BasePresenter;
import com.example.z_common.Amap.AmapPoiUtil;
import com.example.z_common.Amap.AmapPositioningUtil;
import com.example.z_common.Custom.HotLayout;
import com.example.z_common.Model.CityList;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_home.R;

import java.util.ArrayList;
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
        positioning(true);
    }

    @Override
    public void setView() {
        mvpView.getInclude_Title_Text().setText("选择地址");
        mvpView.getInclude_Title_Close().setOnClickListener(view -> {
            mvpView.getThisActivity().finish();
        });
        setCityRecycle();
        /**定位按钮**/
        mvpView.getAddress_WanEditText_Message().setRightPicOnclickListener(editText -> {
            positioning(false);
        });
    }
    /**关闭请求**/
    @Override
    public void CloseRequest() {

    }
    /**城市选择**/
    private void setCityRecycle(){
        List<CityList> cityLists=SimpleUtils.getCitysList();
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.address_city_item, mvpView.getActivityContext(),cityLists, (helper, item) -> {
            if(helper.getAdapterPosition()==0){
                setCityRecyclerHotLayout(helper.getView(R.id.Address_City_item_HotLayout),((CityList)item).getName().split("#"));
                helper.getView(R.id.Address_City_item_HotLayout).setVisibility(View.VISIBLE);
                helper.getView(R.id.Address_City_item_Text).setVisibility(View.GONE);

            }else {
                helper.getView(R.id.Address_City_item_HotLayout).setVisibility(View.GONE);
                helper.getView(R.id.Address_City_item_Text).setVisibility(View.VISIBLE);
                helper.setText(R.id.Address_City_item_Text,((CityList)item).getName());
            }
        });
        mvpView.getAddress_City_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
        mvpView.getAddress_City_Recycler().setAdapter(simpleRecyclerViewAdapter);
        simpleRecyclerViewAdapter.setOnItemClickListener((adapter, view, position) -> {
            /**手动定位城市**/
            if (position!=0)
            mvpView.getAddress_City_Text().setText(cityLists.get(position).getName());
        });
        /**这个是设置字母的悬浮内容**/
        if (cityLists!=null){
            mvpView.getAddress_City_Recycler().addItemDecoration(new AddressItemDecoration(mvpView.getActivityContext(), position -> cityLists.get(position).getSname()));
        }
    }
    /**热门城市或省份的布局**/
    private void setCityRecyclerHotLayout(HotLayout hotLayout,String[] strings){
        //balalal
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 35, 20, 10);// 设置边距
        for (int i = 0; i < strings.length; i++) {
            final TextView textView = new TextView(mvpView.getActivityContext());
            textView.setTag(i);
            textView.setTextSize(15);
            textView.setText(strings[i]);
            textView.setPadding(24, 11, 24, 11);
            textView.setTextColor(Color.parseColor("#666666"));
            textView.setBackgroundResource(R.drawable.home_edittext_background);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setSingleLine(true);
            hotLayout.addView(textView, layoutParams);
            // 标签点击事件
            textView.setOnClickListener(v -> {
                MoveToPosition((LinearLayoutManager) mvpView.getAddress_City_Recycler().getLayoutManager(), (Integer) v.getTag());
                Toast.makeText(mvpView.getActivityContext(), "点击事件", Toast.LENGTH_SHORT).show();
            });
        }
    }

    public static void MoveToPosition(LinearLayoutManager manager, int n) {
        manager.scrollToPositionWithOffset(SimpleUtils.caitsints[n], 0);
        manager.setStackFromEnd(true);
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

    /**点击事件**/
    private void setClick(){
        mvpView.getAddress_City_Text().setOnClickListener(this);
        mvpView.getAddress_City_Look().setOnClickListener(this);

    }
    /**定位功能  点击定位**/
    private void positioning(boolean b){
        /**定位功能  如果已经定位成功  就直接用**/
        if (AmapPositioningUtil.isIsPosition()&&b){
            String str=AmapPositioningUtil.getOKMapLocation().getAddress();
            mvpView.getAddress_WanEditText_Message().setText(str);
            if(!str.equals("定位失败")){
                getNearAddress();
                /**当前定位的城市**/
                mvpView.getAddress_City_Text().setText(AmapPositioningUtil.getOKMapLocation().getCity());
            }else {
                setNearRecycler(NearList);
            }
        }else {
            /**没有定位成功就定位一次**/
            mvpView.getAddress_WanEditText_Message().setText("定位中...");
            AmapPositioningUtil.getAmapPositioningUtil().StartPositioning(aMapLocation -> {
                String str=AmapPositioningUtil.ParsingAMapLocation(aMapLocation);
                mvpView.getAddress_WanEditText_Message().setText(str);
                SimpleUtils.setToast("定位结束");
                if(!str.equals("定位失败")){
                    getNearAddress();
                    /**当前定位的城市**/
                    mvpView.getAddress_City_Text().setText(AmapPositioningUtil.getOKMapLocation().getCity());
                }else {
                    setNearRecycler(NearList);
                }
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
            if (NearList.size()!=0) {
                mvpView.getAddress_Near_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(!GLNear, 3));
                if (GLNear) {
                    GLNear = false;
                    /**附近的地址小于5个数字的时候就显示全部 否则最多5个**/
                    if (NearList.size() < 5) {
                        isNearNumber = NearList.size();
                    } else {
                        isNearNumber = 5;
                    }
                } else {
                    /**列表状态下显示全部附近地址**/
                    GLNear = true;
                    isNearNumber = NearList.size();
                }
                mvpView.getAddress_Near_Recycler().getAdapter().notifyDataSetChanged();
            }else {
                SimpleUtils.setLog("未定位，无附近位置！");
            }
        }
    }
}
