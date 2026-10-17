package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WordSourceContentItemView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.WordSourceContentItemBinding b;
    private android.content.Context context;
    private com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo info;

    public WordSourceContentItemView(android.content.Context context) {
        this(context, null);
    }

    public WordSourceContentItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WordSourceContentItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.WordSourceContentItemBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.word_source_content_item, this, true);
        this.context = context;
        init();
    }

    private void init() {
        this.b.foldContainer.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceContentItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(android.view.View view) {
        if (this.info.isDetailShown()) {
            this.b.ivArrow.setImageResource(com.up366.mobile.R.drawable.icon_drop_down2);
            this.b.foldContainer.setPadding(0, 0, 0, com.up366.common.DpUtilsUp.dp2px(20.0f));
            this.b.llContainer.setVisibility(8);
            this.info.setDetailShown(false);
        } else {
            this.b.ivArrow.setImageResource(com.up366.mobile.R.drawable.icon_drop_up2);
            this.b.foldContainer.setPadding(0, 0, 0, com.up366.common.DpUtilsUp.dp2px(12.0f));
            this.b.llContainer.setVisibility(0);
            this.info.setDetailShown(true);
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceContentItemView$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordSourceItemDetailShownChangedEvent());
            }
        });
    }

    private java.lang.String getFromTypeText(int i) {
        if (i == 1) {
            return "过词块";
        }
        if (i == 2) {
            return "听力原文";
        }
        if (i == 3) {
            return "词典";
        }
        if (i == 4) {
            return "教材学练";
        }
        return "其他";
    }

    public void setWordInfo(final com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo wordNoteFromInfo) {
        this.info = wordNoteFromInfo;
        if (wordNoteFromInfo.isDetailShown()) {
            this.b.ivArrow.setImageResource(com.up366.mobile.R.drawable.icon_drop_up2);
            this.b.llContainer.setVisibility(0);
        } else {
            this.b.ivArrow.setImageResource(com.up366.mobile.R.drawable.icon_drop_down2);
            this.b.llContainer.setVisibility(8);
        }
        this.b.tvAddTime.setText(java.lang.String.format("加入时间:%s", com.up366.mobile.common.utils.TimeUtilsApp.formatTime(wordNoteFromInfo.getAddTime(), "yyyy-MM-dd")));
        this.b.tvSourceType.setText(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("来源类型:").setSpan(new android.text.style.ForegroundColorSpan(androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.textGray))).append(getFromTypeText(wordNoteFromInfo.getFromType())).setSpan(new android.text.style.ForegroundColorSpan(androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.font_c4))).build());
        if (com.up366.common.StringUtils.isEmptyOrNull(wordNoteFromInfo.getFromMemo())) {
            this.b.tvAbstract.setVisibility(8);
            return;
        }
        com.up366.mobile.common.utils.SpannableStringBuilderUtil span = new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("内容:").setSpan(new android.text.style.ForegroundColorSpan(androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.textGray))).append(wordNoteFromInfo.getFromMemo()).setSpan(new android.text.style.ForegroundColorSpan(androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.font_c4)));
        if (wordNoteFromInfo.getFromType() == 2) {
            span.append("题目详情").setSpan(new android.text.style.ClickableSpan() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceContentItemView.1
                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(android.text.TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(androidx.core.content.ContextCompat.getColor(com.up366.mobile.course.unfamiliarWords.WordSourceContentItemView.this.context, com.up366.mobile.R.color.c1));
                    textPaint.setUnderlineText(true);
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(android.view.View view) {
                    if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                        com.up366.mobile.common.utils.ToastPopupUtil.showError(view, com.up366.mobile.course.unfamiliarWords.WordSourceContentItemView.this.context.getString(com.up366.mobile.R.string.no_network_try_later_again));
                        return;
                    }
                    android.content.Intent intent = new android.content.Intent(com.up366.mobile.course.unfamiliarWords.WordSourceContentItemView.this.getContext(), (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
                    com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                    jSONObject.put("questionId", wordNoteFromInfo.getQstId());
                    jSONObject.put(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD, wordNoteFromInfo.getWord());
                    jSONObject.put("wordId", wordNoteFromInfo.getWordId());
                    intent.putExtra("exercise_type", com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.QUESTION_TEXT);
                    intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
                    com.up366.mobile.course.unfamiliarWords.WordSourceContentItemView.this.getContext().startActivity(intent);
                }
            });
        }
        this.b.tvAbstract.setText(span.build());
        this.b.tvAbstract.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
    }
}
