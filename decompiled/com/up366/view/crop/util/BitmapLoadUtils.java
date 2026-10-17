package com.up366.view.crop.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
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

    public static void decodeBitmapInBackground(android.content.Context context, android.net.Uri uri, android.net.Uri uri2, int i, int i2, com.up366.view.crop.callback.BitmapLoadCallback bitmapLoadCallback) {
        new com.up366.view.crop.task.BitmapLoadTask(context, uri, uri2, i, i2, bitmapLoadCallback).executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
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

    public static int calculateInSampleSize(android.graphics.BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i == 0) {
            i = 1920;
        }
        if (i2 == 0) {
            i2 = 1920;
        }
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (true) {
                if (i6 / i5 <= i2 && i7 / i5 <= i) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }

    public static int getExifOrientation(android.content.Context context, android.net.Uri uri) {
        int orientation = 0;
        try {
            java.io.InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                return 0;
            }
            orientation = new com.up366.view.crop.util.ImageHeaderParser(inputStreamOpenInputStream).getOrientation();
            close(inputStreamOpenInputStream);
            return orientation;
        } catch (java.io.IOException e) {
            android.util.Log.e(TAG, "getExifOrientation: " + uri.toString(), e);
            return orientation;
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
        int maxTextureSize = com.up366.view.crop.util.EglUtils.getMaxTextureSize();
        if (maxTextureSize > 0) {
            iSqrt = java.lang.Math.min(iSqrt, maxTextureSize);
        }
        android.util.Log.d(TAG, "maxBitmapSize: " + iSqrt);
        return iSqrt;
    }

    public static void close(java.io.Closeable closeable) {
        if (closeable == null || !(closeable instanceof java.io.Closeable)) {
            return;
        }
        try {
            closeable.close();
        } catch (java.io.IOException unused) {
        }
    }

    public static int getOpenglRenderLimitValue() {
        int openglRenderLimitEqualAboveLollipop = getOpenglRenderLimitEqualAboveLollipop();
        if (openglRenderLimitEqualAboveLollipop == 0) {
            return 4096;
        }
        return openglRenderLimitEqualAboveLollipop;
    }

    private static int getOpenglRenderLimitBelowLollipop() {
        int[] iArr = new int[1];
        android.opengl.GLES10.glGetIntegerv(3379, iArr, 0);
        return iArr[0];
    }

    private static int getOpenglRenderLimitEqualAboveLollipop() {
        javax.microedition.khronos.egl.EGL10 egl10 = (javax.microedition.khronos.egl.EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();
        javax.microedition.khronos.egl.EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
        javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr = new javax.microedition.khronos.egl.EGLConfig[1];
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12351, 12430, 12329, 0, 12339, 1, 12344}, eGLConfigArr, 1, iArr);
        int i = iArr[0];
        javax.microedition.khronos.egl.EGLConfig eGLConfig = eGLConfigArr[0];
        javax.microedition.khronos.egl.EGLSurface eGLSurfaceEglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eGLDisplayEglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344});
        javax.microedition.khronos.egl.EGLContext eGLContextEglCreateContext = egl10.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfig, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT, new int[]{12440, 1, 12344});
        egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext);
        int[] iArr2 = new int[1];
        android.opengl.GLES10.glGetIntegerv(3379, iArr2, 0);
        egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE, javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT);
        egl10.eglDestroySurface(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface);
        egl10.eglDestroyContext(eGLDisplayEglGetDisplay, eGLContextEglCreateContext);
        egl10.eglTerminate(eGLDisplayEglGetDisplay);
        return iArr2[0];
    }

    public static android.graphics.Bitmap compressBitmap(android.graphics.Bitmap bitmap, int i, int i2, int i3) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i >= width) {
            i = width;
        }
        if (i2 >= height) {
            i2 = height;
        }
        float fMin = java.lang.Math.min(i / width, i2 / height);
        if (fMin > 1.0f) {
            fMin = 1.0f;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(fMin, fMin);
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
