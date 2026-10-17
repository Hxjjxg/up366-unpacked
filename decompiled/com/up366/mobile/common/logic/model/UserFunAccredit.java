package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UserFunAccredit {
    private long addTime;
    private long beginTime;
    private long endTime;
    private java.lang.String func;
    private java.lang.String funcId;
    private long startTime;

    public long getAddTime() {
        return this.addTime;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(long j) {
        this.beginTime = j;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public java.lang.String getFunc() {
        return this.func;
    }

    public void setFunc(java.lang.String str) {
        this.func = str;
    }

    public java.lang.String getFuncId() {
        return this.funcId;
    }

    public void setFuncId(java.lang.String str) {
        this.funcId = str;
    }

    public java.lang.String toString() {
        return "UserFunAccredit{addTime=" + this.addTime + ", beginTime=" + this.beginTime + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", func='" + this.func + "', funcId='" + this.funcId + "'}";
    }
}
