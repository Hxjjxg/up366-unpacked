package com.up366.medialibrary.widget.longimage;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface ImageRegionDecoder {
    android.graphics.Bitmap decodeRegion(android.graphics.Rect rect, int i);

    android.graphics.Point init(android.content.Context context, android.net.Uri uri) throws java.lang.Exception;

    boolean isReady();

    void recycle();
}
