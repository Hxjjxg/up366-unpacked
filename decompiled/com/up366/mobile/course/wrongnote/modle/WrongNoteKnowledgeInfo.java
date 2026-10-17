package com.up366.mobile.course.wrongnote.modle;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WrongNoteKnowledgeInfo implements java.io.Serializable {
    private int assignId;
    private java.lang.String bookId;
    private int courseId;
    private int fromType;
    private boolean isCurJob;
    private java.lang.String knowledgeId;
    private java.lang.String knowledgeName;
    private java.lang.String knowledgeNamePinYin;
    private java.lang.String qTypeId;
    private java.lang.String qTypeName;
    private java.lang.String qtypeNamePinYin;
    private int stageId;
    private java.lang.String studyTaskId;
    private int subjectId;
    private int wrongTimes;

    public java.lang.String getqTypeId() {
        return this.qTypeId;
    }

    public void setqTypeId(java.lang.String str) {
        this.qTypeId = str;
    }

    public java.lang.String getqTypeName() {
        return this.qTypeName;
    }

    public void setqTypeName(java.lang.String str) {
        this.qTypeName = str;
        com.pinyinsearch.model.PinyinSearchUnit pinyinSearchUnit = new com.pinyinsearch.model.PinyinSearchUnit(str);
        com.pinyinsearch.util.PinyinUtil.parse(pinyinSearchUnit);
        this.qtypeNamePinYin = com.pinyinsearch.util.PinyinUtil.getSortKey(pinyinSearchUnit).toLowerCase().replaceAll("[^a-z]*", "");
    }

    public java.lang.String getKnowledgeId() {
        return this.knowledgeId;
    }

    public void setKnowledgeId(java.lang.String str) {
        this.knowledgeId = str;
    }

    public java.lang.String getKnowledgeName() {
        return this.knowledgeName;
    }

    public void setKnowledgeName(java.lang.String str) {
        this.knowledgeName = str;
        com.pinyinsearch.model.PinyinSearchUnit pinyinSearchUnit = new com.pinyinsearch.model.PinyinSearchUnit(str);
        com.pinyinsearch.util.PinyinUtil.parse(pinyinSearchUnit);
        this.knowledgeNamePinYin = com.pinyinsearch.util.PinyinUtil.getSortKey(pinyinSearchUnit).toLowerCase().replaceAll("[^a-z]*", "");
    }

    public int getWrongTimes() {
        return this.wrongTimes;
    }

    public void setWrongTimes(int i) {
        this.wrongTimes = i;
    }

    public java.lang.String getKnowledgeNamePinYin() {
        return this.knowledgeNamePinYin;
    }

    public java.lang.String getQtypeNamePinYin() {
        return this.qtypeNamePinYin;
    }

    public int getStageId() {
        return this.stageId;
    }

    public void setStageId(int i) {
        this.stageId = i;
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(int i) {
        this.subjectId = i;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public int getFromType() {
        return this.fromType;
    }

    public void setFromType(int i) {
        this.fromType = i;
    }

    public boolean isCurJob() {
        return this.isCurJob;
    }

    public void setCurJob(boolean z) {
        this.isCurJob = z;
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

    public int getAssignId() {
        return this.assignId;
    }

    public void setAssignId(int i) {
        this.assignId = i;
    }
}
