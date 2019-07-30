package com.example.z_home.Address;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.MvpActivity;
import com.example.z_home.R;

/**
 * 选择地址界面
 */
public class AddressActivity extends MvpActivity<AddressPresenter> implements AddressView {
    private TextView Include_Title_Text;   //页面头文字
    private ImageView Include_Title_Close;  //头部关闭按钮

    private TextView Address_City;   //城市列表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**启动页的图片设置为空**/
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_layout);
        mvpPresenter.attachView(this);
        getViews();
        mvpPresenter.init();
    }

    @Override
    protected AddressPresenter createPresenter() {
        return new AddressPresenter();
    }

    @Override
    public void getViews() {
        Include_Title_Text=findViewById(R.id.Include_Title_Text);
        Include_Title_Close=findViewById(R.id.Include_Title_Close);
        Address_City=findViewById(R.id.Address_City);
    }

    @Override
    public TextView getInclude_Title_Text() {
        return Include_Title_Text;
    }

    @Override
    public ImageView getInclude_Title_Close() {
        return Include_Title_Close;
    }

    @Override
    public TextView getAddress_City() {
        return Address_City;
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public Activity getThisActivity() {
        return this;
    }
}
