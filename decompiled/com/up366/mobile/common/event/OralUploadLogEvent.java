package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OralUploadLogEvent {
    private final java.lang.String errInfo;
    private final int flag;
    private final long overFileSize;
    private final long totalFileSize;

    public OralUploadLogEvent(java.lang.String str, int i, long j, long j2) {
        this.errInfo = str;
        this.overFileSize = j;
        this.totalFileSize = j2;
        this.flag = i;
    }

    public boolean isSuccess() {
        return this.flag == 3;
    }

    public boolean isProgressUpdate() {
        int i = this.flag;
        return (i == 3 || i == 4) ? false : true;
    }

    public boolean isFailed() {
        return this.flag == 4;
    }

    public java.lang.String getErrInfo() {
        return this.errInfo;
    }

    public int getPercent() {
        long j = this.totalFileSize;
        if (j == 0) {
            return 0;
        }
        return (int) ((this.overFileSize * 100) / j);
    }

    public long getOverFileSize() {
        return this.overFileSize;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }

    public int getFlag() {
        return this.flag;
    }
}
