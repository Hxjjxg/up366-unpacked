package com.up366.view.crop.callback;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface BitmapLoadCallback {
    void onBitmapLoaded(android.graphics.Bitmap bitmap, com.up366.view.crop.model.ExifInfo exifInfo, java.lang.String str, java.lang.String str2);

    void onFailure(java.lang.Exception exc);
}
