package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class EventWordNoteAudioPlay {
    private int curPage;
    private com.up366.mobile.course.wrongnote.modle.WordNoteInfo data;

    public EventWordNoteAudioPlay(com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo) {
        this.data = wordNoteInfo;
    }

    public EventWordNoteAudioPlay(com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo, int i) {
        this.data = wordNoteInfo;
        this.curPage = i;
    }

    public com.up366.mobile.course.wrongnote.modle.WordNoteInfo getData() {
        return this.data;
    }

    public int getCurPage() {
        return this.curPage;
    }
}
