package com.example.z_my.UserEditor;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_base.MvpActivity;
import com.example.z_my.R;

/**
 * Created by zengwei on 2019/9/3.
 */
@Route(path = "/Me/UserEditorActivity")
public class UserEditorActivity extends MvpActivity<UserEditorPresenter> implements UserEditorView{
    private ImageView Include_Title_Close;
    private TextView Include_Title_Text;
    private RecyclerView UserEditor_Recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usereditor_layout);
        mvpPresenter.attachView(this);
        getViews();
        mvpPresenter.init();
    }
    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public Activity getThisActivity() {
        return this;
    }

    @Override
    protected UserEditorPresenter createPresenter() {
        return new UserEditorPresenter();
    }

    @Override
    public void getViews() {
        Include_Title_Close=findViewById(R.id.Include_Title_Close);
        Include_Title_Text=findViewById(R.id.Include_Title_Text);
        UserEditor_Recycler=findViewById(R.id.UserEditor_Recycler);
    }

    @Override
    public ImageView getInclude_Title_Close() {
        return Include_Title_Close;
    }

    @Override
    public TextView getInclude_Title_Text() {
        return Include_Title_Text;
    }
    @Override
    public RecyclerView getUserEditor_Recycler() {
        return UserEditor_Recycler;
    }
}
