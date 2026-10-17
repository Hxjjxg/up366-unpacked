package com.igexin.push.d.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class d extends com.igexin.push.d.c.c {
    public static final int a = 6;
    java.lang.String b;
    java.lang.String c;
    java.lang.String d;
    java.lang.String e;

    public d() {
        this.m = 6;
        this.n = (byte) 20;
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
    }

    public d(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.m = 6;
        this.n = (byte) 20;
        this.b = str == null ? "" : str;
        this.c = str2 == null ? "" : str2;
        this.d = str3 == null ? "" : str3;
        this.e = str4 == null ? "" : str4;
    }

    private java.lang.String d() {
        return this.d;
    }

    @Override // com.igexin.push.d.c.c, com.igexin.c.a.d.a.a
    public final void a() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
        try {
            int i = bArr[0] & 255;
            this.b = new java.lang.String(bArr, 1, i, com.igexin.push.g.s.b);
            int i2 = bArr[i + 1] & 255;
            int i3 = i + 2;
            this.c = new java.lang.String(bArr, i3, i2, com.igexin.push.g.s.b);
            int i4 = i3 + i2;
            int i5 = bArr[i4] & 255;
            int i6 = i4 + 1;
            this.d = new java.lang.String(bArr, i6, i5, com.igexin.push.g.s.b);
            int i7 = i6 + i5;
            this.e = new java.lang.String(bArr, i7 + 1, bArr[i7] & 255, com.igexin.push.g.s.b);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        byte[] bytes = this.c.getBytes();
        byte[] bytes2 = this.b.getBytes();
        byte[] bytes3 = this.d.getBytes();
        byte[] bytes4 = this.e.getBytes();
        byte[] bArr = new byte[bytes.length + bytes2.length + bytes3.length + bytes4.length + 4];
        bArr[0] = (byte) bytes.length;
        java.lang.System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        int length = bytes.length;
        int i = length + 1;
        int i2 = length + 2;
        bArr[i] = (byte) bytes2.length;
        java.lang.System.arraycopy(bytes2, 0, bArr, i2, bytes2.length);
        int length2 = i2 + bytes2.length;
        int i3 = length2 + 1;
        bArr[length2] = (byte) bytes3.length;
        java.lang.System.arraycopy(bytes3, 0, bArr, i3, bytes3.length);
        int length3 = i3 + bytes3.length;
        bArr[length3] = (byte) bytes4.length;
        java.lang.System.arraycopy(bytes4, 0, bArr, length3 + 1, bytes4.length);
        return bArr;
    }
}
