package com.example.z_home.HomeItem.FineStore;

import android.support.v4.app.FragmentTransaction;

import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_common.RoutePage.RouterPageFragment;
import com.example.z_goods.GoodsList.GoodsListFragment;
import com.example.z_goods.StoreList.StoreFragment;
import com.example.z_home.R;

/**
 * Created by zengwei on 2019/9/4.
 */

public class FineStorePresenter extends BasePresenter<FineStoreView>{
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        mvpView.getInclude_Title_Close().setOnClickListener(v -> mvpView.getThisActivity().finish());
        mvpView.getInclude_Title_Text().setText("精选店铺");
        FragmentTransaction fragmentTransaction= BaseActivity.getInstance().getSupportFragmentManager().beginTransaction();
        StoreFragment fragment= (StoreFragment) RouterPageFragment.getStoreList();
        fragmentTransaction.add(R.id.FineStore_layout, fragment,StoreFragment.class.getName()).commit();
    }
}
