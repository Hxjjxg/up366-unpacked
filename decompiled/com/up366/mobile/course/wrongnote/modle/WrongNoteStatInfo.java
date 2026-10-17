package com.up366.mobile.course.wrongnote.modle;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WrongNoteStatInfo implements java.io.Serializable {
    private java.lang.String bookId;
    private int classify;
    private int killedCount;
    private int killedCountLately;
    private java.lang.String name;
    private int num;
    private int stageId;
    private int subjectId;
    private int wordCount;
    private int wrongCount;
    private int wrongNoteType;

    public int getNum() {
        return this.num;
    }

    public void setNum(int i) {
        this.num = i;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public int getWrongCount() {
        return this.wrongCount;
    }

    public int getWordCount() {
        return this.wordCount;
    }

    public void setWordCount(int i) {
        this.wordCount = i;
    }

    public void setWrongCount(int i) {
        this.wrongCount = i;
    }

    public int getKilledCount() {
        return this.killedCount;
    }

    public void setKilledCount(int i) {
        this.killedCount = i;
    }

    public int getKilledCountLately() {
        return this.killedCountLately;
    }

    public void setKilledCountLately(int i) {
        this.killedCountLately = i;
    }

    public int getClassify() {
        return this.classify;
    }

    public void setClassify(int i) {
        this.classify = i;
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(int i) {
        this.subjectId = i;
    }

    public int getStageId() {
        return this.stageId;
    }

    public void setStageId(int i) {
        this.stageId = i;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public int getWrongNoteType() {
        return this.wrongNoteType;
    }

    public void setWrongNoteType(int i) {
        this.wrongNoteType = i;
    }

    public java.lang.String toString() {
        return "WrongNoteStatInfo{num=" + this.num + ", name='" + this.name + "', wordCount=" + this.wordCount + ", wrongCount=" + this.wrongCount + ", killedCount=" + this.killedCount + ", killedCountLately=" + this.killedCountLately + ", wrongNoteType=" + this.wrongNoteType + ", classify=" + this.classify + ", subjectId=" + this.subjectId + ", stageId=" + this.stageId + ", bookId='" + this.bookId + "'}";
    }
}
