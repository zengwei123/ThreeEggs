package com.example.z_login_register.LR;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.example.z_base.BasePresenter;
import com.example.z_login_register.LR.ViewPage.LREvent;
import com.example.z_login_register.LR.ViewPage.LRFragmentAdapter;
import com.example.z_login_register.LR.ViewPage.LRViewPageFragment_C;
import com.example.z_login_register.LR.ViewPage.LRViewPageFragment_p;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwei on 2019/8/11.
 */

class LRPresenter extends BasePresenter<LRView>{
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        List<Fragment> fragments=new ArrayList<>();
        LRViewPageFragment_p lrViewPageFragment_p=new LRViewPageFragment_p();
        lrViewPageFragment_p.setLrEvent(() -> {
            mvpView.getNoScrollViewPager().setCurrentItem(1);
        });
        fragments.add(lrViewPageFragment_p);
        fragments.add(new LRViewPageFragment_C());
        mvpView.getNoScrollViewPager().setAdapter(new LRFragmentAdapter(((FragmentActivity)mvpView.getThisActivity()).getSupportFragmentManager(),fragments));
    }

    @Override
    public void CloseRequest() {

    }
}
