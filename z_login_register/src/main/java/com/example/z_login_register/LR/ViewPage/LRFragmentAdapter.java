package com.example.z_login_register.LR.ViewPage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.z_base.MvpFragment;

import java.util.List;

/**
 * Fragment公共Adapter
 */
public class LRFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;//各导航的Fragment
    public LRFragmentAdapter(FragmentManager fragmentManager, List<Fragment> fragments){
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
