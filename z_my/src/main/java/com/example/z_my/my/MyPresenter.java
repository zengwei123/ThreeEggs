package com.example.z_my.my;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.z_base.BasePresenter;
import com.example.z_common.SimpleFragmentAdapter;
import com.example.z_common.SimpleRecyclerViewAdapter;
import com.example.z_common.SimpleRecyclerViewAdapterCallback;
import com.example.z_common.SimpleUtils;
import com.example.z_my.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwei on 2019/7/28.
 */

class MyPresenter extends BasePresenter<MyView>{
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        List<String> strings=new ArrayList<>();
        strings.add("商品收藏");
        strings.add("浏览历史");
        strings.add("关注店铺");
        strings.add("我的砍价");
        strings.add("账号绑定");
        strings.add("收货地址");
        strings.add("设置");

        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.my_recycler_item,
                mvpView.getActivityContext(), strings, (helper, item) -> {
                    helper.setText(R.id.My_Recycler_TextView,(String)item);
                });

        mvpView.getMy_Recycler().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getMy_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,mvpView.getActivityContext(),0));
    }
}
