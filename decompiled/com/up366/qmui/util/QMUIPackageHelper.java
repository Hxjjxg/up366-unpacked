package com.up366.qmui.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIPackageHelper {
    private static java.lang.String appVersionName = null;
    private static int fixVersion = -1;
    private static java.lang.String majorMinorVersion = null;
    private static int majorVersion = -1;
    private static int minorVersion = -1;

    public static java.lang.String getAppVersion(android.content.Context context) {
        if (appVersionName == null) {
            try {
                appVersionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        java.lang.String str = appVersionName;
        return str == null ? "" : str;
    }

    public static java.lang.String getMajorMinorVersion(android.content.Context context) {
        java.lang.String str = majorMinorVersion;
        if (str == null || str.equals("")) {
            majorMinorVersion = getMajorVersion(context) + "." + getMinorVersion(context);
        }
        return majorMinorVersion;
    }

    private static int getMajorVersion(android.content.Context context) {
        if (majorVersion == -1) {
            java.lang.String[] strArrSplit = getAppVersion(context).split("\\.");
            if (strArrSplit.length != 0) {
                majorVersion = java.lang.Integer.parseInt(strArrSplit[0]);
            }
        }
        return majorVersion;
    }

    private static int getMinorVersion(android.content.Context context) {
        if (minorVersion == -1) {
            java.lang.String[] strArrSplit = getAppVersion(context).split("\\.");
            if (strArrSplit.length >= 2) {
                minorVersion = java.lang.Integer.parseInt(strArrSplit[1]);
            }
        }
        return minorVersion;
    }

    public static int getFixVersion(android.content.Context context) {
        if (fixVersion == -1) {
            java.lang.String[] strArrSplit = getAppVersion(context).split("\\.");
            if (strArrSplit.length >= 3) {
                fixVersion = java.lang.Integer.parseInt(strArrSplit[2]);
            }
        }
        return fixVersion;
    }
}
