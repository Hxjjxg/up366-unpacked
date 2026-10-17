package com.up366.mobile.book.studyviews;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyV4View extends android.widget.FrameLayout {
    private com.up366.mobile.book.studyviews.model.V4ExercisePagerAdapter adapter;
    public com.up366.mobile.databinding.BookStudyV4FragmentLayoutBinding b;
    private com.up366.mobile.book.model.BookInfoStudy book;
    private com.up366.mobile.book.model.TreeBookChapter bookChapterInfo;
    private com.up366.mobile.book.StudyActivity context;
    private com.up366.mobile.book.helper.V4ChapterDataHelper dataHelper;
    private com.up366.mobile.book.model.CatalogChapter info;
    private int pageNo;

    public boolean onBackPress() {
        return false;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public StudyV4View(android.content.Context context) {
        this(context, null);
    }

    public StudyV4View(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StudyV4View(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = (com.up366.mobile.book.StudyActivity) context;
        this.dataHelper = new com.up366.mobile.book.helper.V4ChapterDataHelper();
        com.up366.mobile.book.model.TreeBookChapter treeBookChapter = this.context.bookChapterInfo;
        this.bookChapterInfo = treeBookChapter;
        this.book = treeBookChapter.getBook();
        this.b = (com.up366.mobile.databinding.BookStudyV4FragmentLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.book_study_v4_fragment_layout, this, true);
        initView();
        this.info = this.context.bookChapterInfo.getChapter(this.context.cfg.chapterId);
        this.pageNo = this.context.cfg.pageNo;
        this.book = this.context.bookChapterInfo.getBook();
        refresh();
    }

    private void initView() {
        this.context.titleBar.setVisibility(8);
        this.context.showLoadingTitleBar(true);
        java.lang.String name = this.context.bookChapterInfo.getPages().get(this.pageNo).obj.getName();
        this.b.titleBar.setTitle(name);
        this.context.setTitle(name);
        this.adapter = new com.up366.mobile.book.studyviews.model.V4ExercisePagerAdapter(this.context, this.dataHelper, this);
        this.b.viewPager.setAdapter(this.adapter);
        this.b.viewPager.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener() { // from class: com.up366.mobile.book.studyviews.StudyV4View.1
            public void onPageSelected(int i) {
                com.up366.common.log.Logger.debug("onPageChangeListener - " + i);
                com.up366.mobile.book.studyviews.view.V4ExerciseView exerciseView = com.up366.mobile.book.studyviews.StudyV4View.this.adapter.getExerciseView(i);
                if (exerciseView != null) {
                    exerciseView.webView.callJSMethod("onPageExchange()");
                }
                com.up366.mobile.book.studyviews.StudyV4View.this.pageNo = i;
                com.up366.mobile.book.model.CatalogPage catalogPage = com.up366.mobile.book.studyviews.StudyV4View.this.bookChapterInfo.getPages().get(com.up366.mobile.book.studyviews.StudyV4View.this.pageNo);
                com.up366.mobile.book.studyviews.StudyV4View.this.info = (com.up366.mobile.book.model.CatalogChapter) catalogPage.getChapterPPage();
                com.up366.mobile.book.studyviews.StudyV4View.this.context.cfg.pageNo = i;
                com.up366.mobile.book.studyviews.StudyV4View.this.context.cfg.chapterId = com.up366.mobile.book.studyviews.StudyV4View.this.info.obj.getId();
                com.up366.mobile.book.studyviews.StudyV4View.this.context.cfg.pageId = catalogPage.obj.getId();
                com.up366.mobile.book.studyviews.StudyV4View.this.context.detectCurrentState(true);
                com.up366.mobile.book.studyviews.StudyV4View.this.dataHelper.init(com.up366.mobile.book.studyviews.StudyV4View.this.book, com.up366.mobile.book.studyviews.StudyV4View.this.info);
                java.lang.String name2 = com.up366.mobile.book.studyviews.StudyV4View.this.bookChapterInfo.getPages().get(i).obj.getName();
                com.up366.mobile.book.studyviews.StudyV4View.this.b.titleBar.setTitle(name2);
                com.up366.mobile.book.studyviews.StudyV4View.this.context.setTitle(name2);
                com.up366.mobile.book.studyviews.StudyV4View.this.b.titleBar.showBack(true);
                com.up366.mobile.book.studyviews.StudyV4View.this.context.bookOpenStudyHelper.curOpen = catalogPage.getContentPPage().getObj();
                if (com.up366.mobile.book.studyviews.StudyV4View.this.adapter.getExerciseView(i) != null) {
                    com.up366.mobile.book.studyviews.StudyV4View.this.adapter.getExerciseView(i).onEnterPage();
                }
                com.up366.mobile.common.logic.Auth.cur().bookProgress().set(com.up366.mobile.book.studyviews.StudyV4View.this.bookChapterInfo.getBook(), com.up366.mobile.book.studyviews.StudyV4View.this.bookChapterInfo.getPages().get(com.up366.mobile.book.studyviews.StudyV4View.this.pageNo));
            }
        });
        refresh();
    }

    private void refresh() {
        if (this.context == null || this.info == null) {
            return;
        }
        com.up366.mobile.common.logic.Auth.cur().bookProgress().set(this.bookChapterInfo.getBook(), this.bookChapterInfo.getPages().get(this.pageNo));
        java.lang.String name = this.bookChapterInfo.getPages().get(this.pageNo).obj.getName();
        this.b.titleBar.setTitle(name);
        this.context.setTitle(name);
        this.dataHelper.init(this.book, this.info);
        this.dataHelper.curPosition = this.pageNo;
        this.b.viewPager.setCurrentItem(this.pageNo, false);
        com.up366.mobile.book.studyviews.view.V4ExerciseView exerciseView = this.adapter.getExerciseView(this.pageNo);
        if (exerciseView != null) {
            exerciseView.refresh();
        }
        this.adapter.notifyDataSetChanged();
    }

    public void onPageDestroy() {
        com.up366.mobile.common.logic.Auth.cur().bookProgress().setCurrentPageId(null);
        this.adapter.destroy();
    }

    @Override // android.view.View
    public android.view.ViewGroup.LayoutParams getLayoutParams() {
        android.view.ViewGroup.LayoutParams layoutParams = super.getLayoutParams();
        return layoutParams == null ? new android.view.ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    public void refreshData() {
        refresh();
    }
}
