package com.igexin.c.a.b.a.a;

import com.igexin.c.a.b.a.a.d.AnonymousClass1;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class c extends android.os.Handler {

    /* JADX INFO: renamed from: com.igexin.c.a.b.a.a.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.igexin.c.a.b.a.a.j.a().length];
            a = iArr;
            try {
                iArr[com.igexin.c.a.b.a.a.j.d - 1] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.igexin.c.a.b.a.a.j.e - 1] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.igexin.c.a.b.a.a.j.c - 1] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.igexin.c.a.b.a.a.j.f - 1] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.igexin.c.a.b.a.a.j.g - 1] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.igexin.c.a.b.a.a.j.a - 1] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[com.igexin.c.a.b.a.a.j.h - 1] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    public c(android.os.Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        try {
            int i = com.igexin.c.a.b.a.a.c.AnonymousClass1.a[com.igexin.c.a.b.a.a.j.a()[message.what] - 1];
            if (i == 1) {
                com.igexin.c.a.b.a.a.d dVarA = com.igexin.c.a.b.a.a.d.a();
                boolean z = (dVarA.a == null || dVarA.a.isClosed()) ? false : true;
                if (!z && dVarA.d == null) {
                    com.igexin.c.a.c.a.a("GS-M|disconnect = true, reconnect", new java.lang.Object[0]);
                    dVarA.d = new com.igexin.c.a.b.a.a.b(dVarA.new AnonymousClass1());
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) dVarA.d, true);
                    return;
                }
                com.igexin.c.a.c.a.a("GS-Mstart connect, isConnected = " + z + ", ctask = " + dVarA.d, new java.lang.Object[0]);
                return;
            }
            if (i == 3) {
                com.igexin.c.a.b.a.a.d.a().a((java.net.Socket) message.obj);
                return;
            }
            if (i == 4) {
                com.igexin.c.a.b.a.a.d dVarA2 = com.igexin.c.a.b.a.a.d.a();
                if (!dVarA2.i() || dVarA2.f) {
                    return;
                }
                dVarA2.b();
                dVarA2.f = true;
                return;
            }
            if (i == 5) {
                com.igexin.c.a.b.a.a.d dVarA3 = com.igexin.c.a.b.a.a.d.a();
                dVarA3.j();
                if ((dVarA3.d == null && dVarA3.c == null && dVarA3.b == null) || dVarA3.i()) {
                    dVarA3.b();
                    return;
                } else {
                    dVarA3.h();
                    return;
                }
            }
            if (i == 6) {
                com.igexin.c.a.b.a.a.d.a();
                com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
                com.igexin.push.e.a.a(com.igexin.c.a.b.a.a.j.a);
            } else {
                if (i != 7) {
                    return;
                }
                com.igexin.c.a.b.a.a.d dVarA4 = com.igexin.c.a.b.a.a.d.a();
                com.igexin.c.a.c.a.b("GS-M", ((java.lang.String) message.obj) + " write task response timeout");
                dVarA4.c();
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
