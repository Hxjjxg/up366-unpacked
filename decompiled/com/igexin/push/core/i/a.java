package com.igexin.push.core.i;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class a {
    protected java.lang.Long a = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
    protected android.app.Activity b;
    protected java.lang.String c;

    private void a(java.lang.Long l) {
        this.a = l;
    }

    private void a(java.lang.String str) {
        this.c = str;
    }

    private android.app.Activity n() {
        return this.b;
    }

    public final java.lang.Long a() {
        return this.a;
    }

    public final void a(android.app.Activity activity) {
        this.b = activity;
    }

    public final java.lang.String b() {
        return this.c;
    }

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract boolean j();

    public abstract void k();

    public abstract boolean l();

    public abstract void m();
}
