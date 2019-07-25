package com.example.z_goods.GoodsList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;
import com.example.z_base.ViewBind;
import com.example.z_goods.R;

/**
 * Created by zengwei on 2019/7/24.
 */
@Route(path="/Goods/GoodsList")
public class GoodsListListFragment extends MvpFragment<GoodsListPresenter> implements GoodsListView {
    /**这里是推荐的商品**/
    private TextView GoodsList_Comprehensive;  //综合
    private TextView GoodsList_Sales;  //销量
    private TextView GoodsList_Price;  //价格
    private TextView GoodsList_Distance;  //距离
    private ImageView GoodsList_Style;  //排版样式
    private ImageView GoodsList_Screening;  //筛选
    private RecyclerView GoodsList_Recycler;  //推荐数据列表

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.goodslis_layout,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(activity.getApplication()); // 尽可能早，推荐在Application中初始化
        mvpPresenter.attachView(this);
        getViews(view);
        mvpPresenter.init();
    }

    private void getViews(View view){
        GoodsList_Comprehensive=view.findViewById(R.id.GoodsList_Comprehensive);
        GoodsList_Sales=view.findViewById(R.id.GoodsList_Sales);
        GoodsList_Price=view.findViewById(R.id.GoodsList_Price);
        GoodsList_Distance=view.findViewById(R.id.GoodsList_Distance);
        GoodsList_Style=view.findViewById(R.id.GoodsList_Style);
        GoodsList_Screening=view.findViewById(R.id.GoodsList_Screening);
        GoodsList_Recycler=view.findViewById(R.id.GoodsList_Recycler);
    }

    @Override
    public Context getActivityContext() {
        return activity;
    }

    @Override
    public Activity getThisActivity() {
        return activity;
    }

    @Override
    protected GoodsListPresenter createPresenter() {
        return new GoodsListPresenter();
    }

    @Override
    public TextView getGoodsList_Comprehensive() {
        return GoodsList_Comprehensive;
    }

    @Override
    public TextView getGoodsList_Sales() {
        return GoodsList_Sales;
    }

    @Override
    public TextView getGoodsList_Price() {
        return GoodsList_Price;
    }

    @Override
    public TextView getGoodsList_Distance() {
        return GoodsList_Distance;
    }

    @Override
    public ImageView getGoodsList_Style() {
        return GoodsList_Style;
    }

    @Override
    public ImageView getGoodsList_Screening() {
        return GoodsList_Screening;
    }

    @Override
    public RecyclerView getGoodsList_Recycler() {
        return GoodsList_Recycler;
    }
}
