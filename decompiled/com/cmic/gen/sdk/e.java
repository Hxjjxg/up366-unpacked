package com.cmic.gen.sdk;

/* JADX INFO: compiled from: BaseRequest.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class e {
    private static com.cmic.gen.sdk.e a;

    private e() {
    }

    public static com.cmic.gen.sdk.e a() {
        if (a == null) {
            synchronized (com.cmic.gen.sdk.e.class) {
                if (a == null) {
                    a = new com.cmic.gen.sdk.e();
                }
            }
        }
        return a;
    }

    public void b(com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.x0 x0Var) {
        com.cmic.gen.sdk.t tVar = new com.cmic.gen.sdk.t();
        tVar.c(iVar.c("appid"));
        tVar.e(com.cmic.gen.sdk.l1.a());
        tVar.d(a("1.0" + iVar.c("traceId") + tVar.a() + tVar.c() + iVar.c("appkey")));
        com.cmic.gen.sdk.s1 s1VarB = iVar.b();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("https://");
        sb.append(s1VarB.h());
        sb.append("/unisdk/getSdkPageOption");
        a(new com.cmic.gen.sdk.x(sb.toString(), tVar, "POST", iVar.c("traceId")), x0Var, iVar);
    }

    public void a(boolean z, com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.x0 x0Var) {
        com.cmic.gen.sdk.p pVar = new com.cmic.gen.sdk.p();
        pVar.i("1.0");
        pVar.d("Android");
        pVar.f(com.cmic.gen.sdk.h1.a("AID", ""));
        pVar.e(z ? "1" : "0");
        pVar.g(com.cmic.gen.sdk.auth.b.SDK_VERSION);
        pVar.c(iVar.c("appid"));
        pVar.h(pVar.b(""));
        a(new com.cmic.gen.sdk.x("https://" + iVar.b().b() + "/client/uniConfig", pVar, "POST", iVar.c("traceId")), x0Var, iVar);
    }

    /* JADX INFO: compiled from: BaseRequest.java */
    class a implements com.cmic.gen.sdk.b0 {
        final /* synthetic */ com.cmic.gen.sdk.x a;
        final /* synthetic */ com.cmic.gen.sdk.i b;
        final /* synthetic */ com.cmic.gen.sdk.x0 c;

        a(com.cmic.gen.sdk.x xVar, com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.x0 x0Var) {
            this.a = xVar;
            this.b = iVar;
            this.c = x0Var;
        }

        @Override // com.cmic.gen.sdk.b0
        public void a(com.cmic.gen.sdk.y yVar) {
            if (this.a.l()) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(yVar.a());
                    java.lang.String string = jSONObject.has("resultcode") ? jSONObject.getString("resultcode") : jSONObject.getString("resultCode");
                    com.cmic.gen.sdk.x1.a(this.b, string);
                    this.c.a(string, jSONObject.optString("desc"), jSONObject);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    a(com.cmic.gen.sdk.v.a(102223));
                }
            }
        }

        @Override // com.cmic.gen.sdk.b0
        public void a(com.cmic.gen.sdk.v vVar) {
            if (this.a.l()) {
                com.cmic.gen.sdk.x1.a(this.b, java.lang.String.valueOf(vVar.a()));
                this.c.a(java.lang.String.valueOf(vVar.a()), vVar.b(), com.cmic.gen.sdk.auth.c.b(java.lang.String.valueOf(vVar.a()), vVar.b()));
            }
        }
    }

    public java.lang.String a(java.lang.String str) {
        com.cmic.gen.sdk.h0.b("BaseRequest", "sha256=" + str);
        try {
            return android.util.Base64.encodeToString(java.security.MessageDigest.getInstance("SHA-256").digest(str.getBytes("UTF-8")), 0).replace("\n", "");
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public void a(com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.x0 x0Var) {
        com.cmic.gen.sdk.x xVar;
        java.lang.String strC;
        com.cmic.gen.sdk.h0.a("BaseRequest", "time+" + java.lang.System.currentTimeMillis());
        com.cmic.gen.sdk.h0.a("BaseRequest", "methodCostTimePre+" + iVar.a("methodCostTimePre", 0L));
        iVar.b("methodChain", iVar.c("methodChain") + ",100006");
        iVar.b("methodCostTime", iVar.c("methodCostTime") + com.igexin.push.core.b.an + (java.lang.System.currentTimeMillis() - iVar.a("methodCostTimePre", 0L)));
        iVar.b("methodCostTimePre", java.lang.System.currentTimeMillis());
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            jSONObject.put("stackInfo", jSONObject2);
            jSONObject2.put("appid", iVar.c("appid"));
            jSONObject2.put("packageName", iVar.c("apppackage"));
            jSONObject2.put("methodCostTime", iVar.c("methodCostTime"));
            jSONObject2.put("pathOfCallingMethod", iVar.c("pathOfCallingMethod"));
            jSONObject.put("methodChain", iVar.c("methodChain"));
            int iB = iVar.b("networktype");
            com.cmic.gen.sdk.e1 e1Var = new com.cmic.gen.sdk.e1();
            e1Var.a(jSONObject);
            e1Var.y("1.0");
            e1Var.s(com.cmic.gen.sdk.auth.b.SDK_VERSION);
            e1Var.w(com.cmic.gen.sdk.auth.b.SDK_VERSION);
            e1Var.d(iVar.c("appid"));
            e1Var.r(iVar.c("operatortype"));
            e1Var.p(iB + "");
            e1Var.l(com.cmic.gen.sdk.j1.b());
            e1Var.m(com.cmic.gen.sdk.j1.c());
            e1Var.n(com.cmic.gen.sdk.j1.a());
            e1Var.g("0");
            e1Var.i("3.1");
            e1Var.o(com.cmic.gen.sdk.x1.a());
            e1Var.x(com.cmic.gen.sdk.l1.a());
            e1Var.e(iVar.c("apppackage"));
            e1Var.f(iVar.c("appsign"));
            e1Var.u(iVar.c("operator"));
            e1Var.q(com.cmic.gen.sdk.h1.a("oaid", ""));
            e1Var.A(com.cmic.gen.sdk.h1.a("AID", ""));
            if (iVar.b("logintype") != 3 && !iVar.a("isRisk", false)) {
                e1Var.B(iVar.c("userCapaid"));
                if (iVar.b("logintype") == 1) {
                    e1Var.B("200");
                } else {
                    e1Var.B("50");
                }
                e1Var.h("authz");
            } else {
                e1Var.h("pre");
            }
            com.cmic.gen.sdk.x1.c(iVar, "scripAndTokenForHttps");
            com.cmic.gen.sdk.s1 s1VarB = iVar.b();
            if (!iVar.a("isCacheScrip", false) && iVar.b("logintype") != 1 && !iVar.a("isGotScrip", false)) {
                com.cmic.gen.sdk.s sVar = new com.cmic.gen.sdk.s();
                sVar.a(iVar.a(com.cmic.gen.sdk.k.a.a));
                sVar.b(iVar.a(com.cmic.gen.sdk.k.a.b));
                sVar.a(e1Var);
                sVar.a(false);
                iVar.b("isCloseIpv4", s1VarB.k());
                iVar.b("isCloseIpv6", s1VarB.l());
                java.lang.String str = "https://" + s1VarB.c() + "/unisdk/rs/scripAndTokenForHttpsBx";
                if (iVar.a("use2048PublicKey", false)) {
                    com.cmic.gen.sdk.h0.b("BaseRequest", "使用2对应的编码");
                    sVar.d("2");
                    strC = com.cmic.gen.sdk.v0.d().a(iVar.a(com.cmic.gen.sdk.k.a.a));
                } else {
                    strC = com.cmic.gen.sdk.v0.d().c(iVar.a(com.cmic.gen.sdk.k.a.a));
                }
                sVar.c(strC);
                xVar = new com.cmic.gen.sdk.w(str, sVar, "POST", iVar.c("traceId"));
                if (iB == 3) {
                    xVar.a(true);
                    iVar.b("doNetworkSwitch", true);
                } else {
                    xVar.a(false);
                    iVar.b("doNetworkSwitch", false);
                }
            } else {
                e1Var.z(iVar.c("phonescrip"));
                e1Var.t(e1Var.b(iVar.c("appkey")));
                xVar = new com.cmic.gen.sdk.x("https://" + s1VarB.d() + "/unisdk/rs/scripAndTokenForHttpsBx", e1Var, "POST", iVar.c("traceId"));
            }
            xVar.a("dnsParseResult", "1");
            xVar.a("interfaceVersion", "3.1");
            a(xVar, x0Var, iVar);
        } catch (org.json.JSONException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public void a(org.json.JSONObject jSONObject, com.cmic.gen.sdk.i iVar, com.cmic.gen.sdk.x0 x0Var) {
        com.cmic.gen.sdk.g0 g0Var = new com.cmic.gen.sdk.g0();
        com.cmic.gen.sdk.g0.a aVar = new com.cmic.gen.sdk.g0.a();
        com.cmic.gen.sdk.g0.b bVar = new com.cmic.gen.sdk.g0.b();
        bVar.d(com.cmic.gen.sdk.x1.a());
        bVar.f(com.cmic.gen.sdk.l1.a());
        bVar.g("2.0");
        bVar.c(iVar.a("appid", ""));
        bVar.e(bVar.b(""));
        aVar.a(jSONObject);
        g0Var.a(aVar);
        g0Var.a(bVar);
        a(new com.cmic.gen.sdk.x("https://" + iVar.b().e() + "/log/logReport", g0Var, "POST", iVar.c("traceId")), x0Var, iVar);
    }

    private void a(com.cmic.gen.sdk.x xVar, com.cmic.gen.sdk.x0 x0Var, com.cmic.gen.sdk.i iVar) {
        com.cmic.gen.sdk.z1 z1Var = new com.cmic.gen.sdk.z1();
        com.cmic.gen.sdk.b1 b1Var = new com.cmic.gen.sdk.b1();
        com.cmic.gen.sdk.j jVar = new com.cmic.gen.sdk.j();
        z1Var.a(b1Var);
        b1Var.a(jVar);
        z1Var.a(xVar, new com.cmic.gen.sdk.e.a(xVar, iVar, x0Var), iVar);
    }
}
