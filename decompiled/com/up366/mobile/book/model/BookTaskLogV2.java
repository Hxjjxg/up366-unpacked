package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookTaskLogV2 {
    private long addTime;
    private java.lang.String answers;
    private java.lang.String bookId;
    private java.lang.String fileUrls;
    private java.lang.String guid;
    private float percent;
    private java.lang.Long rowId;
    private float score;
    private long studyDate;
    private transient java.lang.String studyTaskId;
    private int studyTime;
    private int submitType;
    private java.lang.String taskId;
    private java.lang.String taskNo;

    public BookTaskLogV2(java.lang.Long l, java.lang.String str, java.lang.String str2, int i, java.lang.String str3, float f, long j, long j2, java.lang.String str4, float f2, int i2, java.lang.String str5, java.lang.String str6) {
        this.rowId = l;
        this.taskId = str;
        this.bookId = str2;
        this.studyTime = i;
        this.answers = str3;
        this.score = f;
        this.addTime = j;
        this.studyDate = j2;
        this.taskNo = str4;
        this.percent = f2;
        this.submitType = i2;
        this.guid = str5;
        this.fileUrls = str6;
    }

    public BookTaskLogV2() {
        this.percent = 0.0f;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public void setStudyTime(int i) {
        this.studyTime = i;
    }

    public int getStudyTime() {
        return this.studyTime;
    }

    public void setAnswers(java.lang.String str) {
        this.answers = str;
    }

    public java.lang.String getAnswers() {
        return this.answers;
    }

    public void setScore(float f) {
        this.score = f;
    }

    public float getScore() {
        return this.score;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public void addStudyTime(long j) {
        if (j < 0) {
            j = com.igexin.push.config.c.i;
        }
        this.studyTime = (int) (((long) this.studyTime) + (j / 1000));
    }

    public long getStudyDate() {
        return this.studyDate;
    }

    public void setStudyDate(long j) {
        this.studyDate = (j / 1000) * 1000;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getGuid() {
        return this.guid;
    }

    public void setGuid(java.lang.String str) {
        this.guid = str;
    }

    public void setTaskNo(java.lang.String str) {
        this.taskNo = str;
    }

    public java.lang.String getTaskNo() {
        return this.taskNo;
    }

    public java.lang.String getFileUrls() {
        return this.fileUrls;
    }

    public void setFileUrls(java.lang.String str) {
        this.fileUrls = str;
    }

    public float getPercent() {
        return this.percent;
    }

    public void setPercent(float f) {
        this.percent = f;
    }

    public java.lang.String getStudyTaskId() {
        return this.studyTaskId;
    }

    public void setStudyTaskId(java.lang.String str) {
        this.studyTaskId = str;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public int getSubmitType() {
        return this.submitType;
    }

    public void setSubmitType(int i) {
        this.submitType = i;
    }
}
