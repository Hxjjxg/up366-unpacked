package com.up366.medialibrary.listener;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface OnPhotoSelectChangedListener<T> {
    void onChange(java.util.List<T> list);

    void onPictureClick(T t, int i);

    void onTakePhoto();
}
