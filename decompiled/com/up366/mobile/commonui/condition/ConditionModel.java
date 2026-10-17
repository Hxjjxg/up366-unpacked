package com.up366.mobile.commonui.condition;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ConditionModel implements java.io.Serializable {
    public static final int DEGREE_ALL = 0;
    public static final int DEGREE_LISTEN = 1;
    public static final int DEGREE_OTHER = 5;
    public static final int DEGREE_READ = 2;
    public static final int DEGREE_USE = 4;
    public static final int DEGREE_WRITE = 3;
    public static final int TIME_ALL = 0;
    public static final int TIME_CUSTOM = 4;
    public static final int TIME_MONTH = 3;
    public static final int TIME_TODAY = 1;
    public static final int TIME_WEEK = 2;
    private long beginTime;
    private java.lang.String beginTimeStr;
    private java.lang.String bookId;
    private int courseId;
    private int degree;
    private long endTime;
    private int from;
    private boolean isShowBookList;
    private boolean isShowTime;
    private java.lang.String orderField;
    private java.lang.String orderType;
    private long resetBeginTime;
    private long resetEndTime;
    private int stageId;
    private int subjectId;
    private int timeType;

    public boolean isShowTime() {
        return this.isShowTime;
    }

    public void setShowTime(boolean z) {
        this.isShowTime = z;
    }

    public boolean isShowBookList() {
        return this.isShowBookList;
    }

    public void setShowBookList(boolean z) {
        this.isShowBookList = z;
    }

    public ConditionModel() {
    }

    public ConditionModel(int i, long j, long j2, java.lang.String str) {
        this.timeType = i;
        this.beginTime = j;
        this.endTime = j2;
        this.bookId = str;
    }

    public ConditionModel(int i, int i2, long j, long j2, java.lang.String str) {
        this.degree = i;
        this.timeType = i2;
        this.beginTime = j;
        this.endTime = j2;
        this.bookId = str;
    }

    public ConditionModel(int i, int i2, long j, long j2, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.degree = i;
        this.timeType = i2;
        this.beginTime = j;
        this.endTime = j2;
        this.bookId = str;
        this.orderType = str2;
        this.orderField = str3;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public int getStageId() {
        return this.stageId;
    }

    public void setStageId(int i) {
        this.stageId = i;
    }

    public int getFrom() {
        return this.from;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(int i) {
        this.subjectId = i;
    }

    public java.lang.String getOrderType() {
        return this.orderType;
    }

    public boolean isOriginallyCondition() {
        int i = this.from;
        if (i == 0) {
            return this.isShowBookList ? this.degree == 0 && this.timeType == 0 && "0".equals(this.bookId) : this.degree == 0 && this.timeType == 0;
        }
        if (i == 1) {
            return this.isShowBookList ? this.timeType == 0 && "0".equals(this.bookId) : this.timeType == 0;
        }
        if (i != 2) {
            return false;
        }
        return this.isShowBookList ? this.timeType == 0 && "0".equals(this.bookId) : this.timeType == 0;
    }

    public void setOrderType(java.lang.String str) {
        this.orderType = str;
    }

    public java.lang.String getOrderField() {
        return this.orderField;
    }

    public void setOrderField(java.lang.String str) {
        this.orderField = str;
    }

    public int getDegree() {
        return this.degree;
    }

    public void setDegree(int i) {
        this.degree = i;
    }

    public int getTimeType() {
        return this.timeType;
    }

    public void setTimeType(int i) {
        this.timeType = i;
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

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getBeginTimeStr() {
        return this.beginTimeStr;
    }

    public void setBeginTimeStr(java.lang.String str) {
        this.beginTimeStr = str;
    }

    public long getResetBeginTime() {
        return this.resetBeginTime;
    }

    public void setResetBeginTime(long j) {
        this.resetBeginTime = j;
    }

    public long getResetEndTime() {
        return this.resetEndTime;
    }

    public void setResetEndTime(long j) {
        this.resetEndTime = j;
    }
}
