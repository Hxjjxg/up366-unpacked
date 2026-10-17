package com.up366.multimedia.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MediaAttachInfo implements java.io.Serializable {
    private java.lang.String ext;
    private java.lang.String id;
    private java.lang.String name;
    private java.lang.String posterUrl;
    private long size;
    private java.lang.String url;
    private java.lang.String viewUrl;
    private final java.util.regex.Pattern picPattern = java.util.regex.Pattern.compile(".*(png|jpeg|jpg|png|gif|bmp)", 2);
    private final java.util.regex.Pattern audioPattern = java.util.regex.Pattern.compile(".*(mp3|wav)", 2);
    private final java.util.regex.Pattern videoPattern = java.util.regex.Pattern.compile(".*(mp4|avi|mov)", 2);

    public MediaAttachInfo() {
    }

    public MediaAttachInfo(java.lang.String id, java.lang.String name, java.lang.String ext, long size, java.lang.String url, java.lang.String posterUrl, java.lang.String viewUrl) {
        this.id = id;
        this.name = name;
        this.ext = ext;
        this.size = size;
        this.url = url;
        this.posterUrl = posterUrl;
        this.viewUrl = viewUrl;
    }

    public java.lang.String getId() {
        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getExt() {
        return this.ext;
    }

    public void setExt(java.lang.String ext) {
        this.ext = ext;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    public java.lang.String getPosterUrl() {
        return this.posterUrl;
    }

    public void setPosterUrl(java.lang.String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public java.lang.String getViewUrl() {
        return this.viewUrl;
    }

    public void setViewUrl(java.lang.String viewUrl) {
        this.viewUrl = viewUrl;
    }

    public boolean isPicture() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.ext)) {
            return false;
        }
        return this.picPattern.matcher(this.ext).matches();
    }

    public boolean isAudio() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.ext)) {
            return false;
        }
        return this.audioPattern.matcher(this.ext).matches();
    }

    public boolean isVideo() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.ext)) {
            return false;
        }
        return this.videoPattern.matcher(this.ext).matches();
    }
}
