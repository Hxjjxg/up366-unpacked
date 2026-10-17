package com.up366.multimedia.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PictureDeleteUpdateEvent {
    private java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems;
    private java.lang.String viewId;

    public PictureDeleteUpdateEvent(java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems, java.lang.String viewId) {
        this.imageItems = imageItems;
        this.viewId = viewId;
    }

    public java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> getImageItems() {
        return this.imageItems;
    }

    public void setImageItems(java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems) {
        this.imageItems = imageItems;
    }

    public java.lang.String getViewId() {
        return this.viewId;
    }

    public void setViewId(java.lang.String viewId) {
        this.viewId = viewId;
    }
}
