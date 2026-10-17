package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookTaskFinishedInfo {
    private long addDate;
    private java.lang.String bookId;
    private java.lang.String chapterId;
    private float percent;
    private java.lang.Long rowId;
    private float score;
    private int seconds;
    private long studyDate;
    private java.lang.String taskId;
    private int uid;

    public BookTaskFinishedInfo(java.lang.Long l, java.lang.String str, int i, java.lang.String str2, java.lang.String str3, float f, float f2, int i2, long j, long j2) {
        this.rowId = l;
        this.taskId = str;
        this.uid = i;
        this.bookId = str2;
        this.chapterId = str3;
        this.score = f;
        this.percent = f2;
        this.seconds = i2;
        this.studyDate = j;
        this.addDate = j2;
    }

    public BookTaskFinishedInfo() {
        this.percent = 0.0f;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getChapterId() {
        return this.chapterId;
    }

    public void setChapterId(java.lang.String str) {
        this.chapterId = str;
    }

    public float getScore() {
        return this.score;
    }

    public void setScore(float f) {
        this.score = f;
    }

    public float getPercent() {
        return this.percent;
    }

    public void setPercent(float f) {
        this.percent = f;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setSeconds(int i) {
        this.seconds = i;
    }

    public long getStudyDate() {
        return this.studyDate;
    }

    public void setStudyDate(long j) {
        this.studyDate = j;
    }

    public long getAddDate() {
        return this.addDate;
    }

    public void setAddDate(long j) {
        this.addDate = j;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }
}
