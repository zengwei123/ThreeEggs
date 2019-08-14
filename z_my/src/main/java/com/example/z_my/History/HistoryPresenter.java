package com.example.z_my.History;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.z_base.BasePresenter;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapterCallback;
import com.example.z_my.R;
import com.necer.calendar.BaseCalendar;
import com.necer.listener.OnCalendarChangedListener;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zengwei on 2019/8/11.
 */

public class HistoryPresenter extends BasePresenter<HistoryView> {
    private boolean aBoolean=false;
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        List<String> strings= new ArrayList<>(Arrays.asList("123","123123","12413241","12312312","124124","124124"));
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.history_layout_item,
                mvpView.getActivityContext(), strings, (helper, item) -> {
                    helper.setText(R.id.History_Price, "￥："+(String) item);
                });
        mvpView.getHistory_Recycler().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getHistory_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,3));

        mvpView.getHistory_MIUI9Calendar().setOnCalendarChangedListener((baseCalendar, year, month, localDate) -> {
            if (aBoolean){
                strings.clear();
                for(int i=0;i<5;i++){
                    strings.add(localDate.toString());
                }
                simpleRecyclerViewAdapter.notifyDataSetChanged();
            }else {
                aBoolean=true;
            }
        });
    }

    @Override
    public void CloseRequest() {

    }
}
