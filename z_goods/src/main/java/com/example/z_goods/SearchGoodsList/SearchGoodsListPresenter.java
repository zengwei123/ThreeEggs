package com.example.z_goods.SearchGoodsList;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_base.MvpFragment;
import com.example.z_circle.CircleList.CircleListFragment;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.RoutePage.RouterPageFragment;
import com.example.z_common.SimpleFragmentAdapter;
import com.example.z_common.Util.SimpleUtils;
import com.example.z_goods.GoodsList.GoodsListFragment;
import com.example.z_goods.R;
import com.example.z_goods.StoreList.StoreFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwei on 2019/8/3.
 */

public class SearchGoodsListPresenter extends BasePresenter<SearchGoodsListView> implements View.OnClickListener{
    private GoodsListFragment goodsfragment;
    private StoreFragment storefragment;
    private CircleListFragment circleListFragment;
    private List<MvpFragment> mvpFragments=new ArrayList<>();
    @Override
    public void init() {
        setView();
        setClick();
    }

    @Override
    public void setView() {
        Goods();
        Store();
        Circle();
        mvpView.getSearchGoodsList_TextView().setText(mvpView.getSearchKey());
        SimpleUtils.setViewTypeface(mvpView.getSearchGoodsList_Switch(),"\ue90d");
        SimpleUtils.setViewTypeface(mvpView.getSearchGoodsList_Back(),"\ue314");

        mvpView.getSearchGoods_TabLayout().addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        mvpView.getSearchGoodsList_Page().setCurrentItem(0);
                        mvpView.getSearchGoodsList_Switch().setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        mvpView.getSearchGoodsList_Page().setCurrentItem(1);
                        mvpView.getSearchGoodsList_Switch().setVisibility(View.GONE);
                        break;
                    case 2:
                        mvpView.getSearchGoodsList_Page().setCurrentItem(2);
                        mvpView.getSearchGoodsList_Switch().setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mvpView.getSearchGoodsList_Page().setAdapter(new SimpleFragmentAdapter(((FragmentActivity)mvpView.getThisActivity()).getSupportFragmentManager(),mvpFragments));
        mvpView.getSearchGoodsList_Page().setOffscreenPageLimit(3);
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
            goodsfragment.setSWitch(mvpView.getSearchGoodsList_Switch());
        }
    }

    /**商品**/
    private void Goods(){
        /**添加推荐布局内容**/
//        FragmentTransaction fragmentTransaction= BaseActivity.getInstance().getSupportFragmentManager().beginTransaction();
        goodsfragment= (GoodsListFragment) RouterPageFragment.grtGoodsList(0,mvpView.getSearchKey());
        mvpFragments.add(goodsfragment);
//        fragmentTransaction.add(R.id.SearchGoodsList_Frame, goodsfragment,GoodsListFragment.class.getName()).commit();
    }

    /**店铺**/
    private void Store(){
        /**添加推荐布局内容**/
//        FragmentTransaction fragmentTransaction= BaseActivity.getInstance().getSupportFragmentManager().beginTransaction();
        storefragment= (StoreFragment) RouterPageFragment.getStoreList();
        mvpFragments.add(storefragment);
//        fragmentTransaction.add(R.id.SearchGoodsList_Frame, storefragment,StoreFragment.class.getName()).commit();
    }

    /**店铺**/
    private void Circle(){
        /**添加推荐布局内容**/
//        FragmentTransaction fragmentTransaction= BaseActivity.getInstance().getSupportFragmentManager().beginTransaction();
        circleListFragment= (CircleListFragment) RouterPageFragment.grtCircleList(1,null);
        mvpFragments.add(circleListFragment);
//        fragmentTransaction.add(R.id.SearchGoodsList_Frame, circleListFragment,CircleListFragment.class.getName()).commit();
    }
}
