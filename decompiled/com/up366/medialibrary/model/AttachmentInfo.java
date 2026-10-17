package com.up366.medialibrary.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AttachmentInfo<T> implements java.io.Serializable {
    public static final int TYPE_PICTURE = 2;
    public static final int TYPE_VIDEO = 1;
    protected java.lang.String localPath;
    protected java.lang.String path;
    protected T relatedKey;
    protected int type;

    protected AttachmentInfo() {
    }

    public void setPath(java.lang.String str) {
        this.path = str;
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(str)) {
            return;
        }
        this.localPath = str;
    }

    public java.lang.String getLocalPath() {
        return this.localPath;
    }

    public java.lang.String getPath() {
        return com.up366.common.StringUtils.isEmptyOrNull(this.localPath) ? this.path : this.localPath;
    }

    public void setLocalPath(java.lang.String str) {
        this.localPath = str;
    }

    public boolean isVideo() {
        return this.type == 1;
    }

    public boolean isPicture() {
        return this.type == 2;
    }

    public T getRelatedKey() {
        return this.relatedKey;
    }

    public void setRelatedKey(T t) {
        this.relatedKey = t;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
