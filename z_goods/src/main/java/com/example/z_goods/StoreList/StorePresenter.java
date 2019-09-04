package com.example.z_goods.StoreList;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.z_base.BasePresenter;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapterCallback;
import com.example.z_goods.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zengwei on 2019/9/4.
 */

public class StorePresenter extends BasePresenter<StoreView> {
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        setRecycler();
    }
    private void setRecycler(){
        List<String> strings= Arrays.asList("","","","");
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.store_recycler_item, mvpView.getActivityContext(), strings, (SimpleRecyclerViewAdapterCallback) (helper, item) -> {

        });
        mvpView.getStore_Recycler().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getStore_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
    }
}
