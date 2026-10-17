package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountUnbindBottomSheetDialog {
    private final android.app.Activity activity;
    private final com.up366.mobile.databinding.AccountUnbindBottomSheetDialogLayoutBinding b;
    private final com.google.android.material.bottomsheet.BottomSheetDialog dialog;
    private com.up366.mobile.common.dialog.AccountUnbindBottomSheetDialog.IOnClickListener listener;

    public interface IOnClickListener {
        void onClick();
    }

    public AccountUnbindBottomSheetDialog(android.app.Activity activity) {
        this.activity = activity;
        com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(activity);
        this.dialog = bottomSheetDialog;
        com.up366.mobile.databinding.AccountUnbindBottomSheetDialogLayoutBinding accountUnbindBottomSheetDialogLayoutBinding = (com.up366.mobile.databinding.AccountUnbindBottomSheetDialogLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(activity), com.up366.mobile.R.layout.account_unbind_bottom_sheet_dialog_layout, (android.view.ViewGroup) null, false);
        this.b = accountUnbindBottomSheetDialogLayoutBinding;
        bottomSheetDialog.setContentView(accountUnbindBottomSheetDialogLayoutBinding.getRoot());
        try {
            ((android.view.ViewGroup) accountUnbindBottomSheetDialogLayoutBinding.getRoot().getParent()).setBackgroundResource(android.R.color.transparent);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        this.b.btnClose.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AccountUnbindBottomSheetDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        this.b.btnUnbind.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.AccountUnbindBottomSheetDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(android.view.View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(android.view.View view) {
        com.up366.mobile.common.dialog.AccountUnbindBottomSheetDialog.IOnClickListener iOnClickListener = this.listener;
        if (iOnClickListener != null) {
            iOnClickListener.onClick();
        }
        this.dialog.dismiss();
    }

    public void show() {
        this.dialog.show();
    }

    public com.up366.mobile.common.dialog.AccountUnbindBottomSheetDialog title(java.lang.CharSequence charSequence) {
        this.b.title.setText(charSequence);
        return this;
    }

    public com.up366.mobile.common.dialog.AccountUnbindBottomSheetDialog message(java.lang.CharSequence charSequence) {
        this.b.message.setText(charSequence);
        return this;
    }

    public com.up366.mobile.common.dialog.AccountUnbindBottomSheetDialog onClick(com.up366.mobile.common.dialog.AccountUnbindBottomSheetDialog.IOnClickListener iOnClickListener) {
        this.listener = iOnClickListener;
        return this;
    }
}
