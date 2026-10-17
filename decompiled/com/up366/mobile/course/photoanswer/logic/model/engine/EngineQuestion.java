package com.up366.mobile.course.photoanswer.logic.model.engine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class EngineQuestion {
    private int paragraph;
    private int qno;
    private int[] rect;
    private int[] rectAnswer;

    public int getParagraph() {
        return this.paragraph;
    }

    public void setParagraph(int i) {
        this.paragraph = i;
    }

    public int getQno() {
        return this.qno;
    }

    public void setQno(int i) {
        this.qno = i;
    }

    public int[] getRect() {
        return this.rect;
    }

    public void setRect(int[] iArr) {
        this.rect = iArr;
    }

    public int[] getRectAnswer() {
        return this.rectAnswer;
    }

    public void setRectAnswer(int[] iArr) {
        this.rectAnswer = iArr;
    }

    public java.lang.String toString() {
        return "EngineQuestion{qno=" + this.qno + ", rect=" + java.util.Arrays.toString(this.rect) + ", rectAnswer=" + java.util.Arrays.toString(this.rectAnswer) + '}';
    }
}
