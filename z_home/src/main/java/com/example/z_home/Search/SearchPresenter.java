package com.example.z_home.Search;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_common.Custom.Dialog.DialogUtil;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.SharedPreferencesHelper;
import com.example.z_common.SimpleUtils;
import com.example.z_common.ZwGson;
import com.example.z_home.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwei on 2019/8/1.
 */

class SearchPresenter extends BasePresenter<SearchView> implements View.OnClickListener{
    @Override
    public void init() {
        setView();
        setClick();
    }

    @Override
    public void setView() {
        SimpleUtils.setViewTypeface(mvpView.getSearch_Back(),"\ue314");
        SimpleUtils.setViewTypeface(mvpView.getSearch_Delete(),"\ue872");
        setHomeSearchEdit_HotLayout(getSearchString());  //添加搜索记录
    }

    @Override
    public void CloseRequest() {

    }

    private void setClick(){
        mvpView.getSearch_Search().setOnClickListener(this);
        mvpView.getSearch_Delete().setOnClickListener(this);
        mvpView.getSearch_Back().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.Search_Search) {
            if (mvpView.getSearch_Edit().getText().toString().trim().equals("")){
                SimpleUtils.setToast("搜索内容不能为空");
            }else{
                AddSearchString(mvpView.getSearch_Edit().getText().toString().trim());
                RoutePageActivity.getGoodsSearch(mvpView.getSearch_Edit().getText().toString().trim());
                mvpView.getThisActivity().finish();
            }
        }else if(i == R.id.Search_Delete){
            new DialogUtil().show(R.mipmap.prompt,"是否清除历史搜索记录","确定", new DialogUtil.DialogButtonListener(){

                @Override
                public void sure() {
                    new SharedPreferencesHelper(BaseActivity.getInstance(),"SEARCHLIST").remove("key");
                }

                @Override
                public void cancel() {

                }
            });

        }else if(i==R.id.Search_Back){
            mvpView.getThisActivity().finish();
        }
    }

    /**热门控件的设置**/
    private void setHomeSearchEdit_HotLayout(List<String> strings){
        //balalal
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 35, 20, 10);// 设置边距
        int indexs;
        if (strings.size()>10){
            indexs=10;
        }else {
            indexs=strings.size();
        }
        for (int i = 0; i < indexs; i++) {
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
            int finalI = i;
            textView.setOnClickListener(v -> {
                RoutePageActivity.getGoodsSearch(strings.get(finalI));
                mvpView.getThisActivity().finish();
            });
        }
    }
    /**添加搜索内容**/
    private void AddSearchString(String sc){
        String str = (String) new SharedPreferencesHelper(BaseActivity.getInstance(),"SEARCHLIST").getSharedPreference("key","");
        List<String> strings;
        if (str.equals("")){
            strings =new ArrayList<>();
        }else {
            strings= ZwGson.GsonToList(str,String.class);
        }
        strings.add(sc);
       new SharedPreferencesHelper(BaseActivity.getInstance(),"SEARCHLIST").put("key", ZwGson.GsonString(strings));
    }
    /**添加搜索内容**/
    private List<String> getSearchString(){
        String str = (String) new SharedPreferencesHelper(BaseActivity.getInstance(),"SEARCHLIST").getSharedPreference("key","");
        List<String> strings;
        if (str.equals("")){
            strings =new ArrayList<>();
        }else {
            strings= ZwGson.GsonToList(str,String.class);
        }
        return strings;
    }
}
