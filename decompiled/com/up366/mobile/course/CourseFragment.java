package com.up366.mobile.course;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class CourseFragment extends com.up366.mobile.common.base.BaseFragment {
    private com.up366.mobile.course.CourseAdapter adapter;
    private com.up366.mobile.databinding.CourseMainFragmentLayoutBinding b;
    private java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner> bannerList;
    private com.up366.mobile.cloud.PrivateCloudViewShowHelper cloudViewShowHelper;
    private android.content.Context context;
    private com.up366.mobile.common.base.USV5ListViewDataController<java.lang.Object> controller;
    com.up366.mobile.course.task.model.CoursePageCountHolder countHolder = null;
    private java.util.List<com.up366.mobile.course.mgr.DailyInterestInfo> dailyInterestInfos;
    private java.util.List<com.up366.mobile.course.task.model.GrowthReportCourse> growthReportCourses;
    private boolean otherDataLoadOver;
    private boolean taskDataLoadOver;

    static /* synthetic */ void lambda$initController$10(java.util.List list) {
    }

    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        this.b = (com.up366.mobile.databinding.CourseMainFragmentLayoutBinding) androidx.databinding.DataBindingUtil.inflate(layoutInflater, com.up366.mobile.R.layout.course_main_fragment_layout, viewGroup, false);
        com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getActivity(), new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.common.helper.GuideDialogHelper.getInst().setDataLoadSuccess(false);
            }
        });
        initView();
        initController();
        initData(getActivity());
        return this.b.getRoot();
    }

    private void initData(android.app.Activity activity) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda41
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initData$6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$6() throws java.lang.Exception {
        this.countHolder = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda9
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initData$1();
            }
        });
        final java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
        if (!com.up366.mobile.common.logic.Auth.cur().config().hasAliTokenMap()) {
            atomicBoolean.set(true);
            com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda10
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initData$3(atomicBoolean);
            }
        });
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda12
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initData$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$1() throws java.lang.Exception {
        this.controller.loadLocalData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$3(java.util.concurrent.atomic.AtomicBoolean atomicBoolean) throws java.lang.Exception {
        if (!atomicBoolean.get() && com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - com.up366.mobile.common.logic.Auth.cur().config().getLastFetchAllSyncTime() > 1000) {
            com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
        }
        com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getActivity(), new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initData$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$2() {
        com.up366.mobile.user.account.login.StaticTimeLoginHelper.INSTANCE.startReqDl();
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.AppConfigLastVersion> netHolderFetchModelMapSync = com.up366.mobile.common.logic.Auth.cur().config().fetchModelMapSync(com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel(), com.up366.mobile.BuildConfig.VERSION_CODE);
        if (netHolderFetchModelMapSync.info != null && netHolderFetchModelMapSync.info.getVersion() > 220) {
            if (!com.up366.mobile.AiSkipHelper.isHasShowAppUpdateDialog()) {
                com.up366.mobile.AiSkipHelper.setHasShowAppUpdateDialog(true);
                com.up366.mobile.common.utils.UpdateModule.getInstance().checkNewVersionAuto();
                return;
            } else {
                passwordUpdateHelper();
                return;
            }
        }
        passwordUpdateHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$5() throws java.lang.Exception {
        this.controller.loadWebData();
        com.up366.mobile.common.logic.Auth.cur().config().fetchMiniCloudList(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda27
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.course.CourseFragment.lambda$initData$4(response, (java.util.List) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$initData$4(com.up366.common.http.Response response, java.util.List list) {
        com.up366.mobile.cloud.PrivateCloudMgr privateCloudMgr = com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr();
        if (response.isError()) {
            list = null;
        }
        privateCloudMgr.startPrivateCloudModel(list);
    }

    private void passwordUpdateHelper() {
        if (com.up366.mobile.common.logic.Auth.isAuth()) {
            com.up366.mobile.user.account.login.StaticTimeLoginHelper.INSTANCE.onReqDlComplete();
            if (com.up366.mobile.main.PhonePasswordUpdateHelper.INSTANCE.skip(getActivity())) {
                return;
            }
            startPageTask();
        }
    }

    private void startPageTask() {
        final com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper = com.up366.mobile.common.helper.AppResourceUpdateHelper.getInstance();
        appResourceUpdateHelper.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda43
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$startPageTask$9(appResourceUpdateHelper);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPageTask$9(com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper) throws java.lang.Exception {
        if (!appResourceUpdateHelper.checkResourceAses() || appResourceUpdateHelper.checkUpdateAses() || !appResourceUpdateHelper.checkValidAses()) {
            if (!appResourceUpdateHelper.isUpdateAsesModelByAssets()) {
                com.up366.mobile.main.AppResourceUpdateActivity.open(getActivity(), 1);
                return;
            } else {
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda22
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        com.up366.organize.PageTaskManager.getInst().cancel(com.up366.mobile.main.PageTaskUtils.NAME_RESOURCE);
                    }
                });
                return;
            }
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda33
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.organize.PageTaskManager.getInst().cancel(com.up366.mobile.main.PageTaskUtils.NAME_RESOURCE);
            }
        });
    }

    private void initController() {
        this.controller.setLoadingView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda46
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                com.up366.mobile.course.CourseFragment.lambda$initController$10(list);
            }
        });
        this.controller.setLocalLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda47
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$initController$17();
            }
        });
        this.controller.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda48
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$initController$30();
            }
        });
        this.controller.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda49
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                this.f$0.lambda$initController$32(list, list2);
            }
        });
        this.controller.setAdapter(this.adapter);
        this.controller.setOnCompleteCallback(new com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda50
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback
            public final void onComplete() {
                this.f$0.lambda$initController$34();
            }
        });
        this.controller.setEnable(true);
        this.controller.onLoadLocalData(new java.lang.Object());
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda51
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initController$35();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$17() throws java.lang.Exception {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda35
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initController$16();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$16() throws java.lang.Exception {
        this.countHolder = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda36
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initController$11();
            }
        });
        if (!com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_DAILY).run(new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda37
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$initController$13();
                }
            });
        }
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_BANNER).run(new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initController$15();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$11() throws java.lang.Exception {
        this.controller.onLoadLocalData(new java.lang.Object());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$13() {
        com.up366.mobile.common.logic.Auth.cur().course().loadDailyInterest(new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda39
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$initController$12(i, str, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$12(int i, java.lang.String str, java.util.List list) {
        if (i == 0) {
            this.dailyInterestInfos = list;
        }
        this.controller.onLoadLocalData(new java.lang.Object());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$15() {
        com.up366.mobile.common.logic.Auth.cur().config().loadBannerList(new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda60
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$initController$14(i, str, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$14(int i, java.lang.String str, java.util.List list) {
        if (i == 0) {
            this.bannerList = list;
            this.controller.onLoadLocalData(new java.lang.Object());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$30() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - CourseFragment - start web loader ");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initController$29();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$29() throws java.lang.Exception {
        this.taskDataLoadOver = false;
        this.otherDataLoadOver = false;
        this.countHolder = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        this.adapter.reset();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda21
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initController$18();
            }
        });
        final com.up366.common.http.NetHolder netHolder = new com.up366.common.http.NetHolder();
        final com.up366.common.http.Response response = new com.up366.common.http.Response(0, "", "", 0, null);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda23
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initController$21(response);
            }
        });
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda24
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initController$28(netHolder, response);
            }
        });
        reloadDailyInterest();
        reloadGrowthReportCourse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$18() throws java.lang.Exception {
        this.controller.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$21(final com.up366.common.http.Response response) throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().info().fetchUserMessageList();
        com.up366.common.http.Response responseFetchTaskList = com.up366.mobile.common.logic.Auth.cur().taskMgr().fetchTaskList();
        if (responseFetchTaskList.isError()) {
            showTaskLoadErrorDialog(responseFetchTaskList);
        } else {
            this.countHolder = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        }
        this.taskDataLoadOver = true;
        this.adapter.reset();
        if (this.otherDataLoadOver) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$initController$19(response);
                }
            });
        } else {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda3
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$initController$20();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$19(com.up366.common.http.Response response) throws java.lang.Exception {
        this.controller.onLoadWebData(response, new java.lang.Object());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$20() throws java.lang.Exception {
        this.controller.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$28(final com.up366.common.http.NetHolder netHolder, final com.up366.common.http.Response response) throws java.lang.Exception {
        new com.up366.mobile.common.utils.ParallelRequestTool().add(new com.up366.mobile.common.utils.ParallelRequestTool.IRunner() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda13
            @Override // com.up366.mobile.common.utils.ParallelRequestTool.IRunner
            public final void run(com.up366.mobile.common.utils.ParallelRequestTool parallelRequestTool) {
                parallelRequestTool.copy(netHolder, com.up366.mobile.common.logic.Auth.cur().config().fetchBannerListSync());
            }
        }).run();
        if (netHolder.resp.isError()) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda14
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$initController$24(netHolder);
                }
            });
        } else {
            com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_BANNER).run(new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$initController$25(netHolder);
                }
            });
        }
        this.otherDataLoadOver = true;
        this.countHolder.save();
        this.adapter.reset();
        if (this.taskDataLoadOver) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda16
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$initController$26(response);
                }
            });
        } else {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda17
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$initController$27();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$23(com.up366.common.http.NetHolder netHolder) {
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.b.getRoot(), netHolder.resp.getInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$24(final com.up366.common.http.NetHolder netHolder) throws java.lang.Exception {
        com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getActivity(), new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda58
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initController$23(netHolder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$25(com.up366.common.http.NetHolder netHolder) {
        this.bannerList = (java.util.List) netHolder.info;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$26(com.up366.common.http.Response response) throws java.lang.Exception {
        this.controller.onLoadWebData(response, new java.lang.Object());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$27() throws java.lang.Exception {
        this.controller.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$32(java.util.List list, java.util.List list2) {
        if (this.countHolder == null) {
            this.countHolder = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        }
        com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder = this.countHolder;
        java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner> list3 = this.bannerList;
        if (list3 != null && list3.size() > 0 && !com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(6, java.lang.Integer.valueOf(this.bannerList.size())));
        } else if (this.taskDataLoadOver && this.otherDataLoadOver) {
            com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getActivity(), new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.mobile.common.helper.GuideDialogHelper.getInst().setBannerShowSuccess(true);
                }
            });
        }
        list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(8, "练习"));
        list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(9, coursePageCountHolder));
        java.util.List<com.up366.mobile.course.task.model.GrowthReportCourse> list4 = this.growthReportCourses;
        if (list4 != null && list4.size() > 0) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_BY_HEIGHT, 16));
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(12, this.growthReportCourses));
        }
        java.util.List<com.up366.mobile.course.mgr.DailyInterestInfo> list5 = this.dailyInterestInfos;
        if (list5 != null && list5.size() > 0) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(8, "同学都在学"));
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_16DP, 5));
            for (int i = 0; i < this.dailyInterestInfos.size(); i++) {
                com.up366.mobile.course.mgr.DailyInterestInfo dailyInterestInfo = this.dailyInterestInfos.get(i);
                if (i == 0) {
                    dailyInterestInfo.setFirst(true);
                }
                list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(11, dailyInterestInfo));
            }
        }
        list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_16DP, 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$34() {
        this.b.refreshLayout.complete();
        com.up366.mobile.user.account.login.StaticTimeLoginHelper.INSTANCE.onMainListComplete();
        com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getActivity(), new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.common.helper.GuideDialogHelper.getInst().setDataLoadSuccess(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$35() throws java.lang.Exception {
        com.up366.mobile.main.MainActivity activity = getActivity();
        if (activity instanceof com.up366.mobile.main.MainActivity) {
            activity.hideSplashBackground();
        }
    }

    public void onStop() {
        super.onStop();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("refresh-hot-books").invalid();
    }

    private void showTaskLoadErrorDialog(final com.up366.common.http.Response response) {
        com.up366.common.log.Logger.error("TAG - CourseFragment - showTaskLoadErrorDialog - " + response.toString());
        com.up366.mobile.common.onlinelog.OpLog.report("load_task_error", response.toString());
        final int code = response.getCode();
        com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getActivity(), new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda40
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showTaskLoadErrorDialog$38(code, response);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTaskLoadErrorDialog$38(final int i, com.up366.common.http.Response response) {
        if (i == -10000) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this.context, "当前没有网络，请检\n查网络后再试！！");
            return;
        }
        if (!com.up366.mobile.common.dialog.DialogBlockUser.checkNeedIntercept()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this.context, com.up366.mobile.common.utils.ErrorMessageTool.convert(response));
            return;
        }
        if (i == -10002) {
            com.up366.common.log.Logger.info("TAG - CourseFragment - refreshTaskList - show dialog ");
            if (com.up366.mobile.common.dialog.DialogBlockUser.isHasShow()) {
                com.up366.common.log.Logger.warn("TAG - CourseFragment - refreshTaskList - DialogBlockUser.isHasShow() return;;;");
                return;
            } else {
                com.up366.mobile.main.PageTaskUtils.addNetworkErrorTipTask(new com.up366.organize.inter.PageTaskRunListener() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda42
                    @Override // com.up366.organize.inter.PageTaskRunListener
                    public final void onWaitRunning() {
                        this.f$0.lambda$showTaskLoadErrorDialog$37(i);
                    }
                });
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this.context, com.up366.mobile.common.utils.ErrorMessageTool.convert(response));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTaskLoadErrorDialog$37(final int i) {
        com.up366.common.log.Logger.info("TAG :  DialogBlockUser.startRun");
        com.up366.organize.PageTaskManager.getInst().startRun(com.up366.mobile.main.PageTaskUtils.NAME_NET_ERROR);
        com.up366.mobile.common.dialog.DialogBlockUser.show((android.app.Activity) this.context, 1, i, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda18
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i2) {
                com.up366.mobile.course.CourseFragment.lambda$showTaskLoadErrorDialog$36(i, i2);
            }
        });
    }

    static /* synthetic */ void lambda$showTaskLoadErrorDialog$36(int i, int i2) {
        com.up366.common.log.Logger.info("TAG :  DialogBlockUser.show ");
        com.up366.mobile.common.onlinelog.OpLog.report("5_1_retry_main", "code:" + i);
        com.up366.organize.PageTaskManager.getInst().finished(com.up366.mobile.main.PageTaskUtils.NAME_NET_ERROR);
    }

    private void initView() {
        if (com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_NOTICE).isInBlackList() || com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            com.up366.mobile.common.utils.ViewUtil.invisible(this.b.message);
        } else {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.message);
        }
        this.b.titleNo.setText(com.up366.mobile.common.logic.Auth.getUserInfo().getUsername());
        this.controller = new com.up366.mobile.common.base.USV5ListViewDataController<>(getActivity());
        new com.up366.mobile.common.helper.AppBarRefreshLayoutHelper().binding(this.b.appBar, this.b.refreshLayout, this.b.recycleView);
        new com.up366.mobile.common.helper.AppBarOffsetChangeHelper().with(this.b.appBar, this.b.toolbarLayout).onOffsetChange(new com.up366.mobile.common.helper.AppBarOffsetChangeHelper.IOnOffsetChangeListener() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda19
            @Override // com.up366.mobile.common.helper.AppBarOffsetChangeHelper.IOnOffsetChangeListener
            public final void onChange(int i, float f) {
                this.f$0.lambda$initView$39(i, f);
            }
        });
        this.b.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda20
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.lambda$initView$40();
            }
        });
        this.adapter = new com.up366.mobile.course.CourseAdapter();
        this.b.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this.context));
        this.b.recycleView.setAdapter(this.adapter);
        this.b.ivPrivateCloudState.setVisibility(8);
        this.cloudViewShowHelper = new com.up366.mobile.cloud.PrivateCloudViewShowHelper(this.b.ivPrivateCloudState, getLifecycle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$39(int i, float f) {
        this.b.llTitle.setAlpha(1.0f - f);
        if (com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_NOTICE).isInBlackList() || com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            gone(this.b.message, this.b.messageToolbar);
        } else if (f >= 0.36d) {
            gone(this.b.message);
            visible(this.b.messageToolbar);
        } else {
            visible(this.b.message);
            gone(this.b.messageToolbar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$40() {
        this.controller.loadWebData();
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
        this.context = getActivity();
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onResume() {
        super.onResume();
        this.b.title.setText(java.lang.String.format("Hi~%s", com.up366.mobile.common.logic.Auth.getRealName()));
        this.b.titleNo.setText(com.up366.mobile.common.logic.Auth.getUserInfo().getUsername());
        this.cloudViewShowHelper.setPrivateCloudState(com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().postPrivateCloudState());
        if (isVisible()) {
            this.controller.refresh();
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("refresh-hot-books").run(new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda54
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.reloadDailyInterest();
                }
            });
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("app-resource-update-success").run(new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda56
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$42();
                }
            });
        }
        java.lang.String str = (java.lang.String) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync("login-success-tip");
        if (!com.up366.common.StringUtils.isEmptyOrNull(str)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(this.b.getRoot(), str);
        }
        java.lang.String str2 = (java.lang.String) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync("register-success-tip");
        if (!com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(this.b.getRoot(), str2);
        }
        if (isVisible()) {
            com.up366.mobile.main.MainActivity activity = getActivity();
            if (activity instanceof com.up366.mobile.main.MainActivity) {
                activity.reportEnterPage(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$42() {
        com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getActivity(), new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.common.helper.GuideDialogHelper.getInst().showTip();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reloadDailyInterest() {
        if (com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_DAILY).isInBlackList() || (com.up366.mobile.common.utils.PlatformUtils.isClosePad() && !com.up366.mobile.common.utils.PlatformUtils.isCustomClosePad())) {
            this.dailyInterestInfos = null;
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda7
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$reloadDailyInterest$43();
                }
            });
        } else {
            com.up366.mobile.common.logic.Auth.cur().course().fetchDailyInterest(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda8
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    this.f$0.lambda$reloadDailyInterest$47(response, (java.util.List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadDailyInterest$43() throws java.lang.Exception {
        this.controller.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadDailyInterest$47(final com.up366.common.http.Response response, java.util.List list) {
        if (!response.isError()) {
            this.dailyInterestInfos = list;
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$reloadDailyInterest$44();
                }
            });
        } else {
            com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getActivity(), new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reloadDailyInterest$46(response);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadDailyInterest$44() throws java.lang.Exception {
        this.controller.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadDailyInterest$45(com.up366.common.http.Response response) throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.b.getRoot(), com.up366.mobile.common.utils.ErrorMessageTool.convert(response));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadDailyInterest$46(final com.up366.common.http.Response response) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda29
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$reloadDailyInterest$45(response);
            }
        });
    }

    private void reloadGrowthReportCourse() {
        com.up366.mobile.common.logic.Auth.cur().taskMgr().fetchGrowthReportCourseList(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda44
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$reloadGrowthReportCourse$49(response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadGrowthReportCourse$49(com.up366.common.http.Response response, java.util.List list) {
        if (response.isError()) {
            return;
        }
        this.growthReportCourses = list;
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda55
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$reloadGrowthReportCourse$48();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadGrowthReportCourse$48() throws java.lang.Exception {
        this.controller.refresh();
    }

    public void onStart() {
        super.onStart();
        com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getActivity(), new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.common.helper.GuideDialogHelper.getInst().setCourseFragmentShowing(true);
            }
        });
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onPause() {
        super.onPause();
        com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getActivity(), new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda59
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.common.helper.GuideDialogHelper.getInst().setCourseFragmentShowing(false);
            }
        });
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginout authLoginout) {
        this.dailyInterestInfos = null;
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.FinishGuideEvent finishGuideEvent) {
        this.b.appBar.setExpanded(true, true);
        this.b.recycleView.scrollToPosition(0);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginSuccess authLoginSuccess) {
        this.b.title.setText(java.lang.String.format("Hi~%s", com.up366.mobile.common.logic.Auth.getRealName()));
        this.b.titleNo.setText(com.up366.mobile.common.logic.Auth.getUserInfo().getUsername());
        initData(getActivity());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(final com.up366.mobile.common.event.ScrollBottomAndShowEvent scrollBottomAndShowEvent) {
        this.b.appBar.setExpanded(false);
        this.b.recycleView.scrollToPosition(this.adapter.getItemCount() - 1);
        com.up366.common.task.TaskUtils.postMainTaskDelay(150L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda30
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.common.EventBusUtilsUp.post(scrollBottomAndShowEvent.showEvent);
            }
        });
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda31
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$56();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$56() throws java.lang.Exception {
        java.lang.Boolean bool = (java.lang.Boolean) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync(com.up366.mobile.common.utils.AppCacheKeysUtils.GUIDE_PEIYIN);
        if (bool != null && bool.booleanValue()) {
            com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getActivity(), new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda52
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.mobile.common.helper.GuideDialogHelper.getInst().show(2);
                }
            });
        } else {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OnBottomTabSelected(3));
            com.up366.common.task.TaskUtils.postMainTaskDelay(165L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda53
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onMessageEvent$55();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$55() throws java.lang.Exception {
        com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getActivity(), new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda45
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.common.helper.GuideDialogHelper.getInst().show(3);
            }
        });
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AppFuncReloadEvent appFuncReloadEvent) {
        reloadDailyInterest();
        if (com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_NOTICE).isInBlackList() || com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            gone(this.b.message, this.b.messageToolbar);
        } else {
            com.up366.mobile.common.logic.Auth.cur().info().loadMessageList();
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(final com.up366.mobile.common.event.PrivateCloudCheckEvent privateCloudCheckEvent) {
        this.cloudViewShowHelper.setPrivateCloudState(privateCloudCheckEvent);
        com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getActivity(), new java.lang.Runnable() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onMessageEvent$57(privateCloudCheckEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$57(com.up366.mobile.common.event.PrivateCloudCheckEvent privateCloudCheckEvent) {
        if (privateCloudCheckEvent.getState() == 0 && (com.up366.common.global.GB.get().getCurrentActivity() instanceof com.up366.mobile.main.MainActivity) && isAdded() && !isHidden() && getView() != null && getView().getVisibility() == 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(com.up366.common.global.GB.get().getCurrentActivity(), "当前是校内极速模式\n" + privateCloudCheckEvent.getIp());
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.RefreshUserInfo refreshUserInfo) {
        this.b.titleNo.setText(com.up366.mobile.common.logic.Auth.getUserInfo().getUsername());
        this.b.title.setText(java.lang.String.format("Hi~%s", com.up366.mobile.common.logic.Auth.getRealName()));
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.StartPageTaskEvent startPageTaskEvent) {
        startPageTask();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        if (commonUploadLogEvent.isSuccess()) {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda57
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onMessageEvent$59();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$59() throws java.lang.Exception {
        if (com.up366.mobile.common.logic.Auth.cur().taskMgr().fetchTaskList().isError()) {
            return;
        }
        this.countHolder = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.CourseFragment$$ExternalSyntheticLambda28
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$58();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$58() throws java.lang.Exception {
        this.controller.loadLocalData();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.RefreshTaskListEvent refreshTaskListEvent) {
        this.countHolder = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        this.controller.loadLocalData();
    }
}
