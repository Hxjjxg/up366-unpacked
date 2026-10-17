package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: PhotoAnswerUploadingDialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0016H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/PhotoAnswerUploadingDialog;", "Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/up366/mobile/databinding/PhotoAnswerUploadingDialogBinding;", "key", "", "setKey", "showMsg", "msg", "showBtnClose", "show", "", "onAttachedToWindow", "", "onDetachedFromWindow", "onMessageEvent", "event", "Lcom/up366/mobile/common/event/UpdateLoadingProgressEvent;", "Lcom/up366/mobile/common/event/CloseUploadDialogEvent;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerUploadingDialog extends com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog {
    private final com.up366.mobile.databinding.PhotoAnswerUploadingDialogBinding binding;
    private java.lang.String key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoAnswerUploadingDialog(android.content.Context context) {
        super(context, 0, 2, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.databinding.PhotoAnswerUploadingDialogBinding photoAnswerUploadingDialogBindingInflate = com.up366.mobile.databinding.PhotoAnswerUploadingDialogBinding.inflate(android.view.LayoutInflater.from(context), null, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(photoAnswerUploadingDialogBindingInflate, "inflate(...)");
        this.binding = photoAnswerUploadingDialogBindingInflate;
        this.key = "";
        setContentView(photoAnswerUploadingDialogBindingInflate.getRoot());
        setCancelable(false);
        com.up366.common.BitmapUtilsUp.display(photoAnswerUploadingDialogBindingInflate.givLoading, com.up366.mobile.R.drawable.loading_xiao_tian);
        photoAnswerUploadingDialogBindingInflate.closeBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoAnswerUploadingDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.dismiss();
            }
        });
        photoAnswerUploadingDialogBindingInflate.closeBtn.setVisibility(8);
        photoAnswerUploadingDialogBindingInflate.progressBar.setState(1);
        findViewById(com.up366.mobile.R.id.giv_loading).setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoAnswerUploadingDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(android.view.View view) {
                return com.up366.mobile.course.photoanswer.dialog.PhotoAnswerUploadingDialog._init_$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerUploadingDialog photoAnswerUploadingDialog, android.view.View view) {
        photoAnswerUploadingDialog.dismiss();
        return false;
    }

    public final com.up366.mobile.course.photoanswer.dialog.PhotoAnswerUploadingDialog setKey(java.lang.String key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        return this;
    }

    public final com.up366.mobile.course.photoanswer.dialog.PhotoAnswerUploadingDialog showMsg(java.lang.String msg) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(msg, "msg");
        java.lang.String str = msg;
        if (str.length() > 0) {
            this.binding.tvLoadingTips.setVisibility(0);
            this.binding.tvLoadingTips.setText(str);
        }
        return this;
    }

    public final com.up366.mobile.course.photoanswer.dialog.PhotoAnswerUploadingDialog showBtnClose(boolean show) {
        this.binding.closeBtn.setVisibility(show ? 0 : 8);
        return this;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        com.up366.common.EventBusUtilsUp.register(this);
        android.view.Window window = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window);
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(attributes, "getAttributes(...)");
        attributes.gravity = 17;
        attributes.width = com.up366.common.DpUtilsUp.dp2px(280.0f);
        attributes.height = com.up366.common.DpUtilsUp.dp2px(225.0f);
        android.view.Window window2 = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window2);
        window2.getDecorView().setPadding(0, 0, 0, 0);
        android.view.Window window3 = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window3);
        window3.setAttributes(attributes);
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(com.up366.mobile.common.event.UpdateLoadingProgressEvent event) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        if (kotlin.jvm.internal.Intrinsics.areEqual(event.getKey(), this.key)) {
            this.binding.progressValue.setText(event.getProgress() + "%");
            this.binding.progressBar.setProgress(event.getProgress());
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(com.up366.mobile.common.event.CloseUploadDialogEvent event) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        dismiss();
    }
}
