package com.example.z_common.RoutePage;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * Created by zengwei on 2019/8/11.
 * 登陆判断
 */
@Interceptor(priority = 8, name = "登陆判断拦截器")
public class LoginJudge implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
//        if(postcard.getPath().equals("/Home/Category")){
//            callback.onInterrupt(new RuntimeException("我觉得有点异常"));
//        }else {
//        }
        callback.onContinue(postcard);  // 处理完成，交还控制权
    }

    @Override
    public void init(Context context) {

    }
}
