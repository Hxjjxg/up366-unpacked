package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: PhotoAnswerNoMatchDialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/PhotoAnswerNoMatchDialog;", "Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "b", "Lcom/up366/mobile/databinding/PhotoAnswerDialogNoMatchBinding;", "setJobName", "jobName", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerNoMatchDialog extends com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog {
    private final com.up366.mobile.databinding.PhotoAnswerDialogNoMatchBinding b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoAnswerNoMatchDialog(android.content.Context context) {
        super(context, 0, 2, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.databinding.PhotoAnswerDialogNoMatchBinding photoAnswerDialogNoMatchBindingInflate = com.up366.mobile.databinding.PhotoAnswerDialogNoMatchBinding.inflate(android.view.LayoutInflater.from(context), null, false);
        this.b = photoAnswerDialogNoMatchBindingInflate;
        setContentView((android.view.View) photoAnswerDialogNoMatchBindingInflate.getRoot());
        setCancelable(false);
        photoAnswerDialogNoMatchBindingInflate.taskName.setText("");
        photoAnswerDialogNoMatchBindingInflate.btnRight.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoAnswerNoMatchDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoAnswerNoMatchDialog._init_$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerNoMatchDialog photoAnswerNoMatchDialog, android.view.View view) {
        photoAnswerNoMatchDialog.dismiss();
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.StartAnalyzeEvent());
    }

    public final com.up366.mobile.course.photoanswer.dialog.PhotoAnswerNoMatchDialog setJobName(java.lang.String jobName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jobName, "jobName");
        this.b.taskName.setText(jobName);
        return this;
    }
}
