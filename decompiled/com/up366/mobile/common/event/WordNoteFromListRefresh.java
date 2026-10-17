package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WordNoteFromListRefresh {
    private final com.up366.common.http.Response resp;
    private final java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo> wordNoteFromInfos;

    public WordNoteFromListRefresh(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo> list) {
        this.resp = response;
        this.wordNoteFromInfos = list;
    }

    public java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo> getWordNoteFromInfos() {
        return this.wordNoteFromInfos;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }
}
