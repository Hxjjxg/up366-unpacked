package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PermissionDialog {
    public final com.up366.mobile.databinding.PermissionDialogBinding b;
    private final android.app.Dialog dialog;

    private PermissionDialog(android.content.Context context) {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(context, com.up366.mobile.R.style.no_frame_dialog);
        this.dialog = baseDialog;
        com.up366.mobile.databinding.PermissionDialogBinding permissionDialogBinding = (com.up366.mobile.databinding.PermissionDialogBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.permission_dialog, (android.view.ViewGroup) null, false);
        this.b = permissionDialogBinding;
        baseDialog.setContentView(permissionDialogBinding.getRoot());
        baseDialog.setCancelable(false);
        init();
    }

    public static com.up366.mobile.common.dialog.PermissionDialog create(android.content.Context context) {
        return new com.up366.mobile.common.dialog.PermissionDialog(context);
    }

    private void init() {
        android.view.WindowManager.LayoutParams attributes = this.dialog.getWindow().getAttributes();
        attributes.gravity = 48;
        this.dialog.getWindow().setAttributes(attributes);
        this.dialog.getWindow().setLayout(-1, -2);
    }

    public com.up366.mobile.common.dialog.PermissionDialog title(java.lang.CharSequence charSequence) {
        this.b.permissionTitle.setVisibility(0);
        this.b.permissionTitle.setText(charSequence);
        return this;
    }

    public com.up366.mobile.common.dialog.PermissionDialog content(java.lang.CharSequence charSequence) {
        this.b.permissionContent.setVisibility(0);
        this.b.permissionContent.setText(charSequence);
        return this;
    }

    public void dismiss() {
        this.dialog.dismiss();
    }

    public com.up366.mobile.common.dialog.PermissionDialog show() {
        if (!this.dialog.isShowing()) {
            this.dialog.show();
        }
        return this;
    }

    public com.up366.mobile.common.dialog.PermissionDialog setOnDissmissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        this.dialog.setOnDismissListener(onDismissListener);
        return this;
    }

    public com.up366.mobile.common.dialog.PermissionDialog setCancelable(boolean z) {
        this.dialog.setCancelable(z);
        return this;
    }
}
