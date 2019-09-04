package com.example.z_common.RoutePage;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;

public class RouterPageFragment {
    /**商品列表**/
    public static Fragment grtGoodsList(){
        return (Fragment) ARouter.getInstance().build("/Goods/GoodsList").navigation();
    }

    /**消息列表**/
    public static MvpFragment grtMessageFragment(){
        return (MvpFragment) ARouter.getInstance().build("/Message/MessageFragment").navigation();
    }

    /**侧滑布局**/
    public static MvpFragment grtDrawerFragment(){
        return (MvpFragment) ARouter.getInstance().build("/Drawer/DrawerFragment").navigation();
    }
}
