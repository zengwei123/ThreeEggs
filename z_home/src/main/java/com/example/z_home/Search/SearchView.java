package com.example.z_home.Search;

import android.widget.EditText;
import android.widget.TextView;

import com.example.z_base.BaseView;
import com.example.z_common.Custom.HotLayout;

/**
 * Created by zengwei on 2019/8/1.
 */

interface SearchView extends BaseView{
    HotLayout getSearch_HotLayout();
    TextView getSearch_Search();
    TextView getSearch_Back();
    TextView getSearch_Delete();
    EditText getSearch_Edit();
}
