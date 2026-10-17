package com.cmic.gen.sdk;

/* JADX INFO: compiled from: SIMUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class c1 {
    private static com.cmic.gen.sdk.c1 d;
    private final android.content.Context a;
    private long b = 0;
    private java.lang.String c = "";

    private c1(android.content.Context context) {
        this.a = context;
    }

    public static void a(android.content.Context context) {
        d = new com.cmic.gen.sdk.c1(context);
    }

    public static com.cmic.gen.sdk.c1 b() {
        return d;
    }

    public java.lang.String a() {
        try {
            int iA = com.cmic.gen.sdk.q1.a().b().a();
            return iA >= 0 ? java.lang.Integer.toString(iA) : "";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private java.lang.String a(java.lang.String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "45412":
                com.cmic.gen.sdk.h0.a("SIMUtils", "香港移动");
                return "4";
            case "46000":
            case "46002":
            case "46004":
            case "46007":
                com.cmic.gen.sdk.h0.b("SIMUtils", "中国移动");
                return "1";
            case "46001":
            case "46006":
            case "46009":
                com.cmic.gen.sdk.h0.b("SIMUtils", "中国联通");
                return "2";
            case "46003":
            case "46005":
            case "46011":
                com.cmic.gen.sdk.h0.b("SIMUtils", "中国电信");
                return "3";
            default:
                return "0";
        }
    }

    public java.lang.String a(java.lang.String str, boolean z) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = a(z);
        }
        return a(str);
    }

    public java.lang.String a(boolean z) {
        if (!z) {
            return "";
        }
        if (java.lang.System.currentTimeMillis() - this.b > com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS) {
            this.b = java.lang.System.currentTimeMillis();
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) this.a.getSystemService("phone");
            if (telephonyManager != null) {
                this.c = telephonyManager.getSimOperator();
                com.cmic.gen.sdk.h0.a("SIMUtils", "getSimOperator SysOperator= " + this.c);
                return this.c;
            }
            return "";
        }
        com.cmic.gen.sdk.h0.a("SIMUtils", "使用缓存operator Operator= " + this.c);
        return this.c;
    }
}
