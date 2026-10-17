package com.igexin.push.core.i.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class n implements com.igexin.push.core.i.a.d {
    private static final java.lang.String f = "n";
    private static final int g = 4096;
    private static final int h = -1;
    private static final int i = -1;
    private static final int j = 4;
    private static final int k = 255;
    private static final int l = 0;
    private boolean A;
    private int B;
    private int C;
    private int D;
    private int E;
    private java.lang.Boolean F;
    private android.graphics.Bitmap.Config G;
    private int[] m;
    private final int[] n;
    private final com.igexin.push.core.i.a.d.a o;
    private java.nio.ByteBuffer p;
    private byte[] q;
    private com.igexin.push.core.i.a.j r;
    private short[] s;
    private byte[] t;
    private byte[] u;
    private byte[] v;
    private int[] w;
    private int x;
    private com.igexin.push.core.i.a.i y;
    private android.graphics.Bitmap z;

    private n(com.igexin.push.core.i.a.d.a aVar) {
        this.n = new int[256];
        this.G = android.graphics.Bitmap.Config.ARGB_8888;
        this.o = aVar;
        this.y = new com.igexin.push.core.i.a.i();
    }

    private n(com.igexin.push.core.i.a.d.a aVar, com.igexin.push.core.i.a.i iVar, java.nio.ByteBuffer byteBuffer) {
        this(aVar, iVar, byteBuffer, 1);
    }

    public n(com.igexin.push.core.i.a.d.a aVar, com.igexin.push.core.i.a.i iVar, java.nio.ByteBuffer byteBuffer, int i2) {
        this(aVar);
        a(iVar, byteBuffer, i2);
    }

    private int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.C + i2; i10++) {
            byte[] bArr = this.v;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.m[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & k;
                i6 += (i11 >> 16) & k;
                i7 += (i11 >> 8) & k;
                i8 += i11 & k;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.C + i12; i13++) {
            byte[] bArr2 = this.v;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.m[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & k;
                i6 += (i14 >> 16) & k;
                i7 += (i14 >> 8) & k;
                i8 += i14 & k;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047  */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v35, types: [short] */
    /* JADX WARN: Type inference failed for: r5v37 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap a(com.igexin.push.core.i.a.g r34, com.igexin.push.core.i.a.g r35) {
        /*
            Method dump skipped, instruction units count: 1086
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.i.a.n.a(com.igexin.push.core.i.a.g, com.igexin.push.core.i.a.g):android.graphics.Bitmap");
    }

    private void a(com.igexin.push.core.i.a.g gVar) {
        com.igexin.push.core.i.a.g gVar2 = gVar;
        int[] iArr = this.w;
        int i2 = gVar2.h;
        int i3 = gVar2.f;
        int i4 = gVar2.g;
        int i5 = gVar2.e;
        boolean z = this.x == 0;
        int i6 = this.E;
        byte[] bArr = this.v;
        int[] iArr2 = this.m;
        int i7 = 0;
        byte b = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = gVar2.g * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b2 = bArr[i12];
                int i14 = i2;
                int i15 = b2 & 255;
                if (i15 != b) {
                    int i16 = iArr2[i15];
                    if (i16 != 0) {
                        iArr[i13] = i16;
                    } else {
                        b = b2;
                    }
                }
                i12++;
                i13++;
                i2 = i14;
            }
            i7++;
            gVar2 = gVar;
        }
        java.lang.Boolean bool = this.F;
        this.F = java.lang.Boolean.valueOf((bool != null && bool.booleanValue()) || (this.F == null && z && b != -1));
    }

    private void b(com.igexin.push.core.i.a.g gVar) {
        java.lang.Boolean bool;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        com.igexin.push.core.i.a.g gVar2 = gVar;
        int[] iArr = this.w;
        int i8 = gVar2.h / this.C;
        int i9 = gVar2.f / this.C;
        int i10 = gVar2.g / this.C;
        int i11 = gVar2.e;
        int i12 = this.C;
        int i13 = i11 / i12;
        boolean z = this.x == 0;
        int i14 = this.E;
        int i15 = this.D;
        byte[] bArr = this.v;
        int[] iArr2 = this.m;
        java.lang.Boolean bool2 = this.F;
        int i16 = 8;
        int i17 = 0;
        int i18 = 0;
        int i19 = 1;
        while (true) {
            bool = bool2;
            if (i18 >= i8) {
                break;
            }
            if (gVar2.i) {
                if (i17 >= i8) {
                    int i20 = i19 + 1;
                    i2 = i8;
                    if (i20 == 2) {
                        i17 = 4;
                        i19 = i20;
                    } else if (i20 != 3) {
                        i19 = i20;
                        if (i20 == 4) {
                            i17 = 1;
                            i16 = 2;
                        }
                    } else {
                        i16 = 4;
                        i19 = i20;
                        i17 = 2;
                    }
                } else {
                    i2 = i8;
                }
                i3 = i17 + i16;
            } else {
                i2 = i8;
                i3 = i17;
                i17 = i18;
            }
            int i21 = i17 + i9;
            boolean z2 = i12 == 1;
            if (i21 < i15) {
                int i22 = i21 * i14;
                int i23 = i22 + i13;
                int i24 = i23 + i10;
                int i25 = i22 + i14;
                if (i25 < i24) {
                    i24 = i25;
                }
                i4 = i3;
                int i26 = i18 * i12 * gVar2.g;
                if (z2) {
                    int i27 = i23;
                    while (true) {
                        i5 = i9;
                        if (i27 >= i24) {
                            break;
                        }
                        int i28 = iArr2[bArr[i26] & 255];
                        if (i28 != 0) {
                            iArr[i27] = i28;
                        } else if (z && bool == null) {
                            bool = java.lang.Boolean.TRUE;
                        }
                        i26 += i12;
                        i27++;
                        i9 = i5;
                    }
                } else {
                    i5 = i9;
                    int i29 = ((i24 - i23) * i12) + i26;
                    int i30 = i23;
                    while (true) {
                        i6 = i10;
                        if (i30 < i24) {
                            int i31 = gVar2.g;
                            int i32 = i13;
                            int i33 = i26;
                            int i34 = 0;
                            int i35 = 0;
                            int i36 = 0;
                            int i37 = 0;
                            int i38 = 0;
                            while (true) {
                                if (i33 >= this.C + i26) {
                                    i7 = i14;
                                    break;
                                }
                                byte[] bArr2 = this.v;
                                i7 = i14;
                                if (i33 >= bArr2.length || i33 >= i29) {
                                    break;
                                }
                                int i39 = this.m[bArr2[i33] & 255];
                                if (i39 != 0) {
                                    i34 += (i39 >> 24) & k;
                                    i35 += (i39 >> 16) & k;
                                    i36 += (i39 >> 8) & k;
                                    i37 += i39 & k;
                                    i38++;
                                }
                                i33++;
                                i14 = i7;
                            }
                            int i40 = i31 + i26;
                            for (int i41 = i40; i41 < this.C + i40; i41++) {
                                byte[] bArr3 = this.v;
                                if (i41 >= bArr3.length || i41 >= i29) {
                                    break;
                                }
                                int i42 = this.m[bArr3[i41] & 255];
                                if (i42 != 0) {
                                    i34 += (i42 >> 24) & k;
                                    i35 += (i42 >> 16) & k;
                                    i36 += (i42 >> 8) & k;
                                    i37 += i42 & k;
                                    i38++;
                                }
                            }
                            int i43 = i38 == 0 ? 0 : ((i34 / i38) << 24) | ((i35 / i38) << 16) | ((i36 / i38) << 8) | (i37 / i38);
                            if (i43 != 0) {
                                iArr[i30] = i43;
                            } else if (z && bool == null) {
                                bool = java.lang.Boolean.TRUE;
                            }
                            i26 += i12;
                            i30++;
                            gVar2 = gVar;
                            i10 = i6;
                            i13 = i32;
                            i14 = i7;
                        }
                    }
                    bool2 = bool;
                    i18++;
                    gVar2 = gVar;
                    i9 = i5;
                    i8 = i2;
                    i10 = i6;
                    i17 = i4;
                    i13 = i13;
                    i14 = i14;
                }
            } else {
                i4 = i3;
                i5 = i9;
            }
            i6 = i10;
            bool2 = bool;
            i18++;
            gVar2 = gVar;
            i9 = i5;
            i8 = i2;
            i10 = i6;
            i17 = i4;
            i13 = i13;
            i14 = i14;
        }
        if (this.F == null) {
            this.F = java.lang.Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [short] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    private void c(com.igexin.push.core.i.a.g gVar) {
        byte b;
        int i2;
        int i3;
        int i4;
        short s;
        com.igexin.push.core.i.a.n nVar = this;
        if (gVar != null) {
            nVar.p.position(gVar.n);
        }
        int i5 = gVar == null ? nVar.y.h * nVar.y.i : gVar.h * gVar.g;
        byte[] bArr = nVar.v;
        if (bArr == null || bArr.length < i5) {
            nVar.v = nVar.o.a(i5);
        }
        byte[] bArr2 = nVar.v;
        if (nVar.s == null) {
            nVar.s = new short[4096];
        }
        short[] sArr = nVar.s;
        if (nVar.t == null) {
            nVar.t = new byte[4096];
        }
        byte[] bArr3 = nVar.t;
        if (nVar.u == null) {
            nVar.u = new byte[4097];
        }
        byte[] bArr4 = nVar.u;
        int iQ = q();
        int i6 = 1 << iQ;
        int i7 = i6 + 1;
        int i8 = i6 + 2;
        int i9 = iQ + 1;
        int i10 = (1 << i9) - 1;
        byte b2 = 0;
        for (int i11 = 0; i11 < i6; i11++) {
            sArr[i11] = 0;
            bArr3[i11] = (byte) i11;
        }
        byte[] bArr5 = nVar.q;
        int i12 = i9;
        int i13 = i8;
        int i14 = i10;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = -1;
        while (true) {
            if (i15 >= i5) {
                b = b2;
                i2 = i20;
                break;
            }
            if (i16 == 0) {
                int iQ2 = q();
                if (iQ2 <= 0) {
                    i3 = i15;
                    i4 = i9;
                } else {
                    java.nio.ByteBuffer byteBuffer = nVar.p;
                    i3 = i15;
                    i4 = i9;
                    byteBuffer.get(nVar.q, 0, java.lang.Math.min(iQ2, byteBuffer.remaining()));
                }
                if (iQ2 <= 0) {
                    nVar.B = 3;
                    i2 = i20;
                    b = 0;
                    break;
                }
                i16 = iQ2;
                i17 = 0;
            } else {
                i3 = i15;
                i4 = i9;
            }
            i19 += (bArr5[i17] & 255) << i18;
            i17++;
            i16--;
            int i24 = i18 + 8;
            int i25 = i13;
            int i26 = i12;
            int i27 = i23;
            int i28 = i21;
            while (i24 >= i26) {
                int i29 = i19 & i14;
                i19 >>= i26;
                i24 -= i26;
                if (i29 == i6) {
                    i25 = i8;
                    i14 = i10;
                    i26 = i4;
                    i27 = -1;
                } else if (i29 != i7) {
                    if (i27 == -1) {
                        bArr2[i20] = bArr3[i29];
                        i20++;
                        i3++;
                        i27 = i29;
                        i28 = i27;
                    } else {
                        if (i29 >= i25) {
                            bArr4[i22] = (byte) i28;
                            i22++;
                            s = i27;
                        } else {
                            s = i29;
                        }
                        while (s >= i6) {
                            bArr4[i22] = bArr3[s];
                            i22++;
                            s = sArr[s];
                        }
                        int i30 = bArr3[s] & 255;
                        byte b3 = (byte) i30;
                        bArr2[i20] = b3;
                        while (true) {
                            i20++;
                            i3++;
                            if (i22 <= 0) {
                                break;
                            }
                            i22--;
                            bArr2[i20] = bArr4[i22];
                        }
                        if (i25 < 4096) {
                            sArr[i25] = (short) i27;
                            bArr3[i25] = b3;
                            i25++;
                            if ((i25 & i14) == 0 && i25 < 4096) {
                                i26++;
                                i14 += i25;
                            }
                        }
                        i27 = i29;
                        i28 = i30;
                    }
                }
            }
            nVar = this;
            i23 = i27;
            i18 = i24;
            i13 = i25;
            i12 = i26;
            i15 = i3;
            i9 = i4;
            i21 = i28;
            b2 = 0;
        }
        java.util.Arrays.fill(bArr2, i2, i5, b);
    }

    private com.igexin.push.core.i.a.j p() {
        if (this.r == null) {
            this.r = new com.igexin.push.core.i.a.j();
        }
        return this.r;
    }

    private int q() {
        return this.p.get() & 255;
    }

    private int r() {
        int iQ = q();
        if (iQ <= 0) {
            return iQ;
        }
        java.nio.ByteBuffer byteBuffer = this.p;
        byteBuffer.get(this.q, 0, java.lang.Math.min(iQ, byteBuffer.remaining()));
        return iQ;
    }

    private android.graphics.Bitmap s() {
        java.lang.Boolean bool = this.F;
        android.graphics.Bitmap bitmapA = this.o.a(this.E, this.D, (bool == null || bool.booleanValue()) ? android.graphics.Bitmap.Config.ARGB_8888 : this.G, this.x);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int a() {
        return this.y.h;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int a(int i2) {
        if (i2 < 0 || i2 >= this.y.e) {
            return -1;
        }
        return this.y.g.get(i2).m;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int a(java.io.InputStream inputStream, int i2) {
        if (inputStream != null) {
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i3 = inputStream.read(bArr, 0, 16384);
                    if (i3 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i3);
                }
                byteArrayOutputStream.flush();
                a(byteArrayOutputStream.toByteArray());
            } catch (java.io.IOException e) {
                android.util.Log.w(f, "Error reading data from stream", e);
            }
        } else {
            this.B = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException e2) {
                android.util.Log.w(f, "Error closing stream", e2);
            }
        }
        return this.B;
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized int a(byte[] bArr) {
        if (this.r == null) {
            this.r = new com.igexin.push.core.i.a.j();
        }
        com.igexin.push.core.i.a.j jVar = this.r;
        if (bArr != null) {
            jVar.a(java.nio.ByteBuffer.wrap(bArr));
        } else {
            jVar.c = null;
            jVar.d.d = 2;
        }
        com.igexin.push.core.i.a.i iVarB = jVar.b();
        this.y = iVarB;
        if (bArr != null) {
            a(iVarB, bArr);
        }
        return this.B;
    }

    @Override // com.igexin.push.core.i.a.d
    public final void a(android.graphics.Bitmap.Config config) {
        if (config == android.graphics.Bitmap.Config.ARGB_8888 || config == android.graphics.Bitmap.Config.RGB_565) {
            this.G = config;
            return;
        }
        throw new java.lang.IllegalArgumentException("Unsupported format: " + config + ", must be one of " + android.graphics.Bitmap.Config.ARGB_8888 + " or " + android.graphics.Bitmap.Config.RGB_565);
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized void a(com.igexin.push.core.i.a.i iVar, java.nio.ByteBuffer byteBuffer) {
        a(iVar, byteBuffer, 1);
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized void a(com.igexin.push.core.i.a.i iVar, java.nio.ByteBuffer byteBuffer, int i2) {
        if (i2 <= 0) {
            throw new java.lang.IllegalArgumentException("Sample size must be >=0, not: ".concat(java.lang.String.valueOf(i2)));
        }
        int iHighestOneBit = java.lang.Integer.highestOneBit(i2);
        this.B = 0;
        this.y = iVar;
        this.x = -1;
        java.nio.ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.p = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.p.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        this.A = false;
        java.util.Iterator<com.igexin.push.core.i.a.g> it = iVar.g.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().k == 3) {
                this.A = true;
                break;
            }
        }
        this.C = iHighestOneBit;
        this.E = iVar.h / iHighestOneBit;
        this.D = iVar.i / iHighestOneBit;
        this.v = this.o.a(iVar.h * iVar.i);
        this.w = this.o.b(this.E * this.D);
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized void a(com.igexin.push.core.i.a.i iVar, byte[] bArr) {
        a(iVar, java.nio.ByteBuffer.wrap(bArr));
    }

    @Override // com.igexin.push.core.i.a.d
    public final int b() {
        return this.y.i;
    }

    @Override // com.igexin.push.core.i.a.d
    public final java.nio.ByteBuffer c() {
        return this.p;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int d() {
        return this.B;
    }

    @Override // com.igexin.push.core.i.a.d
    public final void e() {
        this.x = (this.x + 1) % this.y.e;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int f() {
        int i2;
        if (this.y.e <= 0 || (i2 = this.x) < 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= this.y.e) {
            return -1;
        }
        return this.y.g.get(i2).m;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int g() {
        return this.y.e;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int h() {
        return this.x;
    }

    @Override // com.igexin.push.core.i.a.d
    public final void i() {
        this.x = -1;
    }

    @Override // com.igexin.push.core.i.a.d
    @java.lang.Deprecated
    public final int j() {
        if (this.y.o == -1) {
            return 1;
        }
        return this.y.o;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int k() {
        return this.y.o;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int l() {
        if (this.y.o == -1) {
            return 1;
        }
        if (this.y.o == 0) {
            return 0;
        }
        return this.y.o + 1;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int m() {
        return this.p.limit() + this.v.length + (this.w.length * 4);
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized android.graphics.Bitmap n() {
        if (this.y.e <= 0 || this.x < 0) {
            com.igexin.c.a.c.a.b(f, "Unable to decode frame, frameCount=" + this.y.e + ", framePointer=" + this.x);
            this.B = 1;
        }
        int i2 = this.B;
        if (i2 != 1 && i2 != 2) {
            this.B = 0;
            if (this.q == null) {
                this.q = this.o.a(k);
            }
            com.igexin.push.core.i.a.g gVar = this.y.g.get(this.x);
            int i3 = this.x - 1;
            com.igexin.push.core.i.a.g gVar2 = i3 >= 0 ? this.y.g.get(i3) : null;
            int[] iArr = gVar.o != null ? gVar.o : this.y.c;
            this.m = iArr;
            if (iArr == null) {
                com.igexin.c.a.c.a.b(f, "No valid color table found for frame #" + this.x);
                this.B = 1;
                return null;
            }
            if (gVar.j) {
                int[] iArr2 = this.m;
                java.lang.System.arraycopy(iArr2, 0, this.n, 0, iArr2.length);
                int[] iArr3 = this.n;
                this.m = iArr3;
                iArr3[gVar.l] = 0;
                if (gVar.k == 2 && this.x == 0) {
                    this.F = java.lang.Boolean.TRUE;
                }
            }
            return a(gVar, gVar2);
        }
        com.igexin.c.a.c.a.b(f, "Unable to decode frame, status=" + this.B);
        return null;
    }

    @Override // com.igexin.push.core.i.a.d
    public final void o() {
        this.y = null;
        android.graphics.Bitmap bitmap = this.z;
        if (bitmap != null) {
            this.o.a(bitmap);
        }
        this.z = null;
        this.p = null;
        this.F = null;
        this.o.a();
    }
}
