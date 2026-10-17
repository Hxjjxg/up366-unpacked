package com.up366.mobile.course.photoanswer.logic.model.engine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class EngineBlock {
    private int blockNo;
    private java.lang.String blockType;
    private java.lang.String groupId;
    private int imageNo;
    private java.util.List<com.up366.mobile.course.photoanswer.logic.model.engine.EngineInfo> infos;
    private java.util.List<com.up366.mobile.course.photoanswer.logic.model.engine.EngineQuestion> questions;
    private int[] rect;
    private java.lang.String template;

    public int getBlockNo() {
        return this.blockNo;
    }

    public void setBlockNo(int i) {
        this.blockNo = i;
    }

    public java.lang.String getBlockType() {
        return this.blockType;
    }

    public void setBlockType(java.lang.String str) {
        this.blockType = str;
    }

    public java.lang.String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(java.lang.String str) {
        this.groupId = str;
    }

    public int getImageNo() {
        return this.imageNo;
    }

    public void setImageNo(int i) {
        this.imageNo = i;
    }

    public java.util.List<com.up366.mobile.course.photoanswer.logic.model.engine.EngineInfo> getInfos() {
        return this.infos;
    }

    public void setInfos(java.util.List<com.up366.mobile.course.photoanswer.logic.model.engine.EngineInfo> list) {
        this.infos = list;
    }

    public int[] getRect() {
        return this.rect;
    }

    public void setRect(int[] iArr) {
        this.rect = iArr;
    }

    public java.lang.String getTemplate() {
        return this.template;
    }

    public void setTemplate(java.lang.String str) {
        this.template = str;
    }

    public java.util.List<com.up366.mobile.course.photoanswer.logic.model.engine.EngineQuestion> getQuestions() {
        return this.questions;
    }

    public void setQuestions(java.util.List<com.up366.mobile.course.photoanswer.logic.model.engine.EngineQuestion> list) {
        this.questions = list;
    }

    public java.lang.String toString() {
        return "EngineBlock{blockNo=" + this.blockNo + ", blockType='" + this.blockType + "', groupId='" + this.groupId + "', imageNo=" + this.imageNo + ", infos=" + this.infos + ", rect=" + java.util.Arrays.toString(this.rect) + ", template='" + this.template + "', questions=" + this.questions + '}';
    }
}
