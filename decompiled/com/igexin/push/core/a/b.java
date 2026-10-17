package com.igexin.push.core.a;

import com.igexin.push.core.e.e.AnonymousClass3;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class b extends com.igexin.push.core.a.a implements com.igexin.push.e.b {
    private static final java.lang.String b = "CoreAction";
    private static android.util.SparseArray<com.igexin.push.core.a.a> c;
    private static volatile com.igexin.push.core.a.b d;

    private b() {
        android.util.SparseArray<com.igexin.push.core.a.a> sparseArray = new android.util.SparseArray<>();
        c = sparseArray;
        sparseArray.put(0, new com.igexin.push.core.a.a.a());
        c.put(5, new com.igexin.push.core.a.a.c());
        c.put(37, new com.igexin.push.core.a.a.d());
        c.put(9, new com.igexin.push.core.a.a.f());
        c.put(20, new com.igexin.push.core.a.a.e());
        c.put(26, new com.igexin.push.core.a.b.d());
        c.put(97, new com.igexin.push.core.a.a.b());
    }

    public static java.lang.Class a(android.content.Context context) {
        return com.igexin.push.core.ServiceManager.getInstance().b(context);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        return str + ":" + str2;
    }

    public static void a(android.content.Intent intent) {
        com.igexin.c.a.c.a.a("CoreAction|onServiceInitialize ##", new java.lang.Object[0]);
        if (intent == null) {
            return;
        }
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
        com.igexin.push.core.d.a(false);
        com.igexin.push.core.e.N = intent.hasExtra("op_app") ? intent.getStringExtra("op_app") : "";
        com.igexin.push.core.e.v = false;
        if (com.igexin.push.core.e.u) {
            com.igexin.push.core.l.a().c();
            com.igexin.push.core.e.v = true;
        }
        if (!com.igexin.push.g.q.a(com.igexin.push.core.e.l) || com.igexin.push.g.k.d == null) {
            return;
        }
        com.igexin.push.core.ServiceManager.getInstance();
        java.lang.String strE = com.igexin.push.core.ServiceManager.e(com.igexin.push.core.e.l);
        if (!com.igexin.push.core.b.ao.equals(strE)) {
            byte[] bArrB = com.igexin.c.b.a.b(strE.getBytes());
            if (bArrB == null || !com.igexin.push.g.k.k()) {
                return;
            }
            com.igexin.push.g.k.a(bArrB, com.igexin.push.g.k.d);
            return;
        }
        if (com.igexin.push.g.k.k() && new java.io.File(com.igexin.push.g.k.d).delete()) {
            java.lang.String str = com.igexin.push.g.k.d;
            com.igexin.c.a.c.a.a("del " + com.igexin.push.g.k.d + " success ~~~", new java.lang.Object[0]);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.os.Bundle r23) {
        /*
            Method dump skipped, instruction units count: 2380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.b.a(android.os.Bundle):void");
    }

    public static void a(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("action", com.igexin.push.core.b.F);
            jSONObject.put(com.igexin.push.core.b.C, str);
        } catch (org.json.JSONException e) {
            com.igexin.c.a.c.a.a(e);
        }
        java.lang.String string = jSONObject.toString();
        com.igexin.push.d.c.o oVar = new com.igexin.push.d.c.o();
        oVar.c = 128;
        ((com.igexin.push.d.c.b) oVar).b = (int) java.lang.System.currentTimeMillis();
        oVar.e = com.igexin.push.core.b.O;
        oVar.f = string;
        oVar.h = com.igexin.push.core.e.A;
        com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar, false);
    }

    private static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.igexin.push.core.l.a().a(str, str2, str3, str4);
    }

    public static boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return com.igexin.push.core.n.a().a(str, str2, str3);
    }

    private static boolean a(org.json.JSONObject jSONObject, com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
        return com.igexin.push.core.n.a().a(jSONObject, pushTaskBean);
    }

    public static void b(android.content.Intent intent) {
        if (intent == null || !intent.hasExtra("isSlave")) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("isSlave", false);
        com.igexin.c.a.c.a.a("CoreAction|onServiceInitializeForSlave isSlave =".concat(java.lang.String.valueOf(booleanExtra)), new java.lang.Object[0]);
        if (booleanExtra) {
            com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
            com.igexin.push.core.d.a(true);
            com.igexin.push.core.e.N = intent.hasExtra("op_app") ? intent.getStringExtra("op_app") : "";
            if (com.igexin.push.core.e.u) {
                com.igexin.push.core.l.a().c();
            }
        }
    }

    public static void b(java.lang.String str) {
        com.igexin.c.a.c.a.a("CoreAction|resetDelayTime from = ".concat(java.lang.String.valueOf(str)), new java.lang.Object[0]);
        if (com.igexin.push.core.e.u) {
            com.igexin.c.a.c.a.a("CoreAction|online ,sendHeartbeat ", new java.lang.Object[0]);
            d();
            f();
            return;
        }
        if (com.igexin.push.core.e.O <= 1500 && com.igexin.push.core.e.O != 0) {
            long j = com.igexin.push.core.e.O;
            com.igexin.c.a.c.a.a("CoreAction|already reconnect  " + com.igexin.push.core.e.O, new java.lang.Object[0]);
            return;
        }
        int iRandom = (int) ((java.lang.Math.random() * 100.0d) + 1000.0d);
        long j2 = com.igexin.push.core.e.O;
        com.igexin.c.a.c.a.a("CoreAction|reConnectDelayTime = " + com.igexin.push.core.e.O + ", reset = " + iRandom, new java.lang.Object[0]);
        com.igexin.push.f.b.e.g().a(str, (long) iRandom);
    }

    private static void c(android.content.Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        try {
            java.lang.String action = intent.getAction();
            if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
                e();
                return;
            }
            if (com.igexin.push.core.b.L.equals(action)) {
                com.igexin.push.core.n.a().a(intent);
                return;
            }
            if (com.igexin.push.core.b.N.equals(action)) {
                if (com.igexin.push.config.d.c != 0) {
                    com.igexin.push.f.f.a().c();
                }
            } else if (!"android.intent.action.SCREEN_ON".equals(action)) {
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    com.igexin.push.core.e.y = 0;
                }
            } else {
                com.igexin.push.core.e.y = 1;
                com.igexin.push.f.a.a().a(true);
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    b("screen on");
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static com.igexin.push.core.a.b d() {
        if (d == null) {
            synchronized (com.igexin.push.core.a.b.class) {
                if (d == null) {
                    d = new com.igexin.push.core.a.b();
                }
            }
        }
        return d;
    }

    public static void e() {
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
        com.igexin.push.e.a.c();
        com.igexin.c.a.c.a.a("CoreAction|network changed check condition status", new java.lang.Object[0]);
        com.igexin.push.f.a.a().a(true);
    }

    public static int f() {
        com.igexin.c.a.c.a.a("CoreAction|send heart beat data ........", new java.lang.Object[0]);
        return com.igexin.push.core.d.a.a.h.a("H-" + com.igexin.push.core.e.A, new com.igexin.push.d.c.f(), true);
    }

    public static void g() {
        try {
            for (com.igexin.push.core.b.n nVar : com.igexin.push.core.e.e.a().a) {
                if (nVar.e >= com.igexin.push.config.d.N - 1) {
                    com.igexin.c.a.c.a.a("CoreAction|data.getSendTimes=" + nVar.e + " id=" + nVar.a, new java.lang.Object[0]);
                } else if (nVar.d + 20000 <= java.lang.System.currentTimeMillis()) {
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    org.json.JSONObject jSONObject = new org.json.JSONObject(nVar.b);
                    com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                    bVar.c = 128;
                    bVar.b = (int) jCurrentTimeMillis;
                    bVar.e = com.igexin.push.core.b.O;
                    if (jSONObject.has("extraData")) {
                        bVar.g = android.util.Base64.decode(jSONObject.optString("extraData").getBytes(), 0);
                        jSONObject.remove("extraData");
                    }
                    bVar.f = nVar.b;
                    bVar.h = com.igexin.push.core.e.A;
                    com.igexin.c.a.c.a.a("freshral|" + nVar.b, new java.lang.Object[0]);
                    com.igexin.push.core.e.e eVarA = com.igexin.push.core.e.e.a();
                    long j = nVar.a;
                    long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
                    com.igexin.push.core.b.n nVarA = eVarA.a(j);
                    if (nVarA != null) {
                        nVarA.d = jCurrentTimeMillis2;
                        nVarA.e++;
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) eVarA.new AnonymousClass3(com.igexin.push.core.e.e.a(nVarA), j), true, true);
                    }
                    com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static void h() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("action", "request_deviceid");
            jSONObject.put(com.igexin.push.core.b.C, java.lang.String.valueOf(jCurrentTimeMillis));
        } catch (org.json.JSONException e) {
            com.igexin.c.a.c.a.a(e);
        }
        java.lang.String string = jSONObject.toString();
        com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
        bVar.c = 128;
        bVar.b = (int) jCurrentTimeMillis;
        bVar.e = com.igexin.push.core.b.O;
        bVar.f = string;
        bVar.h = com.igexin.push.core.e.A;
        com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
        com.igexin.c.a.c.a.a("CoreAction|deviceidReq", new java.lang.Object[0]);
    }

    public static void j() {
        if (!com.igexin.push.core.e.W || com.igexin.push.core.e.X >= java.lang.System.currentTimeMillis()) {
            return;
        }
        com.igexin.push.core.e.f.a().a(false);
    }

    public static void k() {
        if (!com.igexin.push.core.e.ae) {
            com.igexin.push.core.e.ae = com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.f.b.b.g(), false, true);
        }
        if (!com.igexin.push.core.e.af) {
            com.igexin.push.core.e.af = com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.f.b.e.g(), true, true);
        }
        if (com.igexin.push.core.e.ag) {
            return;
        }
        com.igexin.push.core.d.a.a.b();
    }

    private static boolean l() {
        return false;
    }

    private static void m() {
        com.igexin.push.g.c.d();
    }

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.e.b
    public final boolean a(com.igexin.push.d.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        com.igexin.push.core.a.a aVar = c.get(cVar.m);
        cVar.getClass().getName();
        com.igexin.c.a.c.a.a("CoreAction|receive : " + cVar.getClass().getName() + " resp ~~~~", new java.lang.Object[0]);
        if ((cVar instanceof com.igexin.push.d.c.h) || (cVar instanceof com.igexin.push.d.c.k) || (cVar instanceof com.igexin.push.d.c.m) || (cVar instanceof com.igexin.push.d.c.p) || (cVar instanceof com.igexin.push.d.c.f) || (cVar instanceof com.igexin.push.d.c.q)) {
            com.igexin.c.a.b.a.a.d.a().a(cVar.getClass().getName());
        }
        if ((cVar instanceof com.igexin.push.d.c.k) || (cVar instanceof com.igexin.push.d.c.m) || (cVar instanceof com.igexin.push.d.c.p)) {
            com.igexin.push.core.e.a("action: " + cVar.m, 0L);
            com.igexin.push.c.c.a().d().b();
        }
        if (aVar != null) {
            aVar.a(cVar);
        }
        com.igexin.push.f.b.b.g().i();
        return true;
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(java.lang.Object obj) {
        com.igexin.push.e.a aVar = com.igexin.push.core.d.a.a.h;
        if ((obj instanceof com.igexin.push.d.c.c) && aVar != null) {
            com.igexin.push.e.a.a((com.igexin.push.d.c.c) obj);
        } else if (obj instanceof com.igexin.push.d.b.b) {
            com.igexin.c.a.c.a.a("CoreAction|TcpExceptionNotify###", new java.lang.Object[0]);
            com.igexin.push.c.c.a().d().c();
            com.igexin.push.c.a aVarD = com.igexin.push.c.c.a().d();
            com.igexin.push.core.j.a().a(com.igexin.push.core.j.a.c);
            aVarD.f();
            if (com.igexin.push.e.a.d()) {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a, "sdkOn = false or pushOn = false, disconnect|user");
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a + "|sdkOn = false or pushOn = false, disconnect|user", new java.lang.Object[0]);
            } else {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a + "|disconnect by network", new java.lang.Object[0]);
            }
            com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = com.igexin.c.a.b.e.a().s;
            if (eVar != null) {
                eVar.a(com.igexin.c.a.b.a.a.f.class);
            }
            com.igexin.push.e.a.a(false);
        } else if (obj instanceof com.igexin.push.d.b.a) {
            com.igexin.c.a.c.a.a("CoreAction|TcpDisconnectSuccessNotify ###", new java.lang.Object[0]);
            if (com.igexin.push.core.e.u) {
                com.igexin.push.core.e.u = false;
                com.igexin.c.a.c.a.a("CoreAction|broadcast online state = offline", new java.lang.Object[0]);
                com.igexin.push.core.l.a().b();
            }
            com.igexin.push.d.a.c.b = -1;
            if (com.igexin.push.core.e.q) {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a, "isAppidWrong = true");
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a + "|isAppidWrong = true", new java.lang.Object[0]);
                com.igexin.c.a.c.a.d.a().a("isAppidWrong = true");
            } else if (!com.igexin.push.g.g.a()) {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a, "so error ++++++++");
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a + "|so error ++++++++", new java.lang.Object[0]);
            } else if (com.igexin.push.core.e.az) {
                com.igexin.push.e.a.a("disconnect success");
            } else {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a, "initSuccess = false");
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a + "|initSuccess = false", new java.lang.Object[0]);
            }
        }
        return false;
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    public final void i() {
        try {
            if ((java.lang.System.currentTimeMillis() - com.igexin.push.core.e.Q) - 86400000 > 0) {
                com.igexin.push.core.e.f.a().b(0);
                com.igexin.push.core.e.f.a().c(java.lang.System.currentTimeMillis());
            }
            com.igexin.c.a.c.a.b(b, "sendAddphoneinfo.deviceToken" + com.igexin.push.core.e.I);
            if (com.igexin.push.core.e.aA <= 7) {
                com.igexin.push.core.e.f.a().b(com.igexin.push.core.e.aA + 1);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.d() { // from class: com.igexin.push.core.a.b.1
                    @Override // com.igexin.push.f.d
                    public final void b() {
                        com.igexin.push.g.o.m();
                        try {
                            com.igexin.push.core.b.a aVar = new com.igexin.push.core.b.a();
                            long j = aVar.n;
                            org.json.JSONObject jSONObject = new org.json.JSONObject();
                            jSONObject.put("model", aVar.a == null ? "" : aVar.a);
                            jSONObject.put("sim", aVar.b == null ? "" : aVar.b);
                            jSONObject.put("imei", aVar.c == null ? "" : aVar.c);
                            jSONObject.put("mac", aVar.d == null ? "" : com.igexin.push.g.o.c());
                            jSONObject.put("version", aVar.e == null ? "" : aVar.e);
                            jSONObject.put("channelid", aVar.f == null ? "" : aVar.f);
                            jSONObject.put("type", "ANDROID");
                            jSONObject.put("app", aVar.k == null ? "" : aVar.k);
                            java.lang.StringBuilder sb = new java.lang.StringBuilder("ANDROID-");
                            sb.append(aVar.g == null ? "" : aVar.g);
                            jSONObject.put("deviceid", sb.toString());
                            jSONObject.put("device_token", aVar.l == null ? "" : aVar.l);
                            jSONObject.put("brand", aVar.m == null ? "" : aVar.m);
                            jSONObject.put("system_version", aVar.j == null ? "" : aVar.j);
                            jSONObject.put("cell", aVar.i == null ? "" : aVar.i);
                            jSONObject.put("aid", com.igexin.push.g.o.h());
                            jSONObject.put("adid", com.igexin.push.g.o.i());
                            jSONObject.put("gtcid", android.text.TextUtils.isEmpty(aVar.o) ? "" : aVar.o);
                            jSONObject.put("oaid", com.igexin.push.core.e.h == null ? "" : com.igexin.push.core.e.h);
                            com.igexin.push.core.ServiceManager.getInstance();
                            java.lang.String strE = com.igexin.push.core.ServiceManager.e(com.igexin.push.core.e.l);
                            if (!com.igexin.push.core.b.ao.equals(strE)) {
                                jSONObject.put(com.igexin.push.g.q.a, strE);
                            }
                            com.igexin.push.core.ServiceManager.getInstance();
                            jSONObject.put(com.igexin.push.g.q.d, com.igexin.push.core.ServiceManager.d(com.igexin.push.core.e.l));
                            jSONObject.put("notification_enabled", com.igexin.push.g.c.b(com.igexin.push.core.e.l) ? 1 : 0);
                            jSONObject.put("installChannel", com.igexin.c.b.a.b(com.igexin.push.core.e.b, "").replaceAll("\\|", ""));
                            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                            jSONObject2.put("action", "addphoneinfo");
                            jSONObject2.put(com.igexin.push.core.b.C, java.lang.String.valueOf(aVar.n));
                            jSONObject2.put("info", jSONObject);
                            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                            jSONObject3.put("guardMe", java.lang.String.valueOf(com.igexin.push.config.e.b()));
                            jSONObject3.put("guardOthers", java.lang.String.valueOf(com.igexin.push.config.e.c()));
                            jSONObject3.put("oneId", com.igexin.push.g.o.t());
                            jSONObject2.put("extra", jSONObject3);
                            java.lang.String string = jSONObject2.toString();
                            com.igexin.c.a.c.a.a("addphoneinfo |  ".concat(java.lang.String.valueOf(string)), new java.lang.Object[0]);
                            com.igexin.push.core.e.e eVarA = com.igexin.push.core.e.e.a();
                            if (eVarA != null) {
                                eVarA.b(new com.igexin.push.core.b.n(j, string, (byte) 5, j));
                            }
                            com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                            bVar.c = 128;
                            bVar.b = (int) j;
                            bVar.e = com.igexin.push.core.b.O;
                            bVar.f = string;
                            bVar.h = com.igexin.push.core.e.A;
                            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                            if (com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I)) {
                                return;
                            }
                            com.igexin.push.core.e.f.a().c(com.igexin.push.core.e.I);
                        } catch (java.lang.Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                }, false, true);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
