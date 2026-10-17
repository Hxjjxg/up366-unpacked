package com.up366.mobile.book.studyviews;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyV1View extends android.widget.FrameLayout {
    private com.up366.mobile.book.helper.V1AudioHelper audioHelper;
    public com.up366.mobile.databinding.BookStudyV1FragmentLayoutBinding b;
    private com.up366.mobile.book.helper.V1BigAudioHelper bigAudioHelper;
    private com.up366.mobile.book.studyviews.view.V1ChapterPlayView chapterView;
    private com.up366.mobile.book.StudyActivity context;
    private android.os.CountDownTimer countDownTimer;
    private com.up366.mobile.book.helper.V1ChapterDataHelper dataHelper;
    private com.up366.mobile.book.model.CatalogChapter info;
    private com.up366.mobile.book.helper.V1ListenerBookLogHelper logHelper;
    private com.up366.mobile.book.studyviews.view.V1ExerciseView subView;

    public StudyV1View(android.content.Context context) {
        this(context, null);
    }

    public StudyV1View(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v7, types: [com.up366.mobile.book.studyviews.StudyV1View$1] */
    public StudyV1View(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.up366.mobile.book.StudyActivity studyActivity = (com.up366.mobile.book.StudyActivity) context;
        this.context = studyActivity;
        studyActivity.titleBar.setVisibility(8);
        this.context.showLoadingTitleBar(true);
        this.context.setTitle(studyActivity.cfg.title);
        this.dataHelper = new com.up366.mobile.book.helper.V1ChapterDataHelper(this.context);
        this.bigAudioHelper = new com.up366.mobile.book.helper.V1BigAudioHelper();
        this.audioHelper = new com.up366.mobile.book.helper.V1AudioHelper();
        this.countDownTimer = new android.os.CountDownTimer(1000L, 100L) { // from class: com.up366.mobile.book.studyviews.StudyV1View.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                com.up366.mobile.book.studyviews.StudyV1View.this.bigAudioHelper.onTimeOut();
                com.up366.mobile.book.studyviews.StudyV1View.this.audioHelper.onTimeOut();
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                com.up366.mobile.book.studyviews.StudyV1View.this.countDownTimer.start();
            }
        }.start();
        this.b = (com.up366.mobile.databinding.BookStudyV1FragmentLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.book_study_v1_fragment_layout, this, true);
        initView();
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.context.cfg;
        this.info = this.context.bookChapterInfo.getChapter(openConfigInfo.chapterId);
        this.logHelper = new com.up366.mobile.book.helper.V1ListenerBookLogHelper(this.info.getNextPage(), this.context.book, openConfigInfo);
        new com.up366.mobile.book.helper.DataHelper().saveData(this.info.getNextPage().obj.getId(), "");
        refresh();
        com.up366.mobile.book.StudyActivity studyActivity2 = this.context;
        studyActivity2.buildBookPagePath(studyActivity2.book, this.info);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.countDownTimer.cancel();
        this.countDownTimer = null;
    }

    private void initView() {
        this.chapterView = new com.up366.mobile.book.studyviews.view.V1ChapterPlayView(this.context);
        this.subView = new com.up366.mobile.book.studyviews.view.V1ExerciseView(this.context);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(this.chapterView);
        arrayList.add(this.subView);
        this.b.viewpager.setAdapter(new com.up366.mobile.book.studyviews.model.V1PagerAdapter(arrayList));
        this.chapterView.setParams(this.dataHelper, this.bigAudioHelper);
        this.subView.setParams(this.dataHelper, this.audioHelper, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.studyviews.StudyV1View$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$0(view);
            }
        });
        this.b.viewpager.setCurrentItem(1);
        this.b.viewpager.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener() { // from class: com.up366.mobile.book.studyviews.StudyV1View.2
            public void onPageSelected(int i) {
                if (i == 0) {
                    com.up366.mobile.book.studyviews.StudyV1View.this.chapterView.onShow();
                    com.up366.mobile.book.studyviews.StudyV1View.this.audioHelper.pausePlay();
                }
                if (i == 1) {
                    com.up366.mobile.book.studyviews.StudyV1View.this.chapterView.onHide();
                }
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(android.view.View view) {
        this.b.viewpager.setCurrentItem(0);
    }

    public void refresh() {
        if (this.info == null || this.context == null) {
            return;
        }
        com.up366.mobile.common.logic.Auth.cur().bookProgress().set(this.context.bookChapterInfo.getBook(), this.info.getNextPage());
        this.dataHelper.init(this.context.bookChapterInfo.getBook(), this.info);
        this.b.viewpager.setCurrentItem(1);
        this.chapterView.refresh();
        this.subView.setLogHelper(this.logHelper);
        this.subView.refresh();
        this.context.showLoading(false);
    }

    public void onPause() {
        this.audioHelper.pausePlay();
        com.up366.mobile.book.helper.V1ListenerBookLogHelper v1ListenerBookLogHelper = this.logHelper;
        if (v1ListenerBookLogHelper != null) {
            v1ListenerBookLogHelper.onPagePause();
            this.logHelper.saveLogOnPause();
        }
    }

    public void onResume() {
        com.up366.mobile.book.helper.V1ListenerBookLogHelper v1ListenerBookLogHelper = this.logHelper;
        if (v1ListenerBookLogHelper != null) {
            v1ListenerBookLogHelper.onPageResume();
        }
    }

    public void onHiddenChanged(boolean z) {
        if (z) {
            this.chapterView.onHide();
        }
    }

    public boolean onBackPress() {
        if (this.b.viewpager.getCurrentItem() != 0) {
            return false;
        }
        this.b.viewpager.setCurrentItem(1);
        return true;
    }

    public void onPageDestroy() {
        com.up366.mobile.common.logic.Auth.cur().bookProgress().setCurrentPageId(null);
        this.audioHelper.stopPlay();
        this.logHelper.saveLogOnPause();
        this.subView.destroy();
    }

    @Override // android.view.View
    public android.view.ViewGroup.LayoutParams getLayoutParams() {
        android.view.ViewGroup.LayoutParams layoutParams = super.getLayoutParams();
        return layoutParams == null ? new android.view.ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }
}
