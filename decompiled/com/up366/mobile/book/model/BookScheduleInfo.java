package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookScheduleInfo {
    private java.lang.String bookId;
    private java.lang.String chapterId;
    private int chapterStudyTaskNum;
    private long lastStudyTime;
    private java.lang.String pageId;
    private java.lang.Long rowId;
    private java.lang.String schedule;
    private java.lang.String shortSchedule;
    private java.lang.String taskId;
    private int taskNo;

    public BookScheduleInfo(java.lang.Long l, java.lang.String str, java.lang.String str2, java.lang.String str3, long j, int i, java.lang.String str4, java.lang.String str5, int i2, java.lang.String str6) {
        this.rowId = l;
        this.bookId = str;
        this.chapterId = str2;
        this.pageId = str3;
        this.lastStudyTime = j;
        this.chapterStudyTaskNum = i;
        this.shortSchedule = str4;
        this.schedule = str5;
        this.taskNo = i2;
        this.taskId = str6;
    }

    public BookScheduleInfo() {
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

    public java.lang.String getPageId() {
        return this.pageId;
    }

    public void setPageId(java.lang.String str) {
        this.pageId = str;
    }

    public long getLastStudyTime() {
        return this.lastStudyTime;
    }

    public void setLastStudyTime(long j) {
        this.lastStudyTime = j;
    }

    public java.lang.String getLastStudyTimeStr() {
        return castTime(this.lastStudyTime);
    }

    public int getChapterStudyTaskNum() {
        return this.chapterStudyTaskNum;
    }

    public void setChapterStudyTaskNum(int i) {
        this.chapterStudyTaskNum = i;
    }

    public java.lang.String getShortSchedule() {
        return this.shortSchedule;
    }

    public void setShortSchedule(java.lang.String str) {
        this.shortSchedule = str;
    }

    public java.lang.String getSchedule() {
        return this.schedule;
    }

    public void setSchedule(java.lang.String str) {
        this.schedule = str;
    }

    public int getTaskNo() {
        return this.taskNo;
    }

    public void setTaskNo(int i) {
        this.taskNo = i;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    private java.lang.String castTime(long j) {
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - j;
        java.lang.String time = com.up366.common.TimeUtils.formatTime(new java.util.Date(j), "E");
        if (j == 0) {
            return "";
        }
        if (currentNtpTimeInMillisecond > 31104000000L) {
            return ((((((currentNtpTimeInMillisecond / 12) / 30) / 24) / 60) / 60) / 1000) + "年前 " + time;
        }
        if (currentNtpTimeInMillisecond > 2592000000L) {
            return (((((currentNtpTimeInMillisecond / 30) / 24) / 60) / 60) / 1000) + "月前 " + time;
        }
        if (currentNtpTimeInMillisecond > 86400000) {
            return ((((currentNtpTimeInMillisecond / 24) / 60) / 60) / 1000) + "天前 " + time;
        }
        if (currentNtpTimeInMillisecond > 3600000) {
            return (currentNtpTimeInMillisecond / 3600000) + "小时前";
        }
        if (currentNtpTimeInMillisecond > 60000) {
            return (currentNtpTimeInMillisecond / 60000) + "分钟前";
        }
        return "刚刚";
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }
}
