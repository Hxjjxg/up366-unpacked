package com.igexin.push.core.i.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class k {
    private k() {
    }

    public static int a(android.graphics.Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (java.lang.NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new java.lang.IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static <T> T a(T t) {
        t.getClass();
        return t;
    }

    public static void a(boolean z, java.lang.String str) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(str));
        }
    }
}
