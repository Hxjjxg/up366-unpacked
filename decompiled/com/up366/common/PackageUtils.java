package com.up366.common;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PackageUtils {
    private static final java.lang.String WX_PACKAGE_NAME = "com.tencent.mm";
    private static int kDefaultVersionCode = 1;
    private static java.lang.String kDefaultVersionName = "";

    public static int getVersionCode() {
        int i = kDefaultVersionCode;
        if (i != 1) {
            return i;
        }
        try {
            android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
            kDefaultVersionCode = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 128).versionCode;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("failed to get package version code,Exception:" + e.getMessage(), e);
        }
        return kDefaultVersionCode;
    }

    public static java.lang.String getVersionName() {
        if (!"".equals(kDefaultVersionName)) {
            return kDefaultVersionName;
        }
        try {
            android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
            kDefaultVersionName = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 128).versionName;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("failed to get package vesion name,Exception:" + e.getMessage(), e);
        }
        return kDefaultVersionName;
    }

    public static boolean isAppInstalled(java.lang.String str) {
        try {
            return com.up366.common.global.GB.get().getApplicationContext().getPackageManager().getPackageInfo(str, 0) != null;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("isAppInstalled,Exception:" + e.getMessage(), e);
            return false;
        }
    }

    public static boolean isWXInstalled() {
        return isAppInstalled(WX_PACKAGE_NAME);
    }

    public static boolean isApkPackageName(java.io.File file, java.lang.String str) {
        if (file == null || !file.isFile() || !file.exists() || com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return false;
        }
        return str.equals(com.up366.common.global.GB.get().getApplicationContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1).packageName);
    }
}
