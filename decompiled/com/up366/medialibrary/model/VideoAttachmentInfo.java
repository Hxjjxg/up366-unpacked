package com.up366.medialibrary.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class VideoAttachmentInfo<T> extends com.up366.medialibrary.model.AttachmentInfo<T> {
    private long duration;
    private java.lang.String localThumbnail;
    private java.lang.String thumbnail;
    private int thumbnailHeight;
    private int thumbnailWidth;

    public VideoAttachmentInfo() {
        this.type = 1;
    }

    @Override // com.up366.medialibrary.model.AttachmentInfo
    public void setPath(java.lang.String str) {
        super.setPath(str);
        if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(str)) {
            java.lang.String strMakeAndCacheThumbnail = com.up366.medialibrary.common.utils.ThumbnailUtils.makeAndCacheThumbnail(str);
            this.thumbnail = strMakeAndCacheThumbnail;
            this.localThumbnail = strMakeAndCacheThumbnail;
        } else {
            java.lang.String localVideoPath = com.up366.medialibrary.common.utils.MediaPathUtil.getInst().getLocalVideoPath(str);
            if (com.up366.common.FileUtilsUp.isFileExists(localVideoPath)) {
                this.localPath = localVideoPath;
            }
        }
    }

    public android.net.Uri getLocalThumbnail() {
        return com.up366.medialibrary.common.utils.UriUtils.getLocalUriFromString(this.localThumbnail);
    }

    public java.lang.String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(java.lang.String str) {
        this.thumbnail = str;
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(str)) {
            return;
        }
        this.localThumbnail = str;
    }

    public void setLocalThumbnail(java.lang.String str) {
        this.localThumbnail = str;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public int getThumbnailWidth() {
        return this.thumbnailWidth;
    }

    public void setThumbnailWidth(int i) {
        this.thumbnailWidth = i;
    }

    public int getThumbnailHeight() {
        return this.thumbnailHeight;
    }

    public void setThumbnailHeight(int i) {
        this.thumbnailHeight = i;
    }

    public java.lang.String toString() {
        return "VideoAttachmentInfo{path='" + this.path + "', localPath='" + this.localPath + "', type=" + this.type + ", relatedKey=" + this.relatedKey + ", thumbnail='" + this.thumbnail + "', localThumbnail='" + this.localThumbnail + "', duration=" + this.duration + ", thumbnailWidth=" + this.thumbnailWidth + ", thumbnailHeight=" + this.thumbnailHeight + '}';
    }
}
