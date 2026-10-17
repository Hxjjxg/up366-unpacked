package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WrongNoteRankHeadView extends android.widget.FrameLayout implements android.view.View.OnClickListener {
    private com.up366.mobile.databinding.CourseWrongNoteRankHeadViewBinding binding;
    private android.content.Context context;
    int curSelId;
    android.graphics.drawable.Drawable dDown;
    android.graphics.drawable.Drawable dNone;
    android.graphics.drawable.Drawable dUp;
    int noSelectColor;
    boolean orderDesc;
    int selectColor;

    public WrongNoteRankHeadView(android.content.Context context) {
        super(context);
        this.curSelId = 0;
        this.orderDesc = true;
        this.noSelectColor = -6710887;
        this.selectColor = -15686401;
        init();
    }

    public WrongNoteRankHeadView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.curSelId = 0;
        this.orderDesc = true;
        this.noSelectColor = -6710887;
        this.selectColor = -15686401;
        init();
    }

    public WrongNoteRankHeadView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.curSelId = 0;
        this.orderDesc = true;
        this.noSelectColor = -6710887;
        this.selectColor = -15686401;
        init();
    }

    private void init() {
        this.context = getContext();
        this.binding = (com.up366.mobile.databinding.CourseWrongNoteRankHeadViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.course_wrong_note_rank_head_view, this, true);
        this.dNone = this.context.getDrawable(com.up366.mobile.R.drawable.detail_icon_no_sel);
        this.dUp = this.context.getDrawable(com.up366.mobile.R.drawable.detail_icon_sel_up);
        this.dDown = this.context.getDrawable(com.up366.mobile.R.drawable.detail_icon_sel_down);
        android.graphics.drawable.Drawable drawable = this.dNone;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.dNone.getMinimumHeight());
        android.graphics.drawable.Drawable drawable2 = this.dUp;
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), this.dUp.getMinimumHeight());
        android.graphics.drawable.Drawable drawable3 = this.dDown;
        drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), this.dDown.getMinimumHeight());
        this.curSelId = com.up366.mobile.R.id.wrong_count;
        resetDrawables();
        this.binding.wrongCount.setCompoundDrawables(null, null, this.dUp, null);
        this.binding.killCount.setOnClickListener(this);
        this.binding.killRecentCount.setOnClickListener(this);
        this.binding.tvRankName.setOnClickListener(this);
        this.binding.wrongCount.setOnClickListener(this);
    }

    private void resetDrawables() {
        this.binding.tvRankName.setTextColor(this.noSelectColor);
        this.binding.wrongCount.setTextColor(this.noSelectColor);
        this.binding.killCount.setTextColor(this.noSelectColor);
        this.binding.killRecentCount.setTextColor(this.noSelectColor);
        this.binding.tvRankName.setCompoundDrawables(null, null, this.dNone, null);
        this.binding.wrongCount.setCompoundDrawables(null, null, this.dNone, null);
        this.binding.killCount.setCompoundDrawables(null, null, this.dNone, null);
        this.binding.killRecentCount.setCompoundDrawables(null, null, this.dNone, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLayoutParams().width = -1;
        requestLayout();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (view.getId() == this.curSelId) {
            this.orderDesc = !this.orderDesc;
        } else {
            this.curSelId = view.getId();
            this.orderDesc = true;
        }
        orderDatasByType();
    }

    private void orderDatasByType() {
        resetDrawables();
        switch (this.curSelId) {
            case com.up366.mobile.R.id.kill_count /* 2131362668 */:
                this.binding.killCount.setCompoundDrawables(null, null, this.orderDesc ? this.dUp : this.dDown, null);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WrongNoteRankOrderRefresh("killedCount", this.orderDesc));
                break;
            case com.up366.mobile.R.id.kill_recent_count /* 2131362671 */:
                this.binding.killRecentCount.setCompoundDrawables(null, null, this.orderDesc ? this.dUp : this.dDown, null);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WrongNoteRankOrderRefresh(com.up366.mobile.common.event.WrongNoteRankOrderRefresh.TANK_TYPE_TODAY_KILLED_COUNT, this.orderDesc));
                break;
            case com.up366.mobile.R.id.tv_rank_name /* 2131363593 */:
                this.binding.tvRankName.setCompoundDrawables(null, null, this.orderDesc ? this.dUp : this.dDown, null);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WrongNoteRankOrderRefresh(com.up366.mobile.common.event.WrongNoteRankOrderRefresh.RANK_TYPE_NAME, this.orderDesc));
                break;
            case com.up366.mobile.R.id.wrong_count /* 2131363765 */:
                this.binding.wrongCount.setCompoundDrawables(null, null, this.orderDesc ? this.dUp : this.dDown, null);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WrongNoteRankOrderRefresh(com.up366.mobile.common.event.WrongNoteRankOrderRefresh.RANK_TYPE_WRONG_COUNT, this.orderDesc));
                break;
        }
    }
}
