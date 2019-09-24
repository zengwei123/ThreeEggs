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
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;
import com.example.z_circle.R;

public class CommentsFragment extends MvpFragment<CommentsPresenter> implements CommentsView{
    private ImageView Comment_Close;
    private ImageView Comment_Sorting;
    private TextView Comment_Sum;
    private RecyclerView Comment_Recycler;
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
}
