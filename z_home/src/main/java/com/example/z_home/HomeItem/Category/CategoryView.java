package com.example.z_home.HomeItem.Category;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseView;

interface CategoryView extends BaseView {
    TextView getInclude_Title_Text();
    ImageView getInclude_Title_Close();
    RecyclerView getCategory_Parent();
    RecyclerView getCategory_Child();
}
