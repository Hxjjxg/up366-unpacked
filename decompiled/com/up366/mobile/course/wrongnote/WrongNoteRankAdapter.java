package com.up366.mobile.course.wrongnote;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WrongNoteRankAdapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.WrongNoteRankHeadView(viewGroup.getContext()));
        }
        if (i == 1) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.WrongNoteRankItemView(viewGroup.getContext()));
        }
        return defaultHandler(viewGroup, i);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
        if (dataHolder.viewType == 1) {
            ((com.up366.mobile.common.views.WrongNoteRankItemView) viewHolder.itemView).setWrongNoteRankInfo((com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo) dataHolder.o, i);
        } else {
            defaultHandler(viewHolder, i);
        }
    }
}
