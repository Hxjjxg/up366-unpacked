package com.igexin.sdk.message;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SetFenceLabelMessage extends com.igexin.sdk.message.GTCmdMessage {
    private java.lang.String code;

    public SetFenceLabelMessage() {
    }

    public SetFenceLabelMessage(java.lang.String str, int i) {
        super(i);
        this.code = str;
    }

    public java.lang.String getCode() {
        return this.code;
    }

    public void setCode(java.lang.String str) {
        this.code = str;
    }
}
