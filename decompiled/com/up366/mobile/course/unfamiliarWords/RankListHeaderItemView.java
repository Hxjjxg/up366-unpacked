package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class RankListHeaderItemView extends android.widget.FrameLayout implements android.view.View.OnClickListener {
    private com.up366.mobile.databinding.RankListHeaderItemBinding b;
    private android.content.Context context;
    private android.graphics.drawable.Drawable dDown;
    private android.graphics.drawable.Drawable dNone;
    private android.graphics.drawable.Drawable dUp;
    private int mTextSelectColor;
    private int mTextUnSelectColor;
    private com.up366.mobile.course.unfamiliarWords.RankListSortStateModel model;

    public RankListHeaderItemView(android.content.Context context) {
        this(context, null);
    }

    public RankListHeaderItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RankListHeaderItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.RankListHeaderItemBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.rank_list_header_item, this, true);
        this.context = context;
        init();
    }

    private void init() {
        this.dNone = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.detail_icon_no_sel);
        this.dUp = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.detail_icon_sel_up);
        this.dDown = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.detail_icon_sel_down);
        android.graphics.drawable.Drawable drawable = this.dNone;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.dNone.getMinimumHeight());
        android.graphics.drawable.Drawable drawable2 = this.dUp;
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), this.dUp.getMinimumHeight());
        android.graphics.drawable.Drawable drawable3 = this.dDown;
        drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), this.dDown.getMinimumHeight());
        this.mTextSelectColor = androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.c1);
        this.mTextUnSelectColor = androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.c5);
        this.model = new com.up366.mobile.course.unfamiliarWords.RankListSortStateModel(false, com.up366.mobile.course.unfamiliarWords.RankListSortStateModel.TYPE_REMAIN_WORD_COUNT);
        refreshState();
        this.b.flRemainWord.setOnClickListener(this);
        this.b.flHasDestroyWord.setOnClickListener(this);
        this.b.flTodayDestroyWord.setOnClickListener(this);
    }

    private void refreshState() {
        java.lang.String orderField = this.model.getOrderField();
        orderField.hashCode();
        switch (orderField) {
            case "wordCount":
                this.b.tvRemainWord.setTextColor(this.mTextSelectColor);
                this.b.tvRemainWord.setCompoundDrawables(null, null, this.model.isOrderDesc() ? this.dDown : this.dUp, null);
                unSelectOrderField(this.b.tvHasDestroyWord, this.b.tvTodayDestroyWord);
                break;
            case "killedCountLately":
                this.b.tvTodayDestroyWord.setTextColor(this.mTextSelectColor);
                this.b.tvTodayDestroyWord.setCompoundDrawables(null, null, this.model.isOrderDesc() ? this.dDown : this.dUp, null);
                unSelectOrderField(this.b.tvHasDestroyWord, this.b.tvRemainWord);
                break;
            case "killedCount":
                this.b.tvHasDestroyWord.setTextColor(this.mTextSelectColor);
                this.b.tvHasDestroyWord.setCompoundDrawables(null, null, this.model.isOrderDesc() ? this.dDown : this.dUp, null);
                unSelectOrderField(this.b.tvRemainWord, this.b.tvTodayDestroyWord);
                break;
        }
    }

    private void unSelectOrderField(android.widget.TextView... textViewArr) {
        for (android.widget.TextView textView : textViewArr) {
            textView.setTextColor(this.mTextUnSelectColor);
            textView.setCompoundDrawables(null, null, this.dNone, null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == 2131362457) {
            if (android.text.TextUtils.equals("killedCount", this.model.getOrderField())) {
                this.model.setOrderDesc(!r3.isOrderDesc());
            } else {
                this.model.setOrderField("killedCount");
                this.model.setOrderDesc(true);
            }
            refreshState();
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteRankOrderStateChangeEvent(this.model));
            return;
        }
        if (id == 2131362460) {
            if (android.text.TextUtils.equals(com.up366.mobile.course.unfamiliarWords.RankListSortStateModel.TYPE_REMAIN_WORD_COUNT, this.model.getOrderField())) {
                this.model.setOrderDesc(!r3.isOrderDesc());
            } else {
                this.model.setOrderField(com.up366.mobile.course.unfamiliarWords.RankListSortStateModel.TYPE_REMAIN_WORD_COUNT);
                this.model.setOrderDesc(false);
            }
            refreshState();
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteRankOrderStateChangeEvent(this.model));
            return;
        }
        if (id != 2131362464) {
            return;
        }
        if (android.text.TextUtils.equals(com.up366.mobile.course.unfamiliarWords.RankListSortStateModel.TYPE_TODAY_KILLED_COUNT, this.model.getOrderField())) {
            this.model.setOrderDesc(!r3.isOrderDesc());
        } else {
            this.model.setOrderField(com.up366.mobile.course.unfamiliarWords.RankListSortStateModel.TYPE_TODAY_KILLED_COUNT);
            this.model.setOrderDesc(true);
        }
        refreshState();
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteRankOrderStateChangeEvent(this.model));
    }
}
