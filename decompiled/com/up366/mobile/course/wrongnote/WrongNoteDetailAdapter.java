package com.up366.mobile.course.wrongnote;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WrongNoteDetailAdapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    public static final int TYPE_TITLE_TAB = 5;
    public static final int TYPE_WRONG_SORT = 6;

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.WrongDetailHeadView(viewGroup.getContext()));
        }
        if (i == 1) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.WrongDetailItemView(viewGroup.getContext()));
        }
        if (i == 5) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.course.unfamiliarWords.WordNoteListTitleView(viewGroup.getContext()));
        }
        if (i == 6) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.WrongNoteSortTypeView(viewGroup.getContext()));
        }
        return defaultHandler(viewGroup, i);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
        int i2 = dataHolder.viewType;
        if (i2 == 0) {
            ((com.up366.mobile.common.views.WrongDetailHeadView) viewHolder.itemView).setWrongNoteStatInfo((com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo) dataHolder.o, ((java.lang.Boolean) dataHolder.o2).booleanValue());
            return;
        }
        if (i2 == 1) {
            ((com.up366.mobile.common.views.WrongDetailItemView) viewHolder.itemView).setInfo((com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo) dataHolder.o, (com.up366.mobile.commonui.condition.ConditionModel) dataHolder.o2);
        } else if (i2 == 5) {
            ((com.up366.mobile.course.unfamiliarWords.WordNoteListTitleView) viewHolder.itemView).setNoteNum((android.text.SpannableStringBuilder) dataHolder.o, (com.up366.mobile.commonui.condition.ConditionModel) dataHolder.o2, (com.up366.mobile.course.wrongnote.WrongNoteDetailFragment) dataHolder.o3);
        } else {
            defaultHandler(viewHolder, i);
        }
    }
}
