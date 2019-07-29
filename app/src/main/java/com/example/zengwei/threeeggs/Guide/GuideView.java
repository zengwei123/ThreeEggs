package com.example.zengwei.threeeggs.Guide;

import android.widget.RelativeLayout;

import com.example.z_base.BaseView;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by zengwei on 2019/7/20.
 */

public interface GuideView extends BaseView {
    BGABanner getGuide_BGABanner();
    RelativeLayout getGuide_NoFirst_layout();
}
