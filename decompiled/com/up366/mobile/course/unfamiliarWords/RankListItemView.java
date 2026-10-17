package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class RankListItemView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.RankListItemViewBinding b;
    private android.content.Context context;

    public RankListItemView(android.content.Context context) {
        this(context, null);
    }

    public RankListItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RankListItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.RankListItemViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.rank_list_item_view, this, true);
        this.context = context;
    }

    public void setWordNoteRankInfo(com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo wordNoteRankInfo, int i) {
        if (i == 0) {
            this.b.ivRank.setImageResource(com.up366.mobile.R.drawable.rank_1);
            this.b.ivRank.setVisibility(0);
            this.b.tvRank.setVisibility(8);
        } else if (i == 1) {
            this.b.ivRank.setImageResource(com.up366.mobile.R.drawable.rank_2);
            this.b.ivRank.setVisibility(0);
            this.b.tvRank.setVisibility(8);
        } else if (i == 2) {
            this.b.ivRank.setImageResource(com.up366.mobile.R.drawable.rank_3);
            this.b.ivRank.setVisibility(0);
            this.b.tvRank.setVisibility(8);
        } else {
            this.b.ivRank.setVisibility(8);
            this.b.tvRank.setVisibility(0);
            if (i < 9) {
                this.b.tvRank.setText("0" + (i + 1));
            } else {
                this.b.tvRank.setText(java.lang.String.valueOf(i + 1));
            }
        }
        this.b.tvRankName.setText(wordNoteRankInfo.getRealname());
        this.b.tvRemainCount.setText(java.lang.String.valueOf(wordNoteRankInfo.getWordCount()));
        this.b.tvHasDestroyCount.setText(java.lang.String.valueOf(wordNoteRankInfo.getKilledCount()));
        this.b.tvTodayDestroyCount.setText(java.lang.String.valueOf(wordNoteRankInfo.getKilledCountLately()));
        if (wordNoteRankInfo.getUid() == com.up366.mobile.common.logic.Auth.getUserInfo().getUid()) {
            this.b.bgLayout.setBackgroundResource(com.up366.mobile.R.drawable.bg_wrong_rank_own_shape);
        } else {
            this.b.bgLayout.setBackgroundColor(androidx.core.content.ContextCompat.getColor(this.context, 2131100561));
        }
    }
}
