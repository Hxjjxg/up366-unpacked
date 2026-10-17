package com.up366.mobile.book.studyviews;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyV6View extends android.widget.FrameLayout {
    private com.up366.mobile.book.studyviews.model.V6ExercisePagerAdapter adapter;
    private com.up366.mobile.book.model.TreeBookChapter bookChapterInfo;
    public com.up366.mobile.book.model.OpenConfigInfo cfg;
    public com.up366.mobile.book.StudyActivity context;
    public com.up366.mobile.book.helper.V6ChapterDataHelper dataHelper;
    private com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView;
    private com.up366.mobile.book.model.CatalogChapter info;
    private boolean isInSubPage;
    private final androidx.viewpager.widget.ViewPager.OnPageChangeListener onPageChangeListener;
    private com.up366.mobile.book.studyviews.model.V6AnswerViewPager.OnSlideLeftInterface onSlideLeft;
    public com.up366.mobile.book.helper.V6StudyOpenNewPageHelper openNewPageHelper;
    private int pageNo;
    private int[] range;
    public com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    private com.up366.mobile.book.studyviews.model.V6AnswerViewPager viewPager;
    private int visibility;

    public StudyV6View(android.content.Context context) {
        this(context, null);
    }

    public StudyV6View(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StudyV6View(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isInSubPage = false;
        this.onSlideLeft = new com.up366.mobile.book.studyviews.model.V6AnswerViewPager.OnSlideLeftInterface() { // from class: com.up366.mobile.book.studyviews.StudyV6View.1
            @Override // com.up366.mobile.book.studyviews.model.V6AnswerViewPager.OnSlideLeftInterface
            public boolean hasRegisterEvent(java.lang.String str) {
                com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView = com.up366.mobile.book.studyviews.StudyV6View.this.adapter.getExerciseView(com.up366.mobile.book.studyviews.StudyV6View.this.pageNo);
                return exerciseView != null && exerciseView.registerHelper.hasRegister(str);
            }

            @Override // com.up366.mobile.book.studyviews.model.V6AnswerViewPager.OnSlideLeftInterface
            public void onSlideLeft() {
                com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView = com.up366.mobile.book.studyviews.StudyV6View.this.adapter.getExerciseView(com.up366.mobile.book.studyviews.StudyV6View.this.pageNo);
                if (exerciseView != null) {
                    exerciseView.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_LEFT_SLIDER);
                    com.up366.common.log.Logger.info("js 已注册左滑事件");
                }
            }
        };
        this.onPageChangeListener = new androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener() { // from class: com.up366.mobile.book.studyviews.StudyV6View.2
            public void onPageSelected(int i2) {
                com.up366.common.log.Logger.debug("onPageChangeListener - " + i2);
                com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView = com.up366.mobile.book.studyviews.StudyV6View.this.adapter.getExerciseView(com.up366.mobile.book.studyviews.StudyV6View.this.pageNo);
                if (exerciseView != null && com.up366.mobile.book.studyviews.StudyV6View.this.pageNo != i2) {
                    exerciseView.onPageExchange();
                }
                com.up366.mobile.book.studyviews.StudyV6View.this.pageNo = i2;
                com.up366.mobile.book.studyviews.StudyV6View.this.dataHelper.curPosition = i2;
                com.up366.mobile.book.studyviews.StudyV6View.this.checkAndDisableSlide(i2);
                com.up366.mobile.book.model.BookInfoStudy book = com.up366.mobile.book.studyviews.StudyV6View.this.bookChapterInfo.getBook();
                com.up366.mobile.book.model.CatalogPage catalogPage = com.up366.mobile.book.studyviews.StudyV6View.this.bookChapterInfo.getPages().get(com.up366.mobile.book.studyviews.StudyV6View.this.pageNo);
                com.up366.mobile.book.studyviews.StudyV6View.this.info = (com.up366.mobile.book.model.CatalogChapter) catalogPage.getChapterPPage();
                com.up366.mobile.book.studyviews.StudyV6View.this.dataHelper.init(book, com.up366.mobile.book.studyviews.StudyV6View.this.info, com.up366.mobile.book.studyviews.StudyV6View.this.range);
                if (com.up366.mobile.book.studyviews.StudyV6View.this.cfg.pageNo != i2) {
                    com.up366.mobile.book.studyviews.StudyV6View.this.cfg.pageNo = i2;
                    com.up366.mobile.book.studyviews.StudyV6View.this.cfg.chapterId = com.up366.mobile.book.studyviews.StudyV6View.this.info.obj.getId();
                    com.up366.mobile.book.studyviews.StudyV6View.this.cfg.pageId = catalogPage.obj.getId();
                    com.up366.mobile.book.studyviews.StudyV6View.this.context.getIntent().putExtra("cfg", com.up366.mobile.book.studyviews.StudyV6View.this.cfg);
                    com.up366.mobile.book.studyviews.StudyV6View.this.context.detectCurrentState(true);
                }
                com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView2 = com.up366.mobile.book.studyviews.StudyV6View.this.adapter.getExerciseView(i2);
                if (exerciseView2 != null) {
                    if ("about:blank".equals(exerciseView2.webView.getUrl())) {
                        exerciseView2.refresh();
                    } else {
                        exerciseView2.onEnterPage();
                    }
                }
                com.up366.mobile.book.studyviews.StudyV6View.this.context.titleBar.setTitle(com.up366.mobile.book.studyviews.StudyV6View.this.bookChapterInfo.getPages().get(i2).obj.getName());
                com.up366.mobile.book.studyviews.StudyV6View.this.context.titleBar.showBack(true);
                com.up366.mobile.common.logic.Auth.cur().bookProgress().set(com.up366.mobile.book.studyviews.StudyV6View.this.bookChapterInfo.getBook(), catalogPage);
            }
        };
        com.up366.mobile.book.StudyActivity studyActivity = (com.up366.mobile.book.StudyActivity) context;
        this.context = studyActivity;
        this.bookChapterInfo = studyActivity.bookChapterInfo;
        this.dataHelper = new com.up366.mobile.book.helper.V6ChapterDataHelper();
        this.speechRecordHelper = new com.up366.mobile.book.helper.recorder.SpeechRecordHelper(context);
        this.openNewPageHelper = new com.up366.mobile.book.helper.V6StudyOpenNewPageHelper(this.context, this);
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = studyActivity.cfg;
        this.cfg = openConfigInfo;
        java.lang.String str = openConfigInfo.chapterId;
        this.info = this.context.bookChapterInfo.getChapter(str);
        this.pageNo = this.cfg.pageNo;
        int[] iArr = this.cfg.range;
        this.range = iArr;
        if (iArr == null) {
            this.range = this.bookChapterInfo.getPageRange(str);
        }
        this.isInSubPage = !com.up366.common.StringUtils.isEmptyOrNull(this.cfg.openUrl);
        com.up366.mobile.common.logic.Auth.cur().bookProgress().set(this.bookChapterInfo.getBook(), this.bookChapterInfo.getPages().get(this.pageNo));
        this.dataHelper.init(this.bookChapterInfo.getBook(), this.info, this.range);
        this.dataHelper.curPosition = this.pageNo;
        com.up366.mobile.common.utils.ViewUtil.disable(this.context.titleBar.binding.rightText);
        com.up366.common.task.TaskUtils.postMainTaskDelay(1000L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV6View$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$new$0();
            }
        });
        if (this.isInSubPage) {
            initSubPageView(context, this.cfg);
        } else {
            initMainPageView(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() throws java.lang.Exception {
        com.up366.mobile.common.utils.ViewUtil.enable(this.context.titleBar.binding.rightText);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.View, com.up366.mobile.book.studyviews.model.V6AnswerViewPager] */
    private void initMainPageView(android.content.Context context) {
        java.util.List<com.up366.mobile.book.model.CatalogPage> pages = this.context.bookChapterInfo.getPages();
        if (pages.size() > this.pageNo) {
            this.context.titleBar.setTitle(pages.get(this.pageNo).obj.getName());
        } else {
            this.context.titleBar.setTitle("");
        }
        ?? v6AnswerViewPager = new com.up366.mobile.book.studyviews.model.V6AnswerViewPager(context);
        this.viewPager = v6AnswerViewPager;
        addView(v6AnswerViewPager);
        this.viewPager.setOnSlideLeft(this.onSlideLeft);
        com.up366.mobile.book.studyviews.model.V6ExercisePagerAdapter v6ExercisePagerAdapter = new com.up366.mobile.book.studyviews.model.V6ExercisePagerAdapter(this.context, this.dataHelper, this, this.speechRecordHelper);
        this.adapter = v6ExercisePagerAdapter;
        this.viewPager.setAdapter(v6ExercisePagerAdapter);
        this.viewPager.addOnPageChangeListener(this.onPageChangeListener);
        this.adapter.notifyDataSetChanged();
        this.viewPager.setCurrentItem(this.pageNo, false);
        checkAndDisableSlide(this.pageNo);
    }

    private void initSubPageView(android.content.Context context, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        this.context.titleBar.setTitle(openConfigInfo.title);
        com.up366.mobile.book.studyviews.view.V6ExerciseView v6ExerciseView = new com.up366.mobile.book.studyviews.view.V6ExerciseView(context);
        this.exerciseView = v6ExerciseView;
        addView(v6ExerciseView);
        this.exerciseView.setParams(this.dataHelper, this.bookChapterInfo.getPages().get(this.pageNo), this.pageNo, this, this.speechRecordHelper, openConfigInfo.openUrl);
        this.exerciseView.refresh();
    }

    public void onPause() {
        this.speechRecordHelper.forceStopAll();
        if (this.isInSubPage) {
            this.exerciseView.onPause();
            return;
        }
        com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView = this.adapter.getExerciseView(this.pageNo);
        if (exerciseView != null) {
            exerciseView.onPause();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        this.visibility = i;
    }

    public int getRealVisibility() {
        return this.visibility;
    }

    public void onResume() {
        if (this.isInSubPage) {
            this.exerciseView.onResume();
            return;
        }
        com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView = this.adapter.getExerciseView(this.pageNo);
        if (exerciseView != null) {
            exerciseView.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndDisableSlide(int i) {
        if (this.range[0] > i) {
            reportPageRangeError(i);
            this.viewPager.setCurrentItem(this.range[0]);
            this.viewPager.disableRightSlide(true);
        }
        if (this.range[1] < i) {
            reportPageRangeError(i);
            this.viewPager.setCurrentItem(this.range[1]);
            this.viewPager.disableLeftSlide(true);
        }
        if (this.range[0] == i) {
            this.viewPager.disableRightSlide(true);
        } else {
            this.viewPager.disableRightSlide(false);
        }
        if (this.range[1] == i) {
            this.viewPager.disableLeftSlide(true);
        } else {
            this.viewPager.disableLeftSlide(false);
        }
    }

    private void reportPageRangeError(int i) {
        try {
            com.up366.mobile.common.onlinelog.OpLog.report("StudyV6View-outOfRange", "pos:" + i + " range:" + java.util.Arrays.toString(this.range) + " book:" + this.bookChapterInfo.getBook().toString() + " cfg:" + this.cfg.toString());
        } catch (java.lang.Exception e) {
            com.up366.mobile.common.onlinelog.OpLog.report("StudyV6View-outOfRange-Error", " range:" + java.util.Arrays.toString(this.range), e);
        }
    }

    public com.up366.mobile.book.studyviews.view.V6ExerciseView getCurrentExerciseView() {
        if (this.isInSubPage) {
            return this.exerciseView;
        }
        return this.adapter.getExerciseView(this.pageNo);
    }

    public boolean onBackPress() {
        if (this.isInSubPage) {
            if (this.exerciseView.isVideoFullScreen()) {
                this.exerciseView.toggleVideoFullScreen();
                return true;
            }
            if (this.exerciseView.registerHelper.hasRegister(com.up366.mobile.book.helper.V6RegisterHelper.EVT_BACKBTN_CLICK)) {
                this.exerciseView.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_BACKBTN_CLICK);
                return true;
            }
            this.exerciseView.audioHelper.pauseAll();
        } else {
            com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView = this.adapter.getExerciseView(this.pageNo);
            if (exerciseView != null && exerciseView.isVideoFullScreen()) {
                exerciseView.toggleVideoFullScreen();
                return true;
            }
            if (exerciseView != null && exerciseView.registerHelper.hasRegister(com.up366.mobile.book.helper.V6RegisterHelper.EVT_BACKBTN_CLICK)) {
                exerciseView.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_BACKBTN_CLICK);
                return true;
            }
            if (exerciseView != null && exerciseView.audioHelper != null) {
                exerciseView.audioHelper.pauseAll();
            }
        }
        this.speechRecordHelper.forceStopAll();
        return false;
    }

    public void onPageDestroy() {
        if (this.isInSubPage) {
            this.exerciseView.onPageExchange();
            this.speechRecordHelper.forceStopAll();
            com.up366.common.task.TaskUtils.postMainTaskDelay(50L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV6View$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onPageDestroy$1();
                }
            });
        } else {
            com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView = this.adapter.getExerciseView(this.pageNo);
            if (exerciseView != null) {
                exerciseView.onPageExchange();
            }
            com.up366.mobile.common.logic.Auth.cur().bookProgress().setCurrentPageId(null);
            this.speechRecordHelper.forceStopAll();
            com.up366.common.task.TaskUtils.postMainTaskDelay(50L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.StudyV6View$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onPageDestroy$2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPageDestroy$1() throws java.lang.Exception {
        this.exerciseView.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPageDestroy$2() throws java.lang.Exception {
        this.adapter.destroy();
    }

    public void gotoNextPage() {
        if (this.isInSubPage) {
            return;
        }
        this.viewPager.setCurrentItem(this.pageNo + 1, true);
    }

    public void gotoPrevPage() {
        if (this.isInSubPage) {
            return;
        }
        this.viewPager.setCurrentItem(this.pageNo - 1, true);
    }

    public void gotoTask(java.lang.String str, java.lang.String str2, int i) {
        com.up366.mobile.book.model.CatalogPage page;
        if (this.isInSubPage || (page = this.bookChapterInfo.getPage(str2)) == null) {
            return;
        }
        this.viewPager.setCurrentItem(page.getPageNo(), true);
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

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.JSGlobalEvent jSGlobalEvent) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(jSGlobalEvent.getMsg());
        com.up366.mobile.book.webview.StudyPageWebView studyWebView = getStudyWebView();
        if (studyWebView != null && "_EVT_HEADSET_STATUS_CHANGE_".equals(object.getString("type"))) {
            studyWebView.callJSMethod("onHeadsetStateChange({\"plugged\":%d})", java.lang.Integer.valueOf(this.context.headsetHelper.getHeadsetState() == 1 ? 1 : 0));
        }
        com.up366.mobile.book.helper.V6RegisterHelper registerHelper = getRegisterHelper();
        if (registerHelper != null) {
            registerHelper.callJsEvent("message", "(%s)", jSGlobalEvent.getMsg());
        }
    }

    private com.up366.mobile.book.webview.StudyPageWebView getStudyWebView() {
        if (this.isInSubPage) {
            return this.exerciseView.webView;
        }
        com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView = this.adapter.getExerciseView(this.pageNo);
        if (exerciseView != null) {
            return exerciseView.webView;
        }
        return null;
    }

    public void disableSlideDirection(int i, int i2) {
        if (this.isInSubPage) {
            return;
        }
        if (i == 0) {
            this.viewPager.disableLeftSlide(i2 == 1);
        } else {
            this.viewPager.disableRightSlide(i2 == 1);
        }
    }

    public void disableSlide(int i) {
        if (this.isInSubPage) {
            return;
        }
        this.viewPager.setScrollable(i == 0);
    }

    public java.lang.String getCurrentDir() {
        if (this.isInSubPage) {
            return this.exerciseView.webView.getCurrentDir();
        }
        com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView = this.adapter.getExerciseView(this.pageNo);
        if (exerciseView == null) {
            return null;
        }
        exerciseView.webView.getCurrentDir();
        return null;
    }

    public void refreshData() {
        if (this.isInSubPage) {
            this.exerciseView.refresh();
        }
        com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView = this.adapter.getExerciseView(this.pageNo);
        if (exerciseView != null) {
            exerciseView.refresh();
        }
    }

    public boolean checkPageChange() {
        if (this.cfg.pageNo == this.pageNo) {
            return false;
        }
        com.up366.common.log.Logger.warn("TAG - StudyV6View - checkPageChange - cfg.pageNo:" + this.cfg.pageNo + " page.getPageNo():" + this.pageNo + " cfg:" + this.cfg);
        com.up366.mobile.common.onlinelog.OpLog.report("checkPageChange", "StudyV6View cfg.pageNo:" + this.cfg.pageNo + " page.getPageNo():" + this.pageNo + " cfg:" + this.cfg);
        return true;
    }

    public void onTopResumedActivityChanged(boolean z) {
        if (this.isInSubPage) {
            if (this.exerciseView.registerHelper.hasRegister("onTopResumedActivityChanged")) {
                this.exerciseView.registerHelper.callJsEvent("onTopResumedActivityChanged", "(%s)", java.lang.Boolean.valueOf(z));
            }
        } else {
            com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView = this.adapter.getExerciseView(this.pageNo);
            if (exerciseView == null || !exerciseView.registerHelper.hasRegister("onTopResumedActivityChanged")) {
                return;
            }
            exerciseView.registerHelper.callJsEvent("onTopResumedActivityChanged", "(%s)", java.lang.Boolean.valueOf(z));
        }
    }

    private com.up366.mobile.book.helper.V6RegisterHelper getRegisterHelper() {
        if (this.isInSubPage) {
            return this.exerciseView.registerHelper;
        }
        com.up366.mobile.book.studyviews.view.V6ExerciseView exerciseView = this.adapter.getExerciseView(this.pageNo);
        if (exerciseView != null) {
            return exerciseView.registerHelper;
        }
        return null;
    }
}
