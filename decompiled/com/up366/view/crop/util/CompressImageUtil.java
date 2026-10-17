package com.up366.view.crop.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CompressImageUtil {
    public static android.graphics.Bitmap resize(android.graphics.Bitmap bitmap, int i, int i2) {
        if (i2 <= 0 || i <= 0) {
            return bitmap;
        }
        float width = bitmap.getWidth() / bitmap.getHeight();
        float f = i;
        float f2 = i2;
        if (f / f2 > width) {
            i = (int) (f2 * width);
        } else {
            i2 = (int) (f / width);
        }
        return android.graphics.Bitmap.createScaledBitmap(bitmap, i, i2, true);
    }
}
