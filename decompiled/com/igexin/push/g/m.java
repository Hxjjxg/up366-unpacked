package com.igexin.push.g;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class m {
    public static android.graphics.Bitmap a(java.lang.String str) {
        if (str != null) {
            try {
                android.graphics.Bitmap bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(str);
                if (bitmapDecodeFile != null) {
                    return bitmapDecodeFile;
                }
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        return null;
    }
}
