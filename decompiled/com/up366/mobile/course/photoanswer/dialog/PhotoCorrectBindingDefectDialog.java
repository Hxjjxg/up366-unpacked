package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: PhotoCorrectBindingDefectDialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/PhotoCorrectBindingDefectDialog;", "Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "b", "Lcom/up366/mobile/databinding/PhotoCorrectBindingDefectBinding;", "btnType", "", "onAttachedToWindow", "", "setErrorCount", "errorCount", "isAllowAutoFix", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoCorrectBindingDefectDialog extends com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog {
    private final com.up366.mobile.databinding.PhotoCorrectBindingDefectBinding b;
    private int btnType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoCorrectBindingDefectDialog(android.content.Context context) {
        super(context, 0, 2, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.databinding.PhotoCorrectBindingDefectBinding photoCorrectBindingDefectBindingInflate = com.up366.mobile.databinding.PhotoCorrectBindingDefectBinding.inflate(android.view.LayoutInflater.from(context), null, false);
        this.b = photoCorrectBindingDefectBindingInflate;
        setContentView(photoCorrectBindingDefectBindingInflate.getRoot());
        setCancelable(false);
        photoCorrectBindingDefectBindingInflate.btnLeft.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoCorrectBindingDefectDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoCorrectBindingDefectDialog._init_$lambda$0(this.f$0, view);
            }
        });
        photoCorrectBindingDefectBindingInflate.btnRight.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoCorrectBindingDefectDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoCorrectBindingDefectDialog._init_$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(com.up366.mobile.course.photoanswer.dialog.PhotoCorrectBindingDefectDialog photoCorrectBindingDefectDialog, android.view.View view) {
        photoCorrectBindingDefectDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoCorrectBindingDefectDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        callBack.onCallback(0, java.lang.Integer.valueOf(photoCorrectBindingDefectDialog.btnType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(com.up366.mobile.course.photoanswer.dialog.PhotoCorrectBindingDefectDialog photoCorrectBindingDefectDialog, android.view.View view) {
        photoCorrectBindingDefectDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoCorrectBindingDefectDialog.getCallBack();
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
        attributes.width = com.up366.common.DpUtilsUp.dp2px(270.0f);
        attributes.height = -2;
        android.view.Window window2 = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window2);
        window2.getDecorView().setPadding(0, 0, 0, 0);
        android.view.Window window3 = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window3);
        window3.setAttributes(attributes);
        super.onAttachedToWindow();
    }

    public static /* synthetic */ com.up366.mobile.course.photoanswer.dialog.PhotoCorrectBindingDefectDialog setErrorCount$default(com.up366.mobile.course.photoanswer.dialog.PhotoCorrectBindingDefectDialog photoCorrectBindingDefectDialog, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return photoCorrectBindingDefectDialog.setErrorCount(i, z);
    }

    public final com.up366.mobile.course.photoanswer.dialog.PhotoCorrectBindingDefectDialog setErrorCount(int errorCount, boolean isAllowAutoFix) {
        if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isAutoFix() && isAllowAutoFix) {
            this.b.btnLeft.setVisibility(0);
            this.b.btnLeft.setText("自动补齐");
            this.btnType = 2;
            return this;
        }
        com.up366.common.log.Logger.info("errorCount = " + errorCount + com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.checkLessSingleRetryCount(errorCount) + "  " + com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isSingleHidden() + "  " + com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isOnline());
        if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.checkLessSingleRetryCount(errorCount) || com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isSingleHidden()) {
            this.b.btnLeft.setVisibility(8);
            return this;
        }
        if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isOnline()) {
            this.b.btnLeft.setVisibility(0);
            this.b.btnLeft.setText("在线作答");
            this.btnType = 1;
        } else if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isForceUse()) {
            this.b.btnLeft.setVisibility(0);
            this.b.btnLeft.setText("就用这张");
            this.btnType = 0;
        } else {
            this.b.btnLeft.setVisibility(8);
        }
        return this;
    }
}
