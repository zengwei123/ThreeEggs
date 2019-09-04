package com.example.z_message.MessagePage;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.z_base.BasePresenter;
import com.example.z_common.GlideUtil;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapterCallback;
import com.example.z_message.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zengwei on 2019/9/1.
 */

public class MessagePagePresenter extends BasePresenter<MessagePageView>{

    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        setRecycler();
    }

    private void setRecycler(){
        List<String> strings= Arrays.asList("小头爸爸","围裙妈妈","大耳朵图图","美羊羊");
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.messagepage_recycler_item, mvpView.getActivityContext(), strings, (SimpleRecyclerViewAdapterCallback) (helper, item) -> {
            helper.setText(R.id.MessagePage_UserName,((String)item));
            GlideUtil.roundImage(mvpView.getThisActivity(),R.mipmap.common_nodata,helper.getView(R.id.MessagePage_UserHead));
        });
        mvpView.getMessagePage_Recycler().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getMessagePage_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
    }

}
