package com.up366.mobile.commonui.condition;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ConditionActivity extends com.up366.mobile.common.base.BaseActivity {
    public static final int FROM_TASK = 2;
    public static final int FROM_WORD = 0;
    public static final int FROM_WRONG_NOTE = 1;
    public static final java.lang.String INTENT_KEY_CONDITION_FROM = "ConditionActivity_From";
    public static final java.lang.String INTENT_KEY_CONDITION_MODEL = "ConditionModel";
    public static final java.lang.String INTENT_KEY_CONDITION_RESULT = "ConditionActivityCallBackData";
    private com.up366.mobile.databinding.ConditionActivityBinding b;
    private java.util.Map<java.lang.String, java.lang.Integer> degreeMap;
    private com.up366.mobile.commonui.condition.ConditionModel model;
    private java.util.Map<java.lang.String, java.lang.Integer> timeMap;
    private com.up366.mobile.commonui.condition.ConditionAdapter adapter = new com.up366.mobile.commonui.condition.ConditionAdapter();
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo> bookController = new com.up366.mobile.common.base.USV5ListViewDataController<>(this);
    private int from = 0;

    static /* synthetic */ void lambda$initBooksController$5(java.util.List list) {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
        this.b = (com.up366.mobile.databinding.ConditionActivityBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.condition_activity);
        initIntent();
        initView();
        if (fromTask()) {
            initSelectClickByTask();
            initCourseList();
        } else {
            initSelectClick();
            initBooksController();
            this.b.refreshLayout.doRefresh();
        }
    }

    private void initSelectClick() {
        setNoteTypeClickListener(this.b.noteAll, this.b.noteListen, this.b.noteRead, this.b.noteWrite, this.b.noteUse, this.b.noteOther);
        setTimeClickListener(this.b.timeBtnAll, this.b.timeBtnToday, this.b.timeBtnWeek, this.b.timeBtnMouth, this.b.dateBtnBegin, this.b.dateBtnEnd);
    }

    private void initSelectClickByTask() {
        setTimeClickListener(this.b.timeBtnAll, this.b.timeBtnToday, this.b.timeBtnWeek, this.b.timeBtnMouth, this.b.dateBtnBegin, this.b.dateBtnEnd);
    }

    private void setTimeClickListener(final android.widget.CheckedTextView... checkedTextViewArr) {
        for (android.widget.CheckedTextView checkedTextView : checkedTextViewArr) {
            checkedTextView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$setTimeClickListener$2(checkedTextViewArr, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$setTimeClickListener$2(android.widget.CheckedTextView[] checkedTextViewArr, android.view.View view) {
        int id = view.getId();
        switch (id) {
            case com.up366.mobile.R.id.dateBtnBegin /* 2131362239 */:
                this.model.setTimeType(4);
                new com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker(this).setStartDate(new java.util.Date(com.up366.mobile.common.utils.TimeUtilsApp.dateStrToLong(this.b.dateBtnBegin.getText().toString(), "yyyy-MM-dd"))).setEndDate(new java.util.Date(getMaxTimeByType())).setMinDate(new java.util.Date(com.up366.mobile.common.utils.TimeUtilsApp.dateStrToLong("2010-01-01", "yyyy-MM-dd"))).setMaxDate(new java.util.Date(getMaxTimeByType())).show(new com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.IOnSelectDateRange() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda13
                    @Override // com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.IOnSelectDateRange
                    public final void onResult(java.util.Date date, java.util.Date date2) {
                        this.f$0.lambda$setTimeClickListener$0(date, date2);
                    }
                });
                break;
            case com.up366.mobile.R.id.dateBtnEnd /* 2131362240 */:
                this.model.setTimeType(4);
                new com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker(this).setStartDate(new java.util.Date(com.up366.mobile.common.utils.TimeUtilsApp.dateStrToLong(this.b.dateBtnEnd.getText().toString(), "yyyy-MM-dd"))).setEndDate(new java.util.Date(getMaxTimeByType())).setMinDate(new java.util.Date(com.up366.mobile.common.utils.TimeUtilsApp.dateStrToLong("2010-01-01", "yyyy-MM-dd"))).setMaxDate(new java.util.Date(getMaxTimeByType())).show(new com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.IOnSelectDateRange() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda14
                    @Override // com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.IOnSelectDateRange
                    public final void onResult(java.util.Date date, java.util.Date date2) {
                        this.f$0.lambda$setTimeClickListener$1(date, date2);
                    }
                });
                break;
            default:
                switch (id) {
                    case com.up366.mobile.R.id.timeBtnAll /* 2131363424 */:
                        this.model.setTimeType(0);
                        this.model.setEndTime(com.up366.mobile.common.utils.TimeUtilsApp.getDayEndTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
                        if (fromTask()) {
                            com.up366.mobile.commonui.condition.ConditionModel conditionModel = this.model;
                            conditionModel.setBeginTime(com.up366.mobile.common.utils.TimeUtilsApp.getDayStartTime(getLastYearTime(conditionModel.getEndTime())));
                        } else {
                            this.model.setBeginTime(com.up366.mobile.common.utils.TimeUtilsApp.dateStrToLong("2010-01-01", "yyyy-MM-dd"));
                        }
                        this.b.dateBtnBegin.setText(com.up366.common.TimeUtils.formatTime(this.model.getBeginTime(), "yyyy-MM-dd"));
                        this.b.dateBtnEnd.setText(com.up366.common.TimeUtils.formatTime(this.model.getEndTime(), "yyyy-MM-dd"));
                        break;
                    case com.up366.mobile.R.id.timeBtnMouth /* 2131363425 */:
                        this.model.setTimeType(3);
                        this.model.setBeginTime(com.up366.mobile.common.utils.TimeUtilsApp.getDayStartTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - 2592000000L));
                        this.model.setEndTime(com.up366.mobile.common.utils.TimeUtilsApp.getDayEndTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
                        this.b.dateBtnBegin.setText(com.up366.common.TimeUtils.formatTime(this.model.getBeginTime(), "yyyy-MM-dd"));
                        this.b.dateBtnEnd.setText(com.up366.common.TimeUtils.formatTime(this.model.getEndTime(), "yyyy-MM-dd"));
                        break;
                    case com.up366.mobile.R.id.timeBtnToday /* 2131363426 */:
                        this.model.setTimeType(1);
                        this.model.setBeginTime(com.up366.mobile.common.utils.TimeUtilsApp.dateStrToLong(com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy-MM-dd"), "yyyy-MM-dd"));
                        this.model.setEndTime(com.up366.mobile.common.utils.TimeUtilsApp.getDayEndTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
                        this.b.dateBtnBegin.setText(com.up366.common.TimeUtils.formatTime(this.model.getBeginTime(), "yyyy-MM-dd"));
                        this.b.dateBtnEnd.setText(com.up366.common.TimeUtils.formatTime(this.model.getEndTime(), "yyyy-MM-dd"));
                        break;
                    case com.up366.mobile.R.id.timeBtnWeek /* 2131363427 */:
                        this.model.setTimeType(2);
                        this.model.setBeginTime(com.up366.mobile.common.utils.TimeUtilsApp.getDayStartTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - 604800000));
                        this.model.setEndTime(com.up366.mobile.common.utils.TimeUtilsApp.getDayEndTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
                        this.b.dateBtnBegin.setText(com.up366.common.TimeUtils.formatTime(this.model.getBeginTime(), "yyyy-MM-dd"));
                        this.b.dateBtnEnd.setText(com.up366.common.TimeUtils.formatTime(this.model.getEndTime(), "yyyy-MM-dd"));
                        break;
                }
                break;
        }
        refreshTimeSelectedState(checkedTextViewArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setTimeClickListener$0(java.util.Date date, java.util.Date date2) {
        this.b.dateBtnBegin.setText(com.up366.common.TimeUtils.formatTime(date, "yyyy-MM-dd"));
        this.model.setBeginTime(com.up366.mobile.common.utils.TimeUtilsApp.getDayStartTime(date.getTime()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setTimeClickListener$1(java.util.Date date, java.util.Date date2) {
        long dayEndTime = com.up366.mobile.common.utils.TimeUtilsApp.getDayEndTime(date2.getTime());
        this.b.dateBtnEnd.setText(com.up366.common.TimeUtils.formatTime(dayEndTime, "yyyy-MM-dd"));
        this.model.setEndTime(dayEndTime);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void refreshTimeSelectedState(android.widget.CheckedTextView... r8) {
        /*
            r7 = this;
            int r0 = r8.length
            r1 = 0
            r2 = r1
        L3:
            if (r2 >= r0) goto L60
            r3 = r8[r2]
            java.lang.CharSequence r4 = r3.getText()
            java.lang.String r4 = r4.toString()
            java.util.Map<java.lang.String, java.lang.Integer> r5 = r7.timeMap
            boolean r4 = r5.containsKey(r4)
            r5 = 1
            if (r4 != 0) goto L38
            java.lang.CharSequence r4 = r3.getText()
            if (r4 == 0) goto L36
            java.util.Map<java.lang.String, java.lang.Integer> r4 = r7.timeMap
            java.lang.String r6 = "自定义"
            java.lang.Object r4 = r4.get(r6)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.up366.mobile.commonui.condition.ConditionModel r6 = r7.model
            int r6 = r6.getTimeType()
            if (r4 != r6) goto L36
            goto L5a
        L36:
            r5 = r1
            goto L5a
        L38:
            java.lang.CharSequence r4 = r3.getText()
            if (r4 == 0) goto L36
            java.util.Map<java.lang.String, java.lang.Integer> r4 = r7.timeMap
            java.lang.CharSequence r6 = r3.getText()
            java.lang.String r6 = r6.toString()
            java.lang.Object r4 = r4.get(r6)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.up366.mobile.commonui.condition.ConditionModel r6 = r7.model
            int r6 = r6.getTimeType()
            if (r4 != r6) goto L36
        L5a:
            r3.setChecked(r5)
            int r2 = r2 + 1
            goto L3
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.commonui.condition.ConditionActivity.refreshTimeSelectedState(android.widget.CheckedTextView[]):void");
    }

    private void setNoteTypeClickListener(final android.widget.CheckedTextView... checkedTextViewArr) {
        for (android.widget.CheckedTextView checkedTextView : checkedTextViewArr) {
            checkedTextView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$setNoteTypeClickListener$3(checkedTextViewArr, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNoteTypeClickListener$3(android.widget.CheckedTextView[] checkedTextViewArr, android.view.View view) {
        switch (view.getId()) {
            case com.up366.mobile.R.id.noteAll /* 2131362908 */:
                this.model.setDegree(0);
                break;
            case com.up366.mobile.R.id.noteListen /* 2131362909 */:
                this.model.setDegree(1);
                break;
            case com.up366.mobile.R.id.noteOther /* 2131362910 */:
                this.model.setDegree(5);
                break;
            case com.up366.mobile.R.id.noteRead /* 2131362911 */:
                this.model.setDegree(2);
                break;
            case com.up366.mobile.R.id.noteUse /* 2131362912 */:
                this.model.setDegree(4);
                break;
            case com.up366.mobile.R.id.noteWrite /* 2131362913 */:
                this.model.setDegree(3);
                break;
        }
        refreshTypeSelectedState(checkedTextViewArr);
    }

    private void refreshTypeSelectedState(android.widget.CheckedTextView... checkedTextViewArr) {
        for (android.widget.CheckedTextView checkedTextView : checkedTextViewArr) {
            checkedTextView.setChecked(checkedTextView.getText() != null && this.degreeMap.get(checkedTextView.getText().toString()).intValue() == this.model.getDegree());
        }
    }

    private void initIntent() {
        android.content.Intent intent = getIntent();
        this.from = intent.getIntExtra(INTENT_KEY_CONDITION_FROM, 0);
        this.model = (com.up366.mobile.commonui.condition.ConditionModel) intent.getSerializableExtra(INTENT_KEY_CONDITION_MODEL);
    }

    private void initBooksController() {
        this.bookController.setErrorViewClickAction(new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda15
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                this.f$0.lambda$initBooksController$4(i);
            }
        });
        this.bookController.setLoadingView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                com.up366.mobile.commonui.condition.ConditionActivity.lambda$initBooksController$5(list);
            }
        });
        this.bookController.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state1).setTipMessage("没有获取到教学班信息哦").build()));
            }
        });
        this.bookController.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                this.f$0.lambda$initBooksController$7(list, list2);
            }
        });
        this.bookController.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$initBooksController$8();
            }
        });
        this.bookController.setAdapter(this.adapter);
        this.bookController.setOnCompleteCallback(new com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback
            public final void onComplete() {
                this.f$0.lambda$initBooksController$9();
            }
        });
        this.bookController.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initBooksController$4(int i) {
        this.b.refreshLayout.doRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initBooksController$7(java.util.List list, java.util.List list2) {
        java.lang.String bookId = this.model.getBookId();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo wrongNoteBookInfo = (com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo) it.next();
            if (bookId.equals(wrongNoteBookInfo.getBookId())) {
                wrongNoteBookInfo.setSelect(true);
            } else {
                wrongNoteBookInfo.setSelect(false);
            }
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(5, wrongNoteBookInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initBooksController$8() throws java.lang.Exception {
        int i = this.from;
        if (i == 0) {
            com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWordNoteDetailBookList();
        } else {
            if (i != 1) {
                return;
            }
            com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchWrongNoteDetailBookList(this.model.getStageId(), this.model.getSubjectId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initBooksController$9() {
        this.b.refreshLayout.complete();
    }

    private void initCourseList() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda8
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initCourseList$11();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCourseList$11() throws java.lang.Exception {
        com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo wrongNoteBookInfo;
        java.util.List<com.up366.mobile.course.mgr.CourseInfo> listLoadAll = com.up366.mobile.common.logic.Auth.cur().db().getCourseInfoDao().loadAll();
        listLoadAll.add(0, new com.up366.mobile.course.mgr.CourseInfo(-1, "全部"));
        final java.util.ArrayList arrayList = new java.util.ArrayList();
        int courseId = this.model.getCourseId();
        for (com.up366.mobile.course.mgr.CourseInfo courseInfo : listLoadAll) {
            if (courseId == courseInfo.getCourseId()) {
                wrongNoteBookInfo = new com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo(courseInfo.getCourseId() + "", courseInfo.getCourseName(), true);
            } else {
                wrongNoteBookInfo = new com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo(courseInfo.getCourseId() + "", courseInfo.getCourseName(), false);
            }
            arrayList.add(wrongNoteBookInfo);
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initCourseList$10(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setCourseAdapterData, reason: merged with bridge method [inline-methods] */
    public void lambda$initCourseList$10(java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list.isEmpty()) {
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state1).setTipMessage("没有获取到教学班信息哦").build()));
        } else {
            java.util.Iterator<com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(5, it.next()));
            }
        }
        this.adapter.lambda$setDatas$0(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        initMap();
        this.b.llTimeSelect.setVisibility(this.model.isShowTime() ? 0 : 8);
        this.b.llBookList.setVisibility(this.model.isShowBookList() ? 0 : 8);
        this.b.view.setVisibility(this.model.isShowBookList() ? 8 : 0);
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.model.getBeginTimeStr())) {
            this.b.llTimeSelectTitle.setText(this.model.getBeginTimeStr());
        }
        reData();
        int i = this.from;
        if (i == 0) {
            this.b.titleBar.setTitle("筛选生词");
            this.b.llTimeSelectTitle.setText("加入时间");
        } else if (i == 1) {
            this.b.titleBar.setTitle("筛选错题");
            gone(this.b.llNoteType);
            visible(this.b.llTimeSelect);
        } else if (i == 2) {
            this.b.titleBar.setTitle("筛选练习");
            this.b.tvListTitle.setText("选择班级");
            this.b.btnReset.setText("恢复默认");
            gone(this.b.llNoteType, this.b.view);
            visible(this.b.llTimeSelect, this.b.llBookList);
        }
        this.b.titleBar.addRightButton(com.up366.mobile.R.drawable.close_icon, new android.view.View.OnClickListener() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$12(view);
            }
        });
        if (!fromTask()) {
            this.b.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda10
                @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
                public final void onRefresh() {
                    this.f$0.lambda$initView$13();
                }
            });
        }
        this.b.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
        this.b.recycleView.setAdapter(this.adapter);
        this.b.btnReset.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$14(view);
            }
        });
        this.b.btnConfirm.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.commonui.condition.ConditionActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$15(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$12(android.view.View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$13() {
        this.bookController.loadWebData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$14(android.view.View view) {
        int i = this.from;
        if (i == 0) {
            this.model.setDegree(0);
            this.model.setTimeType(0);
            this.model.setBeginTime(com.up366.mobile.common.utils.TimeUtilsApp.dateStrToLong("2010-01-01", "yyyy-MM-dd"));
            this.model.setEndTime(com.up366.mobile.common.utils.TimeUtilsApp.getDayEndTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
            if (this.model.isShowBookList()) {
                this.model.setBookId("0");
            }
        } else if (i == 1) {
            this.model.setTimeType(0);
            this.model.setBeginTime(com.up366.mobile.common.utils.TimeUtilsApp.dateStrToLong("2010-01-01", "yyyy-MM-dd"));
            this.model.setEndTime(com.up366.mobile.common.utils.TimeUtilsApp.getDayEndTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
            if (this.model.isShowBookList()) {
                this.model.setBookId("0");
            }
        } else if (i == 2) {
            this.model.setTimeType(4);
            com.up366.mobile.commonui.condition.ConditionModel conditionModel = this.model;
            conditionModel.setEndTime(conditionModel.getResetEndTime());
            com.up366.mobile.commonui.condition.ConditionModel conditionModel2 = this.model;
            conditionModel2.setBeginTime(conditionModel2.getResetBeginTime());
            this.model.setCourseId(-1);
        }
        reData();
        if (fromTask()) {
            return;
        }
        this.bookController.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$15(android.view.View view) {
        if (this.model.getEndTime() < this.model.getBeginTime()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("起始时间必须早于截止时间");
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(INTENT_KEY_CONDITION_RESULT, this.model);
        setResult(-1, intent);
        finish();
    }

    private void initMap() {
        java.util.HashMap map = new java.util.HashMap();
        this.degreeMap = map;
        map.put(getString(com.up366.mobile.R.string.all), 0);
        this.degreeMap.put(getString(com.up366.mobile.R.string.ren_du), 2);
        this.degreeMap.put(getString(com.up366.mobile.R.string.pin_xie), 3);
        this.degreeMap.put(getString(com.up366.mobile.R.string.yun_yong), 4);
        this.degreeMap.put(getString(com.up366.mobile.R.string.ting_shuo), 1);
        this.degreeMap.put(getString(com.up366.mobile.R.string.qi_ta), 5);
        this.timeMap = new java.util.HashMap();
        if (fromTask()) {
            this.timeMap.put("近一年", 0);
        } else {
            this.timeMap.put("全部", 0);
        }
        this.timeMap.put("今天", 1);
        this.timeMap.put("近一周", 2);
        this.timeMap.put("近一个月", 3);
        this.timeMap.put("自定义", 4);
    }

    private boolean fromTask() {
        return this.from == 2;
    }

    private void reData() {
        gone(this.b.llNoteType);
        int i = this.from;
        if (i == 0) {
            visible(this.b.llNoteType);
        } else if (i == 2) {
            visible(this.b.llTimeSelect, this.b.llBookList);
            this.b.timeBtnAll.setText("近一年");
            if (!this.adapter.getDatas().isEmpty()) {
                refreshCourseAdapterData();
            }
        }
        this.b.dateBtnBegin.setText(com.up366.common.TimeUtils.formatTime(this.model.getBeginTime(), "yyyy-MM-dd"));
        this.b.dateBtnEnd.setText(com.up366.common.TimeUtils.formatTime(this.model.getEndTime(), "yyyy-MM-dd"));
        refreshTypeSelectedState(this.b.noteAll, this.b.noteListen, this.b.noteRead, this.b.noteWrite, this.b.noteUse, this.b.noteOther);
        refreshTimeSelectedState(this.b.timeBtnAll, this.b.timeBtnToday, this.b.timeBtnWeek, this.b.timeBtnMouth, this.b.dateBtnBegin, this.b.dateBtnEnd);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDestroy();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.WrongNoteDetailBookListRefresh wrongNoteDetailBookListRefresh) {
        if (wrongNoteDetailBookListRefresh.getResp().isError()) {
            this.bookController.onLoadWebData(wrongNoteDetailBookListRefresh.getResp(), new java.util.ArrayList());
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo> wrongNoteBookList = wrongNoteDetailBookListRefresh.getWrongNoteBookList();
        if (this.from == 1) {
            arrayList.add(new com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo("0", "全部"));
            arrayList.addAll(wrongNoteBookList);
            arrayList.add(new com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo("WORK", "练习"));
        } else if (wrongNoteBookList.size() == 0) {
            arrayList.add(new com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo("0", "全部"));
        } else {
            arrayList.addAll(wrongNoteBookList);
        }
        this.bookController.onLoadWebData(wrongNoteDetailBookListRefresh.getResp(), arrayList);
    }

    private void refreshCourseAdapterData() {
        java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> datas = this.adapter.getDatas();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> it = datas.iterator();
        while (it.hasNext()) {
            com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo wrongNoteBookInfo = (com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo) it.next().o;
            if (wrongNoteBookInfo.getBookId().equals(java.lang.String.valueOf(this.model.getCourseId()))) {
                wrongNoteBookInfo.setSelect(true);
            } else {
                wrongNoteBookInfo.setSelect(false);
            }
            arrayList.add(wrongNoteBookInfo);
        }
        lambda$initCourseList$10(arrayList);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.BookSelectChange bookSelectChange) {
        if (fromTask()) {
            this.model.setCourseId(java.lang.Integer.parseInt(bookSelectChange.getBookId()));
            refreshCourseAdapterData();
        } else {
            this.model.setBookId(bookSelectChange.getBookId());
            this.bookController.refresh();
        }
    }

    private long getMaxTimeByType() {
        if (fromTask()) {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTimeInMillis(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
            calendar.add(2, 3);
            return calendar.getTimeInMillis();
        }
        return com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
    }

    private long getLastYearTime(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(1, -1);
        return calendar.getTimeInMillis();
    }
}
