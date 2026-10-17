package com.up366.medialibrary.common.engine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface ImageEngine {
    void loadFolderImage(android.content.Context context, java.lang.String str, android.widget.ImageView imageView);

    void loadGridImage(android.content.Context context, java.lang.String str, android.widget.ImageView imageView);

    void loadImage(android.content.Context context, java.lang.String str, android.widget.ImageView imageView);

    void loadImage(android.content.Context context, java.lang.String str, android.widget.ImageView imageView, com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView subsamplingScaleImageView, com.up366.medialibrary.listener.OnImageCompleteCallback onImageCompleteCallback);
}
