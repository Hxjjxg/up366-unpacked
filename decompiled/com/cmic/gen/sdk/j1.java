package com.cmic.gen.sdk;

/* JADX INFO: compiled from: TelephonyUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class j1 {
    private static final java.lang.String a = android.os.Build.BRAND;
    private static final java.lang.String b = android.os.Build.MODEL;
    private static final java.lang.String c = "android" + android.os.Build.VERSION.RELEASE;
    private static final boolean d;
    private static final java.lang.String e;

    static {
        d = android.os.Build.VERSION.SDK_INT <= 28;
        e = android.os.Build.MANUFACTURER;
    }

    public static int a(android.content.Context context, boolean z, com.cmic.gen.sdk.i iVar) {
        android.net.ConnectivityManager connectivityManager;
        android.net.NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (android.net.ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            int type = activeNetworkInfo.getType();
            if (type != 1) {
                if (type == 0) {
                    com.cmic.gen.sdk.h0.a("TelephonyUtils", "流量");
                    return 1;
                }
                return 0;
            }
            com.cmic.gen.sdk.h0.a("TelephonyUtils", com.up366.common.NetworkUtilsUp.TYPE_WIFI);
            boolean zA = com.cmic.gen.sdk.t0.a(context, "android.permission.CHANGE_NETWORK_STATE");
            com.cmic.gen.sdk.h0.b("TelephonyUtils", "CHANGE_NETWORK_STATE=" + zA);
            if (!zA || !z || !a(connectivityManager, context, iVar)) {
                return 2;
            }
            com.cmic.gen.sdk.h0.a("TelephonyUtils", "流量数据 WIFI 同开");
            return 3;
        }
        return 0;
    }

    public static java.lang.String b() {
        return a;
    }

    public static java.lang.String c() {
        return b;
    }

    public static boolean d() {
        java.lang.String str = e;
        com.cmic.gen.sdk.h0.b("brand", str);
        return "HUAWEI".equalsIgnoreCase(str);
    }

    public static boolean e() {
        return d;
    }

    private static boolean a(android.net.ConnectivityManager connectivityManager, android.content.Context context, com.cmic.gen.sdk.i iVar) {
        boolean zBooleanValue;
        try {
            java.lang.reflect.Method declaredMethod = android.net.ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", null);
            declaredMethod.setAccessible(true);
            zBooleanValue = ((java.lang.Boolean) declaredMethod.invoke(connectivityManager, null)).booleanValue();
            try {
                com.cmic.gen.sdk.h0.a("TelephonyUtils", "data is on ---------" + zBooleanValue);
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        if (com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(telephonyManager, com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m()))) {
                            iVar.b("networkTypeByAPI", "1");
                        } else {
                            iVar.b("networkTypeByAPI", "0");
                        }
                    }
                } else {
                    iVar.b("networkTypeByAPI", "-1");
                }
                return zBooleanValue;
            } catch (java.lang.Exception unused) {
                com.cmic.gen.sdk.h0.b("TelephonyUtils", "isMobileEnabled ----反射出错-----");
                return zBooleanValue;
            }
        } catch (java.lang.Exception unused2) {
            zBooleanValue = false;
        }
    }

    public static java.lang.String a() {
        return c;
    }

    public static boolean a(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null || 1 != telephonyManager.getSimState();
    }
}
