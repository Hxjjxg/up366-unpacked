package com.up366.mobile.me;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeFragment extends com.up366.mobile.common.base.BaseFragment {
    private static final java.lang.String PARENT_TIP_CLOSE = "PARENT_TIP_CLOSE";
    private com.up366.mobile.databinding.MeMainFragmentLayoutBinding b;
    private boolean firstOpen = true;
    private volatile long lastFetchTime = 0;
    private java.util.List<com.up366.mobile.common.logic.model.UserParent> parents;

    static /* synthetic */ void lambda$initView$3(android.view.View view) {
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
    }

    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        this.b = (com.up366.mobile.databinding.MeMainFragmentLayoutBinding) androidx.databinding.DataBindingUtil.inflate(layoutInflater, com.up366.mobile.R.layout.me_main_fragment_layout, viewGroup, false);
        setTranslucentStatus(getActivity());
        com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarLightMode(getActivity());
        if (this.firstOpen) {
            this.lastFetchTime = java.lang.System.currentTimeMillis();
        }
        initView();
        loadData();
        return this.b.getRoot();
    }

    private void loadData() {
        loadLocalData();
    }

    private void refreshLoadData() {
        if (com.up366.mobile.common.utils.PreferenceUtils.getBoolean("needFirstLoginLoadData", true)) {
            com.up366.mobile.common.utils.PreferenceUtils.putBooleanSync("needFirstLoginLoadData", false);
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("me_fragment_book_study").invalid();
        }
        if (this.firstOpen) {
            this.firstOpen = false;
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("me_fragment_book_study").invalid();
        }
    }

    public static void setTranslucentStatus(android.app.Activity activity) {
        android.view.Window window = activity.getWindow();
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        window.setStatusBarColor(0);
    }

    private void initView() {
        this.b.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda8
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.loadWebData();
            }
        });
        this.b.headView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$0(view);
            }
        });
        this.b.meTeachingClass.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$1(view);
            }
        });
        this.b.meHelp.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.me.MeFragment.openHelpCenter(view.getContext());
            }
        });
        this.b.meDivider5.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 8 : 0);
        this.b.meFeedback.setVisibility(0);
        this.b.scanTitle.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 8 : 0);
        this.b.meFeedback.setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(android.view.View view) {
                return com.up366.mobile.me.MeFragment.lambda$initView$5(view);
            }
        });
        this.b.meFeedback.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.me.feedback.FeedbackActivity.openPage(view.getContext());
            }
        });
        this.b.meSetUp.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.user.setting.UserSettingActivity.startUserSettingActivity(view.getContext());
            }
        });
        this.b.meSetUp.setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(android.view.View view) {
                return com.up366.mobile.me.MeFragment.lambda$initView$8(view);
            }
        });
        this.b.parentTipClose.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$9(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(android.view.View view) {
        com.up366.mobile.me.userinfo.MeUserInfoActivity.openPage(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.view.View view) {
        if (com.up366.mobile.common.logic.Auth.isTourist()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) getActivity(), com.up366.mobile.R.string.tip_tourist);
        } else {
            this.b.meTeachingClass.setRightText(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? "查看班级在这里" : "加入、查看班级在这里");
            startActivity(new android.content.Intent(getContext(), (java.lang.Class<?>) com.up366.mobile.me.teacherclass.MeTeachingClassActivity.class));
        }
    }

    static /* synthetic */ boolean lambda$initView$5(android.view.View view) {
        com.up366.mobile.common.dialog.AppDialog.create(view.getContext()).messageTitle("日志分享").message("分享日志到微信、QQ？").setBtnCloseVisibility(4).left("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                com.up366.mobile.me.MeFragment.lambda$initView$3(view2);
            }
        }).right("分享", new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                new com.up366.mobile.common.compat.CopyAppDataToSdcardCompat().handle(com.up366.common.global.GB.get().getCurrentActivity(), com.up366.mobile.common.compat.CopyAppDataToSdcardCompat.STRING);
            }
        }).show();
        return true;
    }

    static /* synthetic */ boolean lambda$initView$8(android.view.View view) {
        com.up366.mobile.common.utils.ToastPopupUtil.show(view, "id:" + com.up366.mobile.common.helper.DeviceIdHelper.getDeviceId());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$9(android.view.View view) {
        com.up366.mobile.common.utils.PreferenceUtils.putBoolean(PARENT_TIP_CLOSE + com.up366.mobile.common.logic.Auth.UID(), true);
        this.b.parentTipClose.setVisibility(8);
        this.b.parentTipText.setVisibility(8);
    }

    public static void openHelpCenter(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.HELP_URL));
        intent.putExtra("TYPE", 1);
        context.startActivity(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showData() {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.me.MeFragment.showData():void");
    }

    private void loadLocalData() {
        this.parents = com.up366.mobile.common.logic.Auth.cur().info().loadParentList();
        com.up366.mobile.common.logic.Auth.cur().meBookMgr().loadMyBooks(new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$loadLocalData$10(i, str, (com.up366.mobile.common.event.MyBookListEvent) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLocalData$10(int i, java.lang.String str, com.up366.mobile.common.event.MyBookListEvent myBookListEvent) {
        showData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadWebData() {
        com.up366.mobile.common.utils.TaskChainTool taskChainTool = new com.up366.mobile.common.utils.TaskChainTool();
        taskChainTool.query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda22
            @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
            public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                com.up366.mobile.me.MeFragment.lambda$loadWebData$11(iReturnOps);
            }
        });
        taskChainTool.query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda23
            @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
            public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                com.up366.mobile.me.MeFragment.lambda$loadWebData$12(iReturnOps);
            }
        });
        taskChainTool.query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda24
            @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
            public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                this.f$0.lambda$loadWebData$14(iReturnOps);
            }
        });
        if (com.up366.mobile.common.logic.Auth.isAuth() && !com.up366.mobile.common.logic.Auth.isTourist() && !com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            taskChainTool.query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda25
                @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
                public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                    com.up366.mobile.me.MeFragment.lambda$loadWebData$15(iReturnOps);
                }
            });
        }
        taskChainTool.doQueryParallel();
        taskChainTool.onSuccess(new com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda26
            @Override // com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback
            public final void success(int i, java.lang.String str, java.lang.Object[] objArr) {
                this.f$0.lambda$loadWebData$16(i, str, objArr);
            }
        });
        taskChainTool.onError(new com.up366.mobile.common.utils.TaskChainTool.IErrorCallback() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda27
            @Override // com.up366.mobile.common.utils.TaskChainTool.IErrorCallback
            public final void error(int i, java.lang.String str) {
                this.f$0.lambda$loadWebData$17(i, str);
            }
        });
    }

    static /* synthetic */ void lambda$loadWebData$11(final com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        com.up366.mobile.common.logic.MeBookMgr meBookMgr = com.up366.mobile.common.logic.Auth.cur().meBookMgr();
        java.util.Objects.requireNonNull(iReturnOps);
        meBookMgr.fetchMyBooks(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda20
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                iReturnOps.onResponse(response, (com.up366.mobile.common.event.MyBookListEvent) obj);
            }
        });
    }

    static /* synthetic */ void lambda$loadWebData$12(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        com.up366.mobile.common.logic.PersonalMgr personalMgrInfo = com.up366.mobile.common.logic.Auth.cur().info();
        java.util.Objects.requireNonNull(iReturnOps);
        personalMgrInfo.fetchPersonInfo(new com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda11(iReturnOps));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadWebData$14(final com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        com.up366.mobile.common.logic.Auth.cur().info().fetchBindingParentList(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda3
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$loadWebData$13(iReturnOps, response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadWebData$13(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps, com.up366.common.http.Response response, java.util.List list) {
        this.parents = list;
        iReturnOps.onResponse(response, list);
    }

    static /* synthetic */ void lambda$loadWebData$15(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        com.up366.mobile.common.logic.PersonalMgr personalMgrInfo = com.up366.mobile.common.logic.Auth.cur().info();
        java.util.Objects.requireNonNull(iReturnOps);
        personalMgrInfo.fetchStudyCardCount(new com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda11(iReturnOps));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadWebData$16(int i, java.lang.String str, java.lang.Object[] objArr) {
        new com.up366.common.http.Response().setCode(i);
        showData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadWebData$17(int i, java.lang.String str) {
        com.up366.common.http.Response response = new com.up366.common.http.Response();
        response.setCode(i);
        response.setInfo(str);
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) getActivity(), response);
        com.up366.common.http.Response response2 = new com.up366.common.http.Response();
        response2.setCode(0);
        response2.setInfo(str);
        showData();
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onResume() {
        super.onResume();
        refreshLoadData();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("me_fragment_book_study").run(new java.lang.Runnable() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.loadWebData();
            }
        });
        com.up366.mobile.common.logic.Auth.cur().config().fetchModelMap(com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel(), com.up366.mobile.BuildConfig.VERSION_CODE, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda19
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$onResume$18(response, (com.up366.mobile.common.logic.model.AppConfigLastVersion) obj);
            }
        });
        this.b.headView.setData(com.up366.mobile.common.logic.Auth.getUserInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$18(com.up366.common.http.Response response, com.up366.mobile.common.logic.model.AppConfigLastVersion appConfigLastVersion) {
        if (appConfigLastVersion == null || appConfigLastVersion.getVersion() <= 220) {
            return;
        }
        this.b.meSetUp.showRedPoint(true);
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.b.headView.refreshStudyLength();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginSuccess authLoginSuccess) {
        this.b.headView.setData(com.up366.mobile.common.logic.Auth.getUserInfo());
        this.lastFetchTime = java.lang.System.currentTimeMillis();
        loadData();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.MeRealNameUpdateEvent meRealNameUpdateEvent) {
        this.b.headView.setData(com.up366.mobile.common.logic.Auth.getUserInfo());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(final com.up366.mobile.common.event.AddAndShowGuideDialogEvent addAndShowGuideDialogEvent) {
        if (com.up366.mobile.common.helper.GuideDialogHelper.getInst().isHasShow()) {
            return;
        }
        com.up366.common.task.TaskUtils.postMainTaskDelay(350L, new com.up366.common.task.Task() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$20(addAndShowGuideDialogEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$20(com.up366.mobile.common.event.AddAndShowGuideDialogEvent addAndShowGuideDialogEvent) throws java.lang.Exception {
        com.up366.mobile.common.helper.GuideDialogHelper.getInst().addHeadPhotoTip(this.b.headView.getHeadPhotoView());
        com.up366.mobile.common.helper.GuideDialogHelper.getInst().show(addAndShowGuideDialogEvent.type);
        com.up366.common.task.TaskUtils.postMainTaskDelay(260L, new com.up366.common.task.Task() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda21
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$19();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$19() throws java.lang.Exception {
        com.up366.mobile.common.helper.GuideDialogHelper.getInst().addMyBookTip(this.b.meCourseView);
        com.up366.mobile.common.helper.GuideDialogHelper.getInst().addMyCourseTip(this.b.meTeachingClass);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AddAndShowSettingsGuideDialogEvent addAndShowSettingsGuideDialogEvent) {
        this.b.scrollView.fullScroll(130);
        com.up366.common.task.TaskUtils.postMainTaskDelay(150L, new com.up366.common.task.Task() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$21();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$21() throws java.lang.Exception {
        com.up366.mobile.common.helper.GuideDialogHelper.getInst().addSettingTip(this.b.meSetUp);
        com.up366.mobile.common.helper.GuideDialogHelper.getInst().show(6);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginout authLoginout) {
        com.up366.mobile.common.utils.PreferenceUtils.putBooleanSync("needFirstLoginLoadData", true);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.MyBookListEvent myBookListEvent) {
        this.b.meCourseView.setData((com.up366.mobile.common.event.MyBookListEvent) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync(com.up366.mobile.common.utils.AppCacheKeysUtils.MINE_BOOK_LIST_EVENT));
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.OnBottomTabSelected onBottomTabSelected) {
        if (3 == onBottomTabSelected.getType() && com.up366.mobile.common.logic.Auth.isAuth() && !com.up366.mobile.common.logic.Auth.isTourist() && !com.up366.mobile.common.utils.PlatformUtils.isClosePad() && java.lang.System.currentTimeMillis() - this.lastFetchTime >= com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS) {
            com.up366.common.log.Logger.info("MeFragment onHiddenChanged: fetchStudyCardCount ");
            com.up366.mobile.common.logic.Auth.cur().info().fetchStudyCardCount(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda5
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    this.f$0.lambda$onMessageEvent$23(response, (java.lang.String) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$23(com.up366.common.http.Response response, java.lang.String str) {
        if (response.isError()) {
            return;
        }
        this.lastFetchTime = java.lang.System.currentTimeMillis();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.me.MeFragment$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$22();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$22() throws java.lang.Exception {
        this.b.headView.setData(com.up366.mobile.common.logic.Auth.getUserInfo());
    }
}
