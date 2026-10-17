package com.igexin.push.d.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class k extends com.igexin.push.d.c.c {
    public static final int a = 5;
    public boolean b;
    public boolean c;
    public java.lang.String d;
    public java.lang.String e;
    public long f;

    public k() {
        this.m = 5;
    }

    @Override // com.igexin.push.d.c.c, com.igexin.c.a.d.a.a
    public final void a() {
        this.e = null;
        this.d = null;
    }

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
        byte b = bArr[0];
        int i = 1;
        this.b = (b & 64) != 0;
        boolean z = (b & 128) != 0;
        this.c = z;
        if (z) {
            this.d = a(b);
            int iB = com.igexin.c.a.b.g.b(bArr, 1);
            i = iB + 3;
            try {
                this.e = new java.lang.String(bArr, 3, iB, this.d);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        if (bArr.length > i) {
            this.f = com.igexin.c.a.b.g.d(bArr, i);
            com.igexin.c.a.c.a.a("LoginResult|session = " + this.f, new java.lang.Object[0]);
        }
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        int length;
        int i;
        byte bA = this.b ? (byte) 64 : (byte) 0;
        int iB = 1;
        byte[] bytes = null;
        if (this.c) {
            byte b = (byte) (bA | 128);
            try {
                bytes = this.e.getBytes(this.d);
                length = bytes.length;
                i = length + 3;
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
                i = 3;
                length = 0;
            }
            bA = (byte) (b | a(this.d));
        } else {
            length = 0;
            i = 1;
        }
        byte[] bArr = new byte[i + 8];
        bArr[0] = bA;
        if (this.c) {
            iB = com.igexin.c.a.b.g.b(length, bArr, 1);
            if (bytes != null) {
                iB = com.igexin.c.a.b.g.a(bytes, bArr, 2, length) + 2;
            }
        }
        com.igexin.c.a.b.g.a(this.f, bArr, iB);
        return bArr;
    }
}
