package com.up366.mobile.common.dialoghelper;

/* JADX INFO: compiled from: BaseDialogHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH$J.\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH$R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/up366/mobile/common/dialoghelper/BaseDialogHelper;", "", "<init>", "()V", "curDialogType", "Lcom/up366/mobile/common/dialoghelper/IDialogType;", "showDialog", "", "dialogType", "callback", "Lcom/up366/mobile/common/dialoghelper/BaseDialogHelper$IDialogCallback;", "jsonObject", "Lcom/alibaba/fastjson/JSONObject;", "isShowing", "", "checkPermission", "showDialogByDialogType", "listener", "Landroid/content/DialogInterface$OnDismissListener;", "Companion", "IDialogCallback", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BaseDialogHelper {
    public static final int CALLBACK_CODE_CLOSE = 2;
    public static final int CALLBACK_CODE_LEFT = 0;
    public static final int CALLBACK_CODE_RIGHT = 1;
    private com.up366.mobile.common.dialoghelper.IDialogType curDialogType;

    protected abstract boolean checkPermission();

    protected abstract void showDialogByDialogType(com.up366.mobile.common.dialoghelper.IDialogType dialogType, com.up366.mobile.common.dialoghelper.BaseDialogHelper.IDialogCallback callback, android.content.DialogInterface.OnDismissListener listener, com.alibaba.fastjson.JSONObject jsonObject);

    /* JADX INFO: compiled from: BaseDialogHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0001H&¨\u0006\u0007"}, d2 = {"Lcom/up366/mobile/common/dialoghelper/BaseDialogHelper$IDialogCallback;", "", "onCallback", "", "code", "", "info", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface IDialogCallback {
        void onCallback(int code, java.lang.Object info);

        /* JADX INFO: compiled from: BaseDialogHelper.kt */
        @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void onCallback$default(com.up366.mobile.common.dialoghelper.BaseDialogHelper.IDialogCallback iDialogCallback, int i, java.lang.Object obj, int i2, java.lang.Object obj2) {
                if (obj2 != null) {
                    throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCallback");
                }
                if ((i2 & 2) != 0) {
                    obj = "";
                }
                iDialogCallback.onCallback(i, obj);
            }
        }
    }

    public static /* synthetic */ void showDialog$default(com.up366.mobile.common.dialoghelper.BaseDialogHelper baseDialogHelper, com.up366.mobile.common.dialoghelper.IDialogType iDialogType, com.up366.mobile.common.dialoghelper.BaseDialogHelper.IDialogCallback iDialogCallback, com.alibaba.fastjson.JSONObject jSONObject, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDialog");
        }
        if ((i & 4) != 0) {
            jSONObject = null;
        }
        baseDialogHelper.showDialog(iDialogType, iDialogCallback, jSONObject);
    }

    public final void showDialog(final com.up366.mobile.common.dialoghelper.IDialogType dialogType, final com.up366.mobile.common.dialoghelper.BaseDialogHelper.IDialogCallback callback, final com.alibaba.fastjson.JSONObject jsonObject) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dialogType, "dialogType");
        com.up366.common.log.Logger.info("showDialog dialogType:" + dialogType + " callback:" + callback + " jsonObject:" + jsonObject + " , isShowing:" + isShowing() + " ,checkPermission:" + checkPermission());
        if (!isShowing() && checkPermission()) {
            this.curDialogType = dialogType;
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialoghelper.BaseDialogHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.dialoghelper.BaseDialogHelper.showDialog$lambda$1(this.f$0, dialogType, callback, jsonObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$1(final com.up366.mobile.common.dialoghelper.BaseDialogHelper baseDialogHelper, com.up366.mobile.common.dialoghelper.IDialogType iDialogType, com.up366.mobile.common.dialoghelper.BaseDialogHelper.IDialogCallback iDialogCallback, com.alibaba.fastjson.JSONObject jSONObject) {
        baseDialogHelper.showDialogByDialogType(iDialogType, iDialogCallback, new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.dialoghelper.BaseDialogHelper$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                this.f$0.curDialogType = null;
            }
        }, jSONObject);
    }

    public final boolean isShowing() {
        return this.curDialogType != null;
    }

    public static /* synthetic */ void showDialogByDialogType$default(com.up366.mobile.common.dialoghelper.BaseDialogHelper baseDialogHelper, com.up366.mobile.common.dialoghelper.IDialogType iDialogType, com.up366.mobile.common.dialoghelper.BaseDialogHelper.IDialogCallback iDialogCallback, android.content.DialogInterface.OnDismissListener onDismissListener, com.alibaba.fastjson.JSONObject jSONObject, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDialogByDialogType");
        }
        if ((i & 8) != 0) {
            jSONObject = null;
        }
        baseDialogHelper.showDialogByDialogType(iDialogType, iDialogCallback, onDismissListener, jSONObject);
    }
}
