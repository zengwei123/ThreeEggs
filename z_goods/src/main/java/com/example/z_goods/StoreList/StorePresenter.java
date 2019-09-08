package com.example.z_goods.StoreList;

import android.content.Context;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.z_base.BasePresenter;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapterCallback;
import com.example.z_goods.Model.StoreModel;
import com.example.z_goods.Net.GoodsRequestServiceFactory;
import com.example.z_goods.R;

import java.util.Arrays;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by zengwei on 2019/9/4.
 */

public class StorePresenter extends BasePresenter<StoreView> {
    private StoreModel storeModel;
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        setRecycler(mvpView.getActivityContext(),1);
    }
    private void setRecycler(Context context,int page){
        GoodsRequestServiceFactory.Boutique(new RequestObserver.RequestObserverNext<AllDataState<StoreModel>>() {
            @Override
            public void Next(AllDataState<StoreModel> o) {
                storeModel=o.getData();
                SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.store_recycler_item, mvpView.getActivityContext(),storeModel.getPage().getRecords(), (helper, item) -> {

                });
                mvpView.getStore_Recycler().setAdapter(simpleRecyclerViewAdapter);
                mvpView.getStore_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
            }

            @Override
            public void onError() {

            }

            @Override
            public void getDisposable(Disposable d) {

            }
        },context,page);



        List<String> strings= Arrays.asList("","","","");

    }
}
