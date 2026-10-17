package com.up366.mobile.course.task.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskScoreTrend {
    private float avgGlobal;
    private float avgOrgan;
    private java.lang.String courseId;
    private long endTime;
    private float globalRank;
    private float organRank;
    private float scorePercent;
    private java.lang.String studyTaskId;
    private java.lang.String studyTaskName;

    public java.lang.String getStudyTaskId() {
        return this.studyTaskId;
    }

    public void setStudyTaskId(java.lang.String str) {
        this.studyTaskId = str;
    }

    public java.lang.String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(java.lang.String str) {
        this.courseId = str;
    }

    public java.lang.String getStudyTaskName() {
        return this.studyTaskName;
    }

    public void setStudyTaskName(java.lang.String str) {
        this.studyTaskName = str;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public float getScorePercent() {
        return this.scorePercent;
    }

    public void setScorePercent(float f) {
        this.scorePercent = f;
    }

    public float getAvgOrgan() {
        return this.avgOrgan;
    }

    public void setAvgOrgan(float f) {
        this.avgOrgan = f;
    }

    public float getAvgGlobal() {
        return this.avgGlobal;
    }

    public void setAvgGlobal(float f) {
        this.avgGlobal = f;
    }

    public float getOrganRank() {
        return this.organRank;
    }

    public void setOrganRank(float f) {
        this.organRank = f;
    }

    public float getGlobalRank() {
        return this.globalRank;
    }

    public void setGlobalRank(float f) {
        this.globalRank = f;
    }

    public java.lang.String toString() {
        return "TaskScore{studyTaskId='" + this.studyTaskId + "', courseId='" + this.courseId + "', studyTaskName='" + this.studyTaskName + "', endTime='" + this.endTime + "', scorePercent='" + this.scorePercent + "', avgOrgan='" + this.avgOrgan + "', avgGlobal='" + this.avgGlobal + "', organRank='" + this.organRank + "', globalRank='" + this.globalRank + "'}";
    }
}
