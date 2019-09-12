package com.example.z_drawer.Drawer;

import com.example.z_base.BasePresenter;
import com.example.z_common.CommonRequestServiceFactory;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.Util.SharedPreferencesHelper;
import com.example.z_common.Util.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_drawer.R;

import java.util.Arrays;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by zengwei on 2019/9/3.
 */

public class DrawerPresenter extends BasePresenter<DrawerView>{
    @Override
    public void init() {
        setRecycler();
        setView();
    }

    @Override
    public void setView() {
        mvpView.getDrawer_ExitBut().setOnClickListener(v -> {
            CommonRequestServiceFactory.logout(new RequestObserver.RequestObserverNext<AllDataState>() {
                @Override
                public void Next(AllDataState o) {
                    if (o.isSuccess()==true){
                        mvpView.getMain_Me_Listener().OpenDrawer();
                        new SharedPreferencesHelper(mvpView.getActivityContext(),"TOKEN").put("ISLogin",false);
                    }else {
                        SimpleUtils.setToast(o.getMessage());
                    }
                }

                @Override
                public void onError() {

                }

                @Override
                public void getDisposable(Disposable d) {

                }
            }, mvpView.getActivityContext());
        });
    }

    private void setRecycler(){
        List<String> strings= Arrays.asList("账号与安全","通知设置","隐私","关于闪姐","电话客服");
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.drawer_fragemnt_item, mvpView.getActivityContext(), strings, (helper, item) -> {
            helper.setText(R.id.Drawer_Fragment_Item_Text, (String) item);
        });
        mvpView.getDrawer_RecyclerView().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getDrawer_RecyclerView().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
    }
}
