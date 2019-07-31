package com.example.z_common.NET.ConvertersFractory;


import com.example.z_common.NET.Converters.OutPutJsonConverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by zengwei on 2018/11/12.
 * 接口数据的转换器工厂
 */

public class OutPutJsonConverterFactory extends Converter.Factory {
    public static final OutPutJsonConverterFactory INSTANCE = new OutPutJsonConverterFactory();

    public static OutPutJsonConverterFactory create() {
        return INSTANCE;
    }

    // 我们只关实现从ResponseBody 到 String 的转换，所以其它方法可不覆盖
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type == String.class) {
            return OutPutJsonConverter.INSTANCE;
        }
        //其它类型我们不处理，返回null就行
        return null;
    }
}
