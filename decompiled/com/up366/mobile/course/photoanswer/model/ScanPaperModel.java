package com.up366.mobile.course.photoanswer.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class ScanPaperModel {
    private final long createTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
    private java.lang.String curWebViewId;
    private java.lang.String fromType;
    private java.lang.String jobName;
    private java.lang.String paperId;

    public java.lang.String getPaperId() {
        return this.paperId;
    }

    public void setPaperId(java.lang.String str) {
        this.paperId = str;
    }

    public java.lang.String getJobName() {
        return this.jobName;
    }

    public void setJobName(java.lang.String str) {
        this.jobName = str;
    }

    public java.lang.String getFromType() {
        return this.fromType;
    }

    public void setFromType(java.lang.String str) {
        this.fromType = str;
    }

    public java.lang.String getPaperIdSubmitKey() {
        return this.paperId + "_" + this.createTime;
    }

    public java.lang.String getCurWebViewId() {
        return this.curWebViewId;
    }

    public void setCurWebViewId(java.lang.String str) {
        this.curWebViewId = str;
    }

    public long getCreateTime() {
        return this.createTime;
    }
}
