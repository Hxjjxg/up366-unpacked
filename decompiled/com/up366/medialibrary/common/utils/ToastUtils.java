package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class ToastUtils {
    private static final long TIME = 1500;
    private static long lastToastTime;

    public static void s(android.content.Context context, java.lang.String str) {
        if (isShowToast()) {
            return;
        }
        android.widget.Toast.makeText(context.getApplicationContext(), str, 0).show();
    }

    public static boolean isShowToast() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (jCurrentTimeMillis - lastToastTime < 1500) {
            return true;
        }
        lastToastTime = jCurrentTimeMillis;
        return false;
    }
}
