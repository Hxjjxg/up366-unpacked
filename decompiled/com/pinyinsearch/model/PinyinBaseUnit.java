package com.pinyinsearch.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PinyinBaseUnit implements java.lang.Cloneable {
    private java.lang.String mNumber;
    private java.lang.String mOriginalString;
    private java.lang.String mPinyin;

    public PinyinBaseUnit() {
    }

    public PinyinBaseUnit(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.mOriginalString = str;
        this.mPinyin = str2;
        this.mNumber = str3;
    }

    public java.lang.String getOriginalString() {
        return this.mOriginalString;
    }

    public void setOriginalString(java.lang.String str) {
        this.mOriginalString = str;
    }

    public java.lang.String getPinyin() {
        return this.mPinyin;
    }

    public void setPinyin(java.lang.String str) {
        this.mPinyin = str;
    }

    public java.lang.String getNumber() {
        return this.mNumber;
    }

    public void setNumber(java.lang.String str) {
        this.mNumber = str;
    }

    protected java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        return super.clone();
    }
}
