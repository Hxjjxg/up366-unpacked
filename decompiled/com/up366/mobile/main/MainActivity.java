package com.up366.mobile.main;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MainActivity extends com.up366.mobile.common.base.BaseActivity implements com.up366.mobile.book.StudyActivityInterface {
    private com.up366.mobile.databinding.ActivityMainBinding binding;
    public com.up366.mobile.main.PromotionDiagramHelper promotionDiagramHelper;
    private com.up366.mobile.common.helper.QRScanHelper qrScanHelper;
    private java.lang.String currentPageName = "smartroom_home";
    private int currentPage = -1;

    static /* synthetic */ void lambda$onMessageEvent$5(android.view.View view) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.book.StudyActivityInterface
    /* JADX INFO: renamed from: getContext */
    public android.app.Activity m1148getContext() {
        return this;
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginFailed authLoginFailed) {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return this.currentPageName;
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (com.up366.mobile.databinding.ActivityMainBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_main);
        final boolean z = true;
        com.up366.common.EventBusUtilsUp.register(this);
        com.up366.mobile.common.helper.ApplicationHelper.getInst().setMainStart(true);
        this.binding.getRoot().setSystemUiVisibility(9216);
        if (com.up366.mobile.common.utils.SkipBitmapBackGroundUtil.isSkipFromSplashActivity()) {
            this.binding.splashMask.setBackgroundResource(com.up366.mobile.R.drawable.splash_last);
            this.binding.topLayout.setVisibility(0);
        } else {
            z = false;
        }
        this.qrScanHelper = new com.up366.mobile.common.helper.QRScanHelper(this);
        this.promotionDiagramHelper = new com.up366.mobile.main.PromotionDiagramHelper();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.MainActivity$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onCreate$2(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(final boolean z) throws java.lang.Exception {
        this.promotionDiagramHelper.init();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.main.MainActivity$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onCreate$1(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(boolean z) throws java.lang.Exception {
        if (hasFinished()) {
            return;
        }
        if (z && this.promotionDiagramHelper.show) {
            this.promotionDiagramHelper.showPromotionDiagram(this.binding.btnPromotion, this.binding.promotion, this.binding.topLayout, this.binding.timer, this.binding.btnSkip);
        }
        reportEnterPage(0);
        showFragment(2131362178, com.up366.mobile.course.CourseFragment.class);
        com.up366.common.task.TaskUtils.postMainTaskDelay(50L, new com.up366.common.task.Task() { // from class: com.up366.mobile.main.MainActivity$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OnBottomTabSelected(2));
            }
        });
        com.up366.mobile.book.helper.AsesConfigHelper.fetchAsesConfig();
        this.promotionDiagramHelper.waitTask(new java.lang.Runnable() { // from class: com.up366.mobile.main.MainActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.main.PageTaskUtils.addShowDialogTask();
            }
        });
    }

    protected void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        if (getIntent().getIntExtra("homeIndex", 0) == 2) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OnBottomTabSelected(2));
        }
        com.up366.common.log.Logger.info("AiSkipHelper Activity onNewIntent: " + getClass().getSimpleName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        this.promotionDiagramHelper.onResume();
        this.promotionDiagramHelper.waitTask(new java.lang.Runnable() { // from class: com.up366.mobile.main.MainActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.organize.PageTaskManager.getInst().wakeUpStart();
            }
        });
        if (!com.up366.mobile.common.logic.Auth.isAuth()) {
            com.up366.mobile.user.account.login.AccountLoginActivity.open(this);
        }
        getWindow().getDecorView().postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.main.MainActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onResume$4();
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$4() {
        getWindow().getDecorView().requestLayout();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.mobile.common.helper.ApplicationHelper.getInst().setMainStart(false);
        com.up366.common.EventBusUtilsUp.unregister(this);
        this.promotionDiagramHelper.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        if (com.up366.mobile.closepad.PadConfigHelper.INSTANCE.isTX18Pad()) {
            com.up366.common.log.Logger.info("TX18Pad, onBackPressed");
            return;
        }
        if (com.up366.mobile.common.utils.DataPostDelay.isNoOutOfDate("press_back")) {
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

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginSuccess authLoginSuccess) {
        com.up366.mobile.common.compat.CountHelper.count(this);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OnBottomTabSelected(2));
        com.up366.mobile.main.PageTaskUtils.addStudyCardTask();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginout authLoginout) {
        finish();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.OnBottomTabSelected onBottomTabSelected) {
        int type = onBottomTabSelected.getType();
        if (type == 2) {
            reportEnterPage(0);
            this.currentPageName = "smartroom_home";
            showFragment(2131362178, com.up366.mobile.course.CourseFragment.class);
        } else if (type == 3) {
            reportEnterPage(2);
            this.currentPageName = "user_home";
            showFragment(2131362178, com.up366.mobile.me.MeFragment.class);
        } else if (type == 5) {
            reportEnterPage(1);
            this.currentPageName = "classroom_home";
            showFragment(2131362178, com.up366.mobile.main.SchoolHouseFragment.class);
        } else {
            throw new java.lang.IllegalStateException("unknown type " + onBottomTabSelected.getType());
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AddGuideTipMaskEvent addGuideTipMaskEvent) {
        this.binding.maskView.setVisibility(0);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.FinishGuideEvent finishGuideEvent) {
        this.binding.maskView.setVisibility(8);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OnBottomTabSelected(2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.ShowJumpErrorInfoEvent showJumpErrorInfoEvent) {
        if (showJumpErrorInfoEvent.type == 1) {
            com.up366.mobile.common.dialog.AppDialog.create(this).title("提示").message("扫码失败，当前不支持外部链接跳转").right("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.MainActivity$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.main.MainActivity.lambda$onMessageEvent$5(view);
                }
            }).show();
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, showJumpErrorInfoEvent.errorInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(final com.up366.mobile.common.event.SkipTaskActivityEvent skipTaskActivityEvent) {
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            if (skipTaskActivityEvent.isCurrent()) {
                com.up366.mobile.course.task.TaskActivity.startTaskActivity(this);
                return;
            } else {
                com.up366.mobile.course.task.TaskActivity.startTaskActivityShowHistory(this);
                return;
            }
        }
        com.up366.mobile.common.utils.SkipBitmapBackGroundUtil.skip(this, new com.up366.common.task.Task() { // from class: com.up366.mobile.main.MainActivity$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$6(skipTaskActivityEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onMessageEvent$6(com.up366.mobile.common.event.SkipTaskActivityEvent skipTaskActivityEvent) throws java.lang.Exception {
        if (skipTaskActivityEvent.isCurrent()) {
            com.up366.mobile.course.task.TaskActivity.startTaskActivity(this);
        } else {
            com.up366.mobile.course.task.TaskActivity.startTaskActivityShowHistory(this);
        }
    }

    public void hideSplashBackground() {
        this.promotionDiagramHelper.waitTask(new java.lang.Runnable() { // from class: com.up366.mobile.main.MainActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hideSplashBackground$7();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideSplashBackground$7() {
        if (this.promotionDiagramHelper.show) {
            return;
        }
        this.promotionDiagramHelper.hideMaskLayout(this.binding.topLayout, this.binding.promotion);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.ClearPageTaskEvent clearPageTaskEvent) {
        dismissDialogs();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.up366.mobile.common.helper.QRScanHelper qRScanHelper = this.qrScanHelper;
        if (qRScanHelper != null) {
            qRScanHelper.onActivityResult(i, i2, intent);
        }
    }

    public com.up366.mobile.common.helper.QRScanHelper getQrScanHelper() {
        return this.qrScanHelper;
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        if (commonUploadLogEvent.isSuccess() && commonUploadLogEvent.getType() == 24) {
            com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("submitSuccess", commonUploadLogEvent.getRefKey()));
            com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent();
        }
    }

    public void reportEnterPage(int i) {
        int i2 = this.currentPage;
        if (i2 == i) {
            return;
        }
        if (i2 == -1) {
            this.currentPage = i;
            return;
        }
        this.currentPage = i;
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("from", getPageName(i2));
        jSONObject.put("to", getPageName(this.currentPage));
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.APP, com.up366.mobile.common.onlinelog.OpLogData.Control.NAVIGATION_REPLACE, com.up366.mobile.common.onlinelog.OpLogData.Event.NAVIGATE, jSONObject);
    }

    private java.lang.String getPageName(int i) {
        if (i == 0) {
            return "smartroom_home";
        }
        if (i == 1) {
            return "classroom_home";
        }
        if (i == 2) {
            return "user_home";
        }
        return "unknown_" + i;
    }

    private com.up366.mobile.book.StudyActivityInterface delegate() {
        for (com.up366.mobile.book.StudyActivityInterface studyActivityInterface : getSupportFragmentManager().getFragments()) {
            if (studyActivityInterface != null && studyActivityInterface.isAdded() && !studyActivityInterface.isHidden() && (studyActivityInterface instanceof com.up366.mobile.book.StudyActivityInterface)) {
                return studyActivityInterface;
            }
        }
        com.up366.common.log.Logger.error("TAG - MainActivity - delegate() is null");
        return null;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.ContentDownloadHelper getContentDownloadHelper() {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            return studyActivityInterfaceDelegate.getContentDownloadHelper();
        }
        return null;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.BuyBookHelper getBuyBookHelper() {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            return studyActivityInterfaceDelegate.getBuyBookHelper();
        }
        return null;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.V8FilePathHelper getV8FilePathHelper() {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            return studyActivityInterfaceDelegate.getV8FilePathHelper();
        }
        return null;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.BookFilePathHelper getBookFilePathHelper() {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            return studyActivityInterfaceDelegate.getBookFilePathHelper();
        }
        return null;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.HeadsetHelper getHeadsetHelper() {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            return studyActivityInterfaceDelegate.getHeadsetHelper();
        }
        return null;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.exercise.js.TakePhotoHelper getTakePhotoHelper() {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            return studyActivityInterfaceDelegate.getTakePhotoHelper();
        }
        return null;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper getPhotoPickerClippedPhotoV2Helper() {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            return studyActivityInterfaceDelegate.getPhotoPickerClippedPhotoV2Helper();
        }
        return null;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.common.helper.QRScanHelper getQRScanHelper() {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            return studyActivityInterfaceDelegate.getQRScanHelper();
        }
        return null;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.model.OpenConfigInfo getOpenConfigInfo() {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            return studyActivityInterfaceDelegate.getOpenConfigInfo();
        }
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo();
        openConfigInfo.openUrl = com.up366.common.global.GB.get().getServerUrl("about:blank");
        return openConfigInfo;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.model.BookInfoStudy getBookInfoStudy() {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (delegate() != null) {
            return studyActivityInterfaceDelegate.getBookInfoStudy();
        }
        return null;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.model.TreeBookChapter getBookChapterInfo() {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (delegate() != null) {
            return studyActivityInterfaceDelegate.getBookChapterInfo();
        }
        return null;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.common.views.TitleBarView getTitleBar() {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (delegate() != null) {
            return studyActivityInterfaceDelegate.getTitleBar();
        }
        return null;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoadErrorTip(java.lang.String str, java.lang.String str2) {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            studyActivityInterfaceDelegate.showLoadErrorTip(str, str2);
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showDownloadLoadingView() {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            studyActivityInterfaceDelegate.showDownloadLoadingView();
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void updateDownloadLoadingView(int i, long j, long j2, java.lang.String str, java.lang.Runnable runnable) {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            studyActivityInterfaceDelegate.updateDownloadLoadingView(i, j, j2, str, runnable);
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void qrScan(androidx.core.util.Consumer<java.lang.String> consumer) {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            studyActivityInterfaceDelegate.qrScan(consumer);
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoading(boolean z, boolean z2) {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            studyActivityInterfaceDelegate.showLoading(z, z2);
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoading(boolean z) {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            studyActivityInterfaceDelegate.showLoading(z);
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoadingTitleBar(boolean z) {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            studyActivityInterfaceDelegate.showLoadingTitleBar(z);
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void buildBookPagePathV8(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            studyActivityInterfaceDelegate.buildBookPagePathV8(bookInfoStudy);
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void buildBookPagePath(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.CatalogPage catalogPage) {
        com.up366.mobile.book.StudyActivityInterface studyActivityInterfaceDelegate = delegate();
        if (studyActivityInterfaceDelegate != null) {
            studyActivityInterfaceDelegate.buildBookPagePath(bookInfoStudy, catalogPage);
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public android.view.View getRootView() {
        return this.binding.getRoot();
    }
}
