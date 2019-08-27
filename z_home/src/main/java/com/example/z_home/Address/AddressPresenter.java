package com.example.z_home.Address;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.example.z_base.BasePresenter;
import com.example.z_common.Amap.AmapPoiUtil;
import com.example.z_common.Amap.AmapPositioningUtil;
import com.example.z_common.Model.CityList;
import com.example.z_common.Model.PositioningSuccessful;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_home.R;

import java.util.ArrayList;
import java.util.List;

public class AddressPresenter extends BasePresenter<AddressView> implements View.OnClickListener {
    private boolean GLNear=false;   //控制附近的地址的全部还是部分显示
    List<PositioningSuccessful> NearList=new ArrayList<>();   //附近地址数据
    List<String> CityList=new ArrayList<>();   //城市列表数据
    private int selectCityIndex=0;
    private List<Tip> tips=new ArrayList<>();  //Poi数据列表
    @Override
    public void init() {
        setView();
        setClick();
        positioning(true);

        mvpView.getAddress_Search().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                SimpleUtils.setLog(s.toString());
                SearchPoi(s.toString(),mvpView.getAddress_City_Text().getText().toString());
            }
        });
    }

    @Override
    public void setView() {
        mvpView.getInclude_Title_Text().setText("选择定位");
        mvpView.getInclude_Title_Close().setOnClickListener(view -> {
            mvpView.getThisActivity().finish();
        });
        setCityRecycle();
        setRecyclerPoi();
    }
    /**关闭请求**/
    @Override
    public void CloseRequest() {

    }
    /**城市选择**/
    private void setCityRecycle(){
        List<CityList> cityLists=SimpleUtils.getCitysList();
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.address_city_item, mvpView.getActivityContext(),cityLists, (helper, item) -> {
            /**这里市设置热门城市 因为只要执行一次**/
            if(helper.getAdapterPosition()==0){
                List<CityList> cityLists1=new ArrayList<>();
                for (int i=0;i<8;i++){
                    cityLists1.add(cityLists.get(i));
                }
                /**热门城市的布局**/
                SimpleRecyclerViewAdapter simpleRecyclerViewAdapter1=new SimpleRecyclerViewAdapter(R.layout.address_city_hot_item, mvpView.getActivityContext(), cityLists1, (helper1, item1) -> {
                    helper1.setText(R.id.Address_City_item_Text,((CityList)item1).getName());
                });
                ((RecyclerView)helper.getView(R.id.Address_City_item_RecyclerView)).setAdapter(simpleRecyclerViewAdapter1);
                ((RecyclerView)helper.getView(R.id.Address_City_item_RecyclerView)).setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,4));
                helper.getView(R.id.Address_City_item_RecyclerView).setVisibility(View.VISIBLE);
                helper.getView(R.id.Address_City_item_Text).setVisibility(View.GONE);
                /**选择事件**/
                simpleRecyclerViewAdapter1.setOnItemClickListener((adapter, view, position) -> {
                    /**手动定位城市**/
                    selectCityIndex=position;
                    mvpView.getAddress_City_Text().setText(cityLists.get(position).getName());

                    AmapPositioningUtil.setIsPosition(3);
                    AmapPositioningUtil.setPositioningSuccessful(new PositioningSuccessful(cityLists.get(position).getName(),
                            cityLists.get(position).getCode()+"",
                            "",0,0,null));
                    mvpView.getAddress_City_Recycler().setVisibility(View.GONE);
                });

            }else if(helper.getAdapterPosition()>7){ /**普通的城市**/
                helper.getView(R.id.Address_City_item_RecyclerView).setVisibility(View.GONE);
                helper.getView(R.id.Address_City_item_Text).setVisibility(View.VISIBLE);
                helper.setText(R.id.Address_City_item_Text,((CityList)item).getName());
            }else {  /**前8个数据市热门城市的  因为只要执行一次就可以了所以隐藏**/
                helper.getView(R.id.Address_City_item_RecyclerView).setVisibility(View.GONE);
                helper.getView(R.id.Address_City_item_Text).setVisibility(View.GONE);
            }
        });
        mvpView.getAddress_City_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
        mvpView.getAddress_City_Recycler().setAdapter(simpleRecyclerViewAdapter);
        simpleRecyclerViewAdapter.setOnItemClickListener((adapter, view, position) -> {
            /**手动定位城市**/
            selectCityIndex=position;
            mvpView.getAddress_City_Text().setText(cityLists.get(position).getName());

            AmapPositioningUtil.setIsPosition(3);
            AmapPositioningUtil.setPositioningSuccessful(new PositioningSuccessful(cityLists.get(position).getName(),
                    cityLists.get(position).getCode()+"",
                    "",0,0,null));
            mvpView.getAddress_City_Recycler().setVisibility(View.GONE);
        });
        /**这个是设置字母的悬浮内容**/
        if (cityLists!=null){
            mvpView.getAddress_City_Recycler().addItemDecoration(new AddressItemDecoration(mvpView.getActivityContext(), position -> cityLists.get(position).getSname()));
        }
    }


    /**附近地址**/
    private void setNearRecycler(List<PositioningSuccessful> NearList){
        this.NearList=NearList;
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.address_city_item, mvpView.getActivityContext(),NearList, (helper, item) -> {
            helper.setText(R.id.Address_City_item_Text,((PositioningSuccessful)item).getAddress());
            helper.getView(R.id.Address_City_item_Text).setOnClickListener(v->{
                SimpleUtils.setToast(((PositioningSuccessful)item).getAddress());
                mvpView.getAddress_TextView_Message().setText(((PositioningSuccessful)item).getAddress());
                AmapPositioningUtil.setPositioningSuccessful((PositioningSuccessful)item);
                mvpView.getThisActivity().finish();
            });
        });
        mvpView.getAddress_Near_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
        mvpView.getAddress_Near_Recycler().setAdapter(simpleRecyclerViewAdapter);
    }
    /**获取附近的推荐地址**/
    private void getNearAddress(){
        AmapPoiUtil.getNearPoi(AmapPositioningUtil.getPositioningSuccessful().getPoiName(),
                AmapPositioningUtil.getPositioningSuccessful().getCity(),
                AmapPositioningUtil.getPositioningSuccessful().getLatitude(),
                AmapPositioningUtil.getPositioningSuccessful().getLongitude(),
                poiItems -> setNearRecycler(poiItems)
        );
    }

    /**点击事件**/
    private void setClick(){
        mvpView.getAddress_City_Text().setOnClickListener(this);
        mvpView.getAddress_TextView_dingwei().setOnClickListener(this);
    }

    /**
     * 下面这一个是系统定位功能
     * 如果已经定位成功直接就用已经定位的
     * 如果没有使用系统定位定位
     */
    /**定位功能  点击定位**/
    private void positioning(boolean b){
        /**定位功能  如果已经定位成功  就直接用**/
        if (AmapPositioningUtil.getIsPosition()!=-1&&b){
            String str=AmapPositioningUtil.getPositioningSuccessful().getAddress();
            mvpView.getAddress_TextView_Message().setText(str);
            if(!str.equals("定位失败")){
                getNearAddress();
                /**当前定位的城市**/
                mvpView.getAddress_City_Text().setText(AmapPositioningUtil.getPositioningSuccessful().getCity());
            }else {
                setNearRecycler(NearList);
            }
        }else {
            /**没有定位成功就定位一次**/
            mvpView.getAddress_TextView_Message().setText("定位中...");
            AmapPositioningUtil.getAmapPositioningUtil().StartPositioning(aMapLocation -> {
                String str=AmapPositioningUtil.ParsingAMapLocation(aMapLocation);
                mvpView.getAddress_TextView_Message().setText(str);
                if(!str.equals("定位失败")){
                    getNearAddress();
                    /**当前定位的城市**/
                    mvpView.getAddress_City_Text().setText(AmapPositioningUtil.getPositioningSuccessful().getCity());
                }else {
                    setNearRecycler(NearList);
                }
            });
        }
    }



    /**
     * 下面两个是当手动选择定位的时候
     * 会将手动选择的的地址保存起来
     */
    /**搜索地址**/
   private void setRecyclerPoi(){
       SimpleRecyclerViewAdapter simpleFragmentAdapter=new SimpleRecyclerViewAdapter(R.layout.address_city_item, mvpView.getActivityContext(),tips, (helper, item) -> {
               Tip tip=(Tip)item;
               helper.setText(R.id.Address_City_item_Text,tip.getName()+"");
               helper.getView(R.id.Address_City_item_Text).setOnClickListener(v->{
                   /**保存手动定位的数据**/
                   List<CityList> cityLists=SimpleUtils.getCitysList();
                   if (AmapPositioningUtil.getIsPosition()==0){
                       /**如果定位成功**/
                       AmapPositioningUtil.getPositioningSuccessful().setCityCode( tip.getAdcode());
                       AmapPositioningUtil.getPositioningSuccessful().setAddress( tip.getName());
                       AmapPositioningUtil.getPositioningSuccessful().setLongitude( tip.getPoint().getLongitude());
                       AmapPositioningUtil.getPositioningSuccessful().setLatitude( tip.getPoint().getLatitude());
                   }else {
                       try{
                           PositioningSuccessful positioningSuccessful=new PositioningSuccessful(cityLists.get(selectCityIndex).getName(),
                                   tip.getAdcode(),
                                   tip.getName(),
                                   tip.getPoint().getLongitude(),
                                   tip.getPoint().getLatitude(),
                                   null
                           );
                           AmapPositioningUtil.setPositioningSuccessful(positioningSuccessful);
                       }catch (Exception e){
                           e.printStackTrace();
                       }
                   }
                   AmapPositioningUtil.setIsPosition(2);
                   mvpView.getThisActivity().finish();
               });
       });
       mvpView.getAddress_PoI_Recycler().setAdapter(simpleFragmentAdapter);
       mvpView.getAddress_PoI_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
   }
    /**获得搜索的poi**/
    private void SearchPoi(String query,String city){
        SimpleUtils.setLog(city);
        InputtipsQuery inputquery = new InputtipsQuery(query, city);
        inputquery.setCityLimit(true);
        Inputtips inputTips = new Inputtips(mvpView.getActivityContext(), inputquery);
        inputTips.setInputtipsListener((list, i) -> {
            tips.clear();
            for (Tip tip:list){
                tips.add(tip);
                SimpleUtils.setLog(tip.toString());
            }
            mvpView.getAddress_PoI_Recycler().getAdapter().notifyDataSetChanged();
            mvpView.getAddress_PoI_Recycler().setVisibility(View.VISIBLE);
        });
        inputTips.requestInputtipsAsyn();
    }



    @Override
    public void onClick(View view) {
        int i = view.getId();
        /**展开城市列表**/
        if (i == R.id.Address_City_Text) {
            mvpView.getAddress_City_Recycler().setVisibility(View.VISIBLE);
        }
        /**重新定位**/
        else if(i==R.id.Address_TextView_dingwei){
            positioning(false);
        }
    }

}
