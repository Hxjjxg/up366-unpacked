package com.up366.mobile.common.dialog;

/* JADX INFO: compiled from: DialogLoadingXiaoTian.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0006\u0010\u0014\u001a\u00020\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/up366/mobile/common/dialog/DialogLoadingXiaoTian;", "Lcom/up366/mobile/common/dialog/BaseDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "tipsView", "Landroid/widget/TextView;", "progressView", "Lcom/up366/mobile/common/views/DownloadProgressView;", "progressValueView", "closeBtn", "Landroid/view/View;", "setMessage", "msg", "", "showProgress", "", "progress", "", "showCloseBtn", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DialogLoadingXiaoTian extends com.up366.mobile.common.dialog.BaseDialog {
    private final android.view.View closeBtn;
    private final android.widget.TextView progressValueView;
    private final com.up366.mobile.common.views.DownloadProgressView progressView;
    private final android.widget.TextView tipsView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogLoadingXiaoTian(android.content.Context context) {
        super(context, com.up366.mobile.R.style.AppDialogTheme);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        create(com.up366.mobile.R.layout.dialog_loading_xiao_tian);
        this.tipsView = (android.widget.TextView) findViewById(com.up366.mobile.R.id.tv_loading_tips);
        com.up366.common.BitmapUtilsUp.display((android.widget.ImageView) findViewById(com.up366.mobile.R.id.giv_loading), com.up366.mobile.R.drawable.loading_xiao_tian);
        android.view.View viewFindViewById = findViewById(com.up366.mobile.R.id.close_btn);
        this.closeBtn = viewFindViewById;
        viewFindViewById.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.DialogLoadingXiaoTian$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.dismiss();
            }
        });
        com.up366.mobile.common.views.DownloadProgressView downloadProgressView = (com.up366.mobile.common.views.DownloadProgressView) findViewById(com.up366.mobile.R.id.progress_bar);
        this.progressView = downloadProgressView;
        this.progressValueView = (android.widget.TextView) findViewById(com.up366.mobile.R.id.progress_value);
        downloadProgressView.setState(1);
        findViewById(com.up366.mobile.R.id.giv_loading).setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.up366.mobile.common.dialog.DialogLoadingXiaoTian$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(android.view.View view) {
                return com.up366.mobile.common.dialog.DialogLoadingXiaoTian._init_$lambda$1(this.f$0, view);
            }
        });
        setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(com.up366.mobile.common.dialog.DialogLoadingXiaoTian dialogLoadingXiaoTian, android.view.View view) {
        dialogLoadingXiaoTian.dismiss();
        return false;
    }

    public final com.up366.mobile.common.dialog.DialogLoadingXiaoTian setMessage(java.lang.String msg) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(msg, "msg");
        java.lang.String str = msg;
        if (str.length() > 0) {
            this.tipsView.setVisibility(0);
            this.tipsView.setText(str);
        }
        return this;
    }

    public final void showProgress(int progress) {
        this.progressValueView.setText(progress + "%");
        this.progressView.setProgress(progress);
    }

    public final com.up366.mobile.common.dialog.DialogLoadingXiaoTian showCloseBtn() {
        this.closeBtn.setVisibility(0);
        return this;
    }
}
