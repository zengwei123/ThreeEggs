package com.example.z_circle.Circle;

import android.os.Handler;
import android.widget.ImageView;

import com.example.z_base.BasePresenter;
import com.example.z_circle.CircleList.CircleListUtil;
import com.example.z_circle.R;
import com.example.z_common.GlideUtil;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.Arrays;
import java.util.List;

public class CirclePresenter extends BasePresenter<CircleView> {
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        setHeadMenu();
        setHeadShuffling();
        setContentRecycler();
        SimpleUtils.setViewTypeface(mvpView.getCircle_Fragment_TextView_Search(),"\uea65搜索感兴趣的内容");
        mvpView.getCircle_Fragment_TabLayout().addTab( mvpView.getCircle_Fragment_TabLayout().newTab().setText("推荐"));
        mvpView.getCircle_Fragment_TabLayout().addTab( mvpView.getCircle_Fragment_TabLayout().newTab().setText("关注"));
        mvpView.getCircle_Fragment_TabLayout().addTab( mvpView.getCircle_Fragment_TabLayout().newTab().setText("附近"));
        mvpView.getCircle_Fragment_TabLayout().addTab( mvpView.getCircle_Fragment_TabLayout().newTab().setText("点亮数"));
    }

    @Override
    public void CloseRequest() {

    }


    /**设置菜单**/
    private void setHeadMenu(){
        /**设置活动菜单**/
        List<String> strings= Arrays.asList("必买推荐","工作穿搭","网红榜","特色榜");
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter =new SimpleRecyclerViewAdapter(R.layout.circle_fragment_recyclerview_activitymenu, mvpView.getActivityContext(), strings, (helper, item) -> {
            /**价值图片**/
            GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.common_nodata, helper.getView(R.id.Circle_Fragment_ActivityMenu_Image));
            /**活动名称**/
            helper.setText(R.id.Circle_Fragment_ActivityMenu_TextView,(String)item);
        });
        mvpView.getCircle_Fragment_RecyclerView().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getCircle_Fragment_RecyclerView().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,strings.size()));
    }

    /**设置轮播**/
    private void setHeadShuffling(){
        /**设置轮播**/
        mvpView.getCircle_Fragment_BGABanner().setAdapter((banner, itemView, model, position) ->
                GlideUtil.displayImage(mvpView.getThisActivity(),model,(ImageView) itemView));
        List<Integer> sf=Arrays.asList(R.mipmap.a1,R.mipmap.a2,R.mipmap.a3);
        mvpView.getCircle_Fragment_BGABanner().setData(sf, null);
    }

    public void setContentRecycler() {
        CircleListUtil.setRecycler_Article(mvpView.getThisActivity(),mvpView.getCircle_Fragment_ContentRecyclerView());
        mvpView.getCircle_Fragment_TwinklingRefreshLayout().setEnableRefresh(false);
        mvpView.getCircle_Fragment_TwinklingRefreshLayout().setEnableOverScroll(false);
        mvpView.getCircle_Fragment_TwinklingRefreshLayout().setTargetView(mvpView.getCircle_Fragment_ContentRecyclerView());
        mvpView.getCircle_Fragment_TwinklingRefreshLayout().setOnRefreshListener(new RefreshListenerAdapter(){
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
