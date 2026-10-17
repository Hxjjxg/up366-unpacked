package com.igexin.push.core;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class k {
    public static final int a = -1;
    public static final int b = 0;
    public static final int c = 1;
    private static final java.lang.String d = "LoginInteractor";
    private static com.igexin.push.core.k e;

    public static com.igexin.push.core.k a() {
        if (e == null) {
            e = new com.igexin.push.core.k();
        }
        return e;
    }

    private static void a(java.util.List<com.igexin.push.d.c.j> list) {
        if (com.igexin.push.core.ServiceManager.getInstance().initType == null) {
            return;
        }
        int iIntValue = ((java.lang.Integer) com.igexin.push.core.ServiceManager.getInstance().initType.first).intValue();
        java.lang.String strValueOf = java.lang.String.valueOf(iIntValue);
        if (iIntValue == 1) {
            strValueOf = strValueOf + "#" + ((java.lang.String) com.igexin.push.core.ServiceManager.getInstance().initType.second);
        }
        com.igexin.push.d.c.j jVar = new com.igexin.push.d.c.j();
        jVar.a = (byte) 5;
        jVar.b = strValueOf;
        list.add(jVar);
    }

    public static int b() {
        if (!com.igexin.push.core.e.s || !com.igexin.push.g.c.a()) {
            com.igexin.c.a.c.a.a(d, "keyNegotiate stop ++++++++++");
            com.igexin.c.a.c.a.a("LoginInteractor|keyNegotiate stop ++++++++++", new java.lang.Object[0]);
            return -1;
        }
        com.igexin.push.d.c.g gVar = new com.igexin.push.d.c.g();
        gVar.b = com.igexin.push.core.e.a;
        int iA = com.igexin.push.core.d.a.a.h.a("K-", gVar, true);
        com.igexin.c.a.c.a.a("LoginInteractor|keyNegotiate result=".concat(java.lang.String.valueOf(iA)), new java.lang.Object[0]);
        return iA < 0 ? 0 : 1;
    }

    public static void c() {
        com.igexin.c.a.c.a.d.a().a("[LoginInteractor] Start login appid = " + com.igexin.push.core.e.a);
        if (com.igexin.push.core.e.t) {
            com.igexin.push.core.e.t = false;
            com.igexin.push.core.e.T = java.lang.System.currentTimeMillis() + (((long) java.lang.Math.abs(new java.util.Random().nextInt() % 24)) * 3600000);
        }
        com.igexin.push.c.c.a().d().d();
        if (com.igexin.push.core.e.z == 0) {
            com.igexin.c.a.c.a.a("registerReq #####", new java.lang.Object[0]);
            com.igexin.push.d.c.d dVar = new com.igexin.push.d.c.d(com.igexin.push.core.e.D, com.igexin.push.core.e.E, com.igexin.push.core.e.L, com.igexin.push.core.e.a);
            java.lang.String str = com.igexin.push.core.e.D;
            java.lang.String str2 = com.igexin.push.core.e.E;
            java.lang.String str3 = com.igexin.push.core.e.L;
            com.igexin.push.e.a aVar = com.igexin.push.core.d.a.a.h;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("R-");
            sb.append(com.igexin.push.core.e.L);
            com.igexin.c.a.c.a.a("registerReq|" + (aVar.a(sb.toString(), dVar, true) >= 0) + "|" + com.igexin.push.core.e.L, new java.lang.Object[0]);
            return;
        }
        long j = com.igexin.push.core.e.z;
        com.igexin.push.d.c.i iVarD = d();
        com.igexin.c.a.c.a.a("loginReqBefore|" + iVarD.b, new java.lang.Object[0]);
        if (com.igexin.push.core.d.a.a.h.a("S-" + com.igexin.push.core.e.z, iVarD, true) < 0) {
            return;
        }
        java.lang.String str4 = com.igexin.push.core.e.A;
        com.igexin.c.a.c.a.a("LoginInteractor|loginReq|" + com.igexin.push.core.e.A, new java.lang.Object[0]);
    }

    public static com.igexin.push.d.c.i d() {
        android.util.Pair<java.lang.String, java.lang.String> pairB;
        android.net.NetworkInfo activeNetworkInfo;
        com.igexin.push.d.c.i iVar = new com.igexin.push.d.c.i();
        iVar.b = com.igexin.push.core.e.z;
        iVar.c = (byte) 0;
        iVar.d = 65280;
        iVar.e = com.igexin.push.core.e.a;
        try {
            java.util.ArrayList<com.igexin.push.d.c.j> arrayList = new java.util.ArrayList();
            int type = -1;
            try {
                android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) com.igexin.push.core.e.l.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                    type = activeNetworkInfo.getType();
                    com.igexin.push.d.c.j jVar = new com.igexin.push.d.c.j();
                    jVar.a = (byte) 2;
                    jVar.b = java.lang.String.valueOf(type);
                    arrayList.add(jVar);
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            if (type == 1 && (pairB = com.igexin.push.g.o.b()) != null) {
                java.lang.String str = (java.lang.String) pairB.first;
                java.lang.String str2 = (java.lang.String) pairB.second;
                if (str != null) {
                    com.igexin.push.d.c.j jVar2 = new com.igexin.push.d.c.j();
                    jVar2.a = (byte) 1;
                    jVar2.b = str;
                    arrayList.add(jVar2);
                }
                if (str2 != null) {
                    com.igexin.push.d.c.j jVar3 = new com.igexin.push.d.c.j();
                    jVar3.a = (byte) 4;
                    jVar3.b = str2;
                    arrayList.add(jVar3);
                }
            }
            java.lang.String strP = com.igexin.push.g.o.p();
            if (!android.text.TextUtils.isEmpty(strP)) {
                java.lang.String[] strArrSplit = strP.split("#");
                if (strArrSplit.length >= 3 && !android.text.TextUtils.isEmpty(strArrSplit[2])) {
                    com.igexin.push.d.c.j jVar4 = new com.igexin.push.d.c.j();
                    jVar4.a = (byte) 6;
                    jVar4.b = strArrSplit[2];
                    arrayList.add(jVar4);
                }
            }
            if (com.igexin.push.config.d.ae) {
                java.lang.String strR = com.igexin.push.g.o.r();
                if (!android.text.TextUtils.isEmpty(strR)) {
                    com.igexin.push.d.c.j jVar5 = new com.igexin.push.d.c.j();
                    jVar5.a = (byte) 7;
                    jVar5.b = strR;
                    arrayList.add(jVar5);
                }
            }
            if (com.igexin.push.core.ServiceManager.getInstance().initType != null) {
                int iIntValue = ((java.lang.Integer) com.igexin.push.core.ServiceManager.getInstance().initType.first).intValue();
                java.lang.String strValueOf = java.lang.String.valueOf(iIntValue);
                if (iIntValue == 1) {
                    strValueOf = strValueOf + "#" + ((java.lang.String) com.igexin.push.core.ServiceManager.getInstance().initType.second);
                }
                com.igexin.push.d.c.j jVar6 = new com.igexin.push.d.c.j();
                jVar6.a = (byte) 5;
                jVar6.b = strValueOf;
                arrayList.add(jVar6);
            }
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (com.igexin.push.d.c.j jVar7 : arrayList) {
                    sb.append((int) jVar7.a);
                    sb.append(":");
                    sb.append((java.lang.String) jVar7.b);
                    sb.append("|");
                }
                com.igexin.c.a.c.a.a("LoginInteractor| ".concat(java.lang.String.valueOf(sb)), new java.lang.Object[0]);
            } catch (java.lang.Throwable th2) {
                com.igexin.c.a.c.a.a(th2);
            }
            if (!arrayList.isEmpty()) {
                iVar.g = arrayList;
            }
        } catch (java.lang.Throwable th3) {
            com.igexin.c.a.c.a.a(th3);
        }
        return iVar;
    }
}
