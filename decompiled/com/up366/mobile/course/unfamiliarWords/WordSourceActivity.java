package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WordSourceActivity extends com.up366.mobile.common.base.BaseActivity {
    public static final java.lang.String KEY_WORD_INFO = "key_word_info";
    public static final java.lang.String USED_KILLED_WORD = "used_killed_word";
    private com.up366.mobile.databinding.ActivityWordSourceBinding b;
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo> controller = new com.up366.mobile.common.base.USV5ListViewDataController<>(this);
    private int downY;
    private boolean isHeaderItemAdded;
    private boolean killedWordSource;
    private com.up366.mobile.course.unfamiliarWords.WordSourceAdapter mAdapter;
    private com.up366.mobile.book.helper.CommonAudioHelper mAudioHelper;
    private androidx.recyclerview.widget.LinearLayoutManager mLayoutManager;
    private android.util.DisplayMetrics mOutMetrics;
    private com.up366.mobile.course.wrongnote.modle.WordNoteInfo mWordNoteInfo;
    private int upY;

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
        this.b = (com.up366.mobile.databinding.ActivityWordSourceBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_word_source);
        initIntentData();
        initView();
        initController();
        this.b.refreshLayout.doRefresh();
    }

    private void initIntentData() {
        this.killedWordSource = getIntent().getBooleanExtra(USED_KILLED_WORD, false);
        this.mWordNoteInfo = (com.up366.mobile.course.wrongnote.modle.WordNoteInfo) getIntent().getSerializableExtra(KEY_WORD_INFO);
        this.mAudioHelper = new com.up366.mobile.book.helper.CommonAudioHelper(this);
    }

    private void initController() {
        this.controller.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceActivity$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                this.f$0.lambda$initController$0(list);
            }
        });
        this.controller.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceActivity$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                this.f$0.lambda$initController$1(list, list2);
            }
        });
        this.controller.setErrorViewClickAction(new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceActivity$$ExternalSyntheticLambda3
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                this.f$0.lambda$initController$2(i);
            }
        });
        this.controller.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceActivity$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$initController$3();
            }
        });
        this.controller.setOnCompleteCallback(new com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceActivity$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback
            public final void onComplete() {
                this.f$0.lambda$initController$4();
            }
        });
        this.controller.setAdapter(this.mAdapter);
        this.controller.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$0(java.util.List list) {
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state5).setTipMessage(getString(com.up366.mobile.R.string.no_word_source_msg)).build()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$1(java.util.List list, java.util.List list2) {
        if (!this.isHeaderItemAdded && this.mWordNoteInfo != null) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(0, this.mWordNoteInfo, this.mAudioHelper));
            this.isHeaderItemAdded = true;
        }
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, (com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo) it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$2(int i) {
        this.b.refreshLayout.doRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$3() throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWordSourceList(this.mWordNoteInfo.getBookId(), this.mWordNoteInfo.getWordId(), this.killedWordSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$4() {
        this.b.refreshLayout.complete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        this.b.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceActivity$$ExternalSyntheticLambda0
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.refreshFromWeb();
            }
        });
        this.mAdapter = new com.up366.mobile.course.unfamiliarWords.WordSourceAdapter();
        androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = new androidx.recyclerview.widget.LinearLayoutManager(this);
        this.mLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.b.recycleView.setLayoutManager(this.mLayoutManager);
        this.b.recycleView.setWillNotDraw(false);
        android.view.WindowManager windowManager = getWindowManager();
        this.mOutMetrics = new android.util.DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(this.mOutMetrics);
        this.b.recycleView.setBackground(new android.graphics.drawable.Drawable() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceActivity.1
            @Override // android.graphics.drawable.Drawable
            public int getOpacity() {
                return -3;
            }

            @Override // android.graphics.drawable.Drawable
            public void setAlpha(int i) {
            }

            @Override // android.graphics.drawable.Drawable
            public void setColorFilter(android.graphics.ColorFilter colorFilter) {
            }

            @Override // android.graphics.drawable.Drawable
            public void draw(android.graphics.Canvas canvas) {
                android.graphics.Paint paint = new android.graphics.Paint(1);
                paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
                paint.setStrokeWidth(com.up366.common.DpUtilsUp.dp2px(2.0f));
                paint.setColor(androidx.core.content.ContextCompat.getColor(com.up366.mobile.course.unfamiliarWords.WordSourceActivity.this, com.up366.mobile.R.color.c7));
                paint.setPathEffect(new android.graphics.DashPathEffect(new float[]{com.up366.common.DpUtilsUp.dp2px(7.0f), com.up366.common.DpUtilsUp.dp2px(7.0f)}, 0.0f));
                canvas.drawLine(com.up366.common.DpUtilsUp.dp2px(24.0f), com.up366.mobile.course.unfamiliarWords.WordSourceActivity.this.upY, com.up366.common.DpUtilsUp.dp2px(24.0f), com.up366.mobile.course.unfamiliarWords.WordSourceActivity.this.downY, paint);
            }
        });
        this.b.recycleView.setAdapter(this.mAdapter);
        this.b.recycleView.addOnScrollListener(new androidx.recyclerview.widget.RecyclerView.OnScrollListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceActivity.2
            public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                com.up366.mobile.course.unfamiliarWords.WordSourceActivity wordSourceActivity = com.up366.mobile.course.unfamiliarWords.WordSourceActivity.this;
                wordSourceActivity.refreshTimeline(recyclerView, wordSourceActivity.mLayoutManager, com.up366.mobile.course.unfamiliarWords.WordSourceActivity.this.mOutMetrics);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshTimeline(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager, android.util.DisplayMetrics displayMetrics) {
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition == 0) {
            android.view.View childAt = recyclerView.getChildAt(1);
            this.upY = childAt == null ? 0 : childAt.getTop() + com.up366.common.DpUtilsUp.dp2px(20.0f) + com.up366.common.DpUtilsUp.sp2px(7.0f);
        } else if (iFindFirstVisibleItemPosition == 1) {
            android.view.View childAt2 = recyclerView.getChildAt(0);
            this.upY = childAt2 == null ? 0 : childAt2.getTop() + com.up366.common.DpUtilsUp.dp2px(20.0f) + com.up366.common.DpUtilsUp.sp2px(7.0f);
        } else {
            this.upY = 0;
        }
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (recyclerView.getAdapter() != null && iFindLastVisibleItemPosition < recyclerView.getAdapter().getItemCount() - 1) {
            this.downY = displayMetrics.heightPixels;
        } else {
            android.view.View childAt3 = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
            this.downY = childAt3 != null ? childAt3.getTop() + com.up366.common.DpUtilsUp.dp2px(20.0f) + com.up366.common.DpUtilsUp.sp2px(7.0f) : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshFromWeb() {
        this.isHeaderItemAdded = false;
        this.controller.loadWebData();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WordNoteFromListRefresh wordNoteFromListRefresh) {
        this.controller.onLoadWebData(wordNoteFromListRefresh.getResp(), wordNoteFromListRefresh.getWordNoteFromInfos());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WordSourceItemDetailShownChangedEvent wordSourceItemDetailShownChangedEvent) {
        refreshTimeline(this.b.recycleView, this.mLayoutManager, this.mOutMetrics);
        this.b.recycleView.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WordNoteKillMissingWordEvent wordNoteKillMissingWordEvent) {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
        if (wordNoteKillMissingWordEvent.getResp().isError()) {
            if (com.up366.common.NetworkUtilsUp.isConnected()) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, wordNoteKillMissingWordEvent.getResp().getInfo());
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, getString(com.up366.mobile.R.string.no_network_try_later_again));
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, com.up366.mobile.R.string.delete_success);
        finish();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onPause() {
        super.onPause();
        this.mAudioHelper.pauseAll();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        this.controller.destroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
        this.mAudioHelper.release();
    }
}
