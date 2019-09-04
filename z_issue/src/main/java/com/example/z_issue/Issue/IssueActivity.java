package com.example.z_issue.Issue;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.MvpActivity;
import com.example.z_issue.R;
import com.tencent.tauth.Tencent;

/**
 * Created by zengwei on 2019/9/1.
 */

@Route(path = "/Issue/IssueActivity")
public class IssueActivity extends MvpActivity<IssuePresenter> implements IssueView {
    private ImageView Issue_Close;
    private RecyclerView Issue_Recycler;

    private TextView Issue_Goods_Text;
    private TextView Issue_Plate_Text;
    private TextView Issue_Positioning_Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.issue_layout);
        mvpPresenter.attachView(this);
        getViews();
        mvpPresenter.init();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public Activity getThisActivity() {
        return this;
    }

    @Override
    protected IssuePresenter createPresenter() {
        return new IssuePresenter();
    }

    @Override
    public void getViews() {
        Issue_Close=findViewById(R.id.Issue_Close);
        Issue_Recycler=findViewById(R.id.Issue_Recycler);

        Issue_Goods_Text=findViewById(R.id.Issue_Goods_Text);
        Issue_Plate_Text=findViewById(R.id.Issue_Plate_Text);
        Issue_Positioning_Text=findViewById(R.id.Issue_Positioning_Text);
    }

    @Override
    public ImageView getIssue_Close() {
        return Issue_Close;
    }

    @Override
    public RecyclerView getIssue_Recycler() {
        return Issue_Recycler;
    }

    @Override
    public TextView getIssue_Goods_Text() {
        return Issue_Goods_Text;
    }

    @Override
    public TextView getIssue_Plate_Text() {
        return Issue_Plate_Text;
    }

    @Override
    public TextView getIssue_Positioning_Text() {
        return Issue_Positioning_Text;
    }
}
