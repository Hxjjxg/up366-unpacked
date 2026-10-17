package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FileInfo {

    @com.alibaba.fastjson.annotation.JSONField(name = "downloadUrl")
    private java.lang.String downloadUrl;

    @com.alibaba.fastjson.annotation.JSONField(name = "extname")
    private java.lang.String extName;

    @com.alibaba.fastjson.annotation.JSONField(name = "extTime")
    private java.lang.String extTime;

    @com.alibaba.fastjson.annotation.JSONField(name = "extType")
    private int extType;

    @com.alibaba.fastjson.annotation.JSONField(name = "fileId")
    private java.lang.String fileId;

    @com.alibaba.fastjson.annotation.JSONField(name = "filemd5")
    private java.lang.String fileMd5;

    @com.alibaba.fastjson.annotation.JSONField(name = "filename")
    private java.lang.String fileName;

    @com.alibaba.fastjson.annotation.JSONField(name = "filesize")
    private long fileSize;

    public java.lang.String getExtTime() {
        return this.extTime;
    }

    public void setExtTime(java.lang.String str) {
        this.extTime = str;
    }

    public int getExtType() {
        return this.extType;
    }

    public void setExtType(int i) {
        this.extType = i;
    }

    public boolean isEncrypted() {
        java.lang.String str = this.extTime;
        return (str == null || str.trim().length() <= 0 || this.extType == 0) ? false : true;
    }

    public java.lang.String getExtName() {
        return this.extName;
    }

    public void setExtName(java.lang.String str) {
        this.extName = str;
    }

    public java.lang.String getFileId() {
        return this.fileId;
    }

    public void setFileId(java.lang.String str) {
        this.fileId = str;
    }

    public java.lang.String getFileMd5() {
        return this.fileMd5;
    }

    public void setFileMd5(java.lang.String str) {
        this.fileMd5 = str;
    }

    public java.lang.String getFileName() {
        return this.fileName;
    }

    public void setFileName(java.lang.String str) {
        this.fileName = str;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public java.lang.String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(java.lang.String str) {
        this.downloadUrl = str;
    }
}
