package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SkipWordSourceActivityEvent {
    private com.up366.mobile.course.wrongnote.modle.WordNoteInfo info;
    private boolean killedWord;

    public SkipWordSourceActivityEvent(com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo, boolean z) {
        this.info = wordNoteInfo;
        this.killedWord = z;
    }

    public com.up366.mobile.course.wrongnote.modle.WordNoteInfo getInfo() {
        return this.info;
    }

    public boolean isKilledWord() {
        return this.killedWord;
    }
}
