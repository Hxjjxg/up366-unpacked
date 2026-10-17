package com.igexin.push.f;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class b {
    private static final java.lang.String c = "ExtensionTask";
    protected long a = 0;
    protected long b = 0;

    private void a(long j) {
        this.a = j;
    }

    private boolean b() {
        getClass().getName();
        java.lang.System.currentTimeMillis();
        return java.lang.System.currentTimeMillis() - this.a > this.b;
    }

    public abstract void a();
}
