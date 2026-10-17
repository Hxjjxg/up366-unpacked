package com.igexin.c.a.b;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class b extends java.io.OutputStream {
    private java.io.OutputStream a;
    private int b;
    private int c;
    private int d;
    private int e;

    private b(java.io.OutputStream outputStream) {
        this(outputStream, 76);
    }

    public b(java.io.OutputStream outputStream, int i) {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.a = outputStream;
        this.e = i;
    }

    protected final void a() throws java.io.IOException {
        if (this.c > 0) {
            int i = this.e;
            if (i > 0 && this.d == i) {
                this.a.write("\r\n".getBytes());
                this.d = 0;
            }
            char cCharAt = com.igexin.c.a.b.g.b.charAt((this.b << 8) >>> 26);
            char cCharAt2 = com.igexin.c.a.b.g.b.charAt((this.b << 14) >>> 26);
            char cCharAt3 = this.c < 2 ? '=' : com.igexin.c.a.b.g.b.charAt((this.b << 20) >>> 26);
            char cCharAt4 = this.c >= 3 ? com.igexin.c.a.b.g.b.charAt((this.b << 26) >>> 26) : '=';
            this.a.write(cCharAt);
            this.a.write(cCharAt2);
            this.a.write(cCharAt3);
            this.a.write(cCharAt4);
            this.d += 4;
            this.c = 0;
            this.b = 0;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws java.io.IOException {
        a();
        this.a.close();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws java.io.IOException {
        int i2 = this.c;
        this.b = ((i & 255) << (16 - (i2 * 8))) | this.b;
        int i3 = i2 + 1;
        this.c = i3;
        if (i3 == 3) {
            a();
        }
    }
}
