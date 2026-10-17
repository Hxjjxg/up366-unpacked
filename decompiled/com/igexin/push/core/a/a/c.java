package com.igexin.push.core.a.a;

import com.igexin.push.core.e.f.AnonymousClass24;
import com.igexin.push.core.e.f.AnonymousClass38;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class c extends com.igexin.push.core.a.a {
    private static final java.lang.String b = "LoginResult";

    /* JADX INFO: renamed from: com.igexin.push.core.a.a.c$1, reason: invalid class name */
    final class AnonymousClass1 extends com.igexin.push.f.d {
        AnonymousClass1() {
        }

        @Override // com.igexin.push.f.d
        public final void b() {
            try {
                com.igexin.push.core.e.d dVarA = com.igexin.push.core.e.d.a(com.igexin.push.core.e.l);
                org.json.JSONObject jSONObjectA = dVarA.a();
                if (jSONObjectA == null) {
                    return;
                }
                java.util.Iterator<java.lang.String> itKeys = jSONObjectA.keys();
                while (itKeys.hasNext()) {
                    java.lang.String next = itKeys.next();
                    org.json.JSONObject jSONObject = jSONObjectA.getJSONObject(next);
                    com.igexin.c.a.c.a.a("LoginResult|send unFeedback taskid = ".concat(java.lang.String.valueOf(next)), new java.lang.Object[0]);
                    jSONObject.put("appid", com.igexin.push.core.e.a);
                    com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMultiBrandMessageAction(jSONObject, jSONObject.getString("multaid"));
                    itKeys.remove();
                }
                dVarA.b();
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.b(com.igexin.push.core.a.a.c.b, "feedbackMultiBrandPushMessage exception :" + th.toString());
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private void d() {
        com.igexin.c.a.c.a.d.a().a("[LoginResult] Login successed with cid = " + com.igexin.push.core.e.A);
        com.igexin.push.d.c cVar = com.igexin.push.d.c.b.a;
        cVar.c = java.lang.System.currentTimeMillis();
        if (cVar.b) {
            com.igexin.c.a.c.a.a(com.igexin.push.d.c.a, "loginRsp| enter polling");
            cVar.e = new com.igexin.push.d.e();
            com.igexin.push.f.b.d.a.a.g();
            cVar.d = 0;
        } else {
            cVar.b();
        }
        java.lang.String str = com.igexin.push.core.e.A;
        boolean z = com.igexin.push.core.e.v;
        com.igexin.c.a.c.a.a("loginRsp|" + com.igexin.push.core.e.A + "|success", new java.lang.Object[0]);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("isCidBroadcasted|");
        sb.append(com.igexin.push.core.e.v);
        com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
        if (!com.igexin.push.core.e.v) {
            com.igexin.push.core.l.a().c();
            com.igexin.push.core.e.v = true;
        }
        com.igexin.push.core.e.u = true;
        com.igexin.push.g.k.g();
        com.igexin.push.core.l.a().b();
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.g();
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.H)) {
            com.igexin.c.a.c.a.a("LoginResult device id is empty, get device id from server +++++", new java.lang.Object[0]);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.h();
        }
        com.igexin.push.core.c.a.a().a(true);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - com.igexin.push.core.e.Q;
        long j = com.igexin.push.core.e.Q;
        com.igexin.c.a.c.a.a("LoginResult|lastAddphoneinfoTime: " + com.igexin.push.core.e.Q, new java.lang.Object[0]);
        boolean z2 = jCurrentTimeMillis - 86400000 > 0;
        boolean z3 = !com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I);
        boolean z4 = !com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B);
        boolean zB = com.igexin.push.g.c.b(com.igexin.push.core.e.l);
        boolean z5 = com.igexin.push.core.e.J != zB;
        if (z5) {
            com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
            if (com.igexin.push.core.e.J != zB) {
                com.igexin.push.core.e.J = zB ? 1 : 0;
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass24(), false, true);
            }
        }
        boolean z6 = com.igexin.push.core.e.aM;
        com.igexin.c.a.c.a.a("LoginResult|PHONE_INFO_DATA_CHANGE= " + com.igexin.push.core.e.aM + ", isOverOneDay = " + z2 + ", isDeviceTokenDiff = " + z3 + ", isCidDiff = " + z4 + ", isNotificationEnableDiff= " + z5, new java.lang.Object[0]);
        if (com.igexin.push.core.e.aM || z2 || z3 || z4 || z5) {
            com.igexin.push.core.a.b.d().i();
        }
        com.igexin.push.core.c.a.a();
        com.igexin.push.core.c.a.b();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass38(), false, true);
        if (!com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B)) {
            com.igexin.push.core.e.B = com.igexin.push.core.e.A;
        }
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = com.igexin.push.core.b.V;
        messageObtain.obj = new java.lang.Object();
        com.igexin.push.core.d.a.a.a(messageObtain);
        com.igexin.sdk.router.GTBoater.getInstance().initialize();
        if (com.igexin.assist.sdk.a.a().c()) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.a.a.c.AnonymousClass1(), false, true);
        }
        com.igexin.push.g.i.a(com.igexin.push.core.e.l, com.igexin.push.core.e.g, com.igexin.push.core.e.aO);
    }

    private static void e() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - com.igexin.push.core.e.Q;
        long j = com.igexin.push.core.e.Q;
        com.igexin.c.a.c.a.a("LoginResult|lastAddphoneinfoTime: " + com.igexin.push.core.e.Q, new java.lang.Object[0]);
        boolean z = jCurrentTimeMillis - 86400000 > 0;
        boolean z2 = !com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I);
        boolean z3 = !com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B);
        boolean zB = com.igexin.push.g.c.b(com.igexin.push.core.e.l);
        boolean z4 = com.igexin.push.core.e.J != zB;
        if (z4) {
            com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
            if (com.igexin.push.core.e.J != zB) {
                com.igexin.push.core.e.J = zB ? 1 : 0;
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass24(), false, true);
            }
        }
        boolean z5 = com.igexin.push.core.e.aM;
        com.igexin.c.a.c.a.a("LoginResult|PHONE_INFO_DATA_CHANGE= " + com.igexin.push.core.e.aM + ", isOverOneDay = " + z + ", isDeviceTokenDiff = " + z2 + ", isCidDiff = " + z3 + ", isNotificationEnableDiff= " + z4, new java.lang.Object[0]);
        if (com.igexin.push.core.e.aM || z || z2 || z3 || z4) {
            com.igexin.push.core.a.b.d().i();
        }
    }

    private static void f() {
        com.igexin.c.a.c.a.d.a().a("[LoginResult] Login " + com.igexin.push.core.e.A + " failed");
        com.igexin.c.a.c.a.a(b, "login failed, clear session or cid");
        com.igexin.c.a.c.a.a("LoginResult login failed, clear session or cid", new java.lang.Object[0]);
        com.igexin.push.core.e.f.a().b();
        com.igexin.push.core.k.a();
        com.igexin.push.core.k.c();
    }

    private static void g() {
        if (com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B)) {
            return;
        }
        com.igexin.push.core.e.B = com.igexin.push.core.e.A;
    }

    private void h() {
        if (com.igexin.assist.sdk.a.a().c()) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.a.a.c.AnonymousClass1(), false, true);
        }
    }

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(java.lang.Object obj) {
        if ((obj instanceof com.igexin.push.d.c.k) && !com.igexin.push.core.e.u) {
            com.igexin.push.c.c.a().d().e();
            if (((com.igexin.push.d.c.k) obj).b) {
                com.igexin.c.a.c.a.d.a().a("[LoginResult] Login successed with cid = " + com.igexin.push.core.e.A);
                com.igexin.push.d.c cVar = com.igexin.push.d.c.b.a;
                cVar.c = java.lang.System.currentTimeMillis();
                if (cVar.b) {
                    com.igexin.c.a.c.a.a(com.igexin.push.d.c.a, "loginRsp| enter polling");
                    cVar.e = new com.igexin.push.d.e();
                    com.igexin.push.f.b.d.a.a.g();
                    cVar.d = 0;
                } else {
                    cVar.b();
                }
                java.lang.String str = com.igexin.push.core.e.A;
                boolean z = com.igexin.push.core.e.v;
                com.igexin.c.a.c.a.a("loginRsp|" + com.igexin.push.core.e.A + "|success", new java.lang.Object[0]);
                java.lang.StringBuilder sb = new java.lang.StringBuilder("isCidBroadcasted|");
                sb.append(com.igexin.push.core.e.v);
                com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
                if (!com.igexin.push.core.e.v) {
                    com.igexin.push.core.l.a().c();
                    com.igexin.push.core.e.v = true;
                }
                com.igexin.push.core.e.u = true;
                com.igexin.push.g.k.g();
                com.igexin.push.core.l.a().b();
                com.igexin.push.core.a.b.d();
                com.igexin.push.core.a.b.g();
                if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.H)) {
                    com.igexin.c.a.c.a.a("LoginResult device id is empty, get device id from server +++++", new java.lang.Object[0]);
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.h();
                }
                com.igexin.push.core.c.a.a().a(true);
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - com.igexin.push.core.e.Q;
                long j = com.igexin.push.core.e.Q;
                com.igexin.c.a.c.a.a("LoginResult|lastAddphoneinfoTime: " + com.igexin.push.core.e.Q, new java.lang.Object[0]);
                boolean z2 = jCurrentTimeMillis - 86400000 > 0;
                boolean z3 = !com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I);
                boolean z4 = !com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B);
                boolean zB = com.igexin.push.g.c.b(com.igexin.push.core.e.l);
                boolean z5 = com.igexin.push.core.e.J != zB;
                if (z5) {
                    com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
                    if (com.igexin.push.core.e.J != zB) {
                        com.igexin.push.core.e.J = zB ? 1 : 0;
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass24(), false, true);
                    }
                }
                boolean z6 = com.igexin.push.core.e.aM;
                com.igexin.c.a.c.a.a("LoginResult|PHONE_INFO_DATA_CHANGE= " + com.igexin.push.core.e.aM + ", isOverOneDay = " + z2 + ", isDeviceTokenDiff = " + z3 + ", isCidDiff = " + z4 + ", isNotificationEnableDiff= " + z5, new java.lang.Object[0]);
                if (com.igexin.push.core.e.aM || z2 || z3 || z4 || z5) {
                    com.igexin.push.core.a.b.d().i();
                }
                com.igexin.push.core.c.a.a();
                com.igexin.push.core.c.a.b();
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass38(), false, true);
                if (!com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B)) {
                    com.igexin.push.core.e.B = com.igexin.push.core.e.A;
                }
                android.os.Message messageObtain = android.os.Message.obtain();
                messageObtain.what = com.igexin.push.core.b.V;
                messageObtain.obj = new java.lang.Object();
                com.igexin.push.core.d.a.a.a(messageObtain);
                com.igexin.sdk.router.GTBoater.getInstance().initialize();
                if (com.igexin.assist.sdk.a.a().c()) {
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.a.a.c.AnonymousClass1(), false, true);
                }
                com.igexin.push.g.i.a(com.igexin.push.core.e.l, com.igexin.push.core.e.g, com.igexin.push.core.e.aO);
            } else {
                com.igexin.c.a.c.a.d.a().a("[LoginResult] Login " + com.igexin.push.core.e.A + " failed");
                com.igexin.c.a.c.a.a(b, "login failed, clear session or cid");
                com.igexin.c.a.c.a.a("LoginResult login failed, clear session or cid", new java.lang.Object[0]);
                com.igexin.push.core.e.f.a().b();
                com.igexin.push.core.k.a();
                com.igexin.push.core.k.c();
            }
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
