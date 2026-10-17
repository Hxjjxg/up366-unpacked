package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: PhotoAnswerSubmitTipDialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/PhotoAnswerSubmitTipDialog;", "Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/up366/mobile/databinding/PhotoAnswerSubmitTipDialogBinding;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerSubmitTipDialog extends com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog {
    private final com.up366.mobile.databinding.PhotoAnswerSubmitTipDialogBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoAnswerSubmitTipDialog(android.content.Context context) {
        super(context, 0, 2, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.databinding.PhotoAnswerSubmitTipDialogBinding photoAnswerSubmitTipDialogBindingInflate = com.up366.mobile.databinding.PhotoAnswerSubmitTipDialogBinding.inflate(android.view.LayoutInflater.from(context), null, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(photoAnswerSubmitTipDialogBindingInflate, "inflate(...)");
        this.binding = photoAnswerSubmitTipDialogBindingInflate;
        setContentView((android.view.View) photoAnswerSubmitTipDialogBindingInflate.getRoot());
        setCancelable(false);
        photoAnswerSubmitTipDialogBindingInflate.flBg.setBackground(com.up366.mobile.common.utils.ShapeDrawableUtils.createShapeDrawable(10, -1));
        photoAnswerSubmitTipDialogBindingInflate.btnLeft.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitTipDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitTipDialog._init_$lambda$0(this.f$0, view);
            }
        });
        photoAnswerSubmitTipDialogBindingInflate.btnRight.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitTipDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitTipDialog._init_$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitTipDialog photoAnswerSubmitTipDialog, android.view.View view) {
        com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("preview", ""));
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoAnswerSubmitTipDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 0, null, 2, null);
        photoAnswerSubmitTipDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitTipDialog photoAnswerSubmitTipDialog, android.view.View view) {
        com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("submitJustNow", ""));
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoAnswerSubmitTipDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 1, null, 2, null);
        photoAnswerSubmitTipDialog.dismiss();
    }
}
