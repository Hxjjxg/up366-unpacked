package com.up366.multimedia.builder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MediaBuilder {
    private com.up366.multimedia.views.PictureVideoGridView gridView;
    private volatile java.lang.String outPath;
    private volatile java.lang.String rCropPath;
    private volatile java.lang.String tempPath;
    private java.lang.String viewId;
    private boolean takePhotoSupportZoom = false;
    private boolean selectPictureSupportZoom = false;
    private int apactX = 1;
    private int apactY = 1;
    private int outX = 200;
    private int outY = 200;
    private int albumType = 1;

    public com.up366.multimedia.builder.MediaBuilder setTakePhotoSupportZoomParams(boolean takePhotoSupportZoom, int apactX, int apactY, int outX, int outY) {
        this.takePhotoSupportZoom = takePhotoSupportZoom;
        this.apactX = apactX;
        this.apactY = apactY;
        this.outX = outX;
        this.outY = outY;
        return this;
    }

    public com.up366.multimedia.builder.MediaBuilder setSelectPictureSupportZoomParams(boolean takePhotoSupportZoom, int apactX, int apactY, int outX, int outY) {
        this.takePhotoSupportZoom = takePhotoSupportZoom;
        this.apactX = apactX;
        this.apactY = apactY;
        this.outX = outX;
        this.outY = outY;
        return this;
    }

    public boolean isTakePhotoSupportZoom() {
        return this.takePhotoSupportZoom;
    }

    public com.up366.multimedia.builder.MediaBuilder setTakePhotoSupportZoom(boolean takePhotoSupportZoom) {
        this.takePhotoSupportZoom = takePhotoSupportZoom;
        return this;
    }

    public java.lang.String getrCropPath() {
        return this.rCropPath;
    }

    public com.up366.multimedia.builder.MediaBuilder setrCropPath(java.lang.String rCropPath) {
        this.rCropPath = rCropPath;
        return this;
    }

    public boolean isSelectPictureSupportZoom() {
        return this.selectPictureSupportZoom;
    }

    public com.up366.multimedia.builder.MediaBuilder setSelectPictureSupportZoom(boolean selectPictureSupportZoom) {
        this.selectPictureSupportZoom = selectPictureSupportZoom;
        return this;
    }

    public int getAlbumType() {
        return this.albumType;
    }

    public com.up366.multimedia.builder.MediaBuilder setAlbumType(int albumType) {
        this.albumType = albumType;
        return this;
    }

    public com.up366.multimedia.views.PictureVideoGridView getGridView() {
        return this.gridView;
    }

    public com.up366.multimedia.builder.MediaBuilder setGridView(com.up366.multimedia.views.PictureVideoGridView gridView) {
        this.gridView = gridView;
        return this;
    }

    public java.lang.String getTempPath() {
        return this.tempPath;
    }

    public com.up366.multimedia.builder.MediaBuilder setTempPath(java.lang.String tempPath) {
        this.tempPath = tempPath;
        return this;
    }

    public java.lang.String getOutPath() {
        return this.outPath;
    }

    public com.up366.multimedia.builder.MediaBuilder setOutPath(java.lang.String outPath) {
        this.outPath = outPath;
        return this;
    }

    public java.lang.String getViewId() {
        return this.viewId;
    }

    public com.up366.multimedia.builder.MediaBuilder setViewId(java.lang.String viewId) {
        this.viewId = viewId;
        return this;
    }

    public int getApactX() {
        return this.apactX;
    }

    public com.up366.multimedia.builder.MediaBuilder setApactX(int apactX) {
        this.apactX = apactX;
        return this;
    }

    public int getApactY() {
        return this.apactY;
    }

    public com.up366.multimedia.builder.MediaBuilder setApactY(int apactY) {
        this.apactY = apactY;
        return this;
    }

    public int getOutX() {
        return this.outX;
    }

    public com.up366.multimedia.builder.MediaBuilder setOutX(int outX) {
        this.outX = outX;
        return this;
    }

    public int getOutY() {
        return this.outY;
    }

    public com.up366.multimedia.builder.MediaBuilder setOutY(int outY) {
        this.outY = outY;
        return this;
    }
}
