package com.example.z_home.HomeItem.Category;

import android.graphics.Color;
import android.view.View;

import com.example.z_base.BasePresenter;
import com.example.z_common.Custom.Dialog.LottieDialog;
import com.example.z_common.GlideUtil;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.SimpleUtils;
import com.example.z_home.Model.CategoryList;
import com.example.z_home.Net.HomeRequestServiceFactory;
import com.example.z_home.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

class CategoryPresenter extends BasePresenter<CategoryView> {
    private int SelcetParent=0;
    private SimpleRecyclerViewAdapter simpleRecyclerViewAdapter1;   //这个是父类的adapter
    private SimpleRecyclerViewAdapter simpleRecyclerViewAdapter2;    //子类的adapter
    private List<Disposable> disposables;
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        disposables=new ArrayList<>();
        mvpView.getInclude_Title_Text().setText("商品分类");
        mvpView.getInclude_Title_Close().setOnClickListener(view -> {
            mvpView.getThisActivity().finish();
        });

        setCategory();

    }
    /**关闭网络请求**/
    @Override
    public void CloseRequest() {
        for (Disposable disposable:disposables){
            disposable.dispose();
        }
    }

    /**请求分类数据**/
    private void  setCategory(){
        LottieDialog.setDialogWindow(mvpView.getActivityContext());
        HomeRequestServiceFactory.CategoryFind(new RequestObserver.RequestObserverNext<AllDataState<CategoryList>>() {
            @Override
            public void Next(AllDataState<CategoryList> o) {
                if (o.isSuccess()){
                    CategoryList categoryLists=o.getData();
                    /**父类数据**/
                    setRecycler_Parent(categoryLists.getItemCategories());
                }else {
                    SimpleUtils.setToast(o.getMessage());
                }
            }

            @Override
            public void onError() {
                setRecycler_Parent(null);
                mvpView.getCategory_Child().setVisibility(View.GONE);
                /**点击重新请求**/
                simpleRecyclerViewAdapter1.getEmptyView().setOnClickListener(v1 -> {
                    setCategory();
                });
            }

            @Override
            public void getDisposable(Disposable d) {
                disposables.add(d);
            }
        },mvpView.getActivityContext());
    }
    /**设置子布局**/
    private void setRecycler_Child(List<CategoryList.ItemCategoriesBeanX.ItemCategoriesBean> categoriesBeans){
        /**大类下面的子类**/
        simpleRecyclerViewAdapter2=new SimpleRecyclerViewAdapter(R.layout.category_recycler_item2,
                mvpView.getActivityContext(),categoriesBeans, (helper, item) -> {

            /**子类的名字设置**/
            helper.setText(R.id.Category_Child_Text,((CategoryList.ItemCategoriesBeanX.ItemCategoriesBean)item).getName());
            GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.z_category_1,helper.getView(R.id.Category_Child_Image));
        });
        mvpView.getCategory_Child().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,3));
        mvpView.getCategory_Child().setAdapter(simpleRecyclerViewAdapter2);
    }
    /**设置分布局**/
    private void setRecycler_Parent(List<CategoryList.ItemCategoriesBeanX> categoryLists){
        simpleRecyclerViewAdapter1=new SimpleRecyclerViewAdapter(R.layout.category_recycler_item1,
                mvpView.getActivityContext(), categoryLists, (helper, item) -> {


            /**父类的名字**/
            helper.setText(R.id.Category_Parent_Text,((CategoryList.ItemCategoriesBeanX)item).getName());
            /**选中背景色**/
            if (helper.getAdapterPosition()==SelcetParent){
                helper.getView(R.id.Category_Parent_Text).setBackgroundColor(Color.parseColor("#25C6FC"));
            }else {
                helper.getView(R.id.Category_Parent_Text).setBackgroundColor(Color.parseColor("#ffffff"));
            }
            /**点击事件  更新子类内容**/
            helper.getView(R.id.Category_Parent_Text).setOnClickListener(view -> {
                view.setBackgroundColor(Color.parseColor("#25C6FC"));
                setRecycler_Child( categoryLists.get(helper.getAdapterPosition()).getItemCategories());
                SelcetParent=helper.getAdapterPosition();
                mvpView.getCategory_Parent().getAdapter().notifyDataSetChanged();
            });


        });
        /**设置父类item显示**/
        mvpView.getCategory_Parent().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
        mvpView.getCategory_Parent().setAdapter(simpleRecyclerViewAdapter1);


        if(categoryLists!=null){
            mvpView.getCategory_Child().setVisibility(View.VISIBLE);
            /**设置子类显示**/
            setRecycler_Child(categoryLists.get(0).getItemCategories());
        }
    }
}
