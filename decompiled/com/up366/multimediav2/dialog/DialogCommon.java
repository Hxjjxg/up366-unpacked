package com.up366.multimediav2.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class DialogCommon extends android.app.Dialog {
    private com.up366.multimediav2.dialog.DialogCommon.RequestCallBack callBack;
    private java.lang.String cancleMsg;
    private java.lang.String okMsg;
    private java.lang.String titleMsg;

    public interface RequestCallBack {
        void onResult(boolean z);
    }

    public DialogCommon(android.content.Context context) {
        this(context, 0);
    }

    public DialogCommon(android.content.Context context, int i) {
        super(context, i);
    }

    public void setCallBack(com.up366.multimediav2.dialog.DialogCommon.RequestCallBack requestCallBack) {
        this.callBack = requestCallBack;
    }

    public java.lang.String getTitleMsg() {
        return this.titleMsg;
    }

    public void setTitleMsg(java.lang.String str) {
        this.titleMsg = str;
    }

    public java.lang.String getCancleMsg() {
        return this.cancleMsg;
    }

    public void setCancleMsg(java.lang.String str) {
        this.cancleMsg = str;
    }

    public java.lang.String getOkMsg() {
        return this.okMsg;
    }

    public void setOkMsg(java.lang.String str) {
        this.okMsg = str;
    }

    @Override // android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        setContentView(com.up366.multimediav2.R.layout.dialog_common_cancel_ok);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.up366.multimediav2.R.id.tv_title);
        android.widget.Button button = (android.widget.Button) findViewById(com.up366.multimediav2.R.id.bt_cancel);
        android.widget.Button button2 = (android.widget.Button) findViewById(com.up366.multimediav2.R.id.bt_ok);
        button2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.dialog.DialogCommon.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.up366.multimediav2.dialog.DialogCommon.this.callbackByResult(true);
            }
        });
        button.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.dialog.DialogCommon.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.up366.multimediav2.dialog.DialogCommon.this.callbackByResult(false);
            }
        });
        setCanceledOnTouchOutside(true);
        java.lang.String str = this.titleMsg;
        if (str != null) {
            textView.setText(str);
        }
        java.lang.String str2 = this.cancleMsg;
        if (str2 != null) {
            button.setText(str2);
        }
        java.lang.String str3 = this.okMsg;
        if (str3 != null) {
            button2.setText(str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackByResult(boolean z) {
        com.up366.multimediav2.dialog.DialogCommon.RequestCallBack requestCallBack = this.callBack;
        if (requestCallBack != null) {
            requestCallBack.onResult(z);
        }
    }
}
