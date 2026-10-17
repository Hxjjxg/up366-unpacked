package com.igexin.push.e;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class a {
    public static java.lang.String a = "com.igexin.push.e.a";
    public boolean b;

    private int a(java.lang.String str, com.igexin.push.d.c.c cVar) {
        return a(str, cVar, false);
    }

    public static void a(int i) {
        if (i == com.igexin.c.a.b.a.a.j.a) {
            com.igexin.c.a.b.e.a().a(new com.igexin.push.d.b.b());
            com.igexin.c.a.b.e.a().b();
        } else if (i == com.igexin.c.a.b.a.a.j.b) {
            com.igexin.c.a.b.e.a().a(new com.igexin.push.d.b.a());
            com.igexin.c.a.b.e.a().b();
        }
    }

    public static void a(com.igexin.push.d.c.c cVar) {
        if (cVar == null) {
            return;
        }
        com.igexin.push.core.a.b.d().a(cVar);
    }

    public static void a(java.lang.String str) {
        com.igexin.push.f.b.e.g().a(str, com.igexin.push.d.c.b.a.e.a());
    }

    public static void a(boolean z) {
        com.igexin.c.a.c.a.a(a + "|call -> disconnect, reset delay = " + z, new java.lang.Object[0]);
        if (z) {
            com.igexin.push.core.e.a("disconnect", 0L);
        }
        com.igexin.c.a.b.a.a.d.a().d();
    }

    private void b(boolean z) {
        com.igexin.c.a.c.a.a(a, "call setActive, param active = " + z + "; this.active = " + this.b + "; reConnectDelayTime=" + com.igexin.push.core.e.O);
        com.igexin.c.a.c.a.a(a + "|call setActive, param active = " + z + "; this.active = " + this.b + "; reConnectDelayTime=" + com.igexin.push.core.e.O, new java.lang.Object[0]);
        boolean z2 = this.b;
        if (z2 != z) {
            this.b = z;
            if (z) {
                com.igexin.c.a.c.a.a(a + "|active = true, start connect~~~~", new java.lang.Object[0]);
                f();
                return;
            }
            com.igexin.c.a.c.a.a(a + "|active = false, disconnect...", new java.lang.Object[0]);
            a(true);
            return;
        }
        if (z2) {
            if (com.igexin.push.core.e.u) {
                com.igexin.push.core.a.b.d();
                com.igexin.push.core.a.b.f();
                return;
            }
            if (com.igexin.push.core.e.O <= 1500) {
                com.igexin.c.a.c.a.a(a + "|online  false , already reconnect ", new java.lang.Object[0]);
                return;
            }
            com.igexin.c.a.c.a.a(a + "|start active again, online = false, reset delay", new java.lang.Object[0]);
            com.igexin.push.core.e.a("Active", 0L);
            a("Active");
        }
    }

    public static void c() {
        com.igexin.push.core.j.a().a(com.igexin.push.core.j.a.d);
        boolean zE = com.igexin.push.g.c.e();
        com.igexin.c.a.c.a.a(a, "network changed, available = " + zE + ", last = " + com.igexin.push.core.e.n);
        com.igexin.c.a.c.a.a(a + "|network changed, available = " + zE + ", last = " + com.igexin.push.core.e.n, new java.lang.Object[0]);
        com.igexin.push.d.c.b.a.a();
        if (!zE) {
            com.igexin.c.a.c.a.a(a + "|network changed, available = false, do nothing", new java.lang.Object[0]);
            a(false);
        } else if (!com.igexin.push.core.e.n) {
            com.igexin.c.a.c.a.a(a + "|network changed, try connect reset delay", new java.lang.Object[0]);
            f();
        }
        if (zE) {
            com.igexin.push.c.c.a().c();
        }
        com.igexin.push.core.e.n = zE;
    }

    public static boolean d() {
        return (com.igexin.push.core.e.p && com.igexin.push.core.e.s) ? false : true;
    }

    private boolean e() {
        return this.b;
    }

    private static void f() {
        com.igexin.c.a.c.a.a(a + "|call -> tryConnect and reset delay = 0", new java.lang.Object[0]);
        a(true);
    }

    private static void g() {
        com.igexin.push.d.a.c.b = -1;
        if (com.igexin.push.core.e.q) {
            com.igexin.c.a.c.a.a(a, "isAppidWrong = true");
            com.igexin.c.a.c.a.a(a + "|isAppidWrong = true", new java.lang.Object[0]);
            com.igexin.c.a.c.a.d.a().a("isAppidWrong = true");
            return;
        }
        if (!com.igexin.push.g.g.a()) {
            com.igexin.c.a.c.a.a(a, "so error ++++++++");
            com.igexin.c.a.c.a.a(a + "|so error ++++++++", new java.lang.Object[0]);
            return;
        }
        if (com.igexin.push.core.e.az) {
            a("disconnect success");
            return;
        }
        com.igexin.c.a.c.a.a(a, "initSuccess = false");
        com.igexin.c.a.c.a.a(a + "|initSuccess = false", new java.lang.Object[0]);
    }

    private static void h() {
        com.igexin.push.c.c.a().d().c();
        com.igexin.push.c.a aVarD = com.igexin.push.c.c.a().d();
        com.igexin.push.core.j.a().a(com.igexin.push.core.j.a.c);
        aVarD.f();
        if (d()) {
            com.igexin.c.a.c.a.a(a, "sdkOn = false or pushOn = false, disconnect|user");
            com.igexin.c.a.c.a.a(a + "|sdkOn = false or pushOn = false, disconnect|user", new java.lang.Object[0]);
        } else {
            com.igexin.c.a.c.a.a(a + "|disconnect by network", new java.lang.Object[0]);
        }
        com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = com.igexin.c.a.b.e.a().s;
        if (eVar != null) {
            eVar.a(com.igexin.c.a.b.a.a.f.class);
        }
        a(false);
    }

    public final int a(java.lang.String str, com.igexin.push.d.c.c cVar, boolean z) {
        if (str == null || cVar == null) {
            return -1;
        }
        if (!com.igexin.push.core.e.u && !(cVar instanceof com.igexin.push.d.c.g) && !(cVar instanceof com.igexin.push.d.c.i) && !(cVar instanceof com.igexin.push.d.c.d)) {
            com.igexin.c.a.c.a.a("networkLayer|sendData|not online|" + cVar.getClass().getName(), new java.lang.Object[0]);
            return -3;
        }
        if (this.b) {
            if (z) {
                if (com.igexin.c.a.b.e.a().a(com.igexin.push.config.SDKUrlConfig.getConnectAddress(), com.igexin.push.core.d.a.a.g, cVar, com.igexin.push.config.d.f > 0 ? com.igexin.push.config.d.f : 10, new com.igexin.push.d.f()) == null) {
                    return -2;
                }
            } else if (com.igexin.c.a.b.e.a().a(com.igexin.push.config.SDKUrlConfig.getConnectAddress(), com.igexin.push.core.d.a.a.g, cVar) == null) {
                return -2;
            }
        }
        return 0;
    }

    public final void a() {
        boolean z = com.igexin.push.core.e.p;
        boolean z2 = com.igexin.push.core.e.s;
        boolean zA = com.igexin.push.g.c.a();
        if (z && z2 && zA) {
            b(true);
        }
    }

    public final void b() {
        b(false);
        if (com.igexin.push.core.e.u) {
            com.igexin.push.core.e.u = false;
            com.igexin.push.core.l.a().b();
        }
        com.igexin.c.a.c.a.a(a + "|stop by user", new java.lang.Object[0]);
        com.igexin.push.c.c.a().d().f();
    }
}
