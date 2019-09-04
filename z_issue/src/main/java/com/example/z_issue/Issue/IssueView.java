package com.example.z_issue.Issue;

/**
 * Created by zengwei on 2019/9/1.
 */

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseView;

public interface IssueView extends BaseView {
    ImageView getIssue_Close();
    RecyclerView getIssue_Recycler();
    TextView getIssue_Goods_Text();
    TextView getIssue_Plate_Text();
    TextView getIssue_Positioning_Text();
}
