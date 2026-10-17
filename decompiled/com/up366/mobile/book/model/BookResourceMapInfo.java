package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookResourceMapInfo extends com.up366.mobile.common.logic.model.DBModel {
    public long addTime;
    public java.lang.String bookId;
    public long expireTime;
    public java.lang.String fileId;
    public java.lang.String key;
    public java.lang.String path;
    public long rowId;

    public BookResourceMapInfo() {
    }

    public BookResourceMapInfo(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.key = str;
        this.bookId = str2;
        this.path = str3;
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        this.addTime = currentNtpTimeInMillisecond;
        this.expireTime = currentNtpTimeInMillisecond + com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3;
    }

    public java.lang.String toString() {
        return "BookResourceMapInfo{rowId=" + this.rowId + ", path='" + this.path + "', bookId='" + this.bookId + "', fileId='" + this.fileId + "', key='" + this.key + "', expireTime=" + this.expireTime + ", addTime=" + this.addTime + '}';
    }

    public long getRowId() {
        return this.rowId;
    }

    public void setRowId(long j) {
        this.rowId = j;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public void setPath(java.lang.String str) {
        this.path = str;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getFileId() {
        return this.fileId;
    }

    public void setFileId(java.lang.String str) {
        this.fileId = str;
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public void setKey(java.lang.String str) {
        this.key = str;
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
}
