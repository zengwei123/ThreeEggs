package com.example.z_circle.Comments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;
import com.example.z_circle.R;

@Route(path = "/Circle/CommentsFragment")
public class CommentsFragment extends MvpFragment<CommentsPresenter> implements CommentsView{
    private ImageView Comment_Close;  //关闭按钮
    private ImageView Comment_Sorting;   //排序
    private TextView Comment_Sum;   //评论数
    private RecyclerView Comment_Recycler;  //评列表

    private EditText Comments_EditText;  //评论框
    private TextView Comments_TextBut;  //评论发布按钮
    private TextView Comment_UserName; //评论的用户
    private ImageView Comment_UserName_Close;//  关闭回复
    private RelativeLayout Comment_UserName_layout; //回复用户评论布局

    @Autowired
    public String roundId;
    @Autowired
    public String comment_id;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);
        return inflater.inflate(R.layout.comments_fragment,null,false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter.attachView(this);
        getViews(view);
        mvpPresenter.init();
    }

    @Override
    public Context getActivityContext() {
        return activity;
    }

    @Override
    public Activity getThisActivity() {
        return activity;
    }

    @Override
    protected CommentsPresenter createPresenter() {
        return new CommentsPresenter();
    }

    @Override
    public void getViews(View view) {
        Comment_Close=view.findViewById(R.id.Comment_Close);
        Comment_Sorting=view.findViewById(R.id.Comment_Sorting);
        Comment_Sum=view.findViewById(R.id.Comment_Sum);
        Comment_Recycler=view.findViewById(R.id.Comment_Recycler);
        Comments_EditText=view.findViewById(R.id.Comments_EditText);
        Comments_TextBut=view.findViewById(R.id.Comments_TextBut);
        Comment_UserName=view.findViewById(R.id.Comment_UserName);
        Comment_UserName_Close=view.findViewById(R.id.Comment_UserName_Close);
        Comment_UserName_layout=view.findViewById(R.id.Comment_UserName_layout);
    }

    @Override
    public ImageView getComment_Close() {
        return Comment_Close;
    }

    @Override
    public ImageView getComment_Sorting() {
        return Comment_Sorting;
    }

    @Override
    public TextView getComment_Sum() {
        return Comment_Sum;
    }

    @Override
    public RecyclerView getComment_Recycler() {
        return Comment_Recycler;
    }

    @Override
    public EditText getComments_EditText() {
        return Comments_EditText;
    }

    @Override
    public TextView getComments_TextBut() {
        return Comments_TextBut;
    }

    @Override
    public TextView getComment_UserName() {
        return Comment_UserName;
    }

    @Override
    public ImageView geteComment_UserName_Close() {
        return Comment_UserName_Close;
    }

    @Override
    public RelativeLayout getComment_UserName_layout() {
        return Comment_UserName_layout;
    }

    @Override
    public String getRoundId() {
        return roundId;
    }

    @Override
    public String getComment_id() {
        return comment_id;
    }

}
