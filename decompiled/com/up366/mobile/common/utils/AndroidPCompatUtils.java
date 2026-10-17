package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AndroidPCompatUtils {
    public static void setWebViewDataDirectorySuffix(android.content.Context context) {
        if (context == null || android.os.Build.VERSION.SDK_INT < 28) {
            return;
        }
        java.lang.String packageName = context.getPackageName();
        java.lang.String appProcessName = com.up366.mobile.common.utils.ProcessUtils.getAppProcessName();
        if (android.text.TextUtils.isEmpty(packageName) || android.text.TextUtils.isEmpty(appProcessName) || android.text.TextUtils.equals(packageName, appProcessName)) {
            return;
        }
        int iIndexOf = appProcessName.indexOf(58);
        java.lang.String strReplace = ((iIndexOf < 0 || iIndexOf >= appProcessName.length() + (-1)) ? appProcessName : appProcessName.substring(iIndexOf + 1)).replace(':', '_');
        try {
            android.webkit.WebView.setDataDirectorySuffix(strReplace);
            com.up366.common.log.Logger.info("setWebViewDataDirectorySuffix success, processName=" + appProcessName + ", suffix=" + strReplace);
        } catch (java.lang.Throwable th) {
            com.up366.common.log.Logger.error("setWebViewDataDirectorySuffix failed, processName=" + appProcessName + ", suffix=" + strReplace, th);
        }
    }

    public static void closeAndroidPDialog() {
        if (android.os.Build.VERSION.SDK_INT <= 27) {
            return;
        }
        try {
            java.lang.Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(java.lang.String.class).setAccessible(true);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("closeAndroidPDialog 1 " + e.getMessage(), e);
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityThread");
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", null);
            declaredMethod.setAccessible(true);
            java.lang.Object objInvoke = declaredMethod.invoke(null, null);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(objInvoke, true);
        } catch (java.lang.Exception e2) {
            com.up366.common.log.Logger.warn("closeAndroidPDialog  2 " + e2.getMessage());
        }
    }
}
