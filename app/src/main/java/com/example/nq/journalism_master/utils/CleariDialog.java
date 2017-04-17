package com.example.nq.journalism_master.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nq.journalism_master.R;


public class CleariDialog extends Dialog {

    Button okButton;
    TextView conteTextView;
    TextView titleTextView;
    Button cancelButton;
    String contentStr;
    String titleStr;
    LinearLayout doublebtn;
    LinearLayout onebtn;
    Button knowButton;

    public CleariDialog(Context context, String contentStr) {
        super(context, R.style.NotiDialog);
        this.contentStr = contentStr;
    }

    public CleariDialog(Context context, String title, String contentStr) {
        super(context, R.style.NotiDialog);
        this.contentStr = contentStr;
        this.titleStr = title;
    }

    public CleariDialog(Context context) {
        super(context, R.style.NotiDialog);
    }

    public CleariDialog(Context context, int theme, String contentStr) {
        super(context, theme);
        this.contentStr = contentStr;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.clear_dialog);
        doublebtn = (LinearLayout) this.findViewById(R.id.notice_buttonLayout);
        onebtn = (LinearLayout) this.findViewById(R.id.notice_one_btn_Layout);
        knowButton = (Button) this.findViewById(R.id.notice_know);

        okButton = (Button) this.findViewById(R.id.notice_confirm);
        conteTextView = (TextView) this.findViewById(R.id.notice_content);
        conteTextView.setText(contentStr);
        titleTextView = (TextView) this.findViewById(R.id.notice_title);
        titleTextView.setText(titleStr);

        cancelButton = (Button) this.findViewById(R.id.notice_cancel);
        this.setCanceledOnTouchOutside(false);
//        if (App.getSDKVersion() < 11) {
//            okButton.setBackgroundResource(R.drawable.notidialog_leftbtn_selector);
//            cancelButton.setBackgroundResource(R.drawable.notidialog_rightbtn_selector);
//        }
    }

    // 设置确定按钮事件
    public CleariDialog setPositiveListener(final View.OnClickListener onClick) {
        if (onClick != null) {
            okButton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    CleariDialog.this.dismiss();
                    onClick.onClick(v);
                }
            });
        }
        return this;
    }

    /**
     * 设置知道按钮事件
     **/
    public CleariDialog setKnowListener(final View.OnClickListener onClick) {
        if (onClick != null) {
            knowButton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    CleariDialog.this.dismiss();
                    onClick.onClick(v);
                }
            });
        } else {
            knowButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    CleariDialog.this.dismiss();
                }
            });
        }
        return this;
    }

    // 设置取消按钮事件
    public CleariDialog setNegativeListener(final View.OnClickListener onClick) {
        if (onClick != null) {
            cancelButton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    CleariDialog.this.dismiss();
                    onClick.onClick(v);
                }
            });
        } else {
            cancelButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    CleariDialog.this.dismiss();
                }
            });
        }
        return this;
    }

    public void setContentStr(String str) {
        contentStr = str;
        conteTextView.setText(contentStr);
    }

    public void setTitleStr(String str) {
        titleStr = str;
        titleTextView.setText(titleStr);
    }

    public void setOkButtonText(String text) {
        doublebtn.setVisibility(View.VISIBLE);
        onebtn.setVisibility(View.GONE);
        okButton.setText(text);
    }

    public void setCancelButtonText(String text) {
        cancelButton.setText(text);
    }

    public void setKnowButtonText(String text) {
        doublebtn.setVisibility(View.GONE);
        onebtn.setVisibility(View.VISIBLE);
        knowButton.setText(text);
    }
}