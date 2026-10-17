package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SdkVersionUtils {
    public static boolean isQ() {
        return android.os.Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isR() {
        return android.os.Build.VERSION.SDK_INT >= 30;
    }
}
