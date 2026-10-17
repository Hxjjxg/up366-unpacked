package com.up366.mobile.course.photoanswer.logic.model.layout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class NetQuestion {
    private int lineNum;
    private int paragraph;
    private int qno;
    private int[] rect;
    private int[] rectAnswer;
    private int[][] rectNoOCR;

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

    public int getLineNum() {
        return this.lineNum;
    }

    public void setLineNum(int i) {
        this.lineNum = i;
    }

    public int[][] getRectNoOCR() {
        return this.rectNoOCR;
    }

    public void setRectNoOCR(int[][] iArr) {
        this.rectNoOCR = iArr;
    }

    public int getParagraph() {
        return this.paragraph;
    }

    public void setParagraph(int i) {
        this.paragraph = i;
    }
}
