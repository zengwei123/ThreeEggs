package com.example.z_login_register.LR.ViewPage;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.z_base.BaseActivity;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.Util.SharedPreferencesHelper;
import com.example.z_common.Util.SimpleUtils;
import com.example.z_common.UtilRecyclerAdapter.SimpleRecyclerViewAdapter;
import com.example.z_login_register.Net.LRRequestServiceFactory;
import com.example.z_login_register.R;

import java.util.Arrays;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by zengwei on 2019/8/11.
 * 验证码界面
 */

public class LRViewPageFragment_C extends Fragment {
    private EditText LR_code_1;
    private EditText LR_code_2;
    private EditText LR_code_3;
    private EditText LR_code_4;

    private TextView c_code_time;
    private int times=60;

    private String phone="";
    private String qqOpenId="";
    private String weixinOpenId="";
    private RecyclerView LR_code_keyboard;

    private int codeindex=0;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.c_fragment,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        LR_code_1=view.findViewById(R.id.LR_code_1);
        LR_code_2=view.findViewById(R.id.LR_code_2);
        LR_code_3=view.findViewById(R.id.LR_code_3);
        LR_code_4=view.findViewById(R.id.LR_code_4);
        c_code_time=view.findViewById(R.id.c_code_time);
        LR_code_keyboard=view.findViewById(R.id.LR_code_keyboard);
        List<String> strings= Arrays.asList("1","2","3","4","5","6","7","8","9","C","0","BACK");

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

                    String string=LR_code_1.getText().toString().trim()+LR_code_2.getText().toString().trim()+LR_code_3.getText().toString().trim()+LR_code_4.getText().toString().trim();
                    login(string);
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
        c_code_time.setOnClickListener(v->{
            if (!phone.toString().trim().equals("")){
                LRRequestServiceFactory.validateCode(new RequestObserver.RequestObserverNext<AllDataState>() {
                    @Override
                    public void Next(AllDataState o) {
                        if (o.isSuccess()){
                            SimpleUtils.setToast("验证码已发送");
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
                },phone.toString().trim());
            }else {
                SimpleUtils.setToast("手机号不允许为空");
            }
            CountDownTimerStart();
        });
    }

    public void CountDownTimerStart(){
        countDownTimer.start();
    }

    private CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            String value = String.valueOf((int) (millisUntilFinished / 1000));
            c_code_time.setText(value);
        }

        @Override
        public void onFinish() {
            c_code_time.setText("重新获取验证码");
        }
    };

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQqOpenId() {
        return qqOpenId;
    }
    public void setQqOpenId(String qqOpenId) {
        this.qqOpenId = qqOpenId;
    }
    public String getWeixinOpenId() {
        return weixinOpenId;
    }
    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }

    private void login(String code){
        SimpleUtils.setToast(getQqOpenId());
        LRRequestServiceFactory.login(new RequestObserver.RequestObserverNext<AllDataState>() {
            @Override
            public void Next(AllDataState o) {
                if (o.isSuccess()){
                    SimpleUtils.setToast("登陆成功");
                    new SharedPreferencesHelper(BaseActivity.getInstance(),"TOKEN").put("ISLogin",true);
                    getActivity().finish();
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
        },getPhone(),code,getQqOpenId(),getWeixinOpenId());
    }
}
