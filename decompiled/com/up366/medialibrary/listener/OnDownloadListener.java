package com.up366.medialibrary.listener;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface OnDownloadListener {
    void onError(int i, java.lang.String str);

    void onProgress(int i, java.lang.String str);

    void onSuccess();
}
