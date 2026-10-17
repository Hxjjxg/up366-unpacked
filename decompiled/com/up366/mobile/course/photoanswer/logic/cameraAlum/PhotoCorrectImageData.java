package com.up366.mobile.course.photoanswer.logic.cameraAlum;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class PhotoCorrectImageData {
    private int code;
    private java.lang.String cropImagePath;
    private int imageType;

    public PhotoCorrectImageData() {
    }

    public PhotoCorrectImageData(int i, java.lang.String str, int i2) {
        this.code = i;
        this.cropImagePath = str;
        this.imageType = i2;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public java.lang.String getCropImagePath() {
        return this.cropImagePath;
    }

    public void setCropImagePath(java.lang.String str) {
        this.cropImagePath = str;
    }

    public int getImageType() {
        return this.imageType;
    }

    public void setImageType(int i) {
        this.imageType = i;
    }

    public boolean isV3Paper() {
        return this.imageType == 3;
    }

    public boolean isV2Paper() {
        return this.imageType == 1;
    }

    public java.lang.String toString() {
        return "PhotoCorrectImageData{code=" + this.code + ", cropImagePath='" + this.cropImagePath + "', imageType=" + this.imageType + '}';
    }
}
