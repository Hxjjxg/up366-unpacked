package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LDXVideoResult {
    private long time;
    private java.lang.String videoId;

    public LDXVideoResult(java.lang.String str, long j) {
        this.videoId = str;
        this.time = j;
    }

    public java.lang.String getVideoId() {
        return this.videoId;
    }

    public long getTime() {
        return this.time;
    }
}
