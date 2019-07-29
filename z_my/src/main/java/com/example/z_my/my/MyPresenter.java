package com.example.z_my.my;

import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.BasePresenter;
import com.example.z_common.SimpleRecyclerViewAdapter;
import com.example.z_common.SimpleUtils;
import com.example.z_my.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwei on 2019/7/28.
 */

class MyPresenter extends BasePresenter<MyView> implements View.OnClickListener {
    @Override
    public void init() {
        setView();
        setClick();
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
        strings.add("关于");

        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.my_recycler_item,
                mvpView.getActivityContext(), strings, (helper, item) -> {
                    helper.setText(R.id.My_Recycler_TextView,(String)item);
                });

        mvpView.getMy_Recycler().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getMy_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,mvpView.getActivityContext(),0));


    }

    private void setClick(){
        mvpView.getMy_OrderAll_Linear().setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.My_OrderAll_Linear) {
            ARouter.getInstance().build("/Order/OrderList").navigation();
        }
    }
}
