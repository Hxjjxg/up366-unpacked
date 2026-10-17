package com.up366.mobile.common.utils.alifile;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AliYunToken {
    private java.lang.String bucketname;
    private long currentTime;
    private java.lang.String defaulthostid;
    private java.lang.String securityToken;
    private java.lang.String tmpAkId;
    private java.lang.String tmpAkSecret;

    public long getCurrentTime() {
        return this.currentTime;
    }

    public void setCurrentTime(long j) {
        this.currentTime = j;
    }

    public java.lang.String getTmpAkId() {
        return this.tmpAkId;
    }

    public void setTmpAkId(java.lang.String str) {
        this.tmpAkId = str;
    }

    public java.lang.String getSecurityToken() {
        return this.securityToken;
    }

    public void setSecurityToken(java.lang.String str) {
        this.securityToken = str;
    }

    public java.lang.String getBucketname() {
        return this.bucketname;
    }

    public void setBucketname(java.lang.String str) {
        this.bucketname = str;
    }

    public java.lang.String getDefaulthostid() {
        return this.defaulthostid;
    }

    public void setDefaulthostid(java.lang.String str) {
        this.defaulthostid = str;
    }

    public java.lang.String getTmpAkSecret() {
        return this.tmpAkSecret;
    }

    public void setTmpAkSecret(java.lang.String str) {
        this.tmpAkSecret = str;
    }
}
