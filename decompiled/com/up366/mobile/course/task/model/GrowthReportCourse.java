package com.up366.mobile.course.task.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class GrowthReportCourse {
    private java.lang.String bookId;
    private int courseId;
    private java.lang.String courseName;
    private java.lang.String title;

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

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public java.lang.String toString() {
        return "GrowthReportCourse{courseId='" + this.courseId + "', courseName='" + this.courseName + "', bookId='" + this.bookId + "', title='" + this.title + "'}";
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.course.task.model.GrowthReportCourse growthReportCourse = (com.up366.mobile.course.task.model.GrowthReportCourse) obj;
        return this.courseId == growthReportCourse.courseId && java.util.Objects.equals(this.courseName, growthReportCourse.courseName) && java.util.Objects.equals(this.bookId, growthReportCourse.bookId) && java.util.Objects.equals(this.title, growthReportCourse.title);
    }

    public int hashCode() {
        return java.util.Objects.hash(java.lang.Integer.valueOf(this.courseId), this.courseName, this.bookId, this.title);
    }
}
