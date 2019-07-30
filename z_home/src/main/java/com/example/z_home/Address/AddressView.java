package com.example.z_home.Address;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseView;

public interface AddressView extends BaseView {
    TextView getInclude_Title_Text();
    ImageView getInclude_Title_Close();
    TextView getAddress_City_Text();
    RecyclerView getAddress_City_Recycler();
}
