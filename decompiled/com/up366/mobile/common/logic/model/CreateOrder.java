package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CreateOrder {
    private java.lang.String orderId;
    private java.lang.String recId;
    private java.lang.String receivablesId;
    private int statusType;

    public java.lang.String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(java.lang.String str) {
        this.orderId = str;
    }

    public java.lang.String getReceivablesId() {
        return this.receivablesId;
    }

    public void setReceivablesId(java.lang.String str) {
        this.receivablesId = str;
    }

    public int getStatusType() {
        return this.statusType;
    }

    public void setStatusType(int i) {
        this.statusType = i;
    }

    public java.lang.String getRecId() {
        return this.recId;
    }

    public void setRecId(java.lang.String str) {
        this.recId = str;
    }
}
