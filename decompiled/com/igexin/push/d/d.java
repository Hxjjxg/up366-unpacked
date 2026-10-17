package com.igexin.push.d;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class d implements com.igexin.push.d.b {
    public static final java.lang.String a = "NormalModel";

    @Override // com.igexin.push.d.b
    public final long a() {
        long j;
        long j2;
        long j3;
        boolean zA = com.igexin.push.g.c.a();
        com.igexin.push.core.e.n = com.igexin.push.g.c.e();
        boolean z = com.igexin.push.core.e.p;
        boolean z2 = com.igexin.push.core.e.s;
        boolean z3 = com.igexin.push.core.e.n;
        com.igexin.c.a.c.a.a("NormalModel|isSdkOn = " + com.igexin.push.core.e.p + " isPushOn = " + com.igexin.push.core.e.s + " isBlockEndTime = " + zA + " isNetworkAvailable = " + com.igexin.push.core.e.n, new java.lang.Object[0]);
        if (!com.igexin.push.core.e.n || !com.igexin.push.core.e.p || !com.igexin.push.core.e.s || !zA) {
            com.igexin.c.a.c.a.a(a, "reconnect stop, interval= 3min ++++++");
            com.igexin.c.a.c.a.a("NormalModel|reconnect stop, interval= 3min ++++", new java.lang.Object[0]);
            return com.igexin.push.config.c.g;
        }
        if (com.igexin.push.core.e.O <= 0) {
            j3 = 1;
        } else {
            if (com.igexin.push.core.e.O <= 300) {
                j = com.igexin.push.core.e.O;
                j2 = 150;
            } else if (com.igexin.push.core.e.O <= com.igexin.push.config.c.i) {
                j = com.igexin.push.core.e.O;
                j2 = 500;
            } else if (com.igexin.push.core.e.O <= 30000) {
                j = com.igexin.push.core.e.O;
                j2 = 1500;
            } else {
                j = com.igexin.push.core.e.O;
                j2 = com.igexin.push.config.c.l;
            }
            j3 = j + j2;
        }
        com.igexin.push.core.e.O = j3;
        if (com.igexin.push.core.e.O > com.igexin.push.config.c.g) {
            com.igexin.push.core.e.O = com.igexin.push.config.c.g;
        }
        long j4 = com.igexin.push.core.e.O;
        com.igexin.c.a.c.a.a("NormalModel|after add auto reconnect delay time = ".concat(java.lang.String.valueOf(j4)), new java.lang.Object[0]);
        return j4;
    }
}
