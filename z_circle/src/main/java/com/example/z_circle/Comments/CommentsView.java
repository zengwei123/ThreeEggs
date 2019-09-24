package com.example.z_circle.Comments;

import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.z_base.BaseView;
import com.example.z_circle.R;

public interface CommentsView extends BaseView {
    ImageView getComment_Close();
    ImageView getComment_Sorting();
    TextView getComment_Sum();
    RecyclerView getComment_Recycler();
    EditText getComments_EditText();
    TextView getComments_TextBut();
    TextView getComment_UserName();
    ImageView geteComment_UserName_Close();
    RelativeLayout getComment_UserName_layout();


    String getRoundId();
    String getComment_id();
}
