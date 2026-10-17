package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WordNoteListTitleView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.WordNoteListTitleItemBinding b;
    private android.content.Context mContext;

    public WordNoteListTitleView(android.content.Context context) {
        this(context, null);
    }

    public WordNoteListTitleView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WordNoteListTitleView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.WordNoteListTitleItemBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.word_note_list_title_item, this, true);
        this.mContext = context;
    }

    public void setNoteNum(android.text.SpannableStringBuilder spannableStringBuilder, final com.up366.mobile.commonui.condition.ConditionModel conditionModel) {
        this.b.NoteTitleNum.setText(spannableStringBuilder);
        this.b.selectBtn.setChecked(!conditionModel.isOriginallyCondition());
        this.b.selectBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListTitleView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setNoteNum$0(conditionModel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNoteNum$0(com.up366.mobile.commonui.condition.ConditionModel conditionModel, android.view.View view) {
        android.content.Intent intent = new android.content.Intent(this.mContext, (java.lang.Class<?>) com.up366.mobile.commonui.condition.ConditionActivity.class);
        intent.putExtra(com.up366.mobile.commonui.condition.ConditionActivity.INTENT_KEY_CONDITION_MODEL, conditionModel);
        intent.putExtra(com.up366.mobile.commonui.condition.ConditionActivity.INTENT_KEY_CONDITION_FROM, conditionModel.getFrom());
        ((android.app.Activity) this.mContext).startActivityForResult(intent, 10000);
    }

    public void setNoteNum(android.text.SpannableStringBuilder spannableStringBuilder, final com.up366.mobile.commonui.condition.ConditionModel conditionModel, final com.up366.mobile.course.wrongnote.WrongNoteDetailFragment wrongNoteDetailFragment) {
        this.b.NoteTitleNum.setText(spannableStringBuilder);
        this.b.selectBtn.setChecked(!conditionModel.isOriginallyCondition());
        this.b.selectBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListTitleView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.unfamiliarWords.WordNoteListTitleView.lambda$setNoteNum$1(wrongNoteDetailFragment, conditionModel, view);
            }
        });
    }

    static /* synthetic */ void lambda$setNoteNum$1(com.up366.mobile.course.wrongnote.WrongNoteDetailFragment wrongNoteDetailFragment, com.up366.mobile.commonui.condition.ConditionModel conditionModel, android.view.View view) {
        android.content.Intent intent = new android.content.Intent(wrongNoteDetailFragment.getContext(), (java.lang.Class<?>) com.up366.mobile.commonui.condition.ConditionActivity.class);
        intent.putExtra(com.up366.mobile.commonui.condition.ConditionActivity.INTENT_KEY_CONDITION_MODEL, conditionModel);
        intent.putExtra(com.up366.mobile.commonui.condition.ConditionActivity.INTENT_KEY_CONDITION_FROM, conditionModel.getFrom());
        wrongNoteDetailFragment.startActivityForResult(intent, 10001);
    }
}
