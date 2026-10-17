package com.up366.medialibrary.third.ucrop.callback;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface BitmapLoadCallback {
    void onBitmapLoaded(android.graphics.Bitmap bitmap, com.up366.medialibrary.third.ucrop.model.ExifInfo exifInfo, java.lang.String str, java.lang.String str2);

    void onFailure(java.lang.Exception exc);
}
