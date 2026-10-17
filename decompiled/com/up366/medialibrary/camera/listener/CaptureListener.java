package com.up366.medialibrary.camera.listener;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface CaptureListener {
    void recordEnd(long j);

    void recordError();

    void recordShort(long j);

    void recordStart();

    void recordZoom(float f);

    void takePictures();
}
