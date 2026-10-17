package com.up366.mobile.course.p1p;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class BlurData {
    private double blurValue;
    private java.lang.String imagePath;
    private boolean isBlur;
    private double writePercent;

    public BlurData(java.lang.String str, double d, double d2, boolean z) {
        this.imagePath = str;
        this.blurValue = d;
        this.writePercent = d2;
        this.isBlur = z;
    }

    public java.lang.String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(java.lang.String str) {
        this.imagePath = str;
    }

    public double getBlurValue() {
        return this.blurValue;
    }

    public void setBlurValue(double d) {
        this.blurValue = d;
    }

    public double getWritePercent() {
        return this.writePercent;
    }

    public void setWritePercent(double d) {
        this.writePercent = d;
    }

    public boolean isBlur() {
        return this.isBlur;
    }

    public void setBlur(boolean z) {
        this.isBlur = z;
    }
}
