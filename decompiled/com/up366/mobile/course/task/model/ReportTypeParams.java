package com.up366.mobile.course.task.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class ReportTypeParams {
    private java.lang.String bookId;
    private int courseId;
    private java.lang.String scope;
    private java.lang.String studyTaskId;
    private java.lang.String taskId;
    private java.lang.String type;

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String str) {
        this.type = str;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
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

    public java.lang.String getScope() {
        return this.scope;
    }

    public void setScope(java.lang.String str) {
        this.scope = str;
    }

    public java.lang.String toString() {
        return "ReportTypeParams{type='" + this.type + "', taskId='" + this.taskId + "', bookId='" + this.bookId + "', courseId=" + this.courseId + ", studyTaskId='" + this.studyTaskId + "', scope='" + this.scope + "'}";
    }
}
