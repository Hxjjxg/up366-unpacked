package com.igexin.push.core.a.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class f extends com.igexin.push.core.a.a {
    private static final java.lang.String b = "RegisterResult";

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(java.lang.Object obj) {
        if (obj instanceof com.igexin.push.d.c.p) {
            com.igexin.push.d.c.p pVar = (com.igexin.push.d.c.p) obj;
            com.igexin.c.a.c.a.a("register resp |" + pVar.b + "|" + com.igexin.push.core.e.z, new java.lang.Object[0]);
            com.igexin.c.a.c.a.a("register resp cid = " + pVar.d + " device id = " + pVar.e, new java.lang.Object[0]);
            if (pVar.b != com.igexin.push.core.e.z) {
                com.igexin.push.core.e.v = false;
                com.igexin.c.a.c.a.a(b, "change session : from [" + com.igexin.push.core.e.z + "] to [" + pVar.b + "]");
                com.igexin.c.a.c.a.a("RegisterResult change session : from [" + com.igexin.push.core.e.z + "] to [" + pVar.b + "]", new java.lang.Object[0]);
                com.igexin.c.a.c.a.a(b, "change cid : from [" + com.igexin.push.core.e.A + "] to [" + pVar.d + "]");
                com.igexin.c.a.c.a.a("RegisterResult change cid : from [" + com.igexin.push.core.e.A + "] to [" + pVar.d + "]", new java.lang.Object[0]);
                if (android.text.TextUtils.isEmpty(pVar.d) || android.text.TextUtils.isEmpty(pVar.e)) {
                    com.igexin.push.core.e.f.a().a(pVar.b);
                } else {
                    com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
                    java.lang.String str = pVar.d;
                    java.lang.String str2 = pVar.e;
                    com.igexin.push.core.e.z = pVar.b;
                    if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.H)) {
                        com.igexin.push.core.e.H = str2;
                    }
                    com.igexin.push.core.e.A = str;
                    fVarA.c();
                }
                com.igexin.push.core.e.Q = 0L;
            }
            long j = com.igexin.push.core.e.z;
            java.lang.String str3 = com.igexin.push.core.e.A;
            java.lang.String str4 = com.igexin.push.core.e.H;
            com.igexin.c.a.c.a.a("loginReqAfterRegister|new session:" + com.igexin.push.core.e.z + ", cid :" + com.igexin.push.core.e.A + ", devId :" + com.igexin.push.core.e.H, new java.lang.Object[0]);
            com.igexin.push.core.k.a();
            com.igexin.push.d.c.i iVarD = com.igexin.push.core.k.d();
            com.igexin.push.e.a aVar = com.igexin.push.core.d.a.a.h;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("S-");
            sb.append(iVarD.b);
            aVar.a(sb.toString(), iVarD, true);
        }
        return true;
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean c() {
        return false;
    }
}
