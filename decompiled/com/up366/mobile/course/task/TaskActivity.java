package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskActivity extends com.up366.mobile.common.base.BaseActivity {
    private static final java.lang.String INTENT_SHOW_TASK_BOOKID = "show_task_by_bookid";
    private static final java.lang.String INTENT_SHOW_TASK_STATUS = "show_task_status";
    private static final java.lang.String INTENT_show_TASK_COURSEID = "show_task_by_courseid";
    private static final int SHOW_CURRENT = 0;
    private static final int SHOW_HISTORY = 1;
    private com.up366.mobile.common.helper.AppBarRefreshLayoutHelper appBarHelper;
    private com.up366.mobile.course.task.TaskTeacherAskViewHelper askViewHelper;
    private com.up366.mobile.databinding.ActivityTaskBinding binding;
    private java.lang.String currentBookId;
    private com.up366.mobile.course.task.CurrentTaskListFragment currentTaskListFragment;
    private com.up366.mobile.course.task.HistoryTaskListFragment historyTaskListFragment;
    int locationX;
    int locationY;
    private int selectTab;
    private com.up366.mobile.course.task.TaskViewModel viewModel;
    private final java.lang.String beforeShowToastTime = "task-overdue-toast_time";
    private int currentCourseId = -1;
    private boolean refreshData = false;
    private android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    public java.lang.String searchText = "";
    private int currentPage = -1;

    public static void startTaskActivityShowHistory(android.content.Context context) {
        if (com.up366.mobile.common.logic.Auth.cur().config().isEnableH5TaskList()) {
            com.up366.mobile.course.task.JsSdk2023TaskActivity.start(context);
            return;
        }
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.course.task.TaskActivity.class);
        intent.putExtra(INTENT_SHOW_TASK_STATUS, 1);
        context.startActivity(intent);
    }

    public static void startTaskActivity(android.content.Context context) {
        if (com.up366.mobile.common.logic.Auth.cur().config().isEnableH5TaskList()) {
            com.up366.mobile.course.task.JsSdk2023TaskActivity.start(context);
            return;
        }
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.course.task.TaskActivity.class);
        intent.putExtra(INTENT_SHOW_TASK_STATUS, 0);
        context.startActivity(intent);
    }

    public static void startTaskActivityByBookId(android.content.Context context, int i, java.lang.String str) {
        if (com.up366.mobile.common.logic.Auth.cur().config().isEnableH5TaskList()) {
            com.up366.mobile.course.task.JsSdk2023TaskActivity.start(context);
            return;
        }
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.course.task.TaskActivity.class);
        intent.putExtra(INTENT_show_TASK_COURSEID, i);
        intent.putExtra(INTENT_SHOW_TASK_BOOKID, str);
        context.startActivity(intent);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.selectTab = getIntent().getIntExtra(INTENT_SHOW_TASK_STATUS, 0);
        this.currentBookId = getIntent().getStringExtra(INTENT_SHOW_TASK_BOOKID);
        this.currentCourseId = getIntent().getIntExtra(INTENT_show_TASK_COURSEID, -1);
        com.up366.common.log.Logger.info("TaskActivity intent selectTab=" + this.selectTab + "  currentBookId=" + this.currentBookId + "  currentCourseId=" + this.currentCourseId);
        com.up366.mobile.course.task.TaskViewModel taskViewModel = (com.up366.mobile.course.task.TaskViewModel) new androidx.lifecycle.ViewModelProvider(this).get(com.up366.mobile.course.task.TaskViewModel.class);
        this.viewModel = taskViewModel;
        taskViewModel.setCurrentCourseId(this.currentCourseId);
        this.viewModel.setCurrentBookId(this.currentBookId);
        if (com.up366.common.StringUtils.isEmptyOrNull(this.currentBookId) && !com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            com.up366.mobile.common.utils.SkipBitmapBackGroundUtil.loadBitmap(getWindow().getDecorView(), 0);
        }
        this.binding = (com.up366.mobile.databinding.ActivityTaskBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_task);
        initView();
        initTab(bundle != null);
        initObserver();
        if (com.up366.common.StringUtils.isEmptyOrNull(this.currentBookId) && !com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            startActivityOpenAnim();
        }
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        if (com.up366.mobile.common.utils.ViewDataInvalidRecord.$("TaskCompletedEvent").isInvalid() || this.refreshData) {
            this.viewModel.refreshTaskData(false);
            this.refreshData = false;
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    private void startActivityOpenAnim() {
        this.binding.rootLayout.setVisibility(4);
        this.binding.rootLayout.post(new java.lang.Runnable() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startActivityOpenAnim$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startActivityOpenAnim$0() {
        int[] iArr = (int[]) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync("circular-layout");
        this.binding.rootLayout.setVisibility(0);
        if (iArr != null) {
            this.binding.rootLayout.setLayerType(2, null);
            if (this.binding.rootLayout.isAttachedToWindow()) {
                android.animation.Animator animatorCreateCircularReveal = android.view.ViewAnimationUtils.createCircularReveal(this.binding.rootLayout, iArr[0], iArr[1], 0.0f, this.binding.rootLayout.getHeight());
                animatorCreateCircularReveal.setDuration(800L);
                animatorCreateCircularReveal.addListener(new com.up366.mobile.course.task.TaskActivity.AnonymousClass1());
                animatorCreateCircularReveal.start();
            }
        }
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.task.TaskActivity$1, reason: invalid class name */
    class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            com.up366.mobile.course.task.TaskActivity.this.binding.rootLayout.setLayerType(0, null);
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskActivity$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onAnimationEnd$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAnimationEnd$0() throws java.lang.Exception {
            com.up366.mobile.common.utils.SkipBitmapBackGroundUtil.hideBackground(com.up366.mobile.course.task.TaskActivity.this.getWindow().getDecorView(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void goToWrongNote() {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "数据加载中");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda13
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$goToWrongNote$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$goToWrongNote$3() throws java.lang.Exception {
        final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolderLoad = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWrongNoteList(coursePageCountHolderLoad, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda12
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$goToWrongNote$2(coursePageCountHolderLoad, response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$goToWrongNote$2(com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder, com.up366.common.http.Response response, java.util.List list) {
        java.util.Objects.requireNonNull(coursePageCountHolder);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.mobile.book.helper.V8OpenHelper$$ExternalSyntheticLambda10(coursePageCountHolder));
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, com.up366.mobile.common.utils.ErrorMessageTool.convert(response));
            return;
        }
        final android.content.Intent intent = new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.course.wrongnote.WrongNoteActivity.class);
        intent.putExtra("type", 1);
        intent.putExtra("fromType", 0);
        if (list == null || list.size() != 1) {
            intent.putExtra(com.up366.mobile.course.wrongnote.WrongNoteActivity.INTENT_WRONG_SUBJECT, (java.io.Serializable) list);
            startActivity(intent);
            return;
        }
        com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo wrongNoteSubjectInfo = (com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo) list.get(0);
        intent.putExtra("stageId", wrongNoteSubjectInfo.getStageId());
        intent.putExtra("subjectId", wrongNoteSubjectInfo.getSubjectId());
        intent.putExtra(com.up366.mobile.course.wrongnote.WrongNoteActivity.INTENT_WRONG_SUBJECT, (java.io.Serializable) list);
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_WRONGNOTE).runWithTip(new java.lang.Runnable() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$goToWrongNote$1(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$goToWrongNote$1(android.content.Intent intent) {
        startActivity(intent);
    }

    public void setPullRecyclerView(com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, androidx.recyclerview.widget.RecyclerView recyclerView) {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.currentBookId)) {
            this.appBarHelper.binding(this.binding.appBar, pullRefreshLayout, recyclerView);
        }
    }

    private void initView() {
        this.appBarHelper = new com.up366.mobile.common.helper.AppBarRefreshLayoutHelper();
        this.binding.tvCurrentSelectBook.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$4(view);
            }
        });
        this.binding.tvHistorySelectBook.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$5(view);
            }
        });
        this.binding.tvSort.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$6(view);
            }
        });
        final java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger();
        this.binding.toolbar.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$8(atomicInteger, view);
            }
        });
        this.binding.search.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(android.widget.TextView textView, int i, android.view.KeyEvent keyEvent) {
                return this.f$0.lambda$initView$9(textView, i, keyEvent);
            }
        });
        this.binding.switchOnlyUnanswered.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
                this.f$0.lambda$initView$10(compoundButton, z);
            }
        });
        if (com.up366.common.StringUtils.isEmptyOrNull(this.currentBookId)) {
            this.binding.ibStrangeWord.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$initView$12(view);
                }
            });
            this.binding.ibWrongWord.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$initView$13(view);
                }
            });
            this.binding.appBar.addOnOffsetChangedListener(new com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda5
                public final void onOffsetChanged(com.google.android.material.appbar.AppBarLayout appBarLayout, int i) {
                    this.f$0.lambda$initView$14(appBarLayout, i);
                }
            });
        } else {
            this.binding.appBar.setExpanded(false, false);
            this.binding.appBar.postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$initView$16();
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4(android.view.View view) {
        com.up366.mobile.common.utils.ViewUtil.clickView(view);
        this.currentTaskListFragment.showTaskByCourse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$5(android.view.View view) {
        com.up366.mobile.common.utils.ViewUtil.clickView(view);
        this.binding.tvHistorySelectBook.setChecked(true);
        this.historyTaskListFragment.showTaskByCondition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$6(android.view.View view) {
        com.up366.mobile.common.utils.ViewUtil.clickView(view);
        if (this.selectTab == 0) {
            this.currentTaskListFragment.showSort();
        } else {
            this.historyTaskListFragment.showSort();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$8(final java.util.concurrent.atomic.AtomicInteger atomicInteger, android.view.View view) {
        view.postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                atomicInteger.set(0);
            }
        }, com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS);
        if (atomicInteger.addAndGet(1) > 10) {
            this.binding.search.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$9(android.widget.TextView textView, int i, android.view.KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        this.searchText = this.binding.search.getText().toString().trim();
        this.currentTaskListFragment.updateTaskList();
        this.historyTaskListFragment.updateTaskList();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$10(android.widget.CompoundButton compoundButton, boolean z) {
        this.historyTaskListFragment.showOnlyUnanswered(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$12(android.view.View view) {
        com.up366.mobile.common.helper.PageFunctionCheckHelper.checkFunCheck(view, com.up366.mobile.common.helper.PageFunctionCheckHelper.Funtions.WRONGNOTE, new java.lang.Runnable() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initView$11();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$11() {
        android.content.Intent intent = new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.class);
        intent.putExtra("type", 1);
        intent.putExtra("fromType", 0);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$13(android.view.View view) {
        com.up366.mobile.common.helper.PageFunctionCheckHelper.checkFunCheck(view, com.up366.mobile.common.helper.PageFunctionCheckHelper.Funtions.WRONGNOTE, new java.lang.Runnable() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.goToWrongNote();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$14(com.google.android.material.appbar.AppBarLayout appBarLayout, int i) {
        this.binding.clBook.setAlpha(1.0f - (java.lang.Math.abs(i) / appBarLayout.getTotalScrollRange()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$16() {
        this.binding.appBar.addOnOffsetChangedListener(new com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda15
            public final void onOffsetChanged(com.google.android.material.appbar.AppBarLayout appBarLayout, int i) {
                this.f$0.lambda$initView$15(appBarLayout, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$15(com.google.android.material.appbar.AppBarLayout appBarLayout, int i) {
        this.binding.appBar.setExpanded(false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initTab(boolean z) {
        if (z) {
            for (androidx.fragment.app.Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment instanceof com.up366.mobile.course.task.CurrentTaskListFragment) {
                    this.currentTaskListFragment = (com.up366.mobile.course.task.CurrentTaskListFragment) fragment;
                }
                if (fragment instanceof com.up366.mobile.course.task.HistoryTaskListFragment) {
                    this.historyTaskListFragment = (com.up366.mobile.course.task.HistoryTaskListFragment) fragment;
                }
            }
        }
        if (this.currentTaskListFragment == null) {
            this.currentTaskListFragment = new com.up366.mobile.course.task.CurrentTaskListFragment();
        }
        if (this.historyTaskListFragment == null) {
            this.historyTaskListFragment = new com.up366.mobile.course.task.HistoryTaskListFragment();
        }
        this.askViewHelper = new com.up366.mobile.course.task.TaskTeacherAskViewHelper(this.binding, this.currentTaskListFragment.getLifecycle(), this.historyTaskListFragment.getLifecycle());
        this.currentTaskListFragment.getLifecycle().addObserver(new androidx.lifecycle.LifecycleEventObserver() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda16
            public final void onStateChanged(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
                this.f$0.lambda$initTab$17(lifecycleOwner, event);
            }
        });
        com.up366.mobile.me.teacherclass.MeTeachingClassAdapter meTeachingClassAdapter = new com.up366.mobile.me.teacherclass.MeTeachingClassAdapter(getSupportFragmentManager(), 1);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(this.currentTaskListFragment);
        arrayList.add(this.historyTaskListFragment);
        meTeachingClassAdapter.setmFragments(arrayList);
        this.binding.viewpager.setAdapter(meTeachingClassAdapter);
        if (this.selectTab == 0) {
            this.binding.viewpager.setCurrentItem(0);
        } else {
            this.binding.viewpager.setCurrentItem(1);
            this.binding.tvCurrentSelectBook.setVisibility(8);
            this.binding.tvHistorySelectBook.setVisibility(0);
        }
        com.up366.qmui.util.QMUIStatusBarHelper.translucent((android.app.Activity) this);
        com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarLightMode(this);
        com.up366.qmui.widget.tab.QMUITabBuilder typeface = this.binding.tabSegment.tabBuilder().setNormalColor(getResources().getColor(com.up366.mobile.R.color.c5)).setSelectColor(getResources().getColor(com.up366.mobile.R.color.font_c4)).setTypeface(android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, 0), android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, 1));
        this.binding.tabSegment.addTab(typeface.setText("当前").build(this));
        this.binding.tabSegment.addTab(typeface.setText("历史").build(this));
        int iDp2px = com.up366.qmui.util.QMUIDisplayHelper.dp2px(this, 20);
        com.up366.mobile.common.views.QMUITabIndicatorV2 qMUITabIndicatorV2 = new com.up366.mobile.common.views.QMUITabIndicatorV2();
        qMUITabIndicatorV2.setmIndicatorHeight(com.up366.qmui.util.QMUIDisplayHelper.dp2px(this, 12)).setmIndicatorWidth(com.up366.qmui.util.QMUIDisplayHelper.dp2px(this, 24)).setmIndicatorTop(false).setmIsIndicatorWidthFollowContent(false).setmFixedColorAttr(-1).setmShouldReGetFixedColor(false);
        this.binding.tabSegment.setIndicator(qMUITabIndicatorV2);
        this.binding.tabSegment.setMode(0);
        this.binding.tabSegment.setItemSpaceInScrollMode(iDp2px);
        this.binding.tabSegment.setupWithViewPager(this.binding.viewpager, false);
        this.binding.tabSegment.setPadding(iDp2px, 0, iDp2px, 0);
        this.binding.tabSegment.addOnTabSelectedListener(new com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener() { // from class: com.up366.mobile.course.task.TaskActivity.2
            @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
            public void onDoubleTap(int i) {
            }

            @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
            public void onTabReselected(int i) {
            }

            @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
            public void onTabUnselected(int i) {
            }

            @Override // com.up366.qmui.widget.tab.QMUIBasicTabSegment.OnTabSelectedListener
            public void onTabSelected(int i) {
                if (i == 0) {
                    com.up366.mobile.course.task.TaskActivity.this.selectTab = 0;
                    com.up366.mobile.course.task.TaskActivity.this.binding.tvHistorySelectBook.setVisibility(8);
                    com.up366.mobile.course.task.TaskActivity.this.binding.switchOnlyUnanswered.setVisibility(8);
                    if (com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.course.task.TaskActivity.this.currentBookId) && com.up366.mobile.course.task.TaskActivity.this.viewModel.getCourseInfos().size() > 1) {
                        com.up366.mobile.course.task.TaskActivity.this.binding.tvCurrentSelectBook.setVisibility(0);
                        return;
                    } else {
                        com.up366.mobile.course.task.TaskActivity.this.binding.tvCurrentSelectBook.setVisibility(8);
                        return;
                    }
                }
                com.up366.mobile.course.task.TaskActivity.this.selectTab = 1;
                com.up366.mobile.course.task.TaskActivity.this.binding.tvCurrentSelectBook.setVisibility(8);
                com.up366.mobile.course.task.TaskActivity.this.binding.switchOnlyUnanswered.setVisibility(0);
                if (com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.course.task.TaskActivity.this.currentBookId)) {
                    com.up366.mobile.course.task.TaskActivity.this.binding.tvHistorySelectBook.setVisibility(0);
                } else {
                    com.up366.mobile.course.task.TaskActivity.this.binding.tvHistorySelectBook.setVisibility(8);
                }
            }
        });
        this.binding.viewpager.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener() { // from class: com.up366.mobile.course.task.TaskActivity.3
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                com.up366.mobile.course.task.TaskActivity.this.reportEnterPage(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTab$17(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
        if (event == androidx.lifecycle.Lifecycle.Event.ON_CREATE) {
            this.viewModel.loadDataFromMemory();
            if (com.up366.common.StringUtils.isEmptyOrNull(this.currentBookId)) {
                return;
            }
            this.viewModel.refreshTaskData(false);
        }
    }

    private void initObserver() {
        this.viewModel.getCurrentTaskNumber().observe(this, new androidx.lifecycle.Observer() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda8
            public final void onChanged(java.lang.Object obj) {
                this.f$0.lambda$initObserver$18((java.lang.Integer) obj);
            }
        });
        this.viewModel.getRefreshDataLiveData().observe(this, new androidx.lifecycle.Observer() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda9
            public final void onChanged(java.lang.Object obj) {
                this.f$0.lambda$initObserver$19((java.lang.Boolean) obj);
            }
        });
        this.viewModel.getCurrentSelectCourse().observe(this, new androidx.lifecycle.Observer() { // from class: com.up366.mobile.course.task.TaskActivity$$ExternalSyntheticLambda11
            public final void onChanged(java.lang.Object obj) {
                this.f$0.lambda$initObserver$20((com.up366.mobile.course.mgr.CourseInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initObserver$18(java.lang.Integer num) {
        java.lang.String str;
        com.up366.qmui.widget.tab.QMUITab tab = this.binding.tabSegment.getTab(0);
        if (num.intValue() == 0) {
            str = "当前";
        } else {
            str = "当前(" + num + ")";
        }
        tab.setText(str);
        this.binding.tabSegment.replaceTab(0, tab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initObserver$19(java.lang.Boolean bool) {
        this.refreshData = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initObserver$20(com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        if (this.binding.tabSegment.getSelectedIndex() == 0) {
            if (courseInfo == null || !com.up366.common.StringUtils.isEmptyOrNull(this.currentBookId)) {
                this.binding.tvCurrentSelectBook.setVisibility(8);
            } else {
                this.binding.tvCurrentSelectBook.setVisibility(0);
                this.binding.tvCurrentSelectBook.setText(courseInfo.getCourseName());
            }
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.TaskCompletedEvent taskCompletedEvent) {
        if (getLifecycle().getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.RESUMED)) {
            this.viewModel.refreshTaskData(false);
        } else {
            this.refreshData = true;
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.ShowTaskAskEvent showTaskAskEvent) {
        this.askViewHelper.open(showTaskAskEvent.getTaskInfoV2s());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.InitPhotoAnswerErrorNoCameraEvent initPhotoAnswerErrorNoCameraEvent) {
        com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "由于没有后置摄像头，无法进行拍照答题");
    }

    private boolean needShowOverdueToast() {
        long j = com.up366.mobile.common.utils.PreferenceUtils.getLong("task-overdue-toast_time", 0L);
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        if (j == 0) {
            com.up366.mobile.common.utils.PreferenceUtils.putLong("task-overdue-toast_time", currentNtpTimeInMillisecond);
            return true;
        }
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.setTimeInMillis(currentNtpTimeInMillisecond);
        if (calendar.get(3) == calendar2.get(3)) {
            return false;
        }
        com.up366.mobile.common.utils.PreferenceUtils.putLong("task-overdue-toast_time", currentNtpTimeInMillisecond);
        return true;
    }

    public void reportEnterPage(int i) {
        if (this.currentPage == i) {
            return;
        }
        this.currentPage = i;
        if (i == 0) {
            com.up366.mobile.common.onlinelog.OpLog.report("进入当前任务单列表", "current");
        } else {
            com.up366.mobile.common.onlinelog.OpLog.report("进入历史任务单列表", "history");
        }
    }
}
