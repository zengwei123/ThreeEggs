package com.example.z_circle.CircleRecyclerList;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.example.z_base.BasePresenter;
import com.example.z_circle.R;
import com.example.z_common.GlideUtil;
import com.example.z_common.Model.Circle.CircleList;
import com.example.z_common.SimpleRecyclerViewAdapter;
import com.example.z_common.SimpleUtils;

import java.util.ArrayList;
import java.util.List;

public class CircleRecyclerListPresenter extends BasePresenter<CircleRecyclerListView> {
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        List<CircleList> circleLists=new ArrayList<>();
        circleLists.add(new CircleList(R.mipmap.a2,"","小瞎子爱上了一位美丽的山里姑娘，还把初吻给了她，姑娘嫁了别人。老瞎子的师傅在临终前告诉他有一张复明药方，只要弹断一千根琴弦，这张药方就能让他的眼睛看到世界。","爸爸爸爸",""));
        circleLists.add(new CircleList(R.mipmap.a4,"","第二，爱情与信念的两难，苦行僧是爱自己的妻子的，世间安得两全法，不负如来不负卿？","爸爸爸爸",""));
        circleLists.add(new CircleList(R.mipmap.a3,"","贫寒学子柳生入京赶考，在一座大宅的阁楼邂逅了富家小姐惠。屌丝逆袭白富美的桥断不回出现在余华的小说里。在故事的五分之二处，一副余华氏暴力美学徐徐展开。","爸爸爸爸",""));
        circleLists.add(new CircleList(R.mipmap.a1,"","孔乙己是站着喝酒而穿长衫的唯一的人。穿的虽是长衫，可是又脏又破，似乎十多年没有洗。","爸爸爸爸",""));
        circleLists.add(new CircleList(R.mipmap.a6,"","他也真怪，即使在最睛朗的日子，也穿上雨鞋，带上雨伞，而且一定穿着暖和的棉大衣。他总是把雨伞装在套子里，把表放在一个灰色的鹿皮套子里；就连削铅笔的小刀也是装在一个小套子里的。他的脸也好像蒙着套子，因为他老是把它藏在竖起的衣领里。","爸爸爸爸爸爸爸爸爸爸爸爸",""));
        circleLists.add(new CircleList(R.mipmap.a5,"","女主人公德拉和她的丈夫詹姆斯都很贫穷。他们都有一件最珍贵的礼物。圣诞节到来之际，他们为了给对方买一件与之相配的礼物，不惜卖掉了自己珍贵的东西。而他们所准备的礼物此时也失去了意义。","爸爸爸爸",""));
        circleLists.add(new CircleList(R.mipmap.a5,"","女主人公德拉和她的丈夫詹姆斯都很贫穷。他们都有一件最珍贵的礼物。圣诞节到来之际，他们为了给对方买一件与之相配的礼物，不惜卖掉了自己珍贵的东西。而他们所准备的礼物此时也失去了意义。","爸爸爸爸",""));

        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(
                R.layout.circlerecyclerlist_fragment_item, mvpView.getActivityContext(),circleLists, (helper, item) -> {
                    GlideUtil.displayImage(mvpView.getActivityContext(),((CircleList)item).getImage(),helper.getView(R.id.CircleRecyclerList_Recycler_Item_Image));
                    helper.setText(R.id.CircleRecyclerList_Recycler_Item_Context,((CircleList)item).getBriefContent());
                    helper.setText(R.id.CircleRecyclerList_Recycler_Item_Name,((CircleList)item).getName());
                    /**头像设置**/
                    Drawable drawable=mvpView.getActivityContext().getResources().getDrawable(R.mipmap.circle_userimage);
                    drawable.setBounds(0,0,30,35);//第一0是距左边距离，第二0是距上边距离，30、35分别是长宽
                    ((TextView)helper.getView(R.id.CircleRecyclerList_Recycler_Item_Name)).setCompoundDrawables(drawable,null,null,null);//只放左边
                    /**图标设置**/
                    SimpleUtils.setViewTypeface(mvpView.getActivityContext(),((TextView)helper.getView(R.id.CircleRecyclerList_Recycler_Item_Praise)),"\ue9cf 点赞11");
                });

        mvpView.getCircleRecyclerList_Recycler().setAdapter(simpleRecyclerViewAdapter);
        mvpView.getCircleRecyclerList_Recycler().setLayoutManager(SimpleUtils.getRecyclerLayoutManager(2));
    }
}
