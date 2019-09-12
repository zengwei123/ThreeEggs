package com.example.z_message.message;

import android.support.v4.app.FragmentActivity;

import com.example.z_base.BasePresenter;
import com.example.z_base.MvpFragment;
import com.example.z_common.SimpleFragmentAdapter;
import com.example.z_message.MessagePage.MessagePageFragment;

import java.util.ArrayList;
import java.util.List;

public class MessagePresenter extends BasePresenter<MessageView> {
    @Override
    public void init() {
        setView();
    }

    @Override
    public void setView() {
        List<MvpFragment> mvpFragments=new ArrayList<>();
        MessagePageFragment messagePageFragment1=new MessagePageFragment();
        messagePageFragment1.MESSAGE_TYPE=0;
        mvpFragments.add(messagePageFragment1);
        MessagePageFragment messagePageFragment2=new MessagePageFragment();
        messagePageFragment1.MESSAGE_TYPE=1;
        mvpFragments.add(messagePageFragment2);
        MessagePageFragment messagePageFragment3=new MessagePageFragment();
        messagePageFragment1.MESSAGE_TYPE=2;
        mvpFragments.add(messagePageFragment3);
        SimpleFragmentAdapter simpleFragmentAdapter=new SimpleFragmentAdapter( ((FragmentActivity)mvpView.getThisActivity()).getSupportFragmentManager(),mvpFragments);
        mvpView.getMessage_ViewPage().setAdapter(simpleFragmentAdapter);

        mvpView.getMessage_TabLayout().setupWithViewPager(mvpView.getMessage_ViewPage());
        mvpView.getMessage_TabLayout().getTabAt(0).setText("消息");
        mvpView.getMessage_TabLayout().getTabAt(1).setText("赞与收藏");
        mvpView.getMessage_TabLayout().getTabAt(2).setText("评论");
    }

    @Override
    public void CloseRequest() {

    }
}
