package com.cmic.gen.sdk;

/* JADX INFO: compiled from: PhoneScripUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class u0 {
    private static java.lang.String a = null;
    private static java.lang.String b = null;
    private static java.lang.String c = null;
    private static java.lang.String d = null;
    private static long e = 0;
    private static int f = -1;

    /* JADX INFO: compiled from: PhoneScripUtils.java */
    class a extends com.cmic.gen.sdk.k1.a {
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;

        a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.b = context;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            com.cmic.gen.sdk.h0.a("PhoneScripUtils", "start save scrip to sp in sub thread");
            com.cmic.gen.sdk.u0.b(this.b, this.c, this.d, com.cmic.gen.sdk.u0.e, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(android.content.Context context, java.lang.String str, java.lang.String str2, long j, java.lang.String str3) {
        java.lang.String strB = com.cmic.gen.sdk.c0.b(context, str);
        if (android.text.TextUtils.isEmpty(strB)) {
            return;
        }
        com.cmic.gen.sdk.h1.a aVarA = com.cmic.gen.sdk.h1.a();
        aVarA.a("phonescripcache", strB);
        aVarA.a("phonescripstarttime", j);
        aVarA.a("phonescripversion", 1);
        aVarA.a("pre_sim_key", str3);
        aVarA.c();
    }

    public static long c() {
        long jA;
        long j;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (android.text.TextUtils.isEmpty(a)) {
            java.lang.String strA = com.cmic.gen.sdk.h1.a("phonescripcache", "");
            jA = com.cmic.gen.sdk.h1.a("phonescripstarttime", 0L);
            if (android.text.TextUtils.isEmpty(strA)) {
                j = 0;
            }
            return java.lang.Math.max(j / 1000, 0L);
        }
        com.cmic.gen.sdk.h0.a("PhoneScripUtils", d + " " + e);
        jA = e;
        j = (jA - jCurrentTimeMillis) - com.igexin.push.config.c.i;
        return java.lang.Math.max(j / 1000, 0L);
    }

    public static void a(boolean z, boolean z2) {
        com.cmic.gen.sdk.h1.a aVarA = com.cmic.gen.sdk.h1.a();
        aVarA.a("phonescripstarttime");
        aVarA.a("phonescripcache");
        aVarA.a("securityphone");
        aVarA.a("securityphonecache");
        aVarA.a("pre_sim_key");
        aVarA.a("phonescripversion");
        if (z2) {
            aVarA.a();
        } else {
            aVarA.c();
        }
        if (z) {
            a = null;
            d = null;
            e = 0L;
            f = -1;
        }
    }

    public static java.lang.String b(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(a)) {
            java.lang.String strA = com.cmic.gen.sdk.h1.a("phonescripcache", "");
            if (android.text.TextUtils.isEmpty(strA)) {
                com.cmic.gen.sdk.h0.b("PhoneScripUtils", com.igexin.push.core.b.m);
                return null;
            }
            e = com.cmic.gen.sdk.h1.a("phonescripstarttime", 0L);
            d = com.cmic.gen.sdk.h1.a("pre_sim_key", "");
            f = com.cmic.gen.sdk.h1.a("phonescripversion", -1);
            java.lang.String strA2 = com.cmic.gen.sdk.c0.a(context, strA);
            a = strA2;
            return strA2;
        }
        return a;
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, long j, java.lang.String str3, java.lang.String str4) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str3) || j <= 0) {
            return;
        }
        com.cmic.gen.sdk.h0.a("PhoneScripUtils", "save phone scrip simKey = " + str3);
        a = str;
        long j2 = j * 1000;
        e = java.lang.System.currentTimeMillis() + j2;
        com.cmic.gen.sdk.h0.a("sLifeTime", e + "");
        d = str3;
        f = 1;
        if (!"operator".equals(str4)) {
            com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.u0.a(context, str, str2, str3));
        } else if (j2 > 3600000) {
            e = java.lang.System.currentTimeMillis() + 3600000;
        } else {
            e = java.lang.System.currentTimeMillis() + j2;
        }
    }

    private static boolean b() {
        if (android.text.TextUtils.isEmpty(a)) {
            return !android.text.TextUtils.isEmpty(com.cmic.gen.sdk.h1.a("phonescripcache", "")) && a(com.cmic.gen.sdk.h1.a("phonescripstarttime", 0L));
        }
        com.cmic.gen.sdk.h0.a("PhoneScripUtils", d + " " + e);
        return a(e);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        b = str;
        c = str2;
        com.cmic.gen.sdk.h0.b("PhoneScripUtils", "number=" + str);
        java.lang.String strC = com.cmic.gen.sdk.c0.c(context, str);
        com.cmic.gen.sdk.h0.b("PhoneScripUtils", "encryptStr=" + strC);
        if (android.text.TextUtils.isEmpty(strC)) {
            return;
        }
        com.cmic.gen.sdk.h1.a aVarA = com.cmic.gen.sdk.h1.a();
        aVarA.a("securityphonecache", strC);
        aVarA.a("operatortypecache", c);
        aVarA.c();
    }

    public static java.lang.String a(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(b)) {
            return b;
        }
        java.lang.String strA = com.cmic.gen.sdk.h1.a("securityphone", "");
        if (!android.text.TextUtils.isEmpty(strA)) {
            return strA;
        }
        java.lang.String strA2 = com.cmic.gen.sdk.h1.a("securityphonecache", "");
        com.cmic.gen.sdk.h0.b("PhoneScripUtils", "encryptData=" + strA2);
        if (android.text.TextUtils.isEmpty(strA2)) {
            com.cmic.gen.sdk.h0.b("PhoneScripUtils", com.igexin.push.core.b.m);
            return null;
        }
        return com.cmic.gen.sdk.c0.a(context, strA2);
    }

    private static boolean a(long j) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.cmic.gen.sdk.h0.a("PhoneScripUtils", j + "");
        com.cmic.gen.sdk.h0.a("PhoneScripUtils", jCurrentTimeMillis + "");
        return j - jCurrentTimeMillis > com.igexin.push.config.c.i;
    }

    private static int a(java.lang.String str) {
        java.lang.String strA;
        if (!android.text.TextUtils.isEmpty(d)) {
            strA = d;
        } else {
            strA = com.cmic.gen.sdk.h1.a("pre_sim_key", "");
            d = strA;
        }
        if (android.text.TextUtils.isEmpty(strA)) {
            return 0;
        }
        return strA.equals(str) ? 1 : 2;
    }

    public static boolean a(com.cmic.gen.sdk.i iVar) {
        int iA = a(iVar.c("scripKey"));
        iVar.b("imsiState", iA + "");
        java.lang.StringBuilder sb = new java.lang.StringBuilder("simState = ");
        sb.append(iA);
        com.cmic.gen.sdk.h0.a("PhoneScripUtils", sb.toString());
        if (iA == 0) {
            return false;
        }
        if (f == -1) {
            f = com.cmic.gen.sdk.h1.a("phonescripversion", -1);
        }
        if (f != 1) {
            a(true, false);
            com.cmic.gen.sdk.c0.a();
            com.cmic.gen.sdk.h0.a("PhoneScripUtils", "phoneScriptVersion change");
            return false;
        }
        if (iA == 2) {
            a(true, false);
            return false;
        }
        return b();
    }
}
