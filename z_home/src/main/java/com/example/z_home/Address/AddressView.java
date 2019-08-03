package com.example.z_home.Address;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseView;
import com.example.z_common.Custom.WanEditText;

public interface AddressView extends BaseView {
    TextView getInclude_Title_Text();
    ImageView getInclude_Title_Close();
    TextView getAddress_City_Text();
    RecyclerView getAddress_City_Recycler();
    TextView getAddress_City_Look();
    RecyclerView getAddress_Near_Recycler();
    WanEditText getAddress_WanEditText_Message();
}
