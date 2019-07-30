package com.example.z_home.Address;

import android.view.View;

import com.example.z_base.BasePresenter;
import com.example.z_common.SimpleUtils;
import com.example.z_home.R;

public class AddressPresenter extends BasePresenter<AddressView> implements View.OnClickListener {
    @Override
    public void init() {
        setView();
        setClick();
    }

    @Override
    public void setView() {

    }

    private void setClick(){
        mvpView.getAddress_City().setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.Address_City) {
          
        }
    }
}
