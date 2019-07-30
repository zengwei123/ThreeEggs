package com.example.z_home.Category;

import android.graphics.Color;

import com.example.z_base.BasePresenter;
import com.example.z_common.SimpleRecyclerViewAdapter;
import com.example.z_common.SimpleUtils;
import com.example.z_home.Model.CategoryList;
import com.example.z_home.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CategoryPresenter extends BasePresenter<CategoryView> {
    private int SelcetParent=0;

    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        mvpView.getInclude_Title_Text().setText("分类");
        mvpView.getInclude_Title_Close().setOnClickListener(view -> {
            mvpView.getThisActivity().finish();
        });
        List<CategoryList> categoryLists=new ArrayList<>();

        categoryLists.add(new CategoryList("男装",Arrays.asList("爸爸","爸爸","爸爸","爸爸","爸爸","爸爸")));
        categoryLists.add(new CategoryList("女装",Arrays.asList("妈妈","妈妈","妈妈","妈妈","妈妈","妈妈")));
        categoryLists.add(new CategoryList("童装",Arrays.asList("爷爷","爷爷","爷爷","爷爷","爷爷","爷爷")));
        categoryLists.add(new CategoryList("鞋类",Arrays.asList("奶奶","奶奶","奶奶","奶奶","奶奶","奶奶")));
        categoryLists.add(new CategoryList("上装",Arrays.asList("叔叔","叔叔","叔叔","叔叔","叔叔","叔叔")));
        categoryLists.add(new CategoryList("下装",Arrays.asList("姑姑","姑姑","姑姑","姑姑","姑姑","姑姑")));
        categoryLists.add(new CategoryList("内衣",Arrays.asList("嫂子","嫂子","嫂子","嫂子","嫂子","嫂子")));


        setRecycler(0,categoryLists,true);
    }
    /**设置布局**/
    private void setRecycler(int ii,List<CategoryList> categoryLists,boolean b){
        /**不用重复更新布局**/
        if (b){
            SimpleRecyclerViewAdapter simpleRecyclerViewAdapter1=new SimpleRecyclerViewAdapter(R.layout.category_recycler_item1,
                    mvpView.getActivityContext(), categoryLists, (helper, item) -> {
                /**名字**/
                helper.setText(R.id.Category_Parent_Text,((CategoryList)item).getParent());
                /**选中背景色**/
                if (helper.getAdapterPosition()==SelcetParent){
                    helper.getView(R.id.Category_Parent_Text).setBackgroundColor(Color.parseColor("#25C6FC"));
                }else {
                    helper.getView(R.id.Category_Parent_Text).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                /**点击事件**/
                helper.getView(R.id.Category_Parent_Text).setOnClickListener(view -> {
                    view.setBackgroundColor(Color.parseColor("#25C6FC"));
                    setRecycler(helper.getAdapterPosition(),categoryLists,false);
                    SelcetParent=helper.getAdapterPosition();
                    mvpView.getCategory_Parent().getAdapter().notifyDataSetChanged();
                });
            });
            mvpView.getCategory_Parent().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,mvpView.getActivityContext(),0));
            mvpView.getCategory_Parent().setAdapter(simpleRecyclerViewAdapter1);
        }
        /**大类下面的子类**/
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter2=new SimpleRecyclerViewAdapter(R.layout.category_recycler_item2,
                mvpView.getActivityContext(), categoryLists.get(ii).getChild(), (helper, item) -> {
            helper.setText(R.id.Category_Child_Text,(String)item);
        });
        mvpView.getCategory_Child().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,mvpView.getActivityContext(),3));
        mvpView.getCategory_Child().setAdapter(simpleRecyclerViewAdapter2);
    }
}
