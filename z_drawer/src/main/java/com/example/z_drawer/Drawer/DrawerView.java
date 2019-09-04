package com.example.z_drawer.Drawer;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.z_base.BaseView;
import com.example.z_common.Main_Me_Listener;

/**
 * Created by zengwei on 2019/9/3.
 */

public interface DrawerView extends BaseView{
    TextView getDrawer_ExitBut();
    RecyclerView getDrawer_RecyclerView();


    Main_Me_Listener getMain_Me_Listener();
    void setMain_Me_Listener(Main_Me_Listener m);
}
