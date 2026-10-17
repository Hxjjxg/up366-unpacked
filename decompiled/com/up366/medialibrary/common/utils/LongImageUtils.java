package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LongImageUtils {
    public static void displayLongPic(android.net.Uri uri, com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.setImage(com.up366.medialibrary.widget.longimage.ImageSource.uri(uri), new com.up366.medialibrary.widget.longimage.ImageViewState(0.0f, new android.graphics.PointF(0.0f, 0.0f), 0));
    }
}
