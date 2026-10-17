package com.up366.mobile.book.helper.recorder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsecSessionModel {
    public static final int STATE_ERROR = 3;
    public static final int STATE_SCORING = 1;
    public static final int STATE_SUCCESS = 2;
    public static final int STATE_WAIT = 0;
    private long addTime;
    private int cbType;
    private long duration;
    private int errCount;
    private java.lang.String fingerprintJsonFilepath;
    private java.lang.String netFiles;
    private java.lang.String params;
    private java.lang.String recordId;
    private java.lang.String result;
    private java.lang.Long rowId;
    private int state;
    private int type;
    private java.lang.String wavPath;

    public AsecSessionModel() {
    }

    public AsecSessionModel(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, long j, java.lang.Integer num, java.util.List<com.up366.asecengine.model.KeyValue> list) {
        this.recordId = str;
        this.type = i;
        this.netFiles = str2;
        this.wavPath = str3;
        this.duration = j;
        this.addTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        if (num == null) {
            this.cbType = 0;
        } else {
            this.cbType = num.intValue();
        }
        this.params = com.alibaba.fastjson.JSON.toJSONString(list);
    }

    public AsecSessionModel(java.lang.Long l, java.lang.String str, int i, java.lang.String str2, java.lang.String str3, long j, int i2, java.lang.String str4, int i3, long j2, java.lang.String str5, int i4, java.lang.String str6) {
        this.rowId = l;
        this.recordId = str;
        this.type = i;
        this.netFiles = str2;
        this.wavPath = str3;
        this.duration = j;
        this.state = i2;
        this.result = str4;
        this.errCount = i3;
        this.addTime = j2;
        this.params = str5;
        this.cbType = i4;
        this.fingerprintJsonFilepath = str6;
    }

    public java.lang.String getRecordId() {
        return this.recordId;
    }

    public void setRecordId(java.lang.String str) {
        this.recordId = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public java.lang.String getNetFiles() {
        return this.netFiles;
    }

    public void setNetFiles(java.lang.String str) {
        this.netFiles = str;
    }

    public java.lang.String getWavPath() {
        return this.wavPath;
    }

    public void setWavPath(java.lang.String str) {
        this.wavPath = str;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public java.lang.String getResult() {
        return this.result;
    }

    public void setResult(java.lang.String str) {
        this.result = str;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public int getErrCount() {
        return this.errCount;
    }

    public void setErrCount(int i) {
        this.errCount = i;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }

    public int getCbType() {
        return this.cbType;
    }

    public void setCbType(int i) {
        this.cbType = i;
    }

    public java.lang.String getParams() {
        return this.params;
    }

    public void setParams(java.lang.String str) {
        this.params = str;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public java.lang.String getFingerprintJsonFilepath() {
        return this.fingerprintJsonFilepath;
    }

    public void setFingerprintJsonFilepath(java.lang.String str) {
        this.fingerprintJsonFilepath = str;
    }
}
