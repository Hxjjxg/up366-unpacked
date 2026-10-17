package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WrongNoteRankItemView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.CourseWordNoteRankItemViewBinding binding;
    private android.content.Context context;

    public WrongNoteRankItemView(android.content.Context context) {
        super(context);
        init();
    }

    public WrongNoteRankItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WrongNoteRankItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.context = getContext();
        this.binding = (com.up366.mobile.databinding.CourseWordNoteRankItemViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.course_word_note_rank_item_view, this, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLayoutParams().width = -1;
        requestLayout();
    }

    public void setWrongNoteRankInfo(com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo wrongNoteRankInfo, int i) {
        if (i == 1) {
            this.binding.ivRankNo.setVisibility(0);
            this.binding.tvNo.setVisibility(8);
            this.binding.ivRankNo.setImageResource(com.up366.mobile.R.drawable.ranking_list_first);
        } else if (i == 2) {
            this.binding.ivRankNo.setVisibility(0);
            this.binding.tvNo.setVisibility(8);
            this.binding.ivRankNo.setImageResource(com.up366.mobile.R.drawable.ranking_list_second);
        } else if (i == 3) {
            this.binding.ivRankNo.setVisibility(0);
            this.binding.tvNo.setVisibility(8);
            this.binding.ivRankNo.setImageResource(com.up366.mobile.R.drawable.ranking_list_third);
        } else {
            this.binding.ivRankNo.setVisibility(8);
            this.binding.tvNo.setVisibility(0);
            this.binding.tvNo.setText(java.lang.String.valueOf(i));
        }
        this.binding.tvName.setText(wrongNoteRankInfo.getRealname());
        this.binding.tvWrongCount.setText(java.lang.String.valueOf(wrongNoteRankInfo.getWrongCount()));
        this.binding.tvKilledCount.setText(java.lang.String.valueOf(wrongNoteRankInfo.getKilledCount()));
        this.binding.tvKilledCountLately.setText(java.lang.String.valueOf(wrongNoteRankInfo.getRecentKilledCount()));
        if (wrongNoteRankInfo.getUid() == com.up366.mobile.common.logic.Auth.getUserInfo().getUid()) {
            this.binding.rankLL.setBackgroundResource(com.up366.mobile.R.drawable.bg_wrong_rank_own_shape);
        } else {
            this.binding.rankLL.setBackgroundColor(this.context.getResources().getColor(2131100561));
        }
    }
}
