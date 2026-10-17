package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: DialogNetError.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/DialogNetError;", "Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "b", "Lcom/up366/mobile/databinding/DialogNetErrorBinding;", "setMsg", "msg", "", "setLeftBtn", "leftBtn", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DialogNetError extends com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog {
    private final com.up366.mobile.databinding.DialogNetErrorBinding b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogNetError(android.content.Context context) {
        super(context, 0, 2, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.databinding.DialogNetErrorBinding dialogNetErrorBindingInflate = com.up366.mobile.databinding.DialogNetErrorBinding.inflate(android.view.LayoutInflater.from(context), null, false);
        this.b = dialogNetErrorBindingInflate;
        create((android.view.View) dialogNetErrorBindingInflate.getRoot());
        setCancelable(false);
        dialogNetErrorBindingInflate.btnLeft.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.DialogNetError$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.DialogNetError._init_$lambda$0(this.f$0, view);
            }
        });
        dialogNetErrorBindingInflate.btnRight.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.DialogNetError$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.DialogNetError._init_$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(com.up366.mobile.course.photoanswer.dialog.DialogNetError dialogNetError, android.view.View view) {
        dialogNetError.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = dialogNetError.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 0, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(com.up366.mobile.course.photoanswer.dialog.DialogNetError dialogNetError, android.view.View view) {
        dialogNetError.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = dialogNetError.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 1, null, 2, null);
    }

    public final com.up366.mobile.course.photoanswer.dialog.DialogNetError setMsg(java.lang.String msg) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(msg, "msg");
        this.b.tvErrorTips.setText(msg);
        return this;
    }

    public final com.up366.mobile.course.photoanswer.dialog.DialogNetError setLeftBtn(java.lang.String leftBtn) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(leftBtn, "leftBtn");
        this.b.btnLeft.setText(leftBtn);
        return this;
    }
}
