package com.example.z_login_register.LR.ViewPage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_common.Custom.Dialog.DialogUtil;
import com.example.z_common.Model.AllDataState;
import com.example.z_common.NET.RequestObserver;
import com.example.z_common.Util.SimpleUtils;
import com.example.z_login_register.Net.LRRequestServiceFactory;
import com.example.z_login_register.QQUiListener;
import com.example.z_login_register.R;
import com.tencent.tauth.Tencent;

import io.reactivex.disposables.Disposable;

/**
 * Created by zengwei on 2019/8/11.
 * 手机界面
 */

public class LRViewPageFragment_p extends Fragment {
    private EditText LR_Phone;
    private TextView LR_Submit;
    private LREvent lrEvent;
    private ImageView QQ_Login;
    private Tencent tencent;
    private String qqOpenid;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.p_fragment,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tencent = Tencent.createInstance("101770446", this.getActivity());
        LR_Phone=view.findViewById(R.id.LR_Phone);
        LR_Submit=view.findViewById(R.id.LR_Submit);
        QQ_Login=view.findViewById(R.id.QQ_Login);
        SimpleUtils.hideInputManager(getActivity(),LR_Phone);
        /**发送验证码 登陆按钮**/
        LR_Submit.setOnClickListener(v -> {
            //跳转到验证码输入界面
            if (lrEvent!=null){
                if (!LR_Phone.getText().toString().trim().equals("")){
                    LRRequestServiceFactory.validateCode(new RequestObserver.RequestObserverNext<AllDataState>() {
                        @Override
                        public void Next(AllDataState o) {
                            if (o.isSuccess()){
                                SimpleUtils.setToast("验证码已发送");
                                lrEvent.Listening();
                                SimpleUtils.hideInputManager(getActivity(),LR_Phone);
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
                    },LR_Phone.getText().toString().trim());
                }else {
                    SimpleUtils.setToast("手机号不允许为空");
                }

            }else {

            }
        });

        /**QQ登陆**/
        QQ_Login.setOnClickListener(v->{
            Tencent.createInstance("101770446",getActivity());
            tencent.login(getActivity(),"all",new QQUiListener(new QQUiListener.QQListener() {
                @Override
                public void onComplete(String openid) {
                    setQqOpenid(openid);
                    LRRequestServiceFactory.qqLogin(new RequestObserver.RequestObserverNext<AllDataState>() {
                        @Override
                        public void Next(AllDataState o) {
                            if (o.isSuccess()){
                                SimpleUtils.setToast("登录成功");
                                getActivity().finish();
                            }else {
                                new DialogUtil().showAlert(R.mipmap.prompt,"第三方账号未绑定手机，请用手机号登录", null);
                            }
                        }

                        @Override
                        public void onError() {

                        }

                        @Override
                        public void getDisposable(Disposable d) {

                        }
                    },openid);
                }

                @Override
                public void onError() {
                    SimpleUtils.setToast("QQ登录失败");
                }
            }));
        });
    }

    public LREvent getLrEvent() {
        return lrEvent;
    }

    public void setLrEvent(LREvent lrEvents) {
        this.lrEvent = lrEvents;
    }

    public EditText getLR_Phone() {
        return LR_Phone;
    }

    public void setLR_Phone(EditText LR_Phone) {
        this.LR_Phone = LR_Phone;
    }

    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid;
    }
}
