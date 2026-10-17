package com.cmic.gen.sdk;

/* JADX INFO: compiled from: PackageUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class s0 {
    public static java.lang.String a(android.content.Context context) {
        java.lang.String str = null;
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            java.lang.String str2 = (java.lang.String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(c(context), 0));
            if (str2 != null) {
                return str2;
            }
            try {
                android.content.pm.PackageInfo packageInfoB = b(context);
                if (packageInfoB == null) {
                    return null;
                }
                return context.getResources().getString(packageInfoB.applicationInfo.labelRes);
            } catch (java.lang.Exception e) {
                e = e;
                str = str2;
                e.printStackTrace();
                return str;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    private static android.content.pm.PackageInfo b(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static java.lang.String c(android.content.Context context) {
        android.content.pm.PackageInfo packageInfoB = b(context);
        return packageInfoB == null ? "" : packageInfoB.packageName;
    }

    public static java.lang.String d(android.content.Context context) {
        try {
            android.content.pm.PackageInfo packageInfoB = b(context);
            if (packageInfoB == null) {
                return "";
            }
            return c(context) + "&" + packageInfoB.versionName;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
