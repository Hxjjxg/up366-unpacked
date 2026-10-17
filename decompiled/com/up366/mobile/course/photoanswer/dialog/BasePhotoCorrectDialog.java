package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: BasePhotoCorrectDialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "Lcom/up366/mobile/common/dialog/BaseDialog;", "context", "Landroid/content/Context;", "themeId", "", "<init>", "(Landroid/content/Context;I)V", "callBack", "Lcom/up366/mobile/course/photoanswer/dialog/Dialog2Helper$IDialogCallback;", "getCallBack", "()Lcom/up366/mobile/course/photoanswer/dialog/Dialog2Helper$IDialogCallback;", "setCallBack", "(Lcom/up366/mobile/course/photoanswer/dialog/Dialog2Helper$IDialogCallback;)V", "setDismissListener", "listener", "Landroid/content/DialogInterface$OnDismissListener;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class BasePhotoCorrectDialog extends com.up366.mobile.common.dialog.BaseDialog {
    private com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePhotoCorrectDialog(android.content.Context context, int i) {
        super(context, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BasePhotoCorrectDialog(android.content.Context context, int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? com.up366.mobile.R.style.AppDialogTheme : i);
    }

    protected final com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback getCallBack() {
        return this.callBack;
    }

    /* JADX INFO: renamed from: setCallBack, reason: collision with other method in class */
    protected final void m921setCallBack(com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback iDialogCallback) {
        this.callBack = iDialogCallback;
    }

    public final com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog setCallBack(com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack) {
        this.callBack = callBack;
        return this;
    }

    public final com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog setDismissListener(android.content.DialogInterface.OnDismissListener listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        setOnDismissListener(listener);
        return this;
    }
}
