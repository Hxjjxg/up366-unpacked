package com.chuanglan.shanyan_sdk.tool;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class OperatorInfoBean {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;

    public OperatorInfoBean(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    public java.lang.String getOperatorName() {
        return this.a;
    }

    public java.lang.String getOperatorSloganName() {
        return this.c;
    }

    public java.lang.String getOperatorUrl() {
        return this.b;
    }

    public void setOperatorName(java.lang.String str) {
        this.a = str;
    }

    public void setOperatorSloganName(java.lang.String str) {
        this.c = str;
    }

    public void setOperatorUrl(java.lang.String str) {
        this.b = str;
    }

    public OperatorInfoBean(java.lang.String str) {
        this.a = str;
    }

    public OperatorInfoBean(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }
}
