package com.example.z_base;

import android.app.Application;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        // 初始化
//        LitePal.initialize(this);
//        /**是否第一次进入**/
//        boolean isOne= (boolean) new SharedPreferencesHelper(getApplicationContext(),"First").getSharedPreference("IS",true);
//        if (isOne){
//            new SharedPreferencesHelper(getApplicationContext(),"First").put("IS",false);
//            new NoteBook("默认账本", Utils.getFormat("yyyy-MM-dd",new Date().getTime()),1000).save();
//        }
    }
}
