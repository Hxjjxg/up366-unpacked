package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class VersionUtils {
    public static boolean isTargetQ() {
        return android.os.Build.VERSION.SDK_INT >= 29 && com.up366.common.global.GB.get().getApplicationContext().getApplicationInfo().targetSdkVersion >= 29;
    }

    public static boolean isExternalStorageLegacy() {
        return com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m();
    }
}
