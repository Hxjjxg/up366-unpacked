package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ImageAttachInfo implements java.io.Serializable {
    private java.lang.String downloadUrl;
    private java.lang.String ext;
    private java.lang.String fileName;
    private java.lang.String id;
    private java.lang.String localPath;
    private long size;
    private java.lang.String viewUrl;

    public ImageAttachInfo() {
    }

    public ImageAttachInfo(java.lang.String str, java.lang.String str2) {
        this.localPath = str;
        java.io.File file = new java.io.File(str);
        this.id = str2;
        this.fileName = file.getName();
        this.size = file.length();
        java.lang.String str3 = this.localPath;
        this.ext = str3.substring(str3.lastIndexOf(".") + 1);
        java.lang.String str4 = this.id;
        this.downloadUrl = str4;
        this.viewUrl = str4;
    }

    public java.lang.String loadLocalPath() {
        return this.localPath;
    }

    public java.lang.String getId() {
        return this.id;
    }

    public void setId(java.lang.String str) {
        this.id = str;
    }

    public java.lang.String getFileName() {
        return this.fileName;
    }

    public void setFileName(java.lang.String str) {
        this.fileName = str;
    }

    public java.lang.String getExt() {
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.ext)) {
            return this.ext;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(this.fileName) || !this.fileName.contains(".")) {
            return "";
        }
        java.lang.String str = this.fileName;
        return str.substring(str.lastIndexOf(".") + 1);
    }

    public void setExt(java.lang.String str) {
        this.ext = str;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public java.lang.String getViewUrl() {
        return this.viewUrl;
    }

    public void setViewUrl(java.lang.String str) {
        this.viewUrl = str;
    }

    public java.lang.String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(java.lang.String str) {
        this.downloadUrl = str;
    }
}
