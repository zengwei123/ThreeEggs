package com.example.z_common.NET;

import com.example.z_common.NET.ConvertersFractory.OutPutJsonConverterFactory;
import com.example.z_common.NET.ConvertersFractory.StringConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求的管理类
 */
public class RetrofitServiceManager {
    private static final int DEFAULT_TIME_OUT = 10;//超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 20;  //读写超时时间
    private static final String IP="http://193.112.43.188:8081/";
    private Retrofit mRetrofit;
    /**创建Retrofit 请求对象**/
    private RetrofitServiceManager(){
        // 添加公共参数拦截器
        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)//默认重试一次，若需要重试N次，则要实现拦截器。
                //.addInterceptor(new Retry(5))                        //拦截器  重试拦截器
                //.addInterceptor(new AddQueryParameterInterceptor())  //拦截器  添加请求头
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)     //连接超时时间
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)   //读取超时时间
                .writeTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)  //写超时时间
                .build();
        // 创建Retrofit
        mRetrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(OutPutJsonConverterFactory.create())     //添加转换工厂
                .addConverterFactory(GsonConverterFactory.create())           //添加转换工厂
                .addConverterFactory(StringConverterFactory.create())         //添加转换工厂
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())    //添加转换工厂
                .baseUrl(IP)                                                  //请求地址
                .build();                                                     //发起请求
    }


    private static class SingletonHolder{
        private static final RetrofitServiceManager INSTANCE = new RetrofitServiceManager();
    }

    /**
     * 获取RetrofitServiceManager
     * @return
     */
    public static RetrofitServiceManager getInstance(){
        return SingletonHolder.INSTANCE;
    }
    /**
     * 获取对应的Service
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service){
        return mRetrofit.create(service);
    }
}
