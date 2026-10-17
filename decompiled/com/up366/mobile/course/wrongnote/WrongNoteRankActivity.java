package com.up366.mobile.course.wrongnote;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WrongNoteRankActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.course.wrongnote.WrongNoteRankAdapter adapter;
    private com.up366.mobile.databinding.WordNoteRankListBinding b;
    private java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> courseList;
    private int subjectId = 0;
    private int stageId = 0;
    private java.lang.String courseId = "0";
    private com.up366.mobile.common.base.BaseListViewDataController<com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo> rankController = new com.up366.mobile.common.base.USV5ListViewDataController(this);
    private com.up366.mobile.common.base.BaseListViewDataController<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> courseListController = new com.up366.mobile.common.base.USV5ListViewDataController(this);
    private boolean isOrderDesc = true;
    private java.lang.String orderField = com.up366.mobile.common.event.WrongNoteRankOrderRefresh.RANK_TYPE_WRONG_COUNT;

    static /* synthetic */ void lambda$initController$5(java.util.List list) {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.b = (com.up366.mobile.databinding.WordNoteRankListBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.word_note_rank_list);
        com.up366.common.EventBusUtilsUp.register(this);
        initData();
        initView();
        initCourseController();
        initController();
        this.b.refreshLayout.doRefresh();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    private void initData() {
        android.content.Intent intent = getIntent();
        this.subjectId = intent.getIntExtra("subjectId", 0);
        this.stageId = intent.getIntExtra("stageId", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        this.b.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda13
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.lambda$initView$0();
            }
        });
        this.adapter = new com.up366.mobile.course.wrongnote.WrongNoteRankAdapter();
        this.b.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
        this.b.recycleView.setAdapter(this.adapter);
        this.b.titleBar.showArrow();
        this.b.titleBar.setBackImageResource(com.up366.mobile.R.drawable.icon_return);
        this.b.titleBar.binding.title.setTypeface(android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, 1));
        this.b.titleBar.binding.title.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$1(view);
            }
        });
        this.b.titleBar.binding.arrow.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        this.courseListController.loadWebData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.view.View view) {
        showBottomDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(android.view.View view) {
        showBottomDialog();
    }

    private void initCourseController() {
        this.courseListController.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                this.f$0.lambda$initCourseController$3(list);
            }
        });
        this.courseListController.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda8
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$initCourseController$4();
            }
        });
        this.courseListController.setAdapter(this.adapter);
        this.courseListController.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCourseController$3(java.util.List list) {
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state5).setTipMessage(getString(com.up366.mobile.R.string.no_rank_msg)).build()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCourseController$4() throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWrongNoteRankCourseList(this.stageId, this.subjectId);
    }

    private void initController() {
        this.rankController.setLoadingView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda16
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                com.up366.mobile.course.wrongnote.WrongNoteRankActivity.lambda$initController$5(list);
            }
        });
        this.rankController.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                this.f$0.lambda$initController$6(list);
            }
        });
        this.rankController.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                com.up366.mobile.course.wrongnote.WrongNoteRankActivity.lambda$initController$7(list, list2);
            }
        });
        this.rankController.setPageSize(30);
        this.rankController.setWebPagerLoader(new com.up366.mobile.common.base.BaseListViewDataController.IPagerLoader() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IPagerLoader
            public final void load(int i, int i2, java.lang.Object obj) {
                this.f$0.lambda$initController$8(i, i2, (com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo) obj);
            }
        });
        this.rankController.setFooterDataCallback(new com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback
            public final void setDatas(com.up366.common.http.Response response, java.util.List list) {
                this.f$0.lambda$initController$9(response, list);
            }
        });
        this.rankController.setIsSameItem(new com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback
            public final boolean isSame(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.mobile.course.wrongnote.WrongNoteRankActivity.lambda$initController$10((com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo) obj, (com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo) obj2);
            }
        });
        this.rankController.setOnCompleteCallback(new com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback
            public final void onComplete() {
                this.f$0.lambda$initController$11();
            }
        });
        this.rankController.setAdapter(this.adapter);
        this.rankController.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$6(java.util.List list) {
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state5).setTipMessage(getString(com.up366.mobile.R.string.no_rank_msg)).build()));
    }

    static /* synthetic */ void lambda$initController$7(java.util.List list, java.util.List list2) {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, (com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo) it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$8(int i, int i2, com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo wrongNoteRankInfo) {
        com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWrongNoteRankList(this.courseId, i, i2, this.isOrderDesc ? "asc" : "desc", this.orderField);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$9(com.up366.common.http.Response response, java.util.List list) {
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-6, new com.up366.mobile.common.views.RefreshUpView.Data(response, this.rankController)));
    }

    static /* synthetic */ boolean lambda$initController$10(com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo wrongNoteRankInfo, com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo wrongNoteRankInfo2) {
        return wrongNoteRankInfo.getUid() == wrongNoteRankInfo2.getUid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$11() {
        this.b.refreshLayout.complete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showBottomDialog() {
        com.up366.mobile.common.utils.ViewUtil.clickView(this.b.titleBar.binding.arrow);
        com.up366.mobile.common.utils.ViewUtil.clickView(this.b.titleBar.binding.title);
        java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> list = this.courseList;
        if (list == null || list.isEmpty() || this.courseList.size() == 1) {
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
        bottomSheetHelper.setItemClickListener(new com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda9
            @Override // com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener
            public final void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel2) {
                this.f$0.lambda$showBottomDialog$12(qMUIBottomSheet, bottomSheetModel2);
            }
        });
        bottomSheetHelper.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                this.f$0.lambda$showBottomDialog$13(dialogInterface);
            }
        });
        bottomSheetHelper.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBottomDialog$12(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel) {
        com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo wrongNoteCourseInfo = (com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo) bottomSheetModel.getData();
        this.b.titleBar.setTitle(wrongNoteCourseInfo.getCourseName());
        this.courseId = wrongNoteCourseInfo.getCourseId();
        this.b.refreshLayout.doRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBottomDialog$13(android.content.DialogInterface dialogInterface) {
        com.up366.mobile.common.utils.AnimUtils.roate2(this.b.titleBar.binding.arrow);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WrongNoteRankCourseListRefresh wrongNoteRankCourseListRefresh) {
        if (wrongNoteRankCourseListRefresh.getResp().isError()) {
            this.b.refreshLayout.complete();
            com.up366.common.log.Logger.info("WrongNoteRankActivity WrongNoteRankCourseListRefresh error " + wrongNoteRankCourseListRefresh.getResp().toString());
            showNetError(wrongNoteRankCourseListRefresh.getResp());
            return;
        }
        java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> wrongNoteCourseList = wrongNoteRankCourseListRefresh.getWrongNoteCourseList();
        this.courseList = wrongNoteCourseList;
        if (wrongNoteCourseList == null || wrongNoteCourseList.isEmpty()) {
            this.b.refreshLayout.complete();
            showNoData();
            this.b.titleBar.binding.title.setVisibility(8);
            this.b.titleBar.binding.arrow.setVisibility(8);
            return;
        }
        if (android.text.TextUtils.equals(this.courseId, "0")) {
            if (this.courseList.size() < 2) {
                this.b.titleBar.binding.arrow.setVisibility(8);
            }
            this.b.titleBar.setTitle(this.courseList.get(0).getCourseName());
            this.courseId = this.courseList.get(0).getCourseId();
        }
        this.rankController.loadWebData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showNetError(com.up366.common.http.Response response) {
        java.lang.String string;
        if (this.adapter.getDatas().isEmpty()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder tipImage = new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state6);
            if (com.up366.mobile.common.utils.ErrorMessageTool.isPoorNetwork(response)) {
                string = getString(com.up366.mobile.R.string.poor_network_state_tip);
            } else {
                string = getString(com.up366.mobile.R.string.server_error);
            }
            com.up366.mobile.common.views.viewmodel.EmptyViewModel emptyViewModelBuild = tipImage.setTipMessage(string).setLeftBtn(getString(com.up366.mobile.R.string.see_help)).setLeftBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showNetError$14(view);
                }
            }).setRightBtn(getString(com.up366.mobile.R.string.click_retry)).setRightBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showNetError$15(view);
                }
            }).build();
            this.adapter.reset();
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-1, emptyViewModelBuild));
            this.adapter.lambda$setDatas$0(arrayList);
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, com.up366.mobile.common.utils.ErrorMessageTool.convert(response));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showNetError$14(android.view.View view) {
        com.up366.mobile.commonui.LookHelpActivity.openPage(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNetError$15(android.view.View view) {
        this.b.refreshLayout.doRefresh();
    }

    private void showNoData() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.up366.mobile.common.views.viewmodel.EmptyViewModel emptyViewModelBuild = new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setType(3).build();
        this.adapter.reset();
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, emptyViewModelBuild));
        this.adapter.lambda$setDatas$0(arrayList);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WrongNoteRankListRefresh wrongNoteRankListRefresh) {
        this.b.refreshLayout.complete();
        if (!wrongNoteRankListRefresh.getResp().isError() && wrongNoteRankListRefresh.getWrongNoteRankList().size() > 0) {
            this.rankController.setBeforeRender(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.wrongnote.WrongNoteRankActivity$$ExternalSyntheticLambda7
                @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
                public final void setDatas(java.util.List list) {
                    list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(0));
                }
            });
        }
        this.rankController.onLoadWebData(wrongNoteRankListRefresh.getResp(), wrongNoteRankListRefresh.getWrongNoteRankList());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WrongNoteRankOrderRefresh wrongNoteRankOrderRefresh) {
        this.orderField = wrongNoteRankOrderRefresh.getRankType();
        this.isOrderDesc = wrongNoteRankOrderRefresh.isOrderDesc();
        this.b.refreshLayout.doRefresh();
    }
}
