package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ImageUtils {
    public static android.graphics.BitmapFactory.Options getBitmapOptions(java.lang.String str) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(str, options);
        return options;
    }

    public static android.graphics.BitmapFactory.Options getBitmapOptions(android.content.Context context, android.net.Uri uri) throws java.io.IOException {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.os.ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        android.graphics.BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor(), null, options);
        parcelFileDescriptorOpenFileDescriptor.close();
        return options;
    }

    public static android.graphics.Bitmap getBitmapByUri(android.content.Context context, android.net.Uri uri, android.graphics.BitmapFactory.Options options) throws java.io.IOException {
        android.os.ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        android.graphics.Bitmap bitmapDecodeFileDescriptor = android.graphics.BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor(), null, options);
        parcelFileDescriptorOpenFileDescriptor.close();
        return bitmapDecodeFileDescriptor;
    }
}
