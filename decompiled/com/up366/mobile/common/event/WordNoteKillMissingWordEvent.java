package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WordNoteKillMissingWordEvent {
    private final com.up366.common.http.Response resp;

    public WordNoteKillMissingWordEvent(com.up366.common.http.Response response) {
        this.resp = response;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }
}
