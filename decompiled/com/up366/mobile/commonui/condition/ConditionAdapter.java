package com.up366.mobile.commonui.condition;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class ConditionAdapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    public static final int TYPE_BOOKS_BTN = 5;

    ConditionAdapter() {
    }

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == 5) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.commonui.condition.BooksSelectView(viewGroup.getContext()));
        }
        return defaultHandler(viewGroup, i);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
        if (dataHolder.viewType == 5) {
            ((com.up366.mobile.commonui.condition.BooksSelectView) viewHolder.itemView).setBookInfo((com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo) dataHolder.o);
        } else {
            defaultHandler(viewHolder, i);
        }
    }
}
