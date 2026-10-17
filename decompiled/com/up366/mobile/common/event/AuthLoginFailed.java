package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AuthLoginFailed {
    private int code;
    private java.lang.String info;

    public AuthLoginFailed(int i, java.lang.String str) {
        this.code = i;
        this.info = str;
    }

    public int getCode() {
        return this.code;
    }

    public java.lang.String getInfo() {
        return this.info;
    }
}
