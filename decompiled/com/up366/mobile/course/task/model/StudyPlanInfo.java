package com.up366.mobile.course.task.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class StudyPlanInfo {
    private int flevel;
    private java.lang.Long rowId;
    private long studyPlanId;

    public StudyPlanInfo(java.lang.Long l, long j, int i) {
        this.rowId = l;
        this.studyPlanId = j;
        this.flevel = i;
    }

    public StudyPlanInfo() {
    }

    public java.lang.String toString() {
        return "StudyPlanInfo{rowId=" + this.rowId + ", studyPlanId=" + this.studyPlanId + ", flevel=" + this.flevel + '}';
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public long getStudyPlanId() {
        return this.studyPlanId;
    }

    public void setStudyPlanId(long j) {
        this.studyPlanId = j;
    }

    public int getFlevel() {
        return this.flevel;
    }

    public void setFlevel(int i) {
        this.flevel = i;
    }
}
