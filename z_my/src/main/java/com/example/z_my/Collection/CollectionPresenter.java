package com.example.z_my.Collection;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.z_base.BasePresenter;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapterCallback;
import com.example.z_my.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zengwei on 2019/8/11.
 */

public class CollectionPresenter extends BasePresenter<CollectionView>{
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        List<String> strings= Arrays.asList("标题123","标题1234","标题12345","标题123456","标题1234567");
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.collection_layout_item, mvpView.getActivityContext(), strings, (helper, item) -> {

        });
        mvpView.getCollection_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
        mvpView.getCollection_Recycler().setAdapter(simpleRecyclerViewAdapter);
    }

    @Override
    public void CloseRequest() {

    }
}
