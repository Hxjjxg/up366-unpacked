package com.up366.mobile.course.photoanswer.logic.model.layout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class NetBlock {
    private int blockNo;
    private int imageNo;
    private com.up366.mobile.course.photoanswer.logic.model.layout.NetInfo[] infos;
    private com.up366.mobile.course.photoanswer.logic.model.layout.NetQuestion[] questions;
    private int[] rect;
    private java.lang.String blockType = "";
    private java.lang.String template = "";

    public int getBlockNo() {
        return this.blockNo;
    }

    public void setBlockNo(int i) {
        this.blockNo = i;
    }

    public int getImageNo() {
        return this.imageNo;
    }

    public void setImageNo(int i) {
        this.imageNo = i;
    }

    public java.lang.String getBlockType() {
        return this.blockType;
    }

    public void setBlockType(java.lang.String str) {
        this.blockType = str;
    }

    public int[] getRect() {
        return this.rect;
    }

    public void setRect(int[] iArr) {
        this.rect = iArr;
    }

    public com.up366.mobile.course.photoanswer.logic.model.layout.NetInfo[] getInfos() {
        return this.infos;
    }

    public void setInfos(com.up366.mobile.course.photoanswer.logic.model.layout.NetInfo[] netInfoArr) {
        this.infos = netInfoArr;
    }

    public java.lang.String getTemplate() {
        return this.template;
    }

    public void setTemplate(java.lang.String str) {
        this.template = str;
    }

    public com.up366.mobile.course.photoanswer.logic.model.layout.NetQuestion[] getQuestions() {
        return this.questions;
    }

    public void setQuestions(com.up366.mobile.course.photoanswer.logic.model.layout.NetQuestion[] netQuestionArr) {
        this.questions = netQuestionArr;
    }
}
