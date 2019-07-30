package com.example.z_common.RoutePage;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 用来管理activity的路由
 */
public class RoutePageActivity {
    /**首页-分类**/
    public static void grtHomeCategory(){
        ARouter.getInstance().build("/Home/Category").navigation();
    }

    /**我的-订单**/
    public static void grtOrderList(){
        ARouter.getInstance().build("/Order/OrderList").navigation();
    }

    /**我的-订单**/
    public static void grtAddress(){
        ARouter.getInstance().build("/Home/Address").navigation();
    }
}
