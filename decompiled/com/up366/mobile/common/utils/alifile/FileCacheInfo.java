package com.up366.mobile.common.utils.alifile;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FileCacheInfo extends com.up366.mobile.common.logic.model.DBModel {
    public long addTime;
    public long expireTime;
    public java.lang.String key;
    public java.lang.String path;
    public long rowId;

    public FileCacheInfo() {
    }

    public FileCacheInfo(long j, java.lang.String str) {
        this.key = com.up366.common.digest.MD5.md5(str);
        this.expireTime = j;
        this.addTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        this.path = str;
    }

    public java.lang.String toString() {
        return "FileCacheInfo{rowId=" + this.rowId + ", key='" + this.key + "', expireTime=" + this.expireTime + ", addTime=" + this.addTime + ", path='" + this.path + "'}";
    }
}
