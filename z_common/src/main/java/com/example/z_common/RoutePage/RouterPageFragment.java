package com.example.z_common.RoutePage;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

public class RouterPageFragment {
    /**商品列表**/
    public static Fragment grtGoodsList(){
        return (Fragment) ARouter.getInstance().build("/Goods/GoodsList").navigation();
    }
}
