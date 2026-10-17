package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WrongDetailHeadView extends android.widget.FrameLayout {
    private static volatile boolean showing;
    private com.up366.mobile.databinding.CourseWrongDetailHeadViewBinding binding;
    private boolean isFirst;
    private com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo wrongNoteStatInfo;

    public WrongDetailHeadView(android.content.Context context) {
        super(context);
        this.wrongNoteStatInfo = new com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo();
        this.isFirst = false;
        init();
    }

    public WrongDetailHeadView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.wrongNoteStatInfo = new com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo();
        this.isFirst = false;
        init();
    }

    public WrongDetailHeadView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.wrongNoteStatInfo = new com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo();
        this.isFirst = false;
        init();
    }

    private void init() {
        com.up366.mobile.databinding.CourseWrongDetailHeadViewBinding courseWrongDetailHeadViewBinding = (com.up366.mobile.databinding.CourseWrongDetailHeadViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.course_wrong_detail_head_view, this, true);
        this.binding = courseWrongDetailHeadViewBinding;
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(courseWrongDetailHeadViewBinding.killNum, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.WrongDetailHeadView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$0(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.killYesterdayNum, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.WrongDetailHeadView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(android.view.View view) {
        com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo wrongNoteStatInfo = this.wrongNoteStatInfo;
        if (wrongNoteStatInfo == null) {
            return;
        }
        if (wrongNoteStatInfo.getKilledCount() == 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(this, "暂无错题");
            return;
        }
        com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo wrongNoteStatInfo2 = this.wrongNoteStatInfo;
        android.content.Intent intent = new android.content.Intent(getContext(), (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("stageId", java.lang.Integer.valueOf(wrongNoteStatInfo2.getStageId()));
        jSONObject.put("subjectId", java.lang.Integer.valueOf(wrongNoteStatInfo2.getSubjectId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, wrongNoteStatInfo2.getBookId());
        jSONObject.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
        jSONObject.put("isKill", 1);
        jSONObject.put("killFlag", 0);
        intent.putExtra("exercise_type", com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.WRONG_NOTE_REVIEW);
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
        getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(android.view.View view) {
        com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo wrongNoteStatInfo = this.wrongNoteStatInfo;
        if (wrongNoteStatInfo == null) {
            return;
        }
        if (wrongNoteStatInfo.getKilledCountLately() == 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(view, "暂无错题");
            return;
        }
        com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo wrongNoteStatInfo2 = this.wrongNoteStatInfo;
        android.content.Intent intent = new android.content.Intent(getContext(), (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("stageId", java.lang.Integer.valueOf(wrongNoteStatInfo2.getStageId()));
        jSONObject.put("subjectId", java.lang.Integer.valueOf(wrongNoteStatInfo2.getSubjectId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, wrongNoteStatInfo2.getBookId());
        jSONObject.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
        jSONObject.put("isKill", 1);
        jSONObject.put("killFlag", 1);
        intent.putExtra("exercise_type", com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.WRONG_NOTE_REVIEW);
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
        getContext().startActivity(intent);
    }

    public void setWrongNoteStatInfo(com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo wrongNoteStatInfo, boolean z) {
        if (wrongNoteStatInfo == null) {
            return;
        }
        this.isFirst = z;
        this.wrongNoteStatInfo = wrongNoteStatInfo;
        this.binding.remainNum.setText(java.lang.String.valueOf(wrongNoteStatInfo.getWrongCount()));
        this.binding.killNum.setText(java.lang.String.valueOf(wrongNoteStatInfo.getKilledCount()));
        this.binding.killYesterdayNum.setText(java.lang.String.valueOf(wrongNoteStatInfo.getKilledCountLately()));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.EventShowWrongTip eventShowWrongTip) {
        showTip();
    }

    private synchronized void showTip() {
        if (showing) {
            return;
        }
        showing = true;
        if (com.up366.mobile.common.utils.PreferenceUtils.getBoolean("guide_dialog_wrong_note" + com.up366.mobile.common.logic.Auth.UID(), true)) {
            if (this.isFirst) {
                showGuideTip();
            } else {
                showing = false;
            }
            return;
        }
        showKillTip();
    }

    private void showGuideTip() {
        com.up366.mobile.common.utils.PreferenceUtils.putBoolean("guide_dialog_wrong_note" + com.up366.mobile.common.logic.Auth.UID(), false);
        new com.up366.mobile.common.dialog.GuideDialog.Builder().setLayoutId(com.up366.mobile.R.layout.guide_dialog_word_wrong_note).setFocusViews(new android.view.View[]{findViewById(com.up366.mobile.R.id.v_mask)}).setClick(com.up366.mobile.R.id.tip_image, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.WrongDetailHeadView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showGuideTip$2(view);
            }
        }).build().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showGuideTip$2(android.view.View view) {
        com.up366.common.log.Logger.info("TAG - 2018/12/28 - WrongDetailHeadView - init - GuideDialog");
        showKillTip();
    }

    private void showKillTip() {
        if (this.wrongNoteStatInfo.getWrongCount() < 100) {
            showing = false;
            return;
        }
        if (!com.up366.mobile.common.utils.PreferenceUtils.getBoolean("showKillTip-wrong-note" + com.up366.mobile.common.logic.Auth.UID(), true)) {
            showing = false;
        } else {
            com.up366.mobile.common.dialog.AppDialog.create(getContext()).title("提示").message("你的错题已经超过100道咯，\n要记得及时消灭呦~").setBtnCloseVisibility(8).left("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.WrongDetailHeadView$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.common.views.WrongDetailHeadView.showing = false;
                }
            }).right("不再提醒", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.WrongDetailHeadView$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.common.views.WrongDetailHeadView.lambda$showKillTip$4(view);
                }
            }).show();
        }
    }

    static /* synthetic */ void lambda$showKillTip$4(android.view.View view) {
        showing = false;
        com.up366.mobile.common.utils.PreferenceUtils.putBoolean("showKillTip-wrong-note" + com.up366.mobile.common.logic.Auth.UID(), false);
    }
}
