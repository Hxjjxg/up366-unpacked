package com.davemorrissey.labs.subscaleview.decoder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public interface ImageRegionDecoder {
    android.graphics.Bitmap decodeRegion(android.graphics.Rect rect, int i);

    android.graphics.Point init(android.content.Context context, android.net.Uri uri) throws java.lang.Exception;

    boolean isReady();

    void recycle();
}
