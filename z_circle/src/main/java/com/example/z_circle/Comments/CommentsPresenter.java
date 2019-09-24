package com.example.z_circle.Comments;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.z_base.BasePresenter;
import com.example.z_circle.Model.CircleComment;
import com.example.z_circle.Net.CircleRequestServiceFactory;
import com.example.z_circle.R;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.Util.GlideUtil;
import com.example.z_common.Util.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class CommentsPresenter extends BasePresenter<CommentsView> implements View.OnClickListener {
    private int pageNum=1;
    private int pageSize=15;
    private String this_commentsId=null;
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        getCommentsList();
        click();
    }

    private void click(){
        mvpView.getComment_Close().setOnClickListener(this);
        mvpView.getComment_Sorting().setOnClickListener(this);
        mvpView.getComments_TextBut().setOnClickListener(this);
        mvpView.geteComment_UserName_Close().setOnClickListener(this);
    }

    private void getCommentsList(){
        CircleRequestServiceFactory.Comment(new RequestObserver.RequestObserverNext<AllDataState<CircleComment>>() {
            @Override
            public void Next(AllDataState<CircleComment> o) {
                if (o.isSuccess()){
                    setCommentsRecycler(o.getData().getPage().getList());
                    mvpView.getComment_Sum().setText("共"+o.getData().getPage().getTotal()+"条评论");
                    SimpleUtils.setLog(o.getData().toString());
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
        },mvpView.getActivityContext(),mvpView.getRoundId(),mvpView.getComment_id(),pageNum+"",pageSize+"");
    }
    private void setCommentsRecycler(List<CircleComment.PageBean.ListBean> listBeans){
        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(1,R.layout.comment_recycler_item, mvpView.getActivityContext(), listBeans, (helper, item) -> {
            CircleComment.PageBean.ListBean listBean= (CircleComment.PageBean.ListBean) item;
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
            /**评论用户评论按钮**/
            helper.getView(R.id.Comment_But).setVisibility(View.VISIBLE);
            /**评论的评论数**/
            if (listBean.getCommentNum().equals("0")){
                helper.getView(R.id.Comment_CommentSum).setVisibility(View.GONE);
            }else {
                helper.setText(R.id.Comment_CommentSum,listBean.getCommentNum()+"条回复");
            }
            helper.addOnClickListener(R.id.Comment_ClickPraise).addOnClickListener(R.id.Comment_But);


        });
        mvpView.getComment_Recycler().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getComment_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(true,0));
        simpleRecyclerViewAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            //选择回复评论
            if (view.getId()==R.id.Comment_But){
                List<CircleComment.PageBean.ListBean> list=adapter.getData();
                /**显示回复用户布局**/
                mvpView.getComment_UserName_layout().setVisibility(View.VISIBLE);
                mvpView.getComment_UserName().setText("正在回复："+list.get(position).getCommentUserName());  //这里拿到回复的用户名
                //设置需要回复的评论
                this_commentsId=list.get(position).getId();    //需要恢复的评论id
            }
        });
    }



    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.Comment_Close) {

        } else if (i == R.id.Comment_Sorting) {

        }else if(i==R.id.Comments_TextBut){
            if (this_commentsId==null) {
                //如果回复的凭空为0  那么就是回复帖子
                saveComment(mvpView.getRoundId(),null);
            }
            else{
                //否则就是回复用户
                saveComment(mvpView.getRoundId(),this_commentsId);
            }
        }else if (i==R.id.Comment_UserName_Close){
            this_commentsId=null;
            mvpView.getComment_UserName_layout().setVisibility(View.GONE);
        }
    }

    private void saveComment(String RoundId,String commentId){
        SimpleUtils.setLog("RoundId:"+RoundId+"---commentId:"+commentId);
        String str=SimpleUtils.stringToUnicode(mvpView.getComments_EditText().getText().toString());
        CircleRequestServiceFactory.Comment_Save(
                new RequestObserver.RequestObserverNext<AllDataState>() {
                    @Override
                    public void Next(AllDataState o) {
                        if (o.isSuccess()){
                           mvpView.getComments_EditText().setText("");
                        }
                        SimpleUtils.setToast(o.getMessage());
                    }

                    @Override
                    public void onError() {

                    }

                    @Override
                    public void getDisposable(Disposable d) {

                    }
                },mvpView.getActivityContext(), str, RoundId, commentId);
    }

    private SpannableString SelectComment(String string){
        SpannableString span = new SpannableString(string+"#");
        ForegroundColorSpan foregroundColorSpan=new ForegroundColorSpan(mvpView.getActivityContext().getResources().getColor(R.color.CFD404E));
        span.setSpan(foregroundColorSpan,0,string.length()+1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return span;
    }
}
