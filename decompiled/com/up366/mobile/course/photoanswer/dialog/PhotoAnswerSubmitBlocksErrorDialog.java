package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: PhotoAnswerSubmitBlocksErrorDialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/PhotoAnswerSubmitBlocksErrorDialog;", "Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "b", "Lcom/up366/mobile/databinding/PhotoAnswerSubmitBlocksErrorDialogBinding;", "isOnline", "", "setErrorCount", "errorCount", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerSubmitBlocksErrorDialog extends com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog {
    private final com.up366.mobile.databinding.PhotoAnswerSubmitBlocksErrorDialogBinding b;
    private boolean isOnline;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoAnswerSubmitBlocksErrorDialog(android.content.Context context) {
        super(context, 0, 2, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.databinding.PhotoAnswerSubmitBlocksErrorDialogBinding photoAnswerSubmitBlocksErrorDialogBindingInflate = com.up366.mobile.databinding.PhotoAnswerSubmitBlocksErrorDialogBinding.inflate(android.view.LayoutInflater.from(context), null, false);
        this.b = photoAnswerSubmitBlocksErrorDialogBindingInflate;
        setContentView((android.view.View) photoAnswerSubmitBlocksErrorDialogBindingInflate.getRoot());
        setCancelable(false);
        photoAnswerSubmitBlocksErrorDialogBindingInflate.btnLeft.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitBlocksErrorDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitBlocksErrorDialog._init_$lambda$0(this.f$0, view);
            }
        });
        photoAnswerSubmitBlocksErrorDialogBindingInflate.btnRight.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitBlocksErrorDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitBlocksErrorDialog._init_$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitBlocksErrorDialog photoAnswerSubmitBlocksErrorDialog, android.view.View view) {
        photoAnswerSubmitBlocksErrorDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoAnswerSubmitBlocksErrorDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        callBack.onCallback(0, java.lang.Boolean.valueOf(photoAnswerSubmitBlocksErrorDialog.isOnline));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitBlocksErrorDialog photoAnswerSubmitBlocksErrorDialog, android.view.View view) {
        photoAnswerSubmitBlocksErrorDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoAnswerSubmitBlocksErrorDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 1, null, 2, null);
    }

    public final com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitBlocksErrorDialog setErrorCount(int errorCount) {
        if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.checkLessAssembleRetryCount(errorCount)) {
            this.b.btnLeft.setVisibility(8);
            return this;
        }
        if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isOnline()) {
            this.b.btnLeft.setVisibility(0);
            this.b.btnLeft.setText("在线作答");
            this.isOnline = true;
        } else if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isForceUse()) {
            this.b.btnLeft.setVisibility(0);
            this.b.btnLeft.setText("提交");
            this.isOnline = false;
        } else {
            this.b.btnLeft.setVisibility(8);
        }
        return this;
    }
}
