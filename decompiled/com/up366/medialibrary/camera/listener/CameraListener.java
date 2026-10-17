package com.up366.medialibrary.camera.listener;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface CameraListener {
    void onError(int i, java.lang.String str, java.lang.Throwable th);

    void onPictureSuccess(java.lang.String str);

    void onRecordSuccess(java.lang.String str);
}
