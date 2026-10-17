package com.up366.mobile.main;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AppResourceUpdateActivity extends com.up366.mobile.common.base.BaseActivity {
    public static final int TYPE_ASES = 1;
    public static final int TYPE_DICT = 4;
    public static final int TYPE_XOT = 2;
    private com.up366.mobile.databinding.ActivityEngineSourceUpdateLayoutBinding b;
    private boolean firstWait = true;
    private boolean hasConfirmNoneWifi;
    private com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager;
    private int retryCount;

    static /* synthetic */ void lambda$showNoSpaceDialog$10(android.view.View view) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.b = (com.up366.mobile.databinding.ActivityEngineSourceUpdateLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_engine_source_update_layout);
        hideBottomUIMenu(this);
        this.b.tip.setText("正在初始化...");
        this.b.tip.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        this.b.progress.setError(false);
        this.b.percentText.setTextColor(this.b.progress.getCurrentColor());
        this.b.progress.setOnAnimPercentUpdateListener(new com.up366.mobile.common.views.DownloadResourceProgressBarView.IOnAnimProgressUpdateListener() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.views.DownloadResourceProgressBarView.IOnAnimProgressUpdateListener
            public final void onUpdate(int i) {
                this.f$0.lambda$onCreate$0(i);
            }
        });
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onCreate$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(int i) {
        this.b.percentText.setText(com.up366.common.StringUtils.format("%d%%", java.lang.Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1() throws java.lang.Exception {
        fetchDownloadSync(true);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        this.b.lottie.playAnimation();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onPause() {
        super.onPause();
        this.b.lottie.pauseAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchDownloadSync(boolean z) throws java.lang.InterruptedException {
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> asesModelDownloadInfo = com.up366.mobile.common.helper.AppResourceUpdateHelper.getAsesModelDownloadInfo();
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> xotEngineDownloadInfo = com.up366.mobile.common.helper.AppResourceUpdateHelper.getXotEngineDownloadInfo();
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> dictModelDownloadInfo = com.up366.mobile.common.helper.AppResourceUpdateHelper.getDictModelDownloadInfo();
        if (asesModelDownloadInfo.resp.isError() || xotEngineDownloadInfo.resp.isError() || dictModelDownloadInfo.resp.isError()) {
            com.up366.common.log.Logger.error("TAG - EngineSourceUpdateActivity - fetchDownload - tool.onError " + asesModelDownloadInfo.resp.toString() + xotEngineDownloadInfo.resp.toString() + dictModelDownloadInfo.resp.toString());
            if (z && (asesModelDownloadInfo.resp.getCode() == -3 || xotEngineDownloadInfo.resp.getCode() == -3 || dictModelDownloadInfo.resp.getCode() == -3)) {
                com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
                fetchDownloadSync(false);
                return;
            } else {
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$fetchDownloadSync$2();
                    }
                });
                return;
            }
        }
        com.up366.common.download.DownloadInfo downloadInfo = asesModelDownloadInfo.info;
        com.up366.common.download.DownloadInfo downloadInfo2 = xotEngineDownloadInfo.info;
        com.up366.common.download.DownloadInfo downloadInfo3 = dictModelDownloadInfo.info;
        com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> diffAsesModelDownloadInfo = com.up366.mobile.common.helper.AppResourceUpdateHelper.getDiffAsesModelDownloadInfo();
        if (diffAsesModelDownloadInfo.info != null) {
            downloadInfo = diffAsesModelDownloadInfo.info;
        }
        checkAndDownload(downloadInfo, downloadInfo2, downloadInfo3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchDownloadSync$2() throws java.lang.Exception {
        this.b.progress.setError(true);
        this.b.percentText.setTextColor(this.b.progress.getCurrentColor());
        this.b.tip.setText(getTipNoNet());
    }

    private void checkAndDownload(com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.download.DownloadInfo downloadInfo2, com.up366.common.download.DownloadInfo downloadInfo3) {
        com.up366.common.log.Logger.info("TAG - AppResourceUpdateActivity - checkAndDownload - downloadInfoAses = [" + downloadInfo + "], downloadInfoXot = [" + downloadInfo2 + "], downloadInfoDict = [" + downloadInfo3 + "]");
        com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager = this.multiFileDownloadManager;
        com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager2 = new com.up366.mobile.common.utils.MultiFileDownloadManager(multiFileDownloadManager != null ? multiFileDownloadManager.getHasSuccessSize() : 0L);
        this.multiFileDownloadManager = multiFileDownloadManager2;
        multiFileDownloadManager2.setCheckNoneWifi(false);
        this.multiFileDownloadManager.setCheckPermission(false);
        com.up366.asecengine.englishengine.AsesModelHelper asesModelHelperCreate = com.up366.asecengine.englishengine.AsesModelHelper.create();
        if ((!com.up366.mobile.book.exercise.ExerciseResourceHelper.isExistResource() && downloadInfo2 != null) || (downloadInfo2 != null && com.up366.mobile.book.exercise.ExerciseResourceHelper.hasUpdate(downloadInfo2.getFileVersion()))) {
            this.multiFileDownloadManager.add(downloadInfo2);
        }
        if ((!com.up366.mobile.book.dict.DictResourceHelper.isExistResource() && downloadInfo3 != null) || (downloadInfo3 != null && com.up366.mobile.book.dict.DictResourceHelper.hasUpdate(downloadInfo3.getFileVersion()))) {
            this.multiFileDownloadManager.add(downloadInfo3);
        }
        if ((!asesModelHelperCreate.hasModel() && downloadInfo != null) || (downloadInfo != null && asesModelHelperCreate.hasUpdate(downloadInfo.getFileVersion()))) {
            this.multiFileDownloadManager.add(downloadInfo);
        }
        this.multiFileDownloadManager.setCallback(new com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda13
            @Override // com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback
            public final void onResult(int i, long j, long j2, int i2, java.lang.String str) {
                this.f$0.lambda$checkAndDownload$4(i, j, j2, i2, str);
            }
        });
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$checkAndDownload$5();
                }
            });
        } else if (com.up366.common.NetworkUtilsUp.isWifiConnect() || this.hasConfirmNoneWifi) {
            this.multiFileDownloadManager.startDownload();
        } else {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$checkAndDownload$9();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAndDownload$4(int i, long j, long j2, int i2, java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - AppResourceUpdateActivity - onResult - state = [" + i + "], progress = [" + j + "], total = [" + j2 + "], errCode = [" + i2 + "], errInfo = [" + str + "]");
        if (i == 4) {
            this.b.tip.setText("更新成功");
            com.up366.mobile.book.exercise.ExerciseResourceHelper.clearXotVersionCache();
            com.up366.mobile.book.dict.DictResourceHelper.clearDictVersionCache();
            com.up366.organize.PageTaskManager.getInst().finished(com.up366.mobile.main.PageTaskUtils.NAME_RESOURCE);
            com.up366.mobile.user.account.login.StaticTimeLoginHelper.INSTANCE.onReqDlComplete();
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("app-resource-update-success").invalid();
            com.up366.common.task.TaskUtils.postMainTaskDelay(800L, new com.up366.common.task.Task() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda10
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$checkAndDownload$3();
                }
            });
        }
        if (this.firstWait && i == 1 && str != null && !android.text.TextUtils.isEmpty(str) && str.contains("你学校的服务器正在准备资源")) {
            this.b.progress.setError(false);
            this.b.percentText.setTextColor(this.b.progress.getCurrentColor());
            this.b.tip.setText("资源正在准备中，可能需要1-2分钟，请勿退出…");
            this.firstWait = false;
        }
        if (i == 5) {
            if (str == null) {
                str = "";
            }
            if (!com.up366.common.NetworkUtilsUp.isConnected() || str.contains("hostname")) {
                this.b.tip.setText(getTipNoNet());
            } else if (str.contains("存储空间不足")) {
                this.b.tip.setText(getTipNoSpace());
                showNoSpaceDialog();
            } else {
                this.b.tip.setText(getTipLoadError(str));
            }
            this.b.progress.setError(true);
            this.b.percentText.setTextColor(this.b.progress.getCurrentColor());
        }
        if (i == 6) {
            this.b.progress.setError(true);
            this.b.percentText.setTextColor(this.b.progress.getCurrentColor());
            this.b.tip.setText(getTipNoNet());
        }
        if (i == 2) {
            this.b.progress.setError(false);
            this.b.percentText.setTextColor(this.b.progress.getCurrentColor());
            this.b.tip.setText(getTipLoading());
            this.b.progress.setProgress((int) ((j * 100) / j2));
        }
        if (i == 3) {
            this.b.tip.setText("校验中...");
            this.b.progress.setProgress(100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAndDownload$3() throws java.lang.Exception {
        finish();
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.AppResourceHasUpdateEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAndDownload$5() throws java.lang.Exception {
        this.b.progress.setError(true);
        this.b.percentText.setTextColor(this.b.progress.getCurrentColor());
        this.b.tip.setText(getTipNoNet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$checkAndDownload$9() throws java.lang.Exception {
        com.up366.mobile.common.dialog.AppDialog.create(this).title("非Wi-Fi网络提示").message("当前使用手机流量，下载完成大概需\n要耗费" + com.up366.common.ByteUtilsUp.bytesToMKB(this.multiFileDownloadManager.getTotalSize()) + "，确定继续吗？").left("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$checkAndDownload$6(view);
            }
        }).right("确定", new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$checkAndDownload$7(view);
            }
        }).setOnDissmissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                this.f$0.lambda$checkAndDownload$8(dialogInterface);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAndDownload$6(android.view.View view) {
        this.b.progress.setError(true);
        this.b.percentText.setTextColor(this.b.progress.getCurrentColor());
        this.b.tip.setText(getTipNoNet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAndDownload$7(android.view.View view) {
        this.hasConfirmNoneWifi = true;
        this.multiFileDownloadManager.startDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAndDownload$8(android.content.DialogInterface dialogInterface) {
        if (this.hasConfirmNoneWifi) {
            return;
        }
        this.b.progress.setError(true);
        this.b.percentText.setTextColor(this.b.progress.getCurrentColor());
        this.b.tip.setText(getTipNoNet());
    }

    private void showNoSpaceDialog() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showNoSpaceDialog$11();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showNoSpaceDialog$11() throws java.lang.Exception {
        com.up366.common.log.Logger.error("TAG - AppResourceUpdateActivity - showNoSpaceDialog - 手机存储空间不足，下载失败");
        com.up366.mobile.common.dialog.AppDialog.create(this).title("手机存储空间不足\n下载失败").message("请清理手机内存后重试").btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.main.AppResourceUpdateActivity.lambda$showNoSpaceDialog$10(view);
            }
        }).show();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        if (com.up366.mobile.common.utils.DataPostDelay.isNoOutOfDate("press_back")) {
            com.up366.common.download.DownloadManager.getInstance().pauseAllDownload();
            if (com.up366.qmui.util.QMUIDeviceHelper.isTablet(this)) {
                java.lang.System.exit(0);
                return;
            } else {
                finishAffinity();
                return;
            }
        }
        com.up366.mobile.common.utils.DataPostDelay.addCacheFlag("press_back", 3);
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "再按一次返回键退出应用。");
    }

    private java.lang.String getTipLoading() {
        return "资源包下载中，请勿退出，否则下次将重新下载";
    }

    private android.text.SpannableStringBuilder getTipPause() {
        return new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("下载已暂停，点击").append("重试").setSpan(getRetrySpan()).append("或").append("查看帮助").setSpan(getHelpSpan()).build();
    }

    private android.text.SpannableStringBuilder getTipNoNet() {
        return new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("资源包下载失败，连接不到网络，点击").append("重试").setSpan(getRetrySpan()).append("或").append("查看帮助").setSpan(getHelpSpan()).build();
    }

    private android.text.SpannableStringBuilder getTipLoadError(java.lang.String str) {
        com.up366.common.log.Logger.error("TAG - AppResourceUpdateActivity - getTipLoadError - message = [" + str + "]");
        return getTipNoNet();
    }

    private android.text.SpannableStringBuilder getTipNoSpace() {
        com.up366.common.log.Logger.error("TAG - AppResourceUpdateActivity - getTipNoSpace - 手机存储空间不足，下载失败");
        return new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("资源包下载失败，建议清理手机内存后，点击").append("重试").setSpan(getRetrySpan()).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    android.text.style.ClickableSpan getRetrySpan() {
        if (this.retryCount >= 3) {
            this.retryCount = 0;
            com.up366.mobile.common.dialog.AppDialog.create(this).title("下载失败，请检查手机网络是否正常\n稍后再试试。").btnOne("退出APP", new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$getRetrySpan$12(view);
                }
            }).show();
        }
        return new com.up366.mobile.main.AppResourceUpdateActivity.AnonymousClass1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRetrySpan$12(android.view.View view) {
        com.up366.common.download.DownloadManager.getInstance().pauseAllDownload();
        finishAffinity();
    }

    /* JADX INFO: renamed from: com.up366.mobile.main.AppResourceUpdateActivity$1, reason: invalid class name */
    class AnonymousClass1 extends android.text.style.ClickableSpan {
        AnonymousClass1() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(android.view.View view) {
            com.up366.mobile.main.AppResourceUpdateActivity.this.retryCount++;
            com.up366.mobile.main.AppResourceUpdateActivity.this.b.tip.setText("正在初始化...");
            com.up366.mobile.main.AppResourceUpdateActivity.this.b.progress.setError(false);
            com.up366.mobile.main.AppResourceUpdateActivity.this.b.percentText.setTextColor(com.up366.mobile.main.AppResourceUpdateActivity.this.b.progress.getCurrentColor());
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onClick$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0() throws java.lang.Exception {
            com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
            com.up366.mobile.main.AppResourceUpdateActivity.this.fetchDownloadSync(false);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(android.text.TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }
    }

    android.text.style.ClickableSpan getHelpSpan() {
        return new android.text.style.ClickableSpan() { // from class: com.up366.mobile.main.AppResourceUpdateActivity.2
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                com.up366.mobile.commonui.LookHelpActivity.openPage(com.up366.mobile.main.AppResourceUpdateActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                textPaint.setColor(textPaint.linkColor);
                textPaint.setUnderlineText(false);
            }
        };
    }

    public static void open(final android.app.Activity activity, final int i) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.AppResourceUpdateActivity$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.main.AppResourceUpdateActivity.lambda$open$13(activity, i);
            }
        });
    }

    static /* synthetic */ void lambda$open$13(android.app.Activity activity, int i) throws java.lang.Exception {
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.main.AppResourceUpdateActivity.class);
        intent.putExtra("types", i);
        activity.startActivity(intent);
    }

    public static void hideBottomUIMenu(android.app.Activity activity) {
        ((android.view.ViewGroup) activity.getWindow().getDecorView()).setSystemUiVisibility(5122);
    }
}
