package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class v0 implements com.zx.a.I8b7.q0 {
    public com.zx.a.I8b7.s0 a;
    public boolean b = true;

    public v0(com.zx.a.I8b7.s0 s0Var) {
        this.a = (com.zx.a.I8b7.s0) com.zx.a.I8b7.p2.a(s0Var);
    }

    @Override // com.zx.a.I8b7.q0
    public boolean a(int i, java.lang.String str) {
        int i2 = i & 240;
        if (i2 == 0 || i2 == 16) {
            return this.b;
        }
        return false;
    }

    @Override // com.zx.a.I8b7.q0
    public void a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if ((i & 240) != 0) {
            i &= 15;
        }
        this.a.a(i, str, str2, th);
    }
}
