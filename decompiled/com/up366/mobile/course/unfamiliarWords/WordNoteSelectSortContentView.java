package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WordNoteSelectSortContentView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.WordNoteSelectSortBottomSheetViewBinding b;
    private android.content.Context context;
    private int curPage;
    private android.graphics.drawable.Drawable dDown;
    private android.graphics.drawable.Drawable dNone;
    private android.graphics.drawable.Drawable dUp;
    private com.up366.qmui.widget.dialog.QMUIBottomSheet mBottomSheet;
    private java.util.Map<java.lang.String, java.lang.Integer> map;
    private com.up366.mobile.course.unfamiliarWords.SortModel model;

    public WordNoteSelectSortContentView(android.content.Context context) {
        this(context, null);
    }

    public WordNoteSelectSortContentView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WordNoteSelectSortContentView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.WordNoteSelectSortBottomSheetViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.word_note_select_sort_bottom_sheet_view, this, true);
        this.context = context;
        init();
    }

    private void init() {
        java.util.HashMap map = new java.util.HashMap();
        this.map = map;
        map.put(this.context.getString(com.up366.mobile.R.string.all), 0);
        this.map.put(this.context.getString(com.up366.mobile.R.string.ren_du), 2);
        this.map.put(this.context.getString(com.up366.mobile.R.string.pin_xie), 3);
        this.map.put(this.context.getString(com.up366.mobile.R.string.yun_yong), 4);
        this.map.put(this.context.getString(com.up366.mobile.R.string.ting_shuo), 1);
        this.map.put(this.context.getString(com.up366.mobile.R.string.qi_ta), 5);
        this.dNone = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.detail_icon_no_sel);
        this.dUp = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.detail_icon_sel_up);
        this.dDown = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.detail_icon_sel_down);
        android.graphics.drawable.Drawable drawable = this.dNone;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.dNone.getMinimumHeight());
        android.graphics.drawable.Drawable drawable2 = this.dUp;
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), this.dUp.getMinimumHeight());
        android.graphics.drawable.Drawable drawable3 = this.dDown;
        drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), this.dDown.getMinimumHeight());
        this.model = new com.up366.mobile.course.unfamiliarWords.SortModel(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD_TIMES, true, 0);
        refreshOrderState();
        this.b.tvAddCount.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteSelectSortContentView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$0(view);
            }
        });
        this.b.tvCharacterOrder.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteSelectSortContentView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$1(view);
            }
        });
        this.b.tvConfirm.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteSelectSortContentView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$2(view);
            }
        });
        setClickListenerForCategory(this.b.tvAll, this.b.tvRenDu, this.b.tvPinXie, this.b.tvYunYong, this.b.tvTingShuo, this.b.tvQiTa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(android.view.View view) {
        if (android.text.TextUtils.equals(this.model.getOrderField(), com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD_TIMES)) {
            this.model.setOrderDesc(!r3.isOrderDesc());
        } else {
            this.model.setOrderField(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD_TIMES);
            this.model.setOrderDesc(true);
        }
        refreshOrderState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(android.view.View view) {
        if (android.text.TextUtils.equals(this.model.getOrderField(), com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD)) {
            this.model.setOrderDesc(!r2.isOrderDesc());
        } else {
            this.model.setOrderField(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD);
            this.model.setOrderDesc(false);
        }
        refreshOrderState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(android.view.View view) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteSortAndSelectChangeEvent(this.model, this.curPage));
        com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet = this.mBottomSheet;
        if (qMUIBottomSheet != null) {
            qMUIBottomSheet.dismiss();
            return;
        }
        throw new java.lang.IllegalStateException("You need set this content view belongs to which QMBottomSheet");
    }

    public void setCurPage(int i) {
        this.curPage = i;
    }

    public void setModel(com.up366.mobile.course.unfamiliarWords.SortModel sortModel) {
        this.model.setDegree(sortModel.getDegree());
        this.model.setOrderDesc(sortModel.isOrderDesc());
        this.model.setOrderField(sortModel.getOrderField());
        refreshOrderState();
        refreshCategorySelectedState(this.b.tvAll, this.b.tvRenDu, this.b.tvPinXie, this.b.tvYunYong, this.b.tvTingShuo, this.b.tvQiTa);
    }

    private void refreshOrderState() {
        if (android.text.TextUtils.equals(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD_TIMES, this.model.getOrderField())) {
            this.b.tvAddCount.setCompoundDrawables(null, null, this.model.isOrderDesc() ? this.dDown : this.dUp, null);
            this.b.tvCharacterOrder.setCompoundDrawables(null, null, this.dNone, null);
        } else if (android.text.TextUtils.equals(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD, this.model.getOrderField())) {
            this.b.tvCharacterOrder.setCompoundDrawables(null, null, this.model.isOrderDesc() ? this.dDown : this.dUp, null);
            this.b.tvAddCount.setCompoundDrawables(null, null, this.dNone, null);
        }
    }

    private void setClickListenerForCategory(android.widget.TextView... textViewArr) {
        for (android.widget.TextView textView : textViewArr) {
            textView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteSelectSortContentView$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$setClickListenerForCategory$3(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClickListenerForCategory$3(android.view.View view) {
        switch (view.getId()) {
            case com.up366.mobile.R.id.tv_all /* 2131363526 */:
                this.model.setDegree(0);
                break;
            case com.up366.mobile.R.id.tv_pin_xie /* 2131363589 */:
                this.model.setDegree(3);
                break;
            case com.up366.mobile.R.id.tv_qi_ta /* 2131363591 */:
                this.model.setDegree(5);
                break;
            case com.up366.mobile.R.id.tv_ren_du /* 2131363603 */:
                this.model.setDegree(2);
                break;
            case com.up366.mobile.R.id.tv_ting_shuo /* 2131363620 */:
                this.model.setDegree(1);
                break;
            case com.up366.mobile.R.id.tv_yun_yong /* 2131363642 */:
                this.model.setDegree(4);
                break;
        }
        refreshCategorySelectedState(this.b.tvAll, this.b.tvRenDu, this.b.tvPinXie, this.b.tvYunYong, this.b.tvTingShuo, this.b.tvQiTa);
    }

    public void setBottomSheet(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet) {
        this.mBottomSheet = qMUIBottomSheet;
    }

    private void refreshCategorySelectedState(android.widget.TextView... textViewArr) {
        for (android.widget.TextView textView : textViewArr) {
            boolean z = textView.getText() != null && this.map.get(textView.getText().toString()).intValue() == this.model.getDegree();
            textView.setTextColor(androidx.core.content.ContextCompat.getColor(this.context, z ? 2131100561 : com.up366.mobile.R.color.c5));
            textView.setBackground(androidx.core.content.ContextCompat.getDrawable(this.context, z ? com.up366.mobile.R.drawable.bg_round_30dp_c1 : com.up366.mobile.R.drawable.bg_round_30dp_c7));
        }
    }
}
