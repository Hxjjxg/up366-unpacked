package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: PhotoAnswerSubmitErrorDialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/PhotoAnswerSubmitErrorDialog;", "Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/up366/mobile/databinding/PhotoAnswerSubmitErrorDialogBinding;", "setLeftBtnText", "text", "", "setTaskName", "taskName", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerSubmitErrorDialog extends com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog {
    private final com.up366.mobile.databinding.PhotoAnswerSubmitErrorDialogBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoAnswerSubmitErrorDialog(android.content.Context context) {
        super(context, com.up366.mobile.R.style.AppDialogTheme_Transparent);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.databinding.PhotoAnswerSubmitErrorDialogBinding photoAnswerSubmitErrorDialogBindingInflate = com.up366.mobile.databinding.PhotoAnswerSubmitErrorDialogBinding.inflate(android.view.LayoutInflater.from(context), null, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(photoAnswerSubmitErrorDialogBindingInflate, "inflate(...)");
        this.binding = photoAnswerSubmitErrorDialogBindingInflate;
        setContentView((android.view.View) photoAnswerSubmitErrorDialogBindingInflate.getRoot());
        setCancelable(false);
        photoAnswerSubmitErrorDialogBindingInflate.flBg.setBackground(com.up366.mobile.common.utils.ShapeDrawableUtils.createShapeDrawable(10, -1));
        photoAnswerSubmitErrorDialogBindingInflate.btnLeft.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitErrorDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitErrorDialog._init_$lambda$0(this.f$0, view);
            }
        });
        photoAnswerSubmitErrorDialogBindingInflate.btnRight.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitErrorDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitErrorDialog._init_$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitErrorDialog photoAnswerSubmitErrorDialog, android.view.View view) {
        photoAnswerSubmitErrorDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoAnswerSubmitErrorDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 0, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitErrorDialog photoAnswerSubmitErrorDialog, android.view.View view) {
        photoAnswerSubmitErrorDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoAnswerSubmitErrorDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 1, null, 2, null);
    }

    public final com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitErrorDialog setLeftBtnText(java.lang.String text) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(text, "text");
        this.binding.btnLeft.setText(text);
        return this;
    }

    public final com.up366.mobile.course.photoanswer.dialog.PhotoAnswerSubmitErrorDialog setTaskName(java.lang.String taskName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(taskName, "taskName");
        this.binding.tvTaskName.setText(taskName);
        return this;
    }
}
