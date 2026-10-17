package com.up366.mobile.course.wrongnote;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WrongNoteActivity extends com.up366.mobile.common.base.BaseActivity {
    private static final java.lang.String BOOK_ID = "WRONG_NOTE";
    public static final java.lang.String INTENT_WRONG_SUBJECT = "wrong_note_subject";
    private int assignId;
    private com.up366.mobile.databinding.ActivityWrongnoteBinding b;
    private int courseId;
    private boolean isCurJob;
    private int position;
    private java.lang.String studyTaskId;
    private java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo> wrongNoteList;
    private java.util.List<com.up366.mobile.course.wrongnote.WrongNoteDetailFragment> fragments = new java.util.ArrayList();
    private int subjectId = 0;
    private int stageId = 0;
    private java.lang.String bookName = "错题本";
    private int type = 1;
    private int fromType = 0;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "smartroom_wrong";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.b = (com.up366.mobile.databinding.ActivityWrongnoteBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_wrongnote);
        initIntent();
        initView();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void reportEnterEvent() {
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.BOOK_HOME, "wrongnote", com.up366.mobile.common.onlinelog.OpLogData.Event.ENTER_PAGE, (androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject>) new androidx.core.util.Consumer() { // from class: com.up366.mobile.course.wrongnote.WrongNoteActivity$$ExternalSyntheticLambda4
            public final void accept(java.lang.Object obj) {
                ((com.alibaba.fastjson.JSONObject) obj).put("bookid", com.up366.mobile.course.wrongnote.WrongNoteActivity.BOOK_ID);
            }
        });
    }

    private void initIntent() {
        android.content.Intent intent = getIntent();
        this.wrongNoteList = (java.util.List) intent.getSerializableExtra(INTENT_WRONG_SUBJECT);
        this.subjectId = intent.getIntExtra("subjectId", 0);
        this.stageId = intent.getIntExtra("stageId", 0);
        this.type = intent.getIntExtra("type", 1);
        this.fromType = intent.getIntExtra("fromType", 0);
        if (this.type == 2) {
            this.bookName = intent.getStringExtra("bookName");
        }
        if (this.fromType == 1) {
            this.isCurJob = intent.getBooleanExtra("isCurJob", false);
            this.courseId = intent.getIntExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, -1);
            this.studyTaskId = intent.getStringExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID);
            this.assignId = intent.getIntExtra("assignId", 0);
        }
    }

    private void initView() {
        if (this.fromType == 0) {
            java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo> list = this.wrongNoteList;
            if (list == null || list.size() == 0) {
                gone(this.b.emptyView);
                showWrongSubjectTab();
            } else {
                visible(this.b.qmTabLayout, this.b.bottomView);
                gone(this.b.emptyView);
                if (this.wrongNoteList.size() == 1) {
                    gone(this.b.qmTabLayout);
                }
                showWrongSubjectTab();
            }
        } else {
            if (this.type == 2) {
                gone(this.b.ibRankingList);
            }
            gone(this.b.qmTabLayout);
            showWrongSubjectTab();
        }
        if (this.type == 2) {
            this.b.toolbarLayout.setTitle(this.bookName);
        }
        this.b.ibRankingList.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$1(view);
            }
        });
        this.b.bottomView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$1(android.view.View view) {
        android.content.Intent intent = new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.course.wrongnote.WrongNoteRankActivity.class);
        com.up366.mobile.commonui.condition.ConditionModel model = this.fragments.get(this.position).getModel();
        if (model != null) {
            intent.putExtra("stageId", model.getStageId());
            intent.putExtra("subjectId", model.getSubjectId());
        } else {
            intent.putExtra("stageId", this.stageId);
            intent.putExtra("subjectId", this.subjectId);
        }
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(android.view.View view) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.up366.mobile.commonui.condition.ConditionModel model = this.fragments.get(this.position).getModel();
        if (model != null) {
            jSONObject.put("stageId", java.lang.Integer.valueOf(model.getStageId()));
            jSONObject.put("subjectId", java.lang.Integer.valueOf(model.getSubjectId()));
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, model.getBookId());
            jSONObject.put("startTime", 0 == model.getBeginTime() ? "" : java.lang.Long.valueOf(model.getBeginTime()));
            jSONObject.put("endTime", 0 != model.getEndTime() ? java.lang.Long.valueOf(model.getEndTime()) : "");
        } else {
            jSONObject.put("stageId", java.lang.Integer.valueOf(this.stageId));
            jSONObject.put("subjectId", java.lang.Integer.valueOf(this.subjectId));
        }
        jSONObject.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
        jSONObject.put("fromJob", java.lang.Boolean.valueOf(this.fromType == 1));
        jSONObject.put("isCurJob", java.lang.Boolean.valueOf(this.isCurJob));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(this.courseId));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, this.studyTaskId);
        int i = this.assignId;
        if (i > 0) {
            jSONObject.put("assignId", java.lang.Integer.valueOf(i));
        }
        android.content.Intent intent = new android.content.Intent(view.getContext(), (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("exercise_type", "wrongnote");
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
        startActivity(intent);
    }

    public void setBottomViewVisible(boolean z) {
        this.b.bottomView.setVisibility(z ? 0 : 8);
    }

    private void showWrongSubjectTab() {
        this.fragments.clear();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo> list = this.wrongNoteList;
        if (list != null && list.size() != 0) {
            int i = 0;
            while (i < this.wrongNoteList.size()) {
                arrayList.add(this.wrongNoteList.get(i).getSubjectName());
                this.fragments.add(com.up366.mobile.course.wrongnote.WrongNoteDetailFragment.newInstance(this.wrongNoteList.get(i).getSubjectId(), this.wrongNoteList.get(i).getStageId(), i == 0));
                i++;
            }
        } else {
            this.fragments.add(com.up366.mobile.course.wrongnote.WrongNoteDetailFragment.newInstance(this.subjectId, this.stageId, true));
            this.b.qmTabLayout.setVisibility(8);
        }
        com.up366.mobile.course.wrongnote.WrongNoteDetailPagerAdapter wrongNoteDetailPagerAdapter = new com.up366.mobile.course.wrongnote.WrongNoteDetailPagerAdapter(getSupportFragmentManager());
        wrongNoteDetailPagerAdapter.setFragments(this.fragments);
        this.b.viewPager.setAdapter(wrongNoteDetailPagerAdapter);
        final androidx.core.util.Supplier supplier = new androidx.core.util.Supplier() { // from class: com.up366.mobile.course.wrongnote.WrongNoteActivity$$ExternalSyntheticLambda2
            public final java.lang.Object get() {
                return this.f$0.lambda$showWrongSubjectTab$3();
            }
        };
        this.b.viewPager.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.OnPageChangeListener() { // from class: com.up366.mobile.course.wrongnote.WrongNoteActivity.1
            public void onPageScrollStateChanged(int i2) {
            }

            public void onPageScrolled(int i2, float f, int i3) {
            }

            public void onPageSelected(int i2) {
                com.up366.mobile.course.wrongnote.WrongNoteActivity.this.position = i2;
                ((com.up366.mobile.course.wrongnote.WrongNoteDetailFragment) com.up366.mobile.course.wrongnote.WrongNoteActivity.this.fragments.get(i2)).setPosition(i2, supplier);
                ((com.up366.mobile.course.wrongnote.WrongNoteDetailFragment) com.up366.mobile.course.wrongnote.WrongNoteActivity.this.fragments.get(i2)).setBottomViewVisible();
            }
        });
        this.b.viewPager.setOffscreenPageLimit(this.fragments.size() > 1 ? this.fragments.size() - 1 : 1);
        this.b.viewPager.setCurrentItem(0);
        setTabData(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Integer lambda$showWrongSubjectTab$3() {
        return java.lang.Integer.valueOf(this.position);
    }

    public void setPullRecyclerView(com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, androidx.recyclerview.widget.RecyclerView recyclerView) {
        new com.up366.mobile.common.helper.AppBarRefreshLayoutHelper().binding(this.b.appBar, pullRefreshLayout, recyclerView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setTabData(java.util.List<java.lang.String> list) {
        this.b.qmTabLayout.reset();
        com.up366.qmui.widget.tab.QMUITabBuilder typeface = this.b.qmTabLayout.tabBuilder().setNormalColor(getResources().getColor(com.up366.mobile.R.color.c5)).setSelectColor(getResources().getColor(com.up366.mobile.R.color.font_c4)).setTypeface(android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, 0), android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, 1));
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            this.b.qmTabLayout.addTab(typeface.setText(it.next()).build(this));
        }
        int iDp2px = com.up366.qmui.util.QMUIDisplayHelper.dp2px(this, 20);
        com.up366.mobile.common.views.QMUITabIndicatorV2 qMUITabIndicatorV2 = new com.up366.mobile.common.views.QMUITabIndicatorV2();
        qMUITabIndicatorV2.setmIndicatorHeight(com.up366.qmui.util.QMUIDisplayHelper.dp2px(this, 12)).setmIndicatorWidth(com.up366.qmui.util.QMUIDisplayHelper.dp2px(this, 24)).setmIndicatorTop(false).setmIsIndicatorWidthFollowContent(false).setmFixedColorAttr(-1).setmShouldReGetFixedColor(false);
        this.b.qmTabLayout.setIndicator(qMUITabIndicatorV2);
        this.b.qmTabLayout.setMode(0);
        this.b.qmTabLayout.setItemSpaceInScrollMode(iDp2px);
        this.b.qmTabLayout.setupWithViewPager(this.b.viewPager, false);
        this.b.qmTabLayout.setPadding(iDp2px, 0, iDp2px, 0);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void reportPageDuration(final long j) {
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.BOOK_HOME, "wrongnote", com.up366.mobile.common.onlinelog.OpLogData.Event.LEAVE_PAGE, (androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject>) new androidx.core.util.Consumer() { // from class: com.up366.mobile.course.wrongnote.WrongNoteActivity$$ExternalSyntheticLambda3
            public final void accept(java.lang.Object obj) {
                this.f$0.lambda$reportPageDuration$4(j, (com.alibaba.fastjson.JSONObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportPageDuration$4(long j, com.alibaba.fastjson.JSONObject jSONObject) {
        jSONObject.put("bookid", BOOK_ID);
        jSONObject.put("entertime", java.lang.Long.valueOf(this.staticEnterTime));
        jSONObject.put("duration", java.lang.Long.valueOf(j));
    }
}
