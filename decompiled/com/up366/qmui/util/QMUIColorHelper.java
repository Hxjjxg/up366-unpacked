package com.up366.qmui.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIColorHelper {
    public static int setColorAlpha(int i, float f, boolean z) {
        return (i & 16777215) | (((int) (f * (z ? 255 : 255 & (i >> 24)))) << 24);
    }

    public static int setColorAlpha(int i, float f) {
        return setColorAlpha(i, f, true);
    }

    public static int computeColor(int i, int i2, float f) {
        float fConstrain = com.up366.qmui.util.QMUILangHelper.constrain(f, 0.0f, 1.0f);
        return android.graphics.Color.argb(((int) ((android.graphics.Color.alpha(i2) - r0) * fConstrain)) + android.graphics.Color.alpha(i), ((int) ((android.graphics.Color.red(i2) - r0) * fConstrain)) + android.graphics.Color.red(i), ((int) ((android.graphics.Color.green(i2) - r0) * fConstrain)) + android.graphics.Color.green(i), ((int) ((android.graphics.Color.blue(i2) - r4) * fConstrain)) + android.graphics.Color.blue(i));
    }

    public static java.lang.String colorToString(int i) {
        return java.lang.String.format("#%08X", java.lang.Integer.valueOf(i));
    }
}
