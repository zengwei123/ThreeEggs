package com.example.zengwei.threeeggs;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class ThreeEggsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**弟弟行为 为大哥提供方便**/
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this);
    }
}
