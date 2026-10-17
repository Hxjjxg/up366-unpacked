package com.up366.mobile.common.base;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Constants {
    public static final java.lang.String APP_CACHE_AUTO_LOGIN_FAILED = "APP_CACHE_AUTO_LOGIN_FAILED";
    public static final java.lang.String CHECK_FILE = "checkFile";
    public static final short CLIENT_TYPE_ANDROID = 1;
    public static final java.lang.String DEFAULT_SPID = "0001";
    public static final java.lang.String FLIPBOOK_SPID = "9";
    public static byte[] sign;
    private static int st;

    static {
        try {
            sign = com.up366.common.global.GB.get().getApplicationContext().getPackageManager().getPackageInfo(com.up366.common.global.GB.get().getApplicationContext().getPackageName(), 64).signatures[0].toByteArray();
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.up366.common.log.Logger.error(e.getMessage(), e);
        }
        st = 11;
    }
}
