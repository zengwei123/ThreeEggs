package com.example.z_circle.Comments;

import android.view.View;

import com.example.z_base.BasePresenter;
import com.example.z_circle.R;

public class CommentsPresenter extends BasePresenter<CommentsView> implements View.OnClickListener {
    @Override
    public void init() {

    }

    @Override
    public void setView() {

    }

    private void click(){
        mvpView.getComment_Close().setOnClickListener(this);
        mvpView.getComment_Sorting().setOnClickListener(this);
    }

    private void setCommentsRecycler(){
//        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter()
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.Comment_Close) {

        } else if (i == R.id.Comment_Sorting) {

        }
    }
}
