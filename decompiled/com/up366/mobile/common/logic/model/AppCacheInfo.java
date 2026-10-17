package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppCacheInfo extends com.up366.mobile.common.logic.model.DBModel {
    public static final long TIME_DAY_1 = 86400000;
    public static final long TIME_DAY_10 = 864000000;
    public static final long TIME_DAY_7 = 604800000;
    public static final long TIME_HOUR_1 = 3600000;
    public static final long TIME_MINUTE_1 = 60000;
    public static final long TIME_MINUTE_5 = 300000;
    public static final long TIME_MONTH_1 = 2592000000L;
    public static final long TIME_MONTH_3 = 7776000000L;
    public static final long TIME_MONTH_6 = 15552000000L;
    public static final long TIME_SECOND_1 = 1000;
    private long addTime;
    private long expireTime;
    private java.lang.String info;
    private java.lang.String key;
    private java.lang.Object memoryHolder;
    public long rowId;
    private long updateCount;
    private long updateTime;

    public AppCacheInfo(java.lang.String str, java.lang.Object obj, long j) {
        this.key = str;
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        this.addTime = currentNtpTimeInMillisecond;
        long j2 = currentNtpTimeInMillisecond + j;
        this.expireTime = j2;
        if (j2 < 0) {
            this.expireTime = Long.MAX_VALUE;
        }
        this.memoryHolder = obj;
    }

    public AppCacheInfo() {
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(long j) {
        this.expireTime = j;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public long getUpdateCount() {
        return this.updateCount;
    }

    public void setUpdateCount(long j) {
        this.updateCount = j;
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public void setKey(java.lang.String str) {
        this.key = str;
    }

    public java.lang.String getInfo() {
        return this.info;
    }

    public void setInfo(java.lang.String str) {
        this.info = str;
    }

    public java.lang.Object getMemoryHolder() {
        return this.memoryHolder;
    }

    public void setMemoryHolder(java.lang.Object obj) {
        this.memoryHolder = obj;
    }

    public void buildMemoryHolder(java.lang.Object obj) {
        try {
            if (obj instanceof java.lang.Class) {
                this.memoryHolder = com.alibaba.fastjson.JSON.parseObject(this.info, (java.lang.Class) obj);
            } else if (obj instanceof com.alibaba.fastjson.TypeReference) {
                this.memoryHolder = com.alibaba.fastjson.JSON.parseObject(this.info, (com.alibaba.fastjson.TypeReference) obj, new com.alibaba.fastjson.parser.Feature[0]);
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.info("TAG - AppCacheInfo - buildMemoryHolder - info : " + this.info);
            com.up366.common.log.Logger.error("TAG - AppCacheInfo - buildMemoryHolder - meta : " + obj, e);
            throw e;
        }
    }
}
