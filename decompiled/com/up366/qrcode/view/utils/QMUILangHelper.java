package com.up366.qrcode.view.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUILangHelper {
    public static float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static int constrain(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static int getNumberDigits(int i) {
        if (i <= 0) {
            return 0;
        }
        return (int) (java.lang.Math.log10(i) + 1.0d);
    }

    public static int getNumberDigits(long j) {
        if (j <= 0) {
            return 0;
        }
        return (int) (java.lang.Math.log10(j) + 1.0d);
    }

    public static java.lang.String formatNumberToLimitedDigits(int i, int i2) {
        if (getNumberDigits(i) > i2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i3 = 1; i3 <= i2; i3++) {
                sb.append(com.up366.mobile.common.base.Constants.FLIPBOOK_SPID);
            }
            sb.append("+");
            return sb.toString();
        }
        return java.lang.String.valueOf(i);
    }

    public static java.lang.String regularizePrice(float f) {
        return java.lang.String.format(java.util.Locale.CHINESE, "%.2f", java.lang.Float.valueOf(f));
    }

    public static java.lang.String regularizePrice(double d) {
        return java.lang.String.format(java.util.Locale.CHINESE, "%.2f", java.lang.Double.valueOf(d));
    }

    public static boolean isNullOrEmpty(java.lang.CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static void close(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean objectEquals(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
