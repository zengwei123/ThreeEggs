package com.example.z_circle.Comments;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.z_base.BaseView;
import com.example.z_circle.R;

public interface CommentsView extends BaseView {
    RelativeLayout getComments_Fragment_id();
    ImageView getComment_Close();
    ImageView getComment_Sorting();
    TextView getComment_Sum();
    RecyclerView getComment_Recycler();
    EditText getComments_EditText();
    TextView getComments_TextBut();
    TextView getComment_UserName();
    ImageView geteComment_UserName_Close();
    RelativeLayout getComment_UserName_layout();
    SwipeRefreshLayout getComment_SwipeRefreshLayout();


    String getRoundId();
    String getComment_id();

    void setThisView(CommentsFragment.ThisView thisView);
    CommentsFragment.ThisView getThisView();
}
