package com.igexin.sdk.message;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GTTransmitMessage extends com.igexin.sdk.message.GTPushMessage {
    private boolean cidBindToken;
    private boolean isOffline;
    private java.lang.String messageId;
    private byte[] payload;
    private java.lang.String payloadId;
    private java.lang.String taskId;

    public GTTransmitMessage() {
    }

    public GTTransmitMessage(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, boolean z, boolean z2) {
        this.taskId = str;
        this.messageId = str2;
        this.payloadId = str3;
        this.payload = bArr;
        this.isOffline = z;
        this.cidBindToken = z2;
    }

    public java.lang.String getMessageId() {
        return this.messageId;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public java.lang.String getPayloadId() {
        return this.payloadId;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public boolean isCidBindToken() {
        return this.cidBindToken;
    }

    public boolean isOffline() {
        return this.isOffline;
    }

    public void setMessageId(java.lang.String str) {
        this.messageId = str;
    }

    public void setPayload(byte[] bArr) {
        this.payload = bArr;
    }

    public void setPayloadId(java.lang.String str) {
        this.payloadId = str;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }
}
