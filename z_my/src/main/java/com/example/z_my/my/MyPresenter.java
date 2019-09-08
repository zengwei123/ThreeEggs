package com.example.z_my.my;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.view.View;

import com.example.z_base.BasePresenter;
import com.example.z_circle.CircleUtil.CircleListUtil;
import com.example.z_common.GlideUtil;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.SimpleUtils;
import com.example.z_my.R;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/**
 * Created by zengwei on 2019/7/28.
 */

class MyPresenter extends BasePresenter<MyView> implements View.OnClickListener {
    @Override
    public void init() {
        setView();
        setClick();
        setTbaLayoutClass();
        setTbaLayoutItem();
        setRecycler();
    }

    @Override
    public void setView() {
        SimpleUtils.setViewTypeface(mvpView.getMy_OpenDrawer(),"\ue90b");
        mvpView.getMy_UserName().setText("小萝卜兔子头");
        GlideUtil.roundImage(mvpView.getThisActivity(),R.mipmap.common_nodata,mvpView.getMy_UserHead());
        mvpView.getMy_Signature().setText("个性签名：每当月色降临，天空群星璀璨，我就想起我空空如也的口袋。");
    }

    @Override
    public void CloseRequest() {

    }

    private void setClick(){
        mvpView.getMy_OpenDrawer().setOnClickListener(this);
        mvpView.getMy_UserEditor().setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i==R.id.My_OpenDrawer){
            mvpView.getMain_Me_Listener().OpenDrawer();
        }else if(i==R.id.My_UserEditor){
            RoutePageActivity.getUserEditorActivity();
        }
    }

    private void setTbaLayoutClass(){
        mvpView.getMy_TabLayout_Class().addTab(mvpView.getMy_TabLayout_Class().newTab().setText("分享"));
        mvpView.getMy_TabLayout_Class().addTab(mvpView.getMy_TabLayout_Class().newTab().setText("收藏"));
        mvpView.getMy_TabLayout_Class().addTab(mvpView.getMy_TabLayout_Class().newTab().setText("赞过"));
        mvpView.getMy_TabLayout_Class().addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mvpView.getMy_TabLayout_Item().setVisibility(View.VISIBLE);
                mvpView.getMy_TabLayout_Item().getTabAt(0).select();
                switch (tab.getPosition()){
                    case 0:
                        CircleListUtil.setRecycler_Article(mvpView.getThisActivity(),mvpView.getMy_RecyclerView());
                        mvpView.getMy_TabLayout_Item().getTabAt(0).setText("所有文章");
                        mvpView.getMy_TabLayout_Item().getTabAt(1).setText("已存草稿");
                        break;
                    case 1:
                        CircleListUtil.setRecycler_Article(mvpView.getThisActivity(),mvpView.getMy_RecyclerView());
                        mvpView.getMy_TabLayout_Item().getTabAt(0).setText("收藏店铺");
                        mvpView.getMy_TabLayout_Item().getTabAt(1).setText("收藏文章");
                        break;
                    case 2:
                        mvpView.getMy_TabLayout_Item().setVisibility(View.GONE);
                        CircleListUtil.setRecycler_Draft(mvpView.getThisActivity(),mvpView.getMy_RecyclerView());
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
    }

    private void setTbaLayoutItem(){
        mvpView.getMy_TabLayout_Item().addTab(mvpView.getMy_TabLayout_Item().newTab().setText("所有文章"));
        mvpView.getMy_TabLayout_Item().addTab(mvpView.getMy_TabLayout_Item().newTab().setText("已存草稿"));
        mvpView.getMy_TabLayout_Item().addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==0){
                    CircleListUtil.setRecycler_Article(mvpView.getThisActivity(),mvpView.getMy_RecyclerView());
                }else {
                    CircleListUtil.setRecycler_Draft(mvpView.getThisActivity(),mvpView.getMy_RecyclerView());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setRecycler(){
        CircleListUtil.setRecycler_Article(mvpView.getThisActivity(),mvpView.getMy_RecyclerView());
        mvpView.getMy_Fragment_TwinklingRefreshLayout().setEnableRefresh(false);
        mvpView.getMy_Fragment_TwinklingRefreshLayout().setEnableOverScroll(false);
        mvpView.getMy_Fragment_TwinklingRefreshLayout().setTargetView(mvpView.getMy_RecyclerView());
        mvpView.getMy_Fragment_TwinklingRefreshLayout().setOnRefreshListener(new RefreshListenerAdapter(){
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {

            }
            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(() -> refreshLayout.finishLoadmore(),2000);
            }
        });
    }
}
