package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WrongNoteDetailBookListRefresh {
    private final com.up366.common.http.Response resp;
    private final java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo> wrongNoteBookList;

    public WrongNoteDetailBookListRefresh(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo> list) {
        this.resp = response;
        this.wrongNoteBookList = list;
    }

    public java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo> getWrongNoteBookList() {
        return this.wrongNoteBookList;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }
}
