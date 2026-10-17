package com.up366.mobile.common.utils.alifile;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FileMapInfo implements java.lang.Cloneable {
    private long addTime;
    private java.lang.String biz;
    private java.lang.String ext;
    private java.lang.String objectId;
    private java.lang.String path;
    private java.lang.Long rowId;
    private boolean uploaded;
    private java.lang.String url;

    public FileMapInfo(java.lang.Long l, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, long j, boolean z) {
        this.rowId = l;
        this.objectId = str;
        this.path = str2;
        this.biz = str3;
        this.url = str4;
        this.ext = str5;
        this.addTime = j;
        this.uploaded = z;
    }

    public FileMapInfo() {
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public java.lang.String getObjectId() {
        return this.objectId;
    }

    public void setObjectId(java.lang.String str) {
        this.objectId = str;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public void setPath(java.lang.String str) {
        this.path = str;
    }

    public java.lang.String getBiz() {
        return this.biz;
    }

    public void setBiz(java.lang.String str) {
        this.biz = str;
    }

    public java.lang.String getExt() {
        return this.ext;
    }

    public void setExt(java.lang.String str) {
        this.ext = str;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }

    public boolean isUploaded() {
        return this.uploaded;
    }

    public void setUploaded(boolean z) {
        this.uploaded = z;
    }

    public java.lang.String toString() {
        return "FileMapInfo{rowId=" + this.rowId + ", objectId='" + this.objectId + "', path='" + this.path + "', biz='" + this.biz + "', url='" + this.url + "', ext='" + this.ext + "', addTime=" + this.addTime + ", uploaded=" + this.uploaded + '}';
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo = (com.up366.mobile.common.utils.alifile.FileMapInfo) obj;
        return this.addTime == fileMapInfo.addTime && this.uploaded == fileMapInfo.uploaded && java.util.Objects.equals(this.rowId, fileMapInfo.rowId) && java.util.Objects.equals(this.objectId, fileMapInfo.objectId) && java.util.Objects.equals(this.path, fileMapInfo.path) && java.util.Objects.equals(this.biz, fileMapInfo.biz) && java.util.Objects.equals(this.url, fileMapInfo.url) && java.util.Objects.equals(this.ext, fileMapInfo.ext);
    }

    public int hashCode() {
        return java.util.Objects.hash(this.rowId, this.objectId, this.path, this.biz, this.url, this.ext, java.lang.Long.valueOf(this.addTime), java.lang.Boolean.valueOf(this.uploaded));
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.common.utils.alifile.FileMapInfo m729clone() {
        try {
            return (com.up366.mobile.common.utils.alifile.FileMapInfo) super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.IllegalStateException(e);
        }
    }

    public boolean getUploaded() {
        return this.uploaded;
    }
}
