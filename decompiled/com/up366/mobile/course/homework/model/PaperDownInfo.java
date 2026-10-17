package com.up366.mobile.course.homework.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class PaperDownInfo {

    @com.alibaba.fastjson.annotation.JSONField(name = "downloadurl")
    private java.lang.String downloadUrl;

    @com.alibaba.fastjson.annotation.JSONField(name = "extname")
    private java.lang.String extName;

    @com.alibaba.fastjson.annotation.JSONField(name = "fileId")
    private java.lang.String fileId;

    @com.alibaba.fastjson.annotation.JSONField(name = "filemd5")
    private java.lang.String fileMd5;

    @com.alibaba.fastjson.annotation.JSONField(name = "filesize")
    private int fileSize;

    @com.alibaba.fastjson.annotation.JSONField(name = "filename")
    private java.lang.String filename;

    @com.alibaba.fastjson.annotation.JSONField(name = "htmlviewurl")
    private java.lang.String viewUrl;

    public java.lang.String getFilename() {
        return this.filename;
    }

    public void setFilename(java.lang.String str) {
        this.filename = str;
    }

    public java.lang.String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(java.lang.String str) {
        this.downloadUrl = str;
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

    public int getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(int i) {
        this.fileSize = i;
    }

    public java.lang.String getViewUrl() {
        return this.viewUrl;
    }

    public void setViewUrl(java.lang.String str) {
        this.viewUrl = str;
    }

    public java.lang.String toString() {
        return "PaperDownInfo{filename='" + this.filename + "', downloadUrl='" + this.downloadUrl + "', extName='" + this.extName + "', fileId='" + this.fileId + "', fileMd5='" + this.fileMd5 + "', fileSize=" + this.fileSize + ", viewUrl='" + this.viewUrl + "'}";
    }
}
