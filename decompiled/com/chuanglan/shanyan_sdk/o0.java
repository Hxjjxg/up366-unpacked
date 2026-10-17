package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class o0 {
    private static java.lang.String a;
    private static java.lang.String b;

    public static java.lang.String a() {
        if (b == null) {
            a("");
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(b)) {
            b = com.chuanglan.shanyan_sdk.C0065v.g().c();
        }
        return b;
    }

    public static java.lang.String b(java.lang.String str) {
        try {
            return (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getMethod("get", java.lang.String.class, java.lang.String.class).invoke(null, str, "");
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static boolean a(java.lang.String str) {
        java.lang.String str2 = a;
        if (str2 != null) {
            return str2.equals(str);
        }
        java.lang.String strB = b(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_MIUI);
        b = strB;
        if (!android.text.TextUtils.isEmpty(strB)) {
            a = com.up366.multimediav2.util.RomUtils.ROM_MIUI;
        } else {
            java.lang.String strB2 = b("ro.build.version.emui");
            b = strB2;
            if (!android.text.TextUtils.isEmpty(strB2)) {
                a = com.up366.multimediav2.util.RomUtils.ROM_EMUI;
            } else {
                java.lang.String strB3 = b("ro.build.version.opporom");
                b = strB3;
                if (!android.text.TextUtils.isEmpty(strB3)) {
                    a = com.up366.multimediav2.util.RomUtils.ROM_OPPO;
                } else {
                    java.lang.String strB4 = b("ro.vivo.os.version");
                    b = strB4;
                    if (!android.text.TextUtils.isEmpty(strB4)) {
                        a = com.up366.multimediav2.util.RomUtils.ROM_VIVO;
                    } else {
                        java.lang.String strB5 = b("ro.smartisan.version");
                        b = strB5;
                        if (!android.text.TextUtils.isEmpty(strB5)) {
                            a = com.up366.multimediav2.util.RomUtils.ROM_SMARTISAN;
                        } else {
                            java.lang.String strC = com.chuanglan.shanyan_sdk.C0065v.g().c();
                            b = strC;
                            if (strC != null && strC.toUpperCase().contains(com.up366.multimediav2.util.RomUtils.ROM_FLYME)) {
                                a = com.up366.multimediav2.util.RomUtils.ROM_FLYME;
                            } else {
                                a = com.chuanglan.shanyan_sdk.C0065v.g().e();
                            }
                        }
                    }
                }
            }
        }
        java.lang.String str3 = a;
        if (str3 == null) {
            return false;
        }
        return str3.equals(str);
    }
}
