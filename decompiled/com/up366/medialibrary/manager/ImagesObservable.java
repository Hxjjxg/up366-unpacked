package com.up366.medialibrary.manager;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ImagesObservable {
    private static final com.up366.medialibrary.manager.ImagesObservable mInstance = new com.up366.medialibrary.manager.ImagesObservable();
    private java.util.List<com.up366.medialibrary.model.LocalMedia> mData = new java.util.ArrayList();

    public static com.up366.medialibrary.manager.ImagesObservable getInstance() {
        return mInstance;
    }

    public void saveData(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        this.mData = list;
    }

    public java.util.List<com.up366.medialibrary.model.LocalMedia> getData() {
        return this.mData;
    }

    public void clearData() {
        this.mData.clear();
    }
}
