package com.example.z_my.UserEditor;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseView;

/**
 * Created by zengwei on 2019/9/3.
 */

public interface UserEditorView extends BaseView{
     ImageView getInclude_Title_Close();
     TextView getInclude_Title_Text();
     RecyclerView getUserEditor_Recycler();
}
