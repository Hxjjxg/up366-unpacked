package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UpdateCookiesEvent {
    private int code;
    private java.lang.String type = "_EVT_UPDATE_COOKIE_";

    public UpdateCookiesEvent(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String str) {
        this.type = str;
    }
}
