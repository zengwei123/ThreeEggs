package com.example.z_login_register;

import com.example.z_common.Util.ZwGson;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

/**
 * Created by zengwei on 2019/2/26.
 */

public class QQUiListener implements IUiListener {
    private QQListener qqListener;
    public QQUiListener(QQListener qqListener){
        this.qqListener=qqListener;
    }
    @Override
    public void onComplete(Object o) {
        try {
            String j= ZwGson.Json(o.toString(),"openid");
            qqListener.onComplete(j);
        } catch (Exception e) {
            e.printStackTrace();
            qqListener.onError();
        }
    }

    @Override
    public void onError(UiError uiError) {
        qqListener.onError();
    }

    @Override
    public void onCancel() {
    }
    public interface QQListener{
        void onComplete(String openid);
        void onError();
    }
}
