package com.example.z_circle.Details;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.BasePresenter;
import com.example.z_base.MvpActivity;
import com.example.z_circle.R;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by zengwei on 2019/9/18.
 * 圈子详情
 */
@Route(path = "/Circle/DetailsActivity")
public class DetailsActivity extends MvpActivity<DetailsPresenter>implements DetailsView {
    private ImageView Details_Close;  //返回按钮
    private ImageView Details_Share;   //分享按钮
    private TextView Details_UserName;  //用户明
    private BGABanner Details_Banner;  //轮播图
    private TextView Details_Title; //文章标题
    private TextView Details_Content;  //内容
    private TextView Details_Address;//地址
    private TextView Details_Time;  //日期

    private RelativeLayout Details_Goods_Layout;  //推荐商品的布局
    private ImageView Details_Goods_Image; //分享商品的图片
    private TextView Details_Goods_Title; //标题
    private TextView Details_Goods_Price;//价格

    private TextView Details_Label;  //分类/标签

    @Autowired
    public String roundId;  //获取圈子的文章id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**启动页的图片设置为空**/
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        ARouter.getInstance().inject(this);
        mvpPresenter.attachView(this);
        getViews();
        mvpPresenter.init();
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
    protected DetailsPresenter createPresenter() {
        return new DetailsPresenter();
    }

    @Override
    public void getViews() {
        Details_Close=findViewById(R.id.Details_Close);
        Details_Share=findViewById(R.id.Details_Share);
        Details_UserName=findViewById(R.id.Details_UserName);
        Details_Banner=findViewById(R.id.Details_Banner);
        Details_Title=findViewById(R.id.Details_Title);
        Details_Content=findViewById(R.id.Details_Content);
        Details_Address=findViewById(R.id.Details_Address);
        Details_Time=findViewById(R.id.Details_Time);

        Details_Goods_Layout=findViewById(R.id.Details_Goods_Layout);
        Details_Goods_Image=findViewById(R.id.Details_Goods_Image);
        Details_Goods_Title=findViewById(R.id.Details_Goods_Title);
        Details_Goods_Price=findViewById(R.id.Details_Goods_Price);

        Details_Label=findViewById(R.id.Details_Label);
    }

    @Override
    public ImageView getDetails_Close() {
        return Details_Close;
    }

    @Override
    public ImageView getDetails_Share() {
        return Details_Share;
    }

    @Override
    public TextView getDetails_UserName() {
        return Details_UserName;
    }

    @Override
    public BGABanner getDetails_Banner() {
        return Details_Banner;
    }

    @Override
    public TextView getDetails_Title() {
        return Details_Title;
    }

    @Override
    public TextView getDetails_Content() {
        return Details_Content;
    }

    @Override
    public TextView getDetails_Address() {
        return Details_Address;
    }

    @Override
    public TextView getDetails_Time() {
        return Details_Time;
    }

    @Override
    public RelativeLayout getDetails_Goods_Layout() {
        return Details_Goods_Layout;
    }

    @Override
    public ImageView getDetails_Goods_Image() {
        return Details_Goods_Image;
    }

    @Override
    public TextView getDetails_Goods_Title() {
        return Details_Goods_Title;
    }

    @Override
    public TextView getDetails_Goods_Price() {
        return Details_Goods_Price;
    }

    @Override
    public TextView getDetails_Label() {
        return Details_Label;
    }

    @Override
    public String getRoundId() {
        return roundId;
    }
}
