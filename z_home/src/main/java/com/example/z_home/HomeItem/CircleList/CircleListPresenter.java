package com.example.z_home.HomeItem.CircleList;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_circle.CircleList.CircleListFragment;
import com.example.z_common.Model.KeyWords;
import com.example.z_common.RoutePage.RoutePageActivity;
import com.example.z_common.RoutePage.RouterPageFragment;
import com.example.z_common.Util.ZwGson;
import com.example.z_home.R;

import java.util.List;

/**
 * Created by zengwei on 2019/9/8.
 */

public class CircleListPresenter extends BasePresenter<CircleListView> implements View.OnClickListener{
    private CircleListFragment fragment;
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        /**添加推荐布局内容**/
        FragmentTransaction fragmentTransaction= BaseActivity.getInstance().getSupportFragmentManager().beginTransaction();
        fragment= (CircleListFragment) RouterPageFragment.grtCircleList(1,null);
        fragmentTransaction.add(R.id.CircleList_layout, fragment,CircleListFragment.class.getName()).commit();

        mvpView.getInclude_Title_Text().setText(mvpView.getTitlec());

        setTabLayout();
        setClick();
    }

    private void setTabLayout(){
        /**分割分类**/
        List<KeyWords> keyWordsss= ZwGson.jsonToList(mvpView.getclassification(),KeyWords.class);
        /**默认全部分类**/
        mvpView.getCircleList_TabLayout().addTab(mvpView.getCircleList_TabLayout().newTab().setText("全部"));
        for (KeyWords s:keyWordsss){
            mvpView.getCircleList_TabLayout().addTab(mvpView.getCircleList_TabLayout().newTab().setText(s.getName()));
        }

        mvpView.getCircleList_TabLayout().addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()!=0){
                    fragment.categoryName(keyWordsss.get(tab.getPosition()-1).getId()+"");
                }else {
                    fragment.categoryName(null);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setClick(){
        mvpView.getInclude_Title_Close().setOnClickListener(this);
        mvpView.getCircleList_Search().setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.CircleList_Search) {
            RoutePageActivity.getSearch();
        } else if (i == R.id.Include_Title_Close) {
            mvpView.getThisActivity().finish();
        }
    }
}
