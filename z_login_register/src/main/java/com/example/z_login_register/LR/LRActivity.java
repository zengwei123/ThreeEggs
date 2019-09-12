package com.example.z_login_register.LR;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.MvpActivity;
import com.example.z_common.Custom.NoScrollViewPager;
import com.example.z_common.Util.SimpleUtils;
import com.example.z_login_register.LR.ViewPage.LRViewPageFragment_C;
import com.example.z_login_register.LR.ViewPage.LRViewPageFragment_p;
import com.example.z_login_register.QQUiListener;
import com.example.z_login_register.R;
import com.tencent.tauth.Tencent;

/**
 * Created by zengwei on 2019/8/11.
 */
@Route(path = "/LR/LRActivity")
public class LRActivity extends MvpActivity<LRPresenter> implements LRView{
    private ImageView LR_Close;  //头部关闭按钮
    private NoScrollViewPager LR_ViewPage;
    private Tencent tencent;

    private String qqOpenId="";   //qq登录的openid
    private String weixinOpenId="";   //微信登录的openid
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lr_layout);
        mvpPresenter.attachView(this);
        getViews();
        mvpPresenter.init();
        tencent = Tencent.createInstance("101770446", this);
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
    protected LRPresenter createPresenter() {
        return new LRPresenter();
    }

    @Override
    public void getViews() {
        LR_ViewPage=findViewById(R.id.LR_ViewPage);
        LR_Close=findViewById(R.id.LR_Close);
    }

    @Override
    public ImageView getLR_Close() {
        return LR_Close;
    }

    @Override
    public NoScrollViewPager getNoScrollViewPager() {
        return LR_ViewPage;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        tencent.onActivityResultData(requestCode,resultCode,data,new QQUiListener(new QQUiListener.QQListener() {
            @Override
            public void onComplete(String openid) {}
            @Override
            public void onError() {}
        }));
        try{
            qqOpenId= ((LRViewPageFragment_p)mvpPresenter.getFragments().get(0)).getQqOpenid();
            ((LRViewPageFragment_C)mvpPresenter.getFragments().get(1)).setQqOpenId(qqOpenId);
            SimpleUtils.setToast(qqOpenId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
