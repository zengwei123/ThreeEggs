package com.example.z_common.RoutePage;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 用来管理activity的路由
 */
public class RoutePageActivity {
    /**首页-分类**/
    public static void getHomeCategory(){
        ARouter.getInstance().build("/Home/Category").navigation();
    }

    /**我的-订单**/
    public static void getOrderList(){
        ARouter.getInstance().build("/Order/OrderList").navigation();
    }

    /**我的-订单**/
    public static void getAddress(){
        ARouter.getInstance().build("/Home/Address").navigation();
    }

    /**我的-订单**/
    public static void getSearch(){
        ARouter.getInstance().build("/Home/Search").navigation();
    }

}
