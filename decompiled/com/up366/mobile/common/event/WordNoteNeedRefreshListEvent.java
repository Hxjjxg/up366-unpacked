package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WordNoteNeedRefreshListEvent {
    private int curPage;
    private com.up366.mobile.course.unfamiliarWords.SortModel data;

    public WordNoteNeedRefreshListEvent(int i, com.up366.mobile.course.unfamiliarWords.SortModel sortModel) {
        this.curPage = i;
        this.data = sortModel;
    }

    public int getCurPage() {
        return this.curPage;
    }

    public void setCurPage(int i) {
        this.curPage = i;
    }

    public com.up366.mobile.course.unfamiliarWords.SortModel getData() {
        return this.data;
    }

    public void setData(com.up366.mobile.course.unfamiliarWords.SortModel sortModel) {
        this.data = sortModel;
    }
}
