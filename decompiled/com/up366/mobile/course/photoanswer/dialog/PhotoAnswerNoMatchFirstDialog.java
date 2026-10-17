package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: PhotoAnswerNoMatchFirstDialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/PhotoAnswerNoMatchFirstDialog;", "Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "b", "Lcom/up366/mobile/databinding/PhotoAnswerDialogNoMatchFirstBinding;", "paperCode", "", "onAttachedToWindow", "", "setPaperCode", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerNoMatchFirstDialog extends com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog {
    private final com.up366.mobile.databinding.PhotoAnswerDialogNoMatchFirstBinding b;
    private java.lang.String paperCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoAnswerNoMatchFirstDialog(android.content.Context context) {
        super(context, 0, 2, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        this.paperCode = "";
        com.up366.mobile.databinding.PhotoAnswerDialogNoMatchFirstBinding photoAnswerDialogNoMatchFirstBindingInflate = com.up366.mobile.databinding.PhotoAnswerDialogNoMatchFirstBinding.inflate(android.view.LayoutInflater.from(context), null, false);
        this.b = photoAnswerDialogNoMatchFirstBindingInflate;
        setContentView((android.view.View) photoAnswerDialogNoMatchFirstBindingInflate.getRoot());
        setCancelable(false);
        photoAnswerDialogNoMatchFirstBindingInflate.btnLeft.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoAnswerNoMatchFirstDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoAnswerNoMatchFirstDialog._init_$lambda$0(this.f$0, view);
            }
        });
        photoAnswerDialogNoMatchFirstBindingInflate.btnRight.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoAnswerNoMatchFirstDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoAnswerNoMatchFirstDialog._init_$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerNoMatchFirstDialog photoAnswerNoMatchFirstDialog, android.view.View view) {
        photoAnswerNoMatchFirstDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoAnswerNoMatchFirstDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 0, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerNoMatchFirstDialog photoAnswerNoMatchFirstDialog, android.view.View view) {
        photoAnswerNoMatchFirstDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoAnswerNoMatchFirstDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        callBack.onCallback(1, photoAnswerNoMatchFirstDialog.paperCode);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        android.view.Window window = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window);
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(attributes, "getAttributes(...)");
        attributes.gravity = 17;
        attributes.width = com.up366.common.DpUtilsUp.dp2px(280.0f);
        attributes.height = -2;
        android.view.Window window2 = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window2);
        window2.getDecorView().setPadding(0, 0, 0, 0);
        android.view.Window window3 = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window3);
        window3.setAttributes(attributes);
        super.onAttachedToWindow();
    }

    public final com.up366.mobile.course.photoanswer.dialog.PhotoAnswerNoMatchFirstDialog setPaperCode(java.lang.String paperCode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paperCode, "paperCode");
        this.b.paperCodeTxt.setText(paperCode);
        this.paperCode = paperCode;
        return this;
    }
}
