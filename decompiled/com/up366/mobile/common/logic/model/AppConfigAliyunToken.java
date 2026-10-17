package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppConfigAliyunToken {
    private java.lang.String biz;
    private com.up366.mobile.common.logic.model.AppConfigOssBucketInfo ossBucketInfo;
    private int priority;

    public java.lang.String getBiz() {
        return this.biz;
    }

    public void setBiz(java.lang.String str) {
        this.biz = str;
    }

    public com.up366.mobile.common.logic.model.AppConfigOssBucketInfo getOssBucketInfo() {
        return this.ossBucketInfo;
    }

    public void setOssBucketInfo(com.up366.mobile.common.logic.model.AppConfigOssBucketInfo appConfigOssBucketInfo) {
        this.ossBucketInfo = appConfigOssBucketInfo;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }
}
