package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonUploadLogEvent {
    private final java.lang.String batchId;
    private final int errCode;
    private final java.lang.String errInfo;
    private final long overFileSize;
    private final java.lang.String params;
    private final java.lang.String refKey;
    private final int state;
    private final long totalFileSize;
    private final int type;

    public CommonUploadLogEvent(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        this.batchId = batchUploadLog.getBatchId();
        this.state = batchUploadLog.getState();
        this.errCode = batchUploadLog.getErrCode();
        this.errInfo = batchUploadLog.getErrInfo();
        this.refKey = batchUploadLog.getRefKey();
        this.type = batchUploadLog.getType();
        this.overFileSize = batchUploadLog.getUploadFileSize();
        this.totalFileSize = batchUploadLog.getTotalFileSize();
        this.params = batchUploadLog.getParams();
        com.up366.common.log.Logger.info(toString());
    }

    public int getFlag() {
        return this.state;
    }

    public boolean isSuccess() {
        return this.state == 2;
    }

    public boolean isProgressUpdate() {
        return this.state == 1;
    }

    public boolean isFailed() {
        return this.state == -1;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public java.lang.String getErrInfo() {
        return this.errInfo;
    }

    public java.lang.String getRefKey() {
        return this.refKey;
    }

    public int getPercent() {
        long j = this.totalFileSize;
        if (j == 0) {
            return 0;
        }
        long j2 = this.overFileSize;
        if (j2 > j) {
            return 100;
        }
        return (int) ((j2 * 100) / j);
    }

    public int getType() {
        return this.type;
    }

    public java.lang.String getBatchId() {
        return this.batchId;
    }

    public int getState() {
        return this.state;
    }

    public long getOverFileSize() {
        return this.overFileSize;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }

    public java.lang.String getParams() {
        return this.params;
    }

    public java.lang.String toString() {
        return "CommonUploadLogEvent{batchId='" + this.batchId + "', state=" + this.state + ", errCode=" + this.errCode + ", errInfo='" + this.errInfo + "', refKey='" + this.refKey + "', type=" + this.type + ", overFileSize=" + this.overFileSize + ", totalFileSize=" + this.totalFileSize + ", params='" + this.params + "'}";
    }
}
