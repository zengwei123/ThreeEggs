package com.example.z_home.HomeItem.GoodsItem;

import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.RoutePage.RouterPageFragment;
import com.example.z_goods.GoodsList.GoodsListFragment;
import com.example.z_home.R;

public class GoodsItemPresenter extends BasePresenter<GoodsItemView> implements View.OnClickListener {
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        /**添加推荐布局内容**/
        FragmentTransaction fragmentTransaction= BaseActivity.getInstance().getSupportFragmentManager().beginTransaction();
        GoodsListFragment fragment= (GoodsListFragment) RouterPageFragment.grtGoodsList(1,null);
        fragmentTransaction.add(R.id.GoodsList_layout, fragment,GoodsListFragment.class.getName()).commit();

        mvpView.getInclude_Title_Text().setText(mvpView.getTitlec());

        setTabLayout();
        click();
    }
    private void setTabLayout(){
        String[] strings=mvpView.getclassification().split(",");
        mvpView.getGoodsList_TabLayout().addTab(mvpView.getGoodsList_TabLayout().newTab().setText("全部"));
        for (String s:strings){
            mvpView.getGoodsList_TabLayout().addTab(mvpView.getGoodsList_TabLayout().newTab().setText(s));
        }
    }
    private void click(){
        mvpView.getGoodsList_Search().setOnClickListener(this);
        mvpView.getInclude_Title_Close().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.GoodsList_Search) {
            RoutePageActivity.getSearch();
        } else if (i == R.id.Include_Title_Close) {
            mvpView.getThisActivity().finish();
        }
    }
}
