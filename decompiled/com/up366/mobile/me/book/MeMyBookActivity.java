package com.up366.mobile.me.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeMyBookActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.me.book.MeMyBookActivityAdapter adapter;
    private com.up366.mobile.databinding.MeMyBookAcivityLayoutBinding binding;
    private float percent;
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.logic.model.MyBook> controller = new com.up366.mobile.common.base.USV5ListViewDataController<>(this);
    private java.util.List<com.up366.mobile.course.mgr.CourseInfo> courseInfoList = new java.util.ArrayList();
    private java.util.List<com.up366.mobile.common.logic.model.MyBook> books = new java.util.ArrayList();
    private com.up366.mobile.course.mgr.CourseInfo courseInfo = new com.up366.mobile.course.mgr.CourseInfo(0, "全部");

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_book";
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (com.up366.mobile.databinding.MeMyBookAcivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.me_my_book_acivity_layout);
        com.up366.common.EventBusUtilsUp.register(this);
        initView();
        initController();
        com.up366.common.http.Response response = new com.up366.common.http.Response();
        response.setCode(0);
        onMessageEvent(new com.up366.mobile.common.event.MyBookListEvent(response, com.up366.mobile.me.book.MeBookUtil.getMyBooksFromCacheEvent(), com.up366.mobile.me.book.MeBookUtil.getCourseListFromCacheEvent()));
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        com.up366.mobile.common.logic.Auth.cur().book().loadMyProducts();
        com.up366.mobile.common.logic.Auth.cur().meBookMgr().loadMyBooks();
        com.up366.mobile.common.logic.Auth.cur().meBookMgr().fetchMyBooks();
        setAppBarPercent(this.percent);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        new com.up366.mobile.common.helper.AppBarRefreshLayoutHelper().binding(this.binding.appBar, this.binding.pullRefreshLayout, this.binding.recycleView);
        this.binding.pullRefreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda3
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.lambda$initView$0();
            }
        });
        new com.up366.mobile.common.helper.AppBarOffsetChangeHelper().with(this.binding.appBar, this.binding.toolbarLayout).onOffsetChange(new com.up366.mobile.common.helper.AppBarOffsetChangeHelper.IOnOffsetChangeListener() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.helper.AppBarOffsetChangeHelper.IOnOffsetChangeListener
            public final void onChange(int i, float f) {
                this.f$0.lambda$initView$1(i, f);
            }
        });
        this.adapter = new com.up366.mobile.me.book.MeMyBookActivityAdapter();
        this.binding.recycleView.setAdapter(this.adapter);
        com.up366.mobile.me.book.CustomLinearLayoutManager customLinearLayoutManager = new com.up366.mobile.me.book.CustomLinearLayoutManager(this);
        customLinearLayoutManager.setOrientation(1);
        this.binding.recycleView.setLayoutManager(customLinearLayoutManager);
        this.binding.meMyBookSelector.setTag(this.courseInfo);
        this.binding.searchIcon.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$2(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.meMyBookSelector, 1000L, new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$7(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        this.controller.loadWebData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(int i, float f) {
        this.percent = f;
        setAppBarPercent(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$2(android.view.View view) {
        startActivity(new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.me.book.MeMyBookSearchActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$7(android.view.View view) {
        com.up366.mobile.me.book.MeBookUtil.showCourseCheckSheet(this, this.courseInfoList, (com.up366.mobile.course.mgr.CourseInfo) this.binding.meMyBookSelector.getTag(), new com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda13
            @Override // com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener
            public final void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel) {
                this.f$0.lambda$initView$6(qMUIBottomSheet, bottomSheetModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$6(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, final com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel) {
        if (!com.up366.mobile.common.logic.Auth.cur().meBookMgr().checkCourseBookData() || !com.up366.common.NetworkUtilsUp.isConnected()) {
            lambda$initView$3(bottomSheetModel);
        } else {
            com.up366.mobile.common.logic.Auth.cur().course().fetchCourseList(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda7
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    this.f$0.lambda$initView$5(bottomSheetModel, response, (java.util.List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$5(final com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel, com.up366.common.http.Response response, java.util.List list) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$4(bottomSheetModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4(final com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel) throws java.lang.Exception {
        this.books = com.up366.mobile.me.book.MyBookListUtils.buildMyBooks();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda16
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$3(bottomSheetModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showData, reason: merged with bridge method [inline-methods] */
    public void lambda$initView$3(com.up366.mobile.common.views.bottomsheet.BottomSheetModel<com.up366.mobile.course.mgr.CourseInfo> bottomSheetModel) {
        this.binding.meMyBookSelector.setText(bottomSheetModel.getContent());
        this.binding.meMyBookSelector.setTag(bottomSheetModel.getData());
        com.up366.mobile.course.mgr.CourseInfo courseInfo = (com.up366.mobile.course.mgr.CourseInfo) this.binding.meMyBookSelector.getTag();
        final com.up366.common.http.Response response = new com.up366.common.http.Response();
        response.setCode(0);
        com.up366.mobile.me.book.MeBookUtil.filterData(courseInfo.getCourseId(), this.books, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$showData$8(response, i, str, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showData$8(com.up366.common.http.Response response, int i, java.lang.String str, java.util.List list) {
        this.controller.onLoadWebData(response, com.up366.mobile.me.book.MeBookUtil.filterPadData(list));
    }

    private void setAppBarPercent(float f) {
        this.binding.meMyBookSelector.setAlpha(1.0f - f);
        this.binding.searchIcon.setTranslationX((this.binding.meMyBookSelector.getWidth() + com.up366.common.DpUtilsUp.dp2px(20.0f)) * f);
        this.binding.meMyBookSelector.setVisibility(f != 1.0f ? 0 : 4);
        if (this.books.size() == 0 || this.courseInfoList.size() == 1) {
            this.binding.meMyBookSelector.setWidth(0);
        }
        this.binding.meMyBookSelector.setEnabled(f == 0.0f);
        this.binding.meMyBookSelector.setClickable(f == 0.0f);
    }

    private void initController() {
        this.controller.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state5).setTipMessage("没有课本哦~").build()));
            }
        });
        this.controller.setLocalLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda8
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() {
                com.up366.mobile.common.logic.Auth.cur().meBookMgr().loadMyBooks();
            }
        });
        this.controller.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda9
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() {
                com.up366.mobile.common.logic.Auth.cur().meBookMgr().fetchMyBooks();
            }
        });
        this.controller.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda10
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                this.f$0.lambda$initController$12(list, list2);
            }
        });
        this.controller.setOnCompleteCallback(new com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda11
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback
            public final void onComplete() {
                this.f$0.lambda$initController$13();
            }
        });
        this.controller.setIsSameItem(new com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda12
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback
            public final boolean isSame(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.mobile.me.book.MeMyBookActivity.lambda$initController$14((com.up366.mobile.common.logic.model.MyBook) obj, (com.up366.mobile.common.logic.model.MyBook) obj2);
            }
        });
        this.controller.setAdapter(this.adapter);
        this.controller.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$12(java.util.List list, java.util.List list2) {
        list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_16DP));
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, (com.up366.mobile.common.logic.model.MyBook) it.next()));
        }
        if (list.size() > 10) {
            com.up366.common.http.Response response = new com.up366.common.http.Response();
            response.setCode(0);
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-6, new com.up366.mobile.common.views.RefreshUpView.Data(response, this.controller)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$13() {
        this.binding.pullRefreshLayout.complete();
    }

    static /* synthetic */ boolean lambda$initController$14(com.up366.mobile.common.logic.model.MyBook myBook, com.up366.mobile.common.logic.model.MyBook myBook2) {
        return myBook.getBookId().equals(myBook2.getBookId()) && myBook.getLastStudyTime() == myBook2.getLastStudyTime();
    }

    public static void openPage(android.content.Context context) {
        context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.me.book.MeMyBookActivity.class));
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(final com.up366.mobile.common.event.MyBookListEvent myBookListEvent) {
        if (myBookListEvent == null) {
            com.up366.common.log.Logger.error("onMessageEvent error event is null ");
            finish();
            return;
        }
        if (myBookListEvent.resp == null || !myBookListEvent.resp.isError()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            this.courseInfoList = arrayList;
            arrayList.add(this.courseInfo);
            if (myBookListEvent.courseInfoS != null) {
                this.courseInfoList.addAll(myBookListEvent.courseInfoS);
            }
            if (myBookListEvent.books == null) {
                this.books = new java.util.ArrayList();
            } else {
                this.books = myBookListEvent.books;
            }
        }
        this.binding.meMyBookSelector.setVisibility((this.books.size() == 0 || this.courseInfoList.size() == 1) ? 4 : 0);
        com.up366.mobile.course.mgr.CourseInfo courseInfo = (com.up366.mobile.course.mgr.CourseInfo) this.binding.meMyBookSelector.getTag();
        if (myBookListEvent.resp != null) {
            com.up366.mobile.me.book.MeBookUtil.filterData(courseInfo.getCourseId(), this.books, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda14
                @Override // com.up366.common.callback.ICallbackCodeInfoObj
                public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                    this.f$0.lambda$onMessageEvent$15(myBookListEvent, i, str, (java.util.List) obj);
                }
            });
        } else {
            com.up366.mobile.me.book.MeBookUtil.filterData(courseInfo.getCourseId(), this.books, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.me.book.MeMyBookActivity$$ExternalSyntheticLambda15
                @Override // com.up366.common.callback.ICallbackCodeInfoObj
                public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                    this.f$0.lambda$onMessageEvent$16(i, str, (java.util.List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$15(com.up366.mobile.common.event.MyBookListEvent myBookListEvent, int i, java.lang.String str, java.util.List list) {
        this.controller.onLoadWebData(myBookListEvent.resp, com.up366.mobile.me.book.MeBookUtil.filterPadData(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$16(int i, java.lang.String str, java.util.List list) {
        this.controller.onLoadLocalData(com.up366.mobile.me.book.MeBookUtil.filterPadData(list));
    }
}
