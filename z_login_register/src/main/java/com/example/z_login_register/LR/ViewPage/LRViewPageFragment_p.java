package com.example.z_login_register.LR.ViewPage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.z_login_register.R;

/**
 * Created by zengwei on 2019/8/11.
 * 手机界面
 */

public class LRViewPageFragment_p extends Fragment {
    private EditText LR_Phone;
    private Button LR_Submit;
    private LREvent lrEvent;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.p_fragment,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LR_Phone=view.findViewById(R.id.LR_Phone);
        LR_Submit=view.findViewById(R.id.LR_Submit);

        /**发送验证码 登陆按钮**/
        LR_Submit.setOnClickListener(v -> {
            //跳转到验证码输入界面
            if (lrEvent!=null){
                lrEvent.Listening();
            }else {
                Toast.makeText(getContext(), "曹乃的那发", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public LREvent getLrEvent() {
        return lrEvent;
    }

    public void setLrEvent(LREvent lrEvents) {
        this.lrEvent = lrEvents;
    }
}
