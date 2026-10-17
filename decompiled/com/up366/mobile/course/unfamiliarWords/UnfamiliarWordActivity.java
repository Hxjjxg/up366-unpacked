package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class UnfamiliarWordActivity extends com.up366.mobile.common.base.BaseActivity {
    private static final java.lang.String BOOK_ID = "WORD_NOTE";
    private static final java.lang.String CUR_PAGE_TYPE = "cur_page_type";
    private static final int HAS_KILLED_PAGE = 1;
    public static final int REQUEST_CONDITION = 10000;
    private static final int TODAY_KILLED_PAGE = 2;
    public static final int TYPE_FROM_BOOK_CATALOG = 0;
    public static final int TYPE_FROM_CLASS_ROOM = 0;
    public static final int TYPE_FROM_TASK = 1;
    public static final int TYPE_INSIDE_BOOK = 2;
    public static final int TYPE_OUT = 1;
    private static final java.lang.String WORD_COUNT = "word_count_kill_page";
    private static final int WORD_NOTE_PAGE = 0;
    private static final java.lang.String WORD_PAGE_NEED_REFRESH = "word_page_need_refresh";
    private int assignId;
    com.up366.mobile.book.helper.CommonAudioHelper audioHelper;
    private com.up366.mobile.databinding.ActivityUnfamiliarWordsBinding b;
    private int courseId;
    private int curPageType;
    private int degree;
    private boolean isCurJob;
    private com.up366.mobile.course.unfamiliarWords.UnfamiliarWordAdapter mAdapter;
    private boolean mHasWordOutOfDate;
    private int mKilledWordCount;
    private com.up366.common.http.Response mResponse;
    private com.up366.mobile.commonui.condition.ConditionModel model;
    private float percent;
    private com.up366.mobile.course.unfamiliarWords.SortModel sortModel;
    private java.lang.String studyTaskId;
    private android.text.SpannableStringBuilder title;
    private int type = 1;
    private int fromType = 0;
    private java.lang.String bookId = "0";
    private java.lang.String bookName = "";
    private java.lang.String mPageTitle = "生词本";
    private boolean hasShowToDoTip = false;
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo> wordNoteStateController = new com.up366.mobile.common.base.USV5ListViewDataController<>(this);
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> wordNoteListController = new com.up366.mobile.common.base.USV5ListViewDataController<>(this);
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> wordNoteKilledListController = new com.up366.mobile.common.base.USV5ListViewDataController<>(this);
    private boolean oderDesc = true;
    private java.lang.String orderField = com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD_TIMES;
    private java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> mWordsList = new java.util.ArrayList();
    private java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> mTmpList = new java.util.ArrayList();
    private boolean mIsFirstRefresh = false;
    private com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo mStateInfoNormal = new com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo();
    private int stateCount = 1;
    private volatile java.lang.String prePlayAudioId = "";
    private volatile java.lang.String curPlayAudioId = "";
    private java.util.List<java.lang.String> deleteWordIds = new java.util.ArrayList();

    static /* synthetic */ void lambda$initKilledListController$5(java.util.List list) {
    }

    static /* synthetic */ void lambda$initListController$13(java.util.List list) {
    }

    static /* synthetic */ void lambda$initStateController$1(com.up366.common.http.Response response, java.util.List list) {
    }

    static /* synthetic */ void lambda$initStateController$2(java.util.List list) {
    }

    static /* synthetic */ void lambda$showNoteTipDialog$27(android.view.View view) {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "smartroom_vocab";
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
        this.b = (com.up366.mobile.databinding.ActivityUnfamiliarWordsBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_unfamiliar_words);
        initIntentData();
        initView();
        if (this.curPageType == 0) {
            initStateController();
            initListController();
        } else {
            initKilledListController();
        }
        this.b.refreshLayout.doRefresh();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void reportEnterEvent() {
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.BOOK_HOME, "wordnote", com.up366.mobile.common.onlinelog.OpLogData.Event.ENTER_PAGE, (androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject>) new androidx.core.util.Consumer() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda12
            public final void accept(java.lang.Object obj) {
                ((com.alibaba.fastjson.JSONObject) obj).put("bookid", com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.BOOK_ID);
            }
        });
    }

    protected void onRestart() {
        super.onRestart();
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onStop() {
        super.onStop();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    private void initIntentData() {
        android.content.Intent intent = getIntent();
        this.curPageType = intent.getIntExtra(CUR_PAGE_TYPE, 0);
        com.up366.mobile.commonui.condition.ConditionModel conditionModel = new com.up366.mobile.commonui.condition.ConditionModel(0, 0, com.up366.mobile.common.utils.TimeUtilsApp.dateStrToLong("2010-01-01", "yyyy-MM-dd"), com.up366.mobile.common.utils.TimeUtilsApp.dateStrToLong(com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy-MM-dd") + " 23:59:59", "yyyy-MM-dd HH:mm:ss"), "0");
        this.model = conditionModel;
        conditionModel.setShowBookList(true);
        this.sortModel = new com.up366.mobile.course.unfamiliarWords.SortModel(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD_TIMES, true, false, false);
        this.type = intent.getIntExtra("type", 1);
        this.fromType = intent.getIntExtra("fromType", 0);
        this.model.setFrom(0);
        if (this.type == 2) {
            this.bookId = intent.getStringExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
            this.bookName = intent.getStringExtra("bookName");
            this.model.setBookId(this.bookId);
            this.model.setShowBookList(false);
        }
        if (this.curPageType != 0) {
            this.model.setShowTime(false);
            this.bookId = intent.getStringExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
            this.mKilledWordCount = intent.getIntExtra(WORD_COUNT, 0);
            return;
        }
        this.model.setShowTime(true);
        if (this.fromType == 1) {
            this.isCurJob = intent.getBooleanExtra("isCurJob", false);
            this.courseId = intent.getIntExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, -1);
            this.studyTaskId = intent.getStringExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID);
            this.assignId = intent.getIntExtra("assignId", 0);
        }
        assertTrue(intent.hasExtra("type"));
        assertTrue(intent.hasExtra("fromType"));
        if (this.type == 2) {
            assertTrue(intent.hasExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID));
            assertTrue(intent.hasExtra("bookName"));
        }
        if (this.fromType == 1) {
            assertTrue(intent.hasExtra("isCurJob"));
            assertTrue(intent.hasExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID));
            assertTrue(intent.hasExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID));
        }
    }

    private void initStateController() {
        this.wordNoteStateController.setErrorView(new com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback
            public final void setDatas(com.up366.common.http.Response response, java.util.List list) {
                com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.lambda$initStateController$1(response, list);
            }
        });
        this.wordNoteStateController.setLoadingView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda11
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.lambda$initStateController$2(list);
            }
        });
        this.wordNoteStateController.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda22
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(0, list.get(0)));
            }
        });
        this.wordNoteStateController.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda30
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$initStateController$4();
            }
        });
        this.wordNoteStateController.setAdapter(this.mAdapter);
        this.wordNoteStateController.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStateController$4() throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWordNoteDetailStatList(this.bookId);
    }

    private void initKilledListController() {
        this.wordNoteKilledListController.setLoadingView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda33
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.lambda$initKilledListController$5(list);
            }
        });
        this.wordNoteKilledListController.setErrorViewClickAction(new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda34
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                this.f$0.lambda$initKilledListController$6(i);
            }
        });
        this.wordNoteKilledListController.setFilterData(getFilterCallback());
        this.wordNoteKilledListController.setBeforeRender(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda35
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                this.f$0.lambda$initKilledListController$7(list);
            }
        });
        this.wordNoteKilledListController.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda36
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                this.f$0.lambda$initKilledListController$8(list);
            }
        });
        this.wordNoteKilledListController.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                this.f$0.lambda$initKilledListController$9(list, list2);
            }
        });
        this.wordNoteKilledListController.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$initKilledListController$10();
            }
        });
        this.wordNoteKilledListController.setOnCompleteCallback(new com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback
            public final void onComplete() {
                this.f$0.lambda$initKilledListController$11();
            }
        });
        this.wordNoteKilledListController.setAdapter(this.mAdapter);
        this.wordNoteKilledListController.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initKilledListController$6(int i) {
        this.b.refreshLayout.doRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initKilledListController$7(java.util.List list) {
        if (this.mWordsList.size() > 0) {
            list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_16DP));
            list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(6, this.sortModel));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initKilledListController$8(java.util.List list) {
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state5).setTipMessage(getString(com.up366.mobile.R.string.word_has_cleared)).build()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initKilledListController$9(java.util.List list, java.util.List list2) {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo = (com.up366.mobile.course.wrongnote.modle.WordNoteInfo) it.next();
            wordNoteInfo.setBookId(this.bookId);
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, wordNoteInfo, java.lang.Boolean.valueOf(this.sortModel.isChineseHidden()), java.lang.Boolean.valueOf(this.sortModel.isEnglishHidden())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initKilledListController$10() throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchKilledWordNoteList(this.model, this.curPageType == 1 ? 0 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initKilledListController$11() {
        this.b.refreshLayout.complete();
    }

    private void initListController() {
        this.wordNoteListController.setErrorViewClickAction(new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda14
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                this.f$0.lambda$initListController$12(i);
            }
        });
        this.wordNoteListController.setLoadingView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda15
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.lambda$initListController$13(list);
            }
        });
        this.wordNoteListController.setFilterData(getFilterCallback());
        this.wordNoteListController.setBeforeRender(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda16
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                this.f$0.lambda$initListController$14(list);
            }
        });
        this.wordNoteListController.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda17
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                this.f$0.lambda$initListController$15(list);
            }
        });
        this.wordNoteListController.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda18
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                this.f$0.lambda$initListController$16(list, list2);
            }
        });
        this.wordNoteListController.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda19
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$initListController$17();
            }
        });
        this.wordNoteListController.setOnCompleteCallback(new com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda20
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback
            public final void onComplete() {
                this.f$0.lambda$initListController$18();
            }
        });
        this.wordNoteListController.setAdapter(this.mAdapter);
        this.wordNoteListController.setEnable(true);
        this.wordNoteStateController.pipe(this.wordNoteListController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListController$12(int i) {
        this.b.refreshLayout.doRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListController$14(java.util.List list) {
        if (this.title != null) {
            list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_16DP));
            list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(5, this.title, this.model));
        }
        if (this.mWordsList.size() > 0) {
            list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_16DP));
            list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(6, this.sortModel));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListController$15(java.util.List list) {
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state1).setTipMessage(getString(com.up366.mobile.R.string.word_has_cleared)).build()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListController$16(java.util.List list, java.util.List list2) {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, (com.up366.mobile.course.wrongnote.modle.WordNoteInfo) it.next(), java.lang.Boolean.valueOf(this.sortModel.isChineseHidden()), java.lang.Boolean.valueOf(this.sortModel.isEnglishHidden())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListController$17() throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWordNoteList(this.model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListController$18() {
        this.b.refreshLayout.complete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        new com.up366.mobile.common.helper.AppBarRefreshLayoutHelper().binding(this.b.appBar, this.b.refreshLayout, this.b.recycleView);
        new com.up366.mobile.common.helper.AppBarOffsetChangeHelper().with(this.b.appBar, this.b.toolbarLayout).onOffsetChange(new com.up366.mobile.common.helper.AppBarOffsetChangeHelper.IOnOffsetChangeListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda21
            @Override // com.up366.mobile.common.helper.AppBarOffsetChangeHelper.IOnOffsetChangeListener
            public final void onChange(int i, float f) {
                this.f$0.lambda$initView$19(i, f);
            }
        });
        initPageTitle();
        com.up366.mobile.course.unfamiliarWords.UnfamiliarWordAdapter unfamiliarWordAdapter = new com.up366.mobile.course.unfamiliarWords.UnfamiliarWordAdapter();
        this.mAdapter = unfamiliarWordAdapter;
        unfamiliarWordAdapter.setCurPage(this.curPageType);
        this.b.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
        this.b.recycleView.setAdapter(this.mAdapter);
        this.mAdapter.reset();
        this.b.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda23
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.refreshDataFromWeb();
            }
        });
        this.b.refreshLayout.setOnCompleteListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnCompleteListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda24
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnCompleteListener
            public final void onComplete() {
                com.up366.common.task.TaskUtils.postMainTaskDelay(200L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda6
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.EventShowWordTip());
                    }
                });
            }
        });
        if (this.curPageType != 0) {
            com.up366.mobile.common.utils.ViewUtil.gone(this.b.ibTip, this.b.ibRankingList);
            this.b.selectBtn.setChecked(!this.model.isOriginallyCondition());
            visible(this.b.selectBtn);
            this.b.selectBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda25
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$initView$22(view);
                }
            });
        } else {
            gone(this.b.selectBtn);
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.ibTip);
            this.b.bottomViewReadWord.setEnabled(false);
            this.b.bottomViewSelectWord.setEnabled(false);
            this.b.ibTip.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda26
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$initView$23(view);
                }
            });
            this.b.bottomViewReadWord.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda27
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$initView$24(view);
                }
            });
            this.b.bottomViewSelectWord.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda28
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$initView$25(view);
                }
            });
        }
        if (this.type == 2) {
            com.up366.mobile.common.utils.ViewUtil.gone(this.b.ibRankingList, this.b.ibTip);
            if (com.up366.common.StringUtils.isEmptyOrNull(this.bookName)) {
                this.b.toolbarLayout.setTitle(getString(com.up366.mobile.R.string.unfamiliar_word_note));
                return;
            } else {
                this.b.toolbarLayout.setTitle(this.bookName);
                return;
            }
        }
        if (this.curPageType == 0) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.ibTip);
            this.b.ibRankingList.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda29
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$initView$26(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$19(int i, float f) {
        this.percent = f;
        setAppBarPercent(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$22(android.view.View view) {
        android.content.Intent intent = new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.commonui.condition.ConditionActivity.class);
        intent.putExtra(com.up366.mobile.commonui.condition.ConditionActivity.INTENT_KEY_CONDITION_MODEL, this.model);
        intent.putExtra(com.up366.mobile.commonui.condition.ConditionActivity.INTENT_KEY_CONDITION_FROM, 0);
        startActivityForResult(intent, 10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$23(android.view.View view) {
        showNoteTipDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$24(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(view.getContext(), (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("exercise_type", "wordnote");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, this.bookId);
        jSONObject.put("fromJob", java.lang.Boolean.valueOf(this.fromType == 1));
        jSONObject.put("isCurJob", java.lang.Boolean.valueOf(this.isCurJob));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(this.courseId));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, this.studyTaskId);
        jSONObject.put("startTime", 0 == this.model.getBeginTime() ? "" : java.lang.Long.valueOf(this.model.getBeginTime()));
        jSONObject.put("endTime", 0 == this.model.getEndTime() ? "" : java.lang.Long.valueOf(this.model.getEndTime()));
        jSONObject.put("wordDegree", this.model.getDegree() != 0 ? java.lang.Integer.valueOf(this.model.getDegree()) : "");
        jSONObject.put("killMode", 1);
        int i = this.assignId;
        if (i > 0) {
            jSONObject.put("assignId", java.lang.Integer.valueOf(i));
        }
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
        com.up366.mobile.common.onlinelog.OpLogData.INSTANCE.addBehavior(this.courseId, this.bookId, "", this.studyTaskId, false, false, intent);
        startActivity(intent);
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$(WORD_PAGE_NEED_REFRESH).invalid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$25(android.view.View view) {
        android.content.Intent intent = new android.content.Intent(view.getContext(), (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("exercise_type", "wordnote");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, this.bookId);
        jSONObject.put("fromJob", java.lang.Boolean.valueOf(this.fromType == 1));
        jSONObject.put("isCurJob", java.lang.Boolean.valueOf(this.isCurJob));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(this.courseId));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, this.studyTaskId);
        jSONObject.put("startTime", 0 == this.model.getBeginTime() ? "" : java.lang.Long.valueOf(this.model.getBeginTime()));
        jSONObject.put("endTime", 0 == this.model.getEndTime() ? "" : java.lang.Long.valueOf(this.model.getEndTime()));
        jSONObject.put("wordDegree", this.model.getDegree() != 0 ? java.lang.Integer.valueOf(this.model.getDegree()) : "");
        jSONObject.put("killMode", 0);
        int i = this.assignId;
        if (i > 0) {
            jSONObject.put("assignId", java.lang.Integer.valueOf(i));
        }
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
        com.up366.mobile.common.onlinelog.OpLogData.INSTANCE.addBehavior(this.courseId, this.bookId, "", this.studyTaskId, false, false, intent);
        startActivity(intent);
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$(WORD_PAGE_NEED_REFRESH).invalid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$26(android.view.View view) {
        startActivity(new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.course.unfamiliarWords.UnfamiliarWordRankActivity.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showNoteTipDialog() {
        com.up366.mobile.common.dialog.AppDialog.create(this).title("说明").setBtnCloseVisibility(8).message(getResources().getString(com.up366.mobile.R.string.word_reversion_tip)).setMessageLeft().btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.lambda$showNoteTipDialog$27(view);
            }
        }).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initPageTitle() {
        int i = this.curPageType;
        if (i == 1 || i == 2) {
            this.b.title.setVisibility(0);
            new com.up366.mobile.common.helper.AppBarOffsetChangeHelper().with(this.b.appBar, this.b.toolbarLayout).left(this.b.tbvTrailBack).bind(this.b.title);
            final android.text.SpannableStringBuilder spannableStringBuilderBuild = new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append(getString(this.curPageType == 1 ? com.up366.mobile.R.string.have_destroy_word : com.up366.mobile.R.string.today_destroy_word)).append(java.lang.String.format(java.util.Locale.getDefault(), " (%d)", java.lang.Integer.valueOf(this.mKilledWordCount))).setSpan(new com.up366.mobile.common.views.VerticalCenterSpan((int) (this.b.title.getTextSize() * 0.6f), androidx.core.content.ContextCompat.getColor(this, com.up366.mobile.R.color.c5))).build();
            com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda9
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$initPageTitle$28(spannableStringBuilderBuild);
                }
            });
            return;
        }
        this.b.title.setVisibility(8);
        this.b.toolbarLayout.setTitle(this.mPageTitle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPageTitle$28(java.lang.CharSequence charSequence) throws java.lang.Exception {
        this.b.title.setText(charSequence);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        initAudioListener();
        this.mIsFirstRefresh = true;
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$(WORD_PAGE_NEED_REFRESH).run(new java.lang.Runnable() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.refreshDataFromWeb();
            }
        });
        setAppBarPercent(this.percent);
    }

    private void setAppBarPercent(float f) {
        if (this.curPageType != 0) {
            this.b.selectBtn.setAlpha(1.0f - f);
            this.b.selectBtn.setVisibility(f != 1.0f ? 0 : 4);
            this.b.selectBtn.setEnabled(f == 0.0f);
            this.b.selectBtn.setClickable(f == 0.0f);
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onPause() {
        super.onPause();
        this.audioHelper.pauseAll();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        if (this.curPageType == 0) {
            this.wordNoteStateController.destroy();
            this.wordNoteListController.destroy();
        } else {
            this.wordNoteKilledListController.destroy();
        }
        this.audioHelper.release();
    }

    private void initAudioListener() {
        this.audioHelper = new com.up366.mobile.book.helper.CommonAudioHelper(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.EventWordNoteAudioPlay eventWordNoteAudioPlay) {
        if (eventWordNoteAudioPlay.getCurPage() != this.curPageType) {
            return;
        }
        final com.up366.mobile.course.wrongnote.modle.WordNoteInfo data = eventWordNoteAudioPlay.getData();
        if (!data.getWordId().equals(this.curPlayAudioId)) {
            this.prePlayAudioId = this.curPlayAudioId;
            this.curPlayAudioId = data.getWordId();
        }
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.prePlayAudioId)) {
            this.audioHelper.stop(this.prePlayAudioId);
        }
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, getString(com.up366.mobile.R.string.connect_net_before_play));
            return;
        }
        com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder();
        audioHolder.audioId = this.curPlayAudioId;
        audioHolder.isWAV = false;
        audioHolder.isFFT = false;
        audioHolder.autoDestroy = true;
        audioHolder.samplingRate = 12;
        audioHolder.rate = 1.0f;
        audioHolder.volume = 1.0f;
        audioHolder.seek = 0L;
        audioHolder.callBack = getAudioCallBack();
        audioHolder.onError = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda31
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError
            public final void onError(java.lang.Exception exc) {
                this.f$0.lambda$onMessageEvent$30(data, exc);
            }
        };
        com.up366.common.log.Logger.info("play word  audio " + data.getVoiceFile());
        audioHolder.uri = data.getVoiceFile();
        this.audioHelper.play(audioHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$30(final com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo, java.lang.Exception exc) {
        if (this.curPlayAudioId.equals(wordNoteInfo.getWordId())) {
            this.curPlayAudioId = "";
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$29(wordNoteInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onMessageEvent$29(com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo) throws java.lang.Exception {
        wordNoteInfo.setState(4);
        this.wordNoteListController.refresh();
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, getString(com.up366.mobile.R.string.word_play_failed));
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$1, reason: invalid class name */
    class AnonymousClass1 implements com.up366.mobile.book.helper.ICommonAudioCallBack {
        @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
        public void onWavUpdate(java.lang.String str, byte[] bArr) {
        }

        AnonymousClass1() {
        }

        @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
        public void onMediaStateResult(java.lang.String str, int i, int i2) {
            if (i == 4 && com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.this.curPlayAudioId.equals(str)) {
                com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.this.curPlayAudioId = "";
            }
            java.util.Iterator it = com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.this.mTmpList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo = (com.up366.mobile.course.wrongnote.modle.WordNoteInfo) it.next();
                if (android.text.TextUtils.equals(wordNoteInfo.getWordId(), str)) {
                    wordNoteInfo.setState(i);
                    break;
                }
            }
            if (com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.this.curPageType == 0) {
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$1$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$onMediaStateResult$0();
                    }
                });
            } else {
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$1$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$onMediaStateResult$1();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMediaStateResult$0() throws java.lang.Exception {
            com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.this.wordNoteListController.refresh();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMediaStateResult$1() throws java.lang.Exception {
            com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.this.wordNoteKilledListController.refresh();
        }
    }

    private com.up366.mobile.book.helper.ICommonAudioCallBack getAudioCallBack() {
        return new com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.AnonymousClass1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshDataFromWeb() {
        if (this.curPageType == 0) {
            this.stateCount = 1;
            this.mHasWordOutOfDate = false;
            this.wordNoteStateController.loadWebData();
            this.wordNoteListController.loadWebData();
            return;
        }
        this.wordNoteKilledListController.loadWebData();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10000 && i2 == -1) {
            com.up366.mobile.commonui.condition.ConditionModel conditionModel = (com.up366.mobile.commonui.condition.ConditionModel) intent.getSerializableExtra(com.up366.mobile.commonui.condition.ConditionActivity.INTENT_KEY_CONDITION_RESULT);
            conditionModel.setOrderType(this.model.getOrderType());
            conditionModel.setOrderField(this.model.getOrderField());
            this.model = conditionModel;
            this.degree = conditionModel.getDegree();
            this.b.selectBtn.setChecked(!this.model.isOriginallyCondition());
            if (this.curPageType == 0) {
                this.wordNoteListController.reload();
            } else {
                this.wordNoteKilledListController.reload();
            }
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WrongNoteDetailStatInfoRefresh wrongNoteDetailStatInfoRefresh) {
        if (wrongNoteDetailStatInfoRefresh.getResp().isError()) {
            this.wordNoteStateController.onLoadWebData(wrongNoteDetailStatInfoRefresh.getResp(), new java.util.ArrayList());
            return;
        }
        if (this.mHasWordOutOfDate) {
            this.mStateInfoNormal.setKilledCount(wrongNoteDetailStatInfoRefresh.getWrongNoteStatInfo().getKilledCount());
            this.mStateInfoNormal.setKilledCountLately(wrongNoteDetailStatInfoRefresh.getWrongNoteStatInfo().getKilledCountLately());
        } else {
            this.mStateInfoNormal = wrongNoteDetailStatInfoRefresh.getWrongNoteStatInfo();
        }
        if (!this.hasShowToDoTip && this.fromType == 1 && this.mStateInfoNormal.getWordCount() == 0 && this.isCurJob) {
            this.hasShowToDoTip = true;
            com.up366.mobile.common.dialog.DialogOkCancle.showNoteDialog("暂时还没有生词\n快去作答其他练习吧!", "去做答", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$onMessageEvent$31(view);
                }
            });
        } else {
            this.hasShowToDoTip = true;
        }
        loadStateInfo(wrongNoteDetailStatInfoRefresh.getResp(), this.mStateInfoNormal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$31(android.view.View view) {
        if (view.getId() == 2131362067) {
            com.up366.mobile.common.logic.Auth.cur().taskMgr().submitTaskToHistory("{\"courseId\": " + this.courseId + ",\"studyTaskId\": \"" + this.studyTaskId + "\"}");
        }
    }

    private void loadStateInfo(com.up366.common.http.Response response, com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo wrongNoteStatInfo) {
        int i = this.stateCount;
        if (i == 0) {
            this.wordNoteStateController.onLoadWebData(response, wrongNoteStatInfo);
        } else {
            this.stateCount = i - 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WordNoteDetailListRefresh wordNoteDetailListRefresh) {
        if (this.curPageType != 0) {
            return;
        }
        if (wordNoteDetailListRefresh.getResp().isError()) {
            this.wordNoteListController.onLoadWebData(wordNoteDetailListRefresh.getResp(), new java.util.ArrayList());
            return;
        }
        this.mResponse = wordNoteDetailListRefresh.getResp() == null ? this.mResponse : wordNoteDetailListRefresh.getResp();
        this.mWordsList.clear();
        for (com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo : wordNoteDetailListRefresh.getWordNoteList()) {
            if (!com.up366.common.StringUtils.isEmptyOrNull(wordNoteInfo.getWord())) {
                this.mWordsList.add(wordNoteInfo);
            }
        }
        if (!this.mIsFirstRefresh && this.mWordsList.size() == 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, com.up366.mobile.R.string.no_unfamiliar_word);
        }
        this.mIsFirstRefresh = false;
        if (this.mWordsList.size() != wordNoteDetailListRefresh.getWordNoteList().size()) {
            this.mHasWordOutOfDate = true;
            this.mStateInfoNormal.setWordCount(this.mWordsList.size());
        }
        loadStateInfo(wordNoteDetailListRefresh.getResp(), this.mStateInfoNormal);
        this.title = new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("生词详情").append(java.lang.String.format(java.util.Locale.getDefault(), " (%d个)", java.lang.Integer.valueOf(this.mWordsList.size()))).setSpan(new com.up366.mobile.common.views.VerticalCenterSpan(com.up366.common.DpUtilsUp.sp2px(12.0f))).build();
        refreshList();
        if (this.mWordsList.size() > 0) {
            this.b.bottomViewReadWord.setEnabled(true);
            this.b.bottomViewSelectWord.setEnabled(true);
            this.b.bottomView.setVisibility(0);
        } else {
            this.b.bottomViewReadWord.setEnabled(false);
            this.b.bottomViewSelectWord.setEnabled(false);
            this.b.bottomView.setVisibility(8);
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WordNoteKilledListRefresh wordNoteKilledListRefresh) {
        if (this.curPageType == 0) {
            return;
        }
        if (wordNoteKilledListRefresh.getResp().isError()) {
            this.wordNoteKilledListController.onLoadWebData(wordNoteKilledListRefresh.getResp(), new java.util.ArrayList());
            return;
        }
        this.mResponse = wordNoteKilledListRefresh.getResp() == null ? this.mResponse : wordNoteKilledListRefresh.getResp();
        this.mWordsList.clear();
        for (com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo : wordNoteKilledListRefresh.getResult()) {
            if (!com.up366.common.StringUtils.isEmptyOrNull(wordNoteInfo.getWord())) {
                this.mWordsList.add(wordNoteInfo);
            }
        }
        this.title = new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("生词详情").append(java.lang.String.format(java.util.Locale.getDefault(), " (%d个)", java.lang.Integer.valueOf(this.mWordsList.size()))).setSpan(new com.up366.mobile.common.views.VerticalCenterSpan(com.up366.common.DpUtilsUp.sp2px(12.0f))).build();
        refreshList();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WordNoteNeedRefreshListEvent wordNoteNeedRefreshListEvent) {
        if (wordNoteNeedRefreshListEvent.getCurPage() != this.curPageType) {
            return;
        }
        com.up366.mobile.course.unfamiliarWords.SortModel data = wordNoteNeedRefreshListEvent.getData();
        this.oderDesc = data.isOrderDesc();
        this.orderField = data.getOrderField();
        this.model.setOrderType(this.oderDesc ? "desc" : "asc");
        this.model.setOrderField(this.orderField);
        refreshList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.EventTaskSubmit eventTaskSubmit) {
        if (eventTaskSubmit.getResp().isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "操作失败：" + eventTaskSubmit.getResp().getInfo());
        }
        finish();
    }

    private void refreshList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.mTmpList = arrayList;
        int i = this.degree;
        if (i == 0) {
            arrayList.addAll(this.mWordsList);
        } else if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
            for (com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo : this.mWordsList) {
                if (wordNoteInfo.getDegree() == this.degree) {
                    this.mTmpList.add(wordNoteInfo);
                }
            }
        } else {
            arrayList.addAll(this.mWordsList);
        }
        com.up366.mobile.course.unfamiliarWords.SortWordListUtils.sortList(this.mTmpList, this.orderField, this.oderDesc);
        if (this.curPageType == 0) {
            this.wordNoteListController.onLoadWebData(this.mResponse, this.mTmpList);
        } else {
            this.wordNoteKilledListController.onLoadWebData(this.mResponse, this.mTmpList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.SkipKilledEvent skipKilledEvent) {
        android.content.Intent intent = new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.class);
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, this.bookId);
        if (skipKilledEvent.getClassify() == 0) {
            intent.putExtra(CUR_PAGE_TYPE, 1);
        }
        if (skipKilledEvent.getClassify() == 1) {
            intent.putExtra(CUR_PAGE_TYPE, 2);
        }
        intent.putExtra(WORD_COUNT, skipKilledEvent.getWordCount());
        startActivity(intent);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(final com.up366.mobile.common.event.SkipWordSourceActivityEvent skipWordSourceActivityEvent) {
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.curPlayAudioId)) {
            this.audioHelper.stop(this.curPlayAudioId);
        }
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda32
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$32(skipWordSourceActivityEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onMessageEvent$32(com.up366.mobile.common.event.SkipWordSourceActivityEvent skipWordSourceActivityEvent) throws java.lang.Exception {
        android.content.Intent intent = new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.course.unfamiliarWords.WordSourceActivity.class);
        intent.putExtra(com.up366.mobile.course.unfamiliarWords.WordSourceActivity.USED_KILLED_WORD, skipWordSourceActivityEvent.isKilledWord());
        intent.putExtra(com.up366.mobile.course.unfamiliarWords.WordSourceActivity.KEY_WORD_INFO, skipWordSourceActivityEvent.getInfo());
        startActivity(intent);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WordNoteDetailShowTxt wordNoteDetailShowTxt) {
        if (wordNoteDetailShowTxt.getCurPage() != this.curPageType) {
            return;
        }
        this.mAdapter.reset();
        com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> uSV5ListViewDataController = this.wordNoteListController;
        if (uSV5ListViewDataController != null) {
            uSV5ListViewDataController.refresh();
        }
        com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> uSV5ListViewDataController2 = this.wordNoteKilledListController;
        if (uSV5ListViewDataController2 != null) {
            uSV5ListViewDataController2.refresh();
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WordListRefreshEvent wordListRefreshEvent) {
        this.wordNoteStateController.reload();
        this.wordNoteListController.reload();
        this.wordNoteKilledListController.reload();
    }

    private com.up366.mobile.common.base.BaseListViewDataController.ISetDataFilterCallback<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> getFilterCallback() {
        return new com.up366.mobile.common.base.BaseListViewDataController.ISetDataFilterCallback() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda10
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataFilterCallback
            public final boolean filter(java.lang.Object obj) {
                return this.f$0.lambda$getFilterCallback$33((com.up366.mobile.course.wrongnote.modle.WordNoteInfo) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getFilterCallback$33(com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo) {
        return !this.deleteWordIds.contains(wordNoteInfo.getWordId());
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void reportPageDuration(final long j) {
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.BOOK_HOME, "wordnote", com.up366.mobile.common.onlinelog.OpLogData.Event.LEAVE_PAGE, (androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject>) new androidx.core.util.Consumer() { // from class: com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity$$ExternalSyntheticLambda8
            public final void accept(java.lang.Object obj) {
                this.f$0.lambda$reportPageDuration$34(j, (com.alibaba.fastjson.JSONObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportPageDuration$34(long j, com.alibaba.fastjson.JSONObject jSONObject) {
        jSONObject.put("bookid", BOOK_ID);
        jSONObject.put("duration", java.lang.Long.valueOf(j));
        jSONObject.put("entertime", java.lang.Long.valueOf(this.staticEnterTime));
    }
}
