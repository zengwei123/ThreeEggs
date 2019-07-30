package com.example.z_home.Address;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.z_base.BasePresenter;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.SimpleRecyclerViewAdapter;
import com.example.z_common.SimpleRecyclerViewAdapter1;
import com.example.z_common.SimpleRecyclerViewAdapterCallback;
import com.example.z_common.SimpleUtils;
import com.example.z_home.R;

import java.util.ArrayList;
import java.util.List;

public class AddressPresenter extends BasePresenter<AddressView> implements View.OnClickListener {
    @Override
    public void init() {
        setView();
        setClick();
    }

    @Override
    public void setView() {
        List<AllDataState> allDataStates=new ArrayList<>();
        allDataStates.add(new AllDataState('A',0));
        allDataStates.add(new AllDataState("北京",1));
        allDataStates.add(new AllDataState("上海",1));
        allDataStates.add(new AllDataState("上海",1));
        allDataStates.add(new AllDataState("上海",1));
        allDataStates.add(new AllDataState("上海",1));
        allDataStates.add(new AllDataState('B',0));
        allDataStates.add(new AllDataState("长沙",1));
        allDataStates.add(new AllDataState("湘潭",1));
        allDataStates.add(new AllDataState("娄底",1));
        allDataStates.add(new AllDataState("益阳",1));
        allDataStates.add(new AllDataState("株洲",1));
        allDataStates.add(new AllDataState('C',0));
        allDataStates.add(new AllDataState("上海",1));
        allDataStates.add(new AllDataState("深圳",1));
        allDataStates.add(new AllDataState("广州",1));
        allDataStates.add(new AllDataState("海南",1));
        allDataStates.add(new AllDataState("北京",1));

        int[] ints={R.layout.address_city_item,R.layout.address_city_item};
        SimpleRecyclerViewAdapter1 simpleRecyclerViewAdapter1=new SimpleRecyclerViewAdapter1(ints, allDataStates, (helper, item) -> {
                helper.setText(R.id.Address_City_item_Text,((AllDataState)item).getData().toString());
        });
        mvpView.getAddress_City_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,mvpView.getActivityContext(),0));
        mvpView.getAddress_City_Recycler().setAdapter(simpleRecyclerViewAdapter1);
    }

    private void setClick(){
        mvpView.getAddress_City_Text().setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.Address_City_Text) {
            RoutePageActivity.grtAddress();
        }
    }
}
