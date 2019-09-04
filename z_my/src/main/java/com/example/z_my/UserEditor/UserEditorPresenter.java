package com.example.z_my.UserEditor;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.z_base.BasePresenter;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapterCallback;
import com.example.z_my.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zengwei on 2019/9/3.
 */

public class UserEditorPresenter extends BasePresenter<UserEditorView> {
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        mvpView.getInclude_Title_Close().setOnClickListener(v -> mvpView.getThisActivity().finish());
        mvpView.getInclude_Title_Text().setText("编辑资料");
        setRecycler();
    }

    private void setRecycler(){
        List<String> strings= Arrays.asList("小萝卜兔子头","男","2019-08-09","每当月色降临，天空群星璀璨，我就想起我空空如也的口袋。");
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(R.layout.usereditor_recycler_item, mvpView.getActivityContext(), strings, (SimpleRecyclerViewAdapterCallback) (helper, item) -> {
            switch (helper.getAdapterPosition()){
                case 0:helper.setText(R.id.UserEditor_Recycler_Item_Name,"昵称");break;
                case 1:helper.setText(R.id.UserEditor_Recycler_Item_Name,"性别");break;
                case 2:helper.setText(R.id.UserEditor_Recycler_Item_Name,"生日");break;
                case 3:helper.setText(R.id.UserEditor_Recycler_Item_Name,"个性签名");break;
            }
            helper.setText(R.id.UserEditor_Recycler_Item_Message,(String)item);
        });
        mvpView.getUserEditor_Recycler().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getUserEditor_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
    }
}
