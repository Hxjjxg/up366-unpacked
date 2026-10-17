package com.up366.mobile.course.task.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskCompletedInfo {
    private long addDate;
    private int courseId;
    private java.lang.String jobScore;
    private int markStatus;
    private java.lang.Long rowId;
    private float score;
    private java.lang.String studyTaskId;
    private java.lang.String studyTaskPid;
    private int uid;

    public TaskCompletedInfo(java.lang.Long l, int i, int i2, java.lang.String str, java.lang.String str2, float f, java.lang.String str3, long j, int i3) {
        this.rowId = l;
        this.uid = i;
        this.courseId = i2;
        this.studyTaskId = str;
        this.studyTaskPid = str2;
        this.score = f;
        this.jobScore = str3;
        this.addDate = j;
        this.markStatus = i3;
    }

    public TaskCompletedInfo() {
    }

    public java.lang.String toString() {
        return "TaskCompletedInfo{rowId=" + this.rowId + ", uid=" + this.uid + ", courseId=" + this.courseId + ", studyTaskId='" + this.studyTaskId + "', studyTaskPid='" + this.studyTaskPid + "', score=" + this.score + ", jobScore='" + this.jobScore + "', addDate=" + this.addDate + ", markStatus=" + this.markStatus + '}';
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

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public java.lang.String getStudyTaskId() {
        return this.studyTaskId;
    }

    public void setStudyTaskId(java.lang.String str) {
        this.studyTaskId = str;
    }

    public java.lang.String getStudyTaskPid() {
        return this.studyTaskPid;
    }

    public void setStudyTaskPid(java.lang.String str) {
        this.studyTaskPid = str;
    }

    public float getScore() {
        return this.score;
    }

    public void setScore(float f) {
        this.score = f;
    }

    public java.lang.String getJobScore() {
        return this.jobScore;
    }

    public void setJobScore(java.lang.String str) {
        this.jobScore = str;
    }

    public long getAddDate() {
        return this.addDate;
    }

    public void setAddDate(long j) {
        this.addDate = j;
    }

    public int getMarkStatus() {
        return this.markStatus;
    }

    public void setMarkStatus(int i) {
        this.markStatus = i;
    }
}
