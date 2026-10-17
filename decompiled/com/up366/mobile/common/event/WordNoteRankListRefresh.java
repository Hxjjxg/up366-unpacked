package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WordNoteRankListRefresh {
    private final com.up366.common.http.Response resp;
    private final java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo> wordNoteRankInfos;

    public WordNoteRankListRefresh(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo> list) {
        this.resp = response;
        this.wordNoteRankInfos = list;
    }

    public java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo> getWordNoteRankInfos() {
        return this.wordNoteRankInfos;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }
}
