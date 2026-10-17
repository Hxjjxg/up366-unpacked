package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SpeechDataInfo {
    private java.lang.String data;
    private java.lang.String data1;
    private java.lang.String guid;
    private java.lang.Long rowId;

    public SpeechDataInfo() {
    }

    public SpeechDataInfo(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.guid = str;
        this.data = str2;
        this.data1 = str3;
    }

    public SpeechDataInfo(java.lang.Long l, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.rowId = l;
        this.guid = str;
        this.data = str2;
        this.data1 = str3;
    }

    public java.lang.String getGuid() {
        return this.guid;
    }

    public void setGuid(java.lang.String str) {
        this.guid = str;
    }

    public java.lang.String getData() {
        return this.data;
    }

    public void setData(java.lang.String str) {
        this.data = str;
    }

    public java.lang.String getData1() {
        return this.data1;
    }

    public void setData1(java.lang.String str) {
        this.data1 = str;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }
}
