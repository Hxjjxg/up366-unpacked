package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WordNoteRankOrderStateChangeEvent {
    private com.up366.mobile.course.unfamiliarWords.RankListSortStateModel model;

    public WordNoteRankOrderStateChangeEvent(com.up366.mobile.course.unfamiliarWords.RankListSortStateModel rankListSortStateModel) {
        this.model = rankListSortStateModel;
    }

    public com.up366.mobile.course.unfamiliarWords.RankListSortStateModel getModel() {
        return this.model;
    }
}
