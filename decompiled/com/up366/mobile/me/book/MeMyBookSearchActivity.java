package com.up366.mobile.me.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeMyBookSearchActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.me.book.MeMyBookActivityAdapter adapter;
    private com.up366.mobile.databinding.MeMyBookSearchAcivityLayoutBinding binding;
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.logic.model.MyBook> controller = new com.up366.mobile.common.base.USV5ListViewDataController<>(this);
    private java.util.List<com.up366.mobile.common.logic.model.MyBook> books = new java.util.ArrayList();

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_book";
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (com.up366.mobile.databinding.MeMyBookSearchAcivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.me_my_book_search_acivity_layout);
        com.up366.common.EventBusUtilsUp.register(this);
        com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarLightMode(this);
        initView();
        initController();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
        com.up366.mobile.common.utils.ViewUtil.cleanSoftInput(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        this.adapter = new com.up366.mobile.me.book.MeMyBookActivityAdapter();
        this.binding.recycleView.setAdapter(this.adapter);
        com.up366.mobile.me.book.CustomLinearLayoutManager customLinearLayoutManager = new com.up366.mobile.me.book.CustomLinearLayoutManager(this);
        customLinearLayoutManager.setOrientation(1);
        this.binding.recycleView.setLayoutManager(customLinearLayoutManager);
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.me.book.MeMyBookSearchActivity$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$0();
            }
        });
        this.binding.searchText.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.me.book.MeMyBookSearchActivity$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$1(appEditTextView);
            }
        });
        this.binding.searchCancel.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.book.MeMyBookSearchActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() throws java.lang.Exception {
        this.binding.searchText.showSoftInput(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        this.controller.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(android.view.View view) {
        finish();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.up366.mobile.common.utils.ViewUtil.hideSoftInputOnTouchOutside(motionEvent, this.binding.searchText);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void initController() {
        this.controller.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.me.book.MeMyBookSearchActivity$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                this.f$0.lambda$initController$3(list);
            }
        });
        this.controller.setLocalLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.me.book.MeMyBookSearchActivity$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() {
                com.up366.mobile.common.logic.Auth.cur().meBookMgr().loadMyBooks();
            }
        });
        final com.up366.mobile.common.logic.model.AccountOrganInfo accountOrganInfo = new com.up366.mobile.common.logic.model.AccountOrganInfo();
        this.controller.setFilterData(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataFilterCallback() { // from class: com.up366.mobile.me.book.MeMyBookSearchActivity$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataFilterCallback
            public final boolean filter(java.lang.Object obj) {
                return this.f$0.lambda$initController$5((com.up366.mobile.common.logic.model.MyBook) obj);
            }
        });
        this.controller.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.me.book.MeMyBookSearchActivity$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                this.f$0.lambda$initController$7(accountOrganInfo, list, list2);
            }
        });
        this.controller.setOnCompleteCallback(new com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback() { // from class: com.up366.mobile.me.book.MeMyBookSearchActivity$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback
            public final void onComplete() {
                this.f$0.lambda$initController$8();
            }
        });
        this.controller.setIsSameItem(new com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback() { // from class: com.up366.mobile.me.book.MeMyBookSearchActivity$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback
            public final boolean isSame(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.mobile.me.book.MeMyBookSearchActivity.lambda$initController$9((com.up366.mobile.common.logic.model.MyBook) obj, (com.up366.mobile.common.logic.model.MyBook) obj2);
            }
        });
        this.controller.setAdapter(this.adapter);
        this.controller.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$3(java.util.List list) {
        com.up366.mobile.common.views.viewmodel.EmptyViewModel emptyViewModelBuild;
        if (this.binding.searchText.getText().length() > 0) {
            emptyViewModelBuild = new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state5).setTipMessage("没有与您搜索内容相关的课本哦！").build();
        } else {
            emptyViewModelBuild = new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(2131100561).build();
        }
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, emptyViewModelBuild));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initController$5(com.up366.mobile.common.logic.model.MyBook myBook) {
        java.lang.String trimText = this.binding.searchText.getTrimText();
        if (trimText.length() > 0) {
            return myBook.getBookName().contains(trimText);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$7(final com.up366.mobile.common.logic.model.AccountOrganInfo accountOrganInfo, java.util.List list, java.util.List list2) {
        final java.lang.String trimText = this.binding.searchText.getTrimText();
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.me.book.MeMyBookSearchActivity$$ExternalSyntheticLambda9
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                com.up366.mobile.common.logic.model.AccountOrganInfo accountOrganInfo2 = accountOrganInfo;
                java.lang.String str = trimText;
                return java.lang.Float.compare(accountOrganInfo2.countCosDistance(str, ((com.up366.mobile.common.logic.model.MyBook) obj2).getBookName()), accountOrganInfo2.countCosDistance(str, ((com.up366.mobile.common.logic.model.MyBook) obj).getBookName()));
            }
        });
        list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_16DP));
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, (com.up366.mobile.common.logic.model.MyBook) it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$8() {
        this.binding.pullRefreshLayout.complete();
    }

    static /* synthetic */ boolean lambda$initController$9(com.up366.mobile.common.logic.model.MyBook myBook, com.up366.mobile.common.logic.model.MyBook myBook2) {
        return myBook.getBookId().equals(myBook2.getBookId()) && myBook.getLastStudyTime() == myBook2.getLastStudyTime();
    }

    public static void openPage(android.content.Context context) {
        context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.me.book.MeMyBookSearchActivity.class));
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.MyBookListEvent myBookListEvent) {
        if (myBookListEvent == null) {
            com.up366.common.log.Logger.error("onMessageEvent error event is null ");
            finish();
            return;
        }
        if (myBookListEvent.resp == null || !myBookListEvent.resp.isError()) {
            if (myBookListEvent.books == null) {
                this.books = new java.util.ArrayList();
            } else {
                this.books = myBookListEvent.books;
            }
        }
        this.controller.onLoadLocalData(com.up366.mobile.me.book.MeBookUtil.filterPadData(this.books));
    }
}
