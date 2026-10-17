package com.igexin.c.a.b;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class a extends java.io.InputStream {
    private java.io.InputStream a;
    private int[] b;
    private int c = 0;
    private boolean d = false;

    public a(java.io.InputStream inputStream) {
        this.a = inputStream;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0076 A[PHI: r3
  0x0076: PHI (r3v7 int) = (r3v6 int), (r3v13 int) binds: [B:35:0x005e, B:39:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a() throws java.io.IOException {
        /*
            r11 = this;
            r0 = 4
            char[] r1 = new char[r0]
            r2 = 0
            r3 = r2
        L5:
            java.io.InputStream r4 = r11.a
            int r4 = r4.read()
            r5 = -1
            java.lang.String r6 = "Bad base64 stream"
            r7 = 1
            if (r4 != r5) goto L20
            if (r3 != 0) goto L1a
            int[] r0 = new int[r2]
            r11.b = r0
            r11.d = r7
            return
        L1a:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r6)
            throw r0
        L20:
            char r4 = (char) r4
            java.lang.String r8 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
            int r9 = r8.indexOf(r4)
            r10 = 61
            if (r9 != r5) goto L3d
            if (r4 != r10) goto L2e
            goto L3d
        L2e:
            r9 = 13
            if (r4 == r9) goto L42
            r9 = 10
            if (r4 != r9) goto L37
            goto L42
        L37:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r6)
            throw r0
        L3d:
            int r9 = r3 + 1
            r1[r3] = r4
            r3 = r9
        L42:
            if (r3 < r0) goto L5
            r3 = r2
            r4 = r3
        L46:
            if (r3 >= r0) goto L5b
            char r9 = r1[r3]
            if (r9 == r10) goto L55
            if (r4 != 0) goto L4f
            goto L58
        L4f:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r6)
            throw r0
        L55:
            if (r4 != 0) goto L58
            r4 = r7
        L58:
            int r3 = r3 + 1
            goto L46
        L5b:
            r3 = 3
            char r4 = r1[r3]
            if (r4 != r10) goto L76
            java.io.InputStream r3 = r11.a
            int r3 = r3.read()
            if (r3 != r5) goto L70
            r11.d = r7
            r3 = 2
            char r4 = r1[r3]
            if (r4 != r10) goto L76
            goto L77
        L70:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r6)
            throw r0
        L76:
            r7 = r3
        L77:
            r3 = r2
            r4 = r3
        L79:
            if (r3 >= r0) goto L8c
            char r5 = r1[r3]
            if (r5 == r10) goto L89
            int r5 = r8.indexOf(r5)
            int r6 = 3 - r3
            int r6 = r6 * 6
            int r5 = r5 << r6
            r4 = r4 | r5
        L89:
            int r3 = r3 + 1
            goto L79
        L8c:
            int[] r0 = new int[r7]
            r11.b = r0
        L90:
            if (r2 >= r7) goto La1
            int[] r0 = r11.b
            int r1 = 2 - r2
            int r1 = r1 * 8
            int r1 = r4 >>> r1
            r1 = r1 & 255(0xff, float:3.57E-43)
            r0[r2] = r1
            int r2 = r2 + 1
            goto L90
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.c.a.b.a.a():void");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws java.io.IOException {
        this.a.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0085 A[PHI: r4
  0x0085: PHI (r4v7 int) = (r4v6 int), (r4v17 int) binds: [B:41:0x006d, B:45:0x007c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2 A[LOOP:3: B:57:0x00a0->B:58:0x00a2, LOOP_END] */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int read() throws java.io.IOException {
        /*
            r11 = this;
            int[] r0 = r11.b
            if (r0 == 0) goto L9
            int r1 = r11.c
            int r0 = r0.length
            if (r1 != r0) goto Lbc
        L9:
            boolean r0 = r11.d
            r1 = -1
            if (r0 == 0) goto Lf
            return r1
        Lf:
            r0 = 4
            char[] r2 = new char[r0]
            r3 = 0
            r4 = r3
        L14:
            java.io.InputStream r5 = r11.a
            int r5 = r5.read()
            java.lang.String r6 = "Bad base64 stream"
            r7 = 1
            if (r5 != r1) goto L2f
            if (r4 != 0) goto L29
            int[] r0 = new int[r3]
            r11.b = r0
            r11.d = r7
            goto Lb1
        L29:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r6)
            throw r0
        L2f:
            char r5 = (char) r5
            java.lang.String r8 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
            int r9 = r8.indexOf(r5)
            r10 = 61
            if (r9 != r1) goto L4c
            if (r5 != r10) goto L3d
            goto L4c
        L3d:
            r9 = 13
            if (r5 == r9) goto L51
            r9 = 10
            if (r5 != r9) goto L46
            goto L51
        L46:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r6)
            throw r0
        L4c:
            int r9 = r4 + 1
            r2[r4] = r5
            r4 = r9
        L51:
            if (r4 < r0) goto L14
            r4 = r3
            r5 = r4
        L55:
            if (r4 >= r0) goto L6a
            char r9 = r2[r4]
            if (r9 == r10) goto L64
            if (r5 != 0) goto L5e
            goto L67
        L5e:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r6)
            throw r0
        L64:
            if (r5 != 0) goto L67
            r5 = r7
        L67:
            int r4 = r4 + 1
            goto L55
        L6a:
            r4 = 3
            char r5 = r2[r4]
            if (r5 != r10) goto L85
            java.io.InputStream r4 = r11.a
            int r4 = r4.read()
            if (r4 != r1) goto L7f
            r11.d = r7
            r4 = 2
            char r5 = r2[r4]
            if (r5 != r10) goto L85
            goto L86
        L7f:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r6)
            throw r0
        L85:
            r7 = r4
        L86:
            r4 = r3
            r5 = r4
        L88:
            if (r4 >= r0) goto L9b
            char r6 = r2[r4]
            if (r6 == r10) goto L98
            int r6 = r8.indexOf(r6)
            int r9 = 3 - r4
            int r9 = r9 * 6
            int r6 = r6 << r9
            r5 = r5 | r6
        L98:
            int r4 = r4 + 1
            goto L88
        L9b:
            int[] r0 = new int[r7]
            r11.b = r0
            r0 = r3
        La0:
            if (r0 >= r7) goto Lb1
            int[] r2 = r11.b
            int r4 = 2 - r0
            int r4 = r4 * 8
            int r4 = r5 >>> r4
            r4 = r4 & 255(0xff, float:3.57E-43)
            r2[r0] = r4
            int r0 = r0 + 1
            goto La0
        Lb1:
            int[] r0 = r11.b
            int r0 = r0.length
            if (r0 != 0) goto Lba
            r0 = 0
            r11.b = r0
            return r1
        Lba:
            r11.c = r3
        Lbc:
            int[] r0 = r11.b
            int r1 = r11.c
            int r2 = r1 + 1
            r11.c = r2
            r0 = r0[r1]
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.c.a.b.a.read():int");
    }
}
