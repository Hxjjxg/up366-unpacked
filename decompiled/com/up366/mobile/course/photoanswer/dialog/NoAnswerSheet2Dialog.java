package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: NoAnswerSheet2Dialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/NoAnswerSheet2Dialog;", "Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "b", "Lcom/up366/mobile/databinding/PhotoAnswerNotAnswerSheetDialogBinding;", "isOnline", "", "onAttachedToWindow", "", "setErrorCount", "errorCount", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NoAnswerSheet2Dialog extends com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog {
    private final com.up366.mobile.databinding.PhotoAnswerNotAnswerSheetDialogBinding b;
    private boolean isOnline;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoAnswerSheet2Dialog(android.content.Context context) {
        super(context, 0, 2, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.databinding.PhotoAnswerNotAnswerSheetDialogBinding photoAnswerNotAnswerSheetDialogBindingInflate = com.up366.mobile.databinding.PhotoAnswerNotAnswerSheetDialogBinding.inflate(android.view.LayoutInflater.from(context), null, false);
        this.b = photoAnswerNotAnswerSheetDialogBindingInflate;
        setContentView(photoAnswerNotAnswerSheetDialogBindingInflate.getRoot());
        setCancelable(false);
        photoAnswerNotAnswerSheetDialogBindingInflate.btnLeft.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.NoAnswerSheet2Dialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.NoAnswerSheet2Dialog._init_$lambda$0(this.f$0, view);
            }
        });
        photoAnswerNotAnswerSheetDialogBindingInflate.btnRight.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.NoAnswerSheet2Dialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.NoAnswerSheet2Dialog._init_$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(com.up366.mobile.course.photoanswer.dialog.NoAnswerSheet2Dialog noAnswerSheet2Dialog, android.view.View view) {
        noAnswerSheet2Dialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = noAnswerSheet2Dialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        callBack.onCallback(0, java.lang.Boolean.valueOf(noAnswerSheet2Dialog.isOnline));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(com.up366.mobile.course.photoanswer.dialog.NoAnswerSheet2Dialog noAnswerSheet2Dialog, android.view.View view) {
        noAnswerSheet2Dialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = noAnswerSheet2Dialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 1, null, 2, null);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        android.view.Window window = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window);
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(attributes, "getAttributes(...)");
        attributes.gravity = 17;
        attributes.width = com.up366.common.DpUtilsUp.dp2px(275.0f);
        attributes.height = com.up366.common.DpUtilsUp.dp2px(590.0f);
        android.view.Window window2 = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window2);
        window2.getDecorView().setPadding(0, 0, 0, 0);
        android.view.Window window3 = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window3);
        window3.setAttributes(attributes);
        super.onAttachedToWindow();
    }

    public final com.up366.mobile.course.photoanswer.dialog.NoAnswerSheet2Dialog setErrorCount(int errorCount) {
        com.up366.common.log.Logger.info("errorCount = " + errorCount + com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.checkLessSingleRetryCount(errorCount) + "  " + com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isSingleHidden() + "  " + com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isOnline());
        if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.checkLessSingleRetryCount(errorCount) || com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isSingleHidden()) {
            this.b.btnLeft.setVisibility(8);
            return this;
        }
        if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isOnline()) {
            this.b.btnLeft.setVisibility(0);
            this.b.btnLeft.setText("在线作答");
            this.isOnline = true;
        } else if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isForceUse()) {
            this.b.btnLeft.setVisibility(0);
            this.b.btnLeft.setText("就用这张");
            this.isOnline = false;
        } else {
            this.b.btnLeft.setVisibility(8);
        }
        return this;
    }
}
