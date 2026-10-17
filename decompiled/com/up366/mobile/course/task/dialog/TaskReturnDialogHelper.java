package com.up366.mobile.course.task.dialog;

/* JADX INFO: compiled from: TaskReturnDialogHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/up366/mobile/course/task/dialog/TaskReturnDialogHelper;", "", "<init>", "()V", "CALLBACK_CODE_RETAKE_PHOTO", "", "CALLBACK_CODE_ONLINE", "RETURN_CODE_BLUR", "", "RETURN_CODE_NOT_TIAN_XUE_ANSWER_SHEET", "RETURN_CODE_NOT_MATCH", "RETURN_CODE_PAGE_NUM_ERROR", "RETURN_CODE_PAPER_BARCODE_DECODE_ERROR", "RETURN_CODE_ANSWER_SHEET_NO_FULL", "isNeedShowReturnDialog", "", "returnCode", "showReturnDialog", "", "context", "Landroid/content/Context;", "callback", "Lcom/up366/common/callback/ICallbackCodeInfo;", "P1pReturnDialog", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TaskReturnDialogHelper {
    public static final int CALLBACK_CODE_ONLINE = 1;
    public static final int CALLBACK_CODE_RETAKE_PHOTO = 0;
    public static final com.up366.mobile.course.task.dialog.TaskReturnDialogHelper INSTANCE = new com.up366.mobile.course.task.dialog.TaskReturnDialogHelper();
    private static final java.lang.String RETURN_CODE_ANSWER_SHEET_NO_FULL = "008";
    private static final java.lang.String RETURN_CODE_BLUR = "001";
    private static final java.lang.String RETURN_CODE_NOT_MATCH = "003";
    private static final java.lang.String RETURN_CODE_NOT_TIAN_XUE_ANSWER_SHEET = "002";
    private static final java.lang.String RETURN_CODE_PAGE_NUM_ERROR = "004";
    private static final java.lang.String RETURN_CODE_PAPER_BARCODE_DECODE_ERROR = "005";

    public final boolean isNeedShowReturnDialog(java.lang.String returnCode) {
        return false;
    }

    private TaskReturnDialogHelper() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void showReturnDialog(android.content.Context r4, java.lang.String r5, com.up366.common.callback.ICallbackCodeInfo r6) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "returnCode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r0 = r5.hashCode()
            r1 = 0
            switch(r0) {
                case 47665: goto L67;
                case 47666: goto L56;
                case 47667: goto L46;
                case 47668: goto L36;
                case 47669: goto L27;
                case 47670: goto L17;
                case 47671: goto L17;
                case 47672: goto L18;
                default: goto L17;
            }
        L17:
            goto L76
        L18:
            java.lang.String r0 = "008"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L21
            goto L76
        L21:
            java.lang.String r5 = "答题卡没拍全"
            java.lang.String r0 = "你上次提交的答题卡，没有拍全，请根据页码拍够对应的答题卡"
            goto L79
        L27:
            java.lang.String r0 = "005"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L30
            goto L76
        L30:
            java.lang.String r5 = "答题卡打印异常"
            java.lang.String r0 = "你上次提交的答题卡，打印存在异常，导致二维码及标志无法正常识别，建议重新打印再拍照或者直接在线作答哦～"
            goto L79
        L36:
            java.lang.String r0 = "004"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L3f
            goto L76
        L3f:
            java.lang.String r5 = "答题卡题号异常"
            java.lang.String r0 = "答题卡上的题号内容与练习的题目内容不一致，无法正常识别，建议打印正确的答题卡再拍照或者直接在线作答哦～"
            goto L79
        L46:
            java.lang.String r0 = "003"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L4f
            goto L76
        L4f:
            java.lang.String r5 = "答题卡与练习标题不一致"
            java.lang.String r0 = "请核对答题卡上的标题，与你点击拍照的练习标题是否一致，确认一致后再拍哦～"
            goto L79
        L56:
            java.lang.String r0 = "002"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L5f
            goto L76
        L5f:
            java.lang.String r5 = "非天学网答题卡"
            java.lang.String r0 = "请拍天学网的答题卡，样例："
            r1 = 1
            goto L79
        L67:
            java.lang.String r0 = "001"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L70
            goto L76
        L70:
            java.lang.String r5 = "图片模糊不清"
            java.lang.String r0 = "请按照下列提示，重新拍照：\n1、确保周围光线充足且均匀\n2、手机拿稳不要抖动\n3、可点击小图预览图片是否模糊"
            goto L79
        L76:
            java.lang.String r5 = ""
            r0 = r5
        L79:
            com.up366.mobile.course.task.dialog.TaskReturnDialogHelper$P1pReturnDialog r2 = new com.up366.mobile.course.task.dialog.TaskReturnDialogHelper$P1pReturnDialog
            r2.<init>(r4)
            r2.setErrorTip(r5)
            r2.setErrorMessage(r0)
            r2.showErrorImg(r1)
            r2.setCallBack(r6)
            r2.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.course.task.dialog.TaskReturnDialogHelper.showReturnDialog(android.content.Context, java.lang.String, com.up366.common.callback.ICallbackCodeInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TaskReturnDialogHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/up366/mobile/course/task/dialog/TaskReturnDialogHelper$P1pReturnDialog;", "Lcom/up366/mobile/common/dialog/BaseDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "b", "Lcom/up366/mobile/databinding/DialogTaskReturnTipBinding;", "callback", "Lcom/up366/common/callback/ICallbackCodeInfo;", "setCallBack", "setErrorTip", "errorTip", "", "setErrorMessage", "errorMessage", "showErrorImg", "show", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    static final class P1pReturnDialog extends com.up366.mobile.common.dialog.BaseDialog {
        private final com.up366.mobile.databinding.DialogTaskReturnTipBinding b;
        private com.up366.common.callback.ICallbackCodeInfo callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public P1pReturnDialog(android.content.Context context) {
            super(context, com.up366.mobile.R.style.AppDialogTheme);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            com.up366.mobile.databinding.DialogTaskReturnTipBinding dialogTaskReturnTipBindingInflate = com.up366.mobile.databinding.DialogTaskReturnTipBinding.inflate(android.view.LayoutInflater.from(context), null, false);
            this.b = dialogTaskReturnTipBindingInflate;
            setContentView((android.view.View) dialogTaskReturnTipBindingInflate.getRoot());
            setCancelable(false);
            dialogTaskReturnTipBindingInflate.btnClose.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.dialog.TaskReturnDialogHelper$P1pReturnDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.dismiss();
                }
            });
            dialogTaskReturnTipBindingInflate.btnLeft.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.dialog.TaskReturnDialogHelper$P1pReturnDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.course.task.dialog.TaskReturnDialogHelper.P1pReturnDialog._init_$lambda$1(this.f$0, view);
                }
            });
            dialogTaskReturnTipBindingInflate.btnRight.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.dialog.TaskReturnDialogHelper$P1pReturnDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.course.task.dialog.TaskReturnDialogHelper.P1pReturnDialog._init_$lambda$2(this.f$0, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$1(com.up366.mobile.course.task.dialog.TaskReturnDialogHelper.P1pReturnDialog p1pReturnDialog, android.view.View view) {
            p1pReturnDialog.dismiss();
            com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo = p1pReturnDialog.callback;
            if (iCallbackCodeInfo != null) {
                iCallbackCodeInfo.onResult(1, "");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$2(com.up366.mobile.course.task.dialog.TaskReturnDialogHelper.P1pReturnDialog p1pReturnDialog, android.view.View view) {
            p1pReturnDialog.dismiss();
            com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo = p1pReturnDialog.callback;
            if (iCallbackCodeInfo != null) {
                iCallbackCodeInfo.onResult(0, "");
            }
        }

        public final com.up366.mobile.course.task.dialog.TaskReturnDialogHelper.P1pReturnDialog setCallBack(com.up366.common.callback.ICallbackCodeInfo callback) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = callback;
            return this;
        }

        public final com.up366.mobile.course.task.dialog.TaskReturnDialogHelper.P1pReturnDialog setErrorTip(java.lang.String errorTip) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errorTip, "errorTip");
            this.b.errorTxt.setText(errorTip);
            return this;
        }

        public final com.up366.mobile.course.task.dialog.TaskReturnDialogHelper.P1pReturnDialog setErrorMessage(java.lang.String errorMessage) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.b.errorMsg.setText(errorMessage);
            return this;
        }

        public final com.up366.mobile.course.task.dialog.TaskReturnDialogHelper.P1pReturnDialog showErrorImg(boolean show) {
            this.b.errorTipImg.setVisibility(show ? 0 : 8);
            return this;
        }
    }
}
