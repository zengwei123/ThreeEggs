package com.example.z_goods.SearchGoodsList;

import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.RoutePage.RouterPageFragment;
import com.example.z_common.Util.SimpleUtils;
import com.example.z_goods.GoodsList.GoodsListFragment;
import com.example.z_goods.R;

/**
 * Created by zengwei on 2019/8/3.
 */

public class SearchGoodsListPresenter extends BasePresenter<SearchGoodsListView> implements View.OnClickListener{
    private GoodsListFragment fragment;
    @Override
    public void init() {
        setView();
        setClick();
    }

    @Override
    public void setView() {
        /**添加推荐布局内容**/
        FragmentTransaction fragmentTransaction= BaseActivity.getInstance().getSupportFragmentManager().beginTransaction();
        fragment= (GoodsListFragment) RouterPageFragment.grtGoodsList(0,mvpView.getSearchKey());
        fragmentTransaction.add(R.id.SearchGoodsList_Frame, fragment,GoodsListFragment.class.getName()).commit();

        mvpView.getSearchGoodsList_TextView().setText(mvpView.getSearchKey());
        SimpleUtils.setViewTypeface(mvpView.getSearchGoodsList_Switch(),"\ue90d");
        SimpleUtils.setViewTypeface(mvpView.getSearchGoodsList_Back(),"\ue314");
    }

    @Override
    public void CloseRequest() {

    }

    public void setClick(){
        mvpView.getSearchGoodsList_TextView().setOnClickListener(this);
        mvpView.getSearchGoodsList_Switch().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.SearchGoodsList_TextView) {
            RoutePageActivity.getSearch();
            mvpView.getThisActivity().finish();
        }else if(i==R.id.SearchGoodsList_Back){
            mvpView.getThisActivity().finish();
        }else if(i==R.id.SearchGoodsList_Switch){
            fragment.setSWitch(mvpView.getSearchGoodsList_Switch());
        }
    }
}
