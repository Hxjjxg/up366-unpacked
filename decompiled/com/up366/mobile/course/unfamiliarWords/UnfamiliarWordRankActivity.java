package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class UnfamiliarWordRankActivity extends com.up366.mobile.common.base.BaseActivity {
    private static final java.lang.String FETCH_COURSE_LIST = "fetch_course_list";
    private static final java.lang.String FETCH_RANK_LIST = "fetch_rank_list";
    private com.up366.mobile.databinding.ActivityUnfamiliarWordRankBinding b;
    private java.lang.String courseId;
    private java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> courseList;
    private com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankAdapter mAdapter;
    private boolean isOrderDesc = false;
    private java.lang.String orderField = com.up366.mobile.course.unfamiliarWords.RankListSortStateModel.TYPE_REMAIN_WORD_COUNT;
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo> controller = new com.up366.mobile.common.base.USV5ListViewDataController<>(this);
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> courseListController = new com.up366.mobile.common.base.USV5ListViewDataController<>(this);

    static /* synthetic */ void lambda$initController$3(java.util.List list) {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.b = (com.up366.mobile.databinding.ActivityUnfamiliarWordRankBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_unfamiliar_word_rank);
        com.up366.common.EventBusUtilsUp.register(this);
        initView();
        initCourseController();
        initController();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$(FETCH_COURSE_LIST).invalid();
        this.b.refreshLayout.doRefresh();
    }

    private void initCourseController() {
        this.courseListController.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                this.f$0.lambda$initCourseController$0(list);
            }
        });
        this.courseListController.setErrorViewClickAction(new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda7
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                this.f$0.lambda$initCourseController$1(i);
            }
        });
        this.courseListController.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda8
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() {
                com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWordNoteRankCourseList();
            }
        });
        this.courseListController.setAdapter(this.mAdapter);
        this.courseListController.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCourseController$0(java.util.List list) {
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state5).setTipMessage(getString(com.up366.mobile.R.string.no_rank_msg)).build()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCourseController$1(int i) {
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$(FETCH_COURSE_LIST).invalid();
        this.b.refreshLayout.doRefresh();
    }

    private void initController() {
        this.controller.setLoadingView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity.lambda$initController$3(list);
            }
        });
        this.controller.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda11
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                this.f$0.lambda$initController$4(list);
            }
        });
        this.controller.setErrorViewClickAction(new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda12
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                this.f$0.lambda$initController$5(i);
            }
        });
        this.controller.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda13
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity.lambda$initController$6(list, list2);
            }
        });
        this.controller.setPageSize(30);
        this.controller.setWebPagerLoader(new com.up366.mobile.common.base.BaseListViewDataController.IPagerLoader() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda14
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IPagerLoader
            public final void load(int i, int i2, java.lang.Object obj) {
                this.f$0.lambda$initController$7(i, i2, (com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo) obj);
            }
        });
        this.controller.setFooterDataCallback(new com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda15
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback
            public final void setDatas(com.up366.common.http.Response response, java.util.List list) {
                this.f$0.lambda$initController$8(response, list);
            }
        });
        this.controller.setIsSameItem(new com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda16
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback
            public final boolean isSame(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity.lambda$initController$9((com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo) obj, (com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo) obj2);
            }
        });
        this.controller.setOnCompleteCallback(new com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda17
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback
            public final void onComplete() {
                this.f$0.lambda$initController$10();
            }
        });
        this.controller.setAdapter(this.mAdapter);
        this.controller.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$4(java.util.List list) {
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state5).setTipMessage(getString(com.up366.mobile.R.string.no_rank_msg)).build()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$5(int i) {
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$(FETCH_RANK_LIST).invalid();
        this.b.refreshLayout.doRefresh();
    }

    static /* synthetic */ void lambda$initController$6(java.util.List list, java.util.List list2) {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, (com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo) it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$7(int i, int i2, com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo wordNoteRankInfo) {
        com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWordNoteRankListV2(this.courseId, i, i2, this.isOrderDesc ? "desc" : "asc", this.orderField);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$8(com.up366.common.http.Response response, java.util.List list) {
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-6, new com.up366.mobile.common.views.RefreshUpView.Data(response, this.controller)));
    }

    static /* synthetic */ boolean lambda$initController$9(com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo wordNoteRankInfo, com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo wordNoteRankInfo2) {
        return wordNoteRankInfo.getUid() == wordNoteRankInfo2.getUid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$10() {
        this.b.refreshLayout.complete();
    }

    private void initView() {
        this.mAdapter = new com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankAdapter();
        this.b.rvRankList.setAdapter(this.mAdapter);
        this.b.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda1
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.lambda$initView$13();
            }
        });
        this.b.titleBar.setBackImageResource(com.up366.mobile.R.drawable.icon_return);
        this.b.titleBar.binding.title.setTypeface(android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, 1));
        this.b.titleBar.binding.title.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$14(view);
            }
        });
        this.b.titleBar.binding.arrow.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$15(view);
            }
        });
        this.b.titleBar.showArrow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$11() {
        this.courseListController.loadWebData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$13() {
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$(FETCH_COURSE_LIST).run(new java.lang.Runnable() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initView$11();
            }
        });
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$(FETCH_RANK_LIST).run(new java.lang.Runnable() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initView$12();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$12() {
        this.controller.loadWebData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$14(android.view.View view) {
        showBottomDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$15(android.view.View view) {
        showBottomDialog();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showBottomDialog() {
        java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> list = this.courseList;
        if (list == null || list.isEmpty()) {
            return;
        }
        com.up366.mobile.common.utils.AnimUtils.roate1(this.b.titleBar.binding.arrow);
        com.up366.mobile.common.helper.BottomSheetHelper bottomSheetHelper = new com.up366.mobile.common.helper.BottomSheetHelper(this);
        bottomSheetHelper.setTitle("选择班级");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo wrongNoteCourseInfo : this.courseList) {
            com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel = new com.up366.mobile.common.views.bottomsheet.BottomSheetModel();
            bottomSheetModel.setContent(wrongNoteCourseInfo.getCourseName());
            bottomSheetModel.setData(wrongNoteCourseInfo);
            if (android.text.TextUtils.equals(this.courseId, wrongNoteCourseInfo.getCourseId())) {
                bottomSheetModel.setSelected(true);
            }
            arrayList.add(bottomSheetModel);
        }
        bottomSheetHelper.setContents(arrayList);
        bottomSheetHelper.setItemClickListener(new com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener
            public final void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel2) {
                this.f$0.lambda$showBottomDialog$16(qMUIBottomSheet, bottomSheetModel2);
            }
        });
        bottomSheetHelper.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                this.f$0.lambda$showBottomDialog$17(dialogInterface);
            }
        });
        bottomSheetHelper.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBottomDialog$16(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel) {
        com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo wrongNoteCourseInfo = (com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo) bottomSheetModel.getData();
        this.b.titleBar.setTitle(wrongNoteCourseInfo.getCourseName());
        this.courseId = wrongNoteCourseInfo.getCourseId();
        this.b.refreshLayout.doRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBottomDialog$17(android.content.DialogInterface dialogInterface) {
        com.up366.mobile.common.utils.AnimUtils.roate2(this.b.titleBar.binding.arrow);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WrongNoteRankCourseListRefresh wrongNoteRankCourseListRefresh) {
        java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> list;
        this.b.refreshLayout.complete();
        this.courseList = wrongNoteRankCourseListRefresh.getWrongNoteCourseList();
        if (wrongNoteRankCourseListRefresh.getResp().isError() || (list = this.courseList) == null || list.isEmpty()) {
            this.b.refreshLayout.setEnable(false);
            this.courseListController.onLoadWebData(wrongNoteRankCourseListRefresh.getResp(), this.courseList);
            this.b.titleBar.binding.title.setVisibility(8);
            this.b.titleBar.binding.arrow.setVisibility(8);
            return;
        }
        this.b.refreshLayout.setEnable(true);
        this.b.titleBar.setTitle(this.courseList.get(0).getCourseName());
        this.b.titleBar.binding.title.setVisibility(0);
        this.courseId = this.courseList.get(0).getCourseId();
        this.b.titleBar.binding.arrow.setVisibility(this.courseList.size() >= 2 ? 0 : 8);
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$(FETCH_RANK_LIST).invalid();
        this.b.refreshLayout.doRefresh();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WordNoteRankListRefresh wordNoteRankListRefresh) {
        if (!wordNoteRankListRefresh.getResp().isError() && wordNoteRankListRefresh.getWordNoteRankInfos() != null && wordNoteRankListRefresh.getWordNoteRankInfos().size() > 0) {
            this.controller.setBeforeRender(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda9
                @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
                public final void setDatas(java.util.List list) {
                    com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity.lambda$onMessageEvent$18(list);
                }
            });
            this.b.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity$$ExternalSyntheticLambda10
                @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
                public final void onRefresh() {
                    this.f$0.lambda$onMessageEvent$19();
                }
            });
        }
        this.controller.onLoadWebData(wordNoteRankListRefresh.getResp(), wordNoteRankListRefresh.getWordNoteRankInfos());
    }

    static /* synthetic */ void lambda$onMessageEvent$18(java.util.List list) {
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-7));
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$19() {
        this.controller.loadWebData();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WordNoteRankOrderStateChangeEvent wordNoteRankOrderStateChangeEvent) {
        com.up366.mobile.course.unfamiliarWords.RankListSortStateModel model = wordNoteRankOrderStateChangeEvent.getModel();
        this.orderField = model.getOrderField();
        this.isOrderDesc = model.isOrderDesc();
        this.b.refreshLayout.doRefresh();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        this.courseListController.destroy();
        this.controller.destroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }
}
