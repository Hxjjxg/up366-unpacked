package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WrongNoteListRefresh {
    private final com.up366.common.http.Response resp;
    private final java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo> wrongNoteList;

    public WrongNoteListRefresh(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo> list) {
        this.resp = response;
        this.wrongNoteList = list;
    }

    public java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo> getWrongNoteList() {
        return this.wrongNoteList;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }
}
