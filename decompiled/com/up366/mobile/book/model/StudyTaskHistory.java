package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyTaskHistory {
    public static final int BY_TASK_AUTO = 1;
    public static final int BY_USER = 0;
    private java.lang.String guid;
    private long insertTime;
    private int killBy;
    private java.lang.Long rowId;
    private float score;
    private java.lang.String studyTaskId;
    private java.lang.String taskId;

    public StudyTaskHistory(com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2) {
        this.guid = java.util.UUID.randomUUID().toString();
        this.taskId = bookTaskLogV2.getTaskId();
        this.score = bookTaskLogV2.getScore();
        this.insertTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        this.studyTaskId = bookTaskLogV2.getStudyTaskId();
        this.killBy = 0;
    }

    public StudyTaskHistory(com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory, java.lang.String str) {
        this.guid = java.util.UUID.randomUUID().toString();
        this.taskId = studyTaskHistory.taskId;
        this.score = studyTaskHistory.score;
        this.insertTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        this.studyTaskId = str;
        this.killBy = 1;
    }

    public StudyTaskHistory(com.up366.mobile.common.logic.model.SubmitTaskInfo submitTaskInfo) {
        this.guid = java.util.UUID.randomUUID().toString();
        this.taskId = submitTaskInfo.getTaskId();
        this.score = (float) submitTaskInfo.getScore();
        this.insertTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        this.studyTaskId = submitTaskInfo.getStudyTaskId();
        this.killBy = 0;
    }

    public StudyTaskHistory() {
    }

    public StudyTaskHistory(java.lang.Long l, java.lang.String str, java.lang.String str2, long j, float f, java.lang.String str3, int i) {
        this.rowId = l;
        this.guid = str;
        this.taskId = str2;
        this.insertTime = j;
        this.score = f;
        this.studyTaskId = str3;
        this.killBy = i;
    }

    public void setGuid(java.lang.String str) {
        this.guid = str;
    }

    public java.lang.String getGuid() {
        return this.guid;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public long getInsertTime() {
        return this.insertTime;
    }

    public void setInsertTime(long j) {
        this.insertTime = j;
    }

    public float getScore() {
        return this.score;
    }

    public void setScore(float f) {
        this.score = f;
    }

    public java.lang.String getStudyTaskId() {
        return this.studyTaskId;
    }

    public void setStudyTaskId(java.lang.String str) {
        this.studyTaskId = str;
    }

    public int getKillBy() {
        return this.killBy;
    }

    public void setKillBy(int i) {
        this.killBy = i;
    }

    public java.lang.String toString() {
        return "StudyTaskHistory{guid='" + this.guid + "', taskId='" + this.taskId + "', insertTime=" + this.insertTime + ", score=" + this.score + ", studyTaskId='" + this.studyTaskId + "', killBy=" + this.killBy + '}';
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }
}
