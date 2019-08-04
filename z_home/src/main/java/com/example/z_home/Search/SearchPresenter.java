package com.example.z_home.Search;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.z_base.BasePresenter;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.SharedPreferencesHelper;
import com.example.z_home.R;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by zengwei on 2019/8/1.
 */

class SearchPresenter extends BasePresenter<SearchView> implements View.OnClickListener{
    @Override
    public void init() {
        setView();
        setHomeSearchEdit_HotLayout();
        setClick();
    }

    @Override
    public void setView() {

    }

    @Override
    public void CloseRequest() {

    }

    private void setClick(){
        mvpView.getSearch_Search().setOnClickListener(this);
    }
    /**热门控件的设置**/
    private void setHomeSearchEdit_HotLayout(){
        List<String> strings= Arrays.asList("开心过","富婆快乐求","美人鱼");
        //balalal
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 35, 20, 10);// 设置边距
        for (int i = 0; i < strings.size(); i++) {
            final TextView textView = new TextView(mvpView.getActivityContext());
            textView.setTag(i);
            textView.setTextSize(15);
            textView.setText(strings.get(i));
            textView.setPadding(24, 11, 24, 11);
            textView.setTextColor(Color.parseColor("#666666"));
            textView.setBackgroundResource(R.drawable.home_edittext_background);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setSingleLine(true);
            mvpView.getSearch_HotLayout().addView(textView, layoutParams);
            // 标签点击事件
            textView.setOnClickListener(v -> {
                Toast.makeText(mvpView.getActivityContext(), "点击事件", Toast.LENGTH_SHORT).show();
            });
        }
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.Search_Search) {
            RoutePageActivity.getGoodsSearch();
            mvpView.getThisActivity().finish();
        }
    }
}
