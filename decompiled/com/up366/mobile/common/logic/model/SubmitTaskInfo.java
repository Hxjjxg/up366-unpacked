package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SubmitTaskInfo {
    private double score;
    private java.lang.String studyTaskId;
    private long submitTime;
    private java.lang.String taskId;

    public SubmitTaskInfo(java.lang.String str, java.lang.String str2, double d, long j) {
        this.taskId = str;
        this.studyTaskId = str2;
        this.score = d;
        this.submitTime = j;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public java.lang.String getStudyTaskId() {
        return this.studyTaskId;
    }

    public void setStudyTaskId(java.lang.String str) {
        this.studyTaskId = str;
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double d) {
        this.score = d;
    }

    public long getSubmitTime() {
        return this.submitTime;
    }

    public void setSubmitTime(long j) {
        this.submitTime = j;
    }
}
