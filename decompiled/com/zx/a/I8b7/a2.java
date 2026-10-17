package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class a2 {
    public static com.zx.a.I8b7.a2 a(com.zx.a.I8b7.e1 e1Var, java.lang.String str) {
        java.nio.charset.Charset.forName("UTF-8");
        if (e1Var != null && e1Var.a() == null) {
            java.nio.charset.Charset.forName("UTF-8");
            e1Var = com.zx.a.I8b7.e1.b(e1Var + "; charset=utf-8");
        }
        return a(e1Var, str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }

    public static com.zx.a.I8b7.a2 a(com.zx.a.I8b7.e1 e1Var, byte[] bArr) {
        int length = bArr.length;
        long length2 = bArr.length;
        long j = 0;
        long j2 = length;
        if ((j | j2) >= 0 && j <= length2 && length2 - j >= j2) {
            return new com.zx.a.I8b7.z1(e1Var, length, bArr, 0);
        }
        throw new java.lang.ArrayIndexOutOfBoundsException();
    }
}
