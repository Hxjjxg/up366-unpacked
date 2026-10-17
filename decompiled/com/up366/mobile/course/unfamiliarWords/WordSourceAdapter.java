package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WordSourceAdapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    public static final int TYPE_WORD_NOT_FOUND = -7;

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == -7) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.EmptyStateView(viewGroup.getContext()));
        }
        if (i == 0) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.course.unfamiliarWords.WordSourceHeaderView(viewGroup.getContext()));
        }
        if (i == 1) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.course.unfamiliarWords.WordSourceContentItemView(viewGroup.getContext()));
        }
        return defaultHandler(viewGroup, i);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
        int i2 = dataHolder.viewType;
        if (i2 == -7) {
            ((com.up366.mobile.common.views.EmptyStateView) viewHolder.itemView).setData((com.up366.mobile.common.views.viewmodel.EmptyViewModel) dataHolder.o);
            return;
        }
        if (i2 == 0) {
            ((com.up366.mobile.course.unfamiliarWords.WordSourceHeaderView) viewHolder.itemView).setWordInfo((com.up366.mobile.course.wrongnote.modle.WordNoteInfo) dataHolder.o, (com.up366.mobile.book.helper.CommonAudioHelper) dataHolder.o2);
        } else if (i2 == 1) {
            ((com.up366.mobile.course.unfamiliarWords.WordSourceContentItemView) viewHolder.itemView).setWordInfo((com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo) dataHolder.o);
        } else {
            defaultHandler(viewHolder, i);
        }
    }
}
