package com.up366.medialibrary.listener;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface OnResultCallbackListener<T> {
    void onCancel();

    void onResult(java.util.List<T> list);
}
