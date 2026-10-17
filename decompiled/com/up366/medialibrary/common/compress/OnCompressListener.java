package com.up366.medialibrary.common.compress;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface OnCompressListener {
    void onError(java.lang.Throwable th);

    void onStart();

    void onSuccess(java.util.List<com.up366.medialibrary.model.LocalMedia> list);
}
