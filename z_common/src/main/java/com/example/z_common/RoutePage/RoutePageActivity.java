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
    /**首页-地址**/
    public static void getAddress(){
        ARouter.getInstance().build("/Home/Address").navigation();
    }
    /**首页-精选店铺**/
    public static void getFineStore(){
        ARouter.getInstance().build("/Home/FineStoreActivity").navigation();
    }
    /**首页-精选店铺**/
    public static void getCircleList(String title,String classification){
        ARouter.getInstance().build("/Home/CircleListActivity")
                .withString("titlec",title)
                .withString("classification",classification)
                .navigation();
    }
    /**首页-商品的列表信息**/
    public static void getGoodsItem(String title,String classification){
        ARouter.getInstance().build("/Home/GoodsItemActivity")
                .withString("title",title)
                .withString("classification",classification)
                .navigation();
    }
    /**首页-搜索**/
    public static void getSearch(){
        ARouter.getInstance().build("/Home/Search").navigation();
    }

    /********************************************************************************************************************************************************************/
    /********************************************************************************************************************************************************************/
    /**我的-订单(无用)**/
    public static void getOrderList(){
        ARouter.getInstance().build("/Order/OrderList").navigation();
    }
    /**我的-收藏界面**/
    public static void getCollection(){
        ARouter.getInstance().build("/Me/Collection").navigation();
    }
    /**我的-历史浏览界面**/
    public static void getHistory(){
        ARouter.getInstance().build("/Me/History").navigation();
    }
    /**我的-信息修改界面**/
    public static void getUserEditorActivity(){
        ARouter.getInstance().build("/Me/UserEditorActivity").navigation();
    }
    /********************************************************************************************************************************************************************/
    /********************************************************************************************************************************************************************/


    /**商品-搜索列表**/
    public static void getGoodsSearch(String SearchKey){
        ARouter.getInstance().build("/Goods/GoodsSearchList")
                .withString("SearchKey",SearchKey)
                .navigation();
    }

    /**LR-登陆界面**/
    public static void getLRActivity(){
        ARouter.getInstance().build("/LR/LRActivity").navigation();
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
