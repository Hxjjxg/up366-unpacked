package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WXOrderInfo {
    private java.lang.String appId;
    private int partnerId;
    private java.lang.String prepayId;
    private int timeStamp;

    public java.lang.String getAppId() {
        return this.appId;
    }

    public void setAppId(java.lang.String str) {
        this.appId = str;
    }

    public int getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(int i) {
        this.timeStamp = i;
    }

    public int getPartnerId() {
        return this.partnerId;
    }

    public void setPartnerId(int i) {
        this.partnerId = i;
    }

    public java.lang.String getPrepayId() {
        return this.prepayId;
    }

    public void setPrepayId(java.lang.String str) {
        this.prepayId = str;
    }

    public java.lang.String toString() {
        return "WXOrderInfo [appId=" + this.appId + ", timeStamp=" + this.timeStamp + ", partnerId=" + this.partnerId + ", prepayId=" + this.prepayId + "]";
    }
}
