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

    /**我的-地址**/
    public static void getAddress(){
        ARouter.getInstance().build("/Home/Address").navigation();
    }

    /**我的-搜索**/
    public static void getSearch(){
        ARouter.getInstance().build("/Home/Search").navigation();
    }

    /**商品-搜索列表**/
    public static void getGoodsSearch(){
        ARouter.getInstance().build("/Goods/GoodsSearchList").navigation();
    }

    /**登陆界面**/
    public static void getLRActivity(){
        ARouter.getInstance().build("/LR/LRActivity").navigation();
    }

    /**收藏界面**/
    public static void getCollection(){
        ARouter.getInstance().build("/Me/Collection").navigation();
    }

    /**历史浏览界面**/
    public static void getHistory(){
        ARouter.getInstance().build("/Me/History").navigation();
    }

    /**信息修改界面**/
    public static void getUserEditorActivity(){
        ARouter.getInstance().build("/Me/UserEditorActivity").navigation();
    }

    /**文章发布界面**/
    public static void getIssueActivity(){
        ARouter.getInstance().build("/Issue/IssueActivity").navigation();
    }

    /**主界面**/
    public static void getMainActivity(){
        ARouter.getInstance().build("/Main/MainActivity").navigation();
    }




}
