package com.up366.mobile.course;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class LearnTrailActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.ActivityLearnTrailBinding binding;
    private java.lang.String endTime;
    private java.lang.String startTime;
    private boolean showWhiteTitle = true;
    java.text.DecimalFormat formatter = new java.text.DecimalFormat("#.#");

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (com.up366.mobile.databinding.ActivityLearnTrailBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_learn_trail);
        com.up366.qmui.util.QMUIStatusBarHelper.translucent((android.app.Activity) this);
        com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarDarkMode(this);
        new com.up366.mobile.common.helper.AppBarRefreshLayoutHelper().binding(this.binding.appBar, this.binding.pullRefresh);
        final int statusBarHeight = com.up366.mobile.common.utils.ScreenUtils.getStatusBarHeight(this);
        this.binding.appBar.addOnOffsetChangedListener(new com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener() { // from class: com.up366.mobile.course.LearnTrailActivity$$ExternalSyntheticLambda3
            public final void onOffsetChanged(com.google.android.material.appbar.AppBarLayout appBarLayout, int i) {
                this.f$0.lambda$onCreate$0(statusBarHeight, appBarLayout, i);
            }
        });
        initChart();
        this.binding.pullRefresh.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.course.LearnTrailActivity$$ExternalSyntheticLambda4
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.lambda$onCreate$1();
            }
        });
        this.binding.btFilterByTime.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.LearnTrailActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        initStartAndEndTime();
        this.binding.pullRefresh.doRefresh();
        this.formatter.setRoundingMode(java.math.RoundingMode.DOWN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(int i, com.google.android.material.appbar.AppBarLayout appBarLayout, int i2) {
        float height = ((i2 * 1.0f) / ((this.binding.toolbarLayout.getHeight() - i) - this.binding.toolbar.getHeight())) + 1.0f;
        this.binding.ivToolbarBg.setAlpha(height);
        this.binding.btFilterByTime.setAlpha(height);
        double d = height;
        if (d < 0.5d && this.showWhiteTitle) {
            this.showWhiteTitle = false;
            com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarLightMode(this);
            this.binding.tbvTrailBack.setImageResource(com.up366.mobile.R.drawable.icon_return);
        }
        if (d <= 0.5d || this.showWhiteTitle) {
            return;
        }
        this.showWhiteTitle = true;
        com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarDarkMode(this);
        this.binding.tbvTrailBack.setImageResource(com.up366.mobile.R.drawable.learn_trail_back);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1() {
        getDataFromWeb(this.startTime, this.endTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(android.view.View view) {
        showFilterDialog();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && !(getCurrentFocus() instanceof com.up366.mobile.common.views.LineSheetViewV3)) {
            this.binding.trendScoreRatio.setShowToast(false);
            this.binding.trendHomeworkComplete.setShowToast(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void initStartAndEndTime() {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        this.endTime = com.up366.mobile.common.utils.TimeUtilsApp.formatTime(calendar.getTimeInMillis(), "yyyy-MM");
        this.endTime += "-" + com.up366.mobile.common.utils.TimeUtilsApp.getDayNumberByYearMonth(this.endTime);
        calendar.add(2, -1);
        this.startTime = com.up366.mobile.common.utils.TimeUtilsApp.formatTime(calendar.getTimeInMillis(), "yyyy-MM") + "-01";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showFilterDialog() {
        final com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet = new com.up366.qmui.widget.dialog.QMUIBottomSheet(this);
        com.up366.mobile.common.views.BottomTrendFilterPickerView bottomTrendFilterPickerView = new com.up366.mobile.common.views.BottomTrendFilterPickerView(this);
        bottomTrendFilterPickerView.setCurrentFilterData(1, this.startTime.substring(0, 7), this.endTime.substring(0, 7));
        bottomTrendFilterPickerView.setCloseViewListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.LearnTrailActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                qMUIBottomSheet.dismiss();
            }
        });
        bottomTrendFilterPickerView.setSelectFilterCallback(new com.up366.mobile.common.views.BottomTrendFilterPickerView.SelectFilterCallback() { // from class: com.up366.mobile.course.LearnTrailActivity$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.common.views.BottomTrendFilterPickerView.SelectFilterCallback
            public final void onSelectFilter(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
                this.f$0.lambda$showFilterDialog$4(qMUIBottomSheet, str, str2, str3, str4);
            }
        });
        qMUIBottomSheet.addContentView(bottomTrendFilterPickerView);
        qMUIBottomSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFilterDialog$4(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        qMUIBottomSheet.dismiss();
        com.up366.common.log.Logger.info("LearnTrailActivity showFilterDialog startTime=" + str + "-" + str2 + "  endTIme=" + str3 + "-" + str4);
        this.startTime = com.up366.common.StringUtils.format("%s-%s-%s", str, str2, "01");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str3);
        sb.append("-");
        sb.append(str4);
        this.endTime = com.up366.common.StringUtils.format("%s-%s-%d", str3, str4, java.lang.Integer.valueOf(com.up366.mobile.common.utils.TimeUtilsApp.getDayNumberByYearMonth(sb.toString())));
        this.binding.pullRefresh.doRefresh();
    }

    private void initChart() {
        this.binding.tbvTrailBack.setImageResource(com.up366.mobile.R.drawable.learn_trail_back);
        this.binding.trendScoreRatio.setVisibleSchoolAndEarthLineColor();
        this.binding.trendScoreRatio.setTitle(com.up366.mobile.R.drawable.icon_score_rate_trend, "得分率走势");
        this.binding.trendScoreRatio.setChartYTitle("得分率(%)");
        java.lang.String[] strArr = new java.lang.String[4];
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        for (int i = 0; i < 4; i++) {
            strArr[i] = com.up366.mobile.common.utils.TimeUtilsApp.formatTime(jCurrentTimeMillis - ((long) ((3 - i) * 86400000)), "MM-dd");
        }
        this.binding.trendScoreRatio.setAxis(strArr, 20, 5);
        this.binding.trendHomeworkComplete.setTitle(com.up366.mobile.R.drawable.icon_homework_completion_record, "练习完成记录");
        this.binding.trendHomeworkComplete.setChartYTitle("完成数量");
        this.binding.trendHomeworkComplete.setAxis(strArr, 1, 5);
    }

    private void getDataFromWeb(final java.lang.String str, final java.lang.String str2) {
        com.up366.mobile.common.utils.TaskChainTool taskChainTool = new com.up366.mobile.common.utils.TaskChainTool();
        taskChainTool.query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.course.LearnTrailActivity$$ExternalSyntheticLambda9
            @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
            public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                com.up366.mobile.course.LearnTrailActivity.lambda$getDataFromWeb$5(str, str2, iReturnOps);
            }
        });
        taskChainTool.query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.course.LearnTrailActivity$$ExternalSyntheticLambda10
            @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
            public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                com.up366.mobile.course.LearnTrailActivity.lambda$getDataFromWeb$6(str, str2, iReturnOps);
            }
        });
        taskChainTool.doQueryParallel();
        taskChainTool.onError(new com.up366.mobile.common.utils.TaskChainTool.IErrorCallback() { // from class: com.up366.mobile.course.LearnTrailActivity$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.utils.TaskChainTool.IErrorCallback
            public final void error(int i, java.lang.String str3) {
                this.f$0.lambda$getDataFromWeb$7(i, str3);
            }
        });
        taskChainTool.onSuccess(new com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback() { // from class: com.up366.mobile.course.LearnTrailActivity$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback
            public final void success(int i, java.lang.String str3, java.lang.Object[] objArr) {
                this.f$0.lambda$getDataFromWeb$8(i, str3, objArr);
            }
        });
    }

    static /* synthetic */ void lambda$getDataFromWeb$5(java.lang.String str, java.lang.String str2, com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        com.up366.mobile.course.task.TaskMgr taskMgr = com.up366.mobile.common.logic.Auth.cur().taskMgr();
        java.util.Objects.requireNonNull(iReturnOps);
        taskMgr.getTaskScoreTrend(str, str2, new com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda11(iReturnOps));
    }

    static /* synthetic */ void lambda$getDataFromWeb$6(java.lang.String str, java.lang.String str2, com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        com.up366.mobile.course.task.TaskMgr taskMgr = com.up366.mobile.common.logic.Auth.cur().taskMgr();
        java.util.Objects.requireNonNull(iReturnOps);
        taskMgr.fetchTaskByMonth(str, str2, new com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda11(iReturnOps));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getDataFromWeb$7(int i, java.lang.String str) {
        this.binding.pullRefresh.complete();
        com.up366.common.log.Logger.info("LearnTrailActivity getDataFromWeb error code=" + i + " info=" + str);
        com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, "网络好像走丢了\n请稍后再试!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDataFromWeb$8(int i, java.lang.String str, java.lang.Object[] objArr) {
        com.up366.common.log.Logger.info("LearnTrailActivity getDataFromWeb success");
        this.binding.pullRefresh.complete();
        initTaskScoreData((java.util.List) objArr[0]);
        analyseCompletedTask((java.util.List) objArr[1]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initTaskScoreData(java.util.List<com.up366.mobile.course.task.model.TaskScoreTrend> list) {
        int i = 5;
        if (list.size() == 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "得分走势无数据");
            this.binding.trendScoreRatio.setAxis(new java.lang.String[0], 20, 5);
            this.binding.trendScoreRatio.setData(new int[0], new int[0], new int[0], new java.lang.String[0]);
            return;
        }
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.course.LearnTrailActivity$$ExternalSyntheticLambda8
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.mobile.course.LearnTrailActivity.lambda$initTaskScoreData$9((com.up366.mobile.course.task.model.TaskScoreTrend) obj, (com.up366.mobile.course.task.model.TaskScoreTrend) obj2);
            }
        });
        int size = list.size();
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        int[] iArr3 = new int[size];
        java.lang.String[] strArr = new java.lang.String[size];
        java.lang.String[] strArr2 = new java.lang.String[size];
        int i2 = 0;
        while (i2 < list.size()) {
            com.up366.mobile.course.task.model.TaskScoreTrend taskScoreTrend = list.get(i2);
            iArr[i2] = java.lang.Math.max((int) taskScoreTrend.getScorePercent(), 0);
            iArr2[i2] = java.lang.Math.max((int) taskScoreTrend.getAvgOrgan(), 0);
            iArr3[i2] = java.lang.Math.max((int) taskScoreTrend.getAvgGlobal(), 0);
            strArr[i2] = com.up366.common.TimeUtils.formatTime(taskScoreTrend.getEndTime(), "MM-dd");
            strArr2[i2] = com.up366.common.StringUtils.format("%s%n自己: %s%%%n校平均: %s%% (打败全校%s%%)%n全球平均: %s%% (打败全校%s%%)", taskScoreTrend.getStudyTaskName(), this.formatter.format(java.lang.Double.valueOf(java.lang.String.valueOf(taskScoreTrend.getScorePercent()))), this.formatter.format(java.lang.Double.valueOf(java.lang.String.valueOf(taskScoreTrend.getAvgOrgan()))), this.formatter.format(java.lang.Double.valueOf(java.lang.String.valueOf(taskScoreTrend.getOrganRank()))), this.formatter.format(java.lang.Double.valueOf(java.lang.String.valueOf(taskScoreTrend.getAvgGlobal()))), this.formatter.format(java.lang.Double.valueOf(java.lang.String.valueOf(taskScoreTrend.getGlobalRank()))));
            i2++;
            i = 5;
        }
        this.binding.trendScoreRatio.setAxis(strArr, 20, i);
        this.binding.trendScoreRatio.setData(iArr, iArr2, iArr3, strArr2);
    }

    static /* synthetic */ int lambda$initTaskScoreData$9(com.up366.mobile.course.task.model.TaskScoreTrend taskScoreTrend, com.up366.mobile.course.task.model.TaskScoreTrend taskScoreTrend2) {
        if (taskScoreTrend.getEndTime() < taskScoreTrend2.getEndTime()) {
            return -1;
        }
        return taskScoreTrend.getEndTime() > taskScoreTrend2.getEndTime() ? 1 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void analyseCompletedTask(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        int i;
        if (list == null || list.isEmpty()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "练习完成记录无数据");
            this.binding.trendHomeworkComplete.setAxis(new java.lang.String[0], 20, 5);
            this.binding.trendHomeworkComplete.setData(new int[0], new int[0], new int[0], new java.lang.String[0]);
            return;
        }
        java.util.Iterator<com.up366.mobile.course.task.TaskInfoV2> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().isFinish()) {
                it.remove();
            }
        }
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.course.LearnTrailActivity$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.mobile.course.LearnTrailActivity.lambda$analyseCompletedTask$10((com.up366.mobile.course.task.TaskInfoV2) obj, (com.up366.mobile.course.task.TaskInfoV2) obj2);
            }
        });
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : list) {
            java.lang.String time = com.up366.mobile.common.utils.TimeUtilsApp.formatTime(taskInfoV2.getSubmitTime(), "yyyy年MM月dd日");
            if (arrayList.contains(time)) {
                int iIndexOf = arrayList.indexOf(time);
                int iIntValue = ((java.lang.Integer) arrayList3.get(iIndexOf)).intValue();
                arrayList3.remove(iIndexOf);
                arrayList3.add(iIndexOf, java.lang.Integer.valueOf(iIntValue + 1));
            } else {
                arrayList.add(time);
                arrayList2.add(com.up366.mobile.common.utils.TimeUtilsApp.formatTime(taskInfoV2.getSubmitTime(), "MM-dd"));
                arrayList3.add(1);
            }
        }
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList4.add(i2, com.up366.common.StringUtils.format("%s提交了%d份练习", arrayList.get(i2), arrayList3.get(i2)));
        }
        int size = arrayList3.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < arrayList3.size(); i3++) {
            iArr[i3] = java.lang.Math.max(((java.lang.Integer) arrayList3.get(i3)).intValue(), 0);
        }
        int iMax = 5;
        for (int i4 = 0; i4 < size; i4++) {
            iMax = java.lang.Math.max(iArr[i4], iMax);
        }
        if (iMax % 5 > 0) {
            i = (iMax / 5) + 1;
        } else {
            i = iMax / 5;
        }
        this.binding.trendHomeworkComplete.setAxis((java.lang.String[]) arrayList2.toArray(new java.lang.String[0]), i, 5);
        this.binding.trendHomeworkComplete.setData(iArr, null, null, (java.lang.String[]) arrayList4.toArray(new java.lang.String[0]));
    }

    static /* synthetic */ int lambda$analyseCompletedTask$10(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, com.up366.mobile.course.task.TaskInfoV2 taskInfoV22) {
        if (taskInfoV2.getSubmitTime() - taskInfoV22.getSubmitTime() > 0) {
            return 1;
        }
        return taskInfoV2.getSubmitTime() - taskInfoV22.getSubmitTime() < 0 ? -1 : 0;
    }
}
