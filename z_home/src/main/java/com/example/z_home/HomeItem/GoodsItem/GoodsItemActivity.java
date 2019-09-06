package com.example.z_home.HomeItem.GoodsItem;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpActivity;
import com.example.z_home.R;

@Route(path = "/Home/GoodsItemActivity")
public class GoodsItemActivity extends MvpActivity<GoodsItemPresenter> implements GoodsItemView{
    private TextView Include_Title_Text;   //页面头文字
    private ImageView Include_Title_Close;  //头部关闭按钮
    private ImageView GoodsList_Search;
    private TabLayout GoodsList_TabLayout;
    @Autowired
    public String title;
    @Autowired
    public String classification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**启动页的图片设置为空**/
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goodsitem_layout);
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
    protected GoodsItemPresenter createPresenter() {
        return new GoodsItemPresenter();
    }

    @Override
    public void getViews() {
        Include_Title_Text=findViewById(R.id.Include_Title_Text);
        Include_Title_Close=findViewById(R.id.Include_Title_Close);
        GoodsList_Search=findViewById(R.id.GoodsList_Search);
        GoodsList_TabLayout=findViewById(R.id.GoodsList_TabLayout);
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
    public ImageView getGoodsList_Search() {
        return GoodsList_Search;
    }

    @Override
    public TabLayout getGoodsList_TabLayout() {
        return GoodsList_TabLayout;
    }

    @Override
    public String getTitlec() {
        return title;
    }

    @Override
    public String getclassification() {
        return classification;
    }
}
