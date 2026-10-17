package com.up366.mobile.course.photoanswer.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class PaperCodeModel {
    private int errorCode;
    private java.lang.String filePath;
    private int imageIndex;
    private java.lang.String paperCode;

    public int getImageIndex() {
        return this.imageIndex;
    }

    public void setImageIndex(int i) {
        this.imageIndex = i;
    }

    public java.lang.String getPaperCode() {
        return this.paperCode;
    }

    public void setPaperCode(java.lang.String str) {
        this.paperCode = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public java.lang.String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(java.lang.String str) {
        this.filePath = str;
    }

    public java.lang.String toString() {
        return "PaperCodeModel{paperCode='" + this.paperCode + "', errorCode=" + this.errorCode + ", imageIndex=" + this.imageIndex + ", filePath='" + this.filePath + "'}";
    }
}
