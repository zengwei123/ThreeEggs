package com.example.z_circle.Details;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseActivity;
import com.example.z_base.BasePresenter;
import com.example.z_circle.CircleList.CircleListFragment;
import com.example.z_circle.Comments.CommentsFragment;
import com.example.z_circle.Model.CircleComment;
import com.example.z_circle.Model.CircleDetails;
import com.example.z_circle.Net.CircleRequestServiceFactory;
import com.example.z_circle.R;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.RoutePage.RouterPageFragment;
import com.example.z_common.Util.GlideUtil;
import com.example.z_common.Util.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;

import java.util.Arrays;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by zengwei on 2019/9/18.
 */

public class DetailsPresenter extends BasePresenter<DetailsView> implements View.OnClickListener{
    private CircleDetails circleDetails;
    private CircleListFragment fragment;
    private int Details_Comments_Layout_Width=-1;
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        getDetailsMessage();
        Comments_EditText();
        click();
    }

    /**获取圈子详情内容**/
    private void getDetailsMessage(){
        CircleRequestServiceFactory.Detail(new RequestObserver.RequestObserverNext<AllDataState<CircleDetails>>() {
            @Override
            public void Next(AllDataState<CircleDetails> o) {
                circleDetails=o.getData();
                if (circleDetails!=null){
                    setDetailsMessage();
                    setRecommended();
                    getComment(null,1,3);
                    AllComments();
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
        },mvpView.getActivityContext(),mvpView.getRoundId());
    }
    /**详情内容设置**/
    private void setDetailsMessage(){
        //用户名与头像
        mvpView.getDetails_UserName().setText(" "+circleDetails.getRound().getUserName());
        GlideUtil.drawableUrlImage(mvpView.getThisActivity(),68, circleDetails.getRound().getHandImg(),  mvpView.getDetails_UserName(),true,false);
        //设置轮播图
        setBanner(Arrays.asList(circleDetails.getRound().getPosterUrl()));
        //设置标题
        mvpView.getDetails_Title().setText(circleDetails.getRound().getRoundTitle());
        //设置内容
        mvpView.getDetails_Content().setText(circleDetails.getRound().getRoundDesc());
        //设置地址
        mvpView.getDetails_Address().setText(" "+circleDetails.getRound().getAddress());
        GlideUtil.drawableImage(48, R.mipmap.positioning_icon,  mvpView.getDetails_Address(),true);
        //设置日期
        mvpView.getDetails_Time().setText(""+circleDetails.getRound().getCreateTime().split(" ")[0]);
        //判断商品是否又推荐
        if (circleDetails.getRound().getGoods()!=null){
            mvpView.getDetails_Goods_Layout().setVisibility(View.VISIBLE);
            CircleDetails.RoundBean.GoodsBean goodsBean=circleDetails.getRound().getGoods();
            //设置商品的图片
            new GlideUtil().roundAngleImage(mvpView.getThisActivity(),goodsBean.getSmallPic(),  mvpView.getDetails_Goods_Image(),8);
            //设置商品标题
            mvpView.getDetails_Goods_Title().setText(goodsBean.getGoodsName());
            //设置商品价格
            mvpView.getDetails_Goods_Price().setText("￥ "+SimpleUtils.getPrice(goodsBean.getPrice()));
        }else {
            mvpView.getDetails_Goods_Layout().setVisibility(View.GONE);
        }
        //设置标签或者分类
        mvpView.getDetails_Label().setText(circleDetails.getRound().getLabelName());
        //点赞数  是否点赞
        mvpView.getDetails_Praise().setText(" "+circleDetails.getRound().getLikeNum());
        if (circleDetails.getRound().isHasLike()){
            GlideUtil.drawableImage(40,R.mipmap.praise_f_icon,mvpView.getDetails_Praise(),true);
            mvpView.getDetails_Praise().setTextColor(Color.parseColor("#FD404E"));
        }else {
            GlideUtil.drawableImage(40,R.mipmap.praise_9_icon,mvpView.getDetails_Praise(),true);
            mvpView.getDetails_Praise().setTextColor(Color.parseColor("#999999"));
        }
        //收藏数  是否收藏
        mvpView.getDetails_Collection().setText(" "+circleDetails.getRound().getCollectNum());
        if (circleDetails.getRound().isHasCollect()){
            GlideUtil.drawableImage(40,R.mipmap.collection_f_icon,mvpView.getDetails_Collection(),true);
            mvpView.getDetails_Collection().setTextColor(Color.parseColor("#FD404E"));
        }else {
            GlideUtil.drawableImage(40,R.mipmap.collection_9_icon,mvpView.getDetails_Collection(),true);
            mvpView.getDetails_Collection().setTextColor(Color.parseColor("#999999"));
        }

    }
    /**设置轮播图**/
    private void setBanner(List<String> imageUrl){
        mvpView.getDetails_Banner().setAdapter((banner, itemView, model, position) ->{
            ImageView imageView= (ImageView) itemView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            GlideUtil.displayImage(mvpView.getThisActivity(),model,imageView);
        });
        mvpView.getDetails_Banner().setData(imageUrl, null);
    }

    /**获取评论**/
    private void getComment(Context context,int pageNum,int pageSize){
        CircleRequestServiceFactory.Comment(new RequestObserver.RequestObserverNext<AllDataState<CircleComment>>() {
            @Override
            public void Next(AllDataState<CircleComment> o) {
                if (o.isSuccess()){
                    setDetails_CommentsShow_Recycler(o.getData().getPage().getList());
                    /**下面的都是评论数设置**/
                    mvpView.getDetails_CommentsShow_Sum().setText("共"+o.getData().getPage().getTotal()+"条评论");
                    SimpleUtils.setLog(o.getData().toString());

                    mvpView.getDetails_Comments().setText(" "+o.getData().getPage().getTotal());
                    GlideUtil.drawableImage(40,R.mipmap.comments_icon,mvpView.getDetails_Comments(),true);

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
        },context,circleDetails.getRound().getId()+"",0+"",pageNum+"",pageSize+"");
    }
    private void setDetails_CommentsShow_Recycler(List<CircleComment.PageBean.ListBean> listBeans){
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(1,R.layout.comment_recycler_item, mvpView.getActivityContext(), listBeans, (helper, item) -> {
            CircleComment.PageBean.ListBean listBean= (CircleComment.PageBean.ListBean) item;

            SimpleUtils.setLog(listBean.toString());
            /**评论用户信息**/
            SimpleUtils.setLog("用户名："+listBean.getCommentUserName());
            helper.setText(R.id.Comment_UserName,listBean.getCommentUserName());
            /**头像**/
            GlideUtil.roundImage(mvpView.getThisActivity(),listBean.getCommentHeadImg(),helper.getView(R.id.Comment_UserHard));
            /**评论时间**/
            helper.setText(R.id.Comment_Time,listBean.getCreateTime());
            /**评论内容**/
            helper.setText(R.id.Comment_Content,SimpleUtils.unicode2String(listBean.getContent()));
            /**点赞数**/
            helper.setText(R.id.Comment_Praise,listBean.getLikeNum());
            /**是否点赞**/
            if (listBean.isHasLike()){
                ((TextView)helper.getView(R.id.Comment_Praise)).setTextColor(0XffFD404E);
                GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.praise_f_icon, helper.getView(R.id.Comment_Praise_image));
            }else {
                ((TextView)helper.getView(R.id.Comment_Praise)).setTextColor(0Xff999999);
                GlideUtil.displayImage(mvpView.getThisActivity(),R.mipmap.praise_9_icon, helper.getView(R.id.Comment_Praise_image));
            }

            /**评论的评论数**/
            if (listBean.getCommentNum().equals("0")){
                helper.getView(R.id.Comment_CommentSum).setVisibility(View.GONE);
            }else {
                helper.setText(R.id.Comment_CommentSum,listBean.getCommentNum()+"条回复");
            }
            helper.addOnClickListener(R.id.Comment_ClickPraise);
        });
        mvpView.getDetails_CommentsShow_Recycler().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getDetails_CommentsShow_Recycler().setLayoutManager(SimpleUtils.getNoScrollRecyclerLayoutManager(true,0));
        simpleRecyclerViewAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            int vid=view.getId();
            if (vid == R.id.Comment_ClickPraise) { //评论点赞
                TextView textView=view.findViewById(R.id.Comment_Praise);
                ImageView imageView=view.findViewById(R.id.Comment_Praise_image);
                CircleRequestServiceFactory.Comment_Like(mvpView.getDetails_Layout(),
                        mvpView.getThisActivity(),
                        listBeans.get(position).getId(),
                        imageView,
                        textView
                        );
            } else if (vid == R.id.Comment_CommentSum) {

            }
        });
    }

    /**相关推荐**/
    private void setRecommended(){
        mvpView.getDetails_Refresh().setText(" 换一换");
        GlideUtil.drawableImage(40,R.mipmap.refresh_icon,mvpView.getDetails_Refresh(),true);

        /**添加推荐布局内容**/
        FragmentTransaction fragmentTransaction= BaseActivity.getInstance().getSupportFragmentManager().beginTransaction();
        fragment= (CircleListFragment) RouterPageFragment.grtCircleList(2,circleDetails.getRound().getLabelId()+"");
        fragmentTransaction.add(R.id.Details_FrameLayout, fragment,CircleListFragment.class.getName()).commit();
    }

    /**下面评论条的东西**/
    private void Comments_EditText(){
        SimpleUtils.setViewTypeface(mvpView.getDetails_Comments_EditText(),"");
        mvpView.getDetails_Comments_EditText().setHint("\ue254 说点什么");
        mvpView.getDetails_Comments_EditText().setRightPicOnclickListener(editText -> {
            removeEditText();
        });
        mvpView.getDetails_Comments_EditText().setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                // 此处为得到焦点时的处理内容
                EditTextAnim(true);
            }
        });
    }
    public void EditTextAnim(boolean b){
        mvpView.getDetails_Comments_TextBut().setVisibility(View.VISIBLE);

        ValueAnimator valueAnimator=ValueAnimator.ofInt(1,100);     //一个区间
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            IntEvaluator intEvaluator=new IntEvaluator();   //一个估值器
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //动画过程的监听方法
                float f=valueAnimator.getAnimatedFraction();   //获取当前整个动画所占比例
                 if (Details_Comments_Layout_Width==-1){
                     ViewGroup.LayoutParams  layoutParams= mvpView.getDetails_Comments_Layout().getLayoutParams();
                     Details_Comments_Layout_Width=mvpView.getDetails_Comments_Layout().getMeasuredWidth();
                 }
                if (b){
                    ViewGroup.LayoutParams  layoutParams= mvpView.getDetails_Comments_Layout().getLayoutParams();
                    layoutParams.width=intEvaluator.evaluate(f,mvpView.getDetails_Comments_Layout().getMeasuredWidth(),0);    //按照当前比例计算出所占的值   f-比例   0-初始值  600-结束值
                    mvpView.getDetails_Comments_Layout().setLayoutParams(layoutParams);
                }else {
                    ViewGroup.LayoutParams  layoutParams= mvpView.getDetails_Comments_Layout().getLayoutParams();
                    layoutParams.width=intEvaluator.evaluate(f,0,Details_Comments_Layout_Width);    //按照当前比例计算出所占的值   f-比例   0-初始值  600-结束值
                    mvpView.getDetails_Comments_Layout().setLayoutParams(layoutParams);
                }
            }
        });
        valueAnimator.setDuration(400).start();   //设置过渡时间  启动
    }


    private void click(){
        mvpView.getDetails_Close().setOnClickListener(this);
        mvpView.getDetails_Comments_TextBut().setOnClickListener(this);
        mvpView.getDetails_Refresh().setOnClickListener(this);
        mvpView.getDetails_Praise().setOnClickListener(this);
        mvpView.getDetails_Collection().setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.Details_Comments_TextBut) {  //评论发布按钮
            if (mvpView.getDetails_Comments_EditText().getText().toString().trim().equals("")){
                SimpleUtils.setToast(mvpView.getDetails_Comments_EditText().getText().toString().trim());
                return;
            }
            String str=SimpleUtils.stringToUnicode(mvpView.getDetails_Comments_EditText().getText().toString());
            CircleRequestServiceFactory.Comment_Save(
                    new RequestObserver.RequestObserverNext<AllDataState>() {
                        @Override
                        public void Next(AllDataState o) {
                            if (o.isSuccess()){
                                removeEditText();
                            }
                            SimpleUtils.setToast(o.getMessage());
                        }

                        @Override
                        public void onError() {

                        }

                        @Override
                        public void getDisposable(Disposable d) {

                        }
                    },mvpView.getActivityContext(), str, circleDetails.getRound().getId() + "", 0+"");
        }else if(i == R.id.Details_Close){  //关闭按钮
            mvpView.getThisActivity().finish();
        }else if (i == R.id.Details_Refresh){  //换一换
            fragment.categoryName(circleDetails.getRound().getLabelId()+"");
        }else if(i == R.id.Details_Praise){   //点赞按钮
            CircleRequestServiceFactory.Like(mvpView.getDetails_Layout(),circleDetails.getRound().getId()+"",mvpView.getDetails_Praise());
        }else if(i == R.id.Details_Collection){   //收藏按钮
            CircleRequestServiceFactory.Collect(mvpView.getDetails_Layout(),circleDetails.getRound().getId()+"",mvpView.getDetails_Collection());
        }
    }
    /**关闭评论输入框**/
    private void removeEditText(){
        EditTextAnim(false);
        mvpView.getDetails_Comments_TextBut().setVisibility(View.GONE);
        ((InputMethodManager)mvpView.getThisActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(mvpView.getThisActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        mvpView.getDetails_Comments_EditText().setFocusable(false);
        mvpView.getDetails_Comments_EditText().setFocusableInTouchMode(true);
        mvpView.getDetails_Comments_EditText().setText("");
    }

    /**全部评论**/
    private void AllComments(){
        FragmentTransaction fragmentTransaction= BaseActivity.getInstance().getSupportFragmentManager().beginTransaction();
        CommentsFragment  fragment= (CommentsFragment) RouterPageFragment.grtCommentsFragment(circleDetails.getRound().getId()+"",0+"");
        fragmentTransaction.add(R.id.Details_Comments_FrameLayout, fragment,CommentsFragment.class.getName()).commit();
    }
}