package com.up366.mobile.course.task.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class ReturnedInfo {
    private int courseId;
    private java.lang.String returnCode;
    private java.lang.Long rowId;
    private java.lang.String studyTaskId;
    private int uid;

    public ReturnedInfo(java.lang.Long l, int i, java.lang.String str, int i2, java.lang.String str2) {
        this.rowId = l;
        this.uid = i;
        this.studyTaskId = str;
        this.courseId = i2;
        this.returnCode = str2;
    }

    public ReturnedInfo() {
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public java.lang.String getStudyTaskId() {
        return this.studyTaskId;
    }

    public void setStudyTaskId(java.lang.String str) {
        this.studyTaskId = str;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public java.lang.String getReturnCode() {
        return this.returnCode;
    }

    public void setReturnCode(java.lang.String str) {
        this.returnCode = str;
    }
}
