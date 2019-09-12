package com.example.z_common.NET.Converters;


import com.example.z_common.Model.AllDataState;
import com.example.z_common.Util.ZwGson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by zengwei on 2018/11/12.
 * 标准的接口数据model 模板
 */

public class OutPutJsonConverter<T> implements Converter<ResponseBody, AllDataState<T>> {
    public static final OutPutJsonConverter INSTANCE = new OutPutJsonConverter();
    @Override
    public AllDataState<T> convert(ResponseBody value) throws IOException {
        return ZwGson.GsonToBean(value.string(), AllDataState.class);
    }
}
