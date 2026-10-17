package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WordNoteKilledListRefresh {
    private final com.up366.common.http.Response resp;
    private final java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> result;

    public WordNoteKilledListRefresh(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> list) {
        this.resp = response;
        this.result = list;
    }

    public java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> getResult() {
        return this.result;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }
}
