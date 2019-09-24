package com.example.z_common.RoutePage;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.MvpFragment;

public class RouterPageFragment {
    /**商品列表**/
    public static Fragment grtGoodsList(int GoodsType,String SearchParameter){
        return (Fragment) ARouter.getInstance().build("/Goods/GoodsList")
                .withInt("GoodsType",GoodsType)
                .withString("SearchParameter",SearchParameter)
                .navigation();
    }
    /**商品-店铺列表**/
    public static Fragment getStoreList(){
        return (Fragment) ARouter.getInstance().build("/Goods/StoreList").navigation();
    }




    /**圈子-文章列表数据**/
    public static Fragment grtCircleList(int CircleType,String SearchParameter){
        return (Fragment) ARouter.getInstance().build("/Circle/CircleListFragment")
                .withInt("CircleType",CircleType)
                .withString("SearchParameter",SearchParameter)
                .navigation();
    }
    /**圈子-文章评论列表**/
    public static Fragment grtCommentsFragment(String roundId,String comment_id){
        return (Fragment) ARouter.getInstance().build("/Circle/CommentsFragment")
                .withString("roundId",roundId)
                .withString("comment_id",comment_id)
                .navigation();
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
