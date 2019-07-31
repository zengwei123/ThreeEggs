package com.example.z_common.UtilRecyclerAdapter;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by zengwei on 2019/7/24.
 * reyclerView Adapter的回调方法
 */

public interface SimpleRecyclerViewAdapterCallback {
    void convert(BaseViewHolder helper, Object item);
}
