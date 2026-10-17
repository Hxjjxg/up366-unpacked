package com.up366.smartscan2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ConnerData {
    private int[] topLeft = new int[2];
    private int[] topRight = new int[2];
    private int[] bottomLeft = new int[2];
    private int[] bottomRight = new int[2];
    private float[] confidence = new float[1];
    private int errorCode = 0;

    public void reset() {
        int[] iArr = this.topLeft;
        iArr[0] = 0;
        iArr[1] = 0;
        int[] iArr2 = this.topRight;
        iArr2[0] = 0;
        iArr2[1] = 0;
        int[] iArr3 = this.bottomLeft;
        iArr3[0] = 0;
        iArr3[1] = 0;
        int[] iArr4 = this.bottomRight;
        iArr4[0] = 0;
        iArr4[1] = 0;
        this.errorCode = 0;
        this.confidence[0] = 0.0f;
    }

    public int[] getTopLeft() {
        return this.topLeft;
    }

    public void setTopLeft(int[] iArr) {
        this.topLeft = iArr;
    }

    public int[] getTopRight() {
        return this.topRight;
    }

    public void setTopRight(int[] iArr) {
        this.topRight = iArr;
    }

    public int[] getBottomLeft() {
        return this.bottomLeft;
    }

    public void setBottomLeft(int[] iArr) {
        this.bottomLeft = iArr;
    }

    public int[] getBottomRight() {
        return this.bottomRight;
    }

    public void setBottomRight(int[] iArr) {
        this.bottomRight = iArr;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public float[] getConfidence() {
        return this.confidence;
    }

    public void setConfidence(float[] fArr) {
        this.confidence = fArr;
    }

    public java.lang.String toString() {
        return "ConnerData{topLeft=" + java.util.Arrays.toString(this.topLeft) + ", topRight=" + java.util.Arrays.toString(this.topRight) + ", bottomLeft=" + java.util.Arrays.toString(this.bottomLeft) + ", bottomRight=" + java.util.Arrays.toString(this.bottomRight) + ", confidence=" + java.util.Arrays.toString(this.confidence) + ", errorCode=" + this.errorCode + '}';
    }
}
