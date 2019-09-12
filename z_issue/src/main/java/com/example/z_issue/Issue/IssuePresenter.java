package com.example.z_issue.Issue;

import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.z_base.BasePresenter;
import com.example.z_common.Util.GlideUtil;
import com.example.z_common.Util.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_issue.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zengwei on 2019/9/1.
 */

public class IssuePresenter extends BasePresenter<IssueView>{
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        mvpView.getIssue_Close().setOnClickListener(v -> mvpView.getThisActivity().finish());
        setRcycler();

        SimpleUtils.setViewTypeface(mvpView.getIssue_Goods_Text(),"\uebcb 添加地点");
        SimpleUtils.setViewTypeface(mvpView.getIssue_Plate_Text(),"\ue54e 添加地点");
        SimpleUtils.setViewTypeface(mvpView.getIssue_Positioning_Text(),"\uec74 添加地点");
    }

    private void setRcycler(){
        List<Integer> integers= Arrays.asList(R.mipmap.a1,R.mipmap.a2,R.mipmap.xiangji);
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.issue_recycler_item, mvpView.getActivityContext(), integers, (helper, item) -> {
            if (((int)item)==R.mipmap.xiangji){
                GlideUtil.displayImage(mvpView.getThisActivity(),item,helper.getView(R.id.Issue_Recycler_Item_Image));
                helper.getView(R.id.Issue_Recycler_Item_Layout).setBackgroundResource(R.drawable.issue_addimage_style1);
            }else {
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                GlideUtil.displayImage(mvpView.getThisActivity(),item,helper.getView(R.id.Issue_Recycler_Item_Image));
                helper.getView(R.id.Issue_Recycler_Item_Image).setLayoutParams(layoutParams);
                helper.getView(R.id.Issue_Recycler_Item_Layout).setBackgroundResource(R.drawable.issue_addimage_style);
            }
        });

        mvpView.getIssue_Recycler().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getIssue_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,3));
    }
}
