package com.example.z_circle.Circle;

import android.support.v4.app.FragmentActivity;

import com.example.z_base.BasePresenter;
import com.example.z_base.MvpFragment;
import com.example.z_circle.CircleRecyclerList.CircleRecyclerListFragment;
import com.example.z_common.SimpleFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class CirclePresenter extends BasePresenter<CircleView> {
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        List<MvpFragment> listFragments=new ArrayList<>();
        listFragments.add(new CircleRecyclerListFragment());
        listFragments.add(new CircleRecyclerListFragment());
        mvpView.getCircle_ViewPager().setAdapter(new SimpleFragmentAdapter( ((FragmentActivity)mvpView.getThisActivity()).getSupportFragmentManager(),listFragments));

        mvpView.getCircle_TabLayout().setupWithViewPager(mvpView.getCircle_ViewPager());
        mvpView.getCircle_TabLayout().getTabAt(0).setText("热门推荐");
        mvpView.getCircle_TabLayout().getTabAt(1).setText("离我最近");
    }
}
