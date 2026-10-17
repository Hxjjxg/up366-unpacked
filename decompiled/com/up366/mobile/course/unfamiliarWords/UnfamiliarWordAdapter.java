package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class UnfamiliarWordAdapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    public static final int TYPE_HIDE_EN = 6;
    public static final int TYPE_TITLE_TAB = 5;
    private int curPage;

    public void setCurPage(int i) {
        this.curPage = i;
    }

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.course.unfamiliarWords.WordNoteListHeaderView(viewGroup.getContext()));
        }
        if (i == 1) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.course.unfamiliarWords.WordNoteListItemView(viewGroup.getContext()));
        }
        if (i == 5) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.course.unfamiliarWords.WordNoteListTitleView(viewGroup.getContext()));
        }
        if (i == 6) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.course.unfamiliarWords.WordNoteListSortItemView(viewGroup.getContext()));
        }
        return defaultHandler(viewGroup, i);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
        int i2 = dataHolder.viewType;
        if (i2 == 0) {
            ((com.up366.mobile.course.unfamiliarWords.WordNoteListHeaderView) viewHolder.itemView).setWordNoteStateInfo((com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo) dataHolder.o);
            return;
        }
        if (i2 == 1) {
            ((com.up366.mobile.course.unfamiliarWords.WordNoteListItemView) viewHolder.itemView).setCurPage(this.curPage);
            ((com.up366.mobile.course.unfamiliarWords.WordNoteListItemView) viewHolder.itemView).setWordNoteInfo((com.up366.mobile.course.wrongnote.modle.WordNoteInfo) dataHolder.o, ((java.lang.Boolean) dataHolder.o2).booleanValue(), ((java.lang.Boolean) dataHolder.o3).booleanValue());
        } else if (i2 == 5) {
            ((com.up366.mobile.course.unfamiliarWords.WordNoteListTitleView) viewHolder.itemView).setNoteNum((android.text.SpannableStringBuilder) dataHolder.o, (com.up366.mobile.commonui.condition.ConditionModel) dataHolder.o2);
        } else if (i2 == 6) {
            ((com.up366.mobile.course.unfamiliarWords.WordNoteListSortItemView) viewHolder.itemView).setCurPage(this.curPage);
            ((com.up366.mobile.course.unfamiliarWords.WordNoteListSortItemView) viewHolder.itemView).setSortModel((com.up366.mobile.course.unfamiliarWords.SortModel) dataHolder.o);
        } else {
            defaultHandler(viewHolder, i);
        }
    }
}
