package com.example.z_goods.SearchGoodsList;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.RoutePage.RouterPageFragment;
import com.example.z_goods.GoodsList.GoodsListFragment;
import com.example.z_goods.R;

/**
 * Created by zengwei on 2019/8/3.
 */

public class SearchGoodsListPresenter extends BasePresenter<SearchGoodsListView> implements View.OnClickListener{

    @Override
    public void init() {
        setView();
        setClick();
    }

    @Override
    public void setView() {
        /**添加推荐布局内容**/
        FragmentTransaction fragmentTransaction= BaseActivity.getInstance().getSupportFragmentManager().beginTransaction();
        GoodsListFragment fragment= (GoodsListFragment) RouterPageFragment.grtGoodsList();
        fragment.setSearchParameter("123");
        fragmentTransaction.add(R.id.SearchGoodsList_Frame, fragment,GoodsListFragment.class.getName()).commit();

    }

    @Override
    public void CloseRequest() {

    }

    public void setClick(){
        mvpView.getSearchGoodsList_TextView().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.SearchGoodsList_TextView) {
            RoutePageActivity.getSearch();
            mvpView.getThisActivity().finish();
        }
    }
}
