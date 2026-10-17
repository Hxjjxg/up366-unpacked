package com.igexin.assist.control.oppo;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Utils {
    public static java.lang.String getAppKeyByBuildConfig(android.content.pm.ApplicationInfo applicationInfo) {
        try {
            java.lang.String string = applicationInfo.metaData.getString(com.igexin.push.core.b.a);
            if (android.text.TextUtils.isEmpty(string)) {
                string = applicationInfo.packageName;
            }
            java.lang.Class<?> cls = java.lang.Class.forName(string + ".BuildConfig");
            return (java.lang.String) cls.getField("OPPO_APP_KEY").get(cls);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String getAppSecretByBuildConfig(android.content.pm.ApplicationInfo applicationInfo) {
        try {
            java.lang.String string = applicationInfo.metaData.getString(com.igexin.push.core.b.a);
            if (android.text.TextUtils.isEmpty(string)) {
                string = applicationInfo.packageName;
            }
            java.lang.Class<?> cls = java.lang.Class.forName(string + ".BuildConfig");
            return (java.lang.String) cls.getField("OPPO_APP_SECRET").get(cls);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }
}
