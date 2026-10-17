package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PraiseDialog {
    public final com.up366.mobile.databinding.PraiseDialogLayoutBinding b;
    private final android.content.Context context;
    private final android.app.Dialog dialog;

    private PraiseDialog(android.content.Context context) {
        this.context = context;
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(context, com.up366.mobile.R.style.AppDialogTheme_Transparent);
        this.dialog = baseDialog;
        com.up366.mobile.databinding.PraiseDialogLayoutBinding praiseDialogLayoutBinding = (com.up366.mobile.databinding.PraiseDialogLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.praise_dialog_layout, (android.view.ViewGroup) null, false);
        this.b = praiseDialogLayoutBinding;
        baseDialog.setContentView(praiseDialogLayoutBinding.getRoot());
        baseDialog.setCancelable(false);
        init();
    }

    public static com.up366.mobile.common.dialog.PraiseDialog create(android.content.Context context) {
        return new com.up366.mobile.common.dialog.PraiseDialog(context);
    }

    private void init() {
        this.b.btnPraise.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.PraiseDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$0(view);
            }
        });
        this.b.btnRoast.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.PraiseDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$1(view);
            }
        });
        this.b.btnClose.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.PraiseDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(android.view.View view) {
        startPraiseMarket(this.context);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(android.view.View view) {
        com.up366.mobile.me.feedback.FeedbackActivity.openPage(view.getContext());
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(android.view.View view) {
        dismiss();
    }

    public static void startPraiseMarket(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse("market://details?id=com.up366.mobile"));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            try {
                context.startActivity(intent);
                return;
            } catch (java.lang.Exception unused) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) context, "请手动在应用市场中搜索 \"天学网学生\" 进行评分");
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) context, "请手动在应用市场中搜索 \"天学网学生\" 进行评分");
    }

    public void dismiss() {
        this.dialog.dismiss();
    }

    public com.up366.mobile.common.dialog.PraiseDialog show() {
        if (!this.dialog.isShowing()) {
            java.lang.Long l = (java.lang.Long) com.up366.mobile.common.logic.Auth.cur().cache().get("started-App-time", (java.lang.Class<long>) java.lang.Long.class, 0L);
            java.lang.Long l2 = (java.lang.Long) com.up366.mobile.common.logic.Auth.cur().cache().get("PraiseDialog-time", (java.lang.Class<long>) java.lang.Long.class, 0L);
            long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
            if (currentNtpTimeInMillisecond - l2.longValue() > 2592000000L && currentNtpTimeInMillisecond - l.longValue() <= 2592000000L) {
                com.up366.mobile.common.logic.Auth.cur().cache().put("PraiseDialog-time", java.lang.Long.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()), com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
                this.dialog.show();
            }
        }
        return this;
    }
}
