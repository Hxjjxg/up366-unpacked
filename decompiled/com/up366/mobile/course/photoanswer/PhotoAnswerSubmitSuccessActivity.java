package com.up366.mobile.course.photoanswer;

/* JADX INFO: compiled from: PhotoAnswerSubmitSuccessActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/up366/mobile/course/photoanswer/PhotoAnswerSubmitSuccessActivity;", "Lcom/up366/mobile/common/base/BaseActivity;", "<init>", "()V", "fromType", "", "qrbKnow", "Landroid/view/View;", "tvScoreTips", "getCurrentPageName", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerSubmitSuccessActivity extends com.up366.mobile.common.base.BaseActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.course.photoanswer.PhotoAnswerSubmitSuccessActivity.Companion INSTANCE = new com.up366.mobile.course.photoanswer.PhotoAnswerSubmitSuccessActivity.Companion(null);
    private java.lang.String fromType = "";
    private android.view.View qrbKnow;
    private android.view.View tvScoreTips;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "smartroom_take_picture_submit";
    }

    /* JADX INFO: compiled from: PhotoAnswerSubmitSuccessActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/up366/mobile/course/photoanswer/PhotoAnswerSubmitSuccessActivity$Companion;", "", "<init>", "()V", "startActivity", "", "context", "Landroid/content/Context;", "fromType", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startActivity(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            startActivity(context, "");
        }

        public final void startActivity(android.content.Context context, java.lang.String fromType) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fromType, "fromType");
            android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.course.photoanswer.PhotoAnswerSubmitSuccessActivity.class);
            intent.putExtra(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.KEY_INTENT_FROM_TYPE, fromType);
            context.startActivity(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        java.lang.String strValueOf = java.lang.String.valueOf(getIntent().getStringExtra("fromType"));
        this.fromType = strValueOf;
        if (kotlin.jvm.internal.Intrinsics.areEqual(strValueOf, com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.FROM_TYPE_MG_BOOK_PRACTICE_)) {
            setContentView(com.up366.mobile.R.layout.photo_answer_submit_success_activity1);
            com.up366.qmui.util.QMUIStatusBarHelper.translucent((android.app.Activity) this);
        } else {
            setContentView(com.up366.mobile.R.layout.photo_answer_submit_success_activity);
        }
        android.view.View viewFindViewById = findViewById(com.up366.mobile.R.id.qrb_know);
        this.qrbKnow = viewFindViewById;
        android.view.View view = null;
        if (viewFindViewById == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("qrbKnow");
            viewFindViewById = null;
        }
        viewFindViewById.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerSubmitSuccessActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                this.f$0.finish();
            }
        });
        android.view.View viewFindViewById2 = findViewById(com.up366.mobile.R.id.tv_score_tips);
        this.tvScoreTips = viewFindViewById2;
        if (viewFindViewById2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvScoreTips");
        } else {
            view = viewFindViewById2;
        }
        view.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerSubmitSuccessActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                com.up366.mobile.course.photoanswer.PhotoAnswerSubmitSuccessActivity.onCreate$lambda$1(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreate$lambda$1(final com.up366.mobile.course.photoanswer.PhotoAnswerSubmitSuccessActivity photoAnswerSubmitSuccessActivity, android.view.View view) {
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.showDialog$default(com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE, (android.app.Activity) photoAnswerSubmitSuccessActivity, com.up366.mobile.course.photoanswer.dialog.DialogType.LOOK_SCORE_TIP_DIALOG, new com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerSubmitSuccessActivity$onCreate$2$1
            @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
            public void onCallback(int code, java.lang.Object info) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
                if (code == 1) {
                    try {
                        com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("gotoSetting", ""));
                        android.content.Intent intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(android.net.Uri.fromParts("package", this.this$0.getPackageName(), null));
                        this.this$0.startActivity(intent);
                    } catch (java.lang.Exception e) {
                        com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("P1pLookScoreDialogError", java.lang.String.valueOf(e.getMessage())));
                        com.up366.mobile.common.utils.ToastPopupUtil.show("操作失败了，请到应用设置页手动设置");
                    }
                }
            }
        }, null, 8, null);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.onDistroy();
        super.onDestroy();
    }
}
