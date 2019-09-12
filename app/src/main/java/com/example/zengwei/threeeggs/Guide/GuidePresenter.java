package com.example.zengwei.threeeggs.Guide;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_common.Util.GlideUtil;
import com.example.z_common.Util.SharedPreferencesHelper;
import com.example.zengwei.threeeggs.Main.MainActivity;
import com.example.zengwei.threeeggs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwei on 2019/7/20.
 */

public class GuidePresenter extends BasePresenter<GuideView> {
    private int Guide_layout_size=4;
    @Override
    public void init() {
        /**判断是否第一次进入**/
        boolean isOne= (boolean) new SharedPreferencesHelper(mvpView.getActivityContext(),"First").getSharedPreference("IS",true);
        //isOne=true;
        if (isOne){
            new SharedPreferencesHelper(mvpView.getActivityContext(),"First").put("IS",false);
            /**沉浸式 + 全屏 关闭虚拟按键**/
            ((BaseActivity)mvpView.getThisActivity()).immersionWindow();
            if ( ((BaseActivity)mvpView.getThisActivity()).checkDeviceHasNavigationBar()){
                //隐藏虚拟按键，并且全屏
                ((BaseActivity)mvpView.getThisActivity()).hideBottomUIMenu();
            }
            mvpView.getGuide_NoFirst_layout().setVisibility(View.GONE);
        }else {
            /**不是第一次  关闭引导动画**/
            mvpView.getGuide_BGABanner().setVisibility(View.GONE);
            intentActivity();
        }
        setView();
    }

    @Override
    public void setView() {
        List<View> views = new ArrayList<>();
        for (int i=0;i<Guide_layout_size;i++){
            View Guide_layout=View.inflate(mvpView.getActivityContext(), R.layout.guide_bgabanner_layout, null);
            ImageView Guide_BGABanner_Image=Guide_layout.findViewById(R.id.Guide_BGABanner_Image);
            int image_url=R.mipmap.beijin04;
            switch (i){
                case 0: image_url=R.mipmap.beijin04; break;
                case 1: image_url=R.mipmap.beijin05; break;
                case 2: image_url=R.mipmap.beijin06; break;
                case 3: image_url=R.mipmap.beijin07; break;
            }
            GlideUtil.displayImage(mvpView.getThisActivity(),image_url,Guide_BGABanner_Image);
            if(i==Guide_layout_size-1){
                TextView Guide_BGABanner_TextView=Guide_layout.findViewById(R.id.Guide_BGABanner_TextView);
                Guide_BGABanner_TextView.setVisibility(View.VISIBLE);
                /**点击跳转**/
                Guide_BGABanner_TextView.setOnClickListener(v->{
                    intentActivity();
                });
            }
            views.add(Guide_layout);
        }
        mvpView.getGuide_BGABanner().setData(views);
    }

    @Override
    public void CloseRequest() {

    }

    /**自动跳转**/
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            intentActivity();
            super.handleMessage(msg);
        }
    };
    /**跳转到下一个activity**/
    private void intentActivity(){
        ((BaseActivity)mvpView.getThisActivity()).JumpActivity(mvpView.getActivityContext(), MainActivity.class);
        mvpView.getThisActivity().finish();
    }
}
