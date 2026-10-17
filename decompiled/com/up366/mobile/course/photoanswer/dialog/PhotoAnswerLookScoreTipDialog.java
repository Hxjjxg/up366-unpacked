package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: PhotoAnswerLookScoreTipDialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/PhotoAnswerLookScoreTipDialog;", "Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "b", "Lcom/up366/mobile/databinding/DialogP1pLookScoreGuideBinding;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerLookScoreTipDialog extends com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog {
    private final com.up366.mobile.databinding.DialogP1pLookScoreGuideBinding b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoAnswerLookScoreTipDialog(android.content.Context context) {
        super(context, 0, 2, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.databinding.DialogP1pLookScoreGuideBinding dialogP1pLookScoreGuideBindingInflate = com.up366.mobile.databinding.DialogP1pLookScoreGuideBinding.inflate(android.view.LayoutInflater.from(context), null, false);
        this.b = dialogP1pLookScoreGuideBindingInflate;
        dialogP1pLookScoreGuideBindingInflate.llContent.setBackground(com.up366.mobile.common.utils.ShapeDrawableUtils.createShapeDrawable(5, "#FFF8F8F8"));
        dialogP1pLookScoreGuideBindingInflate.tvWayOne.setText("微信搜索\"天学英语家长圈\"公众号，关注后点击\"孩子学情\"，绑定帐号即可");
        setContentView((android.view.View) dialogP1pLookScoreGuideBindingInflate.getRoot());
        setCancelable(false);
        dialogP1pLookScoreGuideBindingInflate.qrbKnow.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoAnswerLookScoreTipDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoAnswerLookScoreTipDialog._init_$lambda$0(this.f$0, view);
            }
        });
        dialogP1pLookScoreGuideBindingInflate.tvOpen.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoAnswerLookScoreTipDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoAnswerLookScoreTipDialog._init_$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerLookScoreTipDialog photoAnswerLookScoreTipDialog, android.view.View view) {
        photoAnswerLookScoreTipDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoAnswerLookScoreTipDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 2, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerLookScoreTipDialog photoAnswerLookScoreTipDialog, android.view.View view) {
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoAnswerLookScoreTipDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 1, null, 2, null);
    }
}
