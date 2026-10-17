package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WrongNoteSortTypeView extends android.widget.FrameLayout {
    public static boolean orderDesc = true;
    public static int type = 3;
    private com.up366.mobile.databinding.ViewWrongNoteSortTypeBinding binding;
    int curSelId;
    android.graphics.drawable.Drawable dDown;
    android.graphics.drawable.Drawable dNone;
    android.graphics.drawable.Drawable dUp;
    int noSelectColor;
    int selectColor;

    public WrongNoteSortTypeView(android.content.Context context) {
        this(context, null);
    }

    public WrongNoteSortTypeView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WrongNoteSortTypeView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.curSelId = 0;
        this.noSelectColor = -6710887;
        this.selectColor = -10453250;
        this.binding = (com.up366.mobile.databinding.ViewWrongNoteSortTypeBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.view_wrong_note_sort_type, this, true);
        initDrawable(context);
        resetDrawables();
        this.curSelId = this.binding.wrongCount.getId();
        this.binding.wrongCount.setTextColor(this.selectColor);
        this.binding.wrongCount.setCompoundDrawables(null, null, this.dDown, null);
        this.binding.knowledge.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.WrongNoteSortTypeView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.onClickView(view);
            }
        });
        this.binding.queType.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.WrongNoteSortTypeView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.onClickView(view);
            }
        });
        this.binding.wrongCount.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.WrongNoteSortTypeView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.onClickView(view);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLayoutParams().width = -1;
        requestLayout();
    }

    private void initDrawable(android.content.Context context) {
        this.dNone = context.getDrawable(com.up366.mobile.R.drawable.icon_arrow_double_gray);
        this.dUp = context.getDrawable(com.up366.mobile.R.drawable.icon_arrow_double_blue_up);
        this.dDown = context.getDrawable(com.up366.mobile.R.drawable.icon_arrow_double_blue_down);
        android.graphics.drawable.Drawable drawable = this.dNone;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.dNone.getMinimumHeight());
        android.graphics.drawable.Drawable drawable2 = this.dUp;
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), this.dUp.getMinimumHeight());
        android.graphics.drawable.Drawable drawable3 = this.dDown;
        drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), this.dDown.getMinimumHeight());
    }

    private void resetDrawables() {
        this.binding.queType.setTextColor(this.noSelectColor);
        this.binding.knowledge.setTextColor(this.noSelectColor);
        this.binding.wrongCount.setTextColor(this.noSelectColor);
        this.binding.queType.setCompoundDrawables(null, null, this.dNone, null);
        this.binding.knowledge.setCompoundDrawables(null, null, this.dNone, null);
        this.binding.wrongCount.setCompoundDrawables(null, null, this.dNone, null);
    }

    public void onClickView(android.view.View view) {
        if (view.getId() == this.curSelId) {
            orderDesc = !orderDesc;
        } else {
            this.curSelId = view.getId();
            orderDesc = true;
        }
        orderDatasByType();
    }

    private void orderDatasByType() {
        resetDrawables();
        int i = this.curSelId;
        if (i == 2131362673) {
            this.binding.knowledge.setTextColor(this.selectColor);
            this.binding.knowledge.setCompoundDrawables(null, null, orderDesc ? this.dUp : this.dDown, null);
            type = 2;
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WrongNoteDetailOrderRefresh());
            return;
        }
        if (i == 2131363047) {
            this.binding.queType.setTextColor(this.selectColor);
            this.binding.queType.setCompoundDrawables(null, null, orderDesc ? this.dUp : this.dDown, null);
            type = 1;
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WrongNoteDetailOrderRefresh());
            return;
        }
        if (i != 2131363765) {
            return;
        }
        this.binding.wrongCount.setTextColor(this.selectColor);
        this.binding.wrongCount.setCompoundDrawables(null, null, orderDesc ? this.dDown : this.dUp, null);
        type = 3;
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WrongNoteDetailOrderRefresh());
    }
}
