package com.example.z_home.Category;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.MvpActivity;
import com.example.z_home.R;

/**
 * 分类页面
 */
@Route(path = "/Home/Category")
public class CategoryActivity extends MvpActivity<CategoryPresenter> implements CategoryView {
    private TextView Include_Title_Text;   //页面头文字
    private ImageView Include_Title_Close;  //头部关闭按钮

    private RecyclerView Category_Parent;  //父分类
    private RecyclerView Category_Child;   //子分类

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**启动页的图片设置为空**/
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_layout);
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
    protected CategoryPresenter createPresenter() {
        return new CategoryPresenter();
    }

    @Override
    public void getViews() {
        Include_Title_Text=findViewById(R.id.Include_Title_Text);
        Include_Title_Close=findViewById(R.id.Include_Title_Close);

        Category_Parent=findViewById(R.id.Category_Parent);
        Category_Child=findViewById(R.id.Category_Child);
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
    public RecyclerView getCategory_Parent() {
        return Category_Parent;
    }

    @Override
    public RecyclerView getCategory_Child() {
        return Category_Child;
    }
}
