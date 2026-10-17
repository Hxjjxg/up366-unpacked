package com.up366.medialibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MediaInfo implements java.io.Serializable {
    private java.lang.String androidQPath;
    private java.lang.String compressPath;
    private long duration;
    private java.lang.String fileName;
    private boolean isOriginal;
    private long length;
    private java.lang.String mimeType;
    private java.lang.String path;
    private java.lang.String realPath;
    private java.lang.String thumbnail;

    public MediaInfo() {
    }

    public MediaInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j, long j2, java.lang.String str5, java.lang.String str6, boolean z, java.lang.String str7) {
        this.path = str;
        this.realPath = str2;
        this.length = j;
        this.duration = j2;
        this.fileName = str5;
        this.mimeType = str6;
        this.isOriginal = z;
        this.thumbnail = str7;
        this.compressPath = str3;
        this.androidQPath = str4;
    }

    public java.lang.String getRealPath() {
        return this.realPath;
    }

    public void setRealPath(java.lang.String str) {
        this.realPath = str;
    }

    public java.lang.String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(java.lang.String str) {
        this.mimeType = str;
    }

    public java.lang.String getFileName() {
        return this.fileName;
    }

    public void setFileName(java.lang.String str) {
        this.fileName = str;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public void setPath(java.lang.String str) {
        this.path = str;
    }

    public long getLength() {
        return this.length;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getSecondDuration() {
        long j = this.duration;
        return (int) ((j / 1000) + ((j % 1000) / 500));
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public boolean isPicture() {
        return com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(this.mimeType);
    }

    public boolean isVideo() {
        return com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(this.mimeType);
    }

    public boolean isOriginal() {
        return this.isOriginal;
    }

    public void setOriginal(boolean z) {
        this.isOriginal = z;
    }

    public java.lang.String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(java.lang.String str) {
        this.thumbnail = str;
    }

    public android.net.Uri getPathUri() {
        return com.up366.medialibrary.common.utils.UriUtils.getLocalUriFromString(this.path);
    }

    public android.net.Uri getThumbnailUri() {
        return com.up366.medialibrary.common.utils.UriUtils.getLocalUriFromString(this.thumbnail);
    }

    public java.lang.String getCompressPath() {
        return this.compressPath;
    }

    public void setCompressPath(java.lang.String str) {
        this.compressPath = str;
    }

    public java.lang.String getAndroidQPath() {
        return this.androidQPath;
    }

    public void setAndroidQPath(java.lang.String str) {
        this.androidQPath = str;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.medialibrary.MediaInfo mediaInfo = (com.up366.medialibrary.MediaInfo) obj;
        return this.length == mediaInfo.length && this.duration == mediaInfo.duration && this.isOriginal == mediaInfo.isOriginal && java.util.Objects.equals(this.thumbnail, mediaInfo.thumbnail) && java.util.Objects.equals(this.path, mediaInfo.path) && java.util.Objects.equals(this.fileName, mediaInfo.fileName) && java.util.Objects.equals(this.mimeType, mediaInfo.mimeType) && java.util.Objects.equals(this.realPath, mediaInfo.realPath) && java.util.Objects.equals(this.compressPath, mediaInfo.compressPath) && java.util.Objects.equals(this.androidQPath, mediaInfo.androidQPath);
    }

    public int hashCode() {
        return java.util.Objects.hash(this.thumbnail, this.path, java.lang.Long.valueOf(this.length), java.lang.Long.valueOf(this.duration), this.fileName, this.mimeType, java.lang.Boolean.valueOf(this.isOriginal), this.realPath, this.compressPath, this.androidQPath);
    }

    public java.lang.String toString() {
        return "MediaInfo{thumbnail='" + this.thumbnail + "', path='" + this.path + "', length=" + this.length + ", duration=" + this.duration + ", fileName='" + this.fileName + "', mimeType='" + this.mimeType + "', isOriginal=" + this.isOriginal + ", realPath='" + this.realPath + "', compressPath='" + this.compressPath + "', androidQPath='" + this.androidQPath + "'}";
    }
}
