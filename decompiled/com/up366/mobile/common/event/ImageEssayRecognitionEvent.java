package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ImageEssayRecognitionEvent {
    public static final int NET_ERROR = -1;
    public static final int RECOGNITION_NO_DATA = -123456;
    public static final int RECOGNITION_SUCCESS = 0;
    private int code;
    private java.lang.String imageNetUrl;
    private java.lang.String message;
    private java.lang.String ocrTid;
    private java.lang.String resultString;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public java.lang.String getMessage() {
        return this.message;
    }

    public void setMessage(java.lang.String str) {
        this.message = str;
    }

    public java.lang.String getOcrTid() {
        return this.ocrTid;
    }

    public void setOcrTid(java.lang.String str) {
        this.ocrTid = str;
    }

    public java.lang.String getResultString() {
        return this.resultString;
    }

    public void setResultString(java.lang.String str) {
        this.resultString = str;
    }

    public java.lang.String getImageNetUrl() {
        return this.imageNetUrl;
    }

    public void setImageNetUrl(java.lang.String str) {
        this.imageNetUrl = str;
    }
}
