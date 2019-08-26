package com.example.z_home.Address;

import android.support.v7.widget.RecyclerView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseView;
import com.example.z_common.Custom.WanEditText;

public interface AddressView extends BaseView {
    TextView getInclude_Title_Text();
    ImageView getInclude_Title_Close();
    AutoCompleteTextView getAddress_Search();
    TextView getAddress_City_Text();
    RecyclerView getAddress_City_Recycler();
    RecyclerView getAddress_Near_Recycler();
    TextView getAddress_TextView_Message();
    RecyclerView getAddress_PoI_Recycler();
    TextView getAddress_TextView_dingwei();
}
