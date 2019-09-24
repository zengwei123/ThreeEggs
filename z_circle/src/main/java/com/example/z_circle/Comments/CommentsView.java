package com.example.z_circle.Comments;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseView;

public interface CommentsView extends BaseView {
    ImageView getComment_Close();
    ImageView getComment_Sorting();
    TextView getComment_Sum();
    RecyclerView getComment_Recycler();
}
