package com.cmic.gen.sdk;

/* JADX INFO: compiled from: OAIDROM.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public final class p0 {
    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            str3 = (java.lang.String) cls.getMethod("get", java.lang.String.class, java.lang.String.class).invoke(cls, str, str2);
        } catch (java.lang.Exception e) {
            com.cmic.gen.sdk.h0.b("OAIDRom", "System property invoke error: " + e);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    public static boolean b() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || android.os.Build.BRAND.equalsIgnoreCase("BLACKSHARK");
    }

    public static boolean c() {
        return a("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE");
    }

    public static boolean d() {
        return !android.text.TextUtils.isEmpty(a("ro.build.version.emui", ""));
    }

    public static boolean e() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("HONOR") || android.os.Build.BRAND.equalsIgnoreCase("HONOR");
    }

    public static boolean f() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") || android.os.Build.BRAND.equalsIgnoreCase("HUAWEI");
    }

    public static boolean g() {
        if (!android.os.Build.MANUFACTURER.equalsIgnoreCase("LENOVO")) {
            java.lang.String str = android.os.Build.BRAND;
            if (!str.equalsIgnoreCase("LENOVO") && !str.equalsIgnoreCase("ZUK")) {
                return false;
            }
        }
        return true;
    }

    public static boolean h() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || android.os.Build.BRAND.equalsIgnoreCase("MEIZU") || android.os.Build.DISPLAY.toUpperCase().contains(com.up366.multimediav2.util.RomUtils.ROM_FLYME);
    }

    public static boolean i() {
        return !android.text.TextUtils.isEmpty(a(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_MIUI, ""));
    }

    public static boolean j() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || android.os.Build.BRAND.equalsIgnoreCase("MOTOLORA");
    }

    public static boolean k() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || android.os.Build.BRAND.equalsIgnoreCase("NUBIA");
    }

    public static boolean l() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || android.os.Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    public static boolean m() {
        if (!android.os.Build.MANUFACTURER.equalsIgnoreCase(com.up366.multimediav2.util.RomUtils.ROM_OPPO)) {
            java.lang.String str = android.os.Build.BRAND;
            if (!str.equalsIgnoreCase(com.up366.multimediav2.util.RomUtils.ROM_OPPO) && !str.equalsIgnoreCase("REALME") && android.text.TextUtils.isEmpty(a("ro.build.version.opporom", ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean n() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || android.os.Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    public static boolean o() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase(com.up366.multimediav2.util.RomUtils.ROM_VIVO) || android.os.Build.BRAND.equalsIgnoreCase(com.up366.multimediav2.util.RomUtils.ROM_VIVO) || !android.text.TextUtils.isEmpty(a("ro.vivo.os.version", ""));
    }

    public static boolean p() {
        if (!android.os.Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            java.lang.String str = android.os.Build.BRAND;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("REDMI")) {
                return false;
            }
        }
        return true;
    }

    public static boolean q() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("ZTE") || android.os.Build.BRAND.equalsIgnoreCase("ZTE");
    }

    public static boolean a() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("ASUS") || android.os.Build.BRAND.equalsIgnoreCase("ASUS");
    }

    public static boolean a(android.content.Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
