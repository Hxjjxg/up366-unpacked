package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CourseBookPlan {
    private long beginTime;
    private java.lang.String bookId;
    private java.lang.String chapterId;
    private int courseId;
    private long endTime;
    private java.lang.String guid;
    private int isClose;
    private int isLock;
    private int isPublished;
    private int publishType;
    private java.lang.Long rowId;

    public CourseBookPlan(java.lang.Long l, java.lang.String str, int i, java.lang.String str2, java.lang.String str3, int i2, int i3, long j, long j2, int i4, int i5) {
        this.rowId = l;
        this.guid = str;
        this.courseId = i;
        this.bookId = str2;
        this.chapterId = str3;
        this.isClose = i2;
        this.isLock = i3;
        this.beginTime = j;
        this.endTime = j2;
        this.publishType = i4;
        this.isPublished = i5;
    }

    public CourseBookPlan() {
    }

    public java.lang.String getChapterId() {
        return this.chapterId;
    }

    public void setChapterId(java.lang.String str) {
        this.chapterId = str;
    }

    public int getIsClose() {
        return this.isClose;
    }

    public void setIsClose(int i) {
        this.isClose = i;
    }

    public int getIsLock() {
        return this.isLock;
    }

    public void setIsLock(int i) {
        this.isLock = i;
    }

    public boolean isLock() {
        return this.isLock == 1;
    }

    public boolean isClose() {
        return this.isClose == 1;
    }

    public java.lang.String getGuid() {
        return this.guid;
    }

    public void setGuid(java.lang.String str) {
        this.guid = str;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public void initGuid() {
        this.guid = this.chapterId + this.courseId;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(long j) {
        this.beginTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public int getPublishType() {
        return this.publishType;
    }

    public void setPublishType(int i) {
        this.publishType = i;
    }

    public int getIsPublished() {
        return this.isPublished;
    }

    public void setIsPublished(int i) {
        this.isPublished = i;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }
}
