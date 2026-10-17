package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WrongNoteDetailStatInfoRefresh {
    private final com.up366.common.http.Response resp;
    private final com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo wrongNoteStatInfo;

    public WrongNoteDetailStatInfoRefresh(com.up366.common.http.Response response, com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo wrongNoteStatInfo) {
        this.resp = response;
        this.wrongNoteStatInfo = wrongNoteStatInfo;
    }

    public com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo getWrongNoteStatInfo() {
        return this.wrongNoteStatInfo;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }
}
