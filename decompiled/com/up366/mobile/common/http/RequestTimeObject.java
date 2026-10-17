package com.up366.mobile.common.http;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RequestTimeObject {
    private java.lang.String key;
    private java.lang.String params;
    private java.lang.Long rowId;
    private long time;

    public RequestTimeObject() {
    }

    public RequestTimeObject(java.lang.String str, java.lang.String str2, long j) {
        this.key = str;
        this.params = str2;
        this.time = j;
    }

    public RequestTimeObject(java.lang.Long l, java.lang.String str, java.lang.String str2, long j) {
        this.rowId = l;
        this.key = str;
        this.params = str2;
        this.time = j;
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public void setKey(java.lang.String str) {
        this.key = str;
    }

    public java.lang.String getParams() {
        return this.params;
    }

    public void setParams(java.lang.String str) {
        this.params = str;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }
}
