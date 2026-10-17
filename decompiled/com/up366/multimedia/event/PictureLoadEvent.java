package com.up366.multimedia.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PictureLoadEvent {
    public static final int ERROR = -1;
    public static final int OK = 0;
    private java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems;
    private int resultCode;
    private java.lang.String viewId;

    public PictureLoadEvent(int resultCode) {
        this.resultCode = resultCode;
        this.viewId = com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().getViewId();
    }

    public PictureLoadEvent(java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems) {
        this.resultCode = 0;
        this.imageItems = imageItems;
        this.viewId = com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().getViewId();
    }

    public PictureLoadEvent(java.lang.String filePath) {
        this.resultCode = 0;
        java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> arrayList = new java.util.ArrayList<>();
        arrayList.add(new com.up366.multimedia.util.AlbumHelper.ImageItem(java.lang.String.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()), filePath, com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
        this.imageItems = arrayList;
        this.viewId = com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().getViewId();
    }

    public PictureLoadEvent(java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems, java.lang.String viewId) {
        this.resultCode = 0;
        this.imageItems = imageItems;
        this.viewId = viewId;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
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

    public java.lang.String[] getDatas() {
        java.lang.String[] strArr = new java.lang.String[this.imageItems.size()];
        for (int i = 0; i < this.imageItems.size(); i++) {
            strArr[i] = this.imageItems.get(i).imagePath;
        }
        return strArr;
    }
}
