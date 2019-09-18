package com.example.z_circle.Details;

import android.view.View;
import android.widget.ImageView;

import com.example.z_base.BasePresenter;
import com.example.z_circle.Model.CircleDetails;
import com.example.z_circle.Net.CircleRequestServiceFactory;
import com.example.z_circle.R;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.Util.GlideUtil;
import com.example.z_common.Util.SimpleUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by zengwei on 2019/9/18.
 */

public class DetailsPresenter extends BasePresenter<DetailsView> implements View.OnClickListener{
    private CircleDetails circleDetails;
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        click();
        getDetailsMessage();
    }

    /**获取圈子详情内容**/
    private void getDetailsMessage(){
        CircleRequestServiceFactory.Detail(new RequestObserver.RequestObserverNext<AllDataState<CircleDetails>>() {
            @Override
            public void Next(AllDataState<CircleDetails> o) {
                circleDetails=o.getData();
                if (circleDetails!=null){
                    setDetailsMessage();
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

    private void click(){
        mvpView.getDetails_Close().setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.Details_Close) {
        }else if(i == R.id.Details_Close){
            mvpView.getThisActivity().finish();
        }
    }
}
