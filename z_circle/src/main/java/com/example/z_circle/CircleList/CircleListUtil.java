package com.example.z_circle.CircleList;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.z_circle.Model.CircleList;
import com.example.z_circle.R;
import com.example.z_common.Custom.Dialog.DialogUtil;
import com.example.z_common.GlideUtil;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwei on 2019/8/31.
 * 这个就是设置文字列表Recycler的个工具类
 *
 */

public class CircleListUtil{
    /**文章数据**/
    public static void setRecycler_Article(Activity activity,RecyclerView recyclerView){
        List<CircleList> circleLists=new ArrayList<>();
        circleLists.add(new CircleList(R.mipmap.a2,"","小瞎子爱上了一位美丽的山里姑娘，还把初吻给了她，姑娘嫁了别人。老瞎子的师傅在临终前告诉他有一张复明药方，只要弹断一千根琴弦，这张药方就能让他的眼睛看到世界。","爸爸爸爸",""));
        circleLists.add(new CircleList(R.mipmap.a4,"","第二，爱情与信念的两难，苦行僧是爱自己的妻子的，世间安得两全法，不负如来不负卿？","爸爸爸爸",""));
        circleLists.add(new CircleList(R.mipmap.a3,"","贫寒学子柳生入京赶考，在一座大宅的阁楼邂逅了富家小姐惠。屌丝逆袭白富美的桥断不回出现在余华的小说里。在故事的五分之二处，一副余华氏暴力美学徐徐展开。","爸爸爸爸",""));
        circleLists.add(new CircleList(R.mipmap.a1,"","孔乙己是站着喝酒而穿长衫的唯一的人。穿的虽是长衫，可是又脏又破，似乎十多年没有洗。","爸爸爸爸",""));
        circleLists.add(new CircleList(R.mipmap.a6,"","他也真怪，即使在最睛朗的日子，也穿上雨鞋，带上雨伞，而且一定穿着暖和的棉大衣。他总是把雨伞装在套子里，把表放在一个灰色的鹿皮套子里；就连削铅笔的小刀也是装在一个小套子里的。他的脸也好像蒙着套子，因为他老是把它藏在竖起的衣领里。","爸爸爸爸爸爸爸爸爸爸爸爸",""));
        circleLists.add(new CircleList(R.mipmap.a5,"","女主人公德拉和她的丈夫詹姆斯都很贫穷。他们都有一件最珍贵的礼物。圣诞节到来之际，他们为了给对方买一件与之相配的礼物，不惜卖掉了自己珍贵的东西。而他们所准备的礼物此时也失去了意义。","爸爸爸爸",""));
        circleLists.add(new CircleList(R.mipmap.a5,"","女主人公德拉和她的丈夫詹姆斯都很贫穷。他们都有一件最珍贵的礼物。圣诞节到来之际，他们为了给对方买一件与之相配的礼物，不惜卖掉了自己珍贵的东西。而他们所准备的礼物此时也失去了意义。","爸爸爸爸",""));
        circleLists.add(new CircleList(R.mipmap.a5,"","女主人公德拉和她的丈夫詹姆斯都很贫穷。他们都有一件最珍贵的礼物。圣诞节到来之际，他们为了给对方买一件与之相配的礼物，不惜卖掉了自己珍贵的东西。而他们所准备的礼物此时也失去了意义。","爸爸爸爸",""));

        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(
                R.layout.circlerecyclerlist_fragment_item, activity,circleLists, (helper, item) -> {
            GlideUtil.displayImage(activity,((CircleList)item).getImage(),helper.getView(R.id.CircleRecyclerList_Recycler_Item_Image));
            helper.setText(R.id.CircleRecyclerList_Recycler_Item_Context,((CircleList)item).getBriefContent());
            helper.setText(R.id.CircleRecyclerList_Recycler_Item_Name,((CircleList)item).getName());
            /**头像设置**/
            Drawable drawable=activity.getResources().getDrawable(R.mipmap.circle_userimage);
            drawable.setBounds(0,0,30,35);//第一0是距左边距离，第二0是距上边距离，30、35分别是长宽
            ((TextView)helper.getView(R.id.CircleRecyclerList_Recycler_Item_Name)).setCompoundDrawables(drawable,null,null,null);//只放左边
            /**图标设置**/
            SimpleUtils.setViewTypeface((helper.getView(R.id.CircleRecyclerList_Recycler_Item_Praise)),"\ue9cf 点赞11");
        });

        recyclerView.setAdapter(simpleRecyclerViewAdapter);
        recyclerView.setLayoutManager(SimpleUtils.getRecyclerLayoutManager(2,false));
    }

    /**草稿数据**/
    public static void setRecycler_Draft(Activity activity,RecyclerView recyclerView){
        List<CircleList> circleLists=new ArrayList<>();
        circleLists.add(new CircleList(R.mipmap.a2,"","小瞎子爱上了一位美丽的山里姑娘，还把初吻给了她，姑娘嫁了别人。老瞎子的师傅在临终前告诉他有一张复明药方，只要弹断一千根琴弦，这张药方就能让他的眼睛看到世界。","08-08",""));
        circleLists.add(new CircleList(R.mipmap.a4,"","第二，爱情与信念的两难，苦行僧是爱自己的妻子的，世间安得两全法，不负如来不负卿？","08-08",""));
        circleLists.add(new CircleList(R.mipmap.a3,"","贫寒学子柳生入京赶考，在一座大宅的阁楼邂逅了富家小姐惠。屌丝逆袭白富美的桥断不回出现在余华的小说里。在故事的五分之二处，一副余华氏暴力美学徐徐展开。","08-08",""));
        circleLists.add(new CircleList(R.mipmap.a1,"","孔乙己是站着喝酒而穿长衫的唯一的人。穿的虽是长衫，可是又脏又破，似乎十多年没有洗。","08-08",""));
        circleLists.add(new CircleList(R.mipmap.a6,"","他也真怪，即使在最睛朗的日子，也穿上雨鞋，带上雨伞，而且一定穿着暖和的棉大衣。他总是把雨伞装在套子里，把表放在一个灰色的鹿皮套子里；就连削铅笔的小刀也是装在一个小套子里的。他的脸也好像蒙着套子，因为他老是把它藏在竖起的衣领里。","08-08",""));
        circleLists.add(new CircleList(R.mipmap.a5,"","女主人公德拉和她的丈夫詹姆斯都很贫穷。他们都有一件最珍贵的礼物。圣诞节到来之际，他们为了给对方买一件与之相配的礼物，不惜卖掉了自己珍贵的东西。而他们所准备的礼物此时也失去了意义。","08-08",""));
        circleLists.add(new CircleList(R.mipmap.a5,"","女主人公德拉和她的丈夫詹姆斯都很贫穷。他们都有一件最珍贵的礼物。圣诞节到来之际，他们为了给对方买一件与之相配的礼物，不惜卖掉了自己珍贵的东西。而他们所准备的礼物此时也失去了意义。","08-08",""));
        circleLists.add(new CircleList(R.mipmap.a5,"","女主人公德拉和她的丈夫詹姆斯都很贫穷。他们都有一件最珍贵的礼物。圣诞节到来之际，他们为了给对方买一件与之相配的礼物，不惜卖掉了自己珍贵的东西。而他们所准备的礼物此时也失去了意义。","08-08",""));

        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter(
                R.layout.circlerecyclerlist_fragment_item, activity,circleLists, (helper, item) -> {
            GlideUtil.displayImage(activity,((CircleList)item).getImage(),helper.getView(R.id.CircleRecyclerList_Recycler_Item_Image));
            helper.setText(R.id.CircleRecyclerList_Recycler_Item_Context,((CircleList)item).getBriefContent());
            helper.setText(R.id.CircleRecyclerList_Recycler_Item_Name,((CircleList)item).getName());
            /**图标设置**/
            SimpleUtils.setViewTypeface((helper.getView(R.id.CircleRecyclerList_Recycler_Item_Praise)),"\ue872");
            helper.addOnClickListener(R.id.CircleRecyclerList_Recycler_Item_Praise);
        });
        recyclerView.setAdapter(simpleRecyclerViewAdapter);
        recyclerView.setLayoutManager(SimpleUtils.getRecyclerLayoutManager(2,false));
        simpleRecyclerViewAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            new DialogUtil().show(R.mipmap.prompt,"是否删除草稿","确定", new DialogUtil.DialogButtonListener(){

                @Override
                public void sure() {
                    circleLists.remove(position);
                    simpleRecyclerViewAdapter.notifyDataSetChanged();
                }

                @Override
                public void cancel() {

                }
            });
        });
    }
}
