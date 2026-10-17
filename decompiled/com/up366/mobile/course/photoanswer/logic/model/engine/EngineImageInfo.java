package com.up366.mobile.course.photoanswer.logic.model.engine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class EngineImageInfo {
    private int basex;
    private int basey;
    private java.util.List<com.up366.mobile.course.photoanswer.logic.model.engine.EngineBlock> blocks;
    private java.lang.String chineseName;
    private java.lang.String convertFileName;
    private int errorCode;
    private int imageHeight;
    private int imageIndex;
    private int imageWidth;
    private boolean isA3;
    private java.lang.String paperID;
    private int[] rectPaperQRCode;
    private int[] rectPaperShortCode;
    private int[] rectStuIDOCR;
    private int[] rectStuIDOMR;
    private int[] rectStuIDQRCode;
    private int[] rectStuName;
    private java.lang.String studentID;
    private java.lang.String taskguid;
    private int totalImageCount;
    private java.lang.String workdir;

    public int getBasex() {
        return this.basex;
    }

    public void setBasex(int i) {
        this.basex = i;
    }

    public int getBasey() {
        return this.basey;
    }

    public void setBasey(int i) {
        this.basey = i;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public void setImageHeight(int i) {
        this.imageHeight = i;
    }

    public int getImageIndex() {
        return this.imageIndex;
    }

    public void setImageIndex(int i) {
        this.imageIndex = i;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public void setImageWidth(int i) {
        this.imageWidth = i;
    }

    public boolean isA3() {
        return this.isA3;
    }

    public void setA3(boolean z) {
        this.isA3 = z;
    }

    public java.lang.String getPaperID() {
        return this.paperID;
    }

    public void setPaperID(java.lang.String str) {
        this.paperID = str;
    }

    public java.lang.String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(java.lang.String str) {
        this.studentID = str;
    }

    public java.lang.String getTaskguid() {
        return this.taskguid;
    }

    public void setTaskguid(java.lang.String str) {
        this.taskguid = str;
    }

    public int getTotalImageCount() {
        return this.totalImageCount;
    }

    public void setTotalImageCount(int i) {
        this.totalImageCount = i;
    }

    public java.lang.String getWorkdir() {
        return this.workdir;
    }

    public void setWorkdir(java.lang.String str) {
        this.workdir = str;
    }

    public java.lang.String getConvertFileName() {
        return this.convertFileName;
    }

    public void setConvertFileName(java.lang.String str) {
        this.convertFileName = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public int[] getRectPaperQRCode() {
        return this.rectPaperQRCode;
    }

    public void setRectPaperQRCode(int[] iArr) {
        this.rectPaperQRCode = iArr;
    }

    public int[] getRectPaperShortCode() {
        return this.rectPaperShortCode;
    }

    public void setRectPaperShortCode(int[] iArr) {
        this.rectPaperShortCode = iArr;
    }

    public int[] getRectStuIDOCR() {
        return this.rectStuIDOCR;
    }

    public void setRectStuIDOCR(int[] iArr) {
        this.rectStuIDOCR = iArr;
    }

    public int[] getRectStuIDOMR() {
        return this.rectStuIDOMR;
    }

    public void setRectStuIDOMR(int[] iArr) {
        this.rectStuIDOMR = iArr;
    }

    public int[] getRectStuIDQRCode() {
        return this.rectStuIDQRCode;
    }

    public void setRectStuIDQRCode(int[] iArr) {
        this.rectStuIDQRCode = iArr;
    }

    public int[] getRectStuName() {
        return this.rectStuName;
    }

    public void setRectStuName(int[] iArr) {
        this.rectStuName = iArr;
    }

    public java.lang.String getChineseName() {
        return this.chineseName;
    }

    public void setChineseName(java.lang.String str) {
        this.chineseName = str;
    }

    public java.util.List<com.up366.mobile.course.photoanswer.logic.model.engine.EngineBlock> getBlocks() {
        return this.blocks;
    }

    public void setBlocks(java.util.List<com.up366.mobile.course.photoanswer.logic.model.engine.EngineBlock> list) {
        this.blocks = list;
    }

    public java.lang.String toString() {
        return "EngineImageInfo{basex=" + this.basex + ", basey=" + this.basey + ", imageHeight=" + this.imageHeight + ", imageIndex=" + this.imageIndex + ", imageWidth=" + this.imageWidth + ", isA3=" + this.isA3 + ", paperID='" + this.paperID + "', studentID='" + this.studentID + "', taskguid='" + this.taskguid + "', totalImageCount=" + this.totalImageCount + ", workdir='" + this.workdir + "', convertFileName='" + this.convertFileName + "', errorCode=" + this.errorCode + ", rectPaperQRCode=" + java.util.Arrays.toString(this.rectPaperQRCode) + ", rectPaperShortCode=" + java.util.Arrays.toString(this.rectPaperShortCode) + ", rectStuIDOCR=" + java.util.Arrays.toString(this.rectStuIDOCR) + ", rectStuIDOMR=" + java.util.Arrays.toString(this.rectStuIDOMR) + ", rectStuIDQRCode=" + java.util.Arrays.toString(this.rectStuIDQRCode) + ", rectStuName=" + java.util.Arrays.toString(this.rectStuName) + ", chineseName='" + this.chineseName + "', blocks=" + this.blocks + '}';
    }
}
