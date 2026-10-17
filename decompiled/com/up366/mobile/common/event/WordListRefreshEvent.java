package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WordListRefreshEvent {
    private final com.up366.common.http.Response resp;
    private java.lang.String wordId;

    public WordListRefreshEvent(java.lang.String str) {
        this.resp = null;
        this.wordId = str;
    }

    public WordListRefreshEvent(com.up366.common.http.Response response, java.lang.String str) {
        this.resp = response;
        this.wordId = str;
    }

    public java.lang.String getWordId() {
        return this.wordId;
    }

    public void setWordId(java.lang.String str) {
        this.wordId = str;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }
}
