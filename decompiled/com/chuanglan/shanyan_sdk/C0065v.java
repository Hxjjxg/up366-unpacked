package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public final class C0065v {
    private static volatile com.chuanglan.shanyan_sdk.C0065v a;
    private static volatile java.lang.String b;
    private static volatile java.lang.String c;
    private static volatile java.lang.String d;
    private static volatile int e;
    private static volatile long f;
    private static volatile java.lang.String g;
    private static volatile java.lang.String h;
    private static volatile java.lang.String i;
    private static volatile java.lang.String j;
    private static volatile java.lang.String k;
    private static volatile java.lang.String l;
    private static volatile java.lang.String m;
    private static volatile long n;

    private C0065v() {
    }

    public static com.chuanglan.shanyan_sdk.C0065v g() {
        if (a == null) {
            synchronized (com.chuanglan.shanyan_sdk.C0065v.class) {
                if (a == null) {
                    a = new com.chuanglan.shanyan_sdk.C0065v();
                }
            }
        }
        return a;
    }

    public java.lang.String a() {
        if (l == null && com.chuanglan.shanyan_sdk.AbstractC0055l.G) {
            l = android.os.Build.MODEL;
        }
        return l;
    }

    public java.lang.String b() {
        if (j == null && com.chuanglan.shanyan_sdk.AbstractC0055l.G) {
            j = android.os.Build.BRAND;
        }
        return j;
    }

    public java.lang.String c() {
        if (k == null && com.chuanglan.shanyan_sdk.AbstractC0055l.G) {
            k = android.os.Build.DISPLAY;
        }
        return k;
    }

    public java.lang.String d(android.content.Context context) {
        if (h == null) {
            h = com.chuanglan.shanyan_sdk.B.a(context);
        }
        return h;
    }

    public java.lang.String e() {
        if (i == null && com.chuanglan.shanyan_sdk.AbstractC0055l.G) {
            i = android.os.Build.MANUFACTURER.toUpperCase();
        }
        return i;
    }

    public java.lang.String f() {
        if (m == null && com.chuanglan.shanyan_sdk.AbstractC0055l.G) {
            m = android.os.Build.VERSION.RELEASE;
        }
        return m;
    }

    public java.lang.String h() {
        if (d == null) {
            synchronized (com.chuanglan.shanyan_sdk.C0065v.class) {
                if (d == null && com.chuanglan.shanyan_sdk.AbstractC0055l.G) {
                    d = com.chuanglan.shanyan_sdk.o0.a();
                }
            }
        }
        if (d == null) {
            d = "";
        }
        com.chuanglan.shanyan_sdk.Q.c("CheckAuthEnableShanYanLogger", "rom v", d);
        return d;
    }

    private java.lang.String a(android.content.Context context) {
        java.lang.String str;
        java.lang.String strOptString = com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(context).getNetworkType(context).optString("operatortype");
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "cmcc current Type", strOptString);
        if ("1".equals(strOptString)) {
            str = "CMCC";
        } else if ("2".equals(strOptString)) {
            str = "CUCC";
        } else if ("3".equals(strOptString)) {
            str = "CTCC";
        } else if ("4".equals(strOptString)) {
            str = "CMHK";
        } else {
            str = "Unknown_Operator";
        }
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "cmcc current Type end", str);
        return str;
    }

    public java.lang.String b(android.content.Context context) {
        if (java.lang.System.currentTimeMillis() - n > com.igexin.push.config.c.s) {
            b = com.chuanglan.shanyan_sdk.AbstractC0059p.i(context);
            n = java.lang.System.currentTimeMillis();
        } else if (com.chuanglan.shanyan_sdk.AbstractC0059p.b(context, "operator_sub")) {
            b = com.chuanglan.shanyan_sdk.AbstractC0059p.i(context);
        } else if (b == null) {
            synchronized (com.chuanglan.shanyan_sdk.C0065v.class) {
                if (b == null) {
                    b = com.chuanglan.shanyan_sdk.AbstractC0059p.i(context);
                }
            }
        }
        if ((b == null || "Unknown_Operator".equals(b)) && e(context) > 0) {
            b = a(context);
        }
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "current Operator Type", b);
        return b;
    }

    public java.lang.String c(android.content.Context context) {
        if (g == null) {
            g = context.getPackageName();
        }
        return g;
    }

    public java.lang.String d() {
        if (c == null) {
            synchronized (com.chuanglan.shanyan_sdk.C0065v.class) {
                if (c == null) {
                    c = com.chuanglan.shanyan_sdk.AbstractC0050g.a();
                }
            }
        }
        if (c == null) {
            c = "";
        }
        com.chuanglan.shanyan_sdk.Q.c("CheckAuthEnableShanYanLogger", "d f i p ", c);
        return c;
    }

    public int e(android.content.Context context) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - f;
        if (jCurrentTimeMillis > 1000) {
            f = java.lang.System.currentTimeMillis();
            e = com.chuanglan.shanyan_sdk.AbstractC0059p.k(context);
        }
        com.chuanglan.shanyan_sdk.Q.c("CheckAuthEnableShanYanLogger", "current simCount", java.lang.Integer.valueOf(e), java.lang.Long.valueOf(jCurrentTimeMillis));
        return e;
    }
}
