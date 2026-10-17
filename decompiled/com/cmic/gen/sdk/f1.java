package com.cmic.gen.sdk;

/* JADX INFO: compiled from: SendLog.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class f1 {
    private com.cmic.gen.sdk.i a;

    /* JADX INFO: compiled from: SendLog.java */
    class a implements com.cmic.gen.sdk.x0 {
        a() {
        }

        @Override // com.cmic.gen.sdk.x0
        public void a(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
            com.cmic.gen.sdk.s1 s1VarB = com.cmic.gen.sdk.f1.this.a.b();
            java.util.HashMap map = new java.util.HashMap();
            if (str.equals("103000")) {
                map.put("logFailTimes", 0);
                map.put("logCloseTime", 0L);
            } else if (s1VarB.f() != 0 && s1VarB.g() != 0) {
                int iA = com.cmic.gen.sdk.h1.a("logFailTimes", 0) + 1;
                if (iA >= s1VarB.g()) {
                    map.put("logFailTimes", 0);
                    map.put("logCloseTime", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                } else {
                    map.put("logFailTimes", java.lang.Integer.valueOf(iA));
                }
            }
            com.cmic.gen.sdk.h1.a(map);
        }
    }

    private static void a(com.cmic.gen.sdk.e0 e0Var, com.cmic.gen.sdk.i iVar) {
        if (e0Var == null || iVar == null) {
            return;
        }
        e0Var.f(iVar.a("appid", ""));
        e0Var.g(com.cmic.gen.sdk.j1.b());
        e0Var.l(iVar.a("interfaceType", ""));
        e0Var.j(iVar.a("interfaceCode", ""));
        e0Var.k(iVar.a("interfaceElasped", ""));
        e0Var.z(iVar.c("timeOut"));
        e0Var.A(iVar.c("traceId"));
        e0Var.x(iVar.c("simCardNum"));
        e0Var.p(iVar.c("operatortype"));
        e0Var.q(com.cmic.gen.sdk.j1.c());
        e0Var.r(com.cmic.gen.sdk.j1.a());
        e0Var.n(java.lang.String.valueOf(iVar.a("networktype", 0)));
        e0Var.s(iVar.c("starttime"));
        e0Var.u(iVar.c("endtime"));
        e0Var.h(java.lang.String.valueOf(iVar.a("systemEndTime", 0L) - iVar.a("systemStartTime", 0L)));
        e0Var.i(iVar.c("imsiState"));
        e0Var.c(com.cmic.gen.sdk.h1.a("AID", ""));
        e0Var.y(iVar.c("operatortype"));
        e0Var.w(iVar.c("scripType"));
        e0Var.o(iVar.c("networkTypeByAPI"));
        com.cmic.gen.sdk.h0.b("SendLog", "traceId" + iVar.c("traceId"));
    }

    public void a(android.content.Context context, java.lang.String str, com.cmic.gen.sdk.i iVar) {
        org.json.JSONArray jSONArray;
        java.lang.String str2 = "";
        try {
            com.cmic.gen.sdk.e0 e0VarA = iVar.a();
            java.lang.String strD = com.cmic.gen.sdk.s0.d(context);
            e0VarA.v(str);
            e0VarA.t(iVar.a("loginMethod", ""));
            if (iVar.a("isCacheScrip", false)) {
                e0VarA.m("scrip");
            } else {
                e0VarA.m("pgw");
            }
            e0VarA.d(com.cmic.gen.sdk.s0.a(context));
            if (!android.text.TextUtils.isEmpty(strD)) {
                str2 = strD;
            }
            e0VarA.e(str2);
            a(e0VarA, iVar);
            if (e0VarA.A.size() > 0) {
                jSONArray = new org.json.JSONArray();
                for (java.lang.Throwable th : e0VarA.A) {
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    for (java.lang.StackTraceElement stackTraceElement : th.getStackTrace()) {
                        stringBuffer.append("\n").append(stackTraceElement.toString());
                    }
                    jSONObject.put("message", th.toString());
                    jSONObject.put("stack", stringBuffer.toString());
                    jSONArray.put(jSONObject);
                }
                e0VarA.A.clear();
            } else {
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                e0VarA.a(jSONArray);
            }
            com.cmic.gen.sdk.h0.b("SendLog", "登录日志");
            a(e0VarA.b(), iVar);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    protected void a(org.json.JSONObject jSONObject, com.cmic.gen.sdk.i iVar) {
        this.a = iVar;
        a(jSONObject);
    }

    private void a(org.json.JSONObject jSONObject) {
        com.cmic.gen.sdk.e.a().a(jSONObject, this.a, new com.cmic.gen.sdk.f1.a());
    }
}
