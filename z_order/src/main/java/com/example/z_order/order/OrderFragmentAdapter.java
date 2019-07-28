package com.example.z_order.order;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.z_base.MvpFragment;

import java.util.List;


public class OrderFragmentAdapter extends FragmentPagerAdapter {
    private List<MvpFragment> mFragmentList;//各导航的Fragment
    public OrderFragmentAdapter(FragmentManager fragmentManager, List<MvpFragment> fragments){
        super(fragmentManager);
        mFragmentList=fragments;
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
