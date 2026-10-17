package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WrongNoteRankListRefresh {
    private final com.up366.common.http.Response resp;
    private final java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo> wrongNoteRankList;

    public WrongNoteRankListRefresh(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo> list) {
        this.resp = response;
        this.wrongNoteRankList = list;
    }

    public java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo> getWrongNoteRankList() {
        return this.wrongNoteRankList;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }
}
