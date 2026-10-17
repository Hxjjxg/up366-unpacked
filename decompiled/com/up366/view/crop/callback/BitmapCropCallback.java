package com.up366.view.crop.callback;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface BitmapCropCallback {
    void onBitmapCropped(android.net.Uri uri, int i, int i2, int i3, int i4);

    void onCropFailure(java.lang.Throwable th);
}
