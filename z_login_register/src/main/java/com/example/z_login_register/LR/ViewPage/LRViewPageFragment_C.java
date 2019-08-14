package com.example.z_login_register.LR.ViewPage;

import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.z_common.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapterCallback;
import com.example.z_login_register.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zengwei on 2019/8/11.
 * 验证码界面
 */

public class LRViewPageFragment_C extends Fragment {
    private EditText LR_code_1;
    private EditText LR_code_2;
    private EditText LR_code_3;
    private EditText LR_code_4;

    private RecyclerView LR_code_keyboard;

    private int codeindex=0;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.c_fragment,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LR_code_1=view.findViewById(R.id.LR_code_1);
        LR_code_2=view.findViewById(R.id.LR_code_2);
        LR_code_3=view.findViewById(R.id.LR_code_3);
        LR_code_4=view.findViewById(R.id.LR_code_4);
        LR_code_keyboard=view.findViewById(R.id.LR_code_keyboard);
        List<String> strings= Arrays.asList("9","8","7","6","5","4","3","2","1","C","0","BACK");

        SimpleRecyclerViewAdapter simpleRecyclerViewAdapter=new SimpleRecyclerViewAdapter( R.layout.c_recycler_item,getActivity(),strings , (helper, item) -> {
            helper.setText(R.id.C_Recycler_Item_Text, (String) item);
        });
        LR_code_keyboard.setAdapter(simpleRecyclerViewAdapter);
        LR_code_keyboard.setLayoutManager(SimpleUtils.getRecyclerLayoutManager(false,3));
        simpleRecyclerViewAdapter.setOnItemClickListener((adapter, view1, position) -> {
            if (position!=9&&position!=11){
                if (LR_code_1.getText().toString().equals("")){
                    LR_code_1.setText(strings.get(position));
                    LR_code_1.setBackground(getActivity().getDrawable(R.drawable.edittext_style1));
                    LR_code_2.setBackground(getActivity().getDrawable(R.drawable.edittext_style));
                    codeindex=1;
                }else if (LR_code_2.getText().toString().equals("")){
                    LR_code_2.setText(strings.get(position));
                    LR_code_2.setBackground(getActivity().getDrawable(R.drawable.edittext_style1));
                    LR_code_3.setBackground(getActivity().getDrawable(R.drawable.edittext_style));
                    codeindex=2;
                }else if (LR_code_3.getText().toString().equals("")){
                    LR_code_3.setText(strings.get(position));
                    LR_code_3.setBackground(getActivity().getDrawable(R.drawable.edittext_style1));
                    LR_code_4.setBackground(getActivity().getDrawable(R.drawable.edittext_style));
                    codeindex=3;
                }else if (LR_code_4.getText().toString().equals("")){
                    LR_code_4.setText(strings.get(position));
                    LR_code_4.setBackground(getActivity().getDrawable(R.drawable.edittext_style1));
                    codeindex=4;
                }
            }else {
                LR_code_1.setBackground(getActivity().getDrawable(R.drawable.edittext_style1));
                LR_code_2.setBackground(getActivity().getDrawable(R.drawable.edittext_style1));
                LR_code_3.setBackground(getActivity().getDrawable(R.drawable.edittext_style1));
                LR_code_4.setBackground(getActivity().getDrawable(R.drawable.edittext_style1));
                if (position==9){
                    LR_code_1.setText("");
                    LR_code_2.setText("");
                    LR_code_3.setText("");
                    LR_code_4.setText("");
                    LR_code_1.setBackground(getActivity().getDrawable(R.drawable.edittext_style));
                }else {
                    switch (codeindex){
                        case 1:LR_code_1.setText("");codeindex=0;  LR_code_1.setBackground(getActivity().getDrawable(R.drawable.edittext_style));break;
                        case 2:LR_code_2.setText("");codeindex=1;  LR_code_2.setBackground(getActivity().getDrawable(R.drawable.edittext_style));break;
                        case 3:LR_code_3.setText("");codeindex=2;  LR_code_3.setBackground(getActivity().getDrawable(R.drawable.edittext_style));break;
                        case 4:LR_code_4.setText(""); codeindex=3;  LR_code_4.setBackground(getActivity().getDrawable(R.drawable.edittext_style));break;
                    }

                }
            }
        });
    }
}
