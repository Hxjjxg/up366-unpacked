package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WrongNoteDetailListRefresh {
    private final com.up366.common.http.Response resp;
    private final java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo> wrongNoteKnowledgeList;

    public WrongNoteDetailListRefresh(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo> list) {
        this.resp = response;
        this.wrongNoteKnowledgeList = list;
    }

    public java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo> getWrongNoteKnowledgeList() {
        return this.wrongNoteKnowledgeList;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }
}
