package com.igexin.sdk.message;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GTCmdMessage extends com.igexin.sdk.message.BaseMessage {
    private int action;

    public GTCmdMessage() {
    }

    public GTCmdMessage(int i) {
        this.action = i;
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int i) {
        this.action = i;
    }
}
