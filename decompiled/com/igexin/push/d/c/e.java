package com.igexin.push.d.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class e {
    public static final int a = 1944742139;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public byte h;
    public byte i;
    public byte j;
    public byte k;
    public byte l;
    public byte m;
    public byte n;
    public byte[] o;
    public int p;
    public int q;
    public int r;

    private int a() {
        int i = this.e | this.h | this.i | this.j;
        this.e = i;
        return i;
    }

    private int b() {
        int i = this.g | this.k | this.l | this.m | this.n;
        this.g = i;
        return i;
    }

    private void b(byte b) {
        this.g = b & 255;
        this.k = (byte) (b & 3);
        this.l = (byte) (b & 4);
        this.m = (byte) (b & 8);
        this.n = (byte) (b & 16);
    }

    public final void a(byte b) {
        this.e = b & 255;
        this.h = (byte) (b & 192);
        this.i = (byte) (b & 48);
        this.j = (byte) (b & 15);
    }
}
