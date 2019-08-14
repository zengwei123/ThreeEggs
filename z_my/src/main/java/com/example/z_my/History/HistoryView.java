package com.example.z_my.History;

import android.support.v7.widget.RecyclerView;

import com.example.z_base.BaseView;
import com.necer.calendar.Miui9Calendar;

/**
 * Created by zengwei on 2019/8/11.
 */

interface HistoryView extends BaseView{
    Miui9Calendar getHistory_MIUI9Calendar();
    RecyclerView getHistory_Recycler();
}
