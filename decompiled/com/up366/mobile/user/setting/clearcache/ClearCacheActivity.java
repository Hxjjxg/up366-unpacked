package com.up366.mobile.user.setting.clearcache;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ClearCacheActivity extends com.up366.mobile.common.base.BaseActivity {
    private long catchSizeToClear;
    com.up366.mobile.user.setting.clearcache.ClearCacheAdapter mClearCacheAdapter;
    android.widget.TextView mConfirmBtn;
    androidx.recyclerview.widget.RecyclerView mRecyclerView;
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> controller = new com.up366.mobile.common.base.USV5ListViewDataController<>(this);
    private java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> cacheInfoHolderList = new java.util.ArrayList();

    static /* synthetic */ void lambda$clearCache$7(android.view.View view) {
    }

    static /* synthetic */ void lambda$initController$2(java.util.List list) {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_setting_download";
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.up366.mobile.R.layout.clear_cache_activity_layout);
        com.up366.common.EventBusUtilsUp.register(this);
        initView();
        initController();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        this.mConfirmBtn = (android.widget.TextView) findViewById(com.up366.mobile.R.id.clear_cache_confirm_btn);
        androidx.recyclerview.widget.RecyclerView recyclerViewFindViewById = findViewById(com.up366.mobile.R.id.clear_cache_recyclerview);
        this.mRecyclerView = recyclerViewFindViewById;
        recyclerViewFindViewById.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
        com.up366.mobile.user.setting.clearcache.ClearCacheAdapter clearCacheAdapter = new com.up366.mobile.user.setting.clearcache.ClearCacheAdapter();
        this.mClearCacheAdapter = clearCacheAdapter;
        this.mRecyclerView.setAdapter(clearCacheAdapter);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.mConfirmBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$0(view);
            }
        });
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheActivity$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(android.view.View view) {
        clearCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$1() throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, getString(com.up366.mobile.R.string.calculating_cache_size));
    }

    private void initController() {
        this.controller.setLoadingView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheActivity$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                com.up366.mobile.user.setting.clearcache.ClearCacheActivity.lambda$initController$2(list);
            }
        });
        this.controller.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheActivity$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                this.f$0.lambda$initController$3(list);
            }
        });
        this.controller.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheActivity$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                this.f$0.lambda$initController$4(list, list2);
            }
        });
        this.controller.setLocalLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheActivity$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() {
                this.f$0.fetchCacheInfoList();
            }
        });
        this.controller.setAdapter(this.mClearCacheAdapter);
        this.controller.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$3(java.util.List list) {
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state3).setTipMessage(getString(com.up366.mobile.R.string.no_download_content)).build()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$4(java.util.List list, java.util.List list2) {
        list2.addAll(list);
        this.mConfirmBtn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchCacheInfoList() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheActivity$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$fetchCacheInfoList$6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchCacheInfoList$6() throws java.lang.Exception {
        java.util.List<com.up366.mobile.user.setting.clearcache.CacheInfo> bookCaches = com.up366.mobile.common.logic.Auth.cur().getCacheMgr().getBookCaches();
        com.up366.mobile.user.setting.clearcache.CacheInfo homeWorkCache = com.up366.mobile.common.logic.Auth.cur().getCacheMgr().getHomeWorkCache();
        this.cacheInfoHolderList.clear();
        if (homeWorkCache.getCacheSize() > 0) {
            this.cacheInfoHolderList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(8, homeWorkCache));
            this.cacheInfoHolderList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_DIVIDER_LINE));
        }
        if (bookCaches.size() > 0) {
            for (com.up366.mobile.user.setting.clearcache.CacheInfo cacheInfo : bookCaches) {
                if (cacheInfo.getCacheType() == 6) {
                    this.cacheInfoHolderList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(10, cacheInfo));
                } else if (cacheInfo.getCacheType() == 7) {
                    this.cacheInfoHolderList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(9, cacheInfo));
                }
            }
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheActivity$$ExternalSyntheticLambda8
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$fetchCacheInfoList$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$fetchCacheInfoList$5() throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
        this.controller.onLoadLocalData(this.cacheInfoHolderList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void clearCache() {
        final java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> datas = this.mClearCacheAdapter.getDatas();
        com.up366.mobile.common.dialog.AppDialog.create(this).title(java.lang.String.format("确定要清理所选中的%s缓存？", com.up366.common.ByteUtilsUp.bytesToMKB(this.catchSizeToClear))).left(getString(com.up366.mobile.R.string.cancel), new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.user.setting.clearcache.ClearCacheActivity.lambda$clearCache$7(view);
            }
        }).right(getString(com.up366.mobile.R.string.confirm), new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$clearCache$9(datas, view);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$clearCache$9(java.util.List list, android.view.View view) {
        clearInBackground(list);
        this.catchSizeToClear = 0L;
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, getString(com.up366.mobile.R.string.clearing));
        com.up366.common.task.TaskUtils.postMainTaskDelay(1000L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheActivity$$ExternalSyntheticLambda9
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$clearCache$8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$clearCache$8() throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
        this.mConfirmBtn.setVisibility(8);
        this.mConfirmBtn.setText(getString(com.up366.mobile.R.string.clear_cache_confirm));
        this.mConfirmBtn.setTextColor(androidx.core.content.ContextCompat.getColor(this, com.up366.mobile.R.color.c8));
        this.mConfirmBtn.setEnabled(false);
        com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "清除成功");
        this.controller.reload();
    }

    private void clearInBackground(final java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheActivity$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.user.setting.clearcache.ClearCacheActivity.lambda$clearInBackground$10(list);
            }
        });
    }

    static /* synthetic */ void lambda$clearInBackground$10(java.util.List list) throws java.lang.Exception {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.up366.mobile.user.setting.clearcache.CacheInfo cacheInfo = (com.up366.mobile.user.setting.clearcache.CacheInfo) ((com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder) it.next()).o;
            if (cacheInfo != null && cacheInfo.isSelected()) {
                cacheInfo.getClean().run();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0167  */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMessageEvent(com.up366.mobile.user.setting.clearcache.CacheSelectEvent r10) {
        /*
            Method dump skipped, instruction units count: 447
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.user.setting.clearcache.ClearCacheActivity.onMessageEvent(com.up366.mobile.user.setting.clearcache.CacheSelectEvent):void");
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        this.controller.destroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }
}
