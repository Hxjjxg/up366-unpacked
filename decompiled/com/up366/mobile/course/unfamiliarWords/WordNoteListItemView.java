package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WordNoteListItemView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.WordNoteListContentItemBinding b;
    private android.content.Context context;
    private int curPage;
    private com.up366.mobile.course.wrongnote.modle.WordNoteInfo mWordNoteInfo;

    static /* synthetic */ void lambda$showDeleteDialog$4(android.content.DialogInterface dialogInterface) {
    }

    static /* synthetic */ void lambda$showDeleteDialog$7(android.view.View view) {
    }

    public WordNoteListItemView(android.content.Context context) {
        this(context, null);
    }

    public WordNoteListItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WordNoteListItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.WordNoteListContentItemBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.word_note_list_content_item, this, true);
        this.context = context;
        init();
    }

    private void init() {
        this.b.ivPlayIcon.setRepeatCount(-1);
        this.b.ivPlayIcon.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListItemView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(android.view.View view) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.EventWordNoteAudioPlay(this.mWordNoteInfo, this.curPage));
    }

    public void setCurPage(int i) {
        this.curPage = i;
    }

    public void setWordNoteInfo(com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo, boolean z, boolean z2) {
        java.lang.String string;
        int color;
        android.graphics.drawable.Drawable drawable;
        this.mWordNoteInfo = wordNoteInfo;
        this.b.tvAddCount.setText(java.lang.String.format(this.context.getString(com.up366.mobile.R.string.add_times), java.lang.Integer.valueOf(this.mWordNoteInfo.getWordTimes())));
        this.b.tvFinishCount.setText(java.lang.String.format(this.context.getString(com.up366.mobile.R.string.finish_times), java.lang.Integer.valueOf(this.mWordNoteInfo.getWordCompletes())));
        this.b.tvWordContent.setText(z2 ? "......" : this.mWordNoteInfo.getWord());
        if (com.up366.common.StringUtils.isEmptyOrNull(this.mWordNoteInfo.getParaphrase())) {
            this.b.tvWordExplain.setText("");
        } else {
            this.b.tvWordExplain.setText(z ? "......" : android.text.Html.fromHtml(this.mWordNoteInfo.getParaphrase()));
        }
        this.b.listItemDragLayout.setEnable(wordNoteInfo.getStatus() == 0);
        this.b.deleteBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListItemView$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setWordNoteInfo$1(view);
            }
        });
        this.b.clContent.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListItemView$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setWordNoteInfo$2(view);
            }
        });
        int degree = this.mWordNoteInfo.getDegree();
        if (degree == 1) {
            string = this.context.getString(com.up366.mobile.R.string.ting_shuo);
            color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.c1);
            drawable = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.bg_word_note_ting_shuo);
        } else if (degree == 2) {
            string = this.context.getString(com.up366.mobile.R.string.ren_du);
            color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.c3);
            drawable = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.bg_word_note_ren_du);
        } else if (degree == 3) {
            string = this.context.getString(com.up366.mobile.R.string.pin_xie);
            color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.c4);
            drawable = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.bg_word_note_pin_xie);
        } else if (degree == 4) {
            string = this.context.getString(com.up366.mobile.R.string.yun_yong);
            color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.c2);
            drawable = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.bg_word_note_yun_yong);
        } else {
            string = this.context.getString(com.up366.mobile.R.string.qi_ta);
            color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.c5);
            drawable = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.bg_word_note_qi_ta);
        }
        this.b.tvWordCategory.setText(string);
        this.b.tvWordCategory.setBackground(drawable);
        this.b.tvWordCategory.setTextColor(color);
        this.b.ivPlayIcon.setVisibility(com.up366.common.StringUtils.isEmptyOrNull(this.mWordNoteInfo.getVoiceFile()) ? 4 : 0);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListItemView$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$setWordNoteInfo$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setWordNoteInfo$1(android.view.View view) {
        showDeleteDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setWordNoteInfo$2(android.view.View view) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SkipWordSourceActivityEvent(this.mWordNoteInfo, this.curPage != 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setWordNoteInfo$3() throws java.lang.Exception {
        int state = this.mWordNoteInfo.getState();
        if (state != -1) {
            if (state == 0) {
                this.b.ivPlayIcon.setMinAndMaxFrame(22, 38);
                this.b.ivPlayIcon.playAnimation();
                return;
            } else if (state != 1 && state != 4) {
                if (state != 9) {
                    return;
                }
                this.b.ivPlayIcon.setMinAndMaxFrame(0, 13);
                this.b.ivPlayIcon.playAnimation();
                return;
            }
        }
        this.b.ivPlayIcon.setMinAndMaxFrame(18, 19);
        this.b.ivPlayIcon.pauseAnimation();
        this.b.ivPlayIcon.setFrame(18);
    }

    private void showDeleteDialog() {
        com.up366.mobile.common.dialog.AppDialog.create(getContext()).title("确认移除").message("确认从生词本中移除吗？移除后不可恢复").setOnDissmissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListItemView$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                com.up366.mobile.course.unfamiliarWords.WordNoteListItemView.lambda$showDeleteDialog$4(dialogInterface);
            }
        }).setBtnCloseVisibility(8).left("确定", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListItemView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showDeleteDialog$6(view);
            }
        }).right("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListItemView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.unfamiliarWords.WordNoteListItemView.lambda$showDeleteDialog$7(view);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeleteDialog$6(android.view.View view) {
        com.up366.mobile.common.logic.Auth.cur().wrongnote().removeWord(this.mWordNoteInfo.getWordId(), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListItemView$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$showDeleteDialog$5(response, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeleteDialog$5(com.up366.common.http.Response response, java.lang.Object obj) {
        if (response.isError()) {
            if (com.up366.mobile.common.utils.ErrorMessageTool.isPoorNetwork(response)) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this, "移除失败：网络原因，请稍后重试！");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this, response);
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(this, "移除成功");
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordListRefreshEvent(this.mWordNoteInfo.getWordId()));
    }
}
