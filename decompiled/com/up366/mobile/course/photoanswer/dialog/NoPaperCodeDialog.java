package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: NoPaperCodeDialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0011H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/NoPaperCodeDialog;", "Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "b", "Lcom/up366/mobile/databinding/PhotoCorrectNoPaperCodeDialogBinding;", "setJobName", "jobName", "", "onAttachedToWindow", "", "onDetachedFromWindow", "onMessageEvent", "event", "Lcom/up366/mobile/common/event/DismissNoPaperCodeDialogEvent;", "Lcom/up366/mobile/common/event/NoPaperCodeDialogTipUpdateEvent;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NoPaperCodeDialog extends com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog {
    private final com.up366.mobile.databinding.PhotoCorrectNoPaperCodeDialogBinding b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoPaperCodeDialog(android.content.Context context) {
        super(context, 0, 2, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.databinding.PhotoCorrectNoPaperCodeDialogBinding photoCorrectNoPaperCodeDialogBindingInflate = com.up366.mobile.databinding.PhotoCorrectNoPaperCodeDialogBinding.inflate(android.view.LayoutInflater.from(context), null, false);
        this.b = photoCorrectNoPaperCodeDialogBindingInflate;
        setContentView((android.view.View) photoCorrectNoPaperCodeDialogBindingInflate.getRoot());
        setCancelable(false);
        photoCorrectNoPaperCodeDialogBindingInflate.taskName.setText("");
        photoCorrectNoPaperCodeDialogBindingInflate.btnLeft.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog._init_$lambda$0(this.f$0, view);
            }
        });
        photoCorrectNoPaperCodeDialogBindingInflate.clear.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog._init_$lambda$1(this.f$0, view);
            }
        });
        photoCorrectNoPaperCodeDialogBindingInflate.btnRight.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog._init_$lambda$2(this.f$0, view);
            }
        });
        photoCorrectNoPaperCodeDialogBindingInflate.content.addTextChangedListener(new android.text.TextWatcher() { // from class: com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(java.lang.CharSequence s, int start, int count, int after) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(s, com.igexin.push.core.d.d.g);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence s, int start, int before, int count) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(s, com.igexin.push.core.d.d.g);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(android.text.Editable s) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(s, com.igexin.push.core.d.d.g);
                com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog.this.b.errorTipInfo.setVisibility(8);
                com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog.this.b.clear.setVisibility(s.length() > 0 ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog noPaperCodeDialog, android.view.View view) {
        noPaperCodeDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = noPaperCodeDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 0, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog noPaperCodeDialog, android.view.View view) {
        noPaperCodeDialog.b.content.setText("");
        noPaperCodeDialog.b.clear.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog noPaperCodeDialog, android.view.View view) {
        com.up366.common.BitmapUtilsUp.display(noPaperCodeDialog.b.loading, com.up366.mobile.R.drawable.photo_correct_btn_loadding);
        java.lang.String string = noPaperCodeDialog.b.content.getText().toString();
        if (string.length() == 0) {
            noPaperCodeDialog.b.errorTipInfo.setText("试卷码不能为空");
            noPaperCodeDialog.b.errorTipInfo.setVisibility(0);
            return;
        }
        noPaperCodeDialog.b.loading.setVisibility(0);
        noPaperCodeDialog.b.btnRight.setEnabled(false);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = noPaperCodeDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        callBack.onCallback(1, string);
    }

    public final com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog setJobName(java.lang.String jobName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jobName, "jobName");
        this.b.taskName.setText(jobName);
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
        attributes.height = -2;
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
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDetachedFromWindow();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(com.up366.mobile.common.event.DismissNoPaperCodeDialogEvent event) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        dismiss();
        com.up366.common.task.TaskUtils.postMainTaskDelay(50L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.dialog.NoPaperCodeDialog$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.common.utils.ToastPopupUtil.show("验证成功");
            }
        });
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(com.up366.mobile.common.event.NoPaperCodeDialogTipUpdateEvent event) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        if (event.getCode() == -102) {
            this.b.errorTipInfo.setText("你输入的试卷码和练习不一致\n请重新输入或找到正确的练习重拍");
        } else {
            this.b.errorTipInfo.setText("网络错误，请检查网络后重试");
        }
        this.b.errorTipInfo.setVisibility(0);
        this.b.btnRight.setEnabled(true);
        this.b.loading.setVisibility(8);
    }
}
