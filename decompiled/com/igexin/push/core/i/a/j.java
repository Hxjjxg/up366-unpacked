package com.igexin.push.core.i.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class j {
    static final int a = 2;
    static final int b = 10;
    private static final java.lang.String e = "GifHeaderParser";
    private static final int f = 255;
    private static final int g = 44;
    private static final int h = 33;
    private static final int i = 59;
    private static final int j = 249;
    private static final int k = 255;
    private static final int l = 254;
    private static final int m = 1;
    private static final int n = 28;
    private static final int o = 2;
    private static final int p = 1;
    private static final int q = 128;
    private static final int r = 64;
    private static final int s = 7;
    private static final int t = 128;
    private static final int u = 7;
    private static final int v = 256;
    java.nio.ByteBuffer c;
    com.igexin.push.core.i.a.i d;
    private final byte[] w = new byte[256];
    private int x = 0;

    private com.igexin.push.core.i.a.j a(byte[] bArr) {
        if (bArr != null) {
            a(java.nio.ByteBuffer.wrap(bArr));
        } else {
            this.c = null;
            this.d.d = 2;
        }
        return this;
    }

    private void a(int i2) {
        boolean z = false;
        while (!z && !p() && this.d.e <= i2) {
            int iN = n();
            if (iN == 33) {
                int iN2 = n();
                if (iN2 != 1) {
                    if (iN2 == j) {
                        this.d.f = new com.igexin.push.core.i.a.g();
                        f();
                    } else if (iN2 != l && iN2 == 255) {
                        m();
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (int i3 = 0; i3 < 11; i3++) {
                            sb.append((char) this.w[i3]);
                        }
                        if (sb.toString().equals("NETSCAPE2.0")) {
                            h();
                        }
                    }
                }
                l();
            } else if (iN == 44) {
                if (this.d.f == null) {
                    this.d.f = new com.igexin.push.core.i.a.g();
                }
                g();
            } else if (iN != 59) {
                this.d.d = 1;
            } else {
                z = true;
            }
        }
    }

    private int[] b(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.c.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = bArr[i4] & 255;
                int i6 = i4 + 2;
                int i7 = bArr[i4 + 1] & 255;
                i4 += 3;
                int i8 = i3 + 1;
                iArr[i3] = (i7 << 8) | (i5 << 16) | com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR | (bArr[i6] & 255);
                i3 = i8;
            }
        } catch (java.nio.BufferUnderflowException e2) {
            com.igexin.c.a.c.a.b(e, "Format Error Reading Color Table " + e2.getMessage());
            this.d.d = 1;
        }
        return iArr;
    }

    private void c() {
        this.c = null;
        java.util.Arrays.fill(this.w, (byte) 0);
        this.d = new com.igexin.push.core.i.a.i();
        this.x = 0;
    }

    private boolean d() {
        i();
        if (!p()) {
            a(2);
        }
        return this.d.e > 1;
    }

    private void e() {
        a(Integer.MAX_VALUE);
    }

    private void f() {
        n();
        int iN = n();
        this.d.f.k = (iN & 28) >> 2;
        if (this.d.f.k == 0) {
            this.d.f.k = 1;
        }
        this.d.f.j = (iN & 1) != 0;
        short s2 = this.c.getShort();
        if (s2 < 2) {
            s2 = 10;
        }
        this.d.f.m = s2 * 10;
        this.d.f.l = n();
        n();
    }

    private void g() {
        this.d.f.e = this.c.getShort();
        this.d.f.f = this.c.getShort();
        this.d.f.g = this.c.getShort();
        this.d.f.h = this.c.getShort();
        int iN = n();
        boolean z = (iN & 128) != 0;
        int iPow = (int) java.lang.Math.pow(2.0d, (iN & 7) + 1);
        this.d.f.i = (iN & 64) != 0;
        com.igexin.push.core.i.a.g gVar = this.d.f;
        if (z) {
            gVar.o = b(iPow);
        } else {
            gVar.o = null;
        }
        this.d.f.n = this.c.position();
        k();
        if (p()) {
            return;
        }
        this.d.e++;
        this.d.g.add(this.d.f);
    }

    private void h() {
        do {
            m();
            byte[] bArr = this.w;
            if (bArr[0] == 1) {
                this.d.o = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.x <= 0) {
                return;
            }
        } while (!p());
    }

    private void i() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) n());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.d.d = 1;
            return;
        }
        j();
        if (!this.d.j || p()) {
            return;
        }
        com.igexin.push.core.i.a.i iVar = this.d;
        iVar.c = b(iVar.k);
        com.igexin.push.core.i.a.i iVar2 = this.d;
        iVar2.n = iVar2.c[this.d.l];
    }

    private void j() {
        this.d.h = this.c.getShort();
        this.d.i = this.c.getShort();
        this.d.j = (n() & 128) != 0;
        this.d.k = (int) java.lang.Math.pow(2.0d, (r0 & 7) + 1);
        this.d.l = n();
        this.d.m = n();
    }

    private void k() {
        n();
        l();
    }

    private void l() {
        int iN;
        do {
            iN = n();
            this.c.position(java.lang.Math.min(this.c.position() + iN, this.c.limit()));
        } while (iN > 0);
    }

    private void m() {
        int iN = n();
        this.x = iN;
        if (iN <= 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                i3 = this.x;
                if (i2 >= i3) {
                    return;
                }
                i3 -= i2;
                this.c.get(this.w, i2, i3);
                i2 += i3;
            } catch (java.lang.Exception e2) {
                com.igexin.c.a.c.a.b(e, "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.x + e2.getMessage());
                this.d.d = 1;
                return;
            }
        }
    }

    private int n() {
        try {
            return this.c.get() & 255;
        } catch (java.lang.Exception unused) {
            this.d.d = 1;
            return 0;
        }
    }

    private int o() {
        return this.c.getShort();
    }

    private boolean p() {
        return this.d.d != 0;
    }

    public final com.igexin.push.core.i.a.j a(java.nio.ByteBuffer byteBuffer) {
        c();
        java.nio.ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.c = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.c.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public final void a() {
        this.c = null;
        this.d = null;
    }

    public final com.igexin.push.core.i.a.i b() {
        if (this.c == null) {
            throw new java.lang.IllegalStateException("You must call setData() before parseHeader()");
        }
        if (p()) {
            return this.d;
        }
        i();
        if (!p()) {
            e();
            if (this.d.e < 0) {
                this.d.d = 1;
            }
        }
        return this.d;
    }
}
