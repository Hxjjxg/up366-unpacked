package com.up366.multimediav2.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PermissionDialog extends android.app.Dialog {
    private android.widget.Button btCancel;
    private android.widget.Button btOk;
    private android.widget.TextView tvMessage;
    private android.widget.TextView tvTitle;

    public PermissionDialog(android.content.Context context) {
        this(context, 0);
    }

    public PermissionDialog(android.content.Context context, int i) {
        super(context, i);
        initView(context);
    }

    private void initView(android.content.Context context) {
        android.view.View viewInflate = android.view.LayoutInflater.from(context).inflate(com.up366.multimediav2.R.layout.dialog_request_permission, (android.view.ViewGroup) null);
        getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        setContentView(viewInflate);
        this.btOk = (android.widget.Button) viewInflate.findViewById(com.up366.multimediav2.R.id.bt_ok);
        this.btCancel = (android.widget.Button) viewInflate.findViewById(com.up366.multimediav2.R.id.bt_cancel);
        this.tvTitle = (android.widget.TextView) viewInflate.findViewById(com.up366.multimediav2.R.id.tv_permission_title);
        this.tvMessage = (android.widget.TextView) viewInflate.findViewById(com.up366.multimediav2.R.id.tv_permission_message);
    }

    public void setTitle(java.lang.String str) {
        this.tvTitle.setText(str);
    }

    public com.up366.multimediav2.dialog.PermissionDialog setMessage(java.lang.String str) {
        this.tvMessage.setText(str);
        return this;
    }

    public com.up366.multimediav2.dialog.PermissionDialog setBtCancellistener(android.view.View.OnClickListener onClickListener) {
        this.btCancel.setOnClickListener(onClickListener);
        return this;
    }

    public com.up366.multimediav2.dialog.PermissionDialog setBtOkText(java.lang.String str) {
        this.btOk.setText(str);
        return this;
    }

    public com.up366.multimediav2.dialog.PermissionDialog setBtOklistener(android.view.View.OnClickListener onClickListener) {
        this.btOk.setOnClickListener(onClickListener);
        return this;
    }
}
