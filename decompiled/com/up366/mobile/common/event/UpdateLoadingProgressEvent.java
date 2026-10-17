package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UpdateLoadingProgressEvent {
    private java.lang.String key;
    private int progress;

    public UpdateLoadingProgressEvent(java.lang.String str, int i) {
        this.progress = i;
        this.key = str;
    }

    public int getProgress() {
        return this.progress;
    }

    public java.lang.String getKey() {
        return this.key;
    }
}
