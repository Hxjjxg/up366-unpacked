package com.up366.mobile.course.wrongnote;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WrongNoteDetailFragment extends com.up366.mobile.common.base.BaseFragment {
    public static final int REQUEST_CONDITION = 10001;
    private static final java.lang.String STAGE_ID = "STAGE_ID";
    private static final java.lang.String SUBJECT_ID = "subjectId";
    public static final int TYPE_FROM_BOOK_CATALOG = 2;
    public static final int TYPE_FROM_CLASS_ROOM = 0;
    public static final int TYPE_FROM_TASK = 1;
    public static final int TYPE_INSIDE_BOOK = 2;
    public static final int TYPE_OUT = 1;
    private androidx.fragment.app.FragmentActivity activity;
    private com.up366.mobile.course.wrongnote.WrongNoteDetailAdapter adapter;
    private int assignId;
    private com.up366.mobile.databinding.ActivityWrongnoteDetailBinding b;
    private int courseId;
    private com.up366.mobile.course.wrongnote.WrongNoteActivity fmAct;
    private boolean isCurJob;
    private com.up366.mobile.commonui.condition.ConditionModel model;
    private int position;
    private java.lang.String studyTaskId;
    private androidx.core.util.Supplier<java.lang.Integer> supplier;
    private int subjectId = 0;
    private int stageId = 0;
    private com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo statInfo = new com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo();
    private java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo> knowledgeList = new java.util.ArrayList();
    private int type = 1;
    private int fromType = 0;
    private java.lang.String bookId = "0";
    private boolean hasShowToDoTip = false;
    private boolean firstResume = true;
    private boolean isFirst = false;

    public static com.up366.mobile.course.wrongnote.WrongNoteDetailFragment newInstance(int i, int i2, boolean z) {
        com.up366.mobile.course.wrongnote.WrongNoteDetailFragment wrongNoteDetailFragment = new com.up366.mobile.course.wrongnote.WrongNoteDetailFragment();
        wrongNoteDetailFragment.setFirst(z);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt(SUBJECT_ID, i);
        bundle.putInt(STAGE_ID, i2);
        wrongNoteDetailFragment.setArguments(bundle);
        return wrongNoteDetailFragment;
    }

    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        this.activity = getActivity();
        this.b = (com.up366.mobile.databinding.ActivityWrongnoteDetailBinding) androidx.databinding.DataBindingUtil.inflate(layoutInflater, com.up366.mobile.R.layout.activity_wrongnote_detail, viewGroup, false);
        com.up366.common.EventBusUtilsUp.register(this);
        initIntentData();
        initView();
        return this.b.getRoot();
    }

    private void initIntentData() {
        android.content.Intent intent = this.activity.getIntent();
        this.subjectId = intent.getIntExtra(SUBJECT_ID, 0);
        this.stageId = intent.getIntExtra("stageId", 0);
        this.type = intent.getIntExtra("type", 1);
        this.fromType = intent.getIntExtra("fromType", 0);
        com.up366.mobile.commonui.condition.ConditionModel conditionModel = new com.up366.mobile.commonui.condition.ConditionModel(0, com.up366.mobile.common.utils.TimeUtilsApp.dateStrToLong("2010-01-01", "yyyy-MM-dd"), com.up366.mobile.common.utils.TimeUtilsApp.dateStrToLong(com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy-MM-dd") + " 23:59:59", "yyyy-MM-dd HH:mm:ss"), "0");
        this.model = conditionModel;
        conditionModel.setShowBookList(true);
        if (this.type == 1 && getArguments() != null) {
            this.subjectId = getArguments().getInt(SUBJECT_ID);
            this.stageId = getArguments().getInt(STAGE_ID);
        }
        if (this.type == 2) {
            java.lang.String stringExtra = intent.getStringExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
            this.bookId = stringExtra;
            this.model.setBookId(stringExtra);
            this.model.setShowBookList(false);
        }
        if (this.fromType == 1) {
            this.isCurJob = intent.getBooleanExtra("isCurJob", false);
            this.courseId = intent.getIntExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, -1);
            this.studyTaskId = intent.getStringExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID);
            this.assignId = intent.getIntExtra("assignId", 0);
        }
        this.model.setSubjectId(this.subjectId);
        this.model.setStageId(this.stageId);
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.firstResume) {
            this.firstResume = false;
            this.b.refreshLayout.doRefresh();
        } else {
            androidx.core.util.Supplier<java.lang.Integer> supplier = this.supplier;
            if (supplier != null && this.position == ((java.lang.Integer) supplier.get()).intValue()) {
                refreshDataFromWeb();
            }
        }
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("wrongnote-submit").run(new java.lang.Runnable() { // from class: com.up366.mobile.course.wrongnote.WrongNoteDetailFragment$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.refreshDataFromWeb();
            }
        });
    }

    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.up366.mobile.course.wrongnote.WrongNoteActivity wrongNoteActivityRequireActivity = requireActivity();
        this.fmAct = wrongNoteActivityRequireActivity;
        wrongNoteActivityRequireActivity.setPullRecyclerView(this.b.refreshLayout, this.b.recycleView);
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10001 && i2 == -1) {
            com.up366.mobile.commonui.condition.ConditionModel conditionModel = (com.up366.mobile.commonui.condition.ConditionModel) intent.getSerializableExtra(com.up366.mobile.commonui.condition.ConditionActivity.INTENT_KEY_CONDITION_RESULT);
            conditionModel.setOrderType(this.model.getOrderType());
            conditionModel.setOrderField(this.model.getOrderField());
            this.model = conditionModel;
            refreshDataFromWeb();
        }
    }

    private void initView() {
        this.b.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteDetailFragment$$ExternalSyntheticLambda4
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.refreshDataFromWeb();
            }
        });
        this.b.refreshLayout.setOnCompleteListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnCompleteListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteDetailFragment$$ExternalSyntheticLambda5
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnCompleteListener
            public final void onComplete() {
                com.up366.common.task.TaskUtils.postMainTaskDelay(200L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.wrongnote.WrongNoteDetailFragment$$ExternalSyntheticLambda6
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.EventShowWrongTip());
                    }
                });
            }
        });
        this.adapter = new com.up366.mobile.course.wrongnote.WrongNoteDetailAdapter();
        this.b.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this.activity));
        this.b.recycleView.setAdapter(this.adapter);
        com.up366.mobile.common.views.WrongNoteSortTypeView.type = 3;
        com.up366.mobile.common.views.WrongNoteSortTypeView.orderDesc = true;
    }

    public void setBottomViewVisible() {
        if (this.fmAct != null) {
            java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo> list = this.knowledgeList;
            if (list != null && list.size() != 0) {
                this.fmAct.setBottomViewVisible(!this.knowledgeList.isEmpty());
            } else {
                this.fmAct.setBottomViewVisible(false);
            }
        }
    }

    public com.up366.mobile.commonui.condition.ConditionModel getModel() {
        return this.model;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshDataFromWeb() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.wrongnote.WrongNoteDetailFragment$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$refreshDataFromWeb$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshDataFromWeb$4() throws java.lang.Exception {
        final com.up366.common.http.NetHolder<com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo> netHolderFetchWrongNoteDetailStatList = com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWrongNoteDetailStatList(this.stageId, this.subjectId, this.bookId);
        final com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo>> netHolderFetchWrongNoteDetailList = com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWrongNoteDetailList(this.model);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.wrongnote.WrongNoteDetailFragment$$ExternalSyntheticLambda10
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$refreshDataFromWeb$3(netHolderFetchWrongNoteDetailStatList, netHolderFetchWrongNoteDetailList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$refreshDataFromWeb$3(com.up366.common.http.NetHolder netHolder, com.up366.common.http.NetHolder netHolder2) throws java.lang.Exception {
        this.b.refreshLayout.complete();
        if (netHolder.resp.isError()) {
            showNetErrorItem(netHolder.resp.getCode(), netHolder.resp.getInfo());
            return;
        }
        if (netHolder2.resp.isError()) {
            showNetErrorItem(netHolder2.resp.getCode(), netHolder2.resp.getInfo());
            return;
        }
        com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo wrongNoteStatInfo = (com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo) netHolder.info;
        this.statInfo = wrongNoteStatInfo;
        if (!this.hasShowToDoTip && this.fromType == 1 && wrongNoteStatInfo.getWrongCount() == 0 && this.isCurJob) {
            this.hasShowToDoTip = true;
            com.up366.mobile.common.dialog.DialogOkCancle.showNoteDialog("暂时还没有错题\n快去作答其他练习吧!", "去做答", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteDetailFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$refreshDataFromWeb$2(view);
                }
            });
        } else {
            this.hasShowToDoTip = true;
        }
        this.knowledgeList = (java.util.List) netHolder2.info;
        refreshList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshDataFromWeb$2(android.view.View view) {
        if (view.getId() == 2131362067) {
            com.up366.mobile.common.logic.Auth.cur().taskMgr().submitTaskToHistory("{\"courseId\": " + this.courseId + ",\"studyTaskId\": \"" + this.studyTaskId + "\"}");
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.EventTaskSubmit eventTaskSubmit) {
        if (eventTaskSubmit.getResp().isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.activity, "操作失败：" + eventTaskSubmit.getResp().getInfo());
        }
        this.activity.finish();
    }

    private void refreshList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.statInfo.setStageId(this.stageId);
        this.statInfo.setSubjectId(this.subjectId);
        this.statInfo.setBookId(this.bookId);
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(0, this.statInfo, java.lang.Boolean.valueOf(this.isFirst)));
        this.model.setFrom(1);
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(5, new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("错题详情").append(java.lang.String.format(java.util.Locale.getDefault(), " (%d类)", java.lang.Integer.valueOf(this.knowledgeList.size()))).setSpan(new com.up366.mobile.common.views.VerticalCenterSpan(com.up366.common.DpUtilsUp.sp2px(12.0f))).build(), this.model, this));
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_16DP));
        if (this.knowledgeList.isEmpty()) {
            this.fmAct.setBottomViewVisible(false);
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state1).setTipMessage("哇！大侠好厉害，错题全都消灭了！").build()));
        } else {
            int i = com.up366.mobile.common.views.WrongNoteSortTypeView.type;
            if (i == 1) {
                java.util.Collections.sort(this.knowledgeList, new java.util.Comparator() { // from class: com.up366.mobile.course.wrongnote.WrongNoteDetailFragment$$ExternalSyntheticLambda7
                    @Override // java.util.Comparator
                    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                        return com.up366.mobile.course.wrongnote.WrongNoteDetailFragment.lambda$refreshList$5((com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo) obj, (com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo) obj2);
                    }
                });
            } else if (i == 2) {
                java.util.Collections.sort(this.knowledgeList, new java.util.Comparator() { // from class: com.up366.mobile.course.wrongnote.WrongNoteDetailFragment$$ExternalSyntheticLambda8
                    @Override // java.util.Comparator
                    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                        return com.up366.mobile.course.wrongnote.WrongNoteDetailFragment.lambda$refreshList$6((com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo) obj, (com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo) obj2);
                    }
                });
            } else if (i == 3) {
                java.util.Collections.sort(this.knowledgeList, new java.util.Comparator() { // from class: com.up366.mobile.course.wrongnote.WrongNoteDetailFragment$$ExternalSyntheticLambda9
                    @Override // java.util.Comparator
                    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                        return com.up366.mobile.course.wrongnote.WrongNoteDetailFragment.lambda$refreshList$7((com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo) obj, (com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo) obj2);
                    }
                });
            }
            this.fmAct.setBottomViewVisible(true);
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(6));
            for (com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo wrongNoteKnowledgeInfo : this.knowledgeList) {
                wrongNoteKnowledgeInfo.setStageId(this.stageId);
                wrongNoteKnowledgeInfo.setSubjectId(this.subjectId);
                wrongNoteKnowledgeInfo.setBookId(this.bookId);
                wrongNoteKnowledgeInfo.setFromType(this.fromType);
                wrongNoteKnowledgeInfo.setCurJob(this.isCurJob);
                wrongNoteKnowledgeInfo.setCourseId(this.courseId);
                wrongNoteKnowledgeInfo.setStudyTaskId(this.studyTaskId);
                wrongNoteKnowledgeInfo.setAssignId(this.assignId);
                arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, wrongNoteKnowledgeInfo, this.model));
            }
        }
        this.adapter.reset();
        this.adapter.lambda$setDatas$0(arrayList);
    }

    static /* synthetic */ int lambda$refreshList$5(com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo wrongNoteKnowledgeInfo, com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo wrongNoteKnowledgeInfo2) {
        if (!com.up366.mobile.common.views.WrongNoteSortTypeView.orderDesc) {
            return wrongNoteKnowledgeInfo.getQtypeNamePinYin().compareTo(wrongNoteKnowledgeInfo2.getQtypeNamePinYin());
        }
        return -wrongNoteKnowledgeInfo.getQtypeNamePinYin().compareTo(wrongNoteKnowledgeInfo2.getQtypeNamePinYin());
    }

    static /* synthetic */ int lambda$refreshList$6(com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo wrongNoteKnowledgeInfo, com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo wrongNoteKnowledgeInfo2) {
        if (!com.up366.mobile.common.views.WrongNoteSortTypeView.orderDesc) {
            return wrongNoteKnowledgeInfo.getKnowledgeNamePinYin().compareTo(wrongNoteKnowledgeInfo2.getKnowledgeNamePinYin());
        }
        return -wrongNoteKnowledgeInfo.getKnowledgeNamePinYin().compareTo(wrongNoteKnowledgeInfo2.getKnowledgeNamePinYin());
    }

    static /* synthetic */ int lambda$refreshList$7(com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo wrongNoteKnowledgeInfo, com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo wrongNoteKnowledgeInfo2) {
        if (!com.up366.mobile.common.views.WrongNoteSortTypeView.orderDesc) {
            return wrongNoteKnowledgeInfo.getWrongTimes() - wrongNoteKnowledgeInfo2.getWrongTimes();
        }
        return wrongNoteKnowledgeInfo2.getWrongTimes() - wrongNoteKnowledgeInfo.getWrongTimes();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WrongNoteDetailOrderRefresh wrongNoteDetailOrderRefresh) {
        refreshList();
    }

    private void showNetErrorItem(int i, java.lang.String str) {
        java.lang.String string;
        com.up366.common.http.Response response = new com.up366.common.http.Response();
        response.setCode(i);
        response.setInfo(str);
        if (this.knowledgeList.isEmpty()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder tipImage = new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state6);
            if (com.up366.mobile.common.utils.ErrorMessageTool.isPoorNetwork(response)) {
                string = getString(com.up366.mobile.R.string.poor_network_state_tip);
            } else {
                string = getString(com.up366.mobile.R.string.server_error);
            }
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-1, tipImage.setTipMessage(string).setLeftBtn(getString(com.up366.mobile.R.string.see_help)).setLeftBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteDetailFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showNetErrorItem$8(view);
                }
            }).setRightBtn(getString(com.up366.mobile.R.string.click_retry)).setRightBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteDetailFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showNetErrorItem$9(view);
                }
            }).build()));
            this.adapter.reset();
            this.adapter.lambda$setDatas$0(arrayList);
            this.fmAct.setBottomViewVisible(false);
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this.activity, com.up366.mobile.common.utils.ErrorMessageTool.convert(response));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNetErrorItem$8(android.view.View view) {
        com.up366.mobile.commonui.LookHelpActivity.openPage(this.activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNetErrorItem$9(android.view.View view) {
        this.b.refreshLayout.doRefresh();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.JSRemoveWordEvent jSRemoveWordEvent) {
        if (getLifecycle().getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.RESUMED)) {
            refreshDataFromWeb();
        }
    }

    public void setPosition(int i, androidx.core.util.Supplier<java.lang.Integer> supplier) {
        this.position = i;
        this.supplier = supplier;
    }

    public void setFirst(boolean z) {
        this.isFirst = z;
    }
}
