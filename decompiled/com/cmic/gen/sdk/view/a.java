package com.cmic.gen.sdk.view;

/* JADX INFO: compiled from: LoginProxy.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class a {
    private static com.cmic.gen.sdk.view.a c;
    private com.cmic.gen.sdk.view.a.InterfaceC0008a a;
    public int b = 1;

    /* JADX INFO: renamed from: com.cmic.gen.sdk.view.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LoginProxy.java */
    public interface InterfaceC0008a {
        void a();
    }

    public static com.cmic.gen.sdk.view.a a() {
        if (c == null) {
            synchronized (com.cmic.gen.sdk.view.a.class) {
                if (c == null) {
                    c = new com.cmic.gen.sdk.view.a();
                }
            }
        }
        return c;
    }

    public com.cmic.gen.sdk.view.a.InterfaceC0008a b() {
        return this.a;
    }

    public void c() {
        if (this.a == null || this.b == 1) {
            return;
        }
        this.a = null;
        com.cmic.gen.sdk.h0.a("LoginProxy", "mLoginAuthProxy == null");
    }

    public void a(com.cmic.gen.sdk.view.a.InterfaceC0008a interfaceC0008a) {
        this.b = 1;
        this.a = interfaceC0008a;
    }
}
