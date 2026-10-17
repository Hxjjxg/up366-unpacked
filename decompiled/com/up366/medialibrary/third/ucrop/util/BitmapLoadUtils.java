package com.up366.medialibrary.third.ucrop.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BitmapLoadUtils {
    private static final java.lang.String TAG = "BitmapLoadUtils";

    public static int exifToDegrees(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int exifToTranslation(int i) {
        return (i == 2 || i == 7 || i == 4 || i == 5) ? -1 : 1;
    }

    public static void decodeBitmapInBackground(android.content.Context context, android.net.Uri uri, android.net.Uri uri2, int i, int i2, int i3, int i4, com.up366.medialibrary.third.ucrop.callback.BitmapLoadCallback bitmapLoadCallback) {
        new com.up366.medialibrary.third.ucrop.task.BitmapLoadTask(context, uri, uri2, i, i2, i3, i4, bitmapLoadCallback).executeOnExecutor(java.util.concurrent.Executors.newCachedThreadPool(), new java.lang.Void[0]);
    }

    public static android.graphics.Bitmap transformBitmap(android.graphics.Bitmap bitmap, android.graphics.Matrix matrix) {
        try {
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return !bitmap.sameAs(bitmapCreateBitmap) ? bitmapCreateBitmap : bitmap;
        } catch (java.lang.OutOfMemoryError e) {
            android.util.Log.e(TAG, "transformBitmap: ", e);
            return bitmap;
        }
    }

    public static int calculateInSampleSize(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return 2;
        }
        if (i == i3 && i2 == i4) {
            return 2;
        }
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            while (true) {
                if (i2 / i5 <= i4 && i / i5 <= i3) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }

    public static int getExifOrientation(android.content.Context context, android.net.Uri uri) {
        try {
            java.io.InputStream contentResolverOpenInputStream = com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(context, uri);
            if (contentResolverOpenInputStream == null) {
                return 0;
            }
            return new com.up366.medialibrary.third.ucrop.util.ImageHeaderParser(contentResolverOpenInputStream).getOrientation();
        } catch (java.io.IOException e) {
            android.util.Log.e(TAG, "getExifOrientation: " + uri.toString(), e);
            return 0;
        }
    }

    public static int calculateMaxBitmapSize(android.content.Context context) {
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        android.graphics.Point point = new android.graphics.Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int iSqrt = (int) java.lang.Math.sqrt(java.lang.Math.pow(point.x, 2.0d) + java.lang.Math.pow(point.y, 2.0d));
        android.graphics.Canvas canvas = new android.graphics.Canvas();
        int iMin = java.lang.Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (iMin > 0) {
            iSqrt = java.lang.Math.min(iSqrt, iMin);
        }
        int maxTextureSize = com.up366.medialibrary.third.ucrop.util.EglUtils.getMaxTextureSize();
        if (maxTextureSize > 0) {
            iSqrt = java.lang.Math.min(iSqrt, maxTextureSize);
        }
        android.util.Log.d(TAG, "maxBitmapSize: " + iSqrt);
        return iSqrt;
    }

    public static void close(java.io.Closeable closeable) {
        if (closeable instanceof java.io.Closeable) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }
}
