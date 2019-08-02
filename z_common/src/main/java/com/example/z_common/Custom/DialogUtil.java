package com.example.z_common.Custom;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_base.BaseActivity;
import com.example.z_common.R;
import com.example.z_common.SimpleUtils;

public class DialogUtil {
    private AlertDialog dlg;
    private ImageView ivIcon;
    private TextView tvText;
    private Button btnCancel,btnSure;

    private Context context;
    private int imgResId = 0;
    private String text;
    private DialogButtonListener listener;

    public void show(String text, final DialogButtonListener listener) {
        this.context = BaseActivity.getInstance();
        this.text = text;
        this.listener = listener;
        createDialog();
        setValue();
    }

    public void show( int imgResId, String text, final DialogButtonListener listener) {
        this.context = BaseActivity.getInstance();
        this.text = text;
        this.listener = listener;
        this.imgResId = imgResId;
        createDialog();
        setValue();
    }

    public void show(Context context, String text, final DialogButtonListener listener) {
        this.context = context;
        this.text = text;
        this.listener = listener;
        createDialog();
        setValue();
    }

    public void show(Context context, int imgResId, String text, final DialogButtonListener listener) {
        this.context = context;
        this.text = text;
        this.listener = listener;
        this.imgResId = imgResId;
        createDialog();
        setValue();
    }

    //创建Dialog、初始化控件
    private void createDialog() {
        dlg = new AlertDialog.Builder(context).create();
        dlg.show();
        Window window = dlg.getWindow();
        window.setContentView(R.layout.z_dialog_prompt);
        window.setGravity(Gravity.CENTER);//居中
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//背景透明
        /**设置宽度**/
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = (SimpleUtils.getWindowSize(true)/4)*3;
        lp.gravity = Gravity.CENTER;
        window.setAttributes(lp);

        ivIcon =  window.findViewById(R.id.ivIcon);
        tvText =  window.findViewById(R.id.tvText);
        btnCancel =  window.findViewById(R.id.btnCancel);
        btnSure =  window.findViewById(R.id.btnSure);
    }

    //设置控件值
    private void setValue() {
        if (imgResId != 0) {
            ivIcon.setImageResource(imgResId);
        } else {
            ivIcon.setVisibility(View.GONE);
        }
        tvText.setText(text);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.cancel();
                dlg.dismiss();
            }
        });
        btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.sure();
                dlg.dismiss();
            }
        });
    }

    public interface DialogButtonListener {

        public void sure();//确认键
        public void cancel();//取消键
    }
}
