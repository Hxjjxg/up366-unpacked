package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class m1 {
    public long a;
    public java.lang.String b;
    public int c;

    public static final class a {
        public static final com.zx.a.I8b7.m1 a = new com.zx.a.I8b7.m1();
    }

    public void a() {
        try {
            this.a = java.lang.System.currentTimeMillis();
            this.b = java.util.UUID.randomUUID().toString().replaceAll("-", "");
            com.zx.a.I8b7.w2 w2Var = com.zx.a.I8b7.w2.a.a;
            java.lang.String strA = w2Var.a.a(24);
            if (!android.text.TextUtils.isEmpty(strA)) {
                this.c = java.lang.Integer.parseInt(strA);
            }
            this.c++;
            com.zx.a.I8b7.h4 h4Var = w2Var.a;
            java.lang.String str = this.c + "";
            h4Var.getClass();
            w2Var.a.a(24, str, true);
            com.zx.a.I8b7.c3.a("process start pts:" + this.a + ", pid:" + this.b + ", rc:" + this.c);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }
}
