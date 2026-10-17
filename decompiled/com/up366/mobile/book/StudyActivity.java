package com.up366.mobile.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyActivity extends com.up366.mobile.common.base.BaseActivity implements com.up366.mobile.book.StudyActivityInterface {
    public com.up366.mobile.book.model.BookInfoStudy book;
    public com.up366.mobile.book.model.TreeBookChapter bookChapterInfo;
    public com.up366.mobile.book.helper.BookFilePathHelper bookFilePathHelper;
    public com.up366.mobile.book.helper.BookOpenStudyHelper bookOpenStudyHelper;
    public com.up366.mobile.book.helper.BookStudyInfoHelper bookStudyInfoHelper;
    private java.lang.String buildPagePath;
    public com.up366.mobile.book.helper.BuyBookHelper buyBookHelper;
    public com.up366.mobile.book.model.OpenConfigInfo cfg;
    public android.widget.FrameLayout container;
    private android.widget.FrameLayout containerTop;
    public com.up366.mobile.book.helper.ContentDownloadHelper contentDownloadHelper;
    public com.up366.mobile.book.helper.HeadsetHelper headsetHelper;
    public java.lang.String lastStartRecordId;
    private int loadingState;
    private com.up366.mobile.book.studyviews.view.BookLoadingView loadingView;
    private com.up366.mobile.book.helper.PageEventRecordHelper pageEventRecordHelper;
    public com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper pickerClippedPhotoV2Helper;
    public android.view.View rootView;
    public com.up366.mobile.common.helper.QRScanHelper scanHelper;
    private com.up366.mobile.book.helper.StateDetectHelper stateDetectHelper;
    public com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper;
    private com.up366.mobile.common.dialog.DialogOkCancleV2 tipDialog;
    public com.up366.mobile.common.views.TitleBarView titleBar;
    public com.up366.mobile.book.helper.V8FilePathHelper v8FilePathHelper;
    public com.up366.mobile.book.helper.V9FilePathHelper v9FilePathHelper;
    public com.up366.mobile.book.helper.ViewDetectHelper viewDetectHelper;
    private boolean controlShowLoadingByJs = false;
    private boolean onLoadingWebData_ = false;
    private boolean isGotoUpdatePhonePassword = false;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.book.StudyActivityInterface
    public android.app.Activity getContext() {
        return this;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void qrScan(androidx.core.util.Consumer<java.lang.String> consumer) {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected boolean shouldRecordEnterPageEvent() {
        return false;
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.cfg;
        if (openConfigInfo != null) {
            java.lang.String str = openConfigInfo.openUrl;
            if (com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.LICENSE_URL).equals(str)) {
                return "agreement_permission";
            }
            if (com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.PRIVACY_URL).equals(str)) {
                return "agreement_privacy";
            }
            if (com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.BABY_PRIVACY_URL).equals(str)) {
                return "agreement_childrenprivacy";
            }
            if (com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.SELF_INFO_URL).equals(str) || com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.SELF_INFO_COLLECT_URL).equals(str)) {
                return "agreement_checklist";
            }
            if (com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.THIRD_INFO_URL).equals(str)) {
                return "agreement_thirdparty";
            }
        }
        return "study_book";
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.up366.mobile.R.layout.book_main_activity);
        getWindow().addFlags(128);
        com.up366.mobile.common.helper.ApplicationHelper.getInst().addStudyActivityCount();
        if (com.up366.mobile.common.utils.PlatformUtils.isPadOkay()) {
            com.up366.notchtools.NotchTools.getInst().fullScreenUseStatus(this);
        }
        com.up366.asecengine.englishengine.AsecEngineHelper asecEngineHelperCreate = com.up366.asecengine.englishengine.AsecEngineHelper.create(com.up366.common.global.GB.get().getApplicationContext());
        asecEngineHelperCreate.setUseNewRecordFactory(com.up366.mobile.common.logic.Auth.cur().config().isEnableUseNewRecord());
        com.up366.library.opusencoder.OpusParams opusParams = new com.up366.library.opusencoder.OpusParams();
        opusParams.setEnable(true);
        asecEngineHelperCreate.updateOpusParams(opusParams);
        com.up366.common.log.Logger.info("TAG - StudyActivity - onCreate - configuration - changingConfigurations : " + getChangingConfigurations() + " configuration : " + getResources().getConfiguration().toString() + " isInMultiWindowMode:" + (android.os.Build.VERSION.SDK_INT >= 24 ? isInMultiWindowMode() : false));
        initViews();
        if (!initIntentData()) {
            finish();
            com.up366.common.log.Logger.error("TAG - StudyActivity - onCreate - initIntentData() error!");
            return;
        }
        if (!this.cfg.isExercise() && this.book == null) {
            finish();
            com.up366.mobile.common.onlinelog.OpLog.report("ERROR-StudyActivity-getSerializableExtra", "getSerializableExtra(\"book\") book == null");
            return;
        }
        com.up366.common.EventBusUtilsUp.register(this);
        com.up366.mobile.book.helper.StudyParamsChecker.check(this.cfg, getIntent());
        com.up366.mobile.book.activity.BookDataCache.getInstance().addToQueue(this);
        this.pageEventRecordHelper = new com.up366.mobile.book.helper.PageEventRecordHelper(this.book, this.cfg);
        this.headsetHelper = new com.up366.mobile.book.helper.HeadsetHelper(this);
        com.up366.mobile.common.helper.QRScanHelper qRScanHelper = new com.up366.mobile.common.helper.QRScanHelper(this);
        this.scanHelper = qRScanHelper;
        qRScanHelper.setJumpActivity(false);
        final android.view.View viewFindViewById = findViewById(com.up366.mobile.R.id.root_view);
        new com.up366.mobile.common.helper.SoftKeyboardChangeHelper(viewFindViewById).onChange(new com.up366.mobile.common.helper.SoftKeyboardChangeHelper.IOnChangeListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda22
            @Override // com.up366.mobile.common.helper.SoftKeyboardChangeHelper.IOnChangeListener
            public final void onChange(boolean z, boolean z2, int i, int i2) {
                com.up366.mobile.book.StudyActivity.lambda$onCreate$0(viewFindViewById, z, z2, i, i2);
            }
        }).watch(new android.view.View[0]);
        initPageDetectData();
        final java.lang.String str = (java.lang.String) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync("jump-job-study-page-path");
        com.up366.mobile.common.logic.Auth.cur().cache().clear("jump-job-study-page-path");
        new androidx.core.util.Supplier() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda33
            public final java.lang.Object get() {
                return this.f$0.lambda$onCreate$1(str);
            }
        };
    }

    static /* synthetic */ void lambda$onCreate$0(android.view.View view, boolean z, boolean z2, int i, int i2) {
        if (z == z2) {
            return;
        }
        if (z2) {
            view.getLayoutParams().height = i2;
            view.requestLayout();
        } else {
            view.getLayoutParams().height = -1;
            view.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.String lambda$onCreate$1(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? this.buildPagePath : str;
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void reportEnterEvent() {
        com.up366.mobile.book.helper.PageEventRecordHelper pageEventRecordHelper = this.pageEventRecordHelper;
        if (pageEventRecordHelper != null) {
            pageEventRecordHelper.onEnter();
        }
    }

    public void onMultiWindowModeChanged(boolean z, android.content.res.Configuration configuration) {
        super.onMultiWindowModeChanged(z, configuration);
        com.up366.common.log.Logger.info("TAG - StudyActivity - onMultiWindowModeChanged - isInMultiWindowMode = [" + z + "], newConfig = [" + configuration + "]");
    }

    public void onTopResumedActivityChanged(boolean z) {
        com.up366.common.log.Logger.info("TAG - StudyActivity - onTopResumedActivityChanged - topResumed = [" + z + "]");
        this.viewDetectHelper.onTopResumedActivityChanged(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.up366.common.log.Logger.info("TAG - StudyActivity - onConfigurationChanged - " + configuration);
        com.up366.mobile.common.utils.PlatformUtils.updateSuitableForHorizontalWideScreen(this);
    }

    private void initPageDetectData() {
        if (this.cfg.isDict()) {
            initDictHelpers();
            detectCurrentState(true);
        } else if (this.cfg.isExercise()) {
            initExerciseHelpers();
            detectCurrentState(true);
        } else {
            this.titleBar.setTitle(this.cfg.title);
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda38
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$initPageDetectData$3();
                }
            });
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda39
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initPageDetectData$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPageDetectData$3() throws java.lang.Exception {
        com.up366.common.http.NetHolder<com.up366.mobile.book.model.BookDetailInfo> netHolder = new com.up366.common.http.NetHolder<>();
        boolean zInitCheckBook = com.up366.mobile.book.helper.Tools.initCheckBook(this.book, this.cfg, netHolder, new com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda29(this), new com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda30(this), new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda35
            public final void accept(java.lang.Object obj) {
                this.f$0.lambda$initPageDetectData$2((com.up366.common.http.Response) obj);
            }
        }, new com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda32(this));
        com.up366.common.log.Logger.info("TAG - StudyActivity - initPageDetectData - isV9BookOrV8BookOrError:" + zInitCheckBook);
        if (zInitCheckBook) {
            return;
        }
        initBookState();
        initBookHelpers();
        if (!this.bookChapterInfo.isHasLoadTreeChapterData()) {
            this.onLoadingWebData_ = true;
            detectCurrentState(false);
            com.up366.mobile.common.logic.Auth.cur().book().loadChapterPlanAndFinishedTaskSync(this.bookChapterInfo, !android.text.TextUtils.isEmpty(this.cfg.studyTaskId));
            if (!this.book.isForceReloadChapterData()) {
                detectCurrentState(false);
            }
            this.book.setForceReloadChapterData(false);
            com.up366.common.http.NetHolder<com.up366.mobile.book.model.TreeBookChapter> netHolderFetchChapterPlanAndFinishedTaskSync = com.up366.mobile.common.logic.Auth.cur().book().fetchChapterPlanAndFinishedTaskSync(this.bookChapterInfo, !android.text.TextUtils.isEmpty(this.cfg.studyTaskId), netHolder);
            this.onLoadingWebData_ = false;
            if (!this.cfg.isOpenPage() && !this.book.isHasBuy() && this.cfg.isCatalog()) {
                showNoBugDialogV2();
                return;
            } else if (netHolderFetchChapterPlanAndFinishedTaskSync.resp.isError()) {
                showLoadWebDataErrorTip(netHolderFetchChapterPlanAndFinishedTaskSync.resp.getCode());
                return;
            } else {
                detectCurrentState(true);
                return;
            }
        }
        detectCurrentState(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPageDetectData$2(com.up366.common.http.Response response) {
        showLoadWebDataErrorTip(response.getCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPageDetectData$4() throws java.lang.Exception {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudyConvertToRealOpenBook;
        com.alibaba.fastjson.JSONObject object;
        try {
            com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.cfg;
            if ((openConfigInfo == null || com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.commonParams) || (object = com.alibaba.fastjson.JSON.parseObject(this.cfg.commonParams)) == null || !object.containsKey("studyTaskDetail") || com.up366.common.StringUtils.isEmptyOrNull(object.getString("studyTaskDetail"))) && (bookInfoStudyConvertToRealOpenBook = com.up366.mobile.book.helper.Tools.convertToRealOpenBook(this.book, this.cfg)) != null) {
                com.up366.mobile.common.logic.Auth.cur().bookProgress().update(bookInfoStudyConvertToRealOpenBook);
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - StudyActivity - initPageDetectData - error:" + e);
        }
    }

    private void showNoBugDialogV2() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda42
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showNoBugDialogV2$6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showNoBugDialogV2$6() throws java.lang.Exception {
        com.up366.mobile.common.dialog.AppDialog.create(this).title("温馨提示").message("您没有权限使用《" + this.book.getBookName() + "》，请联系教学顾问。").btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showNoBugDialogV2$5(view);
            }
        }).setBtnCloseVisibility(4).setCancelable(false).show();
        this.viewDetectHelper.resetPage();
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
        showLoading(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNoBugDialogV2$5(android.view.View view) {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initBookHelpers() {
        this.bookFilePathHelper = new com.up366.mobile.book.helper.BookFilePathHelper(this.book, this.bookChapterInfo);
        this.takePhotoHelper = new com.up366.mobile.book.exercise.js.TakePhotoHelper(this);
        this.bookStudyInfoHelper = new com.up366.mobile.book.helper.BookStudyInfoHelper(this.book);
        this.buyBookHelper = new com.up366.mobile.book.helper.BuyBookHelper(this, this.book);
        this.contentDownloadHelper = new com.up366.mobile.book.helper.ContentDownloadHelper(this, this.bookFilePathHelper);
        this.bookOpenStudyHelper = new com.up366.mobile.book.helper.BookOpenStudyHelper(this);
        this.pickerClippedPhotoV2Helper = new com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper(this, com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.REQUEST_CODE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initExerciseHelpers() {
        this.takePhotoHelper = new com.up366.mobile.book.exercise.js.TakePhotoHelper(this);
        this.contentDownloadHelper = new com.up366.mobile.book.helper.ContentDownloadHelper(this);
        this.pickerClippedPhotoV2Helper = new com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper(this, com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.REQUEST_CODE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initDictHelpers() {
        this.takePhotoHelper = new com.up366.mobile.book.exercise.js.TakePhotoHelper(this);
        this.contentDownloadHelper = new com.up366.mobile.book.helper.ContentDownloadHelper(this);
        this.pickerClippedPhotoV2Helper = new com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper(this, com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.REQUEST_CODE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void initSDKHelpers(com.up366.mobile.book.helper.Tools.JsSdkType jsSdkType) {
        this.takePhotoHelper = new com.up366.mobile.book.exercise.js.TakePhotoHelper(this);
        this.contentDownloadHelper = new com.up366.mobile.book.helper.ContentDownloadHelper(this);
        this.pickerClippedPhotoV2Helper = new com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper(this, com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper.REQUEST_CODE);
        if (jsSdkType == com.up366.mobile.book.helper.Tools.JsSdkType.V8) {
            this.v8FilePathHelper = new com.up366.mobile.book.helper.V8FilePathHelper();
        } else if (jsSdkType == com.up366.mobile.book.helper.Tools.JsSdkType.V9) {
            this.v9FilePathHelper = new com.up366.mobile.book.helper.V9FilePathHelper();
        }
    }

    private void initBookState() {
        this.book.initHasBuy();
        this.book.setBookChapterInfo(this.bookChapterInfo);
        this.bookChapterInfo.init(this.book);
    }

    private boolean initIntentData() {
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo;
        try {
            java.lang.String stringExtra = getIntent().getStringExtra("exercise_type");
            com.up366.mobile.book.model.OpenConfigInfo openConfigInfo2 = (com.up366.mobile.book.model.OpenConfigInfo) getIntent().getSerializableExtra("cfg");
            this.cfg = openConfigInfo2;
            if (openConfigInfo2 != null && openConfigInfo2.isDict()) {
                com.up366.common.log.Logger.info("TAG - StudyActivity - initIntentData - open from dict : " + this.cfg);
            } else if (!com.up366.common.StringUtils.isEmptyOrNull(stringExtra) || ((openConfigInfo = this.cfg) != null && !com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.exerciseType))) {
                java.lang.String stringExtra2 = getIntent().getStringExtra(com.up366.greendao.ExerciseDataDao.TABLENAME);
                if (this.cfg == null) {
                    com.up366.mobile.book.model.OpenConfigInfo openConfigInfo3 = new com.up366.mobile.book.model.OpenConfigInfo();
                    this.cfg = openConfigInfo3;
                    openConfigInfo3.exerciseType = stringExtra;
                    this.cfg.exerciseData = stringExtra2;
                }
                com.up366.common.log.Logger.info("TAG - StudyActivity - initIntentData - exerciseType : " + stringExtra + " exerciseData : " + stringExtra2);
            } else {
                java.io.Serializable serializableExtra = getIntent().getSerializableExtra("book");
                java.lang.String stringExtra3 = getIntent().getStringExtra("from");
                if (serializableExtra == null) {
                    return false;
                }
                if (com.up366.mobile.AiSkipHelper.isMoLiSkip(stringExtra3) && !com.up366.mobile.AiSkipHelper.isHasShowAppUpdateDialog()) {
                    checkAppUpdate();
                }
                com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = (com.up366.mobile.book.model.BookInfoStudy) serializableExtra;
                this.book = bookInfoStudy;
                this.book = bookInfoStudy.m466clone();
                com.up366.common.log.Logger.info("TAG - StudyActivity - initIntentData - book:" + this.book);
                com.up366.mobile.book.model.OpenConfigInfo openConfigInfo4 = this.cfg;
                if (openConfigInfo4 == null) {
                    this.cfg = new com.up366.mobile.book.model.OpenConfigInfo(this.book);
                    com.up366.mobile.book.activity.BookDataCache.getInstance().clear(this.book.getCourseId(), this.book.getBookId());
                } else if (openConfigInfo4.range != null) {
                    this.cfg.initRangeFromIntent = true;
                }
                com.up366.common.log.Logger.info("TAG - StudyActivity - initIntentData - cfg:" + this.cfg);
                com.up366.mobile.book.model.TreeBookChapter treeBookChapter = com.up366.mobile.book.activity.BookDataCache.getInstance().getTreeBookChapter(this.book.getCourseId(), this.book.getBookId());
                this.bookChapterInfo = treeBookChapter;
                if (treeBookChapter.getBook() != null && this.bookChapterInfo.getBook().getBookId() != null && !android.text.TextUtils.equals(this.bookChapterInfo.getBook().getBookId(), com.up366.mobile.book.helper.Tools.common2025BookId)) {
                    this.book = this.bookChapterInfo.getBook().m466clone();
                    com.up366.common.log.Logger.info("TAG - StudyActivity - initIntentData - BookDataCache - book:" + this.book);
                }
            }
            com.up366.mobile.common.onlinelog.OpLogData.INSTANCE.setupBehavior(this.cfg, this.book, getIntent());
            com.up366.mobile.book.helper.Tools.setupTrackContext(this.book, this.cfg);
            return true;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("StudyActivity - initIntentData - ERROR!", e);
            return false;
        }
    }

    private void checkAppUpdate() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda11
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$checkAppUpdate$8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAppUpdate$8() throws java.lang.Exception {
        final java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
        if (!com.up366.mobile.common.logic.Auth.cur().config().hasAliTokenMap()) {
            atomicBoolean.set(true);
            com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda36
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$checkAppUpdate$7(atomicBoolean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$checkAppUpdate$7(java.util.concurrent.atomic.AtomicBoolean atomicBoolean) throws java.lang.Exception {
        if (!atomicBoolean.get() && com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - com.up366.mobile.common.logic.Auth.cur().config().getLastFetchAllSyncTime() > 1000) {
            com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
        }
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> netHolderFetchModelMapSync = com.up366.mobile.common.logic.Auth.cur().config().fetchModelMapSync(com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel(), com.up366.mobile.BuildConfig.VERSION_CODE);
        if (netHolderFetchModelMapSync.info != null && netHolderFetchModelMapSync.info.getVersion() > 220) {
            com.up366.mobile.AiSkipHelper.setHasShowAppUpdateDialog(true);
            com.up366.mobile.common.utils.UpdateModule.getInstance().checkNewVersionAuto();
        } else {
            this.isGotoUpdatePhonePassword = true;
            com.up366.mobile.main.PhonePasswordUpdateHelper.INSTANCE.skip(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initViews() {
        this.rootView = findViewById(com.up366.mobile.R.id.root_view);
        this.container = (android.widget.FrameLayout) findViewById(2131362178);
        this.containerTop = (android.widget.FrameLayout) findViewById(2131363488);
        this.titleBar = (com.up366.mobile.common.views.TitleBarView) findViewById(com.up366.mobile.R.id.title_bar);
        com.up366.mobile.book.studyviews.view.BookLoadingView bookLoadingView = new com.up366.mobile.book.studyviews.view.BookLoadingView(this);
        this.loadingView = bookLoadingView;
        this.containerTop.addView(bookLoadingView);
        this.loadingView.setData(0);
        this.viewDetectHelper = new com.up366.mobile.book.helper.ViewDetectHelper(this);
        this.stateDetectHelper = new com.up366.mobile.book.helper.StateDetectHelper(this);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void reportPageDuration(long j) {
        com.up366.mobile.book.helper.PageEventRecordHelper pageEventRecordHelper = this.pageEventRecordHelper;
        if (pageEventRecordHelper != null) {
            pageEventRecordHelper.onExit(this.staticEnterTime, j);
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.mobile.book.activity.BookDataCache.getInstance().removeFromQueue(this);
        com.up366.mobile.book.helper.ViewDetectHelper viewDetectHelper = this.viewDetectHelper;
        if (viewDetectHelper != null) {
            viewDetectHelper.onPageDestroy();
            this.viewDetectHelper = null;
        }
        com.up366.mobile.common.helper.ApplicationHelper.getInst().subStudyActivityCount();
        com.up366.common.EventBusUtilsUp.unregister(this);
        if (this.book != null) {
            com.up366.mobile.book.activity.BookDataCache.getInstance().clear(this.book.getCourseId(), this.book.getBookId());
        }
        if (!android.text.TextUtils.isEmpty(this.lastStartRecordId)) {
            com.up366.asecengine.englishengine.AsecEngineHelper asecEngineHelperCreate = com.up366.asecengine.englishengine.AsecEngineHelper.create(com.up366.common.global.GB.get().getApplicationContext());
            asecEngineHelperCreate.setOnFFTUpdateListener(null);
            asecEngineHelperCreate.setWaveUpdateListener(null);
            asecEngineHelperCreate.setOnStateChangeListener(null);
        }
        super.onDestroy();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("resume", "study-activity-lifecycle-" + hashCode()).run(new java.lang.Runnable() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onResume$9();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$9() {
        com.up366.mobile.book.helper.Tools.setupTrackContext(this.book, this.cfg);
        this.viewDetectHelper.onResume();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onPause() {
        super.onPause();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("pause", "study-activity-lifecycle-" + hashCode()).run(new java.lang.Runnable() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPause$10();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPause$10() {
        this.viewDetectHelper.onPause();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public void startActivity(android.content.Intent intent, android.os.Bundle bundle) {
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("study-activity-lifecycle-" + hashCode()).invalid();
        super.startActivity(intent, bundle);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onStart() {
        super.onStart();
        this.viewDetectHelper.onResume();
        com.up366.mobile.book.helper.PageEventRecordHelper pageEventRecordHelper = this.pageEventRecordHelper;
        if (pageEventRecordHelper != null) {
            pageEventRecordHelper.onStart();
        }
        com.up366.mobile.book.helper.HeadsetHelper headsetHelper = this.headsetHelper;
        if (headsetHelper != null) {
            headsetHelper.register();
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onStop() {
        super.onStop();
        com.up366.mobile.book.helper.ContentDownloadHelper contentDownloadHelper = this.contentDownloadHelper;
        if (contentDownloadHelper != null && !this.isGotoUpdatePhonePassword) {
            contentDownloadHelper.pauseCurrentDownload();
        }
        if (this.isGotoUpdatePhonePassword) {
            this.isGotoUpdatePhonePassword = false;
        }
        this.viewDetectHelper.onPause();
        com.up366.mobile.book.helper.PageEventRecordHelper pageEventRecordHelper = this.pageEventRecordHelper;
        if (pageEventRecordHelper != null) {
            pageEventRecordHelper.onStop(this.staticEnterTime, this.staticTotalDuration);
        }
        com.up366.mobile.book.helper.HeadsetHelper headsetHelper = this.headsetHelper;
        if (headsetHelper != null) {
            headsetHelper.unRegister();
        }
    }

    public void onBackPressed() {
        if (getOnBackPressedDispatcher().hasEnabledCallbacks()) {
            super.onBackPressed();
            return;
        }
        if (!this.viewDetectHelper.onBackPressed()) {
            try {
                com.up366.common.EventBusUtilsUp.unregister(this);
                if (com.up366.mobile.common.helper.ApplicationHelper.getInst().gotoMain(com.up366.mobile.AiSkipHelper.isMoLiYingBook(this.book.getBookId()))) {
                    com.up366.mobile.user.account.login.StaticTimeLoginHelper.INSTANCE.reset();
                    startActivity(new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.main.MainActivity.class));
                    finish();
                } else {
                    super.onBackPressed();
                }
                return;
            } catch (java.lang.Exception unused) {
                finish();
                return;
            }
        }
        if (this.loadingView.isShowing()) {
            finish();
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.up366.mobile.book.exercise.js.TakePhotoHelper takePhotoHelper = this.takePhotoHelper;
        if (takePhotoHelper != null) {
            takePhotoHelper.onActivityResult(i, i2, intent);
        }
        com.up366.mobile.common.helper.QRScanHelper qRScanHelper = this.scanHelper;
        if (qRScanHelper != null) {
            qRScanHelper.onActivityResult(i, i2, intent);
        }
        com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper photoPickerClippedPhotoV2Helper = this.pickerClippedPhotoV2Helper;
        if (photoPickerClippedPhotoV2Helper != null) {
            photoPickerClippedPhotoV2Helper.onActivityResult(i, i2, intent);
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.multimedia.event.PictureLoadEvent pictureLoadEvent) {
        this.takePhotoHelper.onMessageEvent(pictureLoadEvent);
    }

    public void detectCurrentState(boolean z) {
        this.stateDetectHelper.detect(this.cfg, this.onLoadingWebData_, z, new com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda44
            @Override // com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper
            public final void onResult(int i, java.lang.String str, java.lang.Object obj, boolean z2) {
                this.f$0.lambda$detectCurrentState$23(i, str, obj, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectCurrentState$23(int i, java.lang.String str, final java.lang.Object obj, boolean z) {
        com.up366.common.log.Logger.info("TAG - StudyActivity - detectCurrentState - detect - " + this.stateDetectHelper.getStateName(i) + " - repeat - " + z + " isFinishing:" + isFinishing() + " hashCode:" + hashCode());
        if (isFinishing()) {
            return;
        }
        dismissTipDialog();
        if (i != 0) {
            switch (i) {
                case 2:
                    showTipDialog("提示", str, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda17
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            this.f$0.lambda$detectCurrentState$12(view);
                        }
                    });
                    break;
                case 3:
                    showLoading(false);
                    showTipDialog("提示", "暂无可用章节", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda16
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            this.f$0.lambda$detectCurrentState$11(view);
                        }
                    });
                    break;
                case 4:
                case 5:
                    showTipDialog("提示", getResources().getString(com.up366.mobile.R.string.study_page_not_found) + "(-3)", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda19
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            this.f$0.lambda$detectCurrentState$14(view);
                        }
                    });
                    break;
                case 6:
                    showTipDialog("提示", "教学计划未开放", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda20
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            this.f$0.lambda$detectCurrentState$15(view);
                        }
                    });
                    break;
                case 7:
                    showNoBuyDialog();
                    break;
                case 8:
                    this.viewDetectHelper.showAppCatalog();
                    break;
                case 9:
                    this.viewDetectHelper.show2016HtmlCatalog();
                    com.up366.mobile.book.activity.BookDataCache.getInstance().resetBookChapterCache();
                    break;
                case 10:
                    this.viewDetectHelper.show2019HtmlCatalog();
                    com.up366.mobile.book.activity.BookDataCache.getInstance().resetBookChapterCache();
                    break;
                case 11:
                    this.viewDetectHelper.showStudyV1ExercisePage();
                    break;
                case 12:
                    showTipDialog("提示", "不支持“同步视听说”类型的飞书。。。", null);
                    break;
                case 13:
                    showTipDialog("提示", "不支持“语音风暴”类型的飞书。。。", null);
                    break;
                case 14:
                    this.viewDetectHelper.showStudyV4ExercisePage();
                    break;
                case 15:
                    showTipDialog("提示", "不支持“听说风暴”类型的飞书。。。", null);
                    break;
                case 16:
                    if (this.viewDetectHelper.checkPageChangeV6()) {
                        resetPage();
                    }
                    this.viewDetectHelper.showStudyV6ExercisePage();
                    break;
                case 17:
                    if (this.viewDetectHelper.checkPageChangeV7()) {
                        resetPage();
                    }
                    this.viewDetectHelper.showStudyV7ExercisePage();
                    break;
                case 18:
                    com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda21
                        @Override // com.up366.common.task.Task
                        public final void run() throws java.lang.Exception {
                            this.f$0.lambda$detectCurrentState$17();
                        }
                    });
                    break;
                case 19:
                    this.viewDetectHelper.showSchoolPage();
                    break;
                case 20:
                    this.viewDetectHelper.showExercisePage();
                    break;
                case 21:
                    this.viewDetectHelper.show2023CommonPage();
                    break;
                case 22:
                    showTipDialog("提示", getResources().getString(com.up366.mobile.R.string.go_to_pc_client_study), new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda18
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            this.f$0.lambda$detectCurrentState$13(view);
                        }
                    });
                    break;
                case 23:
                    this.viewDetectHelper.showDictPage();
                    break;
                case 24:
                    if (!z) {
                        this.viewDetectHelper.resetPage();
                        this.controlShowLoadingByJs = false;
                        showLoading(true);
                        setTitle("");
                        this.loadingState = 0;
                        this.loadingView.setData(0);
                        this.contentDownloadHelper.downloadCombine((java.util.List) obj, new com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda23
                            @Override // com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback
                            public final void onResult(int i2, long j, long j2, int i3, java.lang.String str2) {
                                this.f$0.lambda$detectCurrentState$21(obj, i2, j, j2, i3, str2);
                            }
                        });
                    }
                    break;
                case 25:
                    com.up366.mobile.common.utils.ViewDataInvalidRecord.$("state-detect-fetch-all").invalid();
                    this.loadingView.setData(4, 0, "下载失败", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda24
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            this.f$0.lambda$detectCurrentState$22(view);
                        }
                    });
                    if (com.up366.common.NetworkUtilsUp.isConnected()) {
                        showErrorCodeTip();
                    }
                    break;
                case 26:
                    this.viewDetectHelper.show2025CommonPage();
                    break;
            }
            return;
        }
        showLoading(true);
        this.loadingView.setData(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectCurrentState$11(android.view.View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectCurrentState$12(android.view.View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectCurrentState$13(android.view.View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectCurrentState$14(android.view.View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectCurrentState$15(android.view.View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectCurrentState$17() throws java.lang.Exception {
        com.up366.mobile.book.helper.Tools.initCheckBook(this.book, this.cfg, new com.up366.common.http.NetHolder(), new com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda29(this), new com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda30(this), new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda31
            public final void accept(java.lang.Object obj) {
                this.f$0.lambda$detectCurrentState$16((com.up366.common.http.Response) obj);
            }
        }, new com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda32(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectCurrentState$16(com.up366.common.http.Response response) {
        showLoadWebDataErrorTip(response.getCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectCurrentState$21(java.lang.Object obj, int i, long j, long j2, int i2, java.lang.String str) {
        if (this.loadingView.getVisibility() != 0) {
            visible(this.loadingView);
            this.loadingView.setData(this.loadingState);
        }
        switch (i) {
            case 1:
                this.loadingView.setData(7);
                break;
            case 2:
                this.loadingView.setData(2, (int) ((j * 100) / j2), null, null);
                break;
            case 3:
                this.loadingView.setData(3);
                break;
            case 4:
                this.loadingView.setData(5);
                com.up366.mobile.book.model.TreeBookChapter treeBookChapter = this.bookChapterInfo;
                if (treeBookChapter != null) {
                    treeBookChapter.invalidHtmlJsonStrHash();
                }
                com.up366.mobile.book.exercise.ExerciseResourceHelper.clearXotVersionCache();
                com.up366.mobile.book.dict.DictResourceHelper.clearDictVersionCache();
                this.stateDetectHelper.resetOldState();
                this.viewDetectHelper.resetPage();
                this.contentDownloadHelper.resetMultiFileDownloadManager();
                finalizeQuestionsPathV9((java.util.List) obj, new java.lang.Runnable() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda14
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$detectCurrentState$19();
                    }
                });
                break;
            case 5:
                if (str != null && !str.contains("失败")) {
                    str = "下载失败：" + str;
                } else if (str == null) {
                    str = "下载失败";
                }
                com.up366.mobile.common.logic.Auth.cur().cache().clear("state-detect-fetch-all");
                this.loadingView.setData(4, 0, str, i2, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda13
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        this.f$0.lambda$detectCurrentState$18(view);
                    }
                });
                break;
            case 6:
                this.loadingView.setData(6, 0, null, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda15
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        this.f$0.lambda$detectCurrentState$20(view);
                    }
                });
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectCurrentState$18(android.view.View view) {
        this.loadingView.setData(0);
        this.stateDetectHelper.resetOldState();
        this.contentDownloadHelper.setUpMultiFileDownloadManagerHasDownloadSize();
        detectCurrentState(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectCurrentState$19() {
        detectCurrentState(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectCurrentState$20(android.view.View view) {
        this.loadingView.setData(0);
        this.stateDetectHelper.resetOldState();
        this.contentDownloadHelper.setUpMultiFileDownloadManagerHasDownloadSize();
        detectCurrentState(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectCurrentState$22(android.view.View view) {
        this.loadingView.setData(0);
        this.stateDetectHelper.resetOldState();
        detectCurrentState(true);
    }

    private void finalizeQuestionsPathV9(java.util.List<com.up366.common.download.DownloadInfo> list, final java.lang.Runnable runnable) {
        java.util.Iterator<com.up366.common.download.DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getDownType() == 27) {
                com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda37
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        com.up366.mobile.book.StudyActivity.lambda$finalizeQuestionsPathV9$24(runnable);
                    }
                });
                return;
            }
        }
        runnable.run();
    }

    static /* synthetic */ void lambda$finalizeQuestionsPathV9$24(java.lang.Runnable runnable) throws java.lang.Exception {
        java.lang.String questionsPath = com.up366.mobile.book.helper.V9FilePathHelper.getQuestionsPath();
        boolean zRebuildChildDirectoryValidationFiles = com.up366.mobile.common.utils.DirectoryValidationUtils.rebuildChildDirectoryValidationFiles(questionsPath, null, true);
        com.up366.mobile.common.utils.DirectoryValidationUtils.deleteDirectoryValidationFiles(questionsPath);
        com.up366.common.log.Logger.info("TAG - StudyActivity - finalizeQuestionsPathV9 - questionsRootDir=" + questionsPath + " rebuilt=" + zRebuildChildDirectoryValidationFiles);
        java.util.Objects.requireNonNull(runnable);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda2(runnable));
    }

    private void showErrorCodeTip() {
        if (com.up366.mobile.common.utils.ViewDataInvalidRecord.hasCache("no-fileId-standard")) {
            showTipDialog("提示", getResources().getString(com.up366.mobile.R.string.study_page_not_found) + "(-1)", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showErrorCodeTip$25(view);
                }
            });
        }
        if (com.up366.mobile.common.utils.ViewDataInvalidRecord.hasCache("no-content")) {
            showTipDialog("提示", getResources().getString(com.up366.mobile.R.string.study_page_not_found) + "(-1)", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showErrorCodeTip$26(view);
                }
            });
        }
        if (com.up366.mobile.common.utils.ViewDataInvalidRecord.hasCache("no-fileId-test")) {
            showTipDialog("提示", getResources().getString(com.up366.mobile.R.string.study_page_not_found) + "(-1)", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showErrorCodeTip$27(view);
                }
            });
        }
        if (com.up366.mobile.common.utils.ViewDataInvalidRecord.hasCache("no-fileId-school")) {
            showTipDialog("提示", getResources().getString(com.up366.mobile.R.string.study_page_not_found) + "(-2)", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showErrorCodeTip$28(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorCodeTip$25(android.view.View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorCodeTip$26(android.view.View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorCodeTip$27(android.view.View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorCodeTip$28(android.view.View view) {
        onBackPressed();
    }

    private void showNoBuyDialog() {
        showNoBugDialogV2();
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoading(boolean z, boolean z2) {
        com.up366.common.log.Logger.info("TAG - StudyActivity - showLoading - show = [" + z + "], controlByJs = [" + z2 + "]");
        if (z2) {
            this.controlShowLoadingByJs = true;
        }
        if (z2 || !this.controlShowLoadingByJs) {
            if (z || !this.loadingView.isDownloading()) {
                if (z) {
                    visible(this.loadingView);
                    this.loadingView.setData(0);
                } else if (this.loadingView.getVisibility() != 4) {
                    invisible(this.loadingView);
                    com.up366.mobile.common.utils.AnimUtils.fadeOut(this.loadingView);
                }
            }
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoading(boolean z) {
        showLoading(z, false);
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoadingTitleBar(boolean z) {
        this.loadingView.setShowTitleBar(z);
    }

    public void setTitle(java.lang.String str) {
        this.titleBar.setTitle(str);
        this.loadingView.setTitle(str);
    }

    public void backToBookshelf() {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.BackToBookShelf());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.BackToBookShelf backToBookShelf) {
        finish();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public void finish() {
        com.up366.mobile.book.helper.ContentDownloadHelper contentDownloadHelper = this.contentDownloadHelper;
        if (contentDownloadHelper != null) {
            contentDownloadHelper.pauseAllDownload();
        }
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.finish();
    }

    private void showLoadWebDataErrorTip(final int i) {
        com.up366.common.task.TaskUtils.postLazyTaskMain("book-load-error-tip", new com.up366.common.task.Task() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda41
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showLoadWebDataErrorTip$32(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showLoadWebDataErrorTip$32(int i) throws java.lang.Exception {
        if (!this.cfg.isSDKV8() && this.book.getPackType() == 7 && this.contentDownloadHelper.hasCatalogDownload() && this.cfg.isCatalog()) {
            detectCurrentState(true);
            com.up366.common.log.Logger.error("TAG - StudyActivity - showLoadWebDataErrorTip - 获取教材信息失败");
            return;
        }
        if (this.bookChapterInfo.getChapterList() != null && this.bookChapterInfo.getChapterList().size() > 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, "网络好像走丢了\n请稍后重试!");
            detectCurrentState(true);
            return;
        }
        if (i == -10000) {
            showTipDialog("获取教材信息失败", "网络错误，建议更换网络环境或稍后下载。", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showLoadWebDataErrorTip$29(view);
                }
            });
        } else if (!com.up366.mobile.common.dialog.DialogBlockUser.checkNeedIntercept()) {
            showTipDialog("获取教材信息失败", "网络错误，建议更换网络环境或稍后下载。", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showLoadWebDataErrorTip$31(view);
                }
            });
        } else {
            com.up366.mobile.common.dialog.DialogBlockUser.show(this, 2, i, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda10
                @Override // com.up366.common.callback.ICallbackCode
                public final void onResult(int i2) {
                    this.f$0.lambda$showLoadWebDataErrorTip$30(i2);
                }
            });
        }
        this.loadingView.setData(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoadWebDataErrorTip$29(android.view.View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoadWebDataErrorTip$30(int i) {
        com.up366.mobile.common.onlinelog.OpLog.report("5_1_retry_study", "log");
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoadWebDataErrorTip$31(android.view.View view) {
        onBackPressed();
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.ContentDownloadHelper getContentDownloadHelper() {
        return this.contentDownloadHelper;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.BuyBookHelper getBuyBookHelper() {
        return this.buyBookHelper;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.V8FilePathHelper getV8FilePathHelper() {
        return this.v8FilePathHelper;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.BookFilePathHelper getBookFilePathHelper() {
        return this.bookFilePathHelper;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.HeadsetHelper getHeadsetHelper() {
        return this.headsetHelper;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.exercise.js.TakePhotoHelper getTakePhotoHelper() {
        return this.takePhotoHelper;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.helper.PhotoPickerClippedPhotoV2Helper getPhotoPickerClippedPhotoV2Helper() {
        return this.pickerClippedPhotoV2Helper;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.common.helper.QRScanHelper getQRScanHelper() {
        return this.scanHelper;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.model.OpenConfigInfo getOpenConfigInfo() {
        return this.cfg;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.model.BookInfoStudy getBookInfoStudy() {
        return this.book;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.book.model.TreeBookChapter getBookChapterInfo() {
        return this.bookChapterInfo;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public com.up366.mobile.common.views.TitleBarView getTitleBar() {
        return this.titleBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoadErrorTip$33(android.view.View view) {
        onBackPressed();
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showLoadErrorTip(java.lang.String str, java.lang.String str2) {
        showTipDialog(str, str2, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showLoadErrorTip$33(view);
            }
        });
        this.loadingView.setData(-1);
    }

    public void showLoadUrlErrorTip(java.lang.String str, java.lang.String str2, final android.view.View.OnClickListener onClickListener) {
        visible(this.loadingView);
        this.loadingView.setData(-2, "加载失败", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showLoadUrlErrorTip$34(onClickListener, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLoadUrlErrorTip$34(android.view.View.OnClickListener onClickListener, android.view.View view) {
        this.loadingView.setData(0);
        onClickListener.onClick(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openPage(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        java.lang.String paperId;
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = this.book;
        if (bookInfoStudy != null && bookInfoStudy.getBookType() == 2) {
            com.up366.mobile.book.model.BookInfoStudy bookInfoStudy2 = new com.up366.mobile.book.model.BookInfoStudy();
            bookInfoStudy2.setBookId(com.up366.mobile.book.helper.Tools.commonBookId);
            bookInfoStudy2.setBookType(1);
            com.up366.mobile.book.model.ChapterInfo chapterInfo = (com.up366.mobile.book.model.ChapterInfo) com.up366.mobile.common.logic.Auth.cur().db().getChapterInfoDao().queryBuilder().where(com.up366.greendao.ChapterInfoDao.Properties.Id.eq(openConfigInfo.chapterId), new org.greenrobot.greendao.query.WhereCondition[0]).build().unique();
            if (chapterInfo != null && chapterInfo.isContent() && !android.text.TextUtils.isEmpty(chapterInfo.getFileId())) {
                com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda26
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$openPage$35();
                    }
                });
                bookInfoStudy2.setJumpExtFileIds(com.up366.mobile.book.helper.Tools.buildPendingInfosFileId(chapterInfo.getFileId()));
            } else {
                bookInfoStudy2.setJumpExtFileIds(com.up366.mobile.book.helper.Tools.buildPendingInfosTask(this.book.getBookId(), openConfigInfo.chapterId, this.book.getBookType()));
            }
            if (chapterInfo == null) {
                paperId = "";
            } else {
                paperId = chapterInfo.getPaperId();
            }
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("scenario", "_SCHOOL_BOOK_PRACTICE_");
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, this.book.getBookId());
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(this.book.getCourseId()));
            jSONObject.put("bookType", java.lang.Integer.valueOf(this.book.getBookType()));
            jSONObject.put("paperId", paperId);
            jSONObject.put("chapterId", openConfigInfo.chapterId);
            bookInfoStudy2.setJumpCommonParams(jSONObject.toJSONString());
            android.content.Intent intent = new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
            intent.putExtra("book", bookInfoStudy2);
            startActivity(intent);
            return;
        }
        android.content.Intent intent2 = new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent2.putExtra("book", this.book);
        intent2.putExtra("cfg", openConfigInfo);
        startActivity(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openPage$35() throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().db1().saveOrUpdate(new com.up366.mobile.book.model.BookResourceMapInfo(this.book.getFileId(), this.book.getBookId(), new com.up366.mobile.book.helper.V8FilePathHelper().getResourceDir(this.book.getFileId())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openCatalogPage() {
        com.up366.mobile.book.model.BookInfoStudy book = this.bookChapterInfo.getBook();
        if (!android.text.TextUtils.isEmpty(this.cfg.studyTaskId)) {
            com.up366.mobile.book.activity.BookDataCache.getInstance().resetTreeBookChapter(book.getCourseId(), book.getBookId());
            book.setForceReloadChapterData(true);
        }
        android.content.Intent intent = new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("book", book);
        startActivity(intent);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.PhoneState phoneState) {
        int state = phoneState.getState();
        if (state == 0) {
            this.viewDetectHelper.onResume();
        } else {
            if (state != 1) {
                return;
            }
            this.viewDetectHelper.onPause();
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.HasBuyProductRefresh hasBuyProductRefresh) {
        if (this.book == null) {
            return;
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$36();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$36() throws java.lang.Exception {
        this.book.initHasBuy();
        this.bookChapterInfo.init(this.book);
        detectCurrentState(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showTipDialog(java.lang.String str, java.lang.String str2, android.view.View.OnClickListener onClickListener) {
        com.up366.common.log.Logger.info("TAG - StudyActivity - showTipDialog - title = [" + str + "], message = [" + str2 + "], listener = [" + onClickListener + "]");
        dismissTipDialog();
        this.tipDialog = com.up366.mobile.common.dialog.DialogOkCancleV2.create(this).setCancelable(false).hideCancel().title(str).message(str2).ok("确定", onClickListener).show();
    }

    private void dismissTipDialog() {
        com.up366.mobile.common.dialog.DialogOkCancleV2 dialogOkCancleV2 = this.tipDialog;
        if (dialogOkCancleV2 != null) {
            dialogOkCancleV2.dismiss();
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginout authLoginout) {
        finish();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.BackToBookCatalog backToBookCatalog) {
        if (com.up366.mobile.book.activity.BookDataCache.getInstance().coverToBackCatalogPage(backToBookCatalog.getCourseId(), backToBookCatalog.getBookId(), this)) {
            onBackPressed();
            finish();
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.JSGlobalEvent jSGlobalEvent) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(jSGlobalEvent.getMsg());
        java.lang.String string = object.getString("type");
        object.getJSONObject("detail");
        if ("_EVT_GO_STUDYTASK_".equals(string)) {
            onBackPressed();
            finish();
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void buildBookPagePath(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.CatalogPage catalogPage) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.up366.mobile.book.model.CatalogPage catalogPage2 = catalogPage; catalogPage2 != null; catalogPage2 = catalogPage2.getpPage()) {
            if (catalogPage2.getObj() != null) {
                arrayList.add(0, catalogPage2.getObj().getName());
            }
        }
        java.lang.String bookName = arrayList.size() > 0 ? bookInfoStudy.getBookName() + "->" + com.up366.common.StringUtils.join(arrayList, "->") : bookInfoStudy.getBookName();
        com.up366.mobile.course.mgr.CourseInfo courseInfo = com.up366.mobile.common.logic.Auth.cur().course().getCourseInfo(bookInfoStudy.getCourseId());
        if (courseInfo != null) {
            bookName = courseInfo.getCourseName() + "->" + bookName;
        }
        java.lang.String str = "当前位置：" + bookName + "\n";
        if (bookInfoStudy.getCourseId() > 0) {
            str = str + "课程ID：" + bookInfoStudy.getCourseId() + "\n";
        }
        if (catalogPage != null) {
            str = str + "TaskID：" + catalogPage.getObj().getTaskId();
        }
        this.buildPagePath = str;
        com.up366.common.log.Logger.info("TAG - StudyActivity - buildBookPagePath - " + com.alibaba.fastjson.JSON.toJSONString(this.buildPagePath));
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public android.view.View getRootView() {
        return this.rootView;
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void buildBookPagePathV8(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        java.lang.String bookName = bookInfoStudy.getBookName();
        com.up366.mobile.course.mgr.CourseInfo courseInfo = com.up366.mobile.common.logic.Auth.cur().course().getCourseInfo(bookInfoStudy.getCourseId());
        if (courseInfo != null) {
            bookName = courseInfo.getCourseName() + "->" + bookName;
        }
        java.lang.String str = "当前位置：" + bookName + "\n";
        if (bookInfoStudy.getCourseId() > 0) {
            str = str + "课程ID：" + bookInfoStudy.getCourseId() + "\n";
        }
        this.buildPagePath = str;
        if (android.text.TextUtils.equals(bookInfoStudy.getBookId(), com.up366.mobile.book.helper.Tools.commonBookId)) {
            this.buildPagePath = "";
        }
        com.up366.common.log.Logger.info("TAG - StudyActivity - buildBookPagePathV8 - " + com.alibaba.fastjson.JSON.toJSONString(this.buildPagePath));
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void showDownloadLoadingView() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda28
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$showDownloadLoadingView$37();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDownloadLoadingView$37() throws java.lang.Exception {
        this.loadingState = 0;
        this.loadingView.setData(0);
        if (this.loadingView.getVisibility() != 0) {
            visible(this.loadingView);
            this.loadingView.setData(this.loadingState);
        }
    }

    @Override // com.up366.mobile.book.StudyActivityInterface
    public void updateDownloadLoadingView(final int i, final long j, final long j2, final java.lang.String str, final java.lang.Runnable runnable) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda40
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$updateDownloadLoadingView$40(i, j, j2, str, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDownloadLoadingView$40(int i, long j, long j2, java.lang.String str, final java.lang.Runnable runnable) throws java.lang.Exception {
        if (this.loadingView.getVisibility() != 0) {
            visible(this.loadingView);
            this.loadingView.setData(this.loadingState);
        }
        switch (i) {
            case 1:
                this.loadingView.setData(7);
                break;
            case 2:
                this.loadingView.setData(2, (int) ((j * 100) / j2), null, null);
                break;
            case 3:
                this.loadingView.setData(3);
                break;
            case 4:
                this.loadingView.setData(5);
                showLoading(false, true);
                break;
            case 5:
                if (str != null && !str.contains("失败")) {
                    str = "下载失败：" + str;
                } else if (str == null) {
                    str = "下载失败";
                }
                this.loadingView.setData(4, 0, str, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda45
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        runnable.run();
                    }
                });
                break;
            case 6:
                this.loadingView.setData(6, 0, null, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda46
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        runnable.run();
                    }
                });
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPage() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda34
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$resetPage$41();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetPage$41() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - StudyActivity - resetPage");
        this.viewDetectHelper.resetPage();
        this.controlShowLoadingByJs = false;
        showLoading(true);
    }
}
