package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WordNoteListHeaderView extends android.widget.FrameLayout {
    private static boolean hasShowKillTip;
    private final com.up366.mobile.databinding.WordNoteListHeaderItemBinding b;
    private com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo statInfo;

    static /* synthetic */ void lambda$showKillTip$5(android.view.View view) {
    }

    public WordNoteListHeaderView(android.content.Context context) {
        this(context, null);
    }

    public WordNoteListHeaderView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WordNoteListHeaderView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.WordNoteListHeaderItemBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.word_note_list_header_item, this, true);
    }

    public void setWordNoteStateInfo(final com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo wrongNoteStatInfo) {
        if (wrongNoteStatInfo == null) {
            return;
        }
        this.statInfo = wrongNoteStatInfo;
        this.b.tvRemainCount.setText(java.lang.String.valueOf(wrongNoteStatInfo.getWordCount()));
        this.b.tvHasKilledCount.setText(java.lang.String.valueOf(wrongNoteStatInfo.getKilledCount()));
        this.b.tvHasKilledCount.setClickable(wrongNoteStatInfo.getKilledCount() > 0);
        this.b.tvTodayKilledCount.setText(java.lang.String.valueOf(wrongNoteStatInfo.getKilledCountLately()));
        this.b.tvTodayKilledCount.setClickable(wrongNoteStatInfo.getKilledCountLately() > 0);
        this.b.tvHasKilledCount.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListHeaderView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setWordNoteStateInfo$0(wrongNoteStatInfo, view);
            }
        });
        this.b.tvTodayKilledCount.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListHeaderView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setWordNoteStateInfo$1(wrongNoteStatInfo, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setWordNoteStateInfo$0(com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo wrongNoteStatInfo, android.view.View view) {
        if (wrongNoteStatInfo.getKilledCount() > 0) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SkipKilledEvent(0, this.statInfo.getKilledCount()));
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.show(view, getContext().getString(com.up366.mobile.R.string.no_unfamiliar_word));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setWordNoteStateInfo$1(com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo wrongNoteStatInfo, android.view.View view) {
        if (wrongNoteStatInfo.getKilledCountLately() > 0) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SkipKilledEvent(1, this.statInfo.getKilledCountLately()));
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.show(view, getContext().getString(com.up366.mobile.R.string.no_unfamiliar_word));
        }
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
    public void onMessageEvent(com.up366.mobile.common.event.EventShowWordTip eventShowWordTip) {
        showTip();
    }

    private void showTip() {
        if (com.up366.mobile.common.utils.PreferenceUtils.getBoolean("guide_dialog_word_note" + com.up366.mobile.common.logic.Auth.UID(), true)) {
            showGuideTip();
        } else {
            if (this.statInfo.getWordCount() == 0) {
                return;
            }
            if (com.up366.mobile.common.utils.PreferenceUtils.getBoolean("UnfamiliarWordActivity_showTip", true)) {
                showNoteTipDialog();
            } else {
                showKillTip();
            }
        }
    }

    private void showGuideTip() {
        new com.up366.mobile.common.dialog.GuideDialog.Builder().setLayoutId(com.up366.mobile.R.layout.guide_dialog_word_wrong_note).setFocusViews(new android.view.View[]{this.b.vMask}).setClick(com.up366.mobile.R.id.tip_image, new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListHeaderView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showGuideTip$2(view);
            }
        }).build().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showGuideTip$2(android.view.View view) {
        com.up366.mobile.common.utils.PreferenceUtils.putBoolean("guide_dialog_word_note" + com.up366.mobile.common.logic.Auth.UID(), false);
        if (com.up366.mobile.common.utils.PreferenceUtils.getBoolean("UnfamiliarWordActivity_showTip", true)) {
            showNoteTipDialog();
        }
        com.up366.common.log.Logger.info("TAG - 2018/12/28 - WordNoteListHeaderView - init - GuideDialog");
    }

    private void showNoteTipDialog() {
        com.up366.mobile.common.utils.PreferenceUtils.putBoolean("UnfamiliarWordActivity_showTip", false);
        com.up366.mobile.common.dialog.AppDialog.create(getContext()).title("说明").message(getContext().getResources().getString(com.up366.mobile.R.string.word_reversion_tip)).setMessageLeft().btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListHeaderView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showNoteTipDialog$3(view);
            }
        }).btnClose(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListHeaderView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showNoteTipDialog$4(view);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNoteTipDialog$3(android.view.View view) {
        showKillTip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNoteTipDialog$4(android.view.View view) {
        showKillTip();
    }

    private void showKillTip() {
        if (this.statInfo.getWordCount() < 100) {
            return;
        }
        if (com.up366.mobile.common.utils.PreferenceUtils.getBoolean("showKillTip-word-note" + com.up366.mobile.common.logic.Auth.UID(), true) && !hasShowKillTip) {
            hasShowKillTip = true;
            com.up366.mobile.common.dialog.AppDialog.create(getContext()).title("提示").message("你的生词已经超过100个咯，\n要记得及时消灭呦~").setBtnCloseVisibility(8).left("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListHeaderView$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.course.unfamiliarWords.WordNoteListHeaderView.lambda$showKillTip$5(view);
                }
            }).right("不再提醒", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListHeaderView$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.common.utils.PreferenceUtils.putBoolean("showKillTip-word-note" + com.up366.mobile.common.logic.Auth.UID(), false);
                }
            }).show();
        }
    }
}
