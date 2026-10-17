package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ShareDialog {
    private com.up366.mobile.databinding.DialogShareLayoutBinding b;
    private final android.app.Activity context;
    private java.lang.Integer[] platforms;

    public ShareDialog(android.app.Activity activity) {
        this.context = activity;
    }

    public ShareDialog(android.app.Activity activity, java.lang.Integer[] numArr) {
        this.context = activity;
        this.platforms = numArr;
    }

    public void shareUrl(java.lang.String str, java.lang.String str2, java.lang.String str3, com.umeng.socialize.media.UMImage uMImage, com.up366.mobile.common.views.ShareView.ICaptureCallback iCaptureCallback, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        final com.up366.mobile.common.dialog.BaseDialog baseDialogCreateDialog = createDialog();
        this.b.img.setVisibility(4);
        if (iCaptureCallback == null) {
            this.b.shareView.setShareType(1);
        } else {
            this.b.shareView.setShareType(3);
            this.b.shareView.setCaptureCallback(iCaptureCallback);
        }
        this.b.shareView.setParams(str, str2, str3, uMImage);
        this.b.shareView.setShareCallback(new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.dialog.ShareDialog$$ExternalSyntheticLambda3
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str4) {
                com.up366.mobile.common.dialog.ShareDialog.lambda$shareUrl$0(iCallbackCodeInfo, baseDialogCreateDialog, i, str4);
            }
        });
        baseDialogCreateDialog.show();
    }

    static /* synthetic */ void lambda$shareUrl$0(com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo, com.up366.mobile.common.dialog.BaseDialog baseDialog, int i, java.lang.String str) {
        iCallbackCodeInfo.onResult(i, str);
        baseDialog.dismiss();
    }

    public void shareUrl(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.umeng.socialize.media.UMImage uMImage, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        final com.up366.mobile.common.dialog.BaseDialog baseDialogCreateDialog = createDialog();
        this.b.img.setVisibility(4);
        this.b.shareView.setShareType(1);
        this.b.shareView.setParams(str2, str3, str4, uMImage);
        if (!com.up366.common.StringUtils.isEmptyOrNull(str)) {
            this.b.shareView.setDialogTitle(str);
        }
        this.b.shareView.setBtnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.ShareDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.common.dialog.ShareDialog.lambda$shareUrl$1(baseDialogCreateDialog, view);
            }
        });
        this.b.shareView.setShareCallback(new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.dialog.ShareDialog$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str5) {
                com.up366.mobile.common.dialog.ShareDialog.lambda$shareUrl$2(baseDialogCreateDialog, iCallbackCodeInfo, i, str5);
            }
        });
        baseDialogCreateDialog.show();
    }

    static /* synthetic */ void lambda$shareUrl$1(final com.up366.mobile.common.dialog.BaseDialog baseDialog, android.view.View view) {
        java.util.Objects.requireNonNull(baseDialog);
        com.up366.common.task.TaskUtils.postMainTaskDelay(500L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.ShareDialog$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                baseDialog.dismiss();
            }
        });
    }

    static /* synthetic */ void lambda$shareUrl$2(com.up366.mobile.common.dialog.BaseDialog baseDialog, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo, int i, java.lang.String str) {
        if (i == 100) {
            baseDialog.dismiss();
        }
        if (!baseDialog.isShowing()) {
            i = 0;
        }
        iCallbackCodeInfo.onResult(i, str);
    }

    public void shareImage(android.graphics.Bitmap bitmap, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        if (!isActivityAlive()) {
            com.up366.common.log.Logger.info("ShareDialog error , activity is not alive, skip share result callback");
            return;
        }
        final com.up366.mobile.common.dialog.BaseDialog baseDialogCreateDialog = createDialog();
        this.b.img.setVisibility(0);
        com.bumptech.glide.Glide.with(this.context).load(bitmap).into(this.b.img);
        this.b.shareView.setShareType(2);
        this.b.shareView.setParams(bitmap);
        this.b.shareView.setShareCallback(new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.dialog.ShareDialog$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                com.up366.mobile.common.dialog.ShareDialog.lambda$shareImage$3(iCallbackCodeInfo, baseDialogCreateDialog, i, str);
            }
        });
        baseDialogCreateDialog.show();
    }

    static /* synthetic */ void lambda$shareImage$3(com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo, com.up366.mobile.common.dialog.BaseDialog baseDialog, int i, java.lang.String str) {
        iCallbackCodeInfo.onResult(i, str);
        baseDialog.dismiss();
    }

    private boolean isActivityAlive() {
        android.app.Activity activity = this.context;
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return !this.context.isDestroyed();
    }

    private com.up366.mobile.common.dialog.BaseDialog createDialog() {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(this.context, com.up366.mobile.common.utils.PlatformUtils.isHorizontalWideScreen(this.context) ? com.up366.mobile.R.style.AppThemeWhite_Dialog_Transparent : com.up366.mobile.R.style.LargeDialog) { // from class: com.up366.mobile.common.dialog.ShareDialog.1
            @Override // com.up366.mobile.common.dialog.BaseDialog, android.app.Dialog
            public void onBackPressed() {
                com.up366.mobile.common.dialog.ShareDialog.this.b.shareView.cancel();
            }
        };
        baseDialog.setCanceledOnTouchOutside(false);
        com.up366.mobile.databinding.DialogShareLayoutBinding dialogShareLayoutBinding = (com.up366.mobile.databinding.DialogShareLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(this.context), com.up366.mobile.R.layout.dialog_share_layout, (android.view.ViewGroup) null, false);
        this.b = dialogShareLayoutBinding;
        if (this.platforms != null) {
            dialogShareLayoutBinding.shareView.setSharePlatform(this.platforms);
        }
        baseDialog.create(this.b.getRoot());
        com.up366.mobile.common.utils.PlatformUtils.suitableForHorizontalWideScreenDialog(this.context, baseDialog);
        return baseDialog;
    }
}
