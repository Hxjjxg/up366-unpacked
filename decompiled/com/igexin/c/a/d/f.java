package com.igexin.c.a.d;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class f extends com.igexin.c.a.d.b implements com.igexin.c.a.d.a.a, com.igexin.c.a.d.a.f {
    protected static com.igexin.c.a.d.g H;
    public int A;
    public int B;
    public int C;
    public int D;
    public java.lang.Exception E;
    public java.lang.Object F;
    public com.igexin.c.a.d.a.g G;
    protected final java.util.concurrent.locks.ReentrantLock I;
    protected final java.util.concurrent.locks.Condition J;
    protected java.lang.Thread K;
    protected volatile boolean L;
    android.os.PowerManager.WakeLock M;
    int N;
    protected com.igexin.c.a.d.a.d O;
    private byte a;
    protected volatile boolean m;
    protected volatile boolean n;
    protected volatile boolean o;
    protected volatile boolean p;
    protected volatile boolean q;
    protected volatile boolean r;
    protected volatile boolean s;
    protected volatile boolean t;
    protected volatile boolean u;
    protected volatile boolean v;
    protected volatile long w;
    volatile int x;
    public long z;

    public f(int i) {
        this(i, (byte) 0);
    }

    private f(int i, byte b) {
        this.C = i;
        this.O = null;
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        this.I = reentrantLock;
        this.J = reentrantLock.newCondition();
    }

    private int A() {
        return this.a & 15;
    }

    private boolean B() {
        byte b = this.a;
        return (b >> 4) > (b & 15);
    }

    private java.lang.Thread C() {
        return this.K;
    }

    private static void D() throws java.lang.Exception {
    }

    private void E() {
        this.n = true;
    }

    private java.lang.Object F() {
        return this.F;
    }

    private com.igexin.c.a.d.a.d G() {
        return this.O;
    }

    private void a(int i, java.util.concurrent.TimeUnit timeUnit) {
        this.v = false;
        this.E = null;
        this.w = 0L;
        byte b = this.a;
        this.a = (byte) (b + ((b & 15) < 15 ? (byte) 1 : (byte) 0));
        this.m = false;
        this.q = false;
        this.t = false;
        a(i, timeUnit);
    }

    private void a(android.os.PowerManager.WakeLock wakeLock) {
        this.M = wakeLock;
    }

    private boolean a(java.lang.Object obj) {
        if (!this.m) {
            return false;
        }
        this.q = false;
        this.n = false;
        this.m = false;
        this.F = obj;
        return true;
    }

    private void b(int i) {
        if (i != this.D) {
            this.D = i;
            H.s.b(this);
        }
    }

    private void b(long j) {
        this.z = j;
    }

    private void b(java.lang.Object obj) {
        this.F = obj;
    }

    private java.util.concurrent.locks.ReentrantLock g() {
        this.I.getClass();
        return this.I;
    }

    private android.os.PowerManager.WakeLock h() {
        return this.M;
    }

    private void i() {
        this.z = java.lang.System.currentTimeMillis();
    }

    private boolean q() {
        return this.v;
    }

    private int r() {
        this.N = a(java.util.concurrent.TimeUnit.MILLISECONDS) > 0 ? this.N | 134217728 : this.N & 1090519038;
        return this.N;
    }

    private void s() {
        this.N = (this.N + 1) & 1090519038;
    }

    private long t() {
        return this.w - java.lang.System.currentTimeMillis();
    }

    private boolean u() {
        return this.q;
    }

    private boolean v() {
        return this.u;
    }

    private boolean w() {
        return this.m;
    }

    private boolean x() {
        return this.s;
    }

    private boolean y() {
        return this.t;
    }

    private void z() {
        this.v = false;
        this.E = null;
        this.w = 0L;
        byte b = this.a;
        this.a = (byte) (b + ((b & 15) < 15 ? (byte) 1 : (byte) 0));
        this.m = false;
        this.q = false;
        this.t = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(long r7, java.util.concurrent.TimeUnit r9) {
        /*
            r6 = this;
            r0 = 0
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 <= 0) goto L26
            com.igexin.c.a.d.g r0 = com.igexin.c.a.d.f.H
            com.igexin.c.a.d.e<com.igexin.c.a.d.f> r0 = r0.s
            int r0 = r0.a(r6, r7, r9)
            r1 = -2
            if (r0 == r1) goto L27
            r1 = -1
            if (r0 == r1) goto L18
            r1 = 1
            if (r0 == r1) goto L27
            goto L26
        L18:
            long r2 = java.lang.System.currentTimeMillis()
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r4 = r0.convert(r7, r9)
            long r2 = r2 + r4
            r6.w = r2
            goto L27
        L26:
            r1 = 0
        L27:
            java.lang.Class r0 = r6.getClass()
            r0.getSimpleName()
            r6.hashCode()
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            r0.convert(r7, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.c.a.d.f.a(long, java.util.concurrent.TimeUnit):int");
    }

    public final long a(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(t(), java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    @Override // com.igexin.c.a.d.a.a
    public void a() {
        this.F = null;
        this.E = null;
        this.K = null;
    }

    public final void a(int i) {
        this.a = (byte) (((i & 15) << 4) | ((byte) (this.a & 15)));
    }

    public final void a(int i, com.igexin.c.a.d.a.g gVar) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("second must > 0");
        }
        this.B = i;
        this.G = gVar;
    }

    public final void a(com.igexin.c.a.d.a.d dVar) {
        this.O = dVar;
    }

    protected final void a(com.igexin.c.a.d.f fVar) {
        this.C = fVar.C;
        this.a = (byte) (fVar.a & 240);
        this.A = fVar.A;
        this.D = fVar.D;
        this.O = fVar.O;
        this.B = fVar.B;
        this.G = fVar.G;
    }

    public void b_() throws java.lang.Exception {
        this.K = java.lang.Thread.currentThread();
        this.q = true;
        getClass().getName();
        hashCode();
        this.K.getName();
    }

    public void d() {
        this.t = true;
    }

    @Override // com.igexin.c.a.d.a.f
    public void d_() {
        if (this.m || this.n) {
            a();
        }
    }

    public abstract void e();

    protected abstract void f();

    public final void l() {
        this.m = true;
    }

    public final boolean m() {
        return this.o;
    }

    public final boolean n() {
        return this.n;
    }

    protected final void o() {
        if (!this.p && !this.r && !this.s) {
            this.m = true;
            this.q = false;
        } else if (this.r && !this.m) {
            this.q = false;
        } else {
            if (!this.p || this.o || this.m) {
                return;
            }
            this.q = false;
        }
    }

    protected final void p() {
        if (this.O != null) {
            int i = com.igexin.c.a.d.a.d.a.a;
        }
    }
}
