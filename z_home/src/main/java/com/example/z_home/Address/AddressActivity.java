package com.example.z_home.Address;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.MvpActivity;
import com.example.z_common.Custom.WanEditText;
import com.example.z_home.R;

/**
 * 选择地址界面
 */
@Route(path = "/Home/Address")
public class AddressActivity extends MvpActivity<AddressPresenter> implements AddressView {
    private TextView Include_Title_Text;   //页面头文字
    private ImageView Include_Title_Close;  //头部关闭按钮
    private AutoCompleteTextView Address_Search;
    private TextView Address_City_Text;   //城市选择按钮
    private RecyclerView Address_City_Recycler;    //城市列表
    private TextView Address_City_Look;  //查看更多附近
    private RecyclerView Address_Near_Recycler;   //附近地址列表
    private WanEditText Address_WanEditText_Message;  //当前定位的位置
    private RecyclerView Address_PoI_Recycler;   //搜索附近的poi


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
        Address_Search=findViewById(R.id.Address_Search);
        Address_City_Text=findViewById(R.id.Address_City_Text);
        Address_City_Recycler=findViewById(R.id.Address_City_Recycler);
        Address_City_Look=findViewById(R.id.Address_City_Look);
        Address_Near_Recycler=findViewById(R.id.Address_Near_Recycler);
        Address_WanEditText_Message=findViewById(R.id.Address_WanEditText_Message);
        Address_PoI_Recycler=findViewById(R.id.Address_PoI_Recycler);
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
    public AutoCompleteTextView getAddress_Search() {
        return Address_Search;
    }

    @Override
    public TextView getAddress_City_Text() {
        return Address_City_Text;
    }

    @Override
    public RecyclerView getAddress_Near_Recycler() {
        return Address_Near_Recycler;
    }

    @Override
    public WanEditText getAddress_WanEditText_Message() {
        return Address_WanEditText_Message;
    }

    @Override
    public RecyclerView getAddress_PoI_Recycler() {
        return Address_PoI_Recycler;
    }

    @Override
    public RecyclerView getAddress_City_Recycler() {
        return Address_City_Recycler;
    }

    @Override
    public TextView getAddress_City_Look() {
        return Address_City_Look;
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public Activity getThisActivity() {
        return this;
    }

    @Override
    public void onBackPressed() {
        if (getAddress_City_Recycler().getVisibility()!= View.GONE||getAddress_PoI_Recycler().getVisibility()!= View.GONE){
            getAddress_City_Recycler().setVisibility(View.GONE);
            getAddress_PoI_Recycler().setVisibility(View.GONE);
        }else {
            super.onBackPressed();
        }
    }
}
