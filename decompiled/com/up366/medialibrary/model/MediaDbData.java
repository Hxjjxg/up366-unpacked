package com.up366.medialibrary.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MediaDbData {
    public java.util.List<com.up366.medialibrary.model.LocalMedia> data;
    public boolean isHasNextMore;

    public MediaDbData() {
    }

    public MediaDbData(boolean z, java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        this.isHasNextMore = z;
        this.data = list;
    }
}
