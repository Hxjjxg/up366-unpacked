package com.up366.mobile.user.setting;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeTeachingClass {
    private java.lang.String courseCode;
    private int courseId;
    private java.lang.String courseName;
    private long createTime;
    private long endTime;
    private long joinTime;
    private java.lang.String lecturerName;
    private java.lang.Long rowId;
    private int status;

    public MeTeachingClass() {
    }

    public MeTeachingClass(java.lang.Long l, int i, java.lang.String str, java.lang.String str2, int i2, long j, long j2, long j3, java.lang.String str3) {
        this.rowId = l;
        this.courseId = i;
        this.courseName = str;
        this.lecturerName = str2;
        this.status = i2;
        this.createTime = j;
        this.endTime = j2;
        this.joinTime = j3;
        this.courseCode = str3;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public java.lang.String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(java.lang.String str) {
        this.courseName = str;
    }

    public java.lang.String getLecturerName() {
        return this.lecturerName;
    }

    public void setLecturerName(java.lang.String str) {
        this.lecturerName = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public java.lang.String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(java.lang.String str) {
        this.courseCode = str;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public void setJoinTime(long j) {
        this.joinTime = j;
    }
}
