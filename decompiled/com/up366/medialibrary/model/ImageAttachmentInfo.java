package com.up366.medialibrary.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ImageAttachmentInfo<T> extends com.up366.medialibrary.model.AttachmentInfo<T> {
    private int height;
    private int width;

    public ImageAttachmentInfo() {
        this.type = 2;
    }

    @Override // com.up366.medialibrary.model.AttachmentInfo
    public void setPath(java.lang.String str) {
        java.io.File cacheFile2;
        super.setPath(str);
        if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(str) || (cacheFile2 = com.up366.medialibrary.helper.MediaHelperManager.getSaveHelper().getCacheFile2(str)) == null || com.up366.common.FileUtilsUp.isFileExists(cacheFile2)) {
            return;
        }
        this.localPath = cacheFile2.getAbsolutePath();
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public android.net.Uri getLocalUri() {
        return com.up366.medialibrary.common.utils.UriUtils.getLocalUriFromString(this.localPath);
    }

    public java.lang.String toString() {
        return "ImageAttachmentInfo{path='" + this.path + "', localPath='" + this.localPath + "', type=" + this.type + ", relatedKey=" + this.relatedKey + ", height=" + this.height + '}';
    }
}
