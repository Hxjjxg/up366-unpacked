package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyTaskJsonMapInfo extends com.up366.mobile.common.logic.model.DBModel {
    public long addTime;
    public long expireTime;
    public java.lang.String jobId;
    public java.lang.String json;
    public long rowId;

    public StudyTaskJsonMapInfo() {
    }

    public StudyTaskJsonMapInfo(java.lang.String str, java.lang.String str2) {
        this.jobId = str;
        this.json = str2;
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        this.addTime = currentNtpTimeInMillisecond;
        this.expireTime = currentNtpTimeInMillisecond + com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3;
    }

    public java.lang.String toString() {
        return "StudyTaskJsonMapInfo{rowId=" + this.rowId + ", jobId='" + this.jobId + "', json='" + this.json + "', expireTime=" + this.expireTime + ", addTime=" + this.addTime + '}';
    }

    public long getRowId() {
        return this.rowId;
    }

    public void setRowId(long j) {
        this.rowId = j;
    }

    public java.lang.String getJobId() {
        return this.jobId;
    }

    public void setJobId(java.lang.String str) {
        this.jobId = str;
    }

    public java.lang.String getJson() {
        return this.json;
    }

    public void setJson(java.lang.String str) {
        this.json = str;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(long j) {
        this.expireTime = j;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }
}
