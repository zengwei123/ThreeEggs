package com.example.z_login_register.LR;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.WindowManager;
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
    private List<Fragment> fragments=new ArrayList<>();
    @Override
    public void init() {
        mvpView.getLR_Close().setOnClickListener(v->mvpView.getThisActivity().finish());
        mvpView.getThisActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setView();
    }

    @Override
    public void setView() {

        LRViewPageFragment_p lrViewPageFragment_p=new LRViewPageFragment_p();
        lrViewPageFragment_p.setLrEvent(() -> {
            mvpView.getNoScrollViewPager().setCurrentItem(1);
            /**启动定时器**/
            ((LRViewPageFragment_C)fragments.get(1)).CountDownTimerStart();
            /**设置手机号**/
            ((LRViewPageFragment_C)fragments.get(1)).setPhone(((LRViewPageFragment_p)fragments.get(0)).getLR_Phone().getText().toString().trim());
        });
        fragments.add(lrViewPageFragment_p);
        fragments.add(new LRViewPageFragment_C());
        mvpView.getNoScrollViewPager().setAdapter(new LRFragmentAdapter(((FragmentActivity)mvpView.getThisActivity()).getSupportFragmentManager(),fragments));
    }

    @Override
    public void CloseRequest() {

    }

    public List<Fragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }
}
