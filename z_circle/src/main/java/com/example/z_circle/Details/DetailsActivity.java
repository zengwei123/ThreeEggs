package com.example.z_circle.Details;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_base.MvpActivity;
import com.example.z_circle.R;
import com.example.z_common.Custom.WanEditText;
import com.example.z_common.Util.SimpleUtils;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by zengwei on 2019/9/18.
 * 圈子详情
 */
@Route(path = "/Circle/DetailsActivity")
public class DetailsActivity extends MvpActivity<DetailsPresenter>implements DetailsView {
    private ImageView Details_Close;  //返回按钮
    private ImageView Details_Share;   //分享按钮
    private TextView Details_UserName;  //用户明
    private BGABanner Details_Banner;  //轮播图
    private TextView Details_Title; //文章标题
    private TextView Details_Content;  //内容
    private TextView Details_Address;//地址
    private TextView Details_Time;  //日期

    private RelativeLayout Details_Goods_Layout;  //推荐商品的布局
    private ImageView Details_Goods_Image; //分享商品的图片
    private TextView Details_Goods_Title; //标题
    private TextView Details_Goods_Price;//价格

    private TextView Details_Label;  //分类/标签

    private RecyclerView Details_CommentsShow_Recycler;//评论展示数据列表
    private TextView Details_CommentsShow_Sum;  //评论数量
    private TextView Details_CommentsShow_But; //评论展开按钮

    private TextView Details_Refresh;   //相关推荐刷新按钮
    private RecyclerView Details_Replacement;  //换一换

    private TextView Details_Praise;// 全部点赞
    private TextView Details_Collection;// 全部收藏

    private TextView Details_Comments;// 全部评论
    private WanEditText Details_Comments_EditText;  //评论
    private TextView Details_Comments_TextBut;  //评论发布按钮
    private RelativeLayout Details_Comments_EditTextLayout;  //评论editext 布局

    private LinearLayout Details_Comments_Layout;   //点赞 收藏 评论数的布局

    private RelativeLayout Details_Layout;
    @Autowired
    public String roundId;  //获取圈子的文章id
    @Autowired
    public boolean isAdd;   //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**启动页的图片设置为空**/
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        ARouter.getInstance().inject(this);
        mvpPresenter.attachView(this);
        getViews();
        mvpPresenter.init();
        if(isAdd){
            ((BaseActivity)getThisActivity()).addActivity(this);
        }
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
    protected DetailsPresenter createPresenter() {
        return new DetailsPresenter();
    }

    @Override
    public void getViews() {
        Details_Close=findViewById(R.id.Details_Close);
        Details_Share=findViewById(R.id.Details_Share);
        Details_UserName=findViewById(R.id.Details_UserName);
        Details_Banner=findViewById(R.id.Details_Banner);
        Details_Title=findViewById(R.id.Details_Title);
        Details_Content=findViewById(R.id.Details_Content);
        Details_Address=findViewById(R.id.Details_Address);
        Details_Time=findViewById(R.id.Details_Time);

        Details_Goods_Layout=findViewById(R.id.Details_Goods_Layout);
        Details_Goods_Image=findViewById(R.id.Details_Goods_Image);
        Details_Goods_Title=findViewById(R.id.Details_Goods_Title);
        Details_Goods_Price=findViewById(R.id.Details_Goods_Price);

        Details_Label=findViewById(R.id.Details_Label);

        Details_CommentsShow_Recycler=findViewById(R.id.Details_CommentsShow_Recycler);
        Details_CommentsShow_But=findViewById(R.id.Details_CommentsShow_But);
        Details_CommentsShow_Sum=findViewById(R.id.Details_CommentsShow_Sum);
        Details_Refresh=findViewById(R.id.Details_Refresh);

        Details_Praise=findViewById(R.id.Details_Praise);
        Details_Collection=findViewById(R.id.Details_Collection);
        Details_Comments=findViewById(R.id.Details_Comments);

        Details_Comments_EditText=findViewById(R.id.Details_Comments_EditText);
        Details_Comments_TextBut=findViewById(R.id.Details_Comments_TextBut);
        Details_Comments_EditTextLayout=findViewById(R.id.Details_Comments_EditTextLayout);
        Details_Comments_Layout=findViewById(R.id.Details_Comments_Layout);

        Details_Layout=findViewById(R.id.Details_Layout);
    }

    @Override
    public ImageView getDetails_Close() {
        return Details_Close;
    }

    @Override
    public ImageView getDetails_Share() {
        return Details_Share;
    }

    @Override
    public TextView getDetails_UserName() {
        return Details_UserName;
    }

    @Override
    public BGABanner getDetails_Banner() {
        return Details_Banner;
    }

    @Override
    public TextView getDetails_Title() {
        return Details_Title;
    }

    @Override
    public TextView getDetails_Content() {
        return Details_Content;
    }

    @Override
    public TextView getDetails_Address() {
        return Details_Address;
    }

    @Override
    public TextView getDetails_Time() {
        return Details_Time;
    }

    @Override
    public RelativeLayout getDetails_Goods_Layout() {
        return Details_Goods_Layout;
    }

    @Override
    public ImageView getDetails_Goods_Image() {
        return Details_Goods_Image;
    }

    @Override
    public TextView getDetails_Goods_Title() {
        return Details_Goods_Title;
    }

    @Override
    public TextView getDetails_Goods_Price() {
        return Details_Goods_Price;
    }

    @Override
    public TextView getDetails_Label() {
        return Details_Label;
    }

    @Override
    public String getRoundId() {
        return roundId;
    }


    @Override
    public RecyclerView getDetails_CommentsShow_Recycler() {
        return Details_CommentsShow_Recycler;
    }

    @Override
    public TextView getDetails_CommentsShow_But() {
        return Details_CommentsShow_But;
    }

    @Override
    public TextView getDetails_CommentsShow_Sum() {
        return Details_CommentsShow_Sum;
    }

    @Override
    public TextView getDetails_Refresh() {
        return Details_Refresh;
    }

    @Override
    public RecyclerView getDetails_Replacement() {
        return Details_Replacement;
    }

    @Override
    public TextView getDetails_Praise() {
        return Details_Praise;
    }

    @Override
    public TextView getDetails_Collection() {
        return Details_Collection;
    }

    @Override
    public TextView getDetails_Comments() {
        return Details_Comments;
    }

    @Override
    public WanEditText getDetails_Comments_EditText() {
        return Details_Comments_EditText;
    }

    @Override
    public TextView getDetails_Comments_TextBut() {
        return Details_Comments_TextBut;
    }

    @Override
    public RelativeLayout getDetails_Comments_EditTextLayout() {
        return Details_Comments_EditTextLayout;
    }

    @Override
    public LinearLayout getDetails_Comments_Layout() {
        return Details_Comments_Layout;
    }

    @Override
    public RelativeLayout getDetails_Layout() {
        return Details_Layout;
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        SimpleUtils.setLog("看看id:"+v.getId()+"---"+R.id.Details_Comments_TextBut);
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = SimpleUtils.getWindowSize(true);
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                mvpPresenter.EditTextAnim(false);
                getDetails_Comments_TextBut().setVisibility(View.GONE);

                //使EditText触发一次失去焦点事件
                v.setFocusable(false);
//                v.setFocusable(true); //这里不需要是因为下面一句代码会同时实现这个功能
                v.setFocusableInTouchMode(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ((BaseActivity)getThisActivity()).finishAllActivity();
    }
}
