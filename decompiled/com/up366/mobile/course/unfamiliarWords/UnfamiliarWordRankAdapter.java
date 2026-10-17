package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class UnfamiliarWordRankAdapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    public static final int TYPE_HEADER_PIC = -7;

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == -7) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(com.up366.mobile.R.layout.rank_list_header_pic_item));
        }
        if (i == 0) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.course.unfamiliarWords.RankListHeaderItemView(viewGroup.getContext()));
        }
        if (i == 1) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.course.unfamiliarWords.RankListItemView(viewGroup.getContext()));
        }
        return defaultHandler(viewGroup, i);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
        if (dataHolder.viewType == 1) {
            ((com.up366.mobile.course.unfamiliarWords.RankListItemView) viewHolder.itemView).setWordNoteRankInfo((com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo) dataHolder.o, i - 2);
        } else {
            defaultHandler(viewHolder, i);
        }
    }
}
