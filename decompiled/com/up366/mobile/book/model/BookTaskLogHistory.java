package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookTaskLogHistory {
    private java.lang.String guid;
    private long insertTime;
    private byte[] logData;
    private java.lang.Long rowId;
    private java.lang.String taskId;

    public BookTaskLogHistory(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) {
        this.guid = batchUploadLog.getBatchId();
        this.taskId = batchUploadLog.getRefKey();
        this.insertTime = java.lang.System.currentTimeMillis();
        try {
            this.logData = com.up366.common.ZipStringUtils.gzip(batchUploadLog.toString().getBytes());
        } catch (java.lang.Exception e) {
            com.up366.mobile.common.onlinelog.OpLog.report("ERROR-save-log-history", e.getMessage(), e);
        }
    }

    public BookTaskLogHistory() {
    }

    public BookTaskLogHistory(java.lang.Long l, java.lang.String str, java.lang.String str2, long j, byte[] bArr) {
        this.rowId = l;
        this.guid = str;
        this.taskId = str2;
        this.insertTime = j;
        this.logData = bArr;
    }

    public void setGuid(java.lang.String str) {
        this.guid = str;
    }

    public java.lang.String getGuid() {
        return this.guid;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public long getInsertTime() {
        return this.insertTime;
    }

    public void setInsertTime(long j) {
        this.insertTime = j;
    }

    public byte[] getLogData() {
        return this.logData;
    }

    public void setLogData(byte[] bArr) {
        this.logData = bArr;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }
}
