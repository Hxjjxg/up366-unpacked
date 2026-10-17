package com.cmic.gen.sdk;

/* JADX INFO: compiled from: UmcUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class x1 {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static java.lang.String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new java.lang.String(cArr);
    }

    public static byte[] b() {
        byte[] bArr = new byte[16];
        new java.security.SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static java.lang.String c() {
        return d().replace("-", "");
    }

    private static java.lang.String d() {
        return java.util.UUID.randomUUID().toString();
    }

    public static void c(com.cmic.gen.sdk.i iVar, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(iVar.a("interfaceType", ""))) {
            iVar.b("interfaceType", str);
            return;
        }
        iVar.b("interfaceType", iVar.c("interfaceType") + ";" + str);
    }

    public static void b(com.cmic.gen.sdk.i iVar, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(iVar.a("interfaceElasped", ""))) {
            iVar.b("interfaceElasped", str);
            return;
        }
        iVar.b("interfaceElasped", iVar.c("interfaceElasped") + ";" + str);
    }

    public static java.lang.String a() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void a(com.cmic.gen.sdk.i iVar, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(iVar.a("interfaceCode", ""))) {
            iVar.b("interfaceCode", str);
            return;
        }
        iVar.b("interfaceCode", iVar.c("interfaceCode") + ";" + str);
    }

    public static boolean a(com.cmic.gen.sdk.s1 s1Var) {
        return com.cmic.gen.sdk.h1.a("logCloseTime", 0L) + ((long) (s1Var.f() * 3600000)) >= java.lang.System.currentTimeMillis();
    }
}
