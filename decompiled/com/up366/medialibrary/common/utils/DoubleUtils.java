package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DoubleUtils {
    private static final long TIME = 800;
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (jCurrentTimeMillis - lastClickTime < 800) {
            return true;
        }
        lastClickTime = jCurrentTimeMillis;
        return false;
    }
}
