package com.up366.mobile.course.wrongnote.modle;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WrongNoteSubjectInfo implements java.io.Serializable {
    private int killedCount;
    private int killedCountLately;
    private int stageId;
    private int subjectId;
    private java.lang.String subjectName;
    private int wordCount;
    private int wrongCount;
    private int wrongNoteType;

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

    public java.lang.String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(java.lang.String str) {
        this.subjectName = str;
    }

    public int getWrongCount() {
        return this.wrongCount;
    }

    public void setWrongCount(int i) {
        this.wrongCount = i;
    }

    public int getWordCount() {
        return this.wordCount;
    }

    public void setWordCount(int i) {
        this.wordCount = i;
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

    public int getWrongNoteType() {
        return this.wrongNoteType;
    }

    public void setWrongNoteType(int i) {
        this.wrongNoteType = i;
    }
}
