package com.up366.mobile.book.studyviews;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ChapterListView extends android.widget.FrameLayout {
    private com.up366.mobile.book.studyviews.ChapterAdapter adapter;
    public com.up366.mobile.databinding.BookCatalogFragmentLayoutBinding b;
    private com.up366.mobile.book.StudyActivity context;
    private com.up366.mobile.book.helper.CourseCountHelper courseCountHelper;

    public ChapterListView(android.content.Context context) {
        this(context, null);
    }

    public ChapterListView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChapterListView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = (com.up366.mobile.book.StudyActivity) context;
        this.b = (com.up366.mobile.databinding.BookCatalogFragmentLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.book_catalog_fragment_layout, this, true);
        initView();
    }

    private void initView() {
        com.up366.mobile.book.StudyActivity studyActivity = this.context;
        studyActivity.setTitle(studyActivity.book.getBookName());
        this.courseCountHelper = new com.up366.mobile.book.helper.CourseCountHelper(this.context.titleBar, this.context.book);
        this.b.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.book.studyviews.ChapterListView$$ExternalSyntheticLambda2
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.lambda$initView$0();
            }
        });
        this.adapter = new com.up366.mobile.book.studyviews.ChapterAdapter();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(0, this.context.bookChapterInfo));
        this.adapter.reset();
        this.adapter.lambda$setDatas$0(arrayList);
        this.b.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this.context));
        this.b.recycleView.setAdapter(this.adapter);
        refresh();
        com.up366.mobile.book.StudyActivity studyActivity2 = this.context;
        studyActivity2.buildBookPagePath(studyActivity2.book, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        com.up366.mobile.common.logic.Auth.cur().book().fetchChapterPlanAndFinishedTask(this.context.bookChapterInfo, !android.text.TextUtils.isEmpty(this.context.cfg.studyTaskId));
    }

    private void refresh() {
        com.up366.mobile.book.StudyActivity studyActivity = this.context;
        if (studyActivity == null) {
            return;
        }
        com.up366.mobile.book.model.TreeBookChapter treeBookChapter = studyActivity.bookChapterInfo;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(0, treeBookChapter));
        java.util.Iterator<com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage>> it = treeBookChapter.getChapterList().iterator();
        while (it.hasNext()) {
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, it.next()));
        }
        this.adapter.reset();
        this.adapter.lambda$setDatas$0(arrayList);
        this.context.showLoading(false);
        this.b.refreshLayout.complete();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.BookChapterRefresh bookChapterRefresh) {
        if (bookChapterRefresh.getResp() != null) {
            this.b.refreshLayout.complete();
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(final com.up366.mobile.common.event.TaskScoreUpdateEvent taskScoreUpdateEvent) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.ChapterListView$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$2(taskScoreUpdateEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$2(com.up366.mobile.common.event.TaskScoreUpdateEvent taskScoreUpdateEvent) throws java.lang.Exception {
        com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo = this.context.bookChapterInfo.getTaskMap().get(taskScoreUpdateEvent.getTaskId());
        if (bookTaskFinishedInfo == null) {
            bookTaskFinishedInfo = (com.up366.mobile.book.model.BookTaskFinishedInfo) com.up366.mobile.common.logic.Auth.cur().db().getBookTaskFinishedInfoDao().queryBuilder().where(com.up366.greendao.BookTaskFinishedInfoDao.Properties.TaskId.eq(taskScoreUpdateEvent.getTaskId()), new org.greenrobot.greendao.query.WhereCondition[0]).unique();
            this.context.bookChapterInfo.getTaskMap().put(taskScoreUpdateEvent.getTaskId(), bookTaskFinishedInfo);
        }
        if (bookTaskFinishedInfo.getAddDate() == 0) {
            bookTaskFinishedInfo.setAddDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
            bookTaskFinishedInfo.setChapterId(taskScoreUpdateEvent.getChapterId());
        }
        bookTaskFinishedInfo.setScore(taskScoreUpdateEvent.getScore());
        bookTaskFinishedInfo.setStudyDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        bookTaskFinishedInfo.setPercent(taskScoreUpdateEvent.getPercent());
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.ChapterListView$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$1() throws java.lang.Exception {
        this.adapter.notifyDataSetChanged();
    }

    @Override // android.view.View
    public android.view.ViewGroup.LayoutParams getLayoutParams() {
        android.view.ViewGroup.LayoutParams layoutParams = super.getLayoutParams();
        return layoutParams == null ? new android.view.ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDetachedFromWindow();
    }

    public void refreshData() {
        refresh();
    }
}
